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
	initDynamicSelect('validRules','PC.ValidationRule.Id.Name',"scinput");


	jQuery("#validRuleList").jqGrid({
		url: '${base}/ajax/getdata/structureRuleRelation/paginated.json',
		datatype: 'json',
		colNames: [
			"<msg:message code='validationRule.name'/>",
			"<msg:message code='validationRule.code'/>",
			"<msg:message code='validationRule.value'/>",
			"<msg:message code='validationRule.description'/>",
			"<msg:message code='info.operate'/>"
		],
		colModel: [
			{name:'validationRule.name',index:'name',width:'20%',align:'center',hidden: false,sortable:false},
			{name:'validationRule.code',index:'code',width:'20%',align:'center',hidden: false,sortable:false},
			{name:'validationRule.value',index:'value',width:'20%',align:'center',hidden: false,sortable:false},
			{name:'validationRule.description',index:'description',width:'20%',align:'center',hidden: false,sortable:false},
			{name:'act',index:'act',align:'center',width:'20%',sortable:false,title:false}
		],
		mtype:"POST",
		postData:{c:'${validationRule.c}',productStructureId:'${productStructureId}'},
		rowNum:"-1",
		page:"1",
		rowList: [<msg:message code="validationRule.jqgrid.row.list.s10.10"/>],
		height:'120',
		autowidth: true,
		viewrecords: true,
		multiselect: false,
		jsonReader: {
            id: "validationRuleId", //相当于设置主键
            repeatitems: false
		},
		gridComplete: function(){
			//快捷菜单
			var ids = jQuery("#validRuleList").jqGrid('getDataIDs');
			for(var i=0;i < ids.length;i++){
				var id = ids[i];
				var content = "";

				<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_create_code}">
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
				content += " title='删除'>";
				content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
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
				var ruleId = $(this).attr("id");
                var productStructureId = $("#productStructureId").val();
				var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
					var url = "${base}/ajax/submit/structureRuleRelation/delete.json?isLog=1&productStructureId=" + productStructureId + "&validationRuleId=" + ruleId;
					$.ajax({
						url:url,
						type:'post',
						timeout:'60000',
						dataType:'json',
						success:function(jsonData,textStatus){
							if (textStatus == "success"){
								if (jsonData.status == "success"){
									$("#validRuleList").trigger("reloadGrid");
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
            $("#top_create").click(function(){
                    var ruleId = $("select[name=validRules]").val();
                    var productStructureId = $("#productStructureId").val();
                    if(ruleId == "") {
                        alert("请选择规则！")
                        return;
                    }

                var url = "${base}/ajax/submit/structureRuleRelation/create.json?isLog=1&productStructureId=" + productStructureId + "&validationRuleId=" + ruleId;
                    $.ajax({
                        url:url,
                        type:'post',
                        timeout:'60000',
                        dataType:'json',
                        success:function(jsonData,textStatus){
                            if (textStatus == "success"){
                                if (jsonData.status == "success"){
                                    $("#validRuleList").trigger("reloadGrid");
                                }else{
                                    top.layer.msg("<msg:message code='structureRuleRelationService.create.unique'/>");
                                }
                            }
                        }
                    });
            });
			</shiro:hasPermission>

			$("#validRuleList").closest('.ui-jqgrid-view').find('div.ui-jqgrid-titlebar').remove()
		},
		caption:'<msg:message code="validationRule.list"/>',
		toolbar: [true,"bottom"]
	});
	<shiro:hasPermission name="${pc_basecfg_category_create_code}">
	var $ea = $("<a></a>").attr("href","javascript:void(0)")
			.attr("id","top_create")
			.append($("<img/>").attr("src","${base}/static/images/icon/create.png")
					.attr("width","18").attr("height","18").attr("border","0")
					.attr("border","0").attr("align","absmiddle"))
			.append("添加");

	$("#t_validRuleList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer")
			.append("<span><input name='validRules' /></span>")
			.append($ea));
	</shiro:hasPermission>

});

function submit(){

}

jQuery("#validRuleList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
<input type="hidden" id="productStructureId" value="${productStructureId}">
 	<table width="665" border="0" cellspacing="0" cellpadding="0" >
		<tr>
			<td width="100%" style="padding: 0px;margin: 0px;">
				<table id="validRuleList" ><tr><td>&nbsp;</td></tr></table>
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