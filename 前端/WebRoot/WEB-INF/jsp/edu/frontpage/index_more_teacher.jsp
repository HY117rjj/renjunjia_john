<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String mediaPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/Media"+"/";
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

    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="assets/js/jquery.min.js"></script>
    <!--<![endif]-->
    <!--[if lte IE 8 ]>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="assets/js/amazeui.ie8polyfill.min.js"></script>
    <![endif]-->
    <script src="assets/js/amazeui.min.js"></script>
    <script src="js/public.js"></script>
    <script type="text/javascript">
    $(function(){
		$.post("./notice/getFrontPagelist.do",{},function(data){
			var notice = data["notice"];
			if(notice.length){
				var noticetable = $("#noticeTable");
				var head="<tr><td>通知标题</td><td>发布日期</td></tr>";
				for(var index in notice){
					var obj = notice[index];
					var id = obj.id;
					var title = obj.title;
					var content = obj.content;
					var noticeTime = obj.noticeTime;
					var promulgator = obj.promulgator;
					var noticeTime_ = formatDate(new Date(noticeTime),"yyyy-MM-dd");
					var noticeRow = $("<tr></tr>");
					var noticeCol1 = $("<td width=\"70%\" style=\"overflow:hidden;white-space:nowrap;text-overflow:ellipsis;\"></td>");
					var noticeCol2 = $("<td></td>");
					noticeCol1.append("<a href=\"./notice/viewNoticeFrontPage.do?id="+id+"\">"+title+"</a>");
					noticeCol2.append("").append(noticeTime_);
					noticeRow.append(noticeCol1);
					noticeRow.append(noticeCol2);
					noticetable.append(noticeRow);
				}
			}
		}, "json");
	});
	
	//格式化日期, 
	function formatDate(date, format) {
		var paddNum = function(num) {
			num += "";
			return num.replace(/^(\d)$/, "0$1");
		}
		//指定格式字符 
		var cfg = {
			yyyy : date.getFullYear() //年 : 4位 
			,
			yy : date.getFullYear().toString().substring(2)//年 : 2位 
			,
			M : date.getMonth() + 1 //月 : 如果1位的时候不补0 
			,
			MM : paddNum(date.getMonth() + 1) //月 : 如果1位的时候补0 
			,
			d : date.getDate() //日 : 如果1位的时候不补0 
			,
			dd : paddNum(date.getDate())//日 : 如果1位的时候补0 
			,
			hh : date.getHours() //时 
			,
			mm : date.getMinutes() //分 
			,
			ss : date.getSeconds()
		//秒 
		}
		format || (format = "yyyy-MM-dd HH:mm:ss");
		return format.replace(/([a-z])(\1)*/ig, function(m) {
			return cfg[m];
		});
	}
	
	function chairLecture(id){
		if("${user}" == ""){
			$('#my-alert2').modal({
		        relatedTarget: this,
		        onConfirm: function(options) {// 具有 data-am-modal-confirm 属性的按钮关闭时触发的函数
		        	window.top.location.href="./login.do";
		        },
		        onCancel: function() {// 具有 data-am-modal-cancel 属性的按钮关闭时触发的函数
		          
		        }
		    });
			return;
		}
		var url = "${pageContext.request.contextPath }/chair/chairLecture.do?ajax=1&type=${type }&id="+id;
		$.post(url, {}, function(json){
			if(json["json"][0].statusCode==200){
				var $modal = $('#my-alert');
				$modal.modal();
			}
		},"json");
	}
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
                <li class="am-active"><a href="<%=basePath%>">首页</a></li>
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
                <a type="button" href="./student/editPersonalDataRegister.do" class="am-btn am-btn-default am-topbar-btn am-btn-sm"><span class="am-icon-pencil"></span> 注册</a>
            </div>

            <div class="am-topbar-right">
                <a type="button" href="./login.do" class="am-btn am-btn-danger am-topbar-btn am-btn-sm"><span class="am-icon-user"></span> 登录</a>
            </div>
            </c:if>
        </div>
    </div>
</header>
<!--banner-->

<!--news-->
<div class="am-g am-container newatype">
    <div class="am-u-sm-12 am-u-md-12 oh">
         <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
            <h2 class="am-titlebar-title ">
            	专家风采
            </h2>
        </div>
        <div data-am-widget="list_news" class="am-list-news am-list-news-default right-bg" data-am-scrollspy="{animation:'fade'}">
        	<ul class="am-list">
	        	<c:forEach items="${teacher }" var="t">
	            	<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
	                	<div class="am-u-sm-4 am-list-thumb">
	                    	<a href="./demand/listForFrontPage.do?type=4&code=${t[1] }">
	                        	<c:if test="${empty t[3] }">
	                            	<img src="./images/male.jpg" class="face" style="width: 80px;"/>
	                            </c:if>
	                            <c:if test="${not empty t[3] }">
	                            	<img src="http://www.telemedicine.net.cn:9080/telemedicine${fn:replace(t[3], 'viewfile', 'viewfile.do')}" class="face" style="width: 80px;" onerror="this.src='./images/male.jpg'"/>
	                            </c:if>
	                        </a>
	                    </div>
	
	                    <div class=" am-u-sm-8 am-list-main">
	                        <h3 class="am-list-item-hd"><a href="./demand/listForFrontPage.do?type=4&code=${t[1] }">${t[1] }</a></h3>
	
							<div class="am-list-item-text-line6">
	                        	<c:if test="${empty t[2] }">
	                            	暂无简介....
	                            </c:if>
	                            <c:if test="${not empty t[2] }">
	                            	${t[2] }
	                            </c:if>
	                        </div>
	                    </div>
	                </li>
	                <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
	            </c:forEach>
            </ul>
        </div>

    </div>
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
            <li><a href="http://www.telemedicine.net.cn/">友情链接</a></li>
        </ul>
        <p>Copyright (C) 2024 www.bjtu.edu.cn, All Rights Reserved.</p>
        <div class="w2div">
        <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-2 am-avg-lg-2 am-gallery-overlay" 
        	data-am-gallery="{pureview: true }" >
        </ul>
        </div>
    </div>
</footer>
</body>
</html>