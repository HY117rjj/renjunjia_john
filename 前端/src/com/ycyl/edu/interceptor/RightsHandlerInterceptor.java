package com.ycyl.edu.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ycyl.edu.bean.SessionInfo;

public class RightsHandlerInterceptor extends HandlerInterceptorAdapter {
	
	private List<String> excludeUrls;// 不需要拦截的资源

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
   	
	private final String LOGIN_PAGE="/systemlogin.do";
	public static long access_num = 0;
	public static Map<String,Long> IPMap = new HashMap<String,Long>();
	public static Map<String,Long> urlMap = new HashMap<String,Long>();	
	private final static Logger logger = LoggerFactory.getLogger(RightsHandlerInterceptor.class); 
	
	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length()+1);//去掉前面的/字符
		HttpSession session = request.getSession(false);
		
		/*************************<welcome-file>/index.do</welcome-file>*****************************/
		if("".equals(url)){
			response.sendRedirect("/edu/systemlogin.do");
		}
		
		if ((session != null) && (!"".equals(session))) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
			
			//判断是否包含在菜单权限里
	        System.out.println("访问地址:"+url);
	        
			if ((url.indexOf("login") > -1) || excludeUrls.contains("/"+url)) {// 如果要访问的资源是不需要验证的
				return true;
			}
			
			if ((sessionInfo == null) || (sessionInfo.getId() == null)) {// 如果没有登录或登录超时
				if(url.contains("logout"))
				return true;	
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<script language='javaScript'>alert('您尚未登录或是您的会话已过期，请重新登录!');"
					+ "window.top.location.href='" + contextPath + LOGIN_PAGE+ "';" + "</script>");		    	  
			    return false;				
			}
			
			if (sessionInfo.getResourceAllList().contains("/"+url)){
				if (!sessionInfo.getResourceList().contains("/"+url)) {// 如果当前用户没有访问此资源的权限
					response.setContentType("text/html;charset=utf-8");
			    	response.getWriter().write("<script language='javaScript'>alert('您没有访问此资源的权限！');" 
			    		+ "window.top.location.href='" + contextPath + LOGIN_PAGE+ "';" + "</script>");			
					
					return false;
				}
				return true;
			}
		} else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script language='javaScript'>alert('您尚未登录或是您的会话已过期，请重新登录!');window.top.location.href='"
				+ contextPath + "';" + "</script>");
			return false;
		}
		logger.debug("Interceptor Start");
		return true; 
		
   }	


}
