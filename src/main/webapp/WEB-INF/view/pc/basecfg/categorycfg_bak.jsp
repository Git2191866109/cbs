<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<%@ include file="/WEB-INF/view/pc/pccommonhead.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function(){
	initSelect('isShow','PC.Common.Boolean',"dfinput");
	initSelect('isHeader','PC.Common.Boolean',"dfinput");
	initSelect('showType','PC.StructureConfig.ShowType',"dfinput");

	jQuery("#structureConfigList").jqGrid({
        url: '${base}/ajax/getdata/structureConfig/paginated.json',
        datatype: 'json',
        colNames: [
				"<msg:message code='structureConfig.attributeId'/>",
				"<msg:message code='structureConfig.isShow'/>",
				"<msg:message code='structureConfig.isHeader'/>",
				"<msg:message code='structureConfig.showType'/>",
				"<msg:message code='structureConfig.defaultValue'/>",
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
				{name:'attributeId',index:'attributeId',width:'80px',align:'center',hidden: false,sortable:false},
				{name:'isShow',index:'isShow',width:'80px',align:'center',hidden: false,sortable:false},
				{name:'isHeader',index:'isHeader',width:'80px',align:'center',hidden: false,sortable:false},
				{name:'showType',index:'showType',width:'80px',align:'center',hidden: false,sortable:false},
				{name:'defaultValue',index:'defaultValue',width:'80px',align:'center',hidden: false,sortable:false},
				{name:'act',index:'act',align:'center',width:'180px',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${structureConfig.c}'},
        rowNum:"5",
        page:"1",
        rowList: [<msg:message code="structureConfig.jqgrid.row.list.s10.10"/>],
        height:'<msg:message code="structureConfig.jqgrid.height.400"/>',
        autowidth: false,
        viewrecords: true,
        multiselect: false,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#structureConfigList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
    			
			   	<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_modify_code}">
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
				<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_detail_code}">
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_detail' ";
				content += " title='明细'>";
				content += "<img src='${base}/static/images/icon/detail.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "明细";
				content += "</a>";
				</shiro:hasPermission>
			   	<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_delete_code}">
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#structureConfigList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/structureConfig/jumpModify?viewCode=${pc_basecfg_categorycfg_newplayerproduct_modify_code}&isContextCode=1&id="+rowid;
    	    });    
    	    </shiro:hasPermission>

			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#structureConfigList").jqGrid("getRowData",rowid);
    	    	var records = $("#structureConfigList").getGridParam("records");
    	    	var page = $("#structureConfigList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/structureConfig/delete.json?isLog=1&replaceName="+data.name+"&id=" + rowid;
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
    										jQuery("#structureConfigList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#structureConfigList").trigger("reloadGrid");
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
			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_detail_code}">
			$(".shortcut_detail").click(function(){
				var rowid = $(this).attr("id");
				window.location.href="${base}/goto/structureConfig/jumpModify?viewCode=${pc_basecfg_categorycfg_newplayerproduct_detail_code}&isContextCode=1&id="+rowid;
			});
			</shiro:hasPermission>
			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_create_code}">
		    $("#top_create","#t_structureConfigList").click(function(){
		    	window.location.href = "${base}/goto/structureConfig/jumpCreate?viewCode=${pc_basecfg_categorycfg_newplayerproduct_create_code}&isContextCode=1";
		    });    
		    </shiro:hasPermission>
    	},
        caption:'<msg:message code="structureConfig.selAttrList"/>',
        toolbar: [false,"top"]
    });

	jQuery("#unstructureConfigList").jqGrid({
		url: '${base}/ajax/getdata/structureConfig/paginated.json',
		datatype: 'json',
		colNames: [
			"<msg:message code='structureConfig.attributeId'/>",
			"<msg:message code='structureConfig.isShow'/>",
			"<msg:message code='structureConfig.isHeader'/>",
			"<msg:message code='structureConfig.showType'/>",
			"<msg:message code='structureConfig.defaultValue'/>",
			"<msg:message code='info.operate'/>"
		],
		colModel: [
			{name:'attributeId',index:'attributeId',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'isShow',index:'isShow',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'isHeader',index:'isHeader',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'showType',index:'showType',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'defaultValue',index:'defaultValue',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'act',index:'act',align:'center',width:'180px',sortable:false,title:false}
		],
		mtype:"POST",
		postData:{c:'${structureConfig.c}'},
		rowNum:"5",
		page:"1",
		rowList: [<msg:message code="structureConfig.jqgrid.row.list.s10.10"/>],
		height:'<msg:message code="structureConfig.jqgrid.height.400"/>',
		autowidth: false,
		viewrecords: true,
		multiselect: false,
		jsonReader: {
			repeatitems: false
		},
		gridComplete: function(){
			//快捷菜单
			var ids = jQuery("#unstructureConfigList").jqGrid('getDataIDs');
			for(var i=0;i < ids.length;i++){
				var id = ids[i];
				var content = "";

				<shiro:hasPermission name="${pc_basecfg_categorycfg_trustproduct_create_code}">
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_create' ";
				content += " title='添加'>";
				content += "<img src='${base}/static/images/icon/create.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "添加";
				content += "</a>";
				</shiro:hasPermission>
				jQuery("#unstructureConfigList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
			}
		},
		loadComplete:function(){
			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_modify_code}">
			$(".shortcut_modify").click(function(){
				var rowid = $(this).attr("id");
				window.location.href="${base}/goto/structureConfig/jumpModify?viewCode=${pc_basecfg_categorycfg_newplayerproduct_modify_code}&isContextCode=1&id="+rowid;
			});
			</shiro:hasPermission>

			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_delete_code}">
			$(".shortcut_delete").click(function(){
				var rowid = $(this).attr("id");
				var data = jQuery("#structureConfigList").jqGrid("getRowData",rowid);
				var records = $("#structureConfigList").getGridParam("records");
				var page = $("#structureConfigList").getGridParam("page");
				var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
					var url = "${base}/ajax/submit/structureConfig/delete.json?isLog=1&replaceName="+data.name+"&id=" + rowid;
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
											jQuery("#structureConfigList").setGridParam({page:page-1}).trigger("reloadGrid");
											break;
										}
									}
									$("#structureConfigList").trigger("reloadGrid");
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
			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_detail_code}">
			$(".shortcut_detail").click(function(){
				var rowid = $(this).attr("id");
				window.location.href="${base}/goto/structureConfig/jumpDetail?viewCode=${cc_member_account_detail_code}&isContextCode=1&id="+rowid;
			});
			</shiro:hasPermission>
			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_create_code}">
			$("#top_create","#t_structureConfigList").click(function(){
				window.location.href = "${base}/goto/structureConfig/jumpCreate?viewCode=${pc_basecfg_categorycfg_newplayerproduct_create_code}&isContextCode=1";
			});
			</shiro:hasPermission>
		},
		caption:'<msg:message code="structureConfig.unSelAttrList"/>',
		toolbar: [false,"top"]
	});


	jQuery("#validRuleList").jqGrid({
		url: '${base}/ajax/getdata/validationRule/paginated.json',
		datatype: 'json',
		colNames: [
			"<msg:message code='validationRule.name'/>",
			"<msg:message code='validationRule.code'/>",
			"<msg:message code='validationRule.value'/>",
			"<msg:message code='validationRule.description'/>",
			"<msg:message code='info.operate'/>"
		],
		colModel: [
			{name:'name',index:'name',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'code',index:'code',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'value',index:'value',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'description',index:'description',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'act',index:'act',align:'center',width:'80px',sortable:false,title:false}
		],
		mtype:"POST",
		postData:{c:'${validationRule.c}'},
		rowNum:"5",
		page:"1",
		rowList: [<msg:message code="validationRule.jqgrid.row.list.s10.10"/>],
		height:'<msg:message code="validationRule.jqgrid.height.400"/>',
		autowidth: false,
		viewrecords: true,
		multiselect: false,
		jsonReader: {
			repeatitems: false
		},
		gridComplete: function(){
			//快捷菜单
			var ids = jQuery("#validRuleList").jqGrid('getDataIDs');
			for(var i=0;i < ids.length;i++){
				var id = ids[i];
				var content = "";

				<shiro:hasPermission name="${pc_basecfg_categorycfg_trustproduct_create_code}">
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_create' ";
				content += " title='添加'>";
				content += "<img src='${base}/static/images/icon/create.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "添加";
				content += "</a>";
				</shiro:hasPermission>
				jQuery("#validRuleList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
			}
		},
		loadComplete:function(){
			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_modify_code}">
			$(".shortcut_modify").click(function(){
				var rowid = $(this).attr("id");
				window.location.href="${base}/goto/structureConfig/jumpModify?viewCode=${pc_basecfg_categorycfg_newplayerproduct_modify_code}&isContextCode=1&id="+rowid;
			});
			</shiro:hasPermission>

			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_delete_code}">
			$(".shortcut_delete").click(function(){
				var rowid = $(this).attr("id");
				var data = jQuery("#structureConfigList").jqGrid("getRowData",rowid);
				var records = $("#structureConfigList").getGridParam("records");
				var page = $("#structureConfigList").getGridParam("page");
				var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
					var url = "${base}/ajax/submit/structureConfig/delete.json?isLog=1&replaceName="+data.name+"&id=" + rowid;
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
											jQuery("#validationRuleList").setGridParam({page:page-1}).trigger("reloadGrid");
											break;
										}
									}
									$("#structureConfigList").trigger("reloadGrid");
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
			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_detail_code}">
			$(".shortcut_detail").click(function(){
				var rowid = $(this).attr("id");
				window.location.href="${base}/goto/structureConfig/jumpDetail?viewCode=${cc_member_account_detail_code}&isContextCode=1&id="+rowid;
			});
			</shiro:hasPermission>
			<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_create_code}">
			$("#top_create","#t_structureConfigList").click(function(){
				window.location.href = "${base}/goto/structureConfig/jumpCreate?viewCode=${pc_basecfg_categorycfg_newplayerproduct_create_code}&isContextCode=1";
			});
			</shiro:hasPermission>
		},
		caption:'<msg:message code="validationRule.list"/>',
		toolbar: [false,"top"]
	});

});

jQuery("#structureConfigList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
 	<table width="98%" border="0" cellspacing="0" cellpadding="0" >
		<tr>
		<td width="50%">
			<form:form method="post" action="structureConfig" commandName="structureConfig" name="f">
			<input type="hidden" name="c" value="${structureConfig.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="50%">
				<tr>
					<td>
						<table id="structureConfigList"><tr><td>&nbsp;</td></tr></table>
					</td>
				</tr>
			</table>
			</form:form>
		</td>
		<td width="50%" rowspan="2" style="padding: 0px;margin: 0px;">
			<div class="tabRightMain" id ="addDataing" style="padding: 0px;margin: 0px;">
				<form:form method="post" action="${base}/form/submit/structureConfig/create" id="saveItemDate" commandName="structureConfig" name="structureConfig">

				<%--<form method="post" action="#" id="saveItemDate">--%>
					<input type="hidden" name="isLog" value="1"/>
					<div class="form-body" style="padding: 0px;margin: 0px;">
						<div class="form-title" style="width: 200px;"><span><msg:message code='system.prompt.create.info'/></span></div>
						<div class="form-content" style="padding-left: 5px;width:98%;overflow:visible;">
						<ul style="overflow-y:auto;height:100%;width:100%">
							<%--<li>--%>
								<%--<div class="form-field-title">--%>
									<%--<b>*</b><msg:message code='structureConfig.attributeId'/>--%>
								<%--</div>--%>
								<%--<div class="form-field-elt">--%>
									<%--<form:input path="attributeId" class="dfinput"/>--%>
								<%--</div>--%>
								<%--<div class="form-field-prompt">--%>
									<%--<form:errors path="attributeId" delimiter=" "></form:errors>--%>
								<%--</div>--%>
							<%--</li>--%>
							<li>
								<div class="form-field-title">
									<b>*</b><msg:message code='structureConfig.isShow'/>
								</div>
								<div class="form-field-elt">
									<form:input path="isShow" class="dfinput"/>
								</div>
								<div class="form-field-prompt">
									<form:errors path="isShow" delimiter=" "></form:errors>
								</div>
							</li>
							<li>
								<div class="form-field-title">
									<b>*</b><msg:message code='structureConfig.isHeader'/>
								</div>
								<div class="form-field-elt">
									<form:input path="isHeader" class="dfinput"/>
								</div>
								<div class="form-field-prompt">
									<form:errors path="isHeader" delimiter=" "></form:errors>
								</div>
							</li>
							<li>
								<div class="form-field-title">
									<msg:message code='structureConfig.showType'/>
								</div>
								<div class="form-field-elt">
									<form:input path="showType" class="dfinput"/>
								</div>
								<div class="form-field-prompt">
									<form:errors path="showType" delimiter=" "></form:errors>
								</div>
							</li>
							<li>
								<div class="form-field-title">
									<msg:message code='structureConfig.defaultValue'/>
								</div>
								<div class="form-field-elt">
									<form:input path="defaultValue" class="dfinput"/>
								</div>
								<div class="form-field-prompt">
									<form:errors path="defaultValue" delimiter=" "></form:errors>
								</div>
							</li>
						</ul>
							<form:form method="post" action="structureConfig" commandName="structureConfig" name="f">
								<input type="hidden" name="c" value="${structureConfig.c}"/>
								<table cellpadding="0" cellspacing="0" border="0" width="" style="text-align: right;">
									<tr>
										<td style="padding-left: 60px;">
											<table id="validRuleList" ><tr><td>&nbsp;</td></tr></table>
										</td>
									</tr>
								</table>
							</form:form>
							<div class="form-footer">
								<input type="submit" class="btn-80" value="<msg:message code='button.create'/>"/>
							</div>
						</div>

					</div>
				</form:form>


			</div>
		</td>
	</tr>
	<tr>
		<td width="50%"  style="padding-top: 10px;">
			<form:form method="post" action="structureConfig" commandName="structureConfig" name="f">
				<input type="hidden" name="c" value="${structureConfig.c}"/>
				<table cellpadding="0" cellspacing="0" border="0" width="50%">
					<tr>
						<td>
							<table id="unstructureConfigList"><tr><td>&nbsp;</td></tr></table>
						</td>
					</tr>
				</table>
			</form:form>
		</td>
		<td>

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
</body>
</html>