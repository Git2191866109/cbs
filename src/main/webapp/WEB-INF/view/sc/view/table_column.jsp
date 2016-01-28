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
    jQuery("#tableColumnList").jqGrid({
        url: '${base}/ajax/getdata/tableColumn/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='tableColumn.serialVersionUID'/>", 
			    "<msg:message code='tableColumn.id'/>", 
			    "<msg:message code='tableColumn.tableId'/>", 
			    "<msg:message code='tableColumn.objectId'/>", 
			    "<msg:message code='tableColumn.code'/>", 
			    "<msg:message code='tableColumn.name'/>", 
			    "<msg:message code='tableColumn.showName'/>", 
			    "<msg:message code='tableColumn.defaultValue'/>", 
			    "<msg:message code='tableColumn.dataType'/>", 
			    "<msg:message code='tableColumn.length'/>", 
			    "<msg:message code='tableColumn.creationDate'/>", 
			    "<msg:message code='tableColumn.modificationDate'/>", 
			    "<msg:message code='tableColumn.comment'/>", 
			    "<msg:message code='tableColumn.table'/>", 
			    "<msg:message code='tableColumn.tableIndexs'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'serialVersionUID',index:'serialVersionUID',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'id',index:'id',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'tableId',index:'tableId',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'objectId',index:'objectId',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'code',index:'code',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'name',index:'name',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'showName',index:'showName',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'defaultValue',index:'defaultValue',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'dataType',index:'dataType',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'length',index:'length',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'creationDate',index:'creationDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'modificationDate',index:'modificationDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'comment',index:'comment',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'table',index:'table',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'tableIndexs',index:'tableIndexs',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
       // postData:{$("#tableColumn_search_form").serialize()},
        rowNum:"${tableColumn.rows}",    
        page:"${tableColumn.page}",
        rowList: [<msg:message code="tableColumn.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="tableColumn.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#tableColumnList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="201020101">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='页面配置'";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "页面配置";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#tableColumnList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		//top菜单
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="201020101">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/tableColumn/common/201020101?id="+rowid;
    	    });    
    	    </shiro:hasPermission>
    	},
        caption:'<msg:message code="tableColumn.list"/>',
        toolbar: [true,"top"]
    });
});

jQuery("#tableColumnList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="tableColumn" commandName="noticetableColumn" name="f">
			<input type="hidden" name="c" value="${tableColumn.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="tableColumnList"><tr><td>&nbsp;</td></tr></table>	
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