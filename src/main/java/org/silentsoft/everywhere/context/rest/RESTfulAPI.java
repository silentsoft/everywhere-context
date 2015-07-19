package org.silentsoft.everywhere.context.rest;

import java.io.File;

import org.silentsoft.everywhere.context.BizConst;
import org.silentsoft.everywhere.context.http.HttpClientManager;
import org.silentsoft.everywhere.context.host.EverywhereException;
import org.silentsoft.core.util.INIUtil;

public class RESTfulAPI {
	
	private static String uri;

	private static String root;
	
	private static INIUtil META;
	
	static {
		META = new INIUtil(System.getProperty("user.dir") + File.separator + BizConst.PATH_META);
		uri = META.getData(BizConst.INI_SECTION_SERVER, BizConst.INI_SERVER_URI);
		root = META.getData(BizConst.INI_SECTION_SERVER, BizConst.INI_SERVER_ROOT);
	}
	
	private static String getURI(String api) {
		return uri + root + api;
	}
	
	public static void doGet(String api) throws EverywhereException {
		doGet(api, null);
	}
	
	public static <T> T doGet(String api, Class<T> returnType) throws EverywhereException {
		return HttpClientManager.doGet(getURI(api), returnType);
	}
	
	public static void doPost(String api, Object param) throws EverywhereException {
		doPost(api, param, null);
	}
	
	public static <T> T doPost(String api, Object param, Class<T> returnType) throws EverywhereException {
		return HttpClientManager.doPost(getURI(api), param, returnType);
	}
	
	public static void doMultipart(String api, Object param) throws EverywhereException {
		doMultipart(api, param, null);
	}
	
	public static <T> T doMultipart(String api, Object param, Class<T> returnType) throws EverywhereException {
		return HttpClientManager.doMultipart(getURI(api), param, returnType);
	}
}
