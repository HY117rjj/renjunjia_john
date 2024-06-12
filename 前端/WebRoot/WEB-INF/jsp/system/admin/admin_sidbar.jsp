<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
  	<link rel="icon" sizes="192x192" href="images/i/app.png">
  	<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  	<meta name="apple-mobile-web-app-title" content="课程实训系统" />
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/amazeui.min.css"/>
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/amazeui.page.css">
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/admin.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<!-- sidebar start -->
<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
	<div class="am-offcanvas-bar admin-offcanvas-bar">
		<ul class="am-list admin-sidebar-list">
			<li><a href="./systemindex.do"><span class="am-icon-home am-active"></span> 首页</a></li>
        	<li class="admin-parent">
          		<a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 系统管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          		<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            		<li><a href="./student/editPersonalData.do?id=${user.id }" class="am-cf"><span class="am-icon-check"></span> 个人信息管理<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
		            <c:if test="${user.admin == '1' }">
		            <li><a href="./student/list.do"><span class="am-icon-calendar"></span> 用户信息管理</a></li>
		            <!-- 
		            <li><a href="./teacher/list.do"><span class="am-icon-calendar"></span> 教师管理</a></li>
		             -->
		            </c:if>
		            <li><a href="./courseware/list.do"><span class="am-icon-calendar"></span> 教学文档管理</a></li>
		            <li><a href="javascript:void(0);"><span class="am-icon-calendar"></span> 实训操作模块</a></li>
		            <c:if test="${user.admin == '1' || user.simManager == 'A' || user.simManager == 'B' }">
		            <li style="padding-left: 20px;"><a href="./process/list.do"><span class="am-icon-check-square-o"></span> 流程审批</a></li>
		            </c:if>
		            <c:if test="${user.admin == '1' || user.simManager == 'A' }">
		            <li style="padding-left: 20px;"><a href="./log/listLogFile.do"><span class="am-icon-user"></span> 系统管理员</a></li>
		            </c:if>
		            <c:if test="${user.admin == '1' || user.simManager == 'B' }">
		            <li style="padding-left: 20px;"><a href="./student/list.do"><span class="am-icon-user-secret"></span> 安全保密管理员</a></li>
		            </c:if>
		            <c:if test="${user.admin == '1' || user.simManager == 'C' }">
		            <li style="padding-left: 20px;"><a href="./log/list.do"><span class="am-icon-file-text-o"></span> 安全审计员</a></li>
		            </c:if>
		            <li><a href="./case/list.do"><span class="am-icon-calendar"></span> 案例分析与讨论</a></li>
		            <li><a href="./notice/list.do"><span class="am-icon-calendar"></span> 站内公告管理</a></li>
          		</ul>
			</li>
       	 	<li><a href="./systemlogout.do"><span class="am-icon-sign-out"></span> 注销</a></li>
		</ul>
    </div>
</div>
<!-- sidebar end -->

</body>
</html>
