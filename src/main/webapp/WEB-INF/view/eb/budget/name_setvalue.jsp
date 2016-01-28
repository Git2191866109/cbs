<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function(){
	var count_1;
    jQuery("#itemFieldValueList").jqGrid({
        url: '${base}/ajax/getdata/itemFieldValue/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='itemFieldValue.fieldName'/>", 
			    "<msg:message code='itemFieldValue.fieldValue'/>", 
			    "<msg:message code='info.operate'/>",
			    "<img id='addRow' src='${base}/static/images/icon/Add.png' width='20' height='20' />"
        ],
        colModel: [
			   {name:'fieldName',index:'fieldName',width:'',align:'center',hidden: false,sortable:false,editable:true}, 
			   {name:'fieldValue',index:'fieldValue',width:'',align:'center',hidden: false,sortable:false,editable:true}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false},
			   {name:'space',index:'space',width:'10px',sortable:false}
        ],
        mtype:"POST",
        postData:{itemFieldId:'${itemField.id}'},
        rowNum:"50",    
        page:"1",
        rowList: [<msg:message code="budgetItem.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="budgetItem.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#itemFieldValueList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			
    			count_1 = id;
    			
    			var content = "";
    			var space = "";
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    			
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_save' ";
    			content += " title='保存'>";
    			content += "<img src='${base}/static/images/icon/save.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "保存";
    			content += "</a>";
    			
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_reset' ";
    			content += " title='重置'>";
    			content += "<img src='${base}/static/images/icon/detail.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "重置";
    			content += "</a>";
    			
    			space +="<a href='javascript:void(0);' id='"+count_1+"' sid="+count_1+" class='shortcut_delete' method='add'>";
    			space +="<img src='${base}/static/images/icon/Del.png' width='20' height='20' align='center'/></a>";
    			
    			jQuery("#itemFieldValueList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>",space:space});
    		}	
    	},
    	loadComplete:function(){
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#itemFieldValueList").jqGrid("getRowData",rowid);
    	    	var records = $("#itemFieldValueList").getGridParam("records");
    	    	var page = $("#itemFieldValueList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/itemFieldValue/delete.json?isLog=1&id=" + rowid;
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
    										jQuery("#itemFieldValueList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#itemFieldValueList").trigger("reloadGrid"); 
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
        caption:'<msg:message code="itemFieldValue.list"/>',
        toolbar: [true,"top"]
    });
    
    $('#addRow').click(function(){
    	count_1++;
    	var oper = "";
    	oper += "<a href='javascript:void(0);' id='" + count_1 + "' class='shortcut_modify' ";
		oper += " title='修改'>";
		oper += "<img src='${base}/static/images/icon/modify.png'";
		oper += " weight='18' height='18' border='0' align='absmiddle'/>";
		oper += "修改";
		oper += "</a>";
		oper += "<a href='javascript:void(0);' id='" + count_1 + "' class='shortcut_addsave' ";
		oper += " title='保存'>";
		oper += "<img src='${base}/static/images/icon/save.png'";
		oper += " weight='18' height='18' border='0' align='absmiddle'/>";
		oper += "保存";
		oper += "</a>";
		oper += "<a href='javascript:void(0);' id='" + count_1 + "' class='shortcut_reset' ";
		oper += " title='重置'>";
		oper += "<img src='${base}/static/images/icon/detail.png'";
		oper += " weight='18' height='18' border='0' align='absmiddle'/>";
		oper += "重置";
		oper += "</a>";
		jQuery("#itemFieldValueList").jqGrid('addRowData',count_1,"{}");
		
		var data = {
				fieldName:"<input name='fieldName' id='"+count_1+"_fieldName' maxlength='20' class='valid-control' style='width:98%;'/>",
				fieldValue:"<input name='fieldValue' id='"+count_1+"_fieldValue' maxlength='20' class='valid-control' style='width:98%;'/>",
				act:oper,
				space:"<a href='javascript:void(0);' id='"+count_1+"' sid="+count_1+" class='shortcut_adddelete' method='add'><img src='${base}/static/images/icon/Del.png' width='20' height='20' align='center'/></a>"
		};
		jQuery("#itemFieldValueList").jqGrid('setRowData',count_1,data);
	});	
    
    $(".shortcut_modify").live("click",(function(){
    	var rowid = $(this).attr("id");
    	jQuery("#itemFieldValueList").jqGrid('editRow',rowid);
    }));   
    
    $(".shortcut_reset").live("click",( function() {
		var rowid = $(this).attr("id");
		jQuery("#itemFieldValueList").jqGrid('restoreRow',rowid);
	}));
    
    $(".shortcut_save").live("click",( function() {
		var rowid = $(this).attr("id");
		var data = "fieldName="+$.trim($("#"+rowid+"_fieldName").val())+"&fieldValue="+$.trim($("#"+rowid+"_fieldValue").val())+"&id="+rowid;
		var url = "${base}/ajax/submit/itemFieldValue/modify.json?isLog=1"
		$.ajax({
			url:url,
			type:'post',
			data:data,
			timeout:'60000',
			dataType:'json',
			success:function(jsonData,textStatus){
				if (textStatus == "success"){
					$("#itemFieldValueList").trigger("reloadGrid"); 
				}
			}
		});
	}));
    
    $(".shortcut_addsave").live("click",( function() {
   		var data = "fieldName="+$.trim($("#"+count_1+"_fieldName").val())+"&fieldValue="+$.trim($("#"+count_1+"_fieldValue").val())+"&itemFieldId="+${itemField.id};
		var url = "${base}/ajax/submit/itemFieldValue/create.json?isLog=1"
		$.ajax({
			url:url,
			type:'post',
			data:data,
			timeout:'60000',
			dataType:'json',
			success:function(jsonData,textStatus){
				if (textStatus == "success"){
					$("#itemFieldValueList").trigger("reloadGrid"); 
				}
			}
		});
	}));
    
    $(".shortcut_adddelete").live("click",(function(){
    	var rowid = $(this).attr("sid");
		jQuery("#itemFieldValueList").jqGrid('delRowData',rowid);
    }));  
});

jQuery("#itemFieldValueList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");

</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="itemField" commandName="itemField" name="f">
			<input type="hidden" name="c" value="${itemField.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="75%" valign="top">
						<table id="itemFieldValueList"><tr><td>&nbsp;</td></tr></table>	
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
</html>