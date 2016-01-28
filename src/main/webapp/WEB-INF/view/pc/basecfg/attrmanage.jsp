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

	initSelect('category','PC.Attribute.Category',"scinput");
	initSelect('isFixed','PC.Common.Boolean',"scinput");
	initSelect('isInherit','PC.Common.Boolean',"scinput");


	jQuery("#attributeList").jqGrid({
        url: '${base}/ajax/getdata/attribute/paginated.json',
        datatype: 'json',
		emptyrecords:"无数据",
        colNames: [
			    "<msg:message code='attribute.name'/>",
				"<msg:message code='attribute.code'/>",
				"<msg:message code='attribute.category'/>",
				"<msg:message code='attribute.isFixed'/>",
				"<msg:message code='attribute.isInherit'/>",
				"<msg:message code='attribute.createTime'/>",
	            "<msg:message code='info.operate'/>"
        ],
        colModel: [
			    {name:'name',index:'name',width:'18%',align:'center',hidden: false,sortable:false},
				{name:'code',index:'code',width:'18%',align:'center',hidden: false,sortable:false},
				{name:'category',index:'category',width:'8%',align:'center',hidden: false,sortable:false, formatter:function(data){ return getDicText("PC.Attribute.Category",data)}},
				{name:'isFixed',index:'isFixed',width:'8%',align:'center',hidden: false,sortable:false, formatter:function(data){ return getDicText("PC.Common.Boolean",data)}},
				{name:'isInherit',index:'isInherit',width:'8%',align:'center',hidden: false,sortable:false, formatter:function(data){ return getDicText("PC.Common.Boolean",data)}},
			    {name:'createTime',index:'createTime',width:'15%',align:'center',hidden: false,sortable:false},
				{name:'act',index:'act',align:'center',width:'30%',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${attribute.c}'},
        rowNum:"10",    
        page:"1",
        rowList: [<msg:message code="attribute.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="attribute.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#attributeList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
    			
			   	<shiro:hasPermission name="${pc_basecfg_attrmanage_modify_code}">
    			content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
    			content += " title='修改'>";
    			content += "<img src='${base}/static/images/icon/modify.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "修改";
    			content += "</a>";
    		    </shiro:hasPermission>
				<shiro:hasPermission name="${pc_basecfg_attrmanage_detail_code}">
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_detail' ";
				content += " title='明细'>";
				content += "<img src='${base}/static/images/icon/detail.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "明细";
				content += "</a>";
				</shiro:hasPermission>
				<shiro:hasPermission name="${pc_basecfg_attrmanage_modify_code}">
				content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_data' ";
				content += " title='数据'>";
				content += "<img src='${base}/static/images/icon/data.png'";
				content += " weight='18' height='18' border='0' align='absmiddle'/>";
				content += "数据";
				content += "</a>";
				</shiro:hasPermission>

				var data = jQuery("#attributeList").jqGrid("getRowData",id);
				var isFixed = data.isFixed;
				if(isFixed != "是") {
					<shiro:hasPermission name="${pc_basecfg_attrmanage_delete_code}">
					content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
					content += " title='删除'>";
					content += "<img src='${base}/static/images/icon/delete.png'";
					content += " weight='18' height='18' border='0' align='absmiddle'/>";
					content += "删除";
					content += "</a>";
					</shiro:hasPermission>
				}


    			jQuery("#attributeList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    	},
    	loadComplete:function(){
			<shiro:hasPermission name="${pc_basecfg_attrmanage_modify_code}">
    	    $(".shortcut_modify").click(function(){
    	    	var rowid = $(this).attr("id");
    			window.location.href="${base}/goto/attribute/jumpModify?viewCode=${pc_basecfg_attrmanage_modify_code}&isContextCode=1&id="+rowid;
    	    });    
    	    </shiro:hasPermission>

			<shiro:hasPermission name="${pc_basecfg_attrmanage_delete_code}">


			$(".shortcut_data").click(function(){
				var rowid = $(this).attr("id");
				var data = jQuery("#attributeList").jqGrid("getRowData",rowid);
				var records = $("#attributeList").getGridParam("records");
				var page = $("#attributeList").getGridParam("page");
				var url = "${base}/goto/attributeDataConfig/attributeDataConfigIndex?attributeId="+rowid;
				$("#iframe").attr("src",url);
				$(".tip").fadeIn(200);
			});

			$(".shortcut_delete").click(function(){
    	    	var rowid = $(this).attr("id");
    	    	var data = jQuery("#attributeList").jqGrid("getRowData",rowid);
    	    	var records = $("#attributeList").getGridParam("records");
    	    	var page = $("#attributeList").getGridParam("page");
    			var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
    				var url = "${base}/ajax/submit/attribute/delete.json?isLog=1&replaceName="+data.name+"&id=" + rowid;
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
    										jQuery("#attributeList").setGridParam({page:page-1}).trigger("reloadGrid");
    										break;
    									}
    								}
    								$("#attributeList").trigger("reloadGrid");
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
			<shiro:hasPermission name="${pc_basecfg_attrmanage_detail_code}">
			$(".shortcut_detail").click(function(){
				var rowid = $(this).attr("id");
				window.location.href="${base}/goto/attribute/jumpModify?viewCode=${pc_basecfg_attrmanage_detail_code}&isContextCode=1&id="+rowid;

			});
			</shiro:hasPermission>
			<shiro:hasPermission name="${pc_basecfg_attrmanage_create_code}">
		    $("#top_create","#t_attributeList").click(function(){
		    	window.location.href = "${base}/goto/attribute/jumpCreate?viewCode=${pc_basecfg_attrmanage_create_code}&isContextCode=1";
		    });    
		    </shiro:hasPermission>
    	},
        caption:'<msg:message code="attribute.list"/>',
        toolbar: [true,"top"]
    });
    
  //top菜单
	<shiro:hasPermission name="${pc_basecfg_attrmanage_create_code}">
    var $ea = $("<a></a>").attr("href","javascript:void(0)")
   			  .attr("id","top_create")
   			  .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
			  .attr("width","18").attr("height","18").attr("border","0")
			  .attr("border","0").attr("align","absmiddle"))
			  .append("创建");
    $("#t_attributeList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));
    </shiro:hasPermission>

	$("#qryBtn").click(function(){
		jQuery("#attributeList").jqGrid("setGridParam",{postData:{
			category:$("#category").val(),
			isFixed:$("#isFixed").val(),
			isInherit:$("#isInherit").val(),
			name:$("#name").val(),
			code:$("#code").val(),
		}
		}).trigger("reloadGrid");
	});


	$(".click").click(function(){
		$(".tip").fadeIn(200);
	});

	$(".tiptop a").click(function(){
		$(".tip").fadeOut(200);
	});

	$(".sure").click(function(){
		$("#iframe")[0].contentWindow.submit();
		$(".tip").fadeOut(100);
	});

	$(".cancel").click(function(){
		$(".tip").fadeOut(100);
	});
	$(".tip").hide();

});

jQuery("#attributeList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
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
						<label for="category" style="float:right;line-height: 32px;"><msg:message code='attribute.category'/>：</label>
					</td>
					<td>
						<input type="text" name="category" id="category" value="${attribute.category}" class="scinput"/>
					</td>
					<td>
						<label for="isFixed" style="float:right;line-height: 32px;"><msg:message code='attribute.isFixed'/>：</label>
					</td>
					<td>
						<input type="text" name="isFixed" id="isFixed" value="${attribute.isFixed}" class="scinput"/>
					</td>
					<td>
						<label for="isInherit" style="float:right;line-height: 32px;"><msg:message code='attribute.isInherit'/>：</label>
					</td>
					<td>
						<input type="text" name="isInherit" id="isInherit" value="${attribute.isInherit}" class="scinput"/>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td width="5%">
					</td>
					<td>
						<label for="name" style="float:right;line-height: 32px;"><msg:message code='attribute.name'/>：</label>
					</td>
					<td>
						<input type="text" name="name" id="name" value="${attribute.name}" class="scinput"/>

					</td>
					<td>
						<label for="code" style="float:right;line-height: 32px;"><msg:message code='attribute.code'/>：</label>
					</td>
					<td>
						<input type="text" name="code" id="code" value="${attribute.code}" class="scinput"/>

					</td>
					<td>
						<%--<label for="startTime" style="float:right;line-height: 32px;"><msg:message code='attribute.createTime'/>：</label>--%>
					</td>
					<td>
						<%--<input type="text" name="startTime" id="startTime" readonly="readonly" style="width:100px;" class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>--%>
						<%--<span>~</span>--%>
						<%--<input type="text" name="endTime" id="endTime" readonly="readonly" style="width:100px;"  class="scinput date twidth Wdate" onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>--%>
					</td>
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
			<form:form method="post" action="attribute" commandName="attribute" name="f">
			<input type="hidden" name="c" value="${attribute.c}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td>
						<table id="attributeList"><tr><td>&nbsp;</td></tr></table>
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
</div>
<div class="tip" style="display: block;">
	<div class="tiptop"><span>数据关联信息</span><a></a></div>

	<form:form method="post" action="${base}/form/submit/attribute/create" commandName="attributeDataConfig" name="attribute">
	<div class="tipinfo">
		<div class="form-body">
			<iframe  width="100%" frameborder="0"  id="iframe" name="iframe" class="iframe" scrolling="no" style="" title="iframe" height="200px"></iframe>
		</div>
	</div>

	<div class="tipbtn">
		<input name="" type="button" class="sure" value="确定">&nbsp;
		<input name="" type="button" class="cancel" value="取消">
	</div>
	</form:form>
</div>
</body>
</html>