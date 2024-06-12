<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html class="no-js">
<head>
	<base href="<%=basePath%>">
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="课程实训系统" />
    <meta name="description" content="北京交通大学涉密信息系统工程课程实训系统" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>北京交通大学涉密信息系统工程课程实训系统</title>

    <!--360 browser -->
    <meta name="renderer" content="webkit">
    <meta name="author" content="wos">
    <!-- Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/i/app.png">
    
    <meta name="apple-mobile-web-app-title" content="课程实训系统" />
    <link rel="apple-touch-icon-precomposed" href="images/i/edu.png">
    <!--Win8 or 10 -->
    <meta name="msapplication-TileImage" content="images/i/app.png">
    <meta name="msapplication-TileColor" content="#e1652f">

    <link rel="icon" type="image/png" href="images/i/favicon.png">
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/amazeui.page.css">
    <link rel="stylesheet" href="assets/css/amazeui.css">
    <link rel="stylesheet" href="assets/css/admin.modify.css">
    <link rel="stylesheet" href="css/public.css">

    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="assets/js/jquery.min.js"></script>
    <!--<![endif]-->
    <!--[if lte IE 8 ]>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="assets/js/amazeui.ie8polyfill.min.js"></script>
    <![endif]-->
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/amazeui.page.js"></script>
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
                <a type="button" href="function:void(0);" class="am-btn am-btn-default am-topbar-btn am-btn-sm"><span class="am-icon-pencil"></span> 注册</a>
            </div>

            <div class="am-topbar-right">
                <a type="button" href="./login.do" class="am-btn am-btn-danger am-topbar-btn am-btn-sm"><span class="am-icon-user"></span> 登录</a>
            </div>
            </c:if>
        </div>
    </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list" id="collapase-nav-1">
        <li><a href="<%=basePath%>"><span class="am-icon-home am-active"></span> 首页</a></li>
        <li><a href="./student/editPersonalDataRegister.do"><span class="am-icon-pencil-square-o"></span> 用户注册</a></li>
        <li><a href="./logout.do"><span class="am-icon-sign-out"></span> 退出</a></li>
      </ul>
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统管理</strong> / <small>用户注册</small></div>
      </div>

      <hr>

		<form method="post" class="am-form" action="./student/savePersonalDataRegister.do" data-am-validator>
			<input type="hidden" name="admin" value="3"/>
			<input type="hidden" name="state" value="1"/>
			<fieldset>
    		<legend>编辑个人资料</legend>
    		
		    <div class="am-form-group">
		      <label for="idcard">身份证号</label>
		      <input type="text" class="am-form-field js-pattern-idCard" id="idcard" name="idcard" value="${student.idcard }" placeholder="请输入合法的15位或18位身份证号码" required>
		    </div>
		    <div class="am-form-group">
		      <label for="name">姓名</label>
		      <input type="text" class="am-form-field" id="name" name="name" value="${student.name }" placeholder="" required>
		    </div>
		    <div class="am-form-group">
		      <label for="name">学号</label>
		      <input type="text" class="am-form-field" id="userName" name="userName" value="${student.userName }" minlength="3" placeholder="请输入学号" required>
		    </div>
		    <div class="am-form-group">
		      <label for="userPass">密码</label>
		      <input type="password" class="am-form-field" id="userPass" name="userPass" value="${student.userPass }" minlength="6" placeholder="请输入密码（至少 6 个字符）" required>
		    </div>
		    <div class="am-form-group">
		      <label for="userPassToo">确认密码</label>
		      <input type="password" class="am-form-field" id="userPassToo" name="userPassToo" value="${student.userPass }" placeholder="请重新输入密码" data-equal-to="#userPass" required>
		    </div>
		    <c:if test="${isDupcate eq '1'}">
		      <div class="am-alert am-alert-danger" data-am-alert>
				  <button type="button" class="am-close">&times;</button>
				  <p>${msg.message }</p>
			  </div>
			</c:if>
    		</fieldset>
		
			<div class="am-margin">
		      <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
		      <button type="button" onclick="window.history.back();" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
		    </div>
	    </form>
    </div>
  </div>
  <!-- content end -->

</div>

<div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
    <a href="#top" title="回到顶部">
        <span class="am-gotop-title">回到顶部</span>
        <i class="am-gotop-icon am-icon-chevron-up"></i>
    </a>
</div>

<footer>
    <div class="content">
        <ul class="am-avg-sm-5 am-avg-md-5 am-avg-lg-5 am-thumbnails">
            <li><a href="#">联系我们</a></li>
            <li><a href="#">加入我们</a></li>
            <li><a href="#">合作伙伴</a></li>
            <li><a href="#">广告及服务</a></li>
            <li><a href="#">友情链接</a></li>
        </ul>
        <p>Copyright (C) 2024 www.bjtu.edu.cn, All Rights Reserved.</p>
        <div class="w2div">
        <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-2 am-avg-lg-2 am-gallery-overlay" 
        	data-am-gallery="{pureview: true }" >
        </ul>
        </div>
    </div>
</footer>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
</body>
</html>