package com.ycyl.edu.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Title:中联佳裕科技（北京） DRIVER 1.0
 * @Copyright: Copyright (c) 2011
 * @Company: 中联佳裕科技（北京）有限公司
 *
 * @ClassName: ValueConvert 
 * @Description: 数据类型转换类 数据初始化类
 * @author KAY E-mail: gaochangkai@21cn.com
 * @version Created on: 上午10:03:26 2015-7-6 
 * @see com.ycyl.edu.util.ValueConvert.java
 *
 */
public class ValueConvert {

	/**
	 * 将Integer类型的数据转换成boolean 只要Integer>0,则返回true，Integer <= 0则为false
	 * 
	 * @param value
	 * @return
	 */
	public static boolean convertIntegerToBoolean(Integer value) {
		boolean flag = false;
		if (value > 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 将Integer初始化，如果Integer为Null的话 如果不为Null,则直接返回。
	 * 
	 * @param value
	 * @return
	 */
	public static Integer initNullInteger(Integer value) {
		if (null == value) {
			return new Integer(0);
		} else {
			return value;
		}
	}

	/**
	 * 将字符串转成时间Date对象,格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param value
	 * @param flag
	 * @return
	 */
	public static Date convertStringToDate(String value, boolean flag)
			throws Exception {
		SimpleDateFormat sdf = null;
		Date date = null;
		try {
			if (!ValueCheck.isNullOrEmpty(value)) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				date = sdf.parse(value);
			} else {
				// 新建一个Date
				if (flag) {
					date = new Date();
				}
			}

		} catch (ParseException e) {
			throw e;
		}
		return date;
	}

	/**
	 * 将字符串转成时间Timestamp对象,格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param value
	 * @param flag
	 * @return
	 */
	public static Timestamp convertStringToTimestamp(String value, boolean flag)
			throws Exception {
		SimpleDateFormat sdf = null;
		Timestamp timestamp = null;
		try {
			if (!ValueCheck.isNullOrEmpty(value)) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = sdf.parse(value);
				String time = sdf.format(date);
				timestamp = Timestamp.valueOf(time);
			} else {
				// 新建一个Date
				if (flag) {
					timestamp = new Timestamp(new Date().getTime());
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return timestamp;
	}

	/**
	 * 将时间Timestamp对象转成String,格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param value
	 * @param flag
	 * @return
	 */
	public static String convertTimestampToString(Timestamp ts, boolean flag)
			throws Exception {
		SimpleDateFormat sdf = null;
		String time = null;
		try {
			if (null != ts) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				time = sdf.format(ts);
			} else {
				// 新建一个Date
				if (flag) {
					Timestamp timestamp = new Timestamp(new Date().getTime());
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					time = sdf.format(timestamp);
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return time;
	}

	/**
	 * 将时间Date对象转成String,格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param value
	 * @param flag
	 * @return
	 */
	public static String convertDateToString(Date date, boolean flag)
			throws Exception {
		SimpleDateFormat sdf = null;
		String time = null;
		try {
			if (null != date) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				time = sdf.format(date);
			} else {
				// 新建一个Date
				if (flag) {
					Date now = new Date();
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					time = sdf.format(now);
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return time;
	}

	/**
	 * 将util.Date转成时间Timestamp对象,格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param value
	 * @param flag
	 * @return
	 */
	public static Timestamp convertDateToTimestamp(Date date, boolean flag)
			throws Exception {
		SimpleDateFormat sdf = null;
		Timestamp timestamp = null;
		try {
			if (!ValueCheck.isNullObject(date)) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(date);
				timestamp = Timestamp.valueOf(time);
			} else {
				// 新建一个Date
				if (flag) {
					timestamp = new Timestamp(new Date().getTime());
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return timestamp;
	}

	/**
	 * 将util.Set转成util.List集合
	 * 
	 * @param sets
	 * @return
	 * @throws RuntimeException
	 */
	@SuppressWarnings("all")
	public static List convertSetToList(Set sets) throws RuntimeException {
		List list = null;
		try {
			if (null != sets && sets.size() > 0) {
				list = new ArrayList();
				Iterator its = sets.iterator();
				while (its.hasNext()) {
					list.add(its.next());
				}
			}
		} catch (RuntimeException e) {
			throw e;
		}

		return list;
	}

}
