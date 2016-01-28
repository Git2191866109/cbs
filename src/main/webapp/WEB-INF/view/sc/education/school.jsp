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
    jQuery("#schoolList").jqGrid({
        url: '${base}/ajax/getdata/school/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='school.areaCode'/>", 
			    "<msg:message code='school.code'/>", 
			    "<msg:message code='school.name'/>", 
			    "<msg:message code='school.type'/>", 
			    "<msg:message code='school.level'/>", 
			    "<msg:message code='school.address'/>", 
			    "<msg:message code='school.createDate'/>", 
			    "<msg:message code='school.modifyDate'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'areaCode',index:'areaCode',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'code',index:'code',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'name',index:'name',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'type',index:'type',width:'',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
				   if(cellvalue == "1"){
					   return "公立";
				   }else if(cellvalue == "2"){
					   return "私立";
				   }else if(cellvalue == "3"){
					   return "出国";
				   }
			   }}, 
			   {name:'level',index:'level',width:'',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
				   if(cellvalue == "1"){
					   return "大学";
				   }else if(cellvalue == "2"){
					   return "高中";
				   }else if(cellvalue == "3"){
					   return "初中";
				   }else if(cellvalue == "4"){
					   return "小学";
				   }else if(cellvalue =="5"){
					   return "幼儿园";
				   }
			   }}, 
			   {name:'address',index:'address',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'createDate',index:'createDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'modifyDate',index:'modifyDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${school.c}'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="school.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="school.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#schoolList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="2040102">	
    			content += " <a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += " <img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += " 修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="2040103">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += " <img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += " 删除";
    			content += " </a>";
    		    </shiro:hasPermission>
    			jQuery("#schoolList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    	},
    	loadComplete:function(){
    		
			<shiro:hasPermission name="2040102">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/school/jumpModify/2040102?id="+rowid;
    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="2040103">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#schoolList").jqGrid("getRowData",rowid);
    	    	var records = $("#schoolList").getGridParam("records");
    	    	var page = $("#schoolList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/school/delete.json?id=" + rowid + "&prompt=name&name="+encodeURIComponent(encodeURIComponent(data.name));
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
    										jQuery("#schoolList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#schoolList").trigger("reloadGrid"); 
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
			<shiro:hasPermission name="2040101">
		    $("#top_create","#t_schoolList").click(function(){
		    	window.location.href = "${base}/goto/school/jumpCreate/2040101";
		    });    
		    </shiro:hasPermission>			
    	},
        caption:'<msg:message code="school.list"/>',
        toolbar: [true,"top"]
    });
    
    //top菜单
	<shiro:hasPermission name="2040101">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_schoolList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
    </shiro:hasPermission>	
});

jQuery("#schoolList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="school" commandName="noticeschool" name="f" id="school_search_form">
			<input type="hidden" name="c" value="${school.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="schoolList"><tr><td>&nbsp;</td></tr></table>	
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