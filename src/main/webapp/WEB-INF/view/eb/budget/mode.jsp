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
	<c:forEach var="item" items="${growStagesList}" varStatus="pt">
		option += "<option value= "+'${item.id}' +">"+'${item.name}'+"</option>";
	</c:forEach>
	$("#growStagesId").text("");
	$("#growStagesId").append(option);
	if(option != null){
		$("#growStagesId option:first").attr("selected","selected");
		$("#growStagesId").trigger("onchange");
	}
	
    jQuery("#educationModeList").jqGrid({
        url: '${base}/ajax/getdata/educationMode/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='educationMode.name'/>", 
			    "<msg:message code='educationMode.createDate'/>", 
			    "<msg:message code='educationMode.modifyDate'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'name',index:'name',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'createDate',index:'createDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'modifyDate',index:'modifyDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
        rowNum:"10",    
        postData:{growStagesId:parseInt($("#growStagesId").val())},
        page:"1",
        rowList: [<msg:message code="educationMode.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="educationMode.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#educationModeList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="${eb_budget_mode_modify_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			   /* 	<shiro:hasPermission name="${eb_budget_mode_delete_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission> */
    			jQuery("#educationModeList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${eb_budget_mode_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/educationMode/jumpModify?viewCode=${eb_budget_mode_modify_code}&isContextCode=1&id="+rowid;
    	    });    
    	    </shiro:hasPermission>
		/* 	<shiro:hasPermission name="${eb_budget_mode_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#educationModeList").jqGrid("getRowData",rowid);
    	    	var records = $("#educationModeList").getGridParam("records");
    	    	var page = $("#educationModeList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/educationMode/delete.json?isLog=1&replaceName="+data.name+"&id=" + rowid;
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
    										jQuery("#educationModeList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#educationModeList").trigger("reloadGrid"); 
									top.layer.close(layers);									
    							}else{
									top.layer.msg("<msg:message code='system.prompt.delete.limit'/>");
								}
    						}
    					}
    				});
    			});
    	    });  
    	    </shiro:hasPermission> */
			<shiro:hasPermission name="${eb_budget_mode_create_code}">
		    $("#top_create","#t_educationModeList").click(function(){
		    	var bugetId = $('#growStagesId').val();
		    	window.location.href = "${base}/goto/educationMode/jumpCreate?viewCode=${eb_budget_mode_create_code}&isContextCode=1&growStagesId="+ bugetId;
		    });    
		    </shiro:hasPermission>			
    	},
        caption:'<msg:message code="educationMode.list"/>',
        toolbar: [true,"top"]
    });
	
	//top菜单
	<shiro:hasPermission name="${eb_budget_mode_create_code}">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_educationModeList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
    </shiro:hasPermission>		
    
});

jQuery("#educationModeList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");

function reload(){
	jQuery("#educationModeList").jqGrid("setGridParam",{postData:{growStagesId:parseInt($("#growStagesId").val())}});
	jQuery("#educationModeList").trigger("reloadGrid");
}

</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="educationMode" commandName="educationMode" name="f">
			<input type="hidden" name="c" value="${educationMode.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="15%" valign="top">
						<div class="ui-jqgrid ui-widget ui-widget-content ui-corner-all" dir="ltr" style="width: 208px; ">
							<div class="ui-jqgrid-view" id="gview_dictionaryItemList" style="width: 208px; ">
								<div class="ui-jqgrid-view" id="gview_dictionaryItemList" style="width: 208px; ">
									<div class="ui-jqgrid-titlebar ui-widget-header ui-corner-top ui-helper-clearfix"><msg:message code="growStages.differ"/></div>
									<div style="width: 208px;height:395px;" class="ui-state-default ui-jqgrid-hdiv">
										<div class="ui-jqgrid-hbox">
											<select id="growStagesId" style="width:208px;height:150px;border:0px;font-size:11pt;" multiple="multiple" onchange="reload();">
											</select>
										</div>
									</div>
								</div>
							</div>
						</div>
					</td>
					<td width="75%" valign="top">
						<table id="educationModeList"><tr><td>&nbsp;</td></tr></table>	
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