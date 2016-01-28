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
<style type="text/css">
	.form-content li .form-field-elt {
		width:330px;
	}


</style>
<script type="text/javascript">
$(document).ready(function(e) {
	var height = $(window).height();
	$(".form-content").height(height-120);
	$("input[name=basicProductId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"PC.BasicProduct.Id.Name",dataCond:"",dataHide:"SpvId",async:false,
		onload:function (){
			$.thisObj = $("select[name=basicProductId]");
			var spvId = $.thisObj.find("option:checked").attr("data-hide");
			var condition = "Id=" + spvId;
			$("input[name=spvId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"CC.SpvCorporation.Id.Name",dataCond:condition,async:false});
			$("[name=spvId]").val(spvId);
		},
		onchange:function (){
			var spvId = $(this).find("option:selected").attr("data-hide");
			var condition = "Id=" + spvId;
			$("[name=spvId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"CC.SpvCorporation.Id.Name",dataCond:condition,async:false});
			$("select[name=spvId]").val(spvId);
		}
	});


//	$("input[name=basicProductId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"PC.BasicProduct.Id.Name"});
//	$("input[name=spvId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"CC.SpvCorporation.Code.Name",dataCond:"Type=2"});
	$("input[name=assetCategoryCode]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"AA.AssetCategory.Code.Name"});
//	$("input[name=viewName]").initCol({tagClass:"dfinput",dataCode:"PC.Product.ViewName"});




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

</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/product/create" commandName="product" name="product" onsubmit="return richtextdeal()" >
<form:input path="categoryId" class="" type="hidden" value="${categoryId}"/>
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${pc_productmanager_product_newplayerproduct_code}_TAB${categoryId}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${pc_productmanager_product_newplayerproduct_code}_TAB${categoryId},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${pc_productmanager_product_newplayerproduct_create_code},<msg:message code='button.continue.create'/>"/>

<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='product.basicProductId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="basicProductId" class="dfinput"/>
				</div>
				<div class="form-field-desc">

				</div>
				<div class="form-field-prompt">
					<form:errors path="basicProductId" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='product.spvId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="spvId" class="dfinput"/>
				</div>
				<div class="form-field-desc">

				</div>
				<div class="form-field-prompt">
					<form:errors path="spvId" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='product.assetCategoryCode'/>
				</div>
				<div class="form-field-elt">
					<form:input path="assetCategoryCode" class="dfinput"/>
				</div>
				<div class="form-field-desc">

				</div>
				<div class="form-field-prompt">
					<form:errors path="assetCategoryCode" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='product.name'/>
				</div>
				<div class="form-field-elt">
						<form:input path="name" class="dfinput"/>
				</div>
				<div class="form-field-desc">

				</div>
				<div class="form-field-prompt">
					<form:errors path="name" delimiter=" "></form:errors>
				</div>
			</li>
			<%--<li>--%>
				<%--<div class="form-field-title">--%>
					<%--<b>*</b><msg:message code='product.code'/>--%>
				<%--</div>--%>
				<%--<div class="form-field-elt">--%>
					<%--<form:input path="code" class="dfinput"/>--%>
				<%--</div>--%>
				<%--<div class="form-field-prompt">--%>
					<%--<form:errors path="code" delimiter=" "></form:errors>--%>
				<%--</div>--%>
			<%--</li>--%>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='product.totalAmount'/>
				</div>
				<div class="form-field-elt">
					<form:input path="totalAmount" class="dfinput"/>
				</div>
				<div class="form-field-desc">

				</div>
				<div class="form-field-prompt">
					<form:errors path="totalAmount" delimiter=" "></form:errors>
				</div>

			</li>
			<%--<li>--%>
				<%--<div class="form-field-title">--%>
					<%--<b>*</b><msg:message code='product.surplusAmount'/>--%>
				<%--</div>--%>
				<%--<div class="form-field-elt">--%>
					<%--<form:input path="surplusAmount" class="dfinput" readonly="readonly"/>--%>
				<%--</div>--%>
				<%--<div class="form-field-prompt">--%>
					<%--<form:errors path="surplusAmount" delimiter=" "></form:errors>--%>
				<%--</div>--%>
			<%--</li>--%>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='product.firstPublishTime'/>
				</div>
				<div class="form-field-elt">
					<form:input path="firstPublishTime"  readonly="readonly" style="width:345px;" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>

				</div>
				<div class="form-field-prompt">
					<form:errors path="firstPublishTime" delimiter=" "></form:errors>
				</div>
			</li>
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
						<div class="form-field-desc">
							${productAttributeConfig.attribute.description}
						</div>
						<div class="form-field-prompt">
							<form:errors path="productAttributeConfigs[${ status.index}].attributeValue" delimiter=" "></form:errors>
						</div>
					</li>
				</c:if>
			</c:forEach>
			<%--<li>--%>
				<%--<div class="form-field-title">--%>
					<%--<b>*</b><msg:message code='product.viewName'/>--%>
				<%--</div>--%>
				<%--<div class="form-field-elt">--%>
					<%--<form:input path="viewName" class="dfinput"/>--%>
				<%--</div>--%>
				<%--<div class="form-field-desc">--%>
					<%--在网站中展示页面选择--%>
				<%--</div>--%>
				<%--<div class="form-field-prompt">--%>
					<%--<form:errors path="viewName" delimiter=" "></form:errors>--%>
				<%--</div>--%>
			<%--</li>--%>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='product.sort'/>
				</div>
				<div class="form-field-elt">
					<form:input path="sort" class="dfinput"/>
				</div>
				<div class="form-field-desc">
					数字越大，排序越靠前
				</div>
				<div class="form-field-prompt">
					<form:errors path="sort" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='product.description'/>
				</div>
				<div class="form-field-elt">
					<form:textarea path="description" class="textinput"/>
				</div>
				<div class="form-field-desc">
					产品的描述
				</div>
				<div class="form-field-prompt">
					<form:errors path="description" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.create'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${pc_productmanager_product_newplayerproduct_code}_TAB${categoryId}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>
</html>