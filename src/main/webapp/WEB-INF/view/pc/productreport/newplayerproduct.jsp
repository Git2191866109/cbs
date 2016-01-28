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

      jQuery("#basicProductList").jqGrid({
        url: '${base}/ajax/getdata/structureConfig/paginated.json',
        datatype: 'json',
        colNames: [
          "<msg:message code='structureConfig.attributeId'/>",
          "<msg:message code='structureConfig.isShow'/>",
          "<msg:message code='structureConfig.isHeader'/>",
          "<msg:message code='structureConfig.showType'/>",
          "<msg:message code='structureConfig.defaultValue'/>",
          "<msg:message code='info.operate'/>"
        ],
        colModel: [
          {name:'attributeId',index:'attributeId',width:'80px',align:'center',hidden: false,sortable:false},
          {name:'isShow',index:'isShow',width:'80px',align:'center',hidden: false,sortable:false},
          {name:'isHeader',index:'isHeader',width:'80px',align:'center',hidden: false,sortable:false},
          {name:'showType',index:'showType',width:'80px',align:'center',hidden: false,sortable:false},
          {name:'defaultValue',index:'defaultValue',width:'80px',align:'center',hidden: false,sortable:false},
          {name:'act',index:'act',align:'center',width:'180px',sortable:false,title:false}
        ],
        mtype:"POST",
        postData:{c:'${structureConfig.c}'},
        rowNum:"5",
        page:"1",
        rowList: [<msg:message code="structureConfig.jqgrid.row.list.s10.10"/>],
        height:'<msg:message code="structureConfig.jqgrid.height.400"/>',
        autowidth: false,
        viewrecords: true,
        multiselect: false,
        jsonReader: {
          repeatitems: false
        },
        gridComplete: function(){
          //快捷菜单
          var ids = jQuery("#structureConfigList").jqGrid('getDataIDs');
          for(var i=0;i < ids.length;i++){
            var id = ids[i];
            var content = "";

            <shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_modify_code}">
            content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_modify' ";
            content += " title='修改'>";
            content += "<img src='${base}/static/images/icon/modify.png'";
            content += " weight='18' height='18' border='0' align='absmiddle'/>";
            content += "修改";
            content += "</a>";
            </shiro:hasPermission>
            <shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_detail_code}">
            content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_detail' ";
            content += " title='明细'>";
            content += "<img src='${base}/static/images/icon/detail.png'";
            content += " weight='18' height='18' border='0' align='absmiddle'/>";
            content += "明细";
            content += "</a>";
            </shiro:hasPermission>
            <shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_delete_code}">
            content += "<a href='javascript:void(0);' id='" + id + "' class='shortcut_delete' ";
            content += " title='删除'>";
            content += "<img src='${base}/static/images/icon/delete.png'";
            content += " weight='18' height='18' border='0' align='absmiddle'/>";
            content += "删除";
            content += "</a>";
            </shiro:hasPermission>
            jQuery("#structureConfigList").jqGrid('setRowData',ids[i],{act:"<div class='jqgridContainer'>" + content + "</div>"});
          }
        },
        loadComplete:function(){
          <shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_modify_code}">
          $(".shortcut_modify").click(function(){
            var rowid = $(this).attr("id");
            window.location.href="${base}/goto/structureConfig/jumpModify?viewCode=${pc_basecfg_categorycfg_newplayerproduct_modify_code}&isContextCode=1&id="+rowid;
          });
          </shiro:hasPermission>

          <shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_delete_code}">
          $(".shortcut_delete").click(function(){
            var rowid = $(this).attr("id");
            var data = jQuery("#structureConfigList").jqGrid("getRowData",rowid);
            var records = $("#structureConfigList").getGridParam("records");
            var page = $("#structureConfigList").getGridParam("page");
            var layers = top.layer.confirm("<msg:message code='system.prompt.delete.confirm'/>",  function(){
              var url = "${base}/ajax/submit/structureConfig/delete.json?isLog=1&replaceName="+data.name+"&id=" + rowid;
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
                          jQuery("#structureConfigList").setGridParam({page:page-1}).trigger("reloadGrid");
                          break;
                        }
                      }
                      $("#structureConfigList").trigger("reloadGrid");
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
          <shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_detail_code}">
          $(".shortcut_detail").click(function(){
            var rowid = $(this).attr("id");
            window.location.href="${base}/goto/structureConfig/jumpModify?viewCode=${pc_basecfg_categorycfg_newplayerproduct_detail_code}&isContextCode=1&id="+rowid;
          });
          </shiro:hasPermission>
          <shiro:hasPermission name="${pc_basecfg_categorycfg_newplayerproduct_create_code}">
          $("#top_create","#t_structureConfigList").click(function(){
            window.location.href = "${base}/goto/structureConfig/jumpCreate?viewCode=${pc_basecfg_categorycfg_newplayerproduct_create_code}&isContextCode=1";
          });
          </shiro:hasPermission>
        },
        caption:'<msg:message code="structureConfig.selAttrList"/>',
        toolbar: [false,"top"]
      });

      //top菜单
      <shiro:hasPermission name="${pc_productmanager_basicproduct_create_code}">
      var $ea = $("<a></a>").attr("href","javascript:void(0)")
              .attr("id","top_create")
              .append($("<img/>").attr("src","${base}/static/images/icon/create.png")
                      .attr("width","18").attr("height","18").attr("border","0")
                      .attr("border","0").attr("align","absmiddle"))
              .append("创建");
      $("#t_basicProductList").append("&nbsp;&nbsp;").append($("<span></span>").attr("class","jqgridContainer").append($ea));
      </shiro:hasPermission>
    });

    jQuery("#basicProductList").closest(".ui-jqgrid-bdiv").css("overflow-x","hidden");
  </script>
</head>
<body class="skinMain">
<div class="list-content">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="skinMain">
  <tr>
    <td width="100%">
      <form:form method="post" action="basicProduct" commandName="basicProduct" name="f">
        <input type="hidden" name="c" value="${basicProduct.c}"/>
        <table cellpadding="0" cellspacing="0" border="0" width="100%">
          <tr>
            <td>
              <table id="basicProductList"><tr><td>&nbsp;</td></tr></table>
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
</html>