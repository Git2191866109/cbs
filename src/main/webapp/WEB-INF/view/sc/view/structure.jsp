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
    jQuery("#viewConfigurationList").jqGrid({
        url: '${base}/ajax/getdata/viewConfiguration/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='viewConfiguration.serialVersionUID'/>", 
			    "<msg:message code='viewConfiguration.id'/>", 
			    "<msg:message code='viewConfiguration.authId'/>", 
			    "<msg:message code='viewConfiguration.tableId'/>", 
			    "<msg:message code='viewConfiguration.pageType'/>", 
			    "<msg:message code='viewConfiguration.showType'/>", 
			    "<msg:message code='viewConfiguration.columnSort'/>", 
			    "<msg:message code='viewConfiguration.dataSourcesType'/>", 
			    "<msg:message code='viewConfiguration.dataSources'/>", 
			    "<msg:message code='viewConfiguration.comment'/>", 
			    "<msg:message code='viewConfiguration.code'/>", 
			    "<msg:message code='viewConfiguration.name'/>", 
			    "<msg:message code='viewConfiguration.authorization'/>", 
			    "<msg:message code='viewConfiguration.table'/>", 
			    "<msg:message code='viewConfiguration.viewAttributes'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'serialVersionUID',index:'serialVersionUID',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'id',index:'id',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'authId',index:'authId',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'tableId',index:'tableId',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'pageType',index:'pageType',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'showType',index:'showType',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'columnSort',index:'columnSort',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'dataSourcesType',index:'dataSourcesType',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'dataSources',index:'dataSources',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'comment',index:'comment',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'code',index:'code',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'name',index:'name',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'authorization',index:'authorization',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'table',index:'table',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'viewAttributes',index:'viewAttributes',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
       // postData:{$("#viewConfiguration_search_form").serialize()},
        rowNum:"${viewConfiguration.rows}",    
        page:"${viewConfiguration.page}",
        rowList: [<msg:message code="viewConfiguration.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="viewConfiguration.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#viewConfigurationList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
    			jQuery("#viewConfigurationList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		//top菜单
			<shiro:hasPermission name="2010101">
		    var $ea = $("<a></a>").attr("href","javascript:void(0)")
		   			  .attr("id","top_create")
		   			  .append($("<img/>").attr("src","${base}/static/images/icon/update.png")
					  .attr("width","18").attr("height","18").attr("border","0")
					  .attr("border","0").attr("align","absmiddle"))
					  .append("一键更新");
		    $("#t_viewConfigurationList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
		    </shiro:hasPermission>		
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="2010101">
		    $("#top_create","#t_viewConfigurationList").click(function(){
		    	window.location.href = "${base}/goto/viewConfiguration/common/2010101";
		    });    
		    </shiro:hasPermission>			
    	},
        caption:'<msg:message code="viewConfiguration.list"/>',
        toolbar: [true,"top"]
    });
});

jQuery("#viewConfigurationList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="viewConfiguration" commandName="noticeviewConfiguration" name="f">
			<input type="hidden" name="c" value="${viewConfiguration.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="viewConfigurationList"><tr><td>&nbsp;</td></tr></table>	
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