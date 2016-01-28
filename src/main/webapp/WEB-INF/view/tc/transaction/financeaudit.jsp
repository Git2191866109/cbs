<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/view/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title></title>
  <jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
  <script type="text/javascript">
    $(document).ready(function () {
      jQuery("#subscriptionList").jqGrid({
        url: '',
        datatype: 'json',
        colNames: [
				   "<msg:message code='subscription.memberId'/>",
                   "<msg:message code='productReturnMoney.transactionNumber'/>",
                   "<msg:message code='productReturnMoney.productName'/>",
                   "<msg:message code='productReturnMoney.productCode'/>",
                   "<msg:message code='productReturnMoney.businessCheckStatus'/>",
                   "<msg:message code='productReturnMoney.returnStatus'/>",
                   "<msg:message code='productReturnMoney.returnTime'/>",
                   "<msg:message code='productReturnMoney.distributePrincipal'/>",
                   "<msg:message code='productReturnMoney.distributeInterest'/>",
                   "<msg:message code='productReturnMoney.distributeAmount'/>",
                   "<msg:message code='productReturnMoney.actualProfitRatio'/>",
                   "<msg:message code='productReturnMoney.actualReturnAmount'/>",
                   "<msg:message code='productReturnMoney.memberServiceFee'/>",
                   "<msg:message code='info.operate'/>"
               ],
               colModel: [
                   {name: 'memberId', index: 'memberId', width: '5%', align: 'center', hidden: false, sortable: false},
                   {name: 'transactionNumber', index: 'transactionNumber', width: '15%', align: 'center', hidden: false, sortable: false},
                   {name: 'productName', index: 'productName', width: '10%', align: 'center', hidden: false, sortable: false},
                   {name: 'productCode', index: 'productCode', width: '15%', align: 'center', hidden: false, sortable: false},
                   {name: 'businessCheckStatus', index: 'businessCheckStatus', width: '5%', align: 'center', hidden: false, sortable: false,formatter:function(cellvalue,options,rowObject){
	                   	if(cellvalue == 0){
	                		return "待审核";
	                	}else if(cellvalue == 1){
	                		return "审核通过";
	                	}else if(cellvalue == 2){
	                		return "审核不通过";
	                	}
	                }},
	                {name: 'returnStatus', index: 'returnStatus', width: '5%', align: 'center', hidden: false, sortable: false,formatter:function(cellvalue,options,rowObject){
	                   	if(cellvalue == 0){
	                		return "未返款";
	                	}else if(cellvalue == 1){
	                		return "已返款";
	                	}else if(cellvalue == 2){
	                		return "返款成功";
	                	}else if(cellvalue == 3){
	                		return "返款失败";
	                	}else if(cellvalue == 4){
	                		return "拒绝返款";
	                	}
	                }},
	               {name: 'returnTime', index: 'returnTime', width: '5%', align: 'center', hidden: false, sortable: false},
	               {name: 'distributePrincipal', index: 'distributePrincipal', width: '5%', align: 'center', hidden: false, sortable: false},
                   {name: 'distributeInterest', index: 'distributeInterest', width: '15%', align: 'center', hidden: false, sortable: false},
                   {name: 'distributeAmount', index: 'distributeAmount', width: '10%', align: 'center', hidden: false, sortable: false},
                   {name: 'actualProfitRatio', index: 'actualProfitRatio', width: '15%', align: 'center', hidden: false, sortable: false},
                   {name: 'actualReturnAmount', index: 'actualReturnAmount', width: '15%', align: 'center', hidden: false, sortable: false},
                   {name: 'memberServiceFee', index: 'serviceFee', width: '15%', align: 'center', hidden: false, sortable: false},
                   {name: 'act', index: 'act', width: '35%', align: 'center', sortable: false, title: false}

               ],
        mtype: "POST",
        postData: {productId:$("#productId").val()},
        rowNum: "100000",
        page: "1",
        rowList: [<msg:message code="subscription.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height: '<msg:message code="log.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
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
			if(datas.returnStatus == '未返款' || datas.returnStatus == '返款失败'){
	            <shiro:hasPermission name="${tc_transaction_businessaudit_check_code}">
	            content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_pay' ";
	            content += " title='返款'>";
	            content += "<img src='${base}/static/images/icon/detail.png'";
	            content += " weight='18' height='18' border='0' align='absmiddle'/>";
	            content += "返款";
	            content += "</a>";
	            </shiro:hasPermission>
	            
	            <shiro:hasPermission name="${tc_transaction_businessaudit_check_code}">
	            content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_refusepay' ";
	            content += " title='拒付'>";
	            content += "<img src='${base}/static/images/icon/detail.png'";
	            content += " weight='18' height='18' border='0' align='absmiddle'/>";
	            content += "拒付";
	            content += "</a>";
	            </shiro:hasPermission>
			}
            <shiro:hasPermission name="${tc_transaction_financeaudit_paynote_code}">
            content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_remark' ";
            content += " title=支付说明'>";
            content += "<img src='${base}/static/images/icon/modify.png'";
            content += " weight='18' height='18' border='0' align='absmiddle'/>";
            content += "支付说明";
            content += "</a>";
            </shiro:hasPermission>
            jQuery("#subscriptionList").jqGrid('setRowData', ids[i], {act: "<div class='jqgridContainer'>" + content + "</div>"});
          }
        },
        loadComplete: function () {
          <shiro:hasPermission name="${tc_transaction_financeaudit_paynote_code}">
          $(".shortcut_remark").click(function () {
	            var rowid = $(this).attr("id");
	            window.location.href="${base}/goto/productReturnMoney/jumpProductReturnMoneyRemark?viewCode=${tc_transaction_businessaudit_remark_code}&isContextCode=1&id="+rowid;

          });
          </shiro:hasPermission>
			
          
          <shiro:hasPermission name="${tc_transaction_financeaudit_pay_code}">
          $(".shortcut_pay").click(function () {
	            var rowid = $(this).attr("id");
	            var layers = top.layer.confirm("您确定要返款通过所选择交易吗？",  function(){
		    		$.ajax({
    					url:'${base}/ajax/submit/productReturnMoney/modifyReturnStatus.json',
    					data:{idStr:rowid,returnStatus:1},
    					type:'post',
    					timeout:'60000',
    					dataType:'json',
    					success:function(jsonData,textStatus){
    						if (textStatus == "success"){
    							if (jsonData.status == "success"){
    								$("#subscriptionList").trigger("reloadGrid"); 
    								top.layer.msg("<msg:message code='productReturnMoneyService.modifyReturnStatus.success' />",1,1);									
    							}else{
    								top.layer.msg("<msg:message code='productReturnMoneyService.modifyReturnStatus.fail' />");
								}
    						}
    					}
    				});
   			 	});

          });
          </shiro:hasPermission>
          
          <shiro:hasPermission name="${tc_transaction_financeaudit_pay_code}">
          $(".shortcut_refusepay").click(function () {
	            var rowid = $(this).attr("id");
	            var layers = top.layer.confirm("您确定要拒绝返款所选择交易吗？",  function(){
		    		$.ajax({
    					url:'${base}/ajax/submit/productReturnMoney/modify.json',
    					data:{idStr:rowid,returnStatus:4},
    					type:'post',
    					timeout:'60000',
    					dataType:'json',
    					success:function(jsonData,textStatus){
    						if (textStatus == "success"){
    							if (jsonData.status == "success"){
    								$("#subscriptionList").trigger("reloadGrid"); 
									top.layer.close(layers);									
    							}else{
    								top.layer.msg("<msg:message code='subscriptionService.refuse.fail' />");
								}
    						}
    					}
    				});
   			 	});

          });
          </shiro:hasPermission>
          
          <shiro:hasPermission name="${tc_transaction_financeaudit_pay_code}">
	      $("#top_batch_check","#t_subscriptionList").click(function(){
	    
		    	var ids = $("#subscriptionList").jqGrid('getGridParam','selarrrow');
		    	
		    	var idsStr = "";
	    	  	 for (var i = 0; i < ids.length; i++) {
	    	  		 if(i == ids.length -1){
	    	  			 idsStr += ids[i];
	    	  		 }else{
	    	            idsStr += ids[i]+",";
	    	  		 }
	    	  	 }
		    	
	    	    if(ids == null || ids == ""){
	    	  		top.layer.msg("<msg:message code='subscriptionService.return.select' />");
	    	    }else{
			    	var layers = top.layer.confirm("您确定要返款通过所选择交易吗？",  function(){
			    		$.ajax({
	    					url:'${base}/ajax/submit/productReturnMoney/modifyReturnStatus.json',
	    					data:{idStr:idsStr,returnStatus:1},
	    					type:'post',
	    					timeout:'60000',
	    					dataType:'json',
	    					success:function(jsonData,textStatus){
	    						if (textStatus == "success"){
	    							if (jsonData.status == "success"){
	    								$("#subscriptionList").trigger("reloadGrid"); 
	    								top.layer.msg("<msg:message code='productReturnMoneyService.modifyReturnStatus.success' />",1,1);								
	    							}else{
	    								top.layer.msg("<msg:message code='productReturnMoneyService.modifyReturnStatus.fail' />");
									}
	    						}
	    					}
	    				});
	   			 	});
	    	  	}
	      });  
	      </shiro:hasPermission>
	      
	      <shiro:hasPermission name="${tc_transaction_financeaudit_pay_code}">
	      $("#top_onekey_check","#t_subscriptionList").click(function(){
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
		    	  		top.layer.msg("<msg:message code='subscriptionService.businessaudit.nodata' />");
		    	    }else{
				    	var layers = top.layer.confirm("您确定要返款通过所选择交易吗？",  function(){
				    		$.ajax({
		    					url:'${base}/ajax/submit/productReturnMoney/modifyReturnStatus.json',
		    					data:{idStr:idsStr,returnStatus:1},
		    					type:'post',
		    					timeout:'60000',
		    					dataType:'json',
		    					success:function(jsonData,textStatus){
		    						if (textStatus == "success"){
		    							if (jsonData.status == "success"){
		    								$("#subscriptionList").trigger("reloadGrid"); 
		    								top.layer.msg("<msg:message code='productReturnMoneyService.modifyReturnStatus.success' />",1,1);									
		    							}else{
		    								top.layer.msg("<msg:message code='productReturnMoneyService.modifyReturnStatus.fail' />");
										}
		    						}
		    					}
		    				});
		   			 	});
	    	  	}
	      });  
	      </shiro:hasPermission>
		    
        },
        caption: '兑付审核列表',
        toolbar: [true,"top"]
      });
      
    //top菜单
      var $ea = $("<a></a>").attr("href","javascript:void(0)")
     			  .attr("id","top_batch_check")
     			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
  			  .attr("width","18").attr("height","18").attr("border","0")
  			  .attr("border","0").attr("align","absmiddle"))
  			  .append("批量返款");
    
      var $eall = $("<a></a>").attr("href","javascript:void(0)")
		  .attr("id","top_onekey_check")
		  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
	  .attr("width","18").attr("height","18").attr("border","0")
	  .attr("border","0").attr("align","absmiddle"))
	  .append("一键返款");
     // var newamount = "<lable id='amount'>新手产品本金总计:"+'${totalPrincipal}'+"元&nbsp;&nbsp;&nbsp;&nbsp;利息总计:"+'${totalInterest}'+"元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单总数:<lable id='totalCount'>"+'${count}'+"</lable>条</lable>";
  	   $("#t_subscriptionList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($eall).append("&nbsp;&nbsp;").append($ea));   
    });
    jQuery("#subscriptionList").closest(".ui-jqgrid-bdiv").css("overflow-x", "hidden");
  </script>
  <script type="text/javascript">
  function search() {
	  $("#amount").remove();
	  var productId = $("#productId").val();
	  
      jQuery("#subscriptionList").jqGrid("setGridParam", {
          postData: {
              productId: productId,
              startTime: $("#startTime").val(),
              endTime: $("#endTime").val(),
              memberId: $("#memberId").val(),
              transactionNumber: $("#transactionNumber").val(),
              returnStatus:$("#returnStatus").val()
          },
          url:"${base}/ajax/getdata/productReturnMoney/financeAuditPaginated.json"
      }).trigger("reloadGrid");
      
      
      $.ajax({
			url:'${base}/ajax/getdata/productReturnMoney/ajaxSearch.json',
			data:{productId: productId,
              startTime: $("#startTime").val(),
              endTime: $("#endTime").val(),
              memberId: $("#memberId").val(),
              transactionNumber: $("#transactionNumber").val(),
              returnStatus:$("#returnStatus").val()
            },
			type:'post',
			timeout:'60000',
			dataType:'json',
			success:function(data,status){
					if(status == "success"){
						var normalamount = "";
						if(data.isNewbeeProduct == 1){
							 normalamount = "<lable id='amount'>新手产品本金总计:<lable id='totalPrincipal'></lable>元&nbsp;&nbsp;&nbsp;&nbsp;利息总计:<lable id='totalInterest'></lable>元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单总数:<lable id='totalCount'></lable>条</lable>";
						}else{
							normalamount = "<lable id='amount'>&nbsp;&nbsp;实际交易:本金(<lable id='totalPrincipal'></lable>元)+利息(<lable id='totalInterest'></lable>元)=本息(<lable id='totalPrincipalAndInterest'></lable>元)&nbsp;&nbsp;&nbsp;&nbsp;"
								+"预期交易本息:<lable id='totalExceptionPrincipalAndInterest'></lable>元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;产品总本息:<lable id='totalAmount'></lable>元</lable>";
						}
						$("#t_subscriptionList").append(normalamount);  
						$("#totalPrincipal").text(data.totalInvestAmount);
						$("#totalInterest").text(data.totalInterest);
						$("#totalCount").text(data.count);
						$("#totalPrincipalAndInterest").text(data.totalPrincipalAndInterest);
						$("#totalExceptionPrincipalAndInterest").text(data.totalExceptionPrincipalAndInterest);
						$("#totalAmount").text(data.totalAmount);
					}
			}
		});
  }
  </script>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
  <tr>
    <td width="100%">
      <table cellpadding="0" height="85" cellspacing="0" border="1" width="100%">
        <tr>
           <td width="5%">
           </td>
	            <td>
	                <label for="product" style="float:left;line-height: 32px;">产品名称：</label>
	                <div class="vocation">
		               <select name="productId" id="productId" class="select3">
		               			<option value="">请选择</option>
	               			<c:forEach var="product" items="${productList}">
		                   		<option value="${product.id}">${product.name}</option>
		                   </c:forEach>
		               </select>
	           </div>
	            </td>
	             <td>
	                <label for="startTime" style="float:left;line-height: 32px;">分账开始时间：</label>
	                <input type="text" name="startTime" id="startTime" readonly="readonly"
	                       class="scinput date twidth Wdate"
	                       onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
	            </td>
	             <td>
	                <label for="product" style="float:left;line-height: 32px;">交易编号：</label>
	                <input type="text" id="transactionNumber" class="scinput" />
	            </td>
	            <td rowspan="3" valign="middle">
	                <shiro:hasPermission name="${tc_transaction_businessaudit_code}">
	                    <button id="search" class="scbtn" onclick="search();" style="width: 100px;">查询</button>
	                </shiro:hasPermission>
	            </td>
	        </tr>
	          <tr>
	         <td width="5%">
	            </td>
	            <td>
	                <label for="returnStatus" style="float:left;line-height: 35px;">返款状态：</label>
	                <div class="vocation">
		                <select name="returnStatus" id="returnStatus" class="select3">
		                	<option>请选择</option>
		                	<option value="0">未返款</option>
		                	<option value="1">已返款</option>
		                	<option value="2">返款成功</option>
		                	<option value="3">返款失败</option>
		                	<option value="4">拒绝返款</option>
		                </select>
	                </div>
	            </td>
	            <td>
	                <label for="endTime" style="float:left;line-height: 32px;">分账结束时间：</label>
	                <input type="text" name="endTime" id="endTime" readonly="readonly"
	                       class="scinput date twidth Wdate"
	                       onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
	            </td>
	           	 <td>
	                <label for="memberId" style="float:left;line-height: 32px;">客户标识：</label>
	                <input type="text" id="memberId" class="scinput" />
	            </td>
	        </tr>
	        <tr>
	            <td width="5%">
	            </td>
	            <td>
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
<script type="text/javascript">
  $('.select3').uedSelect({width: 150})
</script>
</body>
</html>