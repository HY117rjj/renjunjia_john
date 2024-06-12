package com.ycyl.edu.util;

import java.util.List;
import java.util.Set;

/**
 * @Title:中联佳裕科技（北京） DRIVER 1.0
 * @Copyright: Copyright (c) 2011
 * @Company: 中联佳裕科技（北京）有限公司
 *
 * @ClassName: ValueCheck 
 * @Description: 该类用来对字符串，数组，集合，基本数据类型的验证
 * @author KAY E-mail: gaochangkai@21cn.com
 * @version Created on: 下午02:44:59 2015-7-6 
 * @see com.ycyl.edu.util.ValueCheck.java
 *
 */

public class ValueCheck {

	/**
	 * 判读字符串是否为空，如果为空则返回true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		boolean flag = false;
		if (null == str || "".equals(str.trim())
				|| "null".equals(str.toLowerCase())) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判读Integer是否为空或0，如果为空则返回true
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrZero(Integer value) {
		boolean flag = false;
		if (null == value || 0 == value) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判读Object是否为空，如果为空则返回true
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isNullObject(Object object) {
		boolean flag = false;
		if (null == object) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断两个非空字符串是否相等
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isEqualString(String str1, String str2) {
		boolean flag = false;
		if (ValueCheck.isNullOrEmpty(str1)) {
			return flag;
		} else {
			if (str1.equals(str2) || str1 == str2) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 判断两个对象是否相等，不管是否为空
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static boolean isEqualObject(Object obj1, Object obj2) {
		boolean flag = false;
		if (obj1 == obj2) {
			flag = true;
		} else if (String.valueOf(obj1).trim() == String.valueOf(obj2).trim()
				|| String.valueOf(obj1).trim().equals(
						String.valueOf(obj2).trim())) {
			flag = true;
		} else {
			if (null == obj1) {
				if ("" == String.valueOf(obj2).trim()
						|| "".equals(String.valueOf(obj2).trim())) {
					flag = true;
				}
			}
			if (null == obj2) {
				if ("" == String.valueOf(obj1).trim()
						|| "".equals(String.valueOf(obj1).trim())) {
					flag = true;
				}
			}
		}

		return flag;
	}

	/**
	 * 判断数组是否为空或长度为0
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNullArrayOrLenZero(Object[] obj) {
		boolean flag = false;
		if (null == obj || 0 == obj.length) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断集合是否为空或长度为0
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("all")
	public static boolean isNullListOrSizeZero(List list) {
		boolean flag = false;
		if (null == list || 0 == list.size()) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断集合是否为空或长度为0
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("all")
	public static boolean isNullSetOrSizeZero(Set set) {
		boolean flag = false;
		if (null == set || 0 == set.size()) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断字符串中是否包含另一个字符串
	 * 
	 * @param str
	 * @param rep
	 * @return
	 */
	public static boolean isIndexOf(String str, String rep) {
		boolean flag = false;
		if (!ValueCheck.isNullOrEmpty(str) && !ValueCheck.isNullOrEmpty(rep) && str.indexOf(rep) >= 0) {
			flag = true;
		}
		return flag;
	}
}
