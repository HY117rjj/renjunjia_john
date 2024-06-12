<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		    var coverImage = $('#addressLink').AmazeuiUpload({
		       url: './courseware/uploading.do',
		       downloadUrl:'',
		       maxFiles: 1 , // 单次上传的数量
		       maxFileSize: 2000,  // 单个文件允许的大小 (M)
		       multiThreading: true, // true为同时上传false为队列上传 改为true 如果为fasle的化 程序报错：Synchronous XMLHttpRequest on the main thread is deprecated because of its detrimental effects to the end user's experience.
		       useDefTemplate: true // 开启默认模版
		    });
		    
		    var dataf = [];
		    var datad = [];
	        $.ajax({
	            url: "./teacher/getAvailableTeacher.do",
	            type: "POST",
	            dataType: "json",
	            data: "{'companyname': 'targetVal'}",
	            contentType: "application/json; charset=utf-8",
	            //该属性表示前台请求到的数据为返回json数据格式的方法        
	            async: false,
	            success: function(data) {
	                dataf = eval(data.d);
	                datad = eval(data.n);
	                //数组          
	            }
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统管理</strong> / <small>教学文档管理</small></div>
      </div>
      <hr>
		<form method="post" class="am-form" action="./courseware/saveCourseware.do">
			<input type="hidden" name="id" id="id" value="${cw.id }"/>
			<input type="hidden" name="serialNumber" id="sn" value="${sn }"/>
			<input type="hidden" name="addressLink" value="${cw.addressLink }"/>
			<input type="hidden" name="coverImage" value="${cw.coverImage }"/>
			<input type="hidden" name="attachmentLink" value="${cw.attachmentLink }"/>
			<input type="hidden" name="icdName" id="icdName" value=""/>
			<fieldset>
    		<legend>编辑课件信息</legend>
    		<div class="am-form-group">
		      <label for="idcard">教师身份证号码</label>
		      <input type="text" class="am-form-field" id="idcard" name="idcard" value="${cw.idcard }" placeholder="输入身份证号码" onkeyup="autoComplete.start(event)" required>
		      <div class="auto_hidden" id="auto"><!--自动完成 DIV--></div>
		    </div>
		    <div class="am-form-group">
		      <label for="name">教师姓名</label>
		      <input type="text" class="am-form-field" id="name" name="name" value="${cw.name }" placeholder="输入姓名" required>
		    </div>
		    
    		<div class="am-form-group">
		      <label for="title">课件名称</label>
		      <input type="text" class="am-form-field" id="title" name="title" value="${cw.title }" placeholder="" required>
		    </div>
		    <div class="am-form-group">
		      <label for="summary">内容提要</label>
		      <input type="text" class="am-form-field" id="summary" name="summary" value="${cw.summary }" placeholder="">
		    </div>
			
		    <div class="am-form-group">
		      <label for="onDemandCharge">显示状态</label><br/>
		      <div class="am-btn-group" data-am-button>
	              <label class="am-btn am-btn-default am-btn-xs ">
	                <input type="radio" name="stickyPosts" id="stickyPosts_0" ${cw.stickyPosts eq 0 ? 'checked="checked"' : '' } value="0"> 置顶显示
	              </label>
	              <label class="am-btn am-btn-default am-btn-xs am-active">
	                <input type="radio" name="stickyPosts" id="stickyPosts_1" ${cw.stickyPosts eq 0 ? '' : 'checked="checked"' } value="1"> 不置顶显示
	              </label>
	            </div>
		    </div>
    		
		    <c:if test="${user.admin == '1' }">
		    <div class="am-form-group">
		      <label for="addressLink">封面图片及课件附件地址链接（封面图片格式为JPG/PNG推荐320*180视频课件格式为MP4教学文档格式为DOC/PPT/PDF格式）</label>
		      <div id="addressLink"></div>
		    </div>
		    </c:if>
		    <div class="am-form-group">
		      <label for="text">附件上传情况</label>
		      <div>
		      	<c:if test="${not empty cw.coverImage }">
		      		<a href="<%=mediaPath%>${cw.coverImage }" target="_blank">封面图片</a>
		      	</c:if>
		      	<c:if test="${not empty cw.addressLink }">
		      		<a href="<%=basePath%>Html5VideoPlayer.jsp?cwid=${cw.id }&video=${cw.addressLink }" target="_blank">视频课件</a>
		      	</c:if>
		      	<c:if test="${not empty cw.attachmentLink }">
		      		<a href="<%=mediaPath%>${cw.attachmentLink }" target="_blank">教学文档</a>
		      	</c:if>
		      	<c:if test="${empty cw.coverImage && empty cw.addressLink && empty cw.attachmentLink}">
		      		没有上传任何附件！
		      	</c:if>
		      </div>
		    </div>
			</fieldset>
			
			<div class="am-margin">
			  <c:if test="${user.admin == '1' }">
	            <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
		        <button type="button" onclick="window.history.back();" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>         	
	          </c:if>
		      <c:if test="${user.admin ne '1' }">
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
