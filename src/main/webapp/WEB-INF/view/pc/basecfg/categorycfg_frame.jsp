<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<%@ include file="/WEB-INF/view/pc/pccommonhead.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function(){
			var height = $(window).height();
			$(".iframe").height(height-100);
			$(".tabitem").click(function(){
				$(".tabitem").removeClass("selected");
				$(this).addClass("selected");
				var id = $(this).attr("id").replace("tabitem","tabcont");
				$(".tabcont").css("display","none");
				$("#"+id).css("display","block");
			});
		});
	</script>
	<style type="text/css">
		ul#tabnav {
			position :relative;
			text-align: bottom;
			margin: 0em 0 1em 0;
			font: bold 12px verdana, arial, sans-serif;
			border-bottom: 1px solid #B4B1CE;
			list-style-type: none;
			padding: 4px 2px ;
			height: 24px;
		}
		#connection{
			float: left;
		}
		ul#tabnav li {
			float:left;
		}
		ul#tabnav li a {
			padding: 0 14px;
			border-top: 1px solid #B4B1CE;
			border-left: 1px solid #B4B1CE;
			border-right: 1px solid #B4B1CE;
			background-color: #eafbff ;
			color: #000;
			text-decoration: none;
			height: 24px;
			line-height: 24px;
			float: left;
			margin-top: 3px;
			margin-right: 5px;
			border-radius: 4px 4px 0 0;
		}
		#tabnav .selected {
			background-color:#ccdfed;
			color: #000;
			height: 28px;
			line-height: 28px;
			margin-top: 0;
		}
		/*#addDataing{*/
		/*float: left;*/
		/*width:570px;*/
		/*height:600px;*/
		/*overflow:auto;*/
		/*display: block;*/
		/*}*/
	</style>
</head>
<body class="skinMain">
<ul id="tabnav" class="tabnav">
	<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_code}">
		<c:forEach items="${categoryList }" var="item" varStatus="status">
			<c:if test="${status.first==true}">
				<li class="" ><a href="javascript:void(0);" id="tabitem_${item.value }"  class="selected tabitem">${item.name }</a></li>
			</c:if>
			<c:if test="${status.first==false}">
				<li class="" ><a href="javascript:void(0);" id="tabitem_${item.value }"  class="tabitem">${item.name }</a></li>
			</c:if>
		</c:forEach>
	</shiro:hasPermission>
</ul>
<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_code}">
	<c:forEach items="${categoryList }" var="item" varStatus="status">
		<c:if test="${status.first==true}">
			<div class="tabcont" id="tabcont_${item.value }" style="">
				<iframe src="${base}/goto/structureConfig/structureConfigIndex?viewCode=${pc_basecfg_categorycfg_newplayerproduct_code}&isContextCode=1&categoryId=${item.value }" width="100%" frameborder="0" name="iframe" class="iframe" scrolling="auto" style="" title="iframe"></iframe>
			</div>
		</c:if>
		<c:if test="${status.first!=true}">
			<div class="tabcont" id="tabcont_${item.value }" style="display: none;">
				<iframe src="${base}/goto/structureConfig/structureConfigIndex?viewCode=${pc_basecfg_categorycfg_newplayerproduct_code}&isContextCode=1&categoryId=${item.value }" width="100%" frameborder="0" name="iframe" class="iframe" scrolling="auto" style="" title="iframe"></iframe>
			</div>
		</c:if>
	</c:forEach>
</shiro:hasPermission>


<%--<ul id="tabnav" class="tabnav">--%>
	<%--<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_code}">--%>
		<%--<li class="" ><a href="#" id="tabitem_${pc_basecfg_categorycfg_newplayerproduct_code}"  class="selected tabitem">新手产品</a></li>--%>
	<%--</shiro:hasPermission>--%>
	<%--<shiro:hasPermission name="${pc_basecfg_categorycfg_trustproduct_code}">--%>
		<%--<li class="" ><a href="#" id="tabitem_${pc_basecfg_categorycfg_trustproduct_code}" class="tabitem" >收益权转让产品</a></li>--%>
	<%--</shiro:hasPermission>--%>
<%--</ul>--%>

<%--<div class="tabcont" id="tabcont_${pc_basecfg_categorycfg_newplayerproduct_code}" style="">--%>
	<%--<iframe src="${base}/goto/structureConfig/structureConfigIndex?categoryId=1" width="100%" frameborder="0" width="100%" name="iframe" class="iframe" scrolling="no" style="" title="iframe"></iframe>--%>
<%--</div>--%>
<%--<div class="tabcont" id="tabcont_${pc_basecfg_categorycfg_trustproduct_code}" style="display: none;">--%>
	<%--<iframe src="${base}/goto/structureConfig/structureConfigIndex?categoryId=2" width="100%" frameborder="0" width="100%" name="iframe" class="iframe" scrolling="no" style="" title="iframe"></iframe>--%>
<%--</div>--%>
</body>
</html>