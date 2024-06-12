package com.ycyl.edu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Copyright: Copyright (c) 2014
 *
 * @ClassName: HttpHostFilter 
 * @Description: TODO
 * @author KAY E-mail: gaochangkai@21cn.com
 * @version Created on: 9:41:18 AM May 15, 2020 
 * @see com.ycyl.edu.filter.HttpHostFilter.java
 *
 */
@SuppressWarnings("all")
@Component
@WebFilter(urlPatterns = { "/*" }, filterName = "HttpHostFilter" , dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class HttpHostFilter extends HttpServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        // 头攻击检测  过滤主机名
        String requestHost = request.getHeader("host");
        System.out.println("主机名：" + requestHost);
        if (requestHost != null && !checkBlankList(requestHost)) {
            response.setStatus(403);
            return;
        }
        filterChain.doFilter(request, response);
    }

    //判断主机是否存在白名单中
    private boolean checkBlankList(String host){
        if(host.contains("127.0.0.1")){//此处为自己网站的主机地址
            return true;
        }
        if(host.contains("11.0.0.66")){//此处为自己网站的主机地址
            return true;
        }
        if(host.contains("10.88.13.41")){//此处为自己网站的主机地址
            return true;
        }
        if(host.contains("11.12.152.58")){//此处为自己网站的主机地址
            return true;
        }
        if(host.contains("telemedicine.net.cn")){//此处为自己网站的主机地址
            return true;
        }
        return true;
    }
}
