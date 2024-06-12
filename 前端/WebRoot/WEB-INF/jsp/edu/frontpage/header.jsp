<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html class="no-js">
<head>
	<base href="<%=basePath%>">
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="课程实训系统" />
    <meta name="description" content="北京交通大学涉密信息系统工程课程实训系统" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>课程实训系统</title>

    <!--360 browser -->
    <meta name="renderer" content="webkit">
    <meta name="author" content="wos">
    <!-- Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/i/app.png">
    <!--Safari on iOS -->
    <!--Session ChuanDi Bu Guoqu-->
    <!--
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
     -->
    <meta name="apple-mobile-web-app-title" content="课程实训系统" />
    <link rel="apple-touch-icon-precomposed" href="images/i/edu.png">
    <!--Win8 or 10 -->
    <meta name="msapplication-TileImage" content="images/i/app.png">
    <meta name="msapplication-TileColor" content="#e1652f">

    <link rel="icon" type="image/png" href="images/i/favicon.png">
    <link rel="stylesheet" href="assets/css/amazeui.css">
    <link rel="stylesheet" href="css/public.css">
    <style type="text/css">
	    .am-live a {
		  	display: inline-block;
		  	text-decoration: none;
		}
	    .am-live-fixed {
			position: fixed;
		  	right: 10px;
		  	top: 200px;
		  	z-index: 1010;
		  	opacity: 0;
		  	width: 32px;
		  	min-height: 32px;
		  	overflow: hidden;
		  	border-radius: 0;
		  	text-align: center;
		  	opacity: .9;
		  	
		    line-height: 32px;
		    background-color: #555555;
		    vertical-align: middle;
		    color: #ddd;
		    border-radius:15px;<!--调节圆周程度-->
		}
		
		.am-live-fixed a {
		  	display: block;
		}
		
		.am-live-2 a {
		  	display: inline-block;
		  	text-decoration: none;
		}
	    .am-live-fixed-2 {
			position: fixed;
		  	right: 10px;
		  	top: 380px;
		  	z-index: 1010;
		  	opacity: 0;
		  	width: 32px;
		  	min-height: 32px;
		  	overflow: hidden;
		  	border-radius: 0;
		  	text-align: center;
		  	opacity: .9;
		  	
		    line-height: 32px;
		    background-color: #555555;
		    vertical-align: middle;
		    color: #ddd;
		    border-radius:15px;<!--调节圆周程度-->
		}
    </style>

    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="assets/js/jquery.min.js"></script>
    <!--<![endif]-->
    <!--[if lte IE 8 ]>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="assets/js/amazeui.ie8polyfill.min.js"></script>
    <![endif]-->
    <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script> 
    <script src="assets/js/amazeui.min.js"></script>
    <script src="js/public.js"></script>
</head>
<body>

<header class="am-topbar am-topbar-fixed-top wos-header">
    <div class="am-container">
        <h1 class="am-topbar-brand">
            <a href="<%=basePath%>"><img src="images/logo.png" alt=""></a>
        </h1>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-warning am-show-sm-only"
                data-am-collapse="{target: '#collapse-head'}">
            <span class="am-sr-only">导航切换</span>
            <span class="am-icon-bars"></span>
        </button>

        <div class="am-collapse am-topbar-collapse" id="collapse-head">
            <ul class="am-nav am-nav-pills am-topbar-nav">
                <li class="am-active"><a href="<%=basePath%>">首页</a></li>
                <li><a href="javascript:void(0);">用户管理</a></li>
                <li><a href="javascript:void(0);">教学文档管理</a></li>
                <li><a href="javascript:void(0);">实训操作模块</a></li>
                <li><a href="javascript:void(0);">案例分析模块</a></li>
                <li><a href="./systemlogin.do">系统管理</a></li>
            </ul>
            <c:if test="${not empty user.name }">
            <li class="am-dropdown am-topbar-right" data-am-dropdown>
	          <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:void(0);">
	            </span> ${user.name } <span class="am-icon-caret-down"></span>
	          </a>
	          <ul class="am-dropdown-content am-list-item-text">
	            <li><a href="./student/editPersonalDataFP.do?id=${user.id }"><span class="am-icon-user"></span> 资料</a></li>
	            <li><a href="./student/editPersonalDataFP.do?id=${user.id }"><span class="am-icon-cog"></span> 设置</a></li>
	            <li><a href="./logout.do"><span class="am-icon-power-off"></span> 退出</a></li>
	          </ul>
	        </li>
            </c:if>
            <c:if test="${empty user.name }">
            <div class="am-topbar-right">
                <a type="button" href="./student/editPersonalDataRegister.do" class="am-btn am-btn-default am-topbar-btn am-btn-sm"><span class="am-icon-pencil"></span> 注册</a>
            </div>

            <div class="am-topbar-right">
                <a type="button" href="./systemlogin.do" class="am-btn am-btn-danger am-topbar-btn am-btn-sm"><span class="am-icon-user"></span> 登录</a>
            </div>
            </c:if>
        </div>
    </div>
</header>
</body>
</html>