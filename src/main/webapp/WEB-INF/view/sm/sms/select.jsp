<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<shiro:hasPermission name="${sm_sms_select_view_code}">
<script type="text/javascript">
$(document).ready(function(){
    jQuery("#businessSendList").jqGrid({
        url: '${base}/ajax/getdata/businessSend/selectAllSms.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='businessSend.mobilePhone'/>", 
			    "<msg:message code='businessSend.content'/>", 
			    "<msg:message code='businessSend.businessType'/>", 
			    "<msg:message code='businessSend.spCode'/>", 
			    "<msg:message code='businessSend.isRetry'/>",
			    "<msg:message code='businessSend.retryCount'/>",
			    "<msg:message code='businessSend.messageSerial'/>",
			    "<msg:message code='businessSend.sendTime'/>",
			    "<msg:message code='businessSend.status'/>",
			    "<msg:message code='businessSend.statusReport'/>",
			    "<msg:message code='businessSend.statements'/>"
        ],
        colModel: [
			   {name:'mobilePhone',index:'mobilePhone',width:'10%',align:'center',hidden: false,sortable:false}, 
			   {name:'content',index:'content',width:'30%',align:'center',hidden: false,sortable:false}, 
			   {name:'businessType',index:'businessType',width:'5%',align:'center',hidden: false,sortable:false}, 
			   {name:'spCode',index:'spCode',width:'5%',align:'center',hidden: false,sortable:false}, 
			   {name:'isRetry',index:'isRetry',width:'5%',align:'center',hidden: false,sortable:false}, 
			   {name:'retryCount',index:'retryCount',width:'5%',align:'center',hidden: false,sortable:false}, 
			   {name:'messageSerial',index:'messageSerial',width:'10%',align:'center',hidden: false,sortable:false}, 
			   {name:'sendTime',index:'sendTime',width:'10%',align:'center',hidden: false,sortable:false,
				   formatter:'date',formatoptions: {srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}}, 
			   {name:'status',index:'status',width:'5%',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
				   		if(cellvalue == "0"){
				   			return "提交成功";
				   		}else if(cellvalue == "1"){
				   			return "提交等待";
				   		}else if (cellvalue == "2") {
				   			return "提交失败";
						}else {
							return ""
						}
			   }}, 
			   {name:'statusReport',index:'statusReport',width:'5%',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
			   		if(cellvalue == "0"){
			   			return "发送成功";
			   		}else if(cellvalue == "1"){
			   			return "发送等待";
			   		}else if (cellvalue == "2") {
			   			return "发送失败";
					}else {
						return "";
					}
			   	}},
			   {name:'statements',index:'statements',width:'10%',align:'center',hidden: false,sortable:false}, 

        ],
        mtype:"POST",
        postData:{c:'${businessSend.c}'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="businessSend.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="businessSend.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    	},
    	
    	loadComplete:function(){
    	},
        caption:'<msg:message code="businessSend.list"/>'
    });
   	 
    $("#sms_select").click(function(){
       	jQuery("#businessSendList").jqGrid("setGridParam",{
       		postData:{c:'${businessSend.c}',mobilePhone:$("#mobilePhone").val(),spCode:$("#spCode").val(),
        	startTime:$("#startTime").val(),endTime:$("#endTime").val(),status:$("#status").val(),
        	statusReport:$("#statusReport").val(),spCode:$("#spCode").val()}}).trigger("reloadGrid");    
    });
});

jQuery("#businessSendList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</shiro:hasPermission>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
<shiro:hasPermission name="${sm_sms_select_view_code}">
	<tr>
		<td width="100%">
			<table cellpadding="0" height="85" cellspacing="0" border="1" width="100%">
				<tr>
					<td width="5%">
					</td>
					<td>
						<label for="nickname" style="float:left;line-height: 32px;">
							<msg:message code="businessSend.mobilePhone"/>：
						</label>
						<input type="text" name="mobilePhone" id="mobilePhone" class="scinput"/>
					</td>
					<td>
						<label for="spCode" style="float:left;line-height:32px; margin-top:2px; display;inline-block; padding-top:7px;">
						<msg:message code="businessSend.channel"/>：
						</label>
						<div class="vocation">
						<select name="spCode" id="spCode" class="select3">
							<option value="">--请选择--</option>
							<c:forEach items="${serviceProviderList}" var="spl">
								<option value="${spl.code }">${spl.name }</option>
							</c:forEach>
						</select>
						</div>
					</td>
					<td>
						<label for="status" style="float:left;line-height:32px; margin-top:2px; display;inline-block; padding-top:7px;">
							<msg:message code="businessSend.status"/>：
						</label>
						<div class="vocation">
							<select name="status" id="status" class="select3">
								<option value="">--请选择--</option>
								<option value="0">提交成功</option>
								<option value="1">提交等待</option>
								<option value="2">提交失败</option>
							</select>
						</div>
					</td>
					<td rowspan="2" valign="middle">
						<button type="button" id="sms_select" class="scbtn" style="width:100px;">查询</button>
					</td>
				</tr>
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
						<label for="statusReport" style="float:left;line-height:32px; margin-top:2px; display;inline-block; padding-top:7px;">
						<msg:message code="businessSend.statusReport"/>：
						</label>
						<div class="vocation">
							<select name="statusReport" id="statusReport" class="select3">
								<option value="">--请选择--</option>
								<option value="0">发送成功</option>
								<option value="1">发送等待</option>
								<option value="2">发送失败</option>
							</select>
						</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	</shiro:hasPermission>
	<tr>
		<td width="100%">
			<form:form method="post" action="businessSend" commandName="businessSend" name="f">
			<input type="hidden" name="c" value="${businessSend.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="businessSendList"><tr><td>&nbsp;</td></tr></table>	
						<div id="pagered"></div>
					</td>
				</tr>
			</table>
			</form:form>
		</td>
	</tr>
	<tr>
		<td class="tableMargin"></td>
	</tr>
	<tr>
		<td></td>
	</tr>
</table>
</div>
<script type="text/javascript">
	$('.select3').uedSelect({width:150})
</script>
</body>
</html>