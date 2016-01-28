<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><msg:message code="system.name" /></title>
<link href="${base}/static/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/static/js/jquery.min.js"></script>
<script language="javascript">
$(function(){
	var $rightFrame = $("#leftFrame",parent.document.body);
	var $li = $(".nav").find("li").first();
	var src = $li.find("a").attr("href");
	$rightFrame.attr("src",src);
	$(".nav li").click(function(){
		$(".nav li").each(function(){
			$(this).find("a").removeClass();
		});
		$(this).find("a").addClass("selected");
	});
});
</script>
</head>
<body style="background:url(${base}/static/images/topbg.gif) repeat-x;">
<div class="topleft">
	<img src="${base}/static/images/logo.png" title="<msg:message code="system.name" />"/>
</div>
<ul class="nav">
	<c:forEach items="${subAuthList}" var="sal">
		<shiro:hasPermission name="${sal.code}">
			<li>
				<a href="${base}/goto/authorization/jumpLeft?viewCode=${sal.code}&parentCode=${sal.code}&treeLevel=3" target="leftFrame">
					<img src="${base}/static/images/icon0${sal.code}.png" title="${sal.name}" />
					<h2>${sal.name}</h2>
				</a>
			</li>
		</shiro:hasPermission>
	</c:forEach>
</ul>
<div class="topright">    
	<ul>
		<li><span><img src="${base}/static/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
		<li><a href="${base}/exit">退出</a></li>
	</ul>
	<div class="user">
		<span>	</span>
		<i>消息</i>
		<b>5</b>
	</div>    
</div>
</body>
</html>
