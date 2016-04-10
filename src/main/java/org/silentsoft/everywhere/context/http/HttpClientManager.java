package org.silentsoft.everywhere.context.http;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.silentsoft.core.item.StoreItem;
import org.silentsoft.core.pojo.FilePOJO;
import org.silentsoft.core.util.JSONUtil;
import org.silentsoft.core.util.ObjectUtil;
import org.silentsoft.everywhere.context.BizConst;
import org.silentsoft.everywhere.context.host.EverywhereException;
import org.silentsoft.everywhere.context.util.SecurityUtil;
import org.silentsoft.io.memory.SharedMemory;

public class HttpClientManager {
	private static enum RequestType {
		GET,
		POST,
		MULTIPART
	};
	
	static {
		/**
		 * WARNING : DO NOT REMOVE BELOW CODE ! THIS IS VERY IMPORTANT FOR PERFORMANCE !!!
		 */
		Logger.getLogger("org.apache.http").setLevel(Level.OFF);
	}
	
	public static <T> T doGet(String uri, Class<T> returnType) throws EverywhereException {
		return doAction(uri, null, returnType, RequestType.GET);
	}
	
	public static <T> T doPost(String uri, Object param, Class<T> returnType) throws EverywhereException {
		return doAction(uri, param, returnType, RequestType.POST);
	}
	
	public static <T> T doMultipart(String uri, Object param, Class<T> returnType) throws EverywhereException {
		return doAction(uri, param, returnType, RequestType.MULTIPART);
	}
	
	private static <T> T doAction(String uri, Object param, Class<T> returnType, RequestType requestType) throws EverywhereException {
		T returnValue = null;
		
		HttpGet httpGet = null;
		HttpPost httpPost = null;
		HttpEntity httpEntity = null;
		CloseableHttpResponse httpResponse = null;
		
		try {
			switch (requestType) {
				case GET:
				{
					httpGet = new HttpGet(uri);
					
					httpResponse = execute(httpGet);
					break;
				}
				case POST:
				{
					httpPost = new HttpPost(uri);
					
					if (param != null) {
						StringEntity stringEntity = new StringEntity(JSONUtil.ObjectToString(param), Charset.forName("UTF-8"));
						stringEntity.setContentType("application/json; charset=UTF-8");
						
						httpPost.setEntity(stringEntity);
					}
					
					httpResponse = execute(httpPost);
					break;
				}
				case MULTIPART:
				{
					MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().setCharset(Charset.forName("UTF-8"));
					
					if (param instanceof StoreItem) {
						StoreItem storeItem = (StoreItem) param;
						
						for (FilePOJO filePOJO : storeItem) {
							if (filePOJO.getFile() != null) {
								multipartEntityBuilder.addBinaryBody("binary", filePOJO.getFile(), ContentType.APPLICATION_OCTET_STREAM, filePOJO.getNameWithExtension());
							}
							
							filePOJO.setFile(null);
							filePOJO.setBytes(null);
						}
						
						multipartEntityBuilder.addTextBody("json", JSONUtil.ObjectToString(storeItem), ContentType.APPLICATION_JSON);
					} else {
						return null;
					}
					
					httpPost = new HttpPost(uri);
					httpPost.setEntity(multipartEntityBuilder.build());
					
					httpResponse = execute(httpPost);
					break;
				}
			}
			
			httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				String body = EntityUtils.toString(httpEntity, Charset.forName("UTF-8"));
				if (body.length() > 0) {
					returnValue = (T)JSONUtil.JSONToObject(body, returnType);
				}
			}
			
			EntityUtils.consume(httpEntity);
		} catch (Exception e) {
			throw new EverywhereException("Failed connection to <{}> !", new Object[]{uri, e});
		} finally {			
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (IOException ioe) {
					throw new EverywhereException("Failed close to http response !", new Object[]{ioe});
				}
			}
		}
		
		return returnValue;
	}
	
	private static CloseableHttpResponse execute(HttpUriRequest request) throws IOException, ClientProtocolException {
		String userId = ObjectUtil.toString(SharedMemory.getDataMap().get(BizConst.KEY_USER_ID));
		if (ObjectUtil.isNotEmpty(userId)) {
			request.addHeader("user", userId);
			request.addHeader("sequence", SecurityUtil.encodePassword(userId));
		}
		
		return HttpClientFactory.getHttpClient().execute(request);
	}
}
