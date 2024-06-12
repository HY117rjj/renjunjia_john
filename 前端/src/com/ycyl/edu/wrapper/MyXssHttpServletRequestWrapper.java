package com.ycyl.edu.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @Copyright: Copyright (c) 2014
 *
 * @ClassName: MyXssHttpServletRequestWrapper 
 * @Description: TODO
 * @author KAY E-mail: gaochangkai@21cn.com
 * @version Created on: 10:42:22 AM Apr 26, 2020 
 * @see com.ycyl.edu.wrapper.MyXssHttpServletRequestWrapper.java
 *
 */
public class MyXssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	/**
	 * Constructs a request object wrapping the given request.
	 * 
	 * @param request
	 *            The request to wrap
	 * @throws IllegalArgumentException
	 *            if the request is null
	 */
	public MyXssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String parameter = super.getParameter(name);
		if (StringUtils.isNotBlank(parameter)) {
			// 这里使用的阿帕奇的common-lang3中的转义HTML方法，也可以自己实现,
			String escapeParameter = StringEscapeUtils.escapeHtml(parameter);
			
			System.out.println(escapeParameter);
			return escapeParameter;
		}
		return null;
	}
	
}
