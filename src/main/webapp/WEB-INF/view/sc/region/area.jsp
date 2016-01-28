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
	
	var height = $(window).height();
	$(".form-content").height(height-170);
	
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
<form:form method="post" action="" commandName="area" name="area">
<div class="form-body">
	<div class="form-title"><span>
	<shiro:hasPermission name="${sc_region_area_create_code}">
	<a style="font-size: 15px;color:blue;" href="${base}/goto/area/jumpCreate/${sc_region_area_create_code}?parentCode=0&treeLevel=0&type=1&add=1">[添加国家]</a>
	</shiro:hasPermission>
	</span></div>
	<div class="form-content">
		<table id="listTable" class="list" >
			<c:forEach items="${areaList0}" var="area0" varStatus="status0">
				<tr style="height:36px;">
					<th colspan="5" class="green" style="text-align: center;width:1000px;height: 10px;">
						顶级地区 - ${area0.name}
						<shiro:hasPermission name="${sc_region_area_create_code}">
							<a href="${base}/goto/area/jumpCreate/${sc_region_area_create_code}?treeLevel=2&type=2&parentCode=${area0.parentCode}&code=${area0.code}">[添加省份]</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="${sc_region_area_modify_code}">
							<a href="${base}/goto/area/jumpModify/${sc_region_area_modify_code}?id=${area0.id}">[编辑]</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="${sc_region_area_delete_code}">
							<a href="" class="delete" id="${area0.id}" >[删除]</a>
						</shiro:hasPermission>
					</th>
				</tr>
				<c:forEach items="${areaList1}" var="area1" varStatus="status1">
				<c:if test="${area0.code eq area1.parentCode }">
					<c:if test="${status1.index % 5 == 0 }">
						<c:set var="countArea" value="${status1.index}"/>
						<tr style="height:36px;">
					</c:if>
						<td>
					<shiro:hasPermission name="${sc_region_area_view_code}">
								<a href="${base}/goto/area/list/${sc_region_area_view_code}?parentCode=${area1.parentCode}&code=${area1.code}&type=${area1.type}&treeLevel=${area1.treeLevel}"  title="查看" style="color: #336699;font-size: 12px;" >${area1.name}</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="${sc_region_area_modify_code}">
								<a href="${base}/goto/area/jumpModify/${sc_region_area_modify_code}?id=${area1.id}" style="color: #336699;font-size: 12px;">[编辑]</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="${sc_region_area_delete_code}">
								<a href="javascript:;" class="delete" id="${area1.id}" style="color: #336699;font-size: 12px;">[删除]</a>
					</shiro:hasPermission>
						</td>
					<c:if test="${status1.index - countArea == 5 && status1.index % 5 == 0 }">
						</tr>
					</c:if>
				</c:if>
				</c:forEach>
			</c:forEach>
		</table>
	</div>
</div>
</form:form>
</body>	
</html>