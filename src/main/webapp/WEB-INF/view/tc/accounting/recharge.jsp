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

	initDynamicSelect('memberId','CC.Member.Id.Name',"scinput");
	initSelect('status','TC.RechargeRecords.Status',"scinput");


	jQuery("#rechargeRecordsList").jqGrid({
        url: '${base}/ajax/getdata/rechargeRecords/paginated.json',
        datatype: 'json',
		emptyrecords:"无数据",
        colNames: [
			    "<msg:message code='rechargeRecords.memberId'/>",
				"<msg:message code='rechargeRecords.transactionNumber'/>",
				"<msg:message code='rechargeRecords.payPlantformNumber'/>",
				"<msg:message code='rechargeRecords.amount'/>",
				"<msg:message code='rechargeRecords.handlingCharge'/>",
				"<msg:message code='rechargeRecords.applyTime'/>",
			    "<msg:message code='rechargeRecords.status'/>",
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'memberId',index:'memberId',width:'12%',align:'center',hidden: false,sortable:false, formatter:function(data){ return getDicText("CC.Member.Id.Name",data,true)}},
				{name:'transactionNumber',index:'transactionNumber',width:'10%',align:'center',hidden: false,sortable:false},
				{name:'payPlantformNumber',index:'payPlantformNumber',width:'8%',align:'center',hidden: false,sortable:false},
				{name:'amount',index:'amount',width:'8%',align:'center',hidden: false,sortable:false},
				{name:'handlingCharge',index:'handlingCharge',width:'8%',align:'center',hidden: false,sortable:false},
			    {name:'applyTime',index:'applyTime',width:'14%',align:'center',hidden: false,sortable:false},
				{name:'status',index:'status',width:'14%',align:'center',hidden: false,sortable:false, formatter:function(data){ return getDicText("TC.RechargeRecords.Status",data)}},
			{name:'act',index:'act',align:'center',width:'20%',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${rechargeRecords.c}'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="rechargeRecords.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="rechargeRecords.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#rechargeRecordsList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";

				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_detail' ";
				content += " title='明细'>";
				content += "<img src='${base}/static/images/icon/detail.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "明细";
				content += "</a>";


    			jQuery("#rechargeRecordsList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    	},
    	loadComplete:function(){

			$(".shortcut_detail").click(function(){
				var rowid = $(this).attr("id");
				window.location.href="${base}/goto/rechargeRecords/jumpModify?id="+rowid;

			});
    	},
        caption:'<msg:message code="rechargeRecords.list"/>',
        toolbar: [true,"top"]
    });

	$("#qryBtn").click(function(){
		jQuery("#rechargeRecordsList").jqGrid("setGridParam",{postData:{
			memberId:$("#memberId").val(),
			transactionNumber:$("#transactionNumber").val(),
			payPlantformNumber:$("#payPlantformNumber").val(),
			status:$("#status").val(),
//			applyTime:$("#applyTime").val(),
			applyTimeStartTime:$("#applyTimeStartTime").val(),
			applyTimeEndTime:$("#applyTimeEndTime").val(),
		}
		}).trigger("reloadGrid");
	});

});

jQuery("#rechargeRecordsList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<table cellpadding="0" height="85" cellspacing="0" border="1" width="100%">
				<tr>
					<td width="5%">
					</td>
					<td>
						<label for="memberId" style="float:right;line-height: 32px;"><msg:message code='rechargeRecords.memberId'/>：</label>
					</td>
					<td>
						<input type="text" name="memberId" id="memberId" value="${rechargeRecords.memberId}" class="scinput"/>
					</td>
					<td>
						<label for="transactionNumber" style="float:right;line-height: 32px;"><msg:message code='rechargeRecords.transactionNumber'/>：</label>
					</td>
					<td>
						<input type="text" name="transactionNumber" id="transactionNumber" value="${rechargeRecords.transactionNumber}" class="scinput"/>
					</td>
					<td>
						<label for="payPlantformNumber" style="float:right;line-height: 32px;"><msg:message code='rechargeRecords.payPlantformNumber'/>：</label>
					</td>
					<td>
						<input type="text" name="payPlantformNumber" id="payPlantformNumber" value="${rechargeRecords.payPlantformNumber}" class="scinput"/>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td width="5%">
					</td>
					<td>
						<label for="status" style="float:right;line-height: 32px;"><msg:message code='rechargeRecords.status'/>：</label>
					</td>
					<td>
						<input type="text" name="status" id="status" value="${rechargeRecords.status}" class="scinput"/>

					</td>
					<td>
						<label for="applyTimeStartTime" style="float:right;line-height: 32px;"><msg:message code='rechargeRecords.applyTime'/>：</label>
					</td>
					<td>
						<%--<input type="text" name="applyTime" id="applyTime" value="${rechargeRecords.applyTime}" class="scinput"/>--%>
						<input type="text" name="startTime" id="applyTimeStartTime" readonly="readonly" style="width:100px;" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
						<span>~</span>
						<input type="text" name="endTime" id="applyTimeEndTime" readonly="readonly" style="width:100px;"  class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
					</td>
					<td>
						<%--<label for="startTime" style="float:right;line-height: 32px;"><msg:message code='rechargeRecords.createTime'/>：</label>--%>
					</td>
					<td>
						<%--<input type="text" name="startTime" id="startTime" readonly="readonly" style="width:100px;" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>--%>
						<%--<span>~</span>--%>
						<%--<input type="text" name="endTime" id="endTime" readonly="readonly" style="width:100px;"  class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>--%>
					</td>
					<td rowspan="2" valign="middle">
						<shiro:hasPermission name="${3010105}">
							<button  id="qryBtn" onclick="" class="scbtn" style="width: 100px;">查询</button>
						</shiro:hasPermission>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td width="100%">
			<form:form method="post" action="rechargeRecords" commandName="rechargeRecords" name="f">
			<input type="hidden" name="c" value="${rechargeRecords.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="rechargeRecordsList"><tr><td>&nbsp;</td></tr></table>
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
</body>
</html>