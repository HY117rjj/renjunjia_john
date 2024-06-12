package com.ycyl.edu.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class MyExceptionResolver implements HandlerExceptionResolver{
	//定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(MyExceptionResolver.class); 
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		System.out.println("==============异常开始=============");
		ex.printStackTrace();
		logger.error(ex.toString());
		System.out.println("==============异常结束=============");
		ModelAndView mv = new ModelAndView("error/error");
		mv.addObject("title", "出错了");
		mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
		return mv;
	}

	/** Default constructor */
	public MyExceptionResolver() {
	}

}
