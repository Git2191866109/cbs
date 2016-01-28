<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<script type="text/javascript">


    <%--$.extend({--%>
        <%--loadData : function (dicName) {--%>
            <%--$.ajax({--%>
                <%--url:"${base}/ajax/getdata/dictionary/getByCode.json?name=" + dicCode,--%>
                <%--type:'post',--%>
                <%--dataType:'json',--%>
                <%--success:function(jsonData){--%>
                    <%--if(typeof jsonData !== 'undefined'){--%>
                        <%--var _list = jsonData.dictionaryList;--%>
                        <%--var tempMap = {};--%>
                        <%--for(var i = 0; i < _list.length; i++){--%>
                            <%--tempMap[_list[i].value] = _list[i].name;--%>
                        <%--}--%>
                        <%--localData[dicName] = tempMap;--%>
                    <%--}--%>
                <%--},--%>
                <%--error: function (){--%>

                <%--}--%>
            <%--});--%>
        <%--},--%>
        <%--getDicText : function(dicName, dicValue){--%>
            <%--var has = dicName in localData;--%>
            <%--alert(has);--%>
            <%--if(!has) {--%>
                <%--$.loadData(dicName);--%>
            <%--}--%>
            <%--return localData[dicName];--%>
        <%--}--%>
    <%--});--%>
    var localData = {};
    function getDicText(dicName, dicValue, isDynamic){
        var has = dicName in localData;
        if(!has) {
            loadData(dicName,isDynamic);
        }
        var tempMap = localData[dicName];
        var text = tempMap[dicValue];
        if(typeof text !== 'undefined' ) {
            return text;
        }else {
            if(dicValue == null || dicValue == "null") {
                dicValue = "";
            }
            return dicValue;
        }
    }

    function loadData(dicName, isDynamic) {
        var url = "${base}/ajax/getdata/dictionary/getByCode.json?name=" + dicName;
        if(isDynamic != null) {
            url += "&isDynamic=1";
        }
        $.ajax({
            async:false,
            url:url,
            type:'post',
            dataType:'json',
            success:function(jsonData){
                if(typeof jsonData !== 'undefined'){
                    var _list = jsonData.dictionaryList;
                    var tempMap = {};
                    for(var i = 0; i < _list.length; i++){
                        tempMap[_list[i].value] = _list[i].name;
                    }
                    localData[dicName] = tempMap;
                }
            },
            error: function (){

            }
        });
    }
    //加载select框选项
  function initSelect(selectTagName, dicCode ,className) {
    $.ajax({
      url:"${base}/ajax/getdata/dictionary/getByCode.json?name=" + dicCode,
      type:'post',
      dataType:'json',
      success:function(jsonData){
        if(typeof jsonData !== 'undefined'){
          var _list = jsonData.dictionaryList;
          dealData(selectTagName, _list,className);
        }

      },
      error: function (){

      }
    });
  }

  //加载select框选项
  function initDynamicSelect(selectTagName, dicCode ,className,callback) {
    $.ajax({
      url:"${base}/ajax/getdata/dictionary/getByCode.json?name=" + dicCode+"&isDynamic=1",
      type:'post',
      dataType:'json',
      success:function(jsonData){
        if(typeof jsonData !== 'undefined'){
          var _list = jsonData.dictionaryList;
          dealData(selectTagName, _list,className,callback);
        }

      },
      error: function (){

      }
    });
  }




  function dealData(selectTagName,list, className, callback){
//    selectTagName = selectTagName.replaceAll("[","/[");
//    selectTagName = selectTagName.replaceAll("]","/]");

    var _html = [];
//    var _callback = "eval('alert(1);alert(2)')";
    _html.push('<select id="' + selectTagName+ '" name="' + selectTagName+ '" class="'+ className +'">');
    _html.push('<option value=""> - 请选择 - </option>');

    for(var i = 0; i < list.length; i++){
      _html.push('<option value="' +  list[i].value+ '">'+ list[i].name +'</option>');
    }
    _html.push('</select>');
    var _value = $('input[name="' + selectTagName+ '"]').val();
      _html.push('\<script type="text/javascript">$("select[name=\'' + selectTagName+ '\']").change(' + callback + ');\<\/script>');
      $('input[name="' + selectTagName+ '"]').parent().html(_html.join(''));

//		$('#select_').html(_html.join(''));
    $('select[name="' + selectTagName+ '"]').val(_value);
  }


</script>
