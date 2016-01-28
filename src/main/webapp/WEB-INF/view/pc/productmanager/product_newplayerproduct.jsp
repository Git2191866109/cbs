<%@ page import="com.bs.plugins.custom.uc.user.entity.User" %>
<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<%@ include file="/WEB-INF/view/pc/pccommonhead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function(){
	initSelect('status','PC.Product.Status',"scinput");
	initDynamicSelect('basicProductId','PC.BasicProduct.Id.Name',"scinput");

	jQuery("#productList").jqGrid({
        url: '${base}/ajax/getdata/product/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='product.basicProductId'/>",
				"<msg:message code='product.spvId'/>",
				"<msg:message code='product.name'/>",
				"<msg:message code='product.code'/>",
				"<msg:message code='product.firstPublishTime'/>",
				"<msg:message code='product.status'/>",
				"<msg:message code='product.status'/>",

			<%--"<msg:message code='product.description'/>",--%>
				<c:forEach items="${product.productAttributeConfigs}" var="productAttributeConfig">
			"${productAttributeConfig.attribute.name}",
			</c:forEach>
			"<msg:message code='product.createTime'/>",
			"<msg:message code='product.modifyTime'/>",
			"<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'basicProductId',index:'basicProductId',width:'80px',align:'center',hidden: false,sortable:false, formatter:function(data){ return getDicText("PC.BasicProduct.Id.Name",data,true)}},
				{name:'spvId',index:'spvId',width:'80px',align:'center',hidden: false,sortable:false, formatter:function(data){ return getDicText("CC.SpvCorporation.Id.Name",data,true)}},
				{name:'name',index:'name',width:'80px',align:'center',hidden: false,sortable:false},
				{name:'code',index:'code',width:'80px',align:'center',hidden: false,sortable:false},
				{name:'firstPublishTime',index:'firstPublishTime',width:'80px',align:'center',hidden: false,sortable:false},
				{name:'status',index:'statusName',width:'80px',align:'center',hidden: false,sortable:false, formatter:function(data){ return getDicText("PC.Product.Status",data)}},
				{name:'status',index:'status',width:'80px',align:'center',hidden: true,sortable:false},

//				{name:'description',index:'description',width:'180px',align:'center',hidden: false,sortable:false},
				<c:forEach items="${product.productAttributeConfigs}" var="productAttributeConfig" varStatus="status">
			<%--{name:'productattr_${productAttributeConfig.attributeId}',index:'productattr_${productAttributeConfig.attributeId}',width:'80px',align:'center',hidden: false,sortable:false},--%>
			{name:'productAttributeConfigs.${ status.index}.attributeValue',index:'productAttributeConfigs.${ status.index}.attributeValue',width:'80px',align:'center',hidden: false,sortable:false},
			</c:forEach>
			{name:'createTime',index:'createTime',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'modifyTime',index:'modifyTime',width:'80px',align:'center',hidden: false,sortable:false},
			{name:'act',index:'act',align:'center',width:'330px',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${product.c}',categoryId:${product.categoryId},spvId:'${spvId }'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="product.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="log.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#productList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
				var data = jQuery("#productList").jqGrid("getRowData",id);
				var status = data.status;
//				alert(status);
				jQuery("#productList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + get_func_str(status,id) + "</div>"});
    		}	
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/product/jumpModify?viewCode=${pc_productmanager_product_newplayerproduct_modify_code}&isContextCode=1&id="+rowid+"&categoryId=" + $("#categoryId").val();;
    	    });    
    	    </shiro:hasPermission>

			<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_contract_code}">
			$(".shortcut_contract").click(function(){
				var rowid = $(this).attr("id");
				window.location.href="${base}/goto/productContract/productContractIndex?viewCode=${pc_productmanager_product_newplayerproduct_contract_code}&isContextCode=1&productId="+rowid + "&product.categoryId=${product.categoryId }";
			});
			</shiro:hasPermission>

			<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#productList").jqGrid("getRowData",rowid);
    	    	var records = $("#productList").getGridParam("records");
    	    	var page = $("#productList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/product/delete.json?isLog=1&replaceName="+data.name+"&id=" + rowid;
    				$.ajax({
    					url:url,
    					type:'post',
    					timeout:'60000',
    					dataType:'json',
    					success:function(jsonData,textStatus){
    						if (textStatus == "success"){
    							if (jsonData.status == "success"){
    								for(var i = 1; ;i++){
    									if(records = 10*i+1){
    										jQuery("#productList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#productList").trigger("reloadGrid");
									top.layer.close(layers);									
    							}else{
									top.layer.msg("<msg:message code='system.prompt.delete.limit'/>");
								}
    						}
    					}
    				});
    			});
    	    });
			</shiro:hasPermission>

			<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_publish_code}">
			$(".shortcut_publish").click(function(){
				updateStatus( $(this).attr("id"),"2","您确认进行【发布】吗？");
			});
			</shiro:hasPermission>

			<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_cash_code}">
			$(".shortcut_cash").click(function(){
//				updateStatus( $(this).attr("id"),"6","您确认进行【兑付设置】吗？");
				var rowid = $(this).attr("id");
				window.location.href="${base}/goto/product/jumpProductCash?viewCode=${pc_productmanager_product_newplayerproduct_cash_code}&isContextCode=1&id="+rowid+"&categoryId=" + $("#categoryId").val();;
			});
			</shiro:hasPermission>

			<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_tag_code}">
			$(".shortcut_tag").click(function(){
				updateStatus( $(this).attr("id"),"7","您确认进行【已兑付完成】吗？");
			});
			</shiro:hasPermission>

			<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_cancel_code}">
			$(".shortcut_cancel").click(function(){
				updateStatus( $(this).attr("id"),"4","您确认进行【取消】操作？");
			});


			function updateStatus(rowid, status, configMessage){
				var orginData = jQuery("#structureConfigList").jqGrid('getRowData', rowid);
				var data = "id="+rowid+"&status=" + status;

				var layers = top.layer.confirm(configMessage,  function(){
					$.ajax({
						url:"${base}/ajax/submit/product/updateStatus.json?isLog=1",
						type:'post',
						data:data,
						timeout:'60000',
						dataType:'json',
						success:function(jsonData,textStatus){
							if (textStatus == "success"){

								if (jsonData.status == "success") {
									$("#productList").trigger("reloadGrid");
									jQuery("#productList").jqGrid('setRowData', rowid, {act: "<div class='jqgridContainer'>" + get_func_str(status, rowid) + "</div>"});
								}else {
									console.info(jsonData);
									alert(jsonData.promptMessage);
								}
							}
						}
					});
					top.layer.close(layers);
				});
			}
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_detail_code}">
			$(".shortcut_detail").click(function(){
				var rowid = $(this).attr("id");
				window.location.href="${base}/goto/product/jumpModify?viewCode=${pc_productmanager_product_newplayerproduct_detail_code}&isContextCode=1&id="+rowid+"&categoryId=" + $("#categoryId").val();;
			});

			$(".shortcut_review").click(function(){
				var rowid = $(this).attr("id");
				window.open("http://${websiteDomain }/product/details/" + rowid);
			});


			</shiro:hasPermission>
			<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_create_code}">
		    $("#top_create","#t_productList").click(function(){

		    	window.location.href = "${base}/goto/product/jumpCreate?viewCode=${pc_productmanager_product_newplayerproduct_create_code}&isContextCode=1&categoryId=" + $("#categoryId").val();
		    });    
		    </shiro:hasPermission>
    	},
        caption:'<msg:message code="product.list"/>',
        toolbar: [true,"top"]
    });
    
  //top菜单
	<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_create_code}">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_productList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));
    </shiro:hasPermission>

	$("#qryBtn").click(function(){
		jQuery("#productList").jqGrid("setGridParam",{postData:{
			categoryId:$("#categoryId").val(),
			basicProductId:$("#basicProductId").val(),
			status:$("#status").val(),
			name:$("#name").val(),
			code:$("#code").val(),
			firstPublishTimeStartTime:$("#firstPublishTimeStartTime").val(),
			firstPublishTimeEndTime:$("#firstPublishTimeEndTime").val(),
		}
		}).trigger("reloadGrid");
	});

	function get_func_str(status,id) {
		var content = "";
//		content += func_modify(id);
//		content += func_detail(id);
//		content += func_delete(id);
//		content += func_publish(id);
//		content += func_cash(id);
//		content += func_cancel(id);
		switch (status) {
			case "1":
				content += func_modify(id);
				content += func_contract(id);
				content += func_detail(id);
				content += func_review(id);
				content += func_delete(id);
				content += func_publish(id);


//				content += func_cash(id);
//				content += func_cancel(id);


				break;
			case "2":
				content += func_modify(id);
				content += func_contract(id);
				content += func_detail(id);
				content += func_review(id);
//				content += func_delete(id);
//				content += func_publish(id);
//				content += func_cash(id);
//				content += func_cancel(id);
				break;
			case "5":
				content += func_modify(id);
				content += func_contract(id);
				content += func_detail(id);
				content += func_review(id);
//				content += func_delete(id);
//				content += func_publish(id);
				content += func_cash(id);
//				content += func_cancel(id);
				break;
			case "6":
				content += func_modify(id);
				content += func_contract(id);
				content += func_detail(id);
				content += func_review(id);
//				content += func_delete(id);
//				content += func_publish(id);
//				content += func_cash(id);
				content += func_tag(id);

//				content += func_cancel(id);
				break;
			case "7":
				content += func_modify(id);
				content += func_contract(id);
				content += func_detail(id);
				content += func_review(id);
//				content += func_delete(id);
//				content += func_publish(id);
//				content += func_cash(id);
//				content += func_cancel(id);
				break;
			case "4":
				content = "";
//				content += func_modify(id);
				content += func_contract(id);
				content += func_detail(id);
				content += func_review(id);
//				content += func_delete(id);
//				content += func_publish(id);
//				content += func_cash(id);
//				content += func_cancel(id);
				break;
			default :
				content = "状态异常！";
		}
		return content;
	}

	function func_modify(id) {
		var content = "";
		<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_modify_code}">
		content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
		content += " title='修改'>";
		content += "<img src='${base}/static/images/icon/modify.png'";
		content += " weight='18' height='18' border='0' align='absmiddle'/>";
		content += "修改";
		content += "</a>";
		</shiro:hasPermission>
		return content;
	}

	function func_contract(id) {
		var content = "";
		<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_contract_code}">
		content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_contract' ";
		content += " title='合同'>";
		content += "<img src='${base}/static/images/icon/information_center.gif'";
		content += " weight='18' height='18' border='0' align='absmiddle'/>";
		content += "合同";
		content += "</a>";
		</shiro:hasPermission>
		return content;
	}


	function func_publish(id) {
		var content = "";
		<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_publish_code}">
		content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_publish' ";
		content += " title='发布'>";
		content += "<img src='${base}/static/images/icon/modify.png'";
		content += " weight='18' height='18' border='0' align='absmiddle'/>";
		content += "发布";
		content += "</a>";
		</shiro:hasPermission>
		return content;
	}

	function func_cash(id) {
		var content = "";
		<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_cash_code}">
		content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_cash' ";
		content += " title='兑付设置'>";
		content += "<img src='${base}/static/images/icon/modify.png'";
		content += " weight='18' height='18' border='0' align='absmiddle'/>";
		content += "兑付设置";
		content += "</a>";
		</shiro:hasPermission>
		return content;
	}

	function func_tag(id) {
		var content = "";
		<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_tag_code}">
		content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_tag' ";
		content += " title='已兑付'>";
		content += "<img src='${base}/static/images/icon/modify.png'";
		content += " weight='18' height='18' border='0' align='absmiddle'/>";
		content += "已兑付";
		content += "</a>";
		</shiro:hasPermission>
		return content;
	}

	function func_cancel(id) {
		var content = "";
		<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_cancel_code}">
		content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_cancel' ";
		content += " title='取消'>";
		content += "<img src='${base}/static/images/icon/detail.png'";
		content += " weight='18' height='18' border='0' align='absmiddle'/>";
		content += "取消";
		content += "</a>";
		</shiro:hasPermission>
		return content;
	}

	function func_detail(id) {
		var content = "";
		<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_detail_code}">
		content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_detail' ";
		content += " title='明细'>";
		content += "<img src='${base}/static/images/icon/detail.png'";
		content += " weight='18' height='18' border='0' align='absmiddle'/>";
		content += "明细";
		content += "</a>";
		</shiro:hasPermission>
		return content;
	}

	function func_review(id) {
		var content = "";
		<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_detail_code}">
		content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_review' ";
		content += " title='预览'>";
		content += "<img src='${base}/static/images/icon/viewer contract.png'";
		content += " weight='18' height='18' border='0' align='absmiddle'/>";
		content += "预览";
		content += "</a>";
		</shiro:hasPermission>
		return content;
	}

	function func_delete(id) {
		var content = "";
		<shiro:hasPermission name="${pc_productmanager_product_newplayerproduct_delete_code}">
		content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
		content += " title='删除'>";
		content += "<img src='${base}/static/images/icon/delete.png'";
		content += " weight='18' height='18' border='0' align='absmiddle'/>";
		content += "删除";
		content += "</a>";
		</shiro:hasPermission>
		return content;
	}






});

jQuery("#productList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
<tr>
	<td width="100%">
		<table cellpadding="0" height="85" cellspacing="0" border="1" width="100%">
			<tr>
				<td width="5%">
				</td>
				<td>
					<label for="basicProductId" style="float:right;line-height: 32px;"><msg:message code='product.basicProductId'/></label>
					<input type="hidden" name="categoryId" id="categoryId" value="${product.categoryId}" />
				</td>
				<td>
					<input type="text" name="basicProductId" id="basicProductId" value="${product.basicProductId}" class="scinput"/>
				</td>
				<td>
					<label for="status" style="float:right;line-height: 32px;"><msg:message code='product.status'/>：</label>
				</td>
				<td>
					<input type="text" name="status" id="status" value="${product.status}" class="scinput"/>
				</td>
				<td>
					<label for="name" style="float:right;line-height: 32px;"><msg:message code='product.name'/>：</label>
				</td>
				<td>
					<input type="text" name="name" id="name" value="${product.name}" class="scinput"/>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td width="5%">
				</td>
				<td>
					<label for="code" style="float:right;line-height: 32px;"><msg:message code='product.code'/>：</label>
				</td>
				<td>
					<input type="text" name="code" id="code" value="${product.code}" class="scinput"/>

				</td>
				<td>
					<label for="firstPublishTimeStartTime" style="float:right;line-height: 32px;"><msg:message code='product.firstPublishTime'/>：</label>
				</td>
				<td>
					<input type="text" name="startTime" id="firstPublishTimeStartTime" readonly="readonly" style="width:100px;" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
					<span>~</span>
					<input type="text" name="endTime" id="firstPublishTimeEndTime" readonly="readonly" style="width:100px;"  class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
				</td>
				<td></td>
				<td></td>

				<td rowspan="2" valign="middle">
					<shiro:hasPermission name="${3010105}">
						<button  id="qryBtn" onclick="" class="scbtn" style="width: 100px;">查询</button>
					</shiro:hasPermission>
				</td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td width="100%">
		<form:form method="post" action="product" commandName="product" name="f">
		<input type="hidden" name="c" value="${product.c}"/>
		<table cellpadding="0" cellspacing="0" border="0" width="100%">
			<tr>
				<td>
					<table id="productList" width="100%"><tr><td>&nbsp;</td></tr></table>
					<div id="pagered"></div>
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
</body>
</html>