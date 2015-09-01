package org.silentsoft.everywhere.context.core;

import org.silentsoft.core.data.DataMap;

public final class SharedMemory {

	private static DataMap dataMap = new DataMap();

	public static synchronized DataMap getDataMap() {
		return dataMap;
	}
	
	public static synchronized void setDataMap(DataMap target) {
		dataMap = target;
	}
}
