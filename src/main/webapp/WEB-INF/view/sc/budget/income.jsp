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
    jQuery("#residentIncomesList").jqGrid({
        url: '${base}/ajax/getdata/residentIncomes/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='residentIncomes.areaCode'/>", 
			    "<msg:message code='residentIncomes.amount'/>", 
			    "<msg:message code='residentIncomes.isBaseDate'/>", 
			    "<msg:message code='residentIncomes.ratio'/>", 
			    "<msg:message code='residentIncomes.createDate'/>", 
			    "<msg:message code='residentIncomes.modifyDate'/>", 
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'areaCode',index:'areaCode',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'amount',index:'amount',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'isBaseDate',index:'isBaseDate',width:'',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
			   		if(cellvalue == "0"){
			   			return "否";
			   		}else if(cellvalue == "1"){
			   			return "是";
			   		}
		  		}}, 
			   {name:'ratio',index:'ratio',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'createDate',index:'createDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'modifyDate',index:'modifyDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${residentIncomes.c}'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="residentIncomes.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="residentIncomes.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#residentIncomesList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="2050202">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="2050203">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#residentIncomesList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    	
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="2050202">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/residentIncomes/jumpModify/2050202?id="+rowid;
    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="2050203">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#residentIncomesList").jqGrid("getRowData",rowid);
    	    	var records = $("#residentIncomesList").getGridParam("records");
    	    	var page = $("#residentIncomesList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/residentIncomes/delete.json?id=" + rowid + "&prompt=name&name="+encodeURIComponent(encodeURIComponent(data.name));
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
    										jQuery("#residentIncomesList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#residentIncomesList").trigger("reloadGrid"); 
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
			<shiro:hasPermission name="2050201">
		    $("#top_create","#t_residentIncomesList").click(function(){
		    	window.location.href = "${base}/goto/residentIncomes/jumpCreate/2050201";
		    });    
		    </shiro:hasPermission>			
    	},
        caption:'<msg:message code="residentIncomes.list"/>',
        toolbar: [true,"top"]
    });
    
	//top菜单
	<shiro:hasPermission name="2050201">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_residentIncomesList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
    </shiro:hasPermission>		
    
});

jQuery("#residentIncomesList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
		<tr>
		<td width="100%">
			<form:form method="post" action="residentIncomes" commandName="noticeresidentIncomes" name="f">
			<input type="hidden" name="c" value="${residentIncomes.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="residentIncomesList"><tr><td>&nbsp;</td></tr></table>	
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