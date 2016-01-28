<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<%@ include file="/WEB-INF/view/pc/pccommonhead.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8" src="${base}/static/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${base}/static/js/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${base}/static/js/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
	var height = $(window).height();
	$(".form-content").height(height-120);

	$("input[name=basicProductId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"PC.BasicProduct.Id.Name",dataCond:"",dataHide:"spvId",async:"false",
		onload:function (){
			$.thisObj = $("select[name=basicProductId]");
			var spvId = $.thisObj.find("option:checked").attr("data-hide");
			var condition = "Id=" + spvId;
			$("input[name=spvId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"UC.Organization.Id.Name",dataCond:condition});
			$("select[name=spvId]").val(spvId);
		},
		onchange:function (){
			var spvId = $(this).find("option:selected").attr("data-hide");
			var condition = "Id=" + spvId;
			$("[name=spvId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"UC.Organization.Id.Name",dataCond:condition});
			$("select[name=spvId]").val(spvId);
		}
	});
	$("input[name=assetCategoryCode]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"AA.AssetCategory.Code.Name"});
});

function richtextdeal() {

	$("input[attr=richtext]").each(function(){
		var name = $(this).attr("name");
		if (UE.getEditor(name).hasContents()){
			var content = UE.getEditor(name).getContent();
			$(this).val(content);
//			alert(content);
		}
	});
	return true;
}

//function setContent1(richboxId, isAppendTo) {
//	var arr = [];
//	arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
//	UE.getEditor(richboxId).setContent('欢迎使用ueditor', isAppendTo);
//	alert(arr.join("\n"));
//}
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/product/modify" commandName="product" name="product"  onsubmit="return richtextdeal()" >
<input type="hidden" name="isLog" value="1"/>
<form:hidden path="status" class="dfinput"/>
<input type="hidden" name="viewCode" value="${pc_productmanager_product_newplayerproduct_code}_TAB${categoryId}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${pc_productmanager_product_newplayerproduct_code}_TAB${categoryId},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${pc_productmanager_product_newplayerproduct_cash_code},<msg:message code='button.continue.modify'/>"/>
<form:hidden path="id" />
<form:hidden path="code" />
<form:hidden path="categoryId" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<c:forEach items="${product.productAttributeConfigs}" var="productAttributeConfig" varStatus="status">
				<c:if test="${productAttributeConfig.structureConfig.showType == 9}" ><%-- 隐藏域[hidden] --%>
					<form:hidden path="productAttributeConfigs[${ status.index}].attributeValue" class="dfinput" />
				</c:if>
				<c:if test="${productAttributeConfig.structureConfig.showType != 9}" ><%-- 隐藏域[hidden] --%>
					<li>
						<div class="form-field-title">
								${productAttributeConfig.attribute.name}
							<form:hidden  path="productAttributeConfigs[${ status.index}].id"/>
							<form:hidden  path="productAttributeConfigs[${ status.index}].productId"/>
							<form:hidden  path="productAttributeConfigs[${ status.index}].attributeId"/>
						</div>
						<div class="form-field-elt">
							<c:if test="${productAttributeConfig.structureConfig.showType == 1}" ><%-- 文本框[input] --%>
								<form:input path="productAttributeConfigs[${ status.index}].attributeValue" class="dfinput" />
							</c:if>
							<c:if test="${productAttributeConfig.structureConfig.showType == 2}" ><%-- 下拉选择框[select] --%>
								<%--<script type="text/javascript" >--%>
								<%--$(document).ready(function(e) {--%>
								<%--initSelect('productAttributeConfigs[${ status.index}].attributeValue','PC.Common.SPV',"dfinput");--%>
								<%--});--%>
								<%--</script>--%>
								<%--<form:input path="productAttributeConfigs[${ status.index}].attributeValue" class="dfinput" />--%>
								<form:select  path="productAttributeConfigs[${ status.index}].attributeValue"   items="${productAttributeConfig.options}" class="dfinput"></form:select>
							</c:if>
							<c:if test="${productAttributeConfig.structureConfig.showType == 3}" ><%-- 单选按钮[redio] --%>
								<form:radiobuttons  path="productAttributeConfigs[${ status.index}].attributeValue"   items="${productAttributeConfig.options}" style="margin-left:10px;"></form:radiobuttons>
							</c:if>
							<c:if test="${productAttributeConfig.structureConfig.showType == 4}" ><%-- 复选按钮[checkbox]--%>
								<form:checkboxes  path="productAttributeConfigs[${ status.index}].attributeValue"   items="${productAttributeConfig.options}" style="margin-left:10px;"></form:checkboxes>
							</c:if>
							<c:if test="${productAttributeConfig.structureConfig.showType == 5}" ><%-- 纯文本[textarea] --%>
								<form:textarea path="productAttributeConfigs[${ status.index}].attributeValue" class="textinput"/>
							</c:if>
							<c:if test="${productAttributeConfig.structureConfig.showType == 6}" ><%-- 富文本[richtext] --%>
								<form:hidden  path="productAttributeConfigs[${ status.index}].attributeValue" attr="richtext"></form:hidden>
								<script id="productAttributeConfigs[${ status.index}].attributeValue" type="text/plain" style="width:950px;height:500px;">
									${productAttributeConfig.attributeValue}
								</script>
								<script type="text/javascript">
									var ue = UE.getEditor('productAttributeConfigs[${ status.index}].attributeValue');
									<%--var richtextval = $("input[name='productAttributeConfigs[${ status.index}].attributeValue']").val();--%>
//									ue.setContent('12321321',true); //由于加载未完成，这种方式无效
								</script>
							</c:if>
							<c:if test="${productAttributeConfig.structureConfig.showType == 7}" ><%-- 日期 [date] --%>
								<form:input path="productAttributeConfigs[${ status.index}].attributeValue" readonly="readonly" class="dfinput date twidth Wdate" style="height:30px;"  onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
							</c:if>
							<c:if test="${productAttributeConfig.structureConfig.showType == 8}" ><%-- 时间[datetime] --%>
								<form:input path="productAttributeConfigs[${ status.index}].attributeValue" readonly="readonly" class="dfinput date twidth Wdate" style="height:30px;"  onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
							</c:if>
							<c:if test="${productAttributeConfig.structureConfig.showType == 10}" ><%-- 文本展示[text] --%>
								<form:input path="productAttributeConfigs[${ status.index}].attributeValue" readonly="true" class="dfinput" />
							</c:if>

						</div>
						<div class="form-field-prompt">
							<form:errors path="productAttributeConfigs[${ status.index}].attributeValue" delimiter=" "></form:errors>
						</div>
					</li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
	<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.confirm'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${pc_productmanager_product_newplayerproduct_code}_TAB${categoryId}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>