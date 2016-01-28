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
	
	var option = "";
	<c:forEach var="item" items="${budgetCategoryList}" varStatus="pt">
		option += "<option value= "+'${item.id}' +">"+'${item.name}'+"</option>";
	</c:forEach>
	$("#budgetCategoryId").text("");
	$("#budgetCategoryId").append(option);
	if(option != null){
		$("#budgetCategoryId option:first").attr("selected","selected");
		$("#budgetCategoryId").trigger("onchange");
	}
	
    jQuery("#budgetItemList").jqGrid({
        url: '${base}/ajax/getdata/budgetItem/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='budgetItem.budgetCategoryId'/>", 
			    "<msg:message code='budgetItem.parentId'/>", 
			    "<msg:message code='budgetItem.name'/>", 
			    "<msg:message code='budgetItem.code'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'budgetCategoryId',index:'budgetCategoryId',width:'1',align:'center',hidden: true,sortable:false}, 
			   {name:'parentId',index:'parentId',width:'1',align:'center',hidden: true,sortable:false}, 
			   {name:'name',index:'name',width:'60px',align:'center',hidden: false,sortable:false}, 
			   {name:'code',index:'code',width:'60px',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
        rowNum:"10",    
        postData:{budgetCategoryId:parseInt($("#budgetCategoryId").val())},
        page:"1",
        rowList: [<msg:message code="budgetItem.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="budgetItem.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: false,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#budgetItemList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
    			<shiro:hasPermission name="${eb_budget_item_child_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_child' ";
    			content += " title='添加下级'>";
    			content += "<img src='${base}/static/images/icon/detail.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "添加下级";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="${eb_budget_item_modify_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			 /*   	<shiro:hasPermission name="${eb_budget_item_delete_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission> */
    			jQuery("#budgetItemList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${eb_budget_item_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/budgetItem/jumpModify?viewCode=${eb_budget_item_modify_code}&isContextCode=1&id="+rowid;
    	    });    
    	    </shiro:hasPermission>
    	    
    	    <shiro:hasPermission name="${eb_budget_item_child_code}">
    	    $(".shortcut_child").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/budgetItem/jumpChild?viewCode=${eb_budget_item_child_code}&isContextCode=1&id="+rowid;
    	    });    
    	    </shiro:hasPermission>
    	    
		/* 	<shiro:hasPermission name="${eb_budget_item_delete_code}">
    	    $(".shortcut_delete").click(function(){
   				var rowid = $(this).attr("id");
   				var page = $("#budgetItemList").getGridParam("page");
   		    	var data = jQuery("#budgetItemList").jqGrid("getRowData",rowid);
   		 		$.ajax({
    				url:"${base}/ajax/submit/budgetItem/selectSubLevel.json?id=" + rowid,
    				type:'post',
    				timeout:'60000',
    				dataType:'json',
    				success:function(jsonData,textStatus){
    					if (textStatus == "success"){
    						if (jsonData.status == "success"){
    							var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    								var url = "${base}/ajax/submit/budgetItem/delete.json?isLog=1&replaceName="+data.name+"&id=" + rowid;
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
    			    										jQuery("#budgetItemList").setGridParam({page:page-1}).trigger("reloadGrid");
    			    										break;
    			    									}
    			    								}
    			    								$("#budgetItemList").trigger("reloadGrid"); 
    												top.layer.close(layers);									
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
    	    </shiro:hasPermission> */
			<shiro:hasPermission name="${eb_budget_item_create_code}">
		    $("#top_create","#t_budgetItemList").click(function(){
		    	var bugetId = $('#budgetCategoryId').val();
		    	window.location.href = "${base}/goto/budgetItem/jumpCreate?viewCode=${eb_budget_item_create_code}&isContextCode=1&budgetCategoryId="+ bugetId;
		    });    
		    </shiro:hasPermission>			
    	},
    	
    	subGridOptions:{
        	expandOnLoad: false
	    },
        subGrid : true,
        subGridRowExpanded: function(subgrid_id, row_id) {
        	var data = jQuery("#budgetItemList").jqGrid("getRowData",row_id);
	        var subgrid_table_id, pager_id;
			subgrid_table_id = subgrid_id+"_t";
			pager_id = "p_"+subgrid_table_id;
			$("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
			jQuery("#"+subgrid_table_id).jqGrid({
				url:"${base}/ajax/getdata/budgetItem/paginated.json",
				datatype: "json",
				mtype:"POST",
				colNames: [ "<msg:message code='budgetItem.budgetCategoryId'/>", 
						    "<msg:message code='budgetItem.parentId'/>", 
						    "<msg:message code='budgetItem.name'/>", 
						    "<msg:message code='budgetItem.code'/>", 
				            "<msg:message code='info.operate'/>"],
				colModel: [
						   {name:'budgetCategoryId',index:'budgetCategoryId',width:'1',align:'center',hidden: true,sortable:false}, 
						   {name:'parentId',index:'parentId',width:'1',align:'center',hidden: true,sortable:false}, 
						   {name:'name',index:'name',width:'60px',align:'center',hidden: false,sortable:false}, 
						   {name:'code',index:'code',width:'60px',align:'center',hidden: false,sortable:false}, 
						   {name:'act',index:'act',align:'center',sortable:false,title:false,formatter:function(cellvalue, options, rowObject){
							   var rowid = rowObject.id;
							   var subcontent = "";
							   	<shiro:hasPermission name="${eb_budget_item_modify_code}">	
				    			subcontent += "<a href='javascript:void(0);' id='" + rowid + "' class='shortcut_modify' ";
				    			subcontent += " title='修改'>";
				    			subcontent += "<img src='${base}/static/images/icon/modify.png'";
								subcontent += " weight='18' height='18' border='0' align='absmiddle'/>";
								subcontent += "修改";
				    			subcontent += "</a>";
				    		    </shiro:hasPermission>
							   	<shiro:hasPermission name="${eb_budget_item_delete_code}">	
				    			subcontent += "<a href='javascript:void(0);' id='" + rowid + "' class='shortcut_delete' ";
				    			subcontent += " title='删除'>";
				    			subcontent += "<img src='${base}/static/images/icon/delete.png'";
								subcontent += " weight='18' height='18' border='0' align='absmiddle'/>";
								subcontent += "删除";
				    			subcontent += "</a>";
				    		    </shiro:hasPermission>
				    		    return subcontent;
							   
						   }}
						],
				postData:{parentId:row_id},
			   	autowidth: true,
			    height: '100%',
			    multiselect: false,
			    gridComplete:function(){
			    	<shiro:hasPermission name="${eb_budget_item_modify_code}">
		    	    $(".shortcut_modify").click(function(){
		    	    	var rowid = $(this).attr("id");
		    			window.location.href="${base}/goto/budgetItem/jumpModify?viewCode=${eb_budget_item_modify_code}&isContextCode=1&id="+rowid;
		    	    });    
		    	    </shiro:hasPermission>
		    	    
		    	    <shiro:hasPermission name="${eb_budget_item_child_code}">
		    	    $(".shortcut_child").click(function(){
		    	    	var rowid = $(this).attr("id");
		    			window.location.href="${base}/goto/budgetItem/jumpChild?viewCode=${eb_budget_item_child_code}&isContextCode=1&id="+rowid;
		    	    });    
		    	    </shiro:hasPermission>
		    	    
					<shiro:hasPermission name="${eb_budget_item_delete_code}">
		    	    $(".shortcut_delete").click(function(){
		    	    	var rowid = $(this).attr("id");
		    	    	var data = jQuery("#budgetItemList").jqGrid("getRowData",rowid);
		    	    	var records = $("#budgetItemList").getGridParam("records");
		    	    	var page = $("#budgetItemList").getGridParam("page");
		    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
		    				var url = "${base}/ajax/submit/budgetItem/delete.json?isLog=1&id=" + rowid;
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
		    										jQuery("#budgetItemList").setGridParam({page:page-1}).trigger("reloadGrid");
		    										break;
		    									}
		    								}
		    								$("#budgetItemList").trigger("reloadGrid"); 
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
					<shiro:hasPermission name="${eb_budget_item_create_code}">
				    $("#top_create","#t_budgetItemList").click(function(){
				    	var bugetId = $('#budgetCategoryId').val();
				    	window.location.href = "${base}/goto/budgetItem/jumpCreate?viewCode=${eb_budget_item_create_code}&isContextCode=1&budgetCategoryId="+ bugetId;
				    });    
				    </shiro:hasPermission>			
		        },
		        jsonReader: {
		        	repeatitems: false,
		        }
			});
        },
        caption:'<msg:message code="budgetItem.list"/>',
        toolbar: [true,"top"]
    });
	
	//top菜单
	<shiro:hasPermission name="${eb_budget_item_create_code}">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_budgetItemList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
    </shiro:hasPermission>		
    
});

jQuery("#budgetItemList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");

function reload(){
	jQuery("#budgetItemList").jqGrid("setGridParam",{postData:{budgetCategoryId:parseInt($("#budgetCategoryId").val())}});
	jQuery("#budgetItemList").trigger("reloadGrid");
}

</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="budgetItem" commandName="noticebudgetItem" name="f">
			<input type="hidden" name="c" value="${budgetItem.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="15%" valign="top">
						<div class="ui-jqgrid ui-widget ui-widget-content ui-corner-all" dir="ltr" style="width: 208px; ">
							<div class="ui-jqgrid-view" id="gview_dictionaryItemList" style="width: 208px; ">
								<div class="ui-jqgrid-view" id="gview_dictionaryItemList" style="width: 208px; ">
									<div class="ui-jqgrid-titlebar ui-widget-header ui-corner-top ui-helper-clearfix"><msg:message code="budgetCategory.differ"/></div>
									<div style="width: 208px;height:395px;" class="ui-state-default ui-jqgrid-hdiv">
										<div class="ui-jqgrid-hbox">
											<select id="budgetCategoryId" style="width:208px;height:170px;border:0px;font-size:11pt;" multiple="multiple" onchange="reload();">
											</select>
										</div>
									</div>
								</div>
							</div>
						</div>
					</td>
					<td width="75%" valign="top">
						<table id="budgetItemList"><tr><td>&nbsp;</td></tr></table>	
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