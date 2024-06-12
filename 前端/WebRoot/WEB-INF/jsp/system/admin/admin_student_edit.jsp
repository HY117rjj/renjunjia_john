<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function delTeacher(id){
			var url = "${pageContext.request.contextPath }/teacher/removeTeacher.do?ajax=1&id="+id;
			$.get(url, function(json){
				if(json.statusCode==200){
					
				}
			},'json');
		}
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统管理</strong> / <small>用户信息管理</small></div>
      </div>
      <hr>
		<form method="post" class="am-form" action="./student/saveStudent.do">
			<input type="hidden" name="id" value="${student.id }"/>
			<input type="hidden" name="admin" value="${student.admin }"/>
			
			<fieldset>
    		<legend>编辑学员信息</legend>
    		
		    <div class="am-form-group">
		      <label for="idcard">身份证</label>
		      <input type="text" class="am-form-field" id="idcard" name="idcard" value="${student.idcard }" placeholder="">
		    </div>
		    <div class="am-form-group">
		      <label for="name">姓名</label>
		      <input type="text" class="am-form-field" id="name" name="name" value="${student.name }" placeholder="">
		    </div>
    		
    		<div class="am-form-group">
		      <label for="eduId">学号</label>
		      <input type="text" class="am-form-field" id="userName" name="userName" value="${student.userName }" readonly="readonly">
		    </div>
		    <div class="am-form-group">
		      <label for="eduDesignation">密码</label>
		      <input type="text" class="am-form-field" id="userPass" name="userPass" value="" placeholder="输入密码">
		    </div>
		    
		    <div class="am-form-group">
		      <label for="creditHour">三员管理身份</label>
		      <input type="radio" name="simManager" value="A" ${student.simManager == 'A' ? 'checked="checked"' : '' }> 系统管理员
		      <input type="radio" name="simManager" value="B" ${student.simManager == 'B' ? 'checked="checked"' : '' }> 安全保密管理员
		      <input type="radio" name="simManager" value="C" ${student.simManager == 'C' ? 'checked="checked"' : '' }> 安全审计人员
		    </div>
		    
		    <c:if test="${user.simManager == 'B' }">
		    <div class="am-form-group">
		      <label for="creditHour">角色</label>
		      <input type="radio" name="role" value="role1" ${student.role == 'role1' ? 'checked="checked"' : '' }> 将X文件填入系统
		      <input type="radio" name="role" value="role2" ${student.role == 'role2' ? 'checked="checked"' : '' }> 修改X文件
		      <input type="radio" name="role" value="role3" ${student.role == 'role3' ? 'checked="checked"' : '' }> 删除X文件
		    </div>
		    </c:if>
		    
		    <div class="am-form-group">
		      <label for="creditHour">是否有效</label>
		      <input type="radio" name="state" value="0" ${student.state == '0' ? 'checked="checked"' : '' }> 无效
		      <input type="radio" name="state" value="1" ${student.state == '1' ? 'checked="checked"' : '' }> 有效
		    </div>
		    
    		</fieldset>
		
			<div class="am-margin">
		      <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
		      <button type="button" onclick="window.history.back();" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
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
<script src="assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/amazeui.page.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>
