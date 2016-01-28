<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="msg" uri="/WEB-INF/tlds/springframework-message.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><msg:message code="system.name" /></title>
<link href="${base}/static/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/static/js/jquery.min.js"></script>
<script type="text/javascript"> 
$(document).ready(function(e) {
	var height = $(window).height();
	$(".tabson").height(height-170);
});
</script>
</head>
<body>
<div id="tabs" class="itab" >
	<ul> 
		<li id="tab_default"><a href="#tab_default" class="selected">系统首页</a></li> 
	</ul>
	<div class="itabmove">
		<a href="#"><img src="${base}/static/images/tab/left.png" border="0"/></a>
		<a href="#"><img src="${base}/static/images/tab/right.png" border="0"/></a>
	</div>
</div> 
<!-- 
<div class="place" id="nav">
    <span>位置：</span>
    <ul class="placeul">
    	<li><a href="#">首页</a></li>
    </ul>
</div>
 -->
<div id="div_tab_default" class="tabson">
	<iframe src="${base}/home" id="frame_tab_default" frameborder="0" scrolling="auto" width="100%" height="100%"></iframe>
</div>
</body>
</html>
