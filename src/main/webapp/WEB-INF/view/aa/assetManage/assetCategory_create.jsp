<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function(e) {
	
});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/assetCategory/create" commandName="assetCategory" name="assetCategory">
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${aa_assetManage_assetCategory_code}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${aa_assetManage_assetCategory_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${aa_assetManage_assetCategory_create_code},<msg:message code='button.continue.create'/>"/>

<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='assetCategory.type'/>
				</div>
				<div class="form-field-elt" id="select_">
					<%--<form:select path="type" items="${typeDicList }" itemLabel="name" itemValue="value" class="dfinput"></form:select>--%>
						<form:input path="type" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="type" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='assetCategory.code'/>
				</div>
				<div class="form-field-elt">
					<form:input path="code" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="code" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='assetCategory.name'/>
				</div>
				<div class="form-field-elt">
					<form:input path="name" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="name" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='assetCategory.rate'/>
				</div>
				<div class="form-field-elt">
					<form:input path="rate" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="rate" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='assetCategory.rateOfReturn'/>
				</div>
				<div class="form-field-elt">
					<form:input path="rateOfReturn" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="rateOfReturn" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='assetCategory.variance'/>
				</div>
				<div class="form-field-elt">
					<form:input path="variance" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="variance" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='assetCategory.description'/>
				</div>
				<div class="form-field-elt">
					<form:textarea path="description" class="textinput"/>
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
		<input type="button" onclick="window.location.href='${base}/history/back/${aa_assetManage_assetCategory_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
<script type="text/javascript">
	function dealData(list){
		var _html = [];
		_html.push('<select id="type" name="type" class="dfinput">');
		for(var i = 0; i < list.length; i++){
			_html.push('<option value="' +  list[i].value+ '">'+ list[i].name +'</option>');
		}
		_html.push('</select>');
		var _value = $('input[name=type]').val();
		$('#select_').html(_html.join(''));
		$('select[name=type]').val(_value);
	}
	$.ajax({
		url:"${base}/ajax/getdata/dictionary/getByCode.json?name=AA.AssetCategory.Type",
		type:'post',
		dataType:'json',
		success:function(jsonData){
			if(typeof jsonData !== 'undefined'){
				var _list = jsonData.dictionaryList;
				dealData( _list);
			}

		},
		error: function (){

		}
	})
</script>
</body>	
</html>