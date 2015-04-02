package org.silentsoft.everywhere.context.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.silentsoft.everywhere.context.host.EverywhereException;
import org.silentsoft.core.util.JSONUtil;

public class HttpClientManager {
	private static enum RequestType {
		GET,
		POST
	};
	
	public static <T> T doGet(String uri, Class<T> returnType) throws EverywhereException {
		return doAction(uri, null, returnType, RequestType.GET);
	}
	
	public static <T> T doPost(String uri, Object param, Class<T> returnType) throws EverywhereException {
		return doAction(uri, param, returnType, RequestType.POST);
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
					httpResponse = HttpClientFactory.getHttpClient().execute(httpGet);
					break;
				}
				case POST:
				{
					httpPost = new HttpPost(uri);
					httpPost.setEntity(new StringEntity(JSONUtil.ObjectToString(param)));
					httpResponse = HttpClientFactory.getHttpClient().execute(httpPost);
					break;
				}
			}
			
			httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				BufferedReader br = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
				
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line=br.readLine()) != null) {
					result.append(line);
				}
				
				if (result.toString().length() > 0) {
					returnValue = (T)JSONUtil.JSONToObject(result.toString(), returnType);
				}
				
				if (br != null) {
					br.close();
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
}
