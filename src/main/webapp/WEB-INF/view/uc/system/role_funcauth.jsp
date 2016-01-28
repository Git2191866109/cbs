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
	var height = window.screen.height;
	$("#treeDemoRight").height(height-460);
	var IDMark_Switch = "_switch",
	IDMark_Icon = "_ico",
	IDMark_Span = "_span",
	IDMark_Input = "_input",
	IDMark_Check = "_check",
	IDMark_Edit = "_edit",
	IDMark_Remove = "_remove",
	IDMark_Ul = "_ul",
	IDMark_A = "_a";
	var settingRight = {
		data: {
			simpleData: {
				enable: true
			}
		},callback: {
			onExpand: onExpand
		}
		,check: {
			enable: true
		}
	};
	
	var zNodes = ${node};
	$.fn.zTree.init($("#treeDemoRight"), settingRight, zNodes);
	function onExpand(event, treeId, treeNode) {
		
		curExpandNode = treeNode;
	}
	function createNodes(maxNodesNumInLevel, maxLevel, curLevel, curPId) {
		if (maxNodesNumInLevel<5) {
			maxNodesNumInLevel = 5;
		}
		var nodes = [], num = 0;
		while(num<3) {
			num = parseInt(Math.random()*1024)%maxNodesNumInLevel+1;
		}
		for (var i=0; i<num; i++) {
			var id = curPId ? curPId + "-" + i : "" + i, isParent = (parseInt(Math.random()*9999)%3!=0),
			node = {id: id, pId : curPId, name : "N" + id};
			nodes.push(node);
			if (isParent && curLevel<maxLevel) {
				nodes = nodes.concat(createNodes(maxNodesNumInLevel, maxLevel, curLevel+1, id));
			}
		}
           return nodes;
	}
	var zNodes = createNodes(5, 5, 0);
	var curExpandNode = null;
	function singlePath(newNode) {
		if (newNode === curExpandNode) return;
           var zTree = $.fn.zTree.getZTreeObj("treeDemoRight"),
                   rootNodes, tmpRoot, tmpTId, i, j, n;
           if (!curExpandNode) {
               tmpRoot = newNode;
               while (tmpRoot) {
                   tmpTId = tmpRoot.tId;
                   tmpRoot = tmpRoot.getParentNode();
               }
               rootNodes = zTree.getNodes();
               for (i=0, j=rootNodes.length; i<j; i++) {
                   n = rootNodes[i];
                   if (n.tId != tmpTId) {
                       zTree.expandNode(n, false);
                   }
               }
           } else if (curExpandNode && curExpandNode.open) {
			if (newNode.parentTId === curExpandNode.parentTId) {
				zTree.expandNode(curExpandNode, false);
			} else {
				var newParents = [];
				while (newNode) {
					newNode = newNode.getParentNode();
					if (newNode === curExpandNode) {
						newParents = null;
						break;
					} else if (newNode) {
						newParents.push(newNode);
					}
				}
				if (newParents!=null) {
					var oldNode = curExpandNode;
					var oldParents = [];
					while (oldNode) {
						oldNode = oldNode.getParentNode();
						if (oldNode) {
							oldParents.push(oldNode);
						}
					}
					if (newParents.length>0) {
						zTree.expandNode(oldParents[Math.abs(oldParents.length-newParents.length)-1], false);
					} else {
						zTree.expandNode(oldParents[oldParents.length-1], false);
					}
				}
			}
		}
		curExpandNode = newNode;
	}
   //获取根节点所选子节点
	function getNode(){   
		var treeObj = $.fn.zTree.getZTreeObj("treeDemoRight");
		var nodes =treeObj.getCheckedNodes(true);//获取选中的节点
		var selectNode;
		if(nodes.length>0){
			var arr = new Array();
			for(var j =0;j<nodes.length;j++){
			    selectNode = nodes[j];
				arr.push(selectNode.code);
			}
			return arr.join(",");
		}else{
			return null; 	
		}
	};
	//动态添加权限
	$("#funcauth_create").live("click",function(){
		var array = new Array();
		array=getNode();
		var roleId=$("#arr").val();
			 $.ajax({ 
					url:'${base}/ajax/submit/roleAuthRelation/createReateion.json?isLog=1',
					data:{array:array,roleId:roleId},
					type:'post', //数据发送方式 
					dataType: "json", 
					success: function(jsonData,textStatus){
						if(jsonData.status == 'success'){
							/* var treeObj = $.fn.zTree.getZTreeObj("treeDemoRight");
							treeObj.refresh(); */
						 	alert("添加成功 ");
						 window.location.reload();
						}else if(jsonData.status == 'fail'){
						 	alert("更改失败!!!");
						}
					}
			});	
	});
});
</script>
</head>
<body>
<div class="form-body">
	<input type="hidden" id="arr" value="${roleId}" />
	<input type="hidden" id="name" value="${roleId}" />
	<div class="form-title">
		<span><msg:message code='system.prompt.funcauth.info' /></span>
	</div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li>
				<div class="form-field-title">
				&nbsp;
				</div>
				<div class="form-field-elt" style="padding-left: 50px;">
					<ul id="treeDemoRight" class="ztree"></ul>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="button" id="funcauth_create" class="btn-80" value="<msg:message code='button.auth'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${uc_system_role_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</body>	
</html>