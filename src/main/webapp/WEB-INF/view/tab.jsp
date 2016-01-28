<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><msg:message code="system.name" /></title>
<link href="${base}/static/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${base}/static/js/jquery.tabs.min.js"></script>
<script type="text/javascript">
function test(){
	alert("dddd")
}
$(document).ready(function(e) {
	$("#tabs ul").idTabs(function(id){
		return true;
	});
});
</script>
</head>
<body>
<div id="tabs" class="itab" >
	<ul> 
		<li><a href="#tab1" class="selected">系统首页</a></li> 
		<li><a href="#tab2">自定义</a></li> 
	</ul>
</div> 
</body>
</html>
