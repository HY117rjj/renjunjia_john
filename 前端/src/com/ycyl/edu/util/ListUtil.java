package com.ycyl.edu.util;

import java.util.List;

public class ListUtil {
	
	/**
	 * 判断List是否为null或size为0
	 * 
	 * @author: KAY E-mail：gaochangkai@21cn.com
	 * @version: Created on 下午03:53:32 2015-4-7 
	 * @see com.ycyl.edu.util.ListUtil.java#isNullOrSizeZero()  
	 *
	 * @param list
	 * @return
	 */
	public static Boolean isNullOrSizeZero(List<?> list){
		if(list != null && list.size() > 0 && list.get(0) != null){
			return false;
		}
		return true;
	}
}
