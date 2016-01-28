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
	var height = $(window).height();
	$(".form-content").height(height-170);
	$('.select3').uedSelect({width:345})

	$(".btn_chooseImg").click(function(){
		var $imglabel = $(this).parent().find(".imgNameLabel");
		var $imgInput = $(this).parent().find(".imgInput");
		var $imgfileInput = $(this).parent().find(".imgfileInput");
		
		$imgfileInput.trigger('click');
	});
	
	$("#bankCode").live("change",function(){
		//银行的代码
		var name = $("#bankCode").find("option:selected").text();
		$("#bankName").val(name);
	});
	$(".imgfileInput").live("change",function(){
		var fileName = $(this).val();
		var _fileElementId = $(this).attr("id");

		var $imglabel = $(this).parent().find(".imgNameLabel");
		var $imgInput = $(this).parent().find(".imgInput");
		var $imgfileInput = $(this).parent().find(".imgfileInput");
		var $imgPriv = $(this).parent().next().find(".img_Box");
		$.ajaxFileUpload({
			url:  '/upload.json',
			secureuri: false,
			fileElementId: _fileElementId,
			dataType: 'json',
			success: function (data, status){

				if(data.state == 'SUCCESS'){
					var src =  "http://res.zxuefei.com/" + data.url;
					$imgInput.val(src);
					$imglabel.text(data.original);
					$imgPriv.attr("src",src);
					$imgPriv.show();
				}else{
					alert('上传图片失败……');
				}
			},
			error: function (data, status, e){
				alert('上传图片失败！')
			}
		});
	});

});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/spvCorporation/create" commandName="spvCorporation" name="spvCorporation">
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="viewCode" value="${cc_spvcorporation_spvcorporation_code}">
<input type="hidden" name="buttonGroup" value="${cc_spvcorporation_spvcorporation_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${cc_spvcorporation_spvcorporation_create_code},<msg:message code='button.continue.create'/>"/>
<!-- 银行名称 -->
<input type="hidden" name="bankName" id="bankName" value="中国银行"/>
<div class="form-body">
	<div class="form-title">
		<span>
			<msg:message code='system.prompt.basic.info'/>
		</span>
	</div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.name'/>
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
					<b>*</b><msg:message code='spvCorporation.shortName'/>
				</div>
				<div class="form-field-elt">
					<form:input path="shortName" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="shortName" delimiter=" "></form:errors>
				</div>
			</li>
	        	<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.type'/>
				</div>
				<div class="form-field-elt">
					<input type="radio" name="type" checked="checked"  value="0" >spv
				</div>
				<div class="form-field-prompt">
					<form:errors path="type" delimiter=" "></form:errors>
				</div>
			</li>	
		
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.code'/>
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
					<b>*</b><msg:message code='spvCorporation.umpayAccountNo'/>
				</div>
				<div class="form-field-elt">
					<form:input path="umpayAccountNo" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="umpayAccountNo" delimiter=" "></form:errors>
				</div>
			</li>	<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.umpayMerchantNo'/>
				</div>
				<div class="form-field-elt">
					<form:input path="umpayMerchantNo" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="umpayMerchantNo" delimiter=" "></form:errors>
				</div>
			</li>	
			<li>
				<div  for="bankCode" class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.bankName'/>
				</div>
				<div class="form-field-elt-select">
					 <form:select path="bankCode" id="bankCode" class="select3">
        					<form:option value=""><msg:message code='button.select'/></form:option>	
							<c:forEach items="${bankBasicInfoList}" var="item">
								<form:option value="${item.code}">${item.name}</form:option>
							</c:forEach>
        			</form:select>
				</div>
				<div class="form-field-prompt">
					<form:errors path="bankCode" delimiter=" "></form:errors>
				</div>
			</li>
	     	<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.bankCardNumber'/>
				</div>
				<div class="form-field-elt">
					<form:input path="bankCardNumber" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="bankCardNumber" delimiter=" "></form:errors>
				</div>
			</li>	
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.phone'/>
				</div>
				<div class="form-field-elt">
					<form:input path="phone" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="phone" delimiter=" "></form:errors>
				</div>
			</li>	<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.fax'/>
				</div>
				<div class="form-field-elt">
					<form:input path="fax" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="fax" delimiter=" "></form:errors>
				</div>
			</li>
				<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.postCode'/>
				</div>
				<div class="form-field-elt">
					<form:input path="postCode" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="postCode" delimiter=" "></form:errors>
				</div>
			</li>
				<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.address'/>
				</div>
				<div class="form-field-elt">
					<form:input path="address" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="address" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.description'/>
				</div>
				<div class="form-field-elt">
					<form:input path="description" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="description" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.status'/>
				</div>
				<div class="form-field-elt">
					<input type="radio" name="status" checked="checked"  value="0" >无效
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="status" value="1" >有效
				</div>
				<div class="form-field-prompt">
					<form:errors path="status" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.signaturePicPath'/>
				</div>
				<div class="form-field-elt">
					<div class="modal-body upload-box">
						<div class="upload-header">
							<a href="javascript:;" class="btn btn-orange btn_chooseImg" ><i class="fa fa-image"></i>选择图片</a>
							<span class="imgNameLabel" style="display: none;">请选择..</span>
							<input type="file" name="imgfileInput" id="imgfileInput" class="imgfileInput"  accept=".jpg,.png,.gif" style="display: none;" >
							<form:hidden path="signaturePicPath" class="dfinput imgInput"/>
						</div>
						<div class="upload-body" style="height: 100px;width: 100px;">
							<img src="" id="img_Box" class="img_Box" style="width:100%;"/>
							<input type="hidden" id ="x"/>
							<input type="hidden" id ="y"/>
							<input type="hidden" id ="w"/>
							<input type="hidden" id ="h"/>
						</div>
					</div>
				</div>
				<div class="form-field-prompt">
					<form:errors path="signaturePicPath" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.create'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${cc_spvcorporation_spvcorporation_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>