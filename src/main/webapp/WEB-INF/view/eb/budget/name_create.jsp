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
	
	$("#tableName").val($("#tableId").text().trim());
	
	jQuery("#budgetItemDataList").jqGrid({
        url: '${base}/ajax/getdata/tableColumn/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='tableColumn.name'/>", 
			    "<msg:message code='tableColumn.code'/>"
        ],
        colModel: [
			   {name:'name',index:'name',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'code',index:'code',width:'',align:'center',hidden: false,sortable:false}
        ],
        mtype:"POST",
        postData:{tableId:$("#tableId").val()},
        altRow:true,
        rowList: [<msg:message code="budgetItemData.jqgrid.row.list.s10.10"/>],
        height:'<msg:message code="budgetItemData.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
        onSelectRow:function(){
			var ids = jQuery("#budgetItemDataList").jqGrid('getGridParam','selarrrow');
			$("#ids").val(ids);
        },
        caption:'<msg:message code="budgetItemData.list"/>',
        toolbar: [true,"top"]
    });
});

function save(){
	$("#itemFieldForm").submit();
}
</script>
</head>
<body>
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
	<tr>
		<td width="100%">
			<form:form method="post" action="${base}/form/submit/itemField/create" commandName="itemField" id="itemFieldForm" name="f">
			<input type="hidden" name="isLog" value="1"/>
			<input type="hidden" name="viewCode" value="${eb_budget_name_code}"/>
			<input type="hidden" name="replaceName" value="name"/>
			<input type="hidden" name="buttonGroup" value="${eb_budget_name_code},<msg:message code='button.back.list'/>"/>
			<input type="hidden" name="buttonGroup" value="${eb_budget_name_create_code},<msg:message code='button.continue.create'/>"/>
			<input type="hidden" name="c" value="${itemField.c}"/>
			<input type="hidden" name="categoryId" value="${itemField.categoryId}"/>
			<input type="hidden" name="showType" value="1"/>
			<input type="hidden" name="tableName" id="tableName"/>
			<input type="hidden" name="ids" id="ids"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td align="right" width="10%" class="search_info">表名<msg:message code="system.common.sign.colon"/></td>
					<td align="left" width="30%"  class="search_lable">
						<select name="tableId" id="tableId">
							<option value="21">EB_BudgetItemData</option>
						</select>
					</td>
				</tr>	
				<tr>
					<td colspan="2">
						<table id="budgetItemDataList"><tr><td>&nbsp;</td></tr></table>	
					</td>
				</tr>
			</table>
			</form:form>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">
				<input type="button" id="con_button" class="btn-80" value="保存" onclick="save();" style="margin-top: 10px;"/>
			</td>
		</tr>
	</table>

</body>	
</html>