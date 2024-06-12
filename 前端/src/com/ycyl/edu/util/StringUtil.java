package com.ycyl.edu.util;

public class StringUtil {

	/**
	 * 判断String是否为空字符或NULL
	 * 
	 * @author: KAY E-mail：gaochangkai@21cn.com
	 * @version: Created on 上午11:39:41 2015-3-17 
	 * @see com.ycyl.edu.util.StringUtil.java#isEmpyOrNull()  
	 *
	 * @param obj
	 * @return
	 */
	public static Boolean isEmpyOrNull(String str){
		if("".equals(str) || str == null || "null".equals(str)){
			return true;
		}
		return false;
	}
}
