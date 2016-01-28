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
	$(".menuson li").click(function(){
		var txt = $(this).find("a").text();
		var tabId = $(this).attr("id");
		var rightFrame = window.parent.frames["rightFrame"];
		//tab标签对象
		var $tabs =  $("#tabs",rightFrame.document);
		//内容iframe生成和控制
		var $body =  $("body",rightFrame.document);
		var isLiExist = $tabs.find("#"+tabId).length > 0 ?true:false;
		if (!isLiExist){
			var $tab = $tabs.find("ul");
			var $li = $("<li></li>").attr("id",tabId);
			var $a = $("<a></a>").attr("href","#"+tabId).attr("class","selected").text(txt);
			var $span = $("<span></span>");
			$tab.append($li.append($a).append($span)); 
		}
		$tabs.find("ul li").each(function(){
			var id = $(this).attr("id");
			if (id != tabId){
				$(this).find("a").removeClass("selected");
				$(this).find("span").hide();
			}
			$(this).click(function(){
				$tabs.find("ul li").each(function(){
					$(this).find("a").removeClass("selected");
					$(this).find("span").hide();
				});
				$(this).find("a").addClass("selected");
				$(this).find("span").show();
				//隐藏所有内容div
				$body.find(".tabson").each(function(){
					$(this).hide();
				});
				//显示当前div
				$body.find("#div_"+id).show();
			});
			$(this).find("span").hover(function(){
				$(this).addClass('mouseover');
			},
			function(){
				$(this).removeClass('mouseover');
			});
			$(this).find("span").click(function(){
				var $prevelt = $(this).parent().prev();
				if ($prevelt.length > 0){
					var previd = $prevelt.attr("id")
					$prevelt.find("a").addClass("selected");
					$prevelt.find("span").show();
					$body.find("#div_"+previd).show();
				}
				else{
					var $nextelt = $(this).parent().next()
					if ($nextelt.length > 0){
						var nextid = $prevelt.attr("id")
						$nextelt.find("a").addClass("selected");
						$prevelt.find("span").show();
						$body.find("#div_"+nextid).show();
					}
				}				
				$(this).parent().remove();
				$body.find("#div_"+id).remove();
			});
		});
		//选中内容对应的tab 要处于选中状态
		$tabs.find("ul #"+tabId).find("a").addClass("selected");
		var height = $(rightFrame.document).height();
		var width = $(rightFrame.document).width();
		//跳转url
		var date = new Date();
		var times = date.getTime()
		var iframeSrc = $(this).find("input").val() + "&" + times;
		var isDivExist = $body.find("#div_"+tabId).length > 0 ?true:false;
		if (!isDivExist){
			var $div = $("<div></div>").attr("id","div_"+tabId).attr("class","tabson");
			var $iframe = $("<iframe></iframe>").attr("id","frame_"+tabId)
						.attr("frameborder","0").attr("scrolling","auto")
						.attr("width",width).attr("height",height)
						.attr("src",iframeSrc);
			$body.append($div.append($iframe));
		}
		else{
			//再次跳转
			$body.find("#frame_"+tabId).attr("src",iframeSrc);
		}
		//隐藏所有内容div
		$body.find(".tabson").each(function(){
			$(this).hide();
		});
		//显示当前div
		$body.find("#div_"+tabId).show();
	});
});
</script>
</head>
<body>
<div class="lefttop"><span></span>系统配置</div>
<dl class="leftmenu">
	<dd>
	<c:forEach items="${subAuthList}" var="sal">
	<shiro:hasPermission name="${sal.code}">
		<div class="title">
			<span>
				<img src="${base}/static/images/leftico0${sal_index+1}.png" />
			</span>
			${sal.name}
		</div>
		<ul class="menuson">
		<c:forEach items="${subAuthLevelList}" var="sall">
			<shiro:hasPermission name="${sall.code}">
				<c:if test="${sall.parentCode==sal.code}">
				<li id="tab_${sall.code}">
				<cite></cite>
				<a href="#">${sall.name}</a>
				<i><input type="hidden" value="${base}/goto/${sall.entityName}/${sall.methodName}Index?viewCode=${sall.code}&isContextCode=1"></i>
				</c:if>
			</shiro:hasPermission>
		</c:forEach>
		</ul>
	</shiro:hasPermission>
	</c:forEach>   
	</dd>
</dl>
</body>
</html>

