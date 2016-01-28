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
    jQuery("#tableList").jqGrid({
        url: '${base}/ajax/getdata/table/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='table.serialVersionUID'/>", 
			    "<msg:message code='table.id'/>", 
			    "<msg:message code='table.code'/>", 
			    "<msg:message code='table.objectId'/>", 
			    "<msg:message code='table.name'/>", 
			    "<msg:message code='table.creationDate'/>", 
			    "<msg:message code='table.modificationDate'/>", 
			    "<msg:message code='table.comment'/>", 
			    "<msg:message code='table.tableColumns'/>", 
			    "<msg:message code='table.roleTableRelations'/>", 
			    "<msg:message code='table.viewConfigurations'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'serialVersionUID',index:'serialVersionUID',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'id',index:'id',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'code',index:'code',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'objectId',index:'objectId',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'name',index:'name',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'creationDate',index:'creationDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'modificationDate',index:'modificationDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'comment',index:'comment',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'tableColumns',index:'tableColumns',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'roleTableRelations',index:'roleTableRelations',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'viewConfigurations',index:'viewConfigurations',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
       // postData:{$("#table_search_form").serialize()},
        rowNum:"${table.rows}",    
        page:"${table.page}",
        rowList: [<msg:message code="table.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="table.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#tableList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="2010201">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_list' ";
    			content += " title='字段列表'";
    			content += "<img src='${base}/static/images/icon/column.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "字段列表";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#tableList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		//top菜单
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="2010201">
    	    $(".shortcut_list").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/table/common/2010201?id="+rowid;
    	    });    
    	    </shiro:hasPermission>
    	},
        caption:'<msg:message code="table.list"/>',
        toolbar: [true,"top"]
    });
});

jQuery("#tableList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="table" commandName="noticetable" name="f">
			<input type="hidden" name="c" value="${table.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="tableList"><tr><td>&nbsp;</td></tr></table>	
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