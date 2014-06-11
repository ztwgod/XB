<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="<%= path %>/css/portal/map.css" />

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=${ak}"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script><!-- 加载百度地图样式信息窗口 -->
<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
<script type="text/javascript" src="http://api.map.baidu.com/library/CityList/1.2/src/CityList_min.js"></script><!-- 加载城市列表 -->
<script type="text/javascript" src="<%=path%>/js/x_tools.js"></script>
<style type="text/css">
.li_2_content dt,.li_3_content dt {
	margin-top: -15px;
	border-bottom: 0px;
}
</style>
<title>电子地图</title>
</head>
<body>
	<div style="margin: auto 0; text-align: center;"><jsp:include page="nav.jsp"></jsp:include></div>
	<input type="hidden" id="mdKey" name="mdKey" value="${mdKey}" />
	<input type="hidden" id="root" name="root" value="<%=path%>"/>
	<div id="r-result"><span style="font-size: 14px;font-weight: bold;">请输入目标地点:</span><br />
		<input type="text" id="suggestId" name="suggestId" size="40" />
		<input type="button" id="search" name="search" value="查询 " class="But6" onclick="locSearch();">
		<div id="showDiv" ></div>
	</div>	
	<div id="l-map"></div>
    <div id="searchResultPanel"></div>	
	<!--城市列表-->
	<div class="sel_container"><strong id="curCity">上海市</strong> [<a id="curCityText" href="javascript:void(0)">更换城市</a>]</div>
	<div class="map_popup" id="cityList" style="display:none;">
		<div class="popup_main">
			<div class="title">城市列表</div>
			<div class="cityList" id="citylist_container"></div>
			<button id="popup_close"></button>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
// 百度地图API功能
var map = new BMap.Map("l-map");          // 创建地图实例
var point = new BMap.Point(121.505434,31.246692);  // 创建点坐标
map.centerAndZoom(point, 13);                 // 初始化地图，设置中心点坐标和地图级别
map.enableScrollWheelZoom();
map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
var customLayer;
function addCustomLayer(keyword) {
    if (customLayer) {
        map.removeTileLayer(customLayer);
    }
    //customLayer=new BMap.CustomLayer(x_G("mdKey").value);

    customLayer=new BMap.CustomLayer({
        geotableId: x_G("mdKey").value,
        q: '', //检索关键字
        tags: '', //空格分隔的多字符串
        filter: '' //过滤条件,参考http://developer.baidu.com/map/lbs-geosearch.htm#.search.nearby
    });
    
    
    
    map.addTileLayer(customLayer);
    customLayer.addEventListener('hotspotclick',callback);
}
addCustomLayer();

//start
var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
    {"input" : "suggestId"
    ,"location" : map
});

ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
var str = "";
    var _value = e.fromitem.value;
    var value = "";
    if (e.fromitem.index > -1) {
        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    }    
    str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
    
    value = "";
    if (e.toitem.index > -1) {
        _value = e.toitem.value;
        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    }    
    str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;    
    x_G("searchResultPanel").innerHTML = str;
});

var myValue;
ac.addEventListener("onconfirm", function(e) {//鼠标点击下拉列表后的事件
var _value = e.item.value;
    myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    x_G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
    setPlace();
});

function setPlace(){
    map.clearOverlays();//清除地图上所有覆盖物
    function myFun(){
        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
        map.centerAndZoom(pp, 18);
        map.addOverlay(new BMap.Marker(pp));    //添加标注
    }
    var local = new BMap.LocalSearch(map, { //智能搜索
      onSearchComplete: myFun
    });
    local.search(myValue);
}

//end
function callback(e)//单击热点图层
{
  var customPoi = e.customPoi,
		  str = [];
		//str.push("address = " + customPoi.address);
		//str.push("phoneNumber = " + customPoi.phoneNumber);
        var content = '<p style="width:320px;margin:0;line-height:20px;">地址：' + customPoi.address;
		
        var url = x_getUrl("/portal/loadBoxCnt.do?poiId="+customPoi.poiId);
        $.ajax({
    		type: "get",
    		url: url,
    		beforeSend: function(XMLHttpRequest){
    			//ShowLoading();
    		},
    		success: function(data, textStatus){
    			content+=("<br />"+data+ '</p>');
    			showInfo(content,customPoi);
    		},
    		complete: function(XMLHttpRequest, textStatus){
    			//HideLoading();
    		},
    		error: function(){
    			//请求出错处理
    			content+=('</p>');
    			showInfo(content,customPoi);
    		}
    	});     
}

function locSearch(){
	var value = x_G("suggestId").value;
	var local = new BMap.LocalSearch(map, {
	  renderOptions: {
		  	map: map, 
		  	panel: "showDiv",
		  	//autoViewport: true,
		  	selectFirstResult: false
		},
		  	pageCapacity: 5
	});
	local.search(value);
}

function showInfo(content,customPoi){
	var searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
        title: customPoi.title, //标题
        width: 340, //宽度
        height: 55, //高度
        panel : "panel", //检索结果面板
        enableAutoPan : true, //自动平移
        enableSendToPhone: false, //是否显示发送到手机按钮
        searchTypes :[
            BMAPLIB_TAB_SEARCH,   //周边检索
            BMAPLIB_TAB_TO_HERE  //到这里去
            //BMAPLIB_TAB_FROM_HERE //从这里出发
        ]
    });
    var point = new BMap.Point(customPoi.point.lng, customPoi.point.lat);
    searchInfoWindow.open(point);
}

// 创建CityList对象，并放在citylist_container节点内
var myCl = new BMapLib.CityList({container : "citylist_container", map : map});

// 给城市点击时，添加相关操作
myCl.addEventListener("cityclick", function(e) {
	// 修改当前城市显示
	document.getElementById("curCity").innerHTML = e.name;

	// 点击后隐藏城市列表
	document.getElementById("cityList").style.display = "none";
});

// 给“更换城市”链接添加点击操作
document.getElementById("curCityText").onclick = function() {
	var cl = document.getElementById("cityList");
	if (cl.style.display == "none") {
		cl.style.display = "";
	} else {
		cl.style.display = "none";
	}	
};

// 给城市列表上的关闭按钮添加点击操作
document.getElementById("popup_close").onclick = function() {
	var cl = document.getElementById("cityList");
	if (cl.style.display == "none") {
		cl.style.display = "";
	} else {
		cl.style.display = "none";
	}	
};
</script>