<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<%@ include file="/WEB-INF/view/pc/pccommonhead.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
	<style type="text/css">
		.editable
		{
			border: 1px solid darkgrey;
			height:25px;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			jQuery("#structureConfigList").jqGrid({
				url: '${base}/ajax/getdata/structureConfig/getStructureConfigHomeList.json',
				datatype: 'json',
//				cellEdit:true,
				colNames: [
					"<msg:message code='attribute.id'/>",
					"<msg:message code='attribute.name'/>",
					"<msg:message code='attribute.code'/>",
					"<msg:message code='structureConfig.isHeader'/>",
					"<msg:message code='structureConfig.showType'/>",
					"<msg:message code='structureConfig.defaultValue'/>",
					"<msg:message code='structureConfig.isDelete'/>",
					"<msg:message code='info.operate'/>"
				],

				colModel: [
					{name:'attributeId',index:'attributeId',width:'',align:'center',hidden: true,sortable:false},
					{name:'attribute.name',index:'attribute.name',width:'15%',align:'center',hidden: false,sortable:false},
					{name:'attribute.code',index:'attribute.code',width:'15%',align:'center',hidden: false,sortable:false},
					{name:'isHeader',index:'isHeader',width:'10%',edittype:'select',editable:true,editoptions: {dataUrl:"${base}/ajax/getdata/dictionary/getJqGridSelectStrByCode.json?name=PC.Common.Boolean"},align:'center',hidden: false,sortable:false, formatter:function(data){ return getDicText("PC.Common.Boolean",data)}},
					{name:'showType',index:'showType',width:'10%',edittype:'select',editable:true,editoptions: {dataUrl:"${base}/ajax/getdata/dictionary/getJqGridSelectStrByCode.json?name=PC.StructureConfig.ShowType"},align:'center',hidden: false,sortable:false, formatter:function(data){ return getDicText("PC.StructureConfig.ShowType",data)}},
					{name:'defaultValue',index:'defaultValue',width:'10%',align:'center',editable:true,hidden: false,sortable:false},
					{name:'isDelete',index:'isDelete',width:'20%',align:'center',hidden: true,sortable:false/*formatter:'checkbox', editoptions:{value:'1:0'}, formatoptions:{disabled:false},align:'center',hidden: false,sortable:false*/},
					{name:'act',index:'act',align:'center',width:'35%',sortable:false,title:false}
				],
				mtype:"POST",
				postData:{c:'${structureConfig.c}',categoryId:'${categoryId}'},
				rowNum:"-1",
				rownumbers:true,
				page:"1",
				rowList: [<msg:message code="structureConfig.jqgrid.row.list.s10.10"/>],
				height:'<msg:message code="structureConfig.jqgrid.height.400"/>',
				autowidth: true,
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
						var orginData = jQuery("#structureConfigList").jqGrid('getRowData', id);
						if(orginData.isDelete == 1 || orginData.isDelete == "") {
							content += func_on(id);
						}else {
							content += func_off(id);
							content += func_modify(id);
							content += func_rule(id);
							content += func_kind(id);

						}

						</shiro:hasPermission>

						jQuery("#structureConfigList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
					}
				},
				loadComplete:function(){
					<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_modify_code}">
					$(".shortcut_modify").click(function(){
						var rowid = $(this).attr("id");
//						alert($(this).attr("title"));
						if($(this).attr("title") == "修改") {
							$(this).attr("title","保存");
							$(this).html("<img src='${base}/static/images/icon/save.png' weight='18' height='18' border='0' align='absmiddle'/>保存");
							jQuery("#structureConfigList").jqGrid('editRow',rowid);
						}else {
							var orginData = jQuery("#structureConfigList").jqGrid('getRowData', rowid);
							var data = "attributeId="+orginData.attributeId
									+"&categoryId=${categoryId }"
									+"&isShow=1"/*+$.trim($("#"+rowid+"_isShow").val())*/
									+"&id="+rowid+"&showType="+$("#"+rowid+"_showType").val()
									+"&isHeader="+$("#"+rowid+"_isHeader").val()
									+"&defaultValue="+$("#"+rowid+"_defaultValue").val()
									+"&isDelete="+orginData.isDelete;
							$.ajax({
								url:"${base}/ajax/submit/structureConfig/save.json?isLog=1",
								type:'post',
								data:data,
								timeout:'60000',
								dataType:'json',
								success:function(jsonData,textStatus){
									if (textStatus == "success"){
										$("#structureConfigList").trigger("reloadGrid");
										$(this).attr("title","修改");
										$(this).html("<img src='${base}/static/images/icon/modify.png' weight='18' height='18' border='0' align='absmiddle'/>修改");
									}
								}
							});
						}

					});
					</shiro:hasPermission>

					<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_modify_code}">
					$(".shortcut_on").click(function(){
						var rowid = $(this).attr("id");
//						alert($(this).attr("title"));
						if($(this).attr("title") == "启用") {
							$(this).attr("title","保存");
							$(this).html("<img src='${base}/static/images/icon/save.png' weight='18' height='18' border='0' align='absmiddle'/>保存");
							jQuery("#structureConfigList").jqGrid('editRow',rowid);
						}else {
							var divObj = $(this).parent();
							var orginData = jQuery("#structureConfigList").jqGrid('getRowData', rowid);
							var data = "attributeId="+orginData.attributeId
									+"&categoryId=${categoryId }"
									+"&isShow=1"/*+$.trim($("#"+rowid+"_isShow").val())*/
									+"&id="+rowid+"&showType="+$("#"+rowid+"_showType").val()
									+"&isHeader="+$("#"+rowid+"_isHeader").val()
									+"&defaultValue="+$("#"+rowid+"_defaultValue").val()
									+"&isDelete=0";
							$.ajax({
								url:"${base}/ajax/submit/structureConfig/save.json?isLog=1",
								type:'post',
								data:data,
								timeout:'60000',
								dataType:'json',
								success:function(jsonData,textStatus){
									if (textStatus == "success"){
										$("#structureConfigList").trigger("reloadGrid");
										<%--$(this).attr("title","启用");--%>
										<%--$(this).html("<img src='${base}/static/images/icon/Add.png' weight='18' height='18' border='0' align='absmiddle'/>启用");--%>

										var content = "";

										content += func_off(rowid);
										content += func_modify(rowid);
										content += func_rule(rowid);

										jQuery("#structureConfigList").jqGrid('setRowData',rowid,{act:"<div class='jqgridContainer'>" + content + "</div>"});
//
//										$(divObj).html(content);

									}
								}
							});

						}

					});
					</shiro:hasPermission>

					<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_delete_code}">
					$(".shortcut_off").click(function(){
						var rowid = $(this).attr("id");
						var orginData = jQuery("#structureConfigList").jqGrid('getRowData', rowid);
						var data = "attributeId="+orginData.attributeId
								+"&id="+rowid
								+"&isDelete=1";

						var layers = top.layer.confirm("<msg:message code='structureConfigService.prompt.off.confirm'/>",  function(){
							$.ajax({
								url:"${base}/ajax/submit/structureConfig/save.json?isLog=1",
								type:'post',
								data:data,
								timeout:'60000',
								dataType:'json',
								success:function(jsonData,textStatus){
									if (textStatus == "success"){
										$("#structureConfigList").trigger("reloadGrid");
										var content = "";
										content += "<a href='javascript:void(0);' id='" + rowid + "' class='shortcut_on' ";
										content += " title='启用'>";
										content += "<img src='${base}/static/images/icon/Add.png'";
										content += " weight='18' height='18' border='0' align='absmiddle'/>";
										content += "启用";
										content += "</a>"
//									alert(content);
										jQuery("#structureConfigList").jqGrid('setRowData',rowid,{act:"<div class='jqgridContainer'>" + content + "</div>"});
//									alert($(this).parent().html());
//									$(this).parent().html(content);

									}
								}
							});
							top.layer.close(layers);
						});

					});
					$(".shortcut_rule").click(function(){
						var rowid = $(this).attr("id");
						var data = jQuery("#attributeList").jqGrid("getRowData",rowid);
						var records = $("#attributeList").getGridParam("records");
						var page = $("#attributeList").getGridParam("page");
						var url = "${base}/goto/structureRuleRelation/structureRuleRelationIndex?productStructureId="+rowid;
						$("#iframe").attr("src",url);
						$(".tip").fadeIn(200);
					});

					$(".shortcut_kind").click(function(){
						var rowid = $(this).attr("id");
						var data = jQuery("#attributeList").jqGrid("getRowData",rowid);
						var records = $("#attributeList").getGridParam("records");
						var page = $("#attributeList").getGridParam("page");
						var url = "${base}/goto/structureKindRelation/structureKindRelationIndex?productStructureId="+rowid;
						$("#iframe").attr("src",url);
						$(".tip").fadeIn(200);
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



			$(".click").click(function(){
				$(".tip").fadeIn(200);
			});

			$(".tiptop a").click(function(){
				$(".tip").fadeOut(200);
			});

			$(".sure").click(function(){
				$("#iframe")[0].contentWindow.submit();
				$(".tip").fadeOut(100);
			});

			$(".cancel").click(function(){
				$(".tip").fadeOut(100);
			});
			$(".tip").hide();

			function func_on(id) {
				var content ="";
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_on' ";
				content += " title='启用'>";
				content += "<img src='${base}/static/images/icon/Add.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "启用";
				content += "</a>";
				return content;
			}

			function func_off(id) {
				var content ="";
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_off' ";
				content += " title='禁用'>";
				content += "<img src='${base}/static/images/icon/Del.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "禁用";
				content += "</a>";
				return content;
			}

			function func_modify(id) {
				var content ="";
				<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_modify_code}">
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
				content += " title='修改'>";
				content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
				content += "</a>";
				</shiro:hasPermission>
				return content;
			}

			function func_rule(id) {
				var content ="";
				<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_detail_code}">
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_rule' ";
				content += " title='规则'>";
				content += "<img src='${base}/static/images/icon/detail.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "规则";
				content += "</a>";
				</shiro:hasPermission>
				return content;
			}

			function func_kind(id) {
				var content ="";
				<shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_detail_code}">
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_kind' ";
				content += " title='分组'>";
				content += "<img src='${base}/static/images/icon/product_attribute.gif'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "分组";
				content += "</a>";
				</shiro:hasPermission>
				return content;
			}
		});

		jQuery("#structureConfigList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
	</script>
</head>
<body class="skinMain">
<table width="98%" border="0" cellspacing="0" cellpadding="0" >
	<tr>
		<td width="100%">
			<form:form method="post" action="structureConfig" commandName="structureConfig" name="f">
				<input type="hidden" name="c" value="${structureConfig.c}"/>
				<table cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td>
							<table id="structureConfigList"><tr><td>&nbsp;</td></tr></table>
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
<div class="tip" style="display: block;">
	<div class="tiptop"><span><msg:message code="validationRule.list"/></span><a></a></div>
	<form:form method="post" action="${base}/form/submit/attribute/create" commandName="attributeDataConfig" name="attribute">
		<div class="tipinfo">
			<div class="form-body">
				<iframe  width="100%" frameborder="0"  id="iframe" name="iframe" class="iframe" scrolling="no" style="" title="iframe" height="200px"></iframe>
			</div>
		</div>

		<div class="tipbtn">
			<input name="" type="button" class="sure" value="确定">&nbsp;
			<input name="" type="button" class="cancel" value="取消">
		</div>
	</form:form>
</div>
</body>
</html>