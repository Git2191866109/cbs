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
    jQuery("#${config.modelNameSuffix?uncap_first}List").jqGrid({
        url: '<#noparse>${</#noparse>base<#noparse>}</#noparse>/ajax/getdata/${config.modelNameSuffix?uncap_first}/paginated.json',
        datatype: 'json',
        colNames: [
		<#if (fileds?size >0) >	
	        <#if (config.shortcuts?size >0)>	
	            <#list fileds as list>
			    "<msg:message code='${config.modelNameSuffix?uncap_first}.${list.name}'/>", 
	            </#list>
	            "<msg:message code='info.operate'/>"
	        <#else>
	       		"<msg:message code='info.unconfig'/>"
	        </#if>
		<#else>
			<#if (config.shortcuts?size >0)>	
	            "<msg:message code='info.operate'/>"
	        <#else>
	       		"<msg:message code='info.unconfig'/>"
	        </#if>
		</#if>
        ],
        colModel: [
        <#if (fileds?size >0)>	
		   <#if (config.shortcuts?size >0)>
			   <#list fileds as list>
			   <#assign hidden="false"/>
			   <#if list.hidden == '1'>
			   <#assign hidden="true"/>	
			   </#if>
			   <#assign sortable="false"/>
			   <#if list.sortable == '1'>
			   <#assign sortable="true"/>	
			   </#if>
			   {name:'${list.name}',index:'${list.name}',width:'${list.width}',align:'${list.align}',hidden: ${hidden},sortable:${sortable}}, 
	           </#list>
			   {name:'act',index:'act',align:'center',sortable:false,title:false}
	    	</#if>       
		<#else>
			<#if (config.shortcuts?size >0)>	
	            {name:'act',index:'act',align:'center',sortable:false,title:false}
	        <#else>
	       		{name:'unconfig',index:'unconfig', width:'100%',align:'center',sortable:false,title:false}
	        </#if>
		</#if>
        ],
        mtype:"POST",
       // postData:{$("#${config.modelNameSuffix?uncap_first}_search_form").serialize()},
        rowNum:"<#noparse>${</#noparse>${config.modelNameSuffix?uncap_first}.rows<#noparse>}</#noparse>",    
        page:"<#noparse>${</#noparse>${config.modelNameSuffix?uncap_first}.page<#noparse>}</#noparse>",
        rowList: [<msg:message code="${config.modelNameSuffix?uncap_first}.jqgrid.row.num.common"/>],
        pager: '#pagered',
        height:'<msg:message code="${config.modelNameSuffix?uncap_first}.jqgrid.height"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#${config.modelNameSuffix?uncap_first}List").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
    			<#list config.shortcuts as shortcutList>
    			<#if shortcutList.menuType?? && shortcutList.menuType?contains('shortcut')>
			   	<shiro:hasPermission name="${shortcutList.code}">	
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_${shortcutList.viewType!""}' ";
    			content += " title='${shortcutList.name}'";
    			content += "<img src='<#noparse>${</#noparse>base<#noparse>}</#noparse>/static/images/icon/${shortcutList.nodeName}.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "${shortcutList.name}";
    			content += "</a>";
    		    </shiro:hasPermission>
    		    </#if>
				</#list>  	
    			jQuery("#${config.modelNameSuffix?uncap_first}List").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    		//top菜单
    		<#list config.shortcuts as shortcutList>
			<#if shortcutList.menuType?? && shortcutList.menuType?contains('top')>
			<shiro:hasPermission name="${shortcutList.code!""}">
		    var $ea = $("<a></a>").attr("href","javascript:void(0)")
		   			  .attr("id","top_${shortcutList.viewType!""}")
		   			  .append($("<img/>").attr("src","<#noparse>${</#noparse>base<#noparse>}</#noparse>/static/images/icon/${shortcutList.nodeName!""}.png")
					  .attr("width","18").attr("height","18").attr("border","0")
					  .attr("border","0").attr("align","absmiddle"))
					  .append("${shortcutList.name}");
		    $("#t_${config.modelNameSuffix?uncap_first}List").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
		    </shiro:hasPermission>		
		</#if>
		</#list> 	
    	},
    	loadComplete:function(){
		<#list config.shortcuts as shortcutList>
		<#if shortcutList.menuType?? && shortcutList.menuType?contains('shortcut')>
			<shiro:hasPermission name="${shortcutList.code}">
    		<#if shortcutList.viewType?? && shortcutList.viewType=='delete'>
    	    $(".shortcut_${shortcutList.viewType}").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#${config.modelNameSuffix?uncap_first}List").jqGrid("getRowData",rowid);
    	    	var records = $("#${config.modelNameSuffix?uncap_first}List").getGridParam("records");
    	    	var page = $("#${config.modelNameSuffix?uncap_first}List").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "<#noparse>${</#noparse>base<#noparse>}</#noparse>/ajax/submit/${config.modelNameSuffix?uncap_first}/delete.json?id=" + rowid + "&prompt=name&name="+encodeURIComponent(encodeURIComponent(data.name));
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
    										jQuery("#${config.modelNameSuffix?uncap_first}List").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#${config.modelNameSuffix?uncap_first}List").trigger("reloadGrid"); 
									top.layer.close(layers);									
    							}else{
									top.layer.msg("<msg:message code='system.prompt.delete.limit'/>");
								}
    						}
    					}
    				});
    			});
    	    });  
    	    <#else>   		
    	    $(".shortcut_${shortcutList.viewType!""}").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="<#noparse>${</#noparse>base<#noparse>}</#noparse>/goto/${config.modelNameSuffix?uncap_first}/common/${shortcutList.code!""}?id="+rowid;
    	    });    
    	    </#if>
    	    </shiro:hasPermission>
	    </#if>
	    </#list> 
	    <#list config.shortcuts as shortcutList>
		<#if shortcutList.menuType?? && shortcutList.menuType?contains('top')>
			<shiro:hasPermission name="${shortcutList.code}">
		    $("#top_${shortcutList.viewType!""}","#t_${config.modelNameSuffix?uncap_first}List").click(function(){
		    	window.location.href = "<#noparse>${</#noparse>base<#noparse>}</#noparse>/goto/${config.modelNameSuffix?uncap_first}/common/${shortcutList.code!""}";
		    });    
		    </shiro:hasPermission>			
		</#if>
		</#list> 	
    	},
        caption:'<msg:message code="${config.modelNameSuffix?uncap_first}.list"/>',
        toolbar: [true,"top"]
    });
});

jQuery("#${config.modelNameSuffix?uncap_first}List").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
	<tr>
		<td width="100%">
			<form:form method="post" action="${config.modelNameSuffix?uncap_first}" commandName="notice${config.modelNameSuffix?uncap_first}" name="f">
			<input type="hidden" name="c" value="<#noparse>${</#noparse>${config.modelNameSuffix?uncap_first}.c<#noparse>}</#noparse>"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="${config.modelNameSuffix?uncap_first}List"><tr><td>&nbsp;</td></tr></table>	
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
</html>