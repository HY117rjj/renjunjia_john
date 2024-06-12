package com.ycyl.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.ycyl.edu.wrapper.MyXssHttpServletRequestWrapper;

/**
 * @Copyright: Copyright (c) 2014
 *
 * @ClassName: MyXssFilter 
 * @Description: TODO
 * @author KAY E-mail: gaochangkai@21cn.com
 * @version Created on: 10:43:05 AM Apr 26, 2020 
 * @see com.ycyl.edu.filter.MyXssFilter.java
 *
 */
@Component
@WebFilter(urlPatterns = { "/*" }, filterName = "xssFilter")
public class MyXssFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		MyXssHttpServletRequestWrapper requestWrapper = new MyXssHttpServletRequestWrapper((HttpServletRequest) request);
		chain.doFilter(requestWrapper, response);
	}

	@Override
	public void destroy() {

	}
}
