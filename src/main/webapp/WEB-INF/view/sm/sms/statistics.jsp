<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<shiro:hasPermission name="${sm_sms_statistics_view_code }">
<script type="text/javascript">
$(document).ready(function(){
	$("#sms_statistics").click(function(){
		$.ajax({
				type: "POST",
			  	url: "${base}/ajax/getdata/businessSend/statistics.json",
			   	data: {startTime:$("#startTime").val(),endTime:$("#endTime").val(),spCode:$("#spCode").val()},
			   	success: function(d){
				try{
				 $("#waitSubmit").text(d.waitSubmit);
				 $("#submitSuccess").text(d.submitSuccess);
				 $("#successSend").text(d.successSend);
				}catch (e) {}
			   },
			   error: function(){alert("查询失败");}
		});
	});
	$("#sms_statistics").click();
});
</script>
</shiro:hasPermission>
</head>
<body class="skinMain">
<div class="list-content">
<shiro:hasPermission name="${sm_sms_statistics_view_code }">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
	<tr>
		<td width="100%">
			<table cellpadding="0" height="85" cellspacing="0" border="1" width="100%">
				<tr>
					<td width="5%">
					</td>
					<td>
						<label for="startTime" style="float:left;line-height:32px;">
							<msg:message code="businessSend.startTime"/>：
						</label>
						<input type="text" name="startTime" id="startTime" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
					</td>
					<td>
						<label for="endTime" style="float:left;line-height:32px;">
							<msg:message code="businessSend.endTime"/>：
						</label>
						<input type="text" name="endTime" id="endTime" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
					</td>
					<td>
						<label for="spCode" style="float:left;line-height:32px; margin-top:2px; display;inline-block; padding-top:7px;">
							<msg:message code="businessSend.channel"/>：
						</label>
						<div class="vocation">
							<select name="spCode" id="spCode" class="select3">
								<option value="">--请选择--</option>
								<c:forEach items="${serviceProviderList }" var="spl">
									<option value="${spl.code }">${spl.name }</option>
								</c:forEach>
							</select>
						</div>
					</td>
					<td rowspan="2" valign="middle">
						<button type="button" id="sms_statistics" class="scbtn" style="width:100px;">查询</button>
					</td>
				</tr>
				<tr>
					<td width="5%">
					</td>
					<td style="font-size: 15px;">
						<msg:message code='businessSend.waitSubmit'/>：
						<span id="waitSubmit" style="color: red;font-weight: bold;"></span>
					</td>
					<td style="font-size: 15px;">
						<msg:message code='businessSend.submitSuccess'/>：
						<span id="submitSuccess" style="color: red;font-weight: bold;"></span>
					</td>
					<td style="font-size: 15px;">
						<msg:message code='businessSend.successSend'/>：
						<span id="successSend" style="color: red;font-weight: bold;"></span>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<script type="text/javascript">
	$('.select3').uedSelect({width:150})
</script>
</shiro:hasPermission>
</div>
</body>
</html>