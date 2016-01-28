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
    jQuery("#userList").jqGrid({
        url: '${base}/ajax/getdata/user/jumpPaginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='user.id'/>", 
			    "<msg:message code='user.organization.name'/>", 
			    "<msg:message code='user.account'/>", 
			    "<msg:message code='user.name'/>", 
			    "<msg:message code='user.position'/>", 
			    "<msg:message code='user.status'/>", 
			    "<msg:message code='user.createTime'/>", 
	            "<msg:message code='info.operate'/>"
		],
        colModel: [
			   {name:'id',index:'id',width:'',align:'center',hidden: true,sortable:false}, 
			   {name:'organization.name',index:'organization.name',width:'15%',align:'center',hidden: false,sortable:false}, 
			   {name:'account',index:'account',width:'10%',align:'center',hidden: false,sortable:false}, 
			   {name:'name',index:'name',width:'10%',align:'center',hidden: false,sortable:false}, 
			   {name:'position',index:'position',width:'10%',align:'center',hidden: false,sortable:false}, 
			   {name:'status',index:'status',width:'5%',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
				   if(cellvalue == "1"){
					   return "启用";
				   }else if(cellvalue == "0"){
					   return "禁用";
				   }
			   }}, 
			   {name:'createTime',index:'createTime',width:'15%',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',width:'35%',align:'center',sortable:false,title:false}
		],
        mtype:"POST",
       // postData:{$("#user_search_form").serialize()},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="user.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="user.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#userList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
    			var datas = jQuery("#userList").jqGrid("getRowData",id);
    			<shiro:hasPermission name="${uc_system_user_disable_code}">	
    			var showName = datas.status == '启用' ? '禁用':'启用';
    			content += "<a href='javascript:void(0)' id='"+id+"' class='shortcut_disable' ";
   				content += " title='" + showName + "'>";
       			content += "<img src='${base}/static/images/icon/Enabled.png'";
   				content += " weight='18' height='18' border='0' align='absmiddle'/>";
   				content += showName;
    			content += "</a>";
    		    </shiro:hasPermission>
    			<shiro:hasPermission name="${uc_system_user_modify_code}">	
    			content += "<a href='javascript:void(0)' id='"+id+"' class='shortcut_modify' ";
    			content += " title='修改信息'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
    			<shiro:hasPermission name="${uc_system_user_resetpwd_code}">	
    			content += "<a href='javascript:void(0)' id='"+id+"' class='shortcut_password' ";
    			content += " title='重置密码'>";
    			content += "<img src='${base}/static/images/icon/password.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "重置密码";
    			content += "</a>";
    		    </shiro:hasPermission>
    		    <shiro:hasPermission name="${uc_system_user_bind_code}">	
    			content += "<a href='javascript:void(0)' id='"+id+"' class='shortcut_config' ";
    			content += " title='绑定角色'>";
    			content += "<img src='${base}/static/images/icon/role.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "绑定角色";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#userList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		//top菜单
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${uc_system_user_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/user/jumpModify?viewCode=${uc_system_user_modify_code}&isContextCode=1&id="+rowid;
    	    });    
    	    </shiro:hasPermission>
    	    <shiro:hasPermission name="${uc_system_user_bind_code}">
    	    $(".shortcut_config").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/role/bind?viewCode=${uc_system_user_bind_code}&id="+rowid;
    	    });    
    	    </shiro:hasPermission>
    	    <shiro:hasPermission name="${uc_system_user_resetpwd_code}">
    	    $(".shortcut_password").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/user/jumpModify?viewCode=${uc_system_user_resetpwd_code}&isContextCode=1&id="+rowid;
    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${uc_system_user_disable_code}">
    	    $(".shortcut_disable").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var datas = jQuery("#userList").jqGrid("getRowData",rowid);
    	    	var showMsg = datas.status == '启用' ? '<msg:message code='system.prompt.disable.confirm'/>"':'<msg:message code='system.prompt.using.confirm'/>';
    	    	var status = datas.status == '启用' ? '0':'1';
    	    	var url = "${base}/ajax/submit/user/forbidden.json?id="+rowid+"&status="+status;
    	    	var records = $("#userList").getGridParam("records");
    	    	var page = $("#userList").getGridParam("page");
    			var layers = top.layer.confirm(showMsg,  function(){
    				$.ajax({
    					url:url,
    					type:'post',
    					timeout:'60000',
    					dataType:'json',
    					success:function(jsonData,textStatus){
    						if (textStatus == "success"){
    							$("#userList").trigger("reloadGrid"); 
    							top.layer.close(layers);			
    						}
    					}
    				});
    			});
    	    });  
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${uc_system_user_create_code}">
		    $("#top_create","#t_userList").click(function(){
		    	window.location.href = "${base}/goto/user/jumpCreate?viewCode=${uc_system_user_create_code}&isContextCode=1";
		    });    
		    </shiro:hasPermission>			
    	},
        caption:'<msg:message code="user.list"/>',
        toolbar: [true,"top"]
    });
	<shiro:hasPermission name="${uc_system_user_create_code}">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_userList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
    </shiro:hasPermission>		
});
jQuery("#userList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="user" commandName="noticeuser" name="f">
			<input type="hidden" name="viewCode" value="${user.viewCode}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="userList"><tr><td>&nbsp;</td></tr></table>	
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