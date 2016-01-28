<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/view/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
    <script type="text/javascript">
        console.log(location.href);
        $(document).ready(function () {
            jQuery("#subscriptionList").jqGrid({
                url:"${base}/ajax/getdata/subscription/paginated.json",
                datatype: 'json',
                postData: {productId:'${productId}',startTime:"${orderTime}",endTime:"${orderTime}"},
                colNames: [
                    "<msg:message code='subscription.memberId'/>",
                    "<msg:message code='subscription.productName'/>",
                    "<msg:message code='subscription.productCode'/>",
                    "<msg:message code='subscription.member.name'/>",
                    "<msg:message code='subscription.transactionNumber'/>",
                    "<msg:message code='subscription.investAmount'/>",
                    "<msg:message code='subscription.status'/>",
                    "<msg:message code='subscription.orderTime'/>",
                    "<msg:message code='subscription.expectedProfitRatio'/>",
                    "<msg:message code='subscription.expectedProfit'/>",
                    "<msg:message code='subscription.spvServiceFee'/>",
                    "<msg:message code='subscription.actualLoanAmount'/>",
                    "<msg:message code='subscription.loanStatus'/>",
                    "<msg:message code='subscription.loanTime'/>",
                    "<msg:message code='subscription.spvId' />",
                    "<msg:message code='subscription.payPlantformNumber' />",
                    "<msg:message code='subscription.remark' />",
                    "<msg:message code='info.operate'/>"
                ],
                colModel: [
                    {name: 'memberId', index: 'memberId', width: '10%', align: 'center', hidden: true, sortable: false},
                    {name: 'productName', index: 'productName', width: '15%', align: 'center', hidden: false, sortable: false},
                    {name: 'productCode', index: 'productCode', width: '15%', align: 'center', hidden: false, sortable: false},
                    {name: 'memberName', index: 'memberName', width: '10%', align: 'center', hidden: false, sortable: false},
                    {name: 'transactionNumber', index: 'transactionNumber', width: '15%', align: 'center', hidden: false, sortable: false},
                    {name: 'investAmountStr', index: 'investAmountStr', width: '10%', align: 'center', hidden: false, sortable: true},
                    {name: 'status', index: 'status', width: '10%', align: 'center', hidden: false, sortable: false,formatter:function(cellvalue,options,rowObject){
                    	if(cellvalue == 0){
                    		return "认购失败";
                    	}else if(cellvalue == 1){
                    		return "认购成功";
                    	}
                    }},
                    {name: 'orderTime', index: 'orderTime', width: '15%', align: 'center', hidden: false, sortable: true},
                    {name: 'expectedProfitRatio', index: 'expectedProfitRatio', width: '15%', align: 'center', hidden: false, sortable: false},
                    {name: 'expectedProfit', index: 'expectedProfit', width: '10%', align: 'center', hidden: false, sortable: false},
                    {name: 'spvServiceFee', index: 'spvServiceFee', width: '10%', align: 'center', hidden: false, sortable: false},
                    {name: 'actualLoanAmount', index: 'actualLoanAmount', width: '10%', align: 'center', hidden: false, sortable: false},
                    {name: 'loanStatus', index: 'loanStatus', width: '10%', align: 'center', hidden: false, sortable: false,formatter:function(cellvalue,options,rowObject){
                    	if(cellvalue == 0 || cellvalue == null){
                    		return "未放款";
                    	}else if(cellvalue == 1){
                    		return "已放款";
                    	}else if(cellvalue == 2){
                    		return "放款成功";
                    	}else if(cellvalue == 3){
                    		return "放款失败";
                    	}else if(cellvalue == 4){
                    		return "拒绝放款";
                    	}
                    }},
                    {name: 'loanTime', index: 'loanTime', width: '10%', align: 'center', hidden: false, sortable: false},
                    {name: 'spvShortName', index: 'spvShortName', width: '10%', align: 'center', hidden: false, sortable: false},
                    {name: 'payPlantformNumber', index: 'payPlantformNumber', width: '10%', align: 'center', hidden: false, sortable: false},
                    {name: 'remark', index: 'remark', width: '10%', align: 'center', hidden: false, sortable: false},
                    {name: 'act', index: 'act', width: '40%', align: 'center', sortable: false, title: false}

                ],
                mtype: "POST",
                rowNum: "100000",
                page: "1",
               // rowList: [10,1000],
                pager: '#pagered',
                height:'<msg:message code="log.jqgrid.height.400"/>',
                autowidth: true,
                viewrecords: true,
                multiselect: false,
                jsonReader: {
                    repeatitems: false
                },
                gridComplete: function () {
                    //快捷菜单
                    var ids = jQuery("#subscriptionList").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var content = "";
                        var datas = jQuery("#subscriptionList").jqGrid("getRowData", id);

                        <shiro:hasPermission name="${tc_transaction_subscription_detail_code}">
                        content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_detail' ";
                        content += " title='明细'>";
                        content += "<img src='${base}/static/images/icon/detail.png'";
                        content += " weight='18' height='18' border='0' align='absmiddle'/>";
                        content += "明细";
                        content += "</a>";
                        </shiro:hasPermission>
                        if(datas.loanStatus == "未放款" || datas.loanStatus == "放款失败"){
                        	
	                        <shiro:hasPermission name="${tc_transaction_subscription_transfer_code}">
	                        content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_transfer' ";
	                        content += " title='放款'>";
	                        content += "<img src='${base}/static/images/icon/modify.png'";
	                        content += " weight='18' height='18' border='0' align='absmiddle'/>";
	                        content += "放款";
	                        content += "</a>";
	                        </shiro:hasPermission>
	                        
	                        <shiro:hasPermission name="${tc_transaction_subscription_transfer_code}">
	                        content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_refuseLoan' ";
	                        content += " title='拒绝'>";
	                        content += "<img src='${base}/static/images/icon/modify.png'";
	                        content += " weight='18' height='18' border='0' align='absmiddle'/>";
	                        content += "拒绝";
	                        content += "</a>";
	                        </shiro:hasPermission>
	                        
                        }
                        <shiro:hasPermission name="${tc_transaction_subscription_modify_code}">
                        content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
                        content += " title=备注'>";
                        content += "<img src='${base}/static/images/icon/modify.png'";
                        content += " weight='18' height='18' border='0' align='absmiddle'/>";
                        content += "备注";
                        content += "</a>";
                        </shiro:hasPermission>
                        jQuery("#subscriptionList").jqGrid('setRowData', ids[i], {act: "<div class='jqgridContainer'>" + content + "</div>"});
                    }
                },
                loadComplete: function () {
                    <shiro:hasPermission name="${tc_transaction_subscription_modify_code}">
                    $(".shortcut_modify").click(function () {
                        var rowid = $(this).attr("id");
                        window.location.href = "${base}/goto/subscription/jumpModify?viewCode=${tc_transaction_subscription_modify_code}&isContextCode=1&id=" + rowid;

                    });
                    </shiro:hasPermission>

                    <shiro:hasPermission name="${tc_transaction_subscription_transfer_code}">
                    $(".shortcut_transfer").click(function () {
                        var rowid = $(this).attr("id");
                        var layers = top.layer.confirm("您确定要将此认购放款到SPV公司账户吗？",  function(){
  				    		$.ajax({
  		    					url:'${base}/ajax/submit/subscription/modifyLoanTransfer.json',
  		    					data:{idStr:rowid},
  		    					type:'post',
  		    					timeout:'60000',
  		    					dataType:'json',
  		    					success:function(jsonData,textStatus){
  		    						if (textStatus == "success"){
  		    							if (jsonData.status == "success"){
  		    								$("#subscriptionList").trigger("reloadGrid"); 
  		    								top.layer.msg("<msg:message code='subscriptionService.transfer.success' />",1,1);									
  		    							}else{
  		    								top.layer.msg("<msg:message code='subscriptionService.transfer.fail' />");
  										}
  		    						}
  		    					}
  		    				});
  				    		
  		   			 	});

                    });
                    </shiro:hasPermission>
                    
                    <shiro:hasPermission name="${tc_transaction_subscription_transfer_code}">
                    $(".shortcut_refuseLoan").click(function () {
                        var rowid = $(this).attr("id");
                        var layers = top.layer.confirm("您确定拒绝放款此认购到SPV公司账户吗？",  function(){
  				    		$.ajax({
  		    					url:'${base}/ajax/submit/subscription/refuseLoan.json',
  		    					data:{idStr:rowid},
  		    					type:'post',
  		    					timeout:'60000',
  		    					dataType:'json',
  		    					success:function(jsonData,textStatus){
  		    						if (textStatus == "success"){
  		    							if (jsonData.status == "success"){
  		    								$("#subscriptionList").trigger("reloadGrid"); 
  											top.layer.close(layers);									
  		    							}else{
  		    								top.layer.msg("<msg:message code='subscriptionService.refuseLoan.fail' />");
  										}
  		    						}
  		    					}
  		    				});
  				    		
  		   			 	});

                    });
                    </shiro:hasPermission>
                    
                    <shiro:hasPermission name="${tc_transaction_subscription_detail_code}">
                    $(".shortcut_detail").click(function () {
                        var rowid = $(this).attr("id");
                        window.location.href = "${base}/goto/subscription/jumpDetail?viewCode=${tc_transaction_subscription_detail_code}&isContextCode=1&id=" + rowid;
                    });
                    </shiro:hasPermission>
					
                    <shiro:hasPermission name="${tc_transaction_financeaudit_export_code}">
          	      	$("#top_export","#t_subscriptionList").click(function(){
          	    	  	var ids =  $("#subscriptionList").jqGrid('getDataIDs');
          	    	  	
          	    	  	var idsStr = "";
          	    	  	 for (var i = 0; i < ids.length; i++) {
          	    	  		 if(i == ids.length -1){
          	    	  			 idsStr += ids[i];
          	    	  		 }else{
          	    	            idsStr += ids[i]+",";
          	    	  		 }
          	    	  	 }
          	    	  	
          	    	  	 if(idsStr == null || idsStr == ""){
          		    	  		top.layer.msg("<msg:message code='subscriptionService.financeaudit.nodata' />");
          		    	    }else{
          				    	var layers = top.layer.confirm("您确定要导出当前所有订单吗？",  function(){
          				    		window.location.href="${base}/download/subscription/export?idStr="+idsStr;
          				    		top.layer.close(layers);
          		   			 	});
          	    	  	}
          	     	 });  
          	      	</shiro:hasPermission>
          	      	
          	      <shiro:hasPermission name="${tc_transaction_subscription_transfer_code}">
          	     $("#top_transfer","#t_subscriptionList").click(function(){
          	    	var ids =  $("#subscriptionList").jqGrid('getDataIDs');
          	    	var idsStr = "";
	   	    	  	 for (var i = 0; i < ids.length; i++) {
	   	    	  		 if(i == ids.length -1){
	   	    	  			 idsStr += ids[i];
	   	    	  		 }else{
	   	    	            idsStr += ids[i]+",";
	   	    	  		 }
	   	    	  	 }
          	    	if(ids == null || ids == ""){
         	    		top.layer.msg("<msg:message code='subscriptionService.transfer.nodata' />");
          	    	}else{
                      var layers = top.layer.confirm("您确定要将当前认购转账到SPV公司账户吗？",  function(){
				    		$.ajax({
		    					url:'${base}/ajax/submit/subscription/modifyLoanTransfer.json',
		    					data:{idStr:idsStr},
		    					type:'post',
		    					timeout:'60000',
		    					dataType:'json',
		    					success:function(jsonData,textStatus){
		    						
		    						if (textStatus == "success"){
		    							if (jsonData.status == "success"){
		    								$("#subscriptionList").trigger("reloadGrid"); 
		    								top.layer.msg("<msg:message code='subscriptionService.transfer.success' />",1,1);
		    							}else{
		    								top.layer.msg("<msg:message code='subscriptionService.transfer.fail' />");
										}
		    						}
		    					}
		    				});
				    		
		   			 	});
          	    	 }
                  });
                  </shiro:hasPermission>
                    
                },
                caption: '认购列表',
                toolbar: [true,"top"]
            });
            
            <shiro:hasPermission name="${tc_transaction_subscription_export_code}">
	            var $ea = $("<a></a>").attr("href","javascript:void(0)")
	            .attr("id","top_export")
	            .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
	                    .attr("width","18").attr("height","18").attr("border","0")
	                    .attr("border","0").attr("align","absmiddle"))
	            .append("一键导出");
       	 	$("#t_subscriptionList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));
            </shiro:hasPermission>
            
            <shiro:hasPermission name="${tc_transaction_subscription_transfer_code}">
            var $eatransfer = $("<a></a>").attr("href","javascript:void(0)")
            .attr("id","top_transfer")
            .append($("<img/>").attr("src","${base}/static/images/icon/modify.png")
                    .attr("width","18").attr("height","18").attr("border","0")
                    .attr("border","0").attr("align","absmiddle"))
            .append("一键放款");
	   	 	$("#t_subscriptionList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($eatransfer));
	        </shiro:hasPermission>
       	 	
        });
        jQuery("#subscriptionList").closest(".ui-jqgrid-bdiv").css("overflow-x", "hidden");
    </script>
    <script type="text/javascript">
        function search() {
            jQuery("#subscriptionList").jqGrid("setGridParam", {
                postData: {
                	productCode: $("#productCode").val(),
                    productName: $("#productName").val(),
                    startTime: $("#startTime").val(),
                    endTime: $("#endTime").val(),
                    iDCard: $("#iDCard").val(),
                    transactionNumber: $("#transactionNumber").val(),
                    tradeStatus: $("#tradeStatus").val(),
                    paymentState: $("#paymentState").val(),
                    businessCheckStatus: $("#businessCheckStatus").val(),
                    memberId: $("#memberId").val(),
                    mobilePhone: $("#mobilePhone").val(),
                    productCategoryId: $("#productCategoryId").val(),
                    loanStatus:$("#loanStatus").val()
                    },
                url:"${base}/ajax/getdata/subscription/paginated.json"
            }).trigger("reloadGrid");
         $("#statistics").remove(); 
       	 var normalamount = "<lable id='statistics'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交易数量:<lable id='count'></lable>条&nbsp;&nbsp;&nbsp;&nbsp;认购总金额:<lable id='totalInvestAmount'></lable>元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;预期收益总金额:<lable id='totalExpectedProfit'></lable>元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;实际放款金额:<lable id='totalAmount'></lable>"
      			+"&nbsp;&nbsp;&nbsp;&nbsp;平均预期收益率:<lable id='averageExpectedProfitRatio'></lable></lable>";
          $("#t_subscriptionList").append(normalamount);  
            
           $.ajax({
     			url:'${base}/ajax/getdata/subscription/ajaxSubscriptionSearch.json',
     			data:{
     				productCode: $("#productCode").val(),
                    productName: $("#productName").val(),
                    startTime: $("#startTime").val(),
                    endTime: $("#endTime").val(),
                    iDCard: $("#iDCard").val(),
                    transactionNumber: $("#transactionNumber").val(),
                    tradeStatus: $("#tradeStatus").val(),
                    paymentState: $("#paymentState").val(),
                    businessCheckStatus: $("#businessCheckStatus").val(),
                    memberId: $("#memberId").val(),
                    mobilePhone: $("#mobilePhone").val(),
                    productCategoryId: $("#productCategoryId").val(),
                    loanStatus:$("#loanStatus").val()},
     			type:'post',
     			timeout:'60000',
     			dataType:'json',
     			success:function(data,status){
     					if(status == "success"){
     						$("#count").text(data.count);
     						$("#totalInvestAmount").text(data.totalInvestAmount);
     						$("#totalExpectedProfit").text(data.totalExpectedProfit);
     						$("#averageExpectedProfitRatio").text(data.averageExpectedProfitRatio);
                            $("#totalAmount").text(data.totalActualLoanAmount);
     					}
     			}
   		  });
        }
    </script>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
    <tr id="qrytr">
        <td width="100%">
            <table cellpadding="0" height="85" cellspacing="0" border="1" width="100%">
                <tr>
                    <td width="5%">
                    </td>
                    <td>
                        <label for="product" style="float:left;line-height: 32px;">产品名称：</label>
                        <input type="text" id="productName" class="scinput" />
                    </td>
                     <td>
                        <label for="startTime" style="float:left;line-height: 32px;">认购开始时间：</label>
                        <input type="text" name="startTime" id="startTime" readonly="readonly"
                               class="scinput date twidth Wdate"
                               onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
                    </td>
                    <td>
                        <label for="product" style="float:left;line-height: 32px;">证件编号：</label>
                        <input type="text" id="iDCard" class="scinput" />
                    </td>
                    <td rowspan="3" valign="middle">
                        <shiro:hasPermission name="${tc_transaction_subscription_code}">
                            <button id="search" onclick="search();" class="scbtn" style="width: 100px;">查询</button>
                        </shiro:hasPermission>
                    </td>
                </tr>
                  <tr>
                 <td width="5%">
                    </td>
                     <td>
                        <label for="product" style="float:left;line-height: 32px;">产品编号：</label>
                        <input type="text" id="productCode" class="scinput" />
                    </td>
                    <td>
                        <label for="endTime" style="float:left;line-height: 32px;">认购结束时间：</label>
                        <input type="text" name="endTime" id="endTime" readonly="readonly"
                               class="scinput date twidth Wdate"
                               onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
                    </td>
                    <td>
                        <label for="transactionNumber" style="float:left;line-height: 32px;">交易编号：</label>
                        <input type="text" id="transactionNumber" class="scinput" />
                    </td>
                </tr>
                 <tr>
                    <td width="5%">
                    </td>
                    <td>
	                  <label for="productCategoryId" style="float:left;line-height: 32px;">产品类型：</label>
	                  <div class="vocation">
	                     <select name="productCategoryId" id="productCategoryId" class="select3">
	                     		<option value="">请选择</option>
	               			<c:forEach var="category" items="${categoryList}">
		                   		<option value="${category.id}">${category.name}</option>
		                   </c:forEach>
		               </select>
	                  </div>
	             	 </td>
	             	 <td>
                   <label for="mobilePhone" style="float:left;line-height: 32px;">客户手机号码：</label>
                   <div class="vocation">
                       <input type="text" id="mobilePhone" class="scinput" />
                   </div>
               </td>
                <td>
	                  <label for="memberId" style="float:left;line-height: 32px;">客户标识：</label>
	                  <div class="vocation">
	                     <input type="text" id="memberId" class="scinput" />
	                  </div>
	             	 </td>
                    <td>
                    </td>
                </tr>
                 <tr>
                    <td width="5%">
                    </td>
                    <td>
	                  <label for="tradeStatus" style="float:left;line-height: 32px;">交易状态：</label>
	                  <div class="vocation">
	                      <select name="tradeStatus" id="tradeStatus" class="select3">
	                          <option value="">请选择</option>
	                          <option value="1">存续中</option>
	                          <option value="2">兑付中</option>
	                          <option value="3">已兑付</option>
	                          <option value="4">兑付失败</option>
	                          <option value="5">延期</option>
	                          <option value="6">已退款</option>
	                          <option value="0">认购失败</option>
	                      </select>
	                  </div>
	             	 </td>
	             	  <td>
                        <label for="distributeStatus" style="float:left;line-height: 32px;">回款分账状态：</label>
	                  <div class="vocation">
	                      <select name="distributeStatus" id="distributeStatus" class="select3">
	                          <option value="">请选择</option>
	                          <option value="0">分账失败</option>
	                          <option value="1">分账成功</option>
	                      </select>
	                  </div>
                    </td>
                    <td>
                        <label for="loanStatus" style="float:left;line-height: 32px;">放款状态：</label>
                        <div class="vocation">
                            <select name="loanStatus" id="loanStatus" class="select3">
                                <option value="">请选择</option>
                                <option value="0">未放款</option>
                                <option value="1">已放款</option>
                                <option value="2">放款成功</option>
                                <option value="3">放款失败</option>
                                <option value="4">拒绝放款</option>
                            </select>
                        </div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
    <td width="100%" colspan="3">
        <form:form method="post" action="subscription" commandName="subscription" name="f">
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tr>
                    <td>
                        <table id="subscriptionList">
                            <tr>
                                <td>&nbsp;</td>
                            </tr>
                        </table>
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
</table>
</div>
<div class="form-footer" id="rtnBtn" style="display: none;">
    <input type="button" onclick="window.location.href='${base}/history/back/${tc_statistics_statistics_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
</div>
<script type="text/javascript">
    $('.select3').uedSelect({width: 150})
    if("${productId}" != "") {
        $("#qrytr").css("display","none");
        $("#rtnBtn").css("display","");

    }
</script>
</body>
</html>