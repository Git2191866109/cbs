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
    jQuery("#memberList").jqGrid({
        url: '${base}/ajax/getdata/member/paginated.json',
        datatype: 'json',
        colNames: [
				"<msg:message code='member.id'/>",
				"<msg:message code='member.name'/>", 
				"<msg:message code='member.phoneAccount'/>", 
				"<msg:message code='member.type'/>", 
			    "<msg:message code='accounting.availableAmount'/>", 
			    "<msg:message code='accounting.frozenAmount'/>", 
			    "<msg:message code='member.male'/>", 
			    "<msg:message code='member.registerTime'/>",
			    "<msg:message code='member.isActivate'/>",
			    "<msg:message code='info.operate'/>"
        ],
        colModel: [
               {name:'id',index:'id',width:'',align:'center',hidden: true,sortable:false},
               {name:'name',index:'name',width:'10%',align:'center',hidden: false,sortable:false}, 
			   {name:'phoneAccount',index:'phoneAccount',width:'10%',align:'center',hidden: false,sortable:false}, 
               {name:'type',index:'type',width:'5%',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
				   if(cellvalue == "1"){
					   return "个人";
				   }else if(cellvalue == "2"){
					   return "企业";
				   }else{
					   return "个人";
				   }
			   }}, 
   			   {name:'availableAmount',index:'availableAmount',width:'10%',align:'center',hidden: false,sortable:false}, 
  			   {name:'frozenAmount',index:'frozenAmount',width:'10%',align:'center',hidden: false,sortable:false}, 
 			   {name:'male',index:'male',width:'5%',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
				   if(cellvalue == "0"){
					   return "男";
				   }else if(cellvalue == "1"){
					   return "女";
				   }else{
					   return "未知";
				   }
			   }},
			   {name:'registerTime',index:'registerTime',width:'15%',align:'center',hidden: false,sortable:false},
			   {name:'isActivate',index:'isActivate',width:'5%',align:'center',hidden: false,sortable:false,formatter:function(cellvalue, options, rowObject){
				   if(cellvalue == "0"){
					   return "禁用";
				   }else if(cellvalue == "1"){
					   return "启用";
				   }
			   }},
			   {name:'act',index:'act',width:'30%',align:'center',sortable:false,title:false}
			   
        ],
        mtype:"POST",
        postData:{c:'${member.c}'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="member.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="member.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#memberList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
				var datas = jQuery("#memberList").jqGrid("getRowData",id);
			   	<shiro:hasPermission name="${cc_member_account_modify_code}">
			   	content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
			   	<shiro:hasPermission name="${cc_member_account_delete_code}">
			   	content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
				var showMsg=  datas.isActivate == '启用'? '禁用':'启用';
					content += " title='"+showMsg+"'>";
					content += "<img src='${base}/static/images/icon/Enabled.png'";
					content += " weight='18' height='18' border='0' align='absmiddle'/>";
					content += showMsg;
    			content += "</a>";
    		    </shiro:hasPermission>
    		    <shiro:hasPermission name="${cc_member_account_detail_code}">
			   	content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_detail' ";
    			content += " title='明细'>";
    			content += "<img src='${base}/static/images/icon/detail.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "明细";
    			content += "</a>";
    		    </shiro:hasPermission>
    		    <shiro:hasPermission name="${cc_member_account_resetpwd_code}">
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_password' ";
    			content += " title=重置密码'>";
    			content += "<img src='${base}/static/images/icon/password.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "重置密码";
    			content += "</a>";
    		    </shiro:hasPermission>
    			jQuery("#memberList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${cc_member_account_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
				window.location.href="${base}/goto/member/jumpModify?viewCode=${cc_member_account_modify_code}&isContextCode=1&id="+rowid;

    	    });    
    	    </shiro:hasPermission>
			<shiro:hasPermission name="${cc_member_account_delete_code}">
    	    $(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#memberList").jqGrid("getRowData",rowid);
    	    	var records = $("#memberList").getGridParam("records");
    	    	var page = $("#memberList").getGridParam("page");
				var msg = data.isActivate=='启用'? '<msg:message code='system.prompt.disable.confirm'/>':'<msg:message code='system.prompt.using.confirm'/>';
				var isActivate = data.isActivate =='启用' ? '0':'1';
				var url = "${base}/ajax/submit/member/forbiddenMember.json?id="+rowid+"&isActivate="+ isActivate;
    			var layers = top.layer.confirm(msg,  function(){
					$.ajax({
    					url:url,
    					type:'post',
    					timeout:'60000',
    					dataType:'json',
    					success:function(jsonData,textStatus){
    						if (textStatus == "success"){
    							if (jsonData.status == "success"){
//    								for(var i = 1; ;i++){
//    									if(records = 10*i+1){
//    										jQuery("#memberList").setGridParam({page:page-1}).trigger("reloadGrid");
//    										break;
//    									}
//    								}
    								$("#memberList").trigger("reloadGrid"); 
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
    	    <shiro:hasPermission name="${cc_member_account_detail_code}">
    	    $(".shortcut_detail").click(function(){
    	    	var rowid = $(this).attr("id");
				window.location.href="${base}/goto/member/jumpDetail?viewCode=${cc_member_account_detail_code}&isContextCode=1&id="+rowid;
    	    });
    	    </shiro:hasPermission>
    	    <shiro:hasPermission name="${cc_member_account_resetpwd_code}">
    	    $(".shortcut_password").click(function(){
				var rowid = $(this).attr("id");
				var data = jQuery("#memberList").jqGrid("getRowData",rowid);
				var records = $("#memberList").getGridParam("records");
				var page = $("#memberList").getGridParam("page");
				var url = "${base}/ajax/submit/member/resetpwd.json?id=" + rowid+"&isLog=1";
				$.ajax({
					url:url,
					type:'post',
					timeout:'60000',
					dataType:'json',
					success:function(jsonData,textStatus){
						if (textStatus == "success"){
							if (jsonData.status == "success"){
								alert("重置成功")
								$("#memberList").trigger("reloadGrid");
							}
						}
					},
					error : function() {
						alert("重置失败！");
					}
				});
				
    	    });
    	    </shiro:hasPermission>
    		<shiro:hasPermission name="${cc_member_account_create_code}">
		    $("#top_create","#t_memberList").click(function(){
		    	window.location.href = "${base}/goto/member/jumpCreate?viewCode=${cc_member_account_create_code}&isContextCode=1&isLog=1";
		    });    
		    </shiro:hasPermission>		
    	},
        caption:'<msg:message code="member.list"/>',
        toolbar: [true,"top"]
    });
  //top菜单
	<shiro:hasPermission name="${cc_member_account_create_code}">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建企业用户");
    $("#t_memberList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));   
    </shiro:hasPermission>		
});
jQuery("#memberList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
<script type="text/javascript">
function search (){
	jQuery("#memberList").jqGrid("setGridParam",{postData:{
			nickname:$("#nickname").val(),
			phoneAccount:$("#phoneAccount").val(),
			startTime:$("#startTime").val(),
			endTime:$("#endTime").val(),
			male:$("#male").val(),
			emailAccount:$("#emailAccount").val()
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
			<table cellpadding="0" height="85" cellspacing="0" border="1" width="100%">
				<tr>
					<td width="5%">
					</td>
					<td>
						<label for="nickname" style="float:left;line-height: 32px;">会员昵称：</label>
						<input type="text" name="nickname" id="nickname" value="${member.nickname}" class="scinput"/>
					</td>
					<td>
						<label for="phoneAccount" style="float:left;line-height: 32px;">手机帐号：</label>
						<input type="text" name="phoneAccount" id="phoneAccount" value="${member.phoneAccount}" class="scinput"/>
					</td>
					<td>
						<label for="emailAccount" style="float:left;line-height: 32px;">邮箱帐号：</label>
						<input type="text" name="emailAccount" id="emailAccount" value="${member.emailAccount}" class="scinput"/>
					</td>
					<td rowspan="2" valign="middle">
						<shiro:hasPermission name="${3010105}">
							<button  id="search" onclick="search();" class="scbtn" style="width: 100px;">查询</button>
						</shiro:hasPermission>
					</td>
					<td width="20%" rowspan="2">
						<span id="allMembers">总注册人数：${allMembers}</span>
					<br>
						<span id="dailyMembers">当天注册人数：${dailyMembers}</span>
					</td>
				</tr>
				<tr>
					<td width="5%">
					</td>
					<td>
						<label for="startTime" style="float:left;line-height: 32px;">开始时间：</label>
						<input type="text" name="startTime" id="startTime" readonly="readonly" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
					</td>
					<td>
						<label for="endTime" style="float:left;line-height: 32px;">结束时间：</label>
						<input type="text" name="endTime" id="endTime" readonly="readonly" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
					</td>
					<td>
						<label for="male" style="float:left;line-height:32px; margin-top:2px; display;inline-block; padding-top:7px;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
						<div class="vocation">
						<select name="male" id="male" class="select3">
							<option value="">请选择</option>
							<option value="0">男</option>
							<option value="1">女</option>
						</select>
						</div>
					</td>
					<td>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td width="100%" colspan="3">
			<form:form method="post" action="member" commandName="noticemember" name="f">
			<input type="hidden" name="c" value="${member.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="memberList"><tr><td>&nbsp;</td></tr></table>
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