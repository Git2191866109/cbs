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
    jQuery("#parameterCategoryList").jqGrid({
        url: '${base}/ajax/getdata/parameterCategory/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='parameterCategory.id'/>",
			    "<msg:message code='parameterCategory.code'/>",
			    "<msg:message code='parameterCategory.name'/>",
			    "<msg:message code='parameterCategory.description'/>",

	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'id',index:'id',width:'',align:'center',hidden: true,sortable:false},
			   {name:'code',index:'code',width:'',align:'center',hidden: false,sortable:false},
			   {name:'name',index:'name',width:'',align:'center',hidden: false,sortable:false},
			   {name:'description',index:'description',width:'',align:'center',hidden: false,sortable:false},

			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${parameterCategory.c}'},
        rowNum:"10",
        page:"1",
        rowList: [<msg:message code="parameterCategory.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="parameterCategory.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#parameterCategoryList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="${sc_parameter_parametercategory_modify_code}">	
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="${sc_parameter_parametercategory_delete_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#parameterCategoryList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		//top菜单
			
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${sc_parameter_parametercategory_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
				window.location.href="${base}/goto/parameterCategory/jumpModify?viewCode=${sc_parameter_parametercategory_modify_code}&isContextCode=1&id="+rowid;
    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${sc_parameter_parametercategory_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#parameterCategoryList").jqGrid("getRowData",rowid);
    	    	var records = $("#parameterCategoryList").getGridParam("records");
    	    	var page = $("#parameterCategoryList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
					var url = "${base}/ajax/submit/parameterCategory/delete.json?id=" + rowid+"&isLog=1";
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
    										jQuery("#parameterCategoryList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#t_parameterCategoryList").trigger("reloadGrid"); 
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
			<shiro:hasPermission name="${sc_parameter_parametercategory_create_code}">
		    $("#top_create","#t_parameterCategoryList").click(function(){
				window.location.href = "${base}/goto/parameterCategory/jumpCreate?viewCode=${sc_parameter_parametercategory_create_code}&isContextCode=1&isLog=1";
		    });    
		    </shiro:hasPermission>			
    	},
        caption:'<msg:message code="parameterCategory.list"/>',
        toolbar: [true,"top"]
    });
	<shiro:hasPermission name="${sc_parameter_parametercategory_create_code}">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_parameterCategoryList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));
    </shiro:hasPermission>	
});

jQuery("#parameterCategoryList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="parameterCategory" commandName="noticeparameterCategory" name="f">
			<input type="hidden" name="c" value="${parameterCategory.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="parameterCategoryList"><tr><td>&nbsp;</td></tr></table>	
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
