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
    jQuery("#bankCardChangeApplyList").jqGrid({
        url: '${base}/ajax/getdata/bankCardChangeApply/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='member.name'/>", 
			    "<msg:message code='bankCardChangeApply.cardNumber'/>", 
			    "<msg:message code='bankCardChangeApply.bankAccount'/>", 
			    "<msg:message code='bankCardChangeApply.bankName'/>", 
			    "<msg:message code='bankCardChangeApply.openingBankName'/>", 
			    "<msg:message code='bankCardChangeApply.province'/>", 
			    "<msg:message code='bankCardChangeApply.city'/>", 
			    "<msg:message code='bankCardChangeApply.isValid'/>", 
			    "<msg:message code='bankCardChangeApply.isSafeCard'/>", 
			    "<msg:message code='bankCardChangeApply.applyTime'/>", 
        ],
        colModel: [
			   {name:'member.name',index:'name',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'cardNumber',index:'code',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'bankAccount',index:'startAge',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'bankName',index:'endAge',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'openingBankName',index:'createDate',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'province',index:'act',align:'center',sortable:false,title:false},
			   {name:'city',index:'act',align:'center',sortable:false,title:false},
			   {name:'isValid',index:'act',align:'center',sortable:false,title:false,formatter:function(cellvalue, options, rowObject){
				   if(cellvalue == "1"){
					   return "有效";
				   }else if(cellvalue == "0"){
					   return "无效";
				   }else{
					   return "未知";
				   }
			   }}, 
			   {name:'isSafeCard',index:'act',align:'center',sortable:false,title:false,formatter:function(cellvalue, options, rowObject){
				   if(cellvalue == "0"){
					   return "无效";
				   }else if(cellvalue == "1"){
					   return "有效";
				   }else{
					   return "未知";
				   }
			   }}, 
			   {name:'applyTime',index:'act',align:'center',sortable:false,title:false}
		    ],
        mtype:"POST",
        postData:{c:'${bankCardChangeApply.c}'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="bankCardChangeApply.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="bankCardChangeApply.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
  	  /* 		//快捷菜单
    		var ids = jQuery("#bankCardChangeApplyList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="${eb_budget_grow_modify_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			   /* 	<shiro:hasPermission name="${eb_budget_grow_delete_code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#bankCardChangeApplyList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		} 
    		*/	
    	},
    	loadComplete:function(){
    		/* 	
			<shiro:hasPermission name="${eb_budget_grow_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/bankCardChangeApply/jumpModify?viewCode=${eb_budget_grow_modify_code}&isContextCode=1&id="+rowid;
    	    });     
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${eb_budget_grow_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#bankCardChangeApplyList").jqGrid("getRowData",rowid);
    	    	var records = $("#bankCardChangeApplyList").getGridParam("records");
    	    	var page = $("#bankCardChangeApplyList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/bankCardChangeApply/delete.json?isLog=1&replaceName="+data.name+"&id=" + rowid ;
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
    										jQuery("#bankCardChangeApplyList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#bankCardChangeApplyList").trigger("reloadGrid"); 
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
			<shiro:hasPermission name="${eb_budget_grow_create_code}">
		    $("#top_create","#t_bankCardChangeApplyList").click(function(){
		    	window.location.href = "${base}/goto/bankCardChangeApply/jumpCreate?viewCode=${eb_budget_grow_create_code}&isContextCode=1";
		    });    
		    </shiro:hasPermission>		*/	
    	},
        caption:'<msg:message code="bankCardChangeApply.list"/>',
        toolbar: [true,"top"]
    });
/*     
  //top菜单
	<shiro:hasPermission name="${eb_budget_grow_create_code}">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_bankCardChangeApplyList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
    </shiro:hasPermission>	 */
    
});
jQuery("#bankCardChangeApplyList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
	<tr>
	<td width="100%">
		<form:form method="post" action="bankCardChangeApply" commandName="noticebankCardChangeApply" name="f">
		<input type="hidden" name="c" value="${bankCardChangeApply.c}"/>
		<table cellpadding="0" cellspacing="0" border="0" width="100%">
			<tr>
				<td>
					<table id="bankCardChangeApplyList"><tr><td>&nbsp;</td></tr></table>	
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