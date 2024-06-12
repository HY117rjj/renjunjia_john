package com.ycyl.edu.util;

import java.io.IOException;

import java.io.Reader;

import java.io.Serializable;

import java.io.StringReader;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import org.hibernate.usertype.UserType;

public class CustomOrcalLong implements UserType {

	public CustomOrcalLong() {

	}

	// 序列化

	public Object assemble(Serializable ser, Object obj)

	throws HibernateException {

		// TODO Auto-generated method stub

		return null;

	}

	// 深度拷贝，强制返回字符串

	public Object deepCopy(Object value) throws HibernateException {

		// TODO Auto-generated method stub

		if (null == value)

			return "";

		else

			return new String((String) value);

	}

	// 反序列化

	public Serializable disassemble(Object arg0) throws HibernateException {

		// TODO Auto-generated method stub

		return null;

	}

	// 判断是否相等

	public boolean equals(Object x, Object y) throws HibernateException {

		// TODO Auto-generated method stub

		return (x == y) || (x != null && y != null && (x.equals(y)));

	}

	// 获取哈希码

	public int hashCode(Object arg0) throws HibernateException {

		// TODO Auto-generated method stub

		return 0;

	}

	// 是否可变

	public boolean isMutable() {

		// TODO Auto-generated method stub

		return false;

	}

	// 获取字段值

	public Object nullSafeGet(ResultSet rs, String[] name, Object obj)

	throws HibernateException, SQLException {

		// TODO Auto-generated method stub

		char[] content = new char[1024000];// 第一字符数组保存流读出的内容

		char[] buffer = new char[1024];// 存放每次读的内容

		int len = 0;

		int off = 0;

		int contentLen = 1024000;

		Reader reader = rs.getCharacterStream(name[0]);// ResultSet结果集中读字符流的方法

		// 下面是基本的字符流的方法

		try {

			while (true) {

				len = reader.read(buffer);

				if (len == -1)

					break;

				if (off + len > contentLen) {// 代表字段的内容超出了我们预定义的内容的大小，需要扩充

					char[] tmp = new char[contentLen + 1024000];// 定义扩充区

					System.arraycopy(content, 0, tmp, 0, off);// 将content拷贝到扩充区中，扩充

					content = tmp;

					contentLen = contentLen + 1024000;// 长度扩充

				}

				System.arraycopy(buffer, 0, content, off, len);// 最后将每次读的都拷贝到content中

				off += len;// 记录读的位置长度

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

		return new String(content, 0, off);

	}

	public void nullSafeSet(PreparedStatement pr, Object value, int index)

	throws HibernateException, SQLException {

		// TODO Auto-generated method stub

		String s = (String) value;

		System.out.println(s);

		if (null == s)

			s = "";

		Reader re = new StringReader(s);// 将内容字符串用StringReader读入

		pr.setCharacterStream(index, re, s.length());// 最后用PreparedStatement的方法设置字段内容

	}

	public Object replace(Object arg0, Object arg1, Object arg2)

	throws HibernateException {

		// TODO Auto-generated method stub

		return null;

	}

	@SuppressWarnings("all")
	public Class returnedClass() {// 返回java类型

		// TODO Auto-generated method stub

		return java.lang.String.class;

	}

	public int[] sqlTypes() {// 返回sql属性类型

		// TODO Auto-generated method stub

		return new int[] { java.sql.Types.LONGVARCHAR };

	}

}