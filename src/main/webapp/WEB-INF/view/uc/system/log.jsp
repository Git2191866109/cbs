<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<style type="text/css">
.select_input input{
		width: 100px;
		height: 30px;
		background-color:#FFFFFF;
		border:#bbb 1px solid;
		padding:2px;
	}
	
	.select_input .date{
		width: 150px;
	}
	
	.select_font{font-size: 12px;}
	.select{
		background-color:#FFFFFF;
		height:35px;
		opacity:100;
		border:#bbb 1px solid;
	}
</style>
<script type="text/javascript">
$(document).ready(function(){
    jQuery("#logList").jqGrid({
        url: '${base}/ajax/getdata/log/paginatedByCondition.json',
        datatype: 'json',
        colNames: [
				"<msg:message code='log.userAccount'/>", 
				"<msg:message code='log.type'/>", 
				"<msg:message code='log.content'/>", 
				"<msg:message code='log.accessIP'/>", 
				"<msg:message code='log.createTime'/>", 
				"<msg:message code='info.operate'/>"
				 ],
        colModel: [
			   {name:'userName',index:'userName',width:'10%',align:'center',hidden: false,sortable:false}, 
			   {name:'type',index:'type',width:'10%',align:'center',hidden: false,sortable:false,
				   formatter:function(cellvalue, options, rowObject){
			   		if(cellvalue == "1"){
			   			return "创建操作";
			   		}else if(cellvalue == "2"){
			   			return "修改操作";
			   		}else if(cellvalue == "3"){
			   			return "删除操作";
			   		}else if(cellvalue == "4"){
			   			return "其他操作";
			   		}
			   	}}, 
			   {name:'content',index:'content',width:'40%',align:'center',hidden: false,sortable:false}, 
			   {name:'accessIP',index:'accessIP',width:'10%',align:'center',hidden: false,sortable:false}, 
			   {name:'createTime',index:'createTime',width:'20%',align:'center',hidden: false,sortable:false,
				   formatter:'date',formatoptions: {srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}}, 
			   {name:'act',index:'act',width:'10%',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${log.c}'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="log.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="log.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#logList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="${uc_system_log_delete_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#logList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${uc_system_log_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#logList").jqGrid("getRowData",rowid);
    	    	var records = $("#logList").getGridParam("records");
    	    	var page = $("#logList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/log/delete.json?id=" + rowid ;
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
    										jQuery("#logList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#logList").trigger("reloadGrid"); 
									top.layer.close(layers);									
    							}else{
									top.layer.msg("<msg:message code='system.prompt.delete.limit'/>");
								}
    						}
    					}
    				});
    			});
    	    });  
    	    </shiro:hasPermission>
    	},
        caption:'<msg:message code="log.list"/>'
    });
	 $("#sms_select").click(function(){
       	 jQuery("#logList").jqGrid("setGridParam",{
	       	postData:{viewCode:'${log.viewCode}',
	       		startTime:$("#startTime").val(),
	       		endTime:$("#endTime").val()
	       	}
         }).trigger("reloadGrid");    
	 });
});
jQuery("#logList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
	<tr>
		<td width="100%">
			<table cellpadding="0" height="60" cellspacing="0" border="1"  width="80%">
				<tr>
					<td width="5%">
					</td>
					<td>
					开始时间：
					<input type="text" name="startTime" id="startTime" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
					结束时间：
					<input type="text" name="endTime" id="endTime" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
					<button   id="sms_select" class="scbtn" style="width: 100px;">查询</button>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td width="100%">
			<form:form method="post" action="log" commandName="log" name="f">
			<input type="hidden" name="viewCode" value="${log.viewCode}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="logList"><tr><td>&nbsp;</td></tr></table>	
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