<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript">

var setting = {
		check: {
			enable: true,
			autoCheckTrigger: false
		},
		view: {
			addDiyDom: addDiyDom
		},
		callback: {
			onCheck: zTreeOnCheck
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};
 
var zNodes = ${treeJsonData};
var IDMark_A = "_a"; 		
function addDiyDom(treeId, treeNode){
	if (treeNode.select == 1) {
		var editStr = "<select class='selDemo' id='" +treeNode.id+ "' name='inputLevels'><option value='"+treeNode.id+"-1"+"'>普通</option><option value='"+treeNode.id+"-2"+"'>高级</option></select>";
		var aObj = $("#" + treeNode.tId + IDMark_A);
		aObj.after(editStr);
		var btn = $("#inputLevel_"+treeNode.id);
		if (btn) btn.bind("change", function(){
			
		});
	}
}


function zTreeOnCheck(event, treeId, treeNode){
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = zTree.getCheckedNodes(true);
	var v = "";
	for(var i = 0;i<nodes.length;i++){
		v += nodes[i].id + ",";
	}
	$("#arr").val(v);
	
}

function save(){
	$("#educationGoalForm").submit();
}

$(document).ready(function(e) {
	
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	
	var zTree_check = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes_check = zTree_check.getCheckedNodes(true);
	var v = "";
	for(var i = 0;i<nodes_check.length;i++){
		v += nodes_check[i].id + ",";
	}
	$("#arr").val(v);
	
	var isInland = '${educationGoal.isInland}';
	var radio = document.getElementsByName("isInland");  
    for (var i=0; i<radio.length; i++){  
        if (radio[i].value == isInland) {  
        	radio[i].checked= true;  
            break;  
        }  
    }
    
    var inputTypeItemIdStr= '${inputTypeItemIdStr}';
    var inputTypeItemIdArr = inputTypeItemIdStr.split(",");
    
    for(var i = 0;i<inputTypeItemIdArr.length;i++){
    	var selectId = inputTypeItemIdArr[i].split("-");
    	var obj = document.getElementById(""+selectId[0]+"");
    	for(var j = 0;j<obj.options.length;j++){
    		if(obj.options[j].value == inputTypeItemIdArr[i]){
				obj.options[j].selected = true;
				break;
			}
    	}
    }
});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/educationGoal/setting/${eb_budget_goal_code}" commandName="educationGoal" name="educationGoal" id="educationGoalForm">
<input type="hidden" id="arr" name="arr" />
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span>教育期望配置信息</span></div>
	<div class="form-content">
	<table style="width:65%">
		<tr>
			<td style="text-align: center;">
				<input type="radio" name="isInland" value="1" checked/>国内
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="isInland" value="0" />国外
			</td>
		</tr>
		<tr>
			<td>
				<div>
					<ul id="treeDemo" class="ztree" style="margin-top:0px;width:100%;"></ul>
				</div>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">
				<input type="button" id="con_button" class="btn-80" value="保存" onclick="save();" style="margin-top: 10px;"/>
				<input type="button" onclick="javascript:history.back();" class="btn-80" value="<msg:message code='button.back'/>"/>
			</td>
		</tr>
		
	</table>
	
</div>
</div>
</form:form>
</body>	
</html>