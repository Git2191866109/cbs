<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<shiro:hasPermission name="${tc_appointment_appointment_code}">
<script type="text/javascript">
$(document).ready(function(){
    jQuery("#appointmentList").jqGrid({
        url: '${base}/ajax/getdata/appointment/selectAppointments.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='appointment.mobilePhone'/>",
			    "<msg:message code='appointment.productName'/>",
			    "<msg:message code='appointment.productCode'/>",
			    "<msg:message code='appointment.appointAmount'/>",
			    "<msg:message code='appointment.shares'/>",
			    "<msg:message code='appointment.appointTime'/>",
			    "<msg:message code='appointment.status'/>",
			    "<msg:message code='appointment.remark'/>",
			    "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'mobilePhone',index:'mobilePhone',width:'10%',align:'center',hidden: false,sortable:false},
			   {name:'productName',index:'productName',width:'15%',align:'center',hidden: false,sortable:false},
			   {name:'productCode',index:'productCode',width:'10%',align:'center',hidden: false,sortable:false},
			   {name:'appointAmount',index:'appointAmount',width:'10%',align:'center',hidden: false,sortable:false},
			   {name:'shares',index:'shares',width:'10%',align:'center',hidden: false,sortable:false},
			   {name:'appointTime',index:'appointTime',width:'10%',align:'center',hidden: false,sortable:false,
				   formatter:'date',formatoptions: {srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
			   {name:'status',index:'status',width:'10%',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
				   		if(cellvalue == "0"){
				   			return "预约失败";
				   		}else if(cellvalue == "1"){
				   			return "预约成功";
				   		}else{
				   			return "未知";
				   		}
			   }},
			   {name:'remark',index:'remark',width:'20%',align:'center',hidden: false,sortable:false},
			   {name:'act',index:'act',align:'center',width:'5%',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${appointment.c}'},
        rowNum:"10",
        page:"1",
        rowList: [<msg:message code="appointment.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="appointment.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#appointmentList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    			jQuery("#appointmentList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}
    	},

    	loadComplete:function(){
    		 $(".shortcut_delete").click(function(){
     	    	var rowid = $(this).attr("id");
     	    	var data = jQuery("#appointmentList").jqGrid("getRowData",rowid);
     	    	var records = $("#appointmentList").getGridParam("records");
     	    	var page = $("#appointmentList").getGridParam("page");
     			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
     				var url = "${base}/ajax/submit/appointment/delete.json?id=" + rowid +"&isLog=1&replaceName="+data.name+"&replace_message_element_name=code";
     				$.ajax({
     					url:url,
     					type:'post',
     					timeout:'60000',
     					dataType:'json',
     					success:function(jsonData,textStatus){
     						if (textStatus == "success"){
     							if (jsonData.status == "success"){
     								for(var i = 1; ;i++){
     									if(records = 10*i+1){
     										jQuery("#appointmentList").setGridParam({page:page-1}).trigger("reloadGrid");
     										break;
     									}
     								}
     								$("#appointmentList").trigger("reloadGrid");
 									top.layer.close(layers);
     							}else{
 									top.layer.msg("<msg:message code='system.prompt.delete.limit'/>");
 								}
     						}
     					}
     				});
     			});
     	    });
    	},
        caption:'<msg:message code="appointment.list"/>'
    });

    $("#appointment_select").click(function(){
       	jQuery("#appointmentList").jqGrid("setGridParam",{
       		postData:{c:'${appointment.c}',mobilePhone:$("#mobilePhone").val(),productName:$("#productName").val(),
        	startTime:$("#startTime").val(),endTime:$("#endTime").val(),status:$("#status").val(),
        	appointAmount:$("#appointAmount").val()}}).trigger("reloadGrid");
    });
});

jQuery("#appointmentList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</shiro:hasPermission>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
<shiro:hasPermission name="${tc_appointment_appointment_code}">
	<tr>
		<td width="100%">
			<table cellpadding="0" height="85" cellspacing="0" border="1" width="100%">
				<tr>
					<td width="5%"></td>
					<td>
						<label for="mobilePhone" style="float:left;line-height: 32px;">
							<msg:message code="appointment.mobilePhone"/>：
						</label>
						<input type="text" name="mobilePhone" id="mobilePhone" class="scinput"/>
					</td>
					<td>
						<label for="productName" style="float:left;line-height: 32px;">
							<msg:message code="appointment.productName"/>：
						</label>
						<input type="text" name="productName" id="productName" class="scinput"/>
					</td>
					<td>
						<label for="status" style="float:left;line-height:32px; margin-top:2px; display;inline-block; padding-top:7px;">
							<msg:message code="appointment.status"/>：
						</label>
						<div class="vocation">
							<select name="status" id="status" class="select3">
								<option value="">--请选择--</option>
								<option value="0">预约失败</option>
								<option value="1">预约成功</option>
							</select>
						</div>
					</td>
					<td rowspan="2" valign="middle">
						<button type="button" id="appointment_select" class="scbtn" style="width:100px;">查询</button>
					</td>
				</tr>
				<tr>
					<td width="5%">
					</td>
					<td>
						<label for="startTime" style="float:left;line-height:32px;">
							<msg:message code="appointment.startTime"/>：
						</label>
						<input type="text" name="startTime" id="startTime" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
					</td>
					<td>
						<label for="endTime" style="float:left;line-height:32px;">
							<msg:message code="appointment.endTime"/>：
						</label>
						<input type="text" name="endTime" id="endTime" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
					</td>
					<td>
						<label for="appointAmount" style="float:left;line-height: 32px;">
							<msg:message code="appointment.appointAmount"/>：
						</label>
						<input type="text" name="appointAmount" id="appointAmount" class="scinput"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	</shiro:hasPermission>
	<tr>
		<td width="100%">
			<form:form method="post" action="appointment" commandName="appointment" name="f">
			<input type="hidden" name="c" value="${appointment.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="appointmentList"><tr><td>&nbsp;</td></tr></table>
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