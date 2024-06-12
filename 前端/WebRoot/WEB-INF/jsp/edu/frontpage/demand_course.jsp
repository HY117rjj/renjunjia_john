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
    <script type="text/javascript">
	$(function() {
		var page = window.location.search.match(/page=(\d+)/);   
		$("#page").page({pages:${pd.totalPage }}).setCurr(page?page[1]:1, function() {
			console.log('跳转到第' + page + "页");
		});
	})
	</script>
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
                <li class=""><a href="<%=basePath%>">首页</a></li>
                <li class="am-dropdown" data-am-dropdown>
                    <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                        	课件点播 <span class="am-icon-caret-down"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li class="am-dropdown-header">课件点播</li>
                        <li><a href="./demand/list.do?type=1">1. 专业学科</a></li>
                        <li><a href="./demand/list.do?type=2">2. 临床专业</a></li>
                        <li><a href="./demand/list.do?type=3">3. 疾病分类</a></li>
                        <li><a href="./demand/list.do?type=4">4. 讲授教师</a></li>
                    </ul>
                </li>
                <li class="am-dropdown" data-am-dropdown>
                    <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                        	预约讲座 <span class="am-icon-caret-down"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li class="am-dropdown-header">预约讲座</li>
                        <li><a href="./chair/list.do?type=1">1. 专业学科</a></li>
                        <li><a href="./chair/list.do?type=2">2. 临床专业</a></li>
                        <li><a href="./chair/list.do?type=3">3. 疾病分类</a></li>
                        <li><a href="./chair/list.do?type=4">4. 讲授教师</a></li>
                    </ul>
                </li>
                <li><a href="./systemlogin.do">教育项目</a></li>
                <li><a href="./demand/listHE.do?type=3">健康教育</a></li>
                <li><a href="http://live.telemedicine.net.cn/userportal/?from=singlemessage&isappinstalled=0#/home/allliveevents">课堂直播</a></li>
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
        <c:forEach items="${dicdata }" var="cc">
        	<li class="admin-parent">
        	<c:if test="${type eq 4 }">
        	  <a href="./demand/list.do?type=${type }&code=${cc.code }"><span class="am-icon-calendar"></span> ${cc.name }</a>
        	</c:if>
        	<c:if test="${type ne 4 }">
        	  <a class="am-cf" data-am-collapse="{parent: '#collapase-nav-1', target: '#collapse-nav${cc.code }'}"><span class="am-icon-file"></span> ${cc.name } <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
	          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav${cc.code }">
	          	<c:forEach items="${cc.dataList }" var="cc2">
	          		<c:if test="${empty cc2.dataList }">
        				<li><a href="./demand/list.do?type=${type }&code=${cc2.code }"><span class="am-icon-calendar"></span> ${cc2.name }</a></li>
        	  		</c:if>
        	  		<c:if test="${not empty cc2.dataList }">
        				<li><a data-am-collapse="{target: '#collapse-nav${cc2.name }'}"><span class="am-icon-calendar"></span> ${cc2.name }<span class="am-icon-angle-right am-fr am-margin-right"></span></a></li>
        	  			<ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav${cc2.name }">
        	  			<c:forEach items="${cc2.dataList }" var="cc3">
			        		<li><a href="./demand/list.do?type=${type }&code=${cc3.code }"><span class="am-icon-calendar"></span> ${cc3.name }</a></li>
			          	</c:forEach>
			          	</ul>
        	  		</c:if>
	          	</c:forEach>
	          </ul>
        	</c:if>
	        </li>
        </c:forEach>
        <li><a href="./demand/listCourse.do?type=${type }"><span class="am-icon-pencil-square-o"></span> 我的课程</a></li>
        <li><a href="./logout.do"><span class="am-icon-sign-out"></span> 注销</a></li>
      </ul>
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">课件点播</strong> / <small>我的课程</small></div>
      </div>

      <hr>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
          <div class="am-btn-toolbar">
            <div class="am-btn-group am-btn-group-xs">
            <!-- 工具栏按钮组 -->
            <button type="button" class="am-btn am-btn-primary" style="visibility: hidden;"> 布局占位 </button>
            </div>
          </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">
          <div class="am-form-group">
            <select data-am-selected="{btnSize: 'sm'}">
              <option value="option1">所有类别</option>
              <option value="option2">姓名</option>
              <option value="option3">身份证号</option>
            </select>
          </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">
          <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field">
          <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
          </div>
        </div>
      </div>
	  <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <th class="table-id">ID</th>
                <th class="table-title am-hide-sm-only">身份证号</th>
                <th class="table-type">学员姓名</th>
                <th class="table-author am-hide-sm-only">课件</th>
                <th class="table-date am-hide-sm-only">点播时间</th>
                <th class="table-author am-hide-sm-only">点播费</th>
                <th class="table-date am-hide-sm-only">是否结束</th>
                <!-- 
                <th class="table-set">操作</th>
                -->
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${pd.rows }" var="pd">
              	<tr>
	            	<td>${pd.id }</td>
	                <td class="am-hide-sm-only"><a href="function:void(0);">${pd.idcard }</a></td>
	                <td>${pd.name }</td>
	                <td class="am-hide-sm-only">${pd.courseware }</td>
	                <td class="am-hide-sm-only">${pd.signTime_ }</td>
	                <td class="am-hide-sm-only">${pd.charge }</td>
	                <td class="am-hide-sm-only">${pd.complete }</td>
	                <!--
	                <td>
	                  <div class="am-btn-toolbar">
	                    <div class="am-btn-group am-btn-group-xs">
	                      <a class="am-btn am-btn-default am-btn-xs am-text-secondary" href="${pageContext.request.contextPath }/eduser/editEduUserDetails.do?id=${pd.id }"><span class="am-icon-pencil-square-o"></span> 编辑</a>
	                      <!-- <button class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="editTeacher('${pd.id }');"><span class="am-icon-pencil-square-o"></span> 编辑</button> --
	                      <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="delEduUserDetails('${pd.id }');"><span class="am-icon-trash-o"></span> 删除</button>
	                    </div>
	                  </div>
	                </td>
	                -->
	          	</tr>
              </c:forEach>
              </tbody>
            </table>
            <div class="am-cf">
              	共 ${pd.total } 条记录
              	<div id="page" data-am-page="{pages:'${pd.totalPage }',jump:'./demand/listCourse.do?page=%page%'}"></div>
            </div>
          </form>
        </div>
      </div>	     
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