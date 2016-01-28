<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript">

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
				view: {
					addDiyDom: addDiyDoms
				},
				check:{
					enable: true
				},
				callback: {
					onClick: zTreeRightOnClick,
					beforeExpand: beforeExpand,
					onExpand: onExpand
				},
		     	data: {
		            simpleData: {
		                enable: true,
		                idKey: "id",
		                pIdKey: "pId",
		                rootPId: 0
		            }
		        },
		        async: {
		            //异步加载
		            enable: true,
		            url: "${base}/ajax/getdata/budgetItem/getBudgetItem.json",
		            dataFilter:ajaxDataFilterLeft,
		            dataType : "json",
		            otherParam:{ "rId":function(){
		            	 var treeObj = $.fn.zTree.getZTreeObj("treeDemoLeft");
		                 var nodes =treeObj.getSelectedNodes();//我用了复选框的，你看怎么获取当前选中的节点改下   
		                 var selectNode;
		                 var arr = new Array();
		                 if(nodes.length>0){
		                     selectNode = nodes[0];
		                     var tempnode;
		                     if(selectNode.level!=0){
		                         for(var i=0;i<=1;i++){
		                             if(i==0){
		                                 tempnode=selectNode.getParentNode();
		                            	arr.push(selectNode.id);
		                             }else{
			                            	arr.push( tempnode.id);}
		                         }
		                         return arr.join(",");
		      
		                     }
		                      
		                 }
		            
		            }},
		            autoParam: ["id", "name", "parentId","budgetCategoryId"]
		        }
		};
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
		var zNodes =createNodes(5, 5, 0);

		var curExpandNode = null;
		function beforeExpand(treeId, treeNode) {
			//勾选取消
			var zTree = $.fn.zTree.getZTreeObj("treeDemoRight");
			zTree.checkAllNodes(false);
			
			var pNode = curExpandNode ? curExpandNode.getParentNode():null;
			var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
		for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
				if (treeNode !== treeNodeP.children[i]) {
					zTree.expandNode(treeNodeP.children[i], false);
				}
			}
			while (pNode) {
				if (pNode === treeNode) {
					break;
				}
				pNode = pNode.getParentNode();
			}
			if (!pNode) {
				singlePath(treeNode);
			}

		}
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

		//添加自定义图片
		function addDiyDoms(treeId, treeNode) {
			//是否为父节点
			if(treeNode.isParent) return ;
			var aObj = $("#" + treeNode.tId + IDMark_A);
			if(treeNode.established){
				var editStr = "<span class='demoIcon' id='diyBtn_" +treeNode.id+ "' title='"+treeNode.name+"' onfocus='this.blur();'><span class='button icon02'></span></span>";
				
			}else{
				var editStr = "<span class='demoIcon' id='diyBtn_" +treeNode.id+ "' title='"+treeNode.name+"' onfocus='this.blur();'><span class='button icon01'></span></span>";
				
			} 
				aObj.append(editStr);
		};
	
		
    	//获取根节点ID
		function getroot()
        {   var treeObj = $.fn.zTree.getZTreeObj("treeDemoRight");
            var nodes =treeObj.getCheckedNodes(true);//我用了复选框的，你看怎么获取当前选中的节点改下   
            var selectNode;
            if(nodes.length>0){
            for(var j =0;j<nodes.length;j++)	{
                selectNode = nodes[j];
                var l = selectNode.id;
                if(selectNode.level==0){
				return   selectNode;              	
                }
            }
            }else{
            	  var senodes =treeObj.getSelectedNodes();;//我用了复选框的，你看怎么获取当前选中的节点改下   
                  var selectNodes;
                  for(var j =0;j<senodes.length;j++)	{
                	  selectNodes = senodes[j];
                      var l = selectNodes.id;
                      if(selectNodes.level==0){
      				return   selectNodes;              	
                      }
                  }
            }
        };
    	//获取根节点ID
		function getRightroot()
        {   var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoRight");
            var nodes =treeObj.getCheckedNodes(true);//我用了复选框的，你看怎么获取当前选中的节点改下   
            var selectNode;
            if(nodes.length>0){
            for(var j =0;j<nodes.length;j++)	{
                selectNode = nodes[j];
                var l = selectNode.id;
                if(selectNode.level==0){
				return   selectNode;              	
                }
            }
            }
        };
        //获取根节点所选子节点
    	function getchildren()
        {   var treeObj = $.fn.zTree.getZTreeObj("treeDemoRight");
            var nodes =treeObj.getCheckedNodes(true);//我用了复选框的，你看怎么获取当前选中的节点改下   
            var selectNode;
            if(nodes.length>0){
            	var arr = new Array();
            for(var j =0;j<nodes.length;j++)	{
                selectNode = nodes[j];
                var l = selectNode.id;
		         if(selectNode.level!=0&&selectNode.isParent==false){
		        	 arr.push(selectNode.id);
                 }
            }
            return arr;
            }else{
           return null; 	
            }
        };
    	function getleftchildren()
        {   var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoLeft");
            var nodes =treeObj.getSelectedNodes();//我用了复选框的，你看怎么获取当前选中的节点改下   
            var selectNode;
            if(nodes.length>0){
            	var arr = new Array();
            for(var j =0;j<nodes.length;j++)	{
                selectNode = nodes[j];
                var l = selectNode.id;
		         if(selectNode.level!=0&&selectNode.isParent==false){
		        	 arr.push(selectNode.code);
                 }
            }
            return arr;
            }
        };
        function getleftRoot()
        {   var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoLeft");
            var nodes =treeObj.getSelectedNodes();//我用了复选框的，你看怎么获取当前选中的节点改下   
            var selectNode;
            if(nodes.length>0){
            	var arr = new Array();
            	 var tempnode;
            	 selectNode = nodes[0];
            	 for(var j =0;j<nodes[0].level;j++)	{
            		if(j==0){
                         tempnode=selectNode.getParentNode();
                 	
                     }else{
                     	tempnode = tempnode.getParentNode();
                     	if(j==1){
                    	 arr.push(tempnode.code);
                        	}
                       }
                  	}
            return arr;
            }
        };
        function leftRoot(){
       	 var treeObj = $.fn.zTree.getZTreeObj("treeDemoLeft");
            var nodes =treeObj.getSelectedNodes();//我用了复选框的，你看怎么获取当前选中的节点改下   
            var selectNode;
            if(nodes.length>0){
                selectNode = nodes[0];
                var tempnode;
                if(selectNode.level!=0){
                    for(var i=0;i< 1;i++){
                        if(i==0){
                            tempnode=selectNode.getParentNode();
                    	
                        }else{
                        
                        	tempnode = tempnode.getParentNode();
                        }
                    }
                    
                    return tempnode.id;
 
                }
                 
            }
       
       }
        function leftChildren(){
        	 var treeObj = $.fn.zTree.getZTreeObj("treeDemoLeft");
             var nodes =treeObj.getSelectedNodes();//我用了复选框的，你看怎么获取当前选中的节点改下   
             var selectNode;
             if(nodes.length>0){
                 selectNode = nodes[0];
             	return selectNode.id;
             }
        }
		var settingLeft = {
				view: {
					addDiyDom: null
				},
				callback: {
					onClick: zTreeOnClick
				},
		     	data: {
		            simpleData: {
		                enable: true,
		                idKey: "id",
		                pIdKey: "level ",
		                rootPId: 0
		            }
		        },
		        async: {
		            //异步加载
		            enable: true,
		            url: "${base}/ajax/getdata/educationMode/getEducationMode.json",
		            dataFilter:ajaxDataFilterLeft,
		            dataType : "json",
		            autoParam: ["id", "name","level"]
		        }
		};
		function ajaxDataFilterLeft(treeId, parentNode, responseData) {
			
		    if (responseData) {
		    	for (key in responseData) {
		    	return  eval("(" + responseData[key] + ")");
				}
		    }
		};
		
		
		function zTreeRightOnClick(event, treeId, treeNode) {
			var treeObj = $.fn.zTree.getZTreeObj("treeDemoRight");
			var nodes = treeObj.getSelectedNodes();
			if (nodes.length>0) {
					treeObj.reAsyncChildNodes(nodes[0], "refresh");
			}
			treeObj.expandNode(treeNode, null, null, null, true);
			treeObj.checkNode(nodes[0], true, true);
 			}
		function zTreeOnClick(event, treeId, treeNode) {
			var treeObj = $.fn.zTree.getZTreeObj("treeDemoLeft");
 			treeObj.expandNode(treeNode);
			var sNodes =treeObj.getSelectedNodes();
			if( sNodes[0].isParent == false ){
				//异步获取数据
				 $.ajax({ 
					url:'${base}/ajax/getdata/budgetCategory/getBudgetCategory.json',
					type:'post', //数据发送方式 
					dataType: "json", 
					success: function(childNodes){ //成功 
						$.fn.zTree.init($("#treeDemoRight"), settingRight, eval(childNodes.childNodes ));
					} 
					}); 
				
			}
		};	
	
		$(document).ready(function(){
			$.ajax({ 
				url:'${base}/ajax/getdata/growStages/getGrowStages.json',
				type:'post', //数据发送方式 
				dataType: "json", 
				success: function(childNodes){ //成功 
					$.fn.zTree.init($("#treeDemoLeft"), settingLeft, eval(childNodes.childNodes ));
					$.fn.zTree.init($("#treeDemoTwoLeft"), settingTwoLeft, eval(childNodes.configure  ));
					$.fn.zTree.init($("#treeDemoTwoRight"), settingTwoRight, eval(childNodes.childNodes  ));
					} 
				});
	 		$("#con_button").click(function(){
	 		 	var rightRoot =getroot();
	 		 	var  rightChildren=getchildren();
	 		 	var rightRootChildren=new Array();
	 		 	if(rightChildren!=null){
	 		 		rightRootChildren=rightChildren.join(",");
	 		 	}
	 		 	var leftRoots=leftRoot();
	 		 	var leftChildrens=leftChildren();
	 		 	$.ajax({ 
					url:'${base}/ajax/getdata/modeItemRelation/insertRelationship.json',
					type:'post', //数据发送方式 
					data: {"budgetItemArray":rightRootChildren,
							growStagesId:leftRoots,
							isLog:1,
							eduModeId:leftChildrens,
							budgetCategoryId:rightRoot.id},
					dataType: "json", 
					success: function(succ){ //成功 
						
						if(succ){
							alert("添加成功");
							var treeObj = $.fn.zTree.getZTreeObj("treeDemoRight");
							var nodes = treeObj.getNodes();
							if (nodes.length>0) {
								treeObj.reAsyncChildNodes(getroot(), "refresh");
							}
						}else{
							alert("添加失败");
						}
					} 
				 }); 	
			}); 
	 		
			
		});
		$("#delete").live("click",function(){

			 var aCode=$("input[name='areaCode']").val();
				if(aCode == ""||aCode== null){
					alert("请选择地区");
					return false;
				}
			var formData=$("#saveItemDate").serializeArray();
			$.ajax({ 
					url:'${base}/ajax/getdata/budgetItemData/deleteItemDate.json',
					type:'post', //数据发送方式 
					data:formData,
					dataType: "json", 
					success: function(succ){ //成功 
						if(succ){
							alert("修改成功");
							$("#addData").html("");
							var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoRight");
							var nodes = treeObj.getSelectedNodes();
							if (nodes.length>0) {
								treeObj.reAsyncChildNodes(getRightroot(), "refresh");
							}
						}else{
							alert("修改失败");
						}
					} 
				 });
		
		
		});
		$("#modify").live("click",function(){
			 var aCode=$("input[name='areaCode']").val();
			 if(aCode == ""||aCode== null){
					alert("请选择地区");
					return false;
				}
			 var SystemYearCount=$("input[name='SystemYearCount']").val();
			 if(SystemYearCount == ""||SystemYearCount== null){
					alert("请选择每年缴费次数");
					return false;
				}
			var formData=$("#saveItemDate").serializeArray();
			$.ajax({ 
					url:'${base}/ajax/getdata/budgetItemData/updateItemDate.json',
					type:'post', //数据发送方式 
					data:formData,
					dataType: "json", 
					success: function(succ){ //成功 
						if(succ){
							alert("修改成功");
							$("#addData").html("");
							var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoRight");
							var nodes = treeObj.getSelectedNodes();
							if (nodes.length>0) {
								treeObj.reAsyncChildNodes(nodes[0], "refresh");
							}
						}else{
							alert("修改失败");
						}
					} 
				 });
		});
		$("#create").live("click",function(){
			 var aCode=$("input[name='areaCode']").val();
			if(aCode == ""||aCode== null){
				alert("请选择地区");
				return false;
			}	
			 var YearCount=$("input[name='SystemYearCount']").val();
			 if(YearCount == ""||YearCount== null){
					alert("请选择每年缴费次数");
					return false;
				}
			 //表单异步提交
			var formData=$("#saveItemDate").serializeArray();
			
			 $.ajax({ 
						url:'${base}/ajax/getdata/budgetItemData/saveItemDate.json',
						type:'post', //数据发送方式 
						data:formData,
						dataType: "json", 
						success: function(succ){ //成功 
							if(succ){
								$("#addData").html("");
								alert("添加成功");
								var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoRight");
								var nodes = treeObj.getSelectedNodes();
								if (nodes.length>0) {
									treeObj.reAsyncChildNodes(nodes[0], "refresh");
								}
								//表单隐藏
								
							}else{
								alert("添加失败");
							}
						} 
					 }); 
				//重置表单
			
		});
		$("select[name='IsGrading']").live("change",function(){
		var isGrading=	$("select[name='IsGrading']").val();  
		if(isGrading==0){
			$("input[name='HighAmount']").val(null);
			$("select[name='GradingType']").val(null);  
			$("input[name='HighAmount']").parent().parent().css("display","none");	
			$("input[name='LowAmount']").parent().parent().css("display","block");	
			$("select[name='GradingType']").parent().parent().css("display","none");	
		}
		if(isGrading==1){
			$("input[name='HighAmount']").parent().parent().css("display","block");	
			$("select[name='GradingType']").parent().parent().css("display","block");	
		}
		});
		$("select[name='GradingType']").live("change",function(){
			var GradingType=$("select[name='GradingType']").val();  
			
			if(GradingType==1){
				$("input[name='LowAmount']").parent().parent().css("display","none");	
			}
			if(GradingType==0){
				$("input[name='LowAmount']").val(null);
				$("input[name='LowAmount']").parent().parent().css("display","block");	
			}
		});
		var settingTwoLeft = {
		     	data: {
		            simpleData: {
		                enable: true,
		                idKey: "id",
		                pIdKey:"parentCode",
		                rootPId: 0
		            }
		        },callback: {
					onClick: zTreeTwoLeftOnClick
		    	},
		        async: {
		            //异步加载
		            enable: true,
		            url: "${base}/ajax/getdata/area/getArea.json",
		            dataType : "json",
		            dataFilter:ajaxDataFilterLeft,
		            autoParam: ["id", "name", "parentCode"]
		        }
		};
		var settingTwoRight = {
		     	data: {
		            simpleData: {
		                enable: true,
		                idKey: "id",
		                pIdKey:"parentId"
		            }
		        },
				
		        view: {
					dblClickExpand: false,
					showLine: false,
					addDiyDom: addDiyDoms
				},
		    	callback: {
					onClick: zTreeTwoRightOnClick,
					beforeExpand:zTreeOnExpand,
					beforeClick: zTreeBeforeClick
		    	},
		        async: {
		            //异步加载
		            enable: true,
		            url: "${base}/ajax/getdata/growStages/getTreeDate.json",
		            dataType : "json",
		            dataFilter:ajaxDataFilterLeft,
		            otherParam:{"areaCode":function(){
		            	 var nodes =$("input[name='areaCode']").val();
			           		return nodes;
			            },"provinceCode":function(){
			            	 var nodes =$("input[name='provinceCode']").val();
				           		return nodes;
				            }, "rId":function(){
		            	 var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoRight");
		                 var nodes =treeObj.getSelectedNodes(); 
		                 var selectNode;
		                 
		                 if(nodes.length>0){
		                     selectNode = nodes[0];
		                     var tempnode;
		                     var arr = new Array();
		                     for(var i=0;i<selectNode.level ;i++){
		                             if(i==0){
		                                 tempnode=selectNode.getParentNode();
		                               
		                             }else {
		                                 tempnode = tempnode.getParentNode();
		                             }
		                             //一级
		                             if(selectNode.level-1==i){
		                            	 arr.push(tempnode.id); 
		                             }
		                             //二级
									 if(selectNode.level-2==i){
										 arr.push(tempnode.id); 
		                             }
									//三级
									 if(selectNode.level-3==i){
										 arr.push(tempnode.id); 
		                             }
		                             
		                         }
		                         return arr.join(",");
		      
		                      
		                 }
		            
		            }},
		            autoParam: ["id", "name", "level","parentId"]
		        }
		};
		function zTreeTwoLeftOnClick(event, treeId, treeNode) {
 			var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoLeft");
 			treeObj.expandNode(treeNode);
 			var areaCode=getleftchildren();
 			var provinceCode=getleftRoot();
 	 		$("input[name='areaCode']").val(areaCode);
 	 			$("input[name='provinceCode']").val(provinceCode);
 	 		//刷新数据关系树
			 	var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoRight");
							var nodes = treeObj.getSelectedNodes();
							if (nodes.length>0) {
								treeObj.reAsyncChildNodes(nodes[0], "refresh");
							}
			
		}
		function zTreeOnExpand( treeId, treeNode){
			 var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoRight");
			 treeObj.selectNode(treeNode);
			 return true;
		}
		function zTreeBeforeClick(treeId, treeNode, clickFlag) {
		   	var code=$("input[name='areaCode']").val();
			if(code==""||code==null){
			  	alert("请选择地区");
				return false;
			}else{
			   	return true;
			}
		   	
		}
		function getRoots(){
           	 var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoRight");
                var nodes =treeObj.getSelectedNodes(); 
                var selectNode;
                
                if(nodes.length>0){
                    selectNode = nodes[0];
                    var tempnode;
                    var arr = new Array();
                    for(var i=0;i<selectNode.level ;i++){
                            if(i==0){
                                tempnode=selectNode.getParentNode();
                                //当前选中节点
                           	   arr.push(selectNode.id);
								if(selectNode.level==3){
									$("input[name='itemId']").val(selectNode.rId);
								}else{
	                           
									$("input[name='itemId']").val(selectNode.id);
								}                            
							}else {
                                tempnode = tempnode.getParentNode();
                            }
                            if(selectNode.level-1==i){
                           		 arr.push(tempnode.id); 
                          		$("input[name='growStagesId']").val(tempnode.id);
                            }
                            if(selectNode.level-2==i){
								 arr.push(tempnode.id); 
								 $("input[name='eduModeId']").val(tempnode.id);
                           } if(selectNode.level-3==i){
								 arr.push(tempnode.id); 
								 $("input[name='categoryId']").val(tempnode.id);
								 
                           }
                            
                        }
                        return arr.join(",");
     
                     
                }
           
		};
		function zTreeTwoRightOnClick(event, treeId, treeNode) {
 			var treeObj = $.fn.zTree.getZTreeObj("treeDemoTwoRight");
 			treeObj.expandNode(treeNode);
 			var selectNodes =treeObj.getSelectedNodes()[0];//得到选择的节点属性
 			if(selectNodes.isParent==false){
 				//地区隐藏域
				getRoots();
			
 				var formData=$("#saveItemDate").serialize();
 				//得出小项字段属性
				$.ajax({ 
					url:'${base}/ajax/getdata/itemField/getItemField.json',
					type:'post', //数据发送方式 
					dataType: "json", 
					data:formData,
					success: function(succ){ //成功
						var data=eval("("+succ.succ+")");
						$("#addData").html("");
						//添加地区代码的隐藏域
						
						for( var  i=0;i<data.length;i++){
							var add="<li><div class='form-field-title'><b>*</b>"+data[i].columnName+"</div><div class='form-field-elt'>"; 	
							if(data[i].showType==1){
								//输入框
								if(data[i].val == null){
								 	add+="<input  name='"+data[i].columnCode+"' type='text' class='dfinputs'/>";
								}else{
								 	add+="<input  name='"+data[i].columnCode+"' value='"+data[i].val+"'  type='text' class='dfinputs'/>";
								}
							}else if(data[i].showType==2){
								 //下拉框
								 var itemFieldList= data[i].itemFieldValue;
								 add+=" <select name='"+data[i].columnCode+"'>";
								 for( var  j=0;j<itemFieldList.length;j++){
									 add+="<option value='"+itemFieldList[j].fieldValue+"'>"+itemFieldList[j].fieldName+"</option> ";
								 }	
								 add+="</select>";
							 }else if(data[i].showType==3){
								 //复选框
								 var itemFieldList= data[i].itemFieldValue;
								 for( var  k=0;k<itemFieldList.length;k++){
									 if(data[i].columnCode=='Years'){
										 add+="<input type='checkbox' name='"+data[i].columnCode+"Array' value='"+itemFieldList[k].fieldValue+"'/>"+itemFieldList[k].fieldName;
									 }else{
										 add+="<input type='checkbox' name='"+data[i].columnCode+"' value='"+itemFieldList[k].fieldValue+"'/>"+itemFieldList[k].fieldName;
									} 
								 }	
							 }
							 else if(data[i].showType==4){
								 //单选
								 add+="<input  type='radio' name='"+data[i].columnCode+"' value='0'/>是";
								 add+="<input  type='radio' name='"+data[i].columnCode+"'value='1' />不是";
							 }
							 else {
								 //文本域
								 	if(data[i].val == null){
								 		add+="<input  type='textarea' name='"+data[i].columnCode+"' class='dfinputs'/>";
								 	}else{
										add+="<input  type='textarea' value='"+data[i].val+"' name='"+data[i].columnCode+"' class='dfinputs'/>";
									}
							 }
							
							
								add+="</div></li>";
								$("#addData").append(add);	
							
								 //下拉框
								 if(data[i].showType==2&&data[i].val!=null){
									 $("select[name='"+data[i].columnCode+"']").find("option[value='"+data[i].val+"']").attr("selected",true);  
								 }
								 //复选框
								 if(data[i].showType==3&&data[i].val!=null){
									 if(data[i].columnCode=='Years'){
										 var str= new Array();
										 str=data[i].val.split(",");	
											
										 for(var n=0;n<str.length;n++){
											 	$("input[name='"+data[i].columnCode+"Array'][value="+str[n]+"]").attr("checked",true); 	
										 }
										 
										}else{
										 	$("input[name='"+data[i].columnCode+"'][value="+data[i].val+"]").attr("checked",true); 	
										} 
								 }
								 //单选框
								 if(data[i].showType==4&&data[i].val!=null){
										$("input[name='"+data[i].columnCode+"'][value="+data[i].val+"]").attr("checked",true); 	
								 }
					}
						$("#addData").append("<li><div class='form-field-title'>&nbsp;</div><div class='form-field-elt'>");
						if(succ.isAdded){
							<shiro:hasPermission name="${eb_budget_relation_data_modify_code}">
							$("#addData").append("<input type='button' id='modify' class='btn-80' value='<msg:message code='button.modify'/>'/>");
							</shiro:hasPermission>
							<shiro:hasPermission name="${eb_budget_relation_data_delete_code}">
							$("#addData").append("<input type='button' id='delete' class='btn-80' value='<msg:message code='button.delete'/>'/>");
							</shiro:hasPermission>
						}
						else{
							<shiro:hasPermission name="${eb_budget_relation_data_create_code}">
							$("#addData").append("<input type='button' id='create' class='btn-80' value='<msg:message code='button.create'/>'/>");
							</shiro:hasPermission>
						}
						$("#addData").append("<input type='reset' class='btn-80' value='<msg:message code='button.reset'/>'/>");
						$("#addData").append("</div></li>");
						$("#addDataing").css("display","block");
						//添加数据项ID
						var data=eval(succ.id);
						$("input[name='id']").val(data);
						var isGrading=	$("select[name='IsGrading']").val();  
						if(isGrading==0){
							$("input[name='HighAmount']").val(null);
							$("input[name='HighAmount']").parent().parent().css("display","none");	
							//档次类型隐藏	
							$("select[name='GradingType']").parent().parent().css("display","none");	
						}
						if(isGrading==1){
							$("input[name='HighAmount']").parent().parent().css("display","block");	
							//档次类型显示
							$("select[name='GradingType']").parent().parent().css("display","block");	
							var GradingType=	$("select[name='GradingType']").val();  
							if(GradingType==1){
								$("input[name='LowAmount']").parent().parent().css("display","none");	
							}
							if(GradingType==0){
								$("input[name='LowAmount']").parent().parent().css("display","block");	
							}
						}
						
					} 
				});
			}
		};
		 function tab_order(number){
			 	$("#newtab_1").removeClass("selected");
				$("#newtab_2").removeClass("selected");
				$("#newtab_3").removeClass("selected");
			    $("#newtab_"+number).addClass("selected");
				$(".tabmain").css("display","none");
				$("#tabmain_"+number).css("display","block");
			 }
		 
		 function aKeyProduce(){
			 var r=confirm("确定生成数据吗")
			  if (r==true)
			    {
				  $.ajax({ 
						url:'${base}/ajax/submit/residentIncomes/initBudgetItemDataByArea.json&idLog=1',
						type:'post', //数据发送方式 
						dataType: "json", 
						success: function(jsonData,textStatus){
							if(jsonData.status == 'success'){
								$("#span").html("生成成功！");
							}else if(jsonData.status == 'fail'){
								$("#span").html("生成失败！");
							}
						}})    
				}else{
					return false;
				}
			 
			 
		 }
		 
		 function aKeyIncome(){
			 var r=confirm("确定生成数据吗")
			  if (r==true)
			    {
				  $.ajax({ 
						url:'${base}/ajax/submit/residentIncomes/initResidentIncomesData.json&isLog=1',
						type:'post', //数据发送方式 
						dataType: "json", 
						success: function(jsonData,textStatus){
							
						}})    
				}else{
					return false;
				}
			
			 
		 }
jQuery("#modeItemRelationList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
<style type="text/css">
ul#tabnav {
	position :relative;
	text-align: bottom;
	margin: 0em 0 1em 0;
	font: bold 12px verdana, arial, sans-serif;
	border-bottom: 1px solid #B4B1CE;
	list-style-type: none;
	padding: 4px 2px ;
	height: 24px;
}
#connection{
float: left;
}
ul#tabnav li {
	float:left;
}
ul#tabnav li a {
	padding: 0 14px;
	border-top: 1px solid #B4B1CE;
	border-left: 1px solid #B4B1CE;
	border-right: 1px solid #B4B1CE;
	background-color: #eafbff ;
	color: #000;
	text-decoration: none;
	height: 24px;
	line-height: 24px;
	float: left;
	margin-top: 3px;
	margin-right: 5px;
	border-radius: 4px 4px 0 0;
}
#tabnav .selected {
	background-color:#ccdfed;
	color: #000;
	height: 28px;
	line-height: 28px;
	margin-top: 0;
}
#addDataing{
	float: left;
	width:570px; 
	height:600px; 
	overflow:auto; 
	display: block;
}
</style>
</head>
<body class="skinMain">
<ul id="tabnav">
		<shiro:hasPermission name="${eb_budget_relation_relationship_code}">
		<li class="newtab_1" ><a href="#" id="newtab_1" onclick="tab_order(1)" class="selected">关系配置</a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="${eb_budget_relation_data_code}">
		<li class="newtab_2" ><a href="#" id="newtab_2" onclick="tab_order(2)">数据配置</a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="${eb_budget_relation_generated_code}">
		<li class="newtab_3" ><a href="#" id="newtab_3" onclick="tab_order(3)">生成数据</a></li>
		</shiro:hasPermission>
	</ul>
<div class="tabmain" id="tabmain_1" >
<div class="content_wrap" style="width: 1200px;">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemoLeft" style="float: left;" class="ztree"></ul>
	</div>
	<div class="zTreeDemoBackground left" >
		<ul id="treeDemoRight" style="float: left;margin-left: 50px;" class="ztree"></ul>
	</div>
	<div id="connection" style="float:left;margin-top: 190px;">
		<shiro:hasPermission name="${eb_budget_relation_relationship_conn_code}">
		<input type="button" id="con_button" class="btn-80" style="margin-left: 150px;" value="关联"/>
		</shiro:hasPermission>
	</div>
	</div>

</div>
<div  class="tabmain" id="tabmain_2" style="display: none;" >
<div class="content_wrap" style="width: 1200px;">
	<div class="zTreeDemoBackground left"  style="float: left;">
		<ul id="treeDemoTwoLeft" style="float: left;margin-left: 10px;" class="ztree"></ul>
		
	</div>
	<div class="zTreeDemoBackground left"  style="float: left;">
		
		<ul id="treeDemoTwoRight" style="float: left;margin-left: 40px;" class="ztree"></ul>
	</div>
<div class="tabRightMain" id ="addDataing"  style="float: left;margin-left: 10px;">
	<form method="post" action="#" id="saveItemDate">
	<input type="hidden" name="isLog" value="1"/>
		<div class="form-body">
		<div class="form-title" style="width: 200px;"><span><msg:message code='system.prompt.create.info'/></span></div>
		
		<input title="地区"  type="hidden" name="areaCode" value="">
		<input title="省份地区"  type="hidden" name="provinceCode" value="">
		<input title="成长阶段"  type="hidden" name="growStagesId" value="">
		<input title="教育方式"  type="hidden" name="eduModeId" value="">
		<input title="预算分类大项"  type="hidden" name="categoryId" value="">
		<input title="预算分类小项"  type="hidden" name="itemId" value="">
		<input title="数据配置Id"  type="hidden" name="id" value="">
		<div class="form-content"  >
			<ul id="addData">
			</ul>
		</div>
		</div>
	
	
	</form>
	</div>
	
</div>

</div>

<div class="tabmain" id="tabmain_3" style="display: none;">
<div class="content_wrap" >
	<div id="connection" style="float:left;">
		<shiro:hasPermission name="${eb_budget_relation_generated_generate_code}">
		<input type="button" id="akey_produce" class="btn-80" value="一键生成" onclick="aKeyProduce();"/>
		</shiro:hasPermission>
		<shiro:hasPermission name="${eb_budget_relation_generated_incomes_code}">
		<input type="button" id="akey_income" class="btn-80" value="居民收入数据生成" onclick="aKeyIncome();"/>
		</shiro:hasPermission>
		<span id="span"> </span>
	</div>
</div>
</div>
</body>
</html>