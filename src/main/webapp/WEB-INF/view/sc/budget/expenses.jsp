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
    jQuery("#costLevelList").jqGrid({
        url: '${base}/ajax/getdata/costLevel/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='costLevel.name'/>", 
			    "<msg:message code='costLevel.level'/>", 
			    "<msg:message code='costLevel.isValid'/>", 
			    "<msg:message code='costLevel.createDate'/>", 
			    "<msg:message code='costLevel.modifyDate'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'name',index:'name',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'level',index:'level',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'isValid',index:'isValid',width:'',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
				   		if(cellvalue == "0"){
				   			return "无效";
				   		}else if(cellvalue == "1"){
				   			return "有效";
				   		}
			   }}, 
			   {name:'createDate',index:'createDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'modifyDate',index:'modifyDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${costLevel.c}'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="costLevel.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="costLevel.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#costLevelList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="2050102">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="2050103">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#costLevelList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="2050102">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/costLevel/jumpModify/2050102?id="+rowid;
    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="2050103">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#costLevelList").jqGrid("getRowData",rowid);
    	    	var records = $("#costLevelList").getGridParam("records");
    	    	var page = $("#costLevelList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/costLevel/delete.json?id=" + rowid + "&prompt=name&name="+encodeURIComponent(encodeURIComponent(data.name));
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
    										jQuery("#costLevelList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#costLevelList").trigger("reloadGrid"); 
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
			<shiro:hasPermission name="2050101">
		    $("#top_create","#t_costLevelList").click(function(){
		    	window.location.href = "${base}/goto/costLevel/jumpCreate/2050101";
		    });    
		    </shiro:hasPermission>			
    	},
        caption:'<msg:message code="costLevel.list"/>',
        toolbar: [true,"top"]
    });
    
  //top菜单
	<shiro:hasPermission name="2050101">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_costLevelList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
    </shiro:hasPermission>		
});

jQuery("#costLevelList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="costLevel" commandName="costLevel" name="f">
			<input type="hidden" name="c" value="${costLevel.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="costLevelList"><tr><td>&nbsp;</td></tr></table>	
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