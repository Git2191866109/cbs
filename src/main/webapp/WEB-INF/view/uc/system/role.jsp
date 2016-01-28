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
    jQuery("#roleList").jqGrid({
        url: '${base}/ajax/getdata/role/jumpPaginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='role.name'/>", 
			    "<msg:message code='role.description'/>", 
			    "<msg:message code='role.createTime'/>", 
			    "<msg:message code='role.modifyTime'/>" ,
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'name',index:'name',width:'100',align:'center',hidden: false,sortable:false}, 
			   {name:'description',index:'description',width:'100',align:'center',hidden: false,sortable:false}, 
			   {name:'createTime',index:'createTime',width:'100',align:'center',hidden: false,sortable:false}, 
			   {name:'modifyTime',index:'modifyTime',width:'100',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
       // postData:{$("#role_search_form").serialize()},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="role.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="role.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#roleList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="${uc_system_role_modify_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="${uc_system_role_funcauth_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_funcauth' ";
    			content += " title='功能授权'>";
    			content += "<img src='${base}/static/images/icon/audit.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "功能授权";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="${uc_system_role_delete_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#roleList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		//top菜单
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${uc_system_role_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/role/jumpModify?viewCode=${uc_system_role_modify_code}&id="+rowid;
    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${uc_system_role_funcauth_code}">
    	    $(".shortcut_funcauth").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/authorization/bindingauthority?viewCode=${uc_system_role_funcauth_code}&id="+rowid;
    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${uc_system_role_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#roleList").jqGrid("getRowData",rowid);
    	    	var records = $("#roleList").getGridParam("records");
    	    	var page = $("#roleList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/role/delete.json?id=" + rowid + "&isLog=1&replaceName=name&name="+encodeURIComponent(encodeURIComponent(data.name));
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
    										jQuery("#roleList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#roleList").trigger("reloadGrid"); 
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
			<shiro:hasPermission name="${uc_system_role_create_code}">
		    $("#top_create","#t_roleList").click(function(){
		    	window.location.href = "${base}/goto/role/jumpCreate?viewCode=${uc_system_role_create_code}&isContextCode=1";
		    });    
		    </shiro:hasPermission>			
    	},
        caption:'<msg:message code="role.list"/>',
        toolbar: [true,"top"]
    });
    <shiro:hasPermission name="${uc_system_role_create_code}">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_roleList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
    </shiro:hasPermission>	
});
jQuery("#roleList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
	<tr>
		<td width="100%">
			<form:form method="post" action="role" commandName="noticerole" name="f">
			<input type="hidden" name="viewCode" value="${role.viewCode}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="roleList"><tr><td>&nbsp;</td></tr></table>	
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