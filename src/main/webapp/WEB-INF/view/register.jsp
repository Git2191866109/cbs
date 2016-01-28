<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><msg:message code="system.name"/></title>
<link  href="${base}/static/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/static/js/jquery.min.js"></script>
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
	background-image:url(${base}/static/images/light.png); 
	background-repeat:no-repeat; 
	background-position:center top; 
	overflow:hidden;
}
</style>
</head>
<body>
<form action="${base}/common/register/save" method="post">
<div id="mainBody">
	<div id="cloud1" class="cloud"></div>
	<div id="cloud2" class="cloud"></div>
</div>
<div class="logintop">    
	<span>注册</span>    
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
				<input type="submit" class="loginbtn" value="注册"/>
			</li>
		</ul>
	</div>
</div>
</form>
</body>
</html>
