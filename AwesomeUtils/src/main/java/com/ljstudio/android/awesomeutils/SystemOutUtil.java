package com.ljstudio.android.awesomeutils;


public class SystemOutUtil {

//	private final static boolean isRelease = true;
	private final static boolean isRelease = false;
	private final static String APPLICATION_TAG = "LJSTUDIO---->";
	
	
	public static void sysOut(Object object) {
		if (isRelease) {
			// 软件发布
		} else {
			System.out.println(APPLICATION_TAG + object.toString());
		}
	}
	
}
