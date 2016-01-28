<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><msg:message code="system.name"/></title>
<link  href="${pageContext.request.contextPath}/static/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script language="javascript">
$(function(){
	$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
		$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	});
});  
</script> 

<style type="text/css">
body{
	background-color:#1c77ac;
	background-image:url(${pageContext.request.contextPath}/static/images/light.png); 
	background-repeat:no-repeat; 
	background-position:center top; 
	overflow:hidden;
}
</style>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
<div id="mainBody">
	<div id="cloud1" class="cloud"></div>
	<div id="cloud2" class="cloud"></div>
</div>
<div class="logintop">    
	<span>欢迎登录后台管理界面平台</span>    
	<ul>
		<li><a href="#">帮助</a></li>
		<li><a href="#">关于</a></li>
		<li><a href="${pageContext.request.contextPath}/register">注册</a></li>
	</ul>    
</div>
<div class="loginbody">
	<span class="systemlogo"></span> 
	<div class="loginbox">
		<ul>
			<li>
				<input type="text" name="account" id="account" class="loginuser" onclick="JavaScript:this.value=''"/>
			</li>
			<li>
				<input type="password" name="password" id="password" class="loginpwd" onclick="JavaScript:this.value=''"/>
			</li>
			<li>
				<input type="submit" class="loginbtn" value="登录"/>
				<label>
					<input type="checkbox" value="" checked="checked" />记住密码
				</label>
				<label>
					<a href="#">忘记密码？</a>
				</label>
			</li>
		</ul>
	</div>
</div>
<div class="loginbm">
	版权所有  2014  
	<a href=""><msg:message code="system.coypright"/></a>  
</div>
</form>
</body>
</html>
