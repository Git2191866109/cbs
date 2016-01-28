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
<script language="javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
//	var ostop = $("#nav").offset().top; 
//	$(window).bind("scroll", function(){ 
//		var offsetTop = ostop + $(window).scrollTop() +"px"; 
//		$("#nav").animate({top:offsetTop },{duration:300,queue:false}); 
//	}); 
})	
</script>
</head>
<body>
    
    <div class="mainindex">
    <div class="welinfo">
    <span><img src="${base}/static/images/sun.png" alt="天气" /></span>
    <b>Admin早上好，欢迎使用信息管理系统</b>(admin@uimaker.com)
    <a href="#">帐号设置</a>
    </div>
    
    <div class="welinfo">
    <span><img src="${base}/static/images/time.png" alt="时间" /></span>
    <i>您上次登录的时间：2013-10-09 15:22</i> （不是您登录的？<a href="#">请点这里</a>）
    </div>
    
    <div class="xline"></div>
    
    <ul class="iconlist">
    
    <li><img src="${base}/static/images/ico01.png" /><p><a href="#">管理设置</a></p></li>
    <li><img src="${base}/static/images/ico02.png" /><p><a href="#">发布文章</a></p></li>
    <li><img src="${base}/static/images/ico03.png" /><p><a href="#">数据统计</a></p></li>
    <li><img src="${base}/static/images/ico04.png" /><p><a href="#">文件上传</a></p></li>
    <li><img src="${base}/static/images/ico05.png" /><p><a href="#">目录管理</a></p></li>
    <li><img src="${base}/static/images/ico06.png" /><p><a href="#">查询</a></p></li> 
            
    </ul>
    
    <div class="ibox"><a class="ibtn"><img src="${base}/static/images/iadd.png" />添加新的快捷功能</a></div>
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="${base}/static/images/dp.png" alt="提醒" /></span>
    <b>Uimaker信息管理系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>您可以快速进行文章发布管理操作</span><a class="ibtn">发布或管理文章</a></li>
    <li><span>您可以快速发布产品</span><a class="ibtn">发布或管理产品</a></li>
    <li><span>您可以进行密码修改、账户设置等操作</span><a class="ibtn">账户管理</a></li>
    </ul>
    
    <div class="xline"></div>
    
    <div class="uimakerinfo"><b>查看Uimaker网站使用指南，您可以了解到多种风格的B/S后台管理界面,软件界面设计，图标设计，手机界面等相关信息</b>(<a href="http://www.uimaker.com" target="_blank">www.uimaker.com</a>)</div>
    
    <ul class="umlist">
    <li><a href="#">如何发布文章</a></li>
    <li><a href="#">如何访问网站</a></li>
    <li><a href="#">如何管理广告</a></li>
    <li><a href="#">后台用户设置(权限)</a></li>
    <li><a href="#">系统设置</a></li>
    </ul>
    </div>
</body>
</html>