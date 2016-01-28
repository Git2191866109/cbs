<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<%@ include file="/WEB-INF/view/pc/pccommonhead.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<style type="text/css">
	/*.dataSourceEditLi{*/
		/*display: none;*/
	/*}*/
	body{
		background-color: white;
	}
</style>

<script type="text/javascript">
$(document).ready(function(e) {

	$("input[name=dictCategoryId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"SC.DictionaryCategory.Id.Name"});

	$("input[name=tableName]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"SC.Table.Code.Name",dataCond:"",dataHide:"Id",async:"false",
		onload:function (){
			$.thisObj = $("select[name=tableName]");
			var tableId = $.thisObj.find("option:checked").attr("data-hide");
			var condition = "TableId=" + tableId;
			$("[name=keyColumn]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"SC.TableColumn.Code.Name",dataCond:condition});
			$("[name=valueColumn]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"SC.TableColumn.Code.Name",dataCond:condition});
		},
		onchange:function (){
			var tableId = $(this).find("option:selected").attr("data-hide");
			console.log($(this).find("option:selected").length);
			var condition = "TableId=" + tableId;
			$("[name=keyColumn]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"SC.TableColumn.Code.Name",dataCond:condition});
			$("[name=valueColumn]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"SC.TableColumn.Code.Name",dataCond:condition});
		}
	});

	clickDataSourceRadio($("input[name=dataSource][checked]").val());


//	$("select[name=tableName1]").change(function(){
//		alert(1);
//	});
});

function clickDataSourceRadio(value) {

	if(value == "") {
		value = 0;
	}

	$(".dataSourceEditLi").hide();
	$(".dataSourceEditLi" + value).show();
}

	function submit() {
		$("#editform").submit();

	}

</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/attributeDataConfig/createOrUpdate" commandName="attributeDataConfig" name="attributeDataConfig" id="editform">
<form:hidden path="id" />
<form:hidden path="attributeId" />
<div class="form-body">
	<div class="form-title"><msg:message code='attributeDataConfig.dataSource'/>：
		<form:radiobutton path="dataSource"   value="0"  onclick="clickDataSourceRadio('0')" />无
		<form:radiobutton path="dataSource"   value="1" onclick="clickDataSourceRadio('1')"/>来源于字典
		<form:radiobutton path="dataSource"   value="2" onclick="clickDataSourceRadio('2')"/>来源于模型
		<form:radiobutton path="dataSource"   value="3" onclick="clickDataSourceRadio('3')"/>自定义
	</div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li class="dataSourceEditLi dataSourceEditLi0">
			</li>
			<li class="dataSourceEditLi dataSourceEditLi1">
				<div class="form-field-title">
					<msg:message code='attributeDataConfig.dictCategoryId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="dictCategoryId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="dictCategoryId" delimiter=" "></form:errors>
				</div>
			</li>
			<li class="dataSourceEditLi dataSourceEditLi2">
				<div class="form-field-title">
					<msg:message code='attributeDataConfig.tableName'/>
				</div>
				<div class="form-field-elt">
					<form:input path="tableName" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="tableName" delimiter=" "></form:errors>
				</div>

			</li >
			<li class="dataSourceEditLi dataSourceEditLi2">
				<div class="form-field-title">
					<msg:message code='attributeDataConfig.keyColumn'/>
				</div>
				<div class="form-field-elt">
					<form:input path="keyColumn" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="keyColumn" delimiter=" "></form:errors>
				</div>
			</li >
			<li class="dataSourceEditLi dataSourceEditLi2">
				<div class="form-field-title">
					<msg:message code='attributeDataConfig.valueColumn'/>
				</div>
				<div class="form-field-elt">
					<form:input path="valueColumn" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="valueColumn" delimiter=" "></form:errors>
				</div>
			</li >
			<li class="dataSourceEditLi dataSourceEditLi3">
				<div class="form-field-title">
					<msg:message code='attributeDataConfig.customKey'/>
				</div>
				<div class="form-field-elt">
					<form:input path="customKey" class="scinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="customKey" delimiter=" "></form:errors>
				</div>
				<div class="form-field-title">
					<msg:message code='attributeDataConfig.customValue'/>
				</div>
				<div class="form-field-elt">
					<form:input path="customValue" class="scinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="customValue" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<%--<div class="form-footer">--%>
		<%--<input type="submit" class="btn-80" value="<msg:message code='button.create'/>"/>--%>
		<%--&nbsp;&nbsp;&nbsp;&nbsp;--%>
		<%--<input type="button" onclick="window.location.href='${base}/history/back/${pc_basecfg_attrmanage_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>--%>
	<%--</div>--%>
</div>
</form:form>
</body>
</html>