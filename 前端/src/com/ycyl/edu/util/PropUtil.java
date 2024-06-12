package com.ycyl.edu.util;

import java.util.ResourceBundle;

public class PropUtil {

	public PropUtil() {

	}

	public static String getProperties(String name){
		ResourceBundle prop = ResourceBundle.getBundle("jdbc");
		return prop.getString(name);
	}
}
