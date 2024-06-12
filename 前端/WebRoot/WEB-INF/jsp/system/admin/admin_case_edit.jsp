<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String mediaPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/Media"+"/";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js fixed-layout">
  <head>
    <base href="<%=basePath%>">
    
    <title>课程实训系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<meta name="renderer" content="webkit">
  	<meta http-equiv="Cache-Control" content="no-siteapp" />
  	<link rel="icon" type="image/png" href="assets/i/favicon.png">
  	<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  	<meta name="apple-mobile-web-app-title" content="课程实训系统" />
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/amazeui.min.css"/>
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/amazeui.page.css">
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/admin.css">
  	
    <link href="js/Squire-Squire-UI/build/Squire-UI.Modified.css" rel="stylesheet" type="text/css" />
    <link href="js/Squire-Squire-UI/build/bootstrap/bootstrap.min.without.a.css" rel="stylesheet" type="text/css" />
    <script src="js/Squire-Squire-UI/build/jQuery/jQuery.js" type="text/javascript"></script>
    <script src="js/Squire-Squire-UI/build/squire-raw.js" type="text/javascript"></script>
    <script src="js/Squire-Squire-UI/build/Squire-UI.js" type="text/javascript"></script>
    
    <link rel="stylesheet" href="js/AmazeUIUpload-master/dist/amazeui.upload.css"/>
    <script src="js/AmazeUIUpload-master/dist/amazeui.min.js"></script>
    <script src="js/AmazeUIUpload-master/dist/amazeui.upload.js"></script>
    <script src="js/AmazeUIUpload-master/dist/amazeui.upload.template.js"></script>
    <script src="js/AmazeUIUpload-master/dist/amazeui.upload.event.js"></script>
    
    <link rel="stylesheet" href="assets/css/amazeui.autocomplete.css"/>
    <script src="assets/js/amazeui.autocomplete.js"></script>
    <script src="assets/js/amazeui.autocomplete.icd.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		$(function () {
	    	var editor = new SquireUI({replace: 'textarea#foo', height: 300});
	      	editor.setHTML('${cw.caseContent }');//切记，用双引号会和内容中的双引号形成闭合
	      	editor.addEventListener("input", function(){
	      		$("#caseContent").val(editor.getHTML());
	      	});
	    });
	</script>
  </head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <strong>课程实训系统</strong> <small> </small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:void(0);"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:void(0);">
          <span class="am-icon-users"></span> ${user.name } <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="./student/editPersonalData.do?id=${user.id }"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="./student/editPersonalData.do?id=${user.id }"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="./systemlogout.do"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <%@ include file="./admin_sidbar.jsp"%>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统管理</strong> / <small>案例分析与讨论</small></div>
      </div>
      <hr>
		<form method="post" class="am-form" action="./case/saveCase.do">
			<input type="hidden" name="id" id="id" value="${cw.id }"/>
		
			<fieldset>
    		<legend>编辑课件信息</legend>
    		<div class="am-form-group">
		      <label for="idcard">身份证号码</label>
		      <input type="text" class="am-form-field" id="idcard" name="idcard" value="${cw.idcard }" placeholder="输入身份证号码">
		      <div class="auto_hidden" id="auto"><!--自动完成 DIV--></div>
		    </div>
		    <div class="am-form-group">
		      <label for="name">姓名</label>
		      <input type="text" class="am-form-field" id="name" name="name" value="${cw.name }" placeholder="输入姓名" required>
		    </div>
    		<div class="am-form-group">
		      <label for="caseContent">案例分析任务</label>
		      <textarea id="caseContent" name="caseContent" rows="6">${cw.caseContent }</textarea>
		    </div>
		    <div class="am-form-group">
		      <label for="recordTime">发布时间</label>
		      <input type="text" class="am-form-field" id="recordTime" value="<fmt:formatDate type="both" value="${cw.recordTime }" pattern="yyyy-MM-dd HH:mm:ss" />">
		    </div>
			</fieldset>
			
			<div class="am-margin">
			  <c:if test="${user.name eq cw.name }">
	            <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
		        <button type="button" onclick="window.history.back();" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>         	
	          </c:if>
		      <c:if test="${user.name ne cw.name }">
		        <button type="button" onclick="window.history.back();" class="am-btn am-btn-primary am-btn-xs">返回</button>         	
	          </c:if>
		    </div>
	    </form>
    </div>
    <footer class="admin-content-footer">
      <hr>
      <p class="am-padding-left">Copyright (C) 2024 www.bjtu.edu.cn, All Rights Reserved.</p>
    </footer>
  </div>
  <!-- content end -->

</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<!--Uncaught TypeError: $(...).AmazeuiUpload is not a function-->
<!--  
<script src="assets/js/jquery.min.js"></script>
-->
<!--<![endif]-->
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/amazeui.page.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>
