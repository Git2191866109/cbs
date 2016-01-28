<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function(e) {
	
$(".delete").click(function(){
		
    	var id = $(this).attr("id");
    	
    	$.ajax({
			url:"${base}/ajax/submit/area/selectSubLevel.json?id=" + id,
			type:'post',
			timeout:'60000',
			dataType:'json',
			success:function(jsonData,textStatus){
				if (textStatus == "success"){
					if (jsonData.status == "success"){
						var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
							var url = "${base}/ajax/submit/area/delete.json?id=" + id ;
							$.ajax({
								url:url,
								type:'post',
								timeout:'60000',
								dataType:'json',
								success:function(jsonData,textStatus){
									if (textStatus == "success"){
										if (jsonData.status == "success"){
											top.layer.close(layers);
											window.location.reload();
										}else{
											top.layer.msg("<msg:message code='system.prompt.delete.limit'/>");
										}
									}
								}
							});
						});
					}else{
						top.layer.msg("<msg:message code='system.prompt.delete.limit'/>")
						
					}
				}
			}
		});
    	
    });  
});
</script>
</head>
<body>
<form:form  commandName="area" name="area">
<div class="form-body">
	<div class="form-title">
	<shiro:hasPermission name="${sc_region_area_create_code}">
		<a style="font-size: 15px;color:blue;" href="${base}/goto/area/jumpCreate/${sc_region_area_create_code}?treeLevel=${area.treeLevel+1}&type=${area.type+1}&parentCode=${area.code}">[添加]</a>
	</shiro:hasPermission>
	&nbsp;&nbsp;&nbsp;&nbsp;<a style="font-size: 15px;color:blue;" onclick="javascript:history.back();" href="javascript:void(0);">[返回上一级]</a></div>
	<div class="form-content">
		<table id="listTable" class="list">
		<tr style="height:36px;">
			<th colspan="5" class="green" style="text-align: center;width:1000px;height: 10px;">
			</th>
		</tr>
		<c:forEach items="${areaList}" var="area" varStatus="status">
			<c:if test="${status.index%5 == 0 }">
				<c:set var="countArea" value="${status.index}"/>
				<tr style="height:36px;">
			</c:if>
					<td>
					<shiro:hasPermission name="${sc_region_area_view_code}">
						<a href="${base}/goto/area/list/${sc_region_area_view_code}?parentCode=${area.parentCode}&code=${area.code}&type=${area.type}&treeLevel=${area.treeLevel}" title="查看" style="color: #336699;font-size: 12px;">${area.name}</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="${sc_region_area_modify_code}">
						<a href="${base}/goto/area/jumpModify/${sc_region_area_modify_code}?id=${area.id}" style="color: #336699;font-size: 12px;">[编辑]</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="${sc_region_area_delete_code}">
						<a href="javascript:;" class="delete" id="${area.id}" style="color: #336699;font-size: 12px;">[删除]</a>
					</shiro:hasPermission>
					</td>
			<c:if test="${status.index - countArea == 5 && status.index%5 == 0 }">
				</tr>
			</c:if>
		</c:forEach>
		</table>
	</div>
</div>
</form:form>
</body>	
</html>