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
      jQuery("#accountingDetailList").jqGrid({
        url: '',
        datatype: 'json',
        colNames: [
          "交易时间",
          "交易单号",
          "产品名称",
          "客户名称",
          "交易金额",
          "资金流向",
          "业务类型",
          "财务类型"
        ],
        colModel: [
          {name: 'createTime', index: 'createTime', width: '15%', align: 'center', hidden: false, sortable: false},
          {name: 'transactionNumber', index: 'transactionNumber', width: '15%', align: 'center', hidden: false, sortable: false},
          {name: 'product.name', index: 'product.name', width: '15%', align: 'center', hidden: false, sortable: false},
          {name: 'member.name', index: 'member.name', width: '15%', align: 'center', hidden: false, sortable: false},
          {name: 'amount', index: 'amount', width: '15%', align: 'center', hidden: false, sortable: false},
          {name: 'flowTo', index: 'flowTo', width: '15%', align: 'center', hidden: false, sortable: false,formatter:function(data){
        	  if(data == 1){
        		  return "进账";
        	  }else if(data == 0){
        		  return "出账";
        	  }
          }},
          {name: 'businessType', index: 'businessType', width: '15%', align: 'center', hidden: false, sortable: false,formatter:function(data){
        	  if(data == 1){
        		  return "认购订单";
        	  }else if(data == 2){
        		  return "赎回订单";
        	  }else if(data == 3){
        		  return "活动";
        	  }
          }},
          {name: 'accountType', index: 'accountType', width: '15%', align: 'center', hidden: false, sortable: false,formatter:function(data){
        	  if(data == 1){
        		  return "本金";
        	  }else if(data == 2){
        		  return "利息";
        	  }else if(data == 3){
        		  return "手续费";
        	  }else if(data == 4){
        		  return "服务费";
        	  }else if(data == 5){
        		  return "本金+利息";
        	  }
          }}
        ],
        mtype: "POST",
        postData: {},
        rowNum: "10",
        page: "1",
        rowList: [<msg:message code="member.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height: '220',
        autowidth: true,
        viewrecords: true,
        multiselect: false,
        jsonReader: {
          repeatitems: false,
          userdata:'userdata'
        },
        caption: '客户资金流水列表',
        toolbar: [true,"top"]
      });
      
    });
    jQuery("#accountingDetailList").closest(".ui-jqgrid-bdiv").css("overflow-x", "hidden");
    
  </script>
  <script type="text/javascript">
    function search() {
      $("#amount").remove();
      jQuery("#accountingDetailList").jqGrid("setGridParam", {
        postData: {
          productId: $("#productId").val(),
          flowTo: $("#flowTo").val(),
          startTime: $("#startTime").val(),
          endTime: $("#endTime").val(),
          businessType: $("#businessType").val(),
          clientName: $("#clientName").val(),
          accountType: $("#accountType").val()
        },
      url:'${base}/ajax/getdata/accountingDetail/selectClientPaginated.json'
      }).trigger("reloadGrid");
      
      var amount = "<lable id='amount'>流入统计:<lable id='totalFlowIn'></lable>元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;流出统计:<lable id='totalFlowOut'></lable>元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;流出流入总计:<lable id='totalFlow'></lable>元</lable>";
	  $("#t_accountingDetailList").append($("<span></span>").attr("class","jqgridContainer").append(amount));
	  
	  $.ajax({
			url:'${base}/ajax/getdata/accountingDetail/searchStaticesFlow.json',
			data:{ productId: $("#productId").val(),
		          flowTo: $("#flowTo").val(),
		          startTime: $("#startTime").val(),
		          endTime: $("#endTime").val(),
		          businessType: $("#businessType").val(),
		          clientName: $("#clientName").val(),
		          accountType: $("#accountType").val()},
			type:'post',
			timeout:'60000',
			dataType:'json',
			success:function(data,status){
					if(status == "success"){
						$("#totalFlowIn").text(data.totalFlowIn);
						$("#totalFlowOut").text(data.totalFlowOut);
						$("#totalFlow").text(data.totalFlow);
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
               			<c:forEach var="product" items="${productList}">
	                   		<option value="${product.id}">${product.name}</option>
	                   </c:forEach>
	               </select>
           		</div>
           </td>
         <td>
            <label for="product" style="float:left;line-height: 32px;">资金流向：</label>

            <div class="vocation">
              <select name="product>" id="flowTo" class="select3">
                <option value="">请选择</option>
                <option value="0">出帐</option>
                <option value="1">进账</option>
              </select>
            </div>
          </td>
          <td>
               <label for="startTime" style="float:left;line-height: 32px;">流水开始时间：</label>
               <input type="text" name="startTime" id="startTime" readonly="readonly"
                      class="scinput date twidth Wdate"
                      onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
           </td>
          <td rowspan="2" valign="middle">
            <shiro:hasPermission name="${tc_accounting_clientflow_code}">
              <button id="search" onclick="search();" class="scbtn" style="width: 100px;">查询</button>
            </shiro:hasPermission>
          </td>
        </tr>
        <tr>
          <td width="5%">
          </td>
          <td>
            <label for="statusname1" style="float:left;line-height: 32px;">财务类型：</label>

            <div class="vocation">
              <select name="" id="accountType" class="select3">
                <option value="">请选择</option>
                <option value="1">本金</option>
                <option value="2">利息</option>
                <option value="3">手续费</option>
                <option value="4">服务费</option>
                <option value="5">本金+利息</option>
              </select>
            </div>
          </td>
           <td>
            <label for="businessType" style="float:left;line-height: 32px;">业务类型：</label>

            <div class="vocation">
              <select name="businessType" id="businessType" class="select3">
                <option value="">请选择</option>
                <option value="0">认购</option>
                <option value="1">赎回</option>
                <option value="2">活动</option>
              </select>
            </div>
          </td>
          <td>
               <label for="startTime" style="float:left;line-height: 32px;"> 流水结束时间：</label>
               <input type="text" name="startTime" id="startTime" readonly="readonly"
                      class="scinput date twidth Wdate"
                      onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
           </td>
        </tr>
        <tr>
         <td width="5%"></td>
        	<td>
                <label for="transactionNumber" style="float:left;line-height: 32px;">交易编号：</label>
                <input type="text" id="transactionNumber" class="scinput" />
            </td>
        	<td>
                <label for="clientName" style="float:left;line-height: 32px;">客户名称：</label>
                <input type="text" id="clientName" class="scinput" />
            </td>
        <td></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td width="100%" colspan="3">
      <form:form method="post" action="accountingDetail" commandName="accountingDetail" name="f">
        <table cellpadding="0" cellspacing="0" border="0" width="100%">
          <tr>
            <td>
              <table id="accountingDetailList">
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