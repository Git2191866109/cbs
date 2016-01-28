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
    jQuery("#itemFieldValueList").jqGrid({
        url: '${base}/ajax/getdata/itemFieldValue/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='itemFieldValue.serialVersionUID'/>", 
			    "<msg:message code='itemFieldValue.id'/>", 
			    "<msg:message code='itemFieldValue.itemNameId'/>", 
			    "<msg:message code='itemFieldValue.value'/>", 
			    "<msg:message code='itemFieldValue.isValid'/>", 
			    "<msg:message code='itemFieldValue.isDefault'/>", 
			    "<msg:message code='itemFieldValue.year'/>", 
			    "<msg:message code='itemFieldValue.month'/>", 
			    "<msg:message code='itemFieldValue.description'/>", 
			    "<msg:message code='itemFieldValue.createDate'/>", 
			    "<msg:message code='itemFieldValue.modifyDate'/>", 
			    "<msg:message code='itemFieldValue.creatorId'/>", 
			    "<msg:message code='itemFieldValue.itemField'/>", 
			    "<msg:message code='itemFieldValue.itemFieldCollectValues'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'serialVersionUID',index:'serialVersionUID',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'id',index:'id',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'itemNameId',index:'itemNameId',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'value',index:'value',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'isValid',index:'isValid',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'isDefault',index:'isDefault',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'year',index:'year',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'month',index:'month',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'description',index:'description',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'createDate',index:'createDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'modifyDate',index:'modifyDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'creatorId',index:'creatorId',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'itemField',index:'itemField',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'itemFieldCollectValues',index:'itemFieldCollectValues',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
       // postData:{$("#itemFieldValue_search_form").serialize()},
        rowNum:"${itemFieldValue.rows}",    
        page:"${itemFieldValue.page}",
        rowList: [<msg:message code="itemFieldValue.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="itemFieldValue.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#itemFieldValueList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="${eb_budget_value_modify_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="${eb_budget_value_delete_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#itemFieldValueList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		//top菜单
			<shiro:hasPermission name="${eb_budget_value_create_code}">
		    var $ea = $("<a></a>").attr("href","javascript:void(0)")
		   			  .attr("id","top_create")
		   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
					  .attr("width","18").attr("height","18").attr("border","0")
					  .attr("border","0").attr("align","absmiddle"))
					  .append("创建");
		    $("#t_itemFieldValueList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
		    </shiro:hasPermission>		
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${eb_budget_value_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/itemFieldValue/common/${eb_budget_value_modify_code}?id="+rowid;
    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${eb_budget_value_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#itemFieldValueList").jqGrid("getRowData",rowid);
    	    	var records = $("#itemFieldValueList").getGridParam("records");
    	    	var page = $("#itemFieldValueList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/itemFieldValue/delete.json?id=" + rowid;
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
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${eb_budget_value_create_code}">
		    $("#top_create","#t_itemFieldValueList").click(function(){
		    	window.location.href = "${base}/goto/itemFieldValue/common/${eb_budget_value_create_code}";
		    });    
		    </shiro:hasPermission>			
    	},
        caption:'<msg:message code="itemFieldValue.list"/>',
        toolbar: [true,"top"]
    });
});

jQuery("#itemFieldValueList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="itemFieldValue" commandName="noticeitemFieldValue" name="f">
			<input type="hidden" name="c" value="${itemFieldValue.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
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