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
	<c:forEach var="item" items="${growStageList}" varStatus="pt">
		option += "<option value= "+'${item.id}' +">"+'${item.name}'+"</option>";
	</c:forEach>
	$("#growStageId").text("");
	$("#growStageId").append(option);
	if(option != null){
		$("#growStageId option:first").attr("selected","selected");
		$("#growStageId").trigger("onchange");
	}
	
    jQuery("#greadeYearList").jqGrid({
        url: '${base}/ajax/getdata/greadeYear/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='greadeYear.name'/>", 
			    "<msg:message code='greadeYear.greade'/>", 
			    "<msg:message code='greadeYear.startYear'/>", 
			    "<msg:message code='greadeYear.endYear'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'name',index:'name',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'greade',index:'greade',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'startYear',index:'startYear',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'endYear',index:'endYear',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
        rowNum:"10",    
        postData:{growStageId:parseInt($("#growStageId").val())},
        page:"1",
        rowList: [<msg:message code="greadeYear.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="greadeYear.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#greadeYearList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
    			<shiro:hasPermission name="${eb_budget_greade_modify_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    			</shiro:hasPermission >	
    			/* <shiro:hasPermission name="${eb_budget_greade_modify_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    			</shiro:hasPermission>	 */
    			jQuery("#greadeYearList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		
    	},
    	loadComplete:function(){
    		<shiro:hasPermission name="${eb_budget_greade_modify_code}">	
    		
    		$(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/greadeYear/jumpModify?viewCode=${eb_budget_greade_modify_code}&id="+rowid+"&isContextCode=1&growStageId="+parseInt($("#growStageId").val());
    	    });  
    		</shiro:hasPermission >	
    	/* 	<shiro:hasPermission name="${eb_budget_greade_modify_code}">	
    		
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#greadeYearList").jqGrid("getRowData",rowid);
    	    	var records = $("#greadeYearList").getGridParam("records");
    	    	var page = $("#greadeYearList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/greadeYear/delete.json?id=" + rowid+"&replaceName="+data.name+"&isLog=1&growStageId="+parseInt($("#growStageId").val());
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
    										jQuery("#greadeYearList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#greadeYearList").trigger("reloadGrid"); 
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
    		
		    $("#top_create","#t_greadeYearList").click(function(){
		    	var bugetId = $('#growStageId').val();
		    	window.location.href = "${base}/goto/greadeYear/jumpCreate?viewCode=${eb_budget_greade_create_code}&isContextCode=1&growStageId="+ bugetId;
		    });    
    	},
        caption:'<msg:message code="greadeYear.list"/>',
        toolbar: [true,"top"]
    });
	
	//top菜单
	<shiro:hasPermission name="${eb_budget_greade_create_code}">	
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
 	
	$("#t_greadeYearList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
	   </shiro:hasPermission>	

});

jQuery("#greadeYearList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");

function reload(){
	jQuery("#greadeYearList").jqGrid("setGridParam",{postData:{growStageId:parseInt($("#growStageId").val())}});
	jQuery("#greadeYearList").trigger("reloadGrid");
}

</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="greadeYear" commandName="greadeYear" name="f">
			<input type="hidden" name="c" value="${greadeYear.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="15%" valign="top">
						<div class="ui-jqgrid ui-widget ui-widget-content ui-corner-all" dir="ltr" style="width: 208px; ">
							<div class="ui-jqgrid-view" id="gview_dictionaryItemList" style="width: 208px; ">
								<div class="ui-jqgrid-view" id="gview_dictionaryItemList" style="width: 208px; ">
									<div class="ui-jqgrid-titlebar ui-widget-header ui-corner-top ui-helper-clearfix"><msg:message code="growStages.differ"/></div>
									<div style="width: 208px;height:395px;" class="ui-state-default ui-jqgrid-hdiv">
										<div class="ui-jqgrid-hbox">
											<select id="growStageId" style="width:208px;height:150px;border:0px;font-size:11pt;" multiple="multiple" onchange="reload();">
											</select>
										</div>
									</div>
								</div>
							</div>
						</div>
					</td>
					<td width="75%" valign="top">
						<table id="greadeYearList"><tr><td>&nbsp;</td></tr></table>	
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