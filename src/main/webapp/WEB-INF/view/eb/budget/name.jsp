<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript">

var lastsel2;
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
	
	jQuery("#itemFieldList").jqGrid({
        url: '${base}/ajax/getdata/itemField/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='itemField.tableName'/>", 
			    "<msg:message code='itemField.columnCode'/>", 
			    "<msg:message code='itemField.columnName'/>", 
			    "<msg:message code='itemField.columnAlias'/>", 
			    "<msg:message code='itemField.isShow'/>", 
			    "<msg:message code='itemField.showType'/>", 
			    "<msg:message code='itemField.sort'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'tableName',index:'tableName',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'columnCode',index:'columnCode',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'columnName',index:'columnName',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'columnAlias',index:'columnAlias',width:'',align:'center',hidden: false,sortable:false,editable:true}, 
			   {name:'isShow',index:'isShow',width:'',align:'center',hidden: false,sortable:false,editable:true,formatter:'select',edittype:'select',editoptions:{value:"1:是;0:否"}}, 
			   {name:'showType',index:'showType',width:'',align:'center',hidden: false,sortable:false,editable:true,formatter:'select',edittype:'select',editoptions:{value:"1:输入框;2:下拉框;3:复选框;4:单选框;5:文本"}}, 
			   {name:'rank',index:'rank',width:'',align:'center',hidden: false,sortable:false,editable:true}, 
			   {name:'act',index:'act',align:'center',width:'370px',sortable:false,title:false}
        ],
        mtype:"POST",
        rowNum:"10",    
        postData:{categoryId:parseInt($("#budgetCategoryId").val())},
        page:"1",
        rowList: [<msg:message code="itemField.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="itemField.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: false,
        jsonReader: {
        	repeatitems: false
        },
   //     onSelectRow: function(id){
   // 		if(id && id!==lastsel2){
   // 			jQuery('#itemFieldList').jqGrid('restoreRow',lastsel2);
   // 			jQuery('#itemFieldList').jqGrid('editRow',id,true);
  //  			lastsel2=id;
  //  		}
  //  	},
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#itemFieldList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="${eb_budget_name_modify_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
    			<shiro:hasPermission name="${eb_budget_name_modify_code}">	
        		
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
    			</shiro:hasPermission>	
        		
    			<shiro:hasPermission name="${eb_budget_name_setvalue_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_setvalue' ";
    			content += " title='设置值'>";
    			content += "<img src='${base}/static/images/icon/detail.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "设置值";
    			content += "</a>";
    			</shiro:hasPermission>	
    			
			   	<shiro:hasPermission name="${eb_budget_name_delete_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#itemFieldList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${eb_budget_name_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	jQuery("#itemFieldList").jqGrid('editRow',rowid);
    	    });    
    	    </shiro:hasPermission>
    	    
    	    $(".shortcut_save").live("click",( function() {
    	    	
    			var rowid = $(this).attr("id");
    			var data = "columnAlias="+$.trim($("#"+rowid+"_columnAlias").val())+"&isShow="+$.trim($("#"+rowid+"_isShow").val())+"&id="+rowid+"&showType="+$("#"+rowid+"_showType").val()+"&rank="+$("#"+rowid+"_rank").val()+"";
				$.ajax({
					url:"${base}/ajax/submit/itemField/modify.json?isLog=1",
					type:'post',
					data:data,
					timeout:'60000',
					dataType:'json',
					success:function(jsonData,textStatus){
						if (textStatus == "success"){
							$("#itemFieldList").trigger("reloadGrid"); 
						}
					}
				});
    			
    			
    		}));
    	    
    	    $(".shortcut_reset").live("click",( function() {
    			var rowid = $(this).attr("id");
    			jQuery("#itemFieldList").jqGrid('restoreRow',rowid);
    		}));
    	    
			<shiro:hasPermission name="${eb_budget_name_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#itemFieldList").jqGrid("getRowData",rowid);
    	    	var records = $("#itemFieldList").getGridParam("records");
    	    	var page = $("#itemFieldList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/itemField/delete.json?isLog=1&replaceName="+data.name+"&id=" + rowid;
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
    										jQuery("#itemFieldList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#itemFieldList").trigger("reloadGrid"); 
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
			<shiro:hasPermission name="${eb_budget_name_create_code}">
		    $("#top_create","#t_itemFieldList").click(function(){
		    	var bugetId = $('#budgetCategoryId').val();
		    	window.location.href = "${base}/goto/itemField/jumpCreate?viewCode=${eb_budget_name_create_code}&isContextCode=1&categoryId="+ bugetId;
		    });    
		    </shiro:hasPermission>		
		    
		    $(".shortcut_setvalue").click(function(){
		    	var rowid = $(this).attr("id");
		    	window.location.href = "${base}/goto/itemField/jumpSetValue?viewCode=${eb_budget_name_setvalue_code}&isContextCode=1&id="+ rowid;
		    });  
    	},
        caption:'<msg:message code="itemField.list"/>',
        toolbar: [true,"top"]
    });
	
	//top菜单
	<shiro:hasPermission name="${eb_budget_name_create_code}">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_itemFieldList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
    </shiro:hasPermission>		

});

function reload(){
	jQuery("#itemFieldList").jqGrid("setGridParam",{postData:{categoryId:parseInt($("#budgetCategoryId").val())}});
	jQuery("#itemFieldList").trigger("reloadGrid");
}

function show(cellvalue){
   if(cellvalue == 0){
	   return "否";
   }else if(cellvalue == 1){
	   return "是";
   }
}

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
					<td width="15%" valign="top">
						<div class="ui-jqgrid ui-widget ui-widget-content ui-corner-all" id="gbox_dictionaryList" dir="ltr" style="width: 208px; ">
							<div class="ui-jqgrid-view" id="gview_dictionaryList" style="width: 208px; ">
								<div class="ui-jqgrid-view" id="gview_dictionaryList" style="width: 208px; ">
								<div class="ui-jqgrid-titlebar ui-widget-header ui-corner-top ui-helper-clearfix">费用大类</div>
								<div style="width: 208px; height:383px; background:#FFF;" class="ui-state-default ui-jqgrid-hdiv"><div class="ui-jqgrid-hbox" >
									<select id="budgetCategoryId" style="width:208px;height:180px;border:0px;font-size:11pt;" multiple="multiple" onchange="reload();">
									</select>
								</div>
								</div>
								</div>
							</div>
						</div>
					</td>
					<td width="75%" valign="top">
						<table id="itemFieldList"><tr><td>&nbsp;</td></tr></table>	
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