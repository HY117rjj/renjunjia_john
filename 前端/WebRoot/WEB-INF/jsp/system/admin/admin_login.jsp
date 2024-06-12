<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js fixed-layout">
  <head lang="en">
    <base href="<%=basePath%>">
    
    <title>课程实训系统登录</title>
    
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<meta name="format-detection" content="telephone=no">
  	<meta name="renderer" content="webkit">
  	<meta http-equiv="Cache-Control" content="no-siteapp" />
  	<!--Safari on iOS -->
  	<link rel="apple-touch-icon" href="assets/i/favicon.png">
  	<link rel="icon" sizes="192x192" href="images/i/app.png">
    <meta name="apple-mobile-web-app-title" content="课程实训系统" />
    <link rel="apple-touch-icon-precomposed" href="images/i/edu.png">
  	<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/amazeui.min.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
  </style>
  </head>
<body>
<div class="header">
  <div class="am-g">
    <h1>课程实训系统</h1>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-topbar-right">
  	<a type="button" href="./student/editPersonalDataRegister.do" class="am-btn am-btn-default am-topbar-btn am-btn-sm"><span class="am-icon-pencil"></span> 注册</a>
  </div>
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">

    <form method="post" class="am-form" action="./systemLoading.do">
      <label for="user">登录名:</label>
      <input type="text" name="user" id="user" value="" placeholder="输入用户名" class="am-form-field" required>
      <br>
      <label for="password">密码:</label>
      <input type="password" name="password" id="password" placeholder="输入密码" value="">
      <br>
      <c:if test="${loginFailure eq '1'}">
      <div class="am-alert am-alert-danger" data-am-alert>
		  <button type="button" class="am-close">&times;</button>
		  <p>${msg.message }</p>
	  </div>
	  </c:if>
	  <div id="amuial"></div>
	  
      <label for="remember-me">
        <input id="remember-me" type="checkbox">
		记住密码
      </label>
      
      <br />
      <div class="am-cf">
        <input type="submit" name="landing" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
        <input type="button" name="forget" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
      </div>
      
      <input type="hidden" name="admin" id="admin" value="1">
    </form>
    <hr>
    <p>Copyright (C) 2024 www.bjtu.edu.cn, All Rights Reserved.</p>
  </div>
</div>

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>
