<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function(){
    jQuery("#feedbackList").jqGrid({
        url: '${base}/ajax/getdata/feedback/paginated.json',
        datatype: 'json',
        colNames: [
			    "<msg:message code='feedback.nickName'/>",
			    "<msg:message code='feedback.email'/>", 
			    "<msg:message code='feedback.mobilePhone'/>", 
			    "<msg:message code='feedback.state'/>",
			    "<msg:message code='feedback.createTime'/>",
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			   {name:'nickName',index:'nickName',width:'10%',align:'center',hidden: false,sortable:false},
			   {name:'email',index:'email',width:'20%',align:'center',hidden: false,sortable:false}, 
			   {name:'mobilePhone',index:'mobilePhone',width:'15%',align:'center',hidden: false,sortable:false},
			   {name:'state',index:'state',width:'10%',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
				   if(cellvalue == "0"){
					   return "未处理";
				   }else if(cellvalue == "1"){
					   return "已处理";
				   }else if(cellvalue == "2") {
					   return "处理中";
				   }
			   }},
			   {name:'createTime',index:'createTime',width:'20%',align:'center',hidden: false,sortable:false},
			   {name:'act',index:'act',width:'30%',align:'center',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${feedback.c}'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="feedback.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="feedback.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#feedbackList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
			   	<shiro:hasPermission name="${cc_feedback_feedbackquery_modify_code}">
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
    		    <shiro:hasPermission name="${cc_feedback_feedbackquery_detail_code}">
			   	content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_detail' ";
    			content += " title='明细'>";
    			content += "<img src='${base}/static/images/icon/detail.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "明细";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="${cc_feedback_feedbackquery_delete_code}">
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
    			content += " title='删除'>";
    			content += "<img src='${base}/static/images/icon/delete.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "删除";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#feedbackList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    	},
    	loadComplete:function(){
    		
			<shiro:hasPermission name="${cc_feedback_feedbackquery_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
				window.location.href="${base}/goto/feedback/jumpModify?viewCode=${cc_feedback_feedbackquery_modify_code}&isContextCode=1&id="+rowid;
    	    });
    	    </shiro:hasPermission>
    	    <shiro:hasPermission name="${cc_feedback_feedbackquery_detail_code}">
    	    $(".shortcut_detail").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/feedback/jumpDetail?viewCode=${cc_feedback_feedbackquery_detail_code}&isContextCode=1&id="+rowid;
    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${cc_feedback_feedbackquery_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#feedbackList").jqGrid("getRowData",rowid);
    	    	var records = $("#feedbackList").getGridParam("records");
    	    	var page = $("#feedbackList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
					var url = "${base}/ajax/submit/feedback/delete.json?id=" + rowid+"&isLog=1&replaceName="+data.nickName;
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
    										jQuery("#feedbackList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#feedbackList").trigger("reloadGrid"); 
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
    	},
        caption:'<msg:message code="feedback.list"/>'
    });
});
jQuery("#feedbackList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
<script type="text/javascript">
function search (){
	jQuery("#feedbackList").jqGrid("setGridParam",{postData:{
		nickName:$("#nickName").val(),
		email:$("#email").val(),
		state:$("#state").val(),
		mobilePhone:$("#mobilePhone").val()
		}
	}).trigger("reloadGrid");
}
</script>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
	<tr>
		<td width="100%">
			<table cellpadding="0" height="60" cellspacing="0" border="1" width="100%">
				<tr>
					<td width="5%">
					</td>
					<td>
						<label for="nickname" style="float:left;line-height: 32px;">会员昵称：</label>
						<input type="text" name="nickname" id="nickname" value="${member.nickname}" class="scinput"/>
					</td>
					<td>
						<label for="mobilePhone" style="float:left;line-height: 32px;">手机号：</label>
						<input type="text" name="mobilePhone" id="mobilePhone" value="${feedback.mobilePhone}" class="scinput"/>
					</td>
					<td>
						<label for="email" style="float:left;line-height: 32px;">邮箱地址：</label>
						<input type="text" name="email" id="email" value="${feedback.email}" class="scinput"/>
					</td>
					<td>
						<label for="state" style="float:left;line-height:32px; margin-top:2px; display;inline-block; padding-top:7px;">处理状态：</label>
						<div class="vocation">
							<select name="state" id="state" class="select3">
								<option value="">请选择</option>
								<option value="0">未处理</option>
								<option value="1">已处理</option>
								<option value="2">处理中</option>
							</select>
						</div>
					</td>
					<td valign="middle">
						<button  id="search" onclick="search();" class="scbtn" style="width: 100px;">查询</button>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td width="100%" colspan="3">
			<form:form method="post" action="feedback" commandName="noticefeedback" name="f">
			<input type="hidden" name="c" value="${feedback.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="feedbackList"><tr><td>&nbsp;</td></tr></table>	
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
	$('.select3').uedSelect({width:150})
</script>
</body>
</html>