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
    jQuery("#educationGoalList").jqGrid({
        url: '${base}/ajax/getdata/educationGoal/jumpPaginated.json?id=${educationConfigure.id}',
        datatype: 'json',
        colNames: [
			    "<msg:message code='educationGoal.name'/>", 
			    "<msg:message code='educationGoal.createDate'/>"
        ],
        colModel: [
			   {name:'name',index:'name',width:'',align:'center',hidden: false,sortable:false}, 
			   {name:'createDate',index:'createDate',width:'',align:'center',hidden: false,sortable:false}
        ],
        mtype:"POST",
        postData:{c:'${educationGoal.c}'},
        rowNum:"6",    
        page:"1",
        rowList: [<msg:message code="educationGoal.jqgrid.row.list.s10.10"/>],
        pager: '#pagered',
        height:'<msg:message code="educationGoal.jqgrid.height.400"/>',
        autowidth: true,
        viewrecords: true,
        multiselect: true,
        jsonReader: {
        	repeatitems: false  ,root: "rows"
        }, 
        onSelectRow:function(){
			var ids = jQuery("#educationGoalList").jqGrid('getGridParam','selarrrow');
			$("#ids").val(ids);
        },
    	gridComplete: function(){
    		//快捷菜单
    		var ids = jQuery("#educationGoalList").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var content = "";
    		jQuery("#educationGoalList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
    		}	
    	},
    	loadComplete:function(data){
    		
    		var datas=data.rows;
    		for(var i=0;i<datas.length;i++){
	    			if(datas[i].arr=="true"){
	    				  $("#jqg_educationGoalList_"+(datas[i].id)+"").attr("checked","checked");	
	    				  $("#jqg_educationGoalList_"+((datas[i].id))+"").val((datas[i].id));
	    			}else{
	    				  $("#jqg_educationGoalList_"+(datas[i].id)+"").attr("checked",false);	
	    				  $("#jqg_educationGoalList_"+(datas[i].id)+"").val((datas[i].id));
	    			}
	    		}
		},
        caption:'<msg:message code="educationGoal.list"/>',
        toolbar: [true,"top"]
    });
  //top菜单
  
  	$("#con_button").click(function(){
  		 var str="";
  		 $("input[type='checkbox']").each(function(){ 
             if($(this).attr("checked")){
                 str += $(this).val()+","
             }
         })
         $("#ids").val(str);
  		$("#con").submit();
  	});
});

jQuery("#educationGoalList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
</script>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
	<tr>
	<td width="100%">
		<form:form  id="con" method="post" action="${base}/form/submit/educationConfigure/jumpCreate/${eb_budget_goal_code}" commandName="educationConfigure" name="f">
		<input type="hidden" name="c" value="${educationConfigure.c}"/>
		<input type="hidden" name="eduGoalId_master" value="${educationConfigure.id}"/>
		<input type="hidden" name="ids" id="ids"/>
		
		<table cellpadding="0" cellspacing="0" border="0" width="100%">
			<tr>
				<td>
					<table id="educationGoalList"><tr><td>&nbsp;</td></tr></table>	
					<div id="pagered"></div>
				</td>
			</tr>
		</table>
		</form:form>
	<input type="button" id="con_button" class="btn-80" value="关联"/>
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
</html>