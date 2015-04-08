package org.silentsoft.everywhere.context;

import java.io.File;

public class BizConst {
	public static final int SIZE_EMPTY = 0;
	
	public static final String PATH_META = File.separator + "conf" + File.separator + "META.ini";
	
	public static final String INI_SECTION_SERVER = "SERVER";
	public static final String INI_SERVER_URI = "URI";
	public static final String INI_SERVER_ROOT = "ROOT";
	
	public static final String EVENT_VIEW_REGISTER = "EVENT_VIEW_REGISTER";
	public static final String EVENT_VIEW_LOGIN = "EVENT_VIEW_LOGIN";
}
