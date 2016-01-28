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
    jQuery("#educationConfigureList").jqGrid({
        url: '${base}/ajax/getdata/educationConfigure/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='educationConfigure.ids'/>", 
			    "<msg:message code='educationConfigure.serialVersionUID'/>", 
			    "<msg:message code='educationConfigure.id'/>", 
			    "<msg:message code='educationConfigure.eduGoalId_master'/>", 
			    "<msg:message code='educationConfigure.eduGoalId_vice'/>", 
			    "<msg:message code='educationConfigure.createDate'/>", 
			    "<msg:message code='educationConfigure.modifyDate'/>", 
			    "<msg:message code='educationConfigure.creatorId'/>", 
			    "<msg:message code='educationConfigure.educationGoal'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'ids',index:'ids',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'serialVersionUID',index:'serialVersionUID',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'id',index:'id',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'eduGoalId_master',index:'eduGoalId_master',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'eduGoalId_vice',index:'eduGoalId_vice',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'createDate',index:'createDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'modifyDate',index:'modifyDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'creatorId',index:'creatorId',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'educationGoal',index:'educationGoal',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
       // postData:{$("#educationConfigure_search_form").serialize()},
        rowNum:"${educationConfigure.rows}",    
        page:"${educationConfigure.page}",
        rowList: [<msg:message code="educationConfigure.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="educationConfigure.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#educationConfigureList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="4010902">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="4010903">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
			/*  <shiro:hasPermission name="4010905">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_conn' ";
    			content += " title='关联'";
    			content += "<img src='${base}/static/images/icon/conn.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "关联";
    			content += "</a>";
    		    </shiro:hasPermission> */
    			jQuery("#educationConfigureList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		//top菜单
			<shiro:hasPermission name="4010901">
		    var $ea = $("<a></a>").attr("href","javascript:void(0)")
		   			  .attr("id","top_create")
		   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
					  .attr("width","18").attr("height","18").attr("border","0")
					  .attr("border","0").attr("align","absmiddle"))
					  .append("创建");
		    $("#t_educationConfigureList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
		    </shiro:hasPermission>		
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="4010902">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/educationConfigure/common/4010902?id="+rowid;
    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="4010903">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#educationConfigureList").jqGrid("getRowData",rowid);
    	    	var records = $("#educationConfigureList").getGridParam("records");
    	    	var page = $("#educationConfigureList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/educationConfigure/delete.json?id=" + rowid + "&prompt=name&name="+encodeURIComponent(encodeURIComponent(data.name));
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
    										jQuery("#educationConfigureList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#educationConfigureList").trigger("reloadGrid"); 
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
		/* 	<shiro:hasPermission name="4010905">
    	    $(".shortcut_conn").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/educationConfigure/common/4010905?id="+rowid;
    	    });    
    	    </shiro:hasPermission> */
			<shiro:hasPermission name="4010901">
		    $("#top_create","#t_educationConfigureList").click(function(){
		    	window.location.href = "${base}/goto/educationConfigure/common/4010901";
		    });    
		    </shiro:hasPermission>			
    	},
        caption:'<msg:message code="educationConfigure.list"/>',
        toolbar: [true,"top"]
    });
});

jQuery("#educationConfigureList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
	<tr>
	<td width="100%">
		<form:form method="post" action="educationConfigure" commandName="noticeeducationConfigure" name="f">
		<input type="hidden" name="c" value="${educationConfigure.c}"/>
		<table cellpadding="0" cellspacing="0" border="0" width="100%">
			<tr>
				<td>
					<table id="educationConfigureList"><tr><td>&nbsp;</td></tr></table>	
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