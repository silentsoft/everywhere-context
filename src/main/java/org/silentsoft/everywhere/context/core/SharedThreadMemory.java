package org.silentsoft.everywhere.context.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.silentsoft.core.data.DataMap;

public class SharedThreadMemory {
	
	private static Map<Long, DataMap> cache = new ConcurrentHashMap<Long, DataMap>();
	
	private static DataMap getDataMap() {
		Long threadId = Thread.currentThread().getId();

		if (cache.containsKey(threadId)) {
			return cache.get(threadId);
		}
		
		DataMap dataMap = new DataMap();
		cache.put(threadId, dataMap);
		
		return dataMap;
	}
	
	public static Object get(String key) {
		return getDataMap().get(key);
	}
	
	public static void put(String key, Object value) {
		getDataMap().put(key, value);
	}
	
	public static boolean contains(String key) {
		return getDataMap().containsKey(key);
	}
	
	public static Object remove(String key) {
		return getDataMap().remove(key);
	}
	
	public static void removeAll() {
		cache.remove(Thread.currentThread().getId());
	}
	
}
