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
            jQuery("#newplayerProductList").jqGrid({
                url: '${base}/ajax/getdata/subscription/statisticsIndex.json',
                datatype: 'json',
                emptyrecords:"无销售记录！",
                colNames: [
                    "产品ID",
                    "产品名称",
                    "日期",
                    "售出金额(元)",
                    "订单数",
                    "操作"
                ],
                colModel: [
                    {name: 'ProductId', index: 'ProductId', width: '25%', align: 'center', hidden: true, sortable: false},
                    {name: 'ProductName', index: 'createTime', width: '25%', align: 'center', hidden: false, sortable: false},
                    {name: 'OrderDate', index: 'OrderDate', width: '25%', align: 'center', hidden: false, sortable: false},
                    {name: 'InvestAmount', index: 'product.name', width: '15%', align: 'center', hidden: false, sortable: false},
                    {name: 'orderCount', index: 'counterpartyName', width: '15%', align: 'center', hidden: false, sortable: false},
                    {name:'act',index:'act',width:'15%',align:'center',sortable:false,title:false}
                ],
                mtype: "POST",
                postData: {remark:'1'},
                rowNum: "10",
                page: "1",
                rowList: [<msg:message code="member.jqgrid.row.list.s10.10"/>],
                pager: '#pagered',
                height: '<msg:message code="log.jqgrid.height.400"/>',
                autowidth: true,
                viewrecords: true,
                multiselect: false,
                jsonReader: {
                    repeatitems: false,
                    id: "ProductId",
//                    usrData:'userdata'
                },
                caption: '收益权转让回购产品统计',
                gridComplete: function(){
                    //快捷菜单
                    var ids = jQuery("#newplayerProductList").jqGrid('getDataIDs');
                    for(var i=0;i < ids.length;i++){
                        var id = ids[i];
                        var content = "";
                        content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_detail' ";
                        content += " title='查看明细'>";
                        content += "<img src='${base}/static/images/icon/detail.png'";
                        content += " weight='18' height='18' border='0' align='absmiddle'/>";
                        content += "查看明细";
                        content += "</a>";
                        jQuery("#newplayerProductList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
                    }
                },
                loadComplete:function(){
                    $(".shortcut_detail").click(function(){
                        var productId = $(this).attr("id");
                        var data = jQuery("#newplayerProductList").jqGrid("getRowData",productId);
                        var orderDate = data.OrderDate;
                        var url = "${base}/goto/subscription/subscriptionIndex?productId="+productId + "&orderTime=" + orderDate + "&isContextCode=1&viewCode=${tc_transaction_subscription_code}";
                        window.location.href = url;
                        //window.open(url);
//                        window.open(url,'_self');
                        //location.href=url;
                    });

                },
                toolbar: [true,"bottom"]
            });

            var amount = "<lable id='amount'>累计售出额度&nbsp;:&nbsp;<lable id='totalFlowIn'>${newProductInvestAmount}</lable>&nbsp;元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;累计订单数&nbsp;:&nbsp;<lable id='totalFlowOut'>${newProductorderCount}</lable>";
            $("#t_newplayerProductList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append(amount));
        });
        jQuery("#newplayerProductList").closest(".ui-jqgrid-bdiv").css("overflow-x", "hidden");




        $(document).ready(function () {
            jQuery("#productList").jqGrid({
                url: '${base}/ajax/getdata/subscription/statisticsIndex.json',
                datatype: 'json',
                emptyrecords:"无销售记录！",
                colNames: [
                    "产品ID",
                    "产品名称",
                    "产品总金额(元)",
                    "累计售出金额(元)",
                    "累计订单数",
                    "剩余金额(元)",
                    "剩余占比",
                    "操作"
                ],
                colModel: [
                    {name: 'ProductId', index: 'ProductId', width: '25%', align: 'center', hidden: true, sortable: false},
                    {name: 'ProductName', index: 'createTime', width: '25%', align: 'center', hidden: false, sortable: false},
                    {name: 'TotalAmount', index: 'transactionNumber', width: '15%', align: 'center', hidden: false, sortable: false},
                    {name: 'InvestAmount', index: 'product.name', width: '15%', align: 'center', hidden: false, sortable: false},
                    {name: 'orderCount', index: 'counterpartyName', width: '15%', align: 'center', hidden: false, sortable: false},
                    {name: 'SurplusAmount', index: 'amount', width: '15%', align: 'center', hidden: false, sortable: false},
                    {name: 'SurplusRate', index: 'flowTo', width: '15%', align: 'center', hidden: false, sortable: false,formatter:function(data){
                        return data + "%";
                    }},
                    {name:'act',index:'act',width:'15%',align:'center',sortable:false,title:false}
                ],
                mtype: "POST",
                postData: {remark:'2'},
                rowNum: "10",
                page: "1",
                rowList: [<msg:message code="member.jqgrid.row.list.s10.10"/>],
                pager: '#pagered',
                height: '<msg:message code="log.jqgrid.height.400"/>',
                autowidth: true,
                viewrecords: true,
                multiselect: false,
                jsonReader: {
                    repeatitems: false,
    //                    usrData:'userdata'
                    id: "ProductId", //相当于设置主键
                },
                caption: '收益权转让产品统计',
                gridComplete: function(){
                    //快捷菜单
                    var ids = jQuery("#productList").jqGrid('getDataIDs');
                    for(var i=0;i < ids.length;i++){
                        var id = ids[i];
                        var content = "";
                        content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_detail2' ";
                        content += " title='查看明细'>";
                        content += "<img src='${base}/static/images/icon/detail.png'";
                        content += " weight='18' height='18' border='0' align='absmiddle'/>";
                        content += "查看明细";
                        content += "</a>";
                        jQuery("#productList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
                    }
                },
                loadComplete:function(){
                    $(".shortcut_detail2").click(function(){
                        var productId = $(this).attr("id");
                        window.location.href="${base} /goto/subscription/subscriptionIndex?viewCode=${tc_transaction_subscription_code}&isContextCode=1&productId="+productId;
                    });
                },
                toolbar: [true,"bottom"]
            });
        });
        jQuery("#newplayerProductList").closest(".ui-jqgrid-bdiv").css("overflow-x", "hidden");

    </script>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
    <tr>
        <td width="100%" colspan="3">
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tr>
                    <td>
                        <table id="newplayerProductList">
                            <tr>
                                <td>&nbsp;</td>
                            </tr>
                        </table>
                        <div id="pagered"></div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td class="tableMargin"></td>
    </tr>
</table>
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
    <tr>
        <td width="100%" colspan="3">
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tr>
                    <td>
                        <table id="productList">
                            <tr>
                                <td>&nbsp;</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td class="tableMargin"></td>
    </tr>
</table>
</div>
</body>
</html>