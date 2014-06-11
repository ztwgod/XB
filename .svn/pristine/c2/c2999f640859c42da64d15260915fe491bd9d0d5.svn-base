function toListBox() {
	var root = parent.document.getElementById("_root").value;
	document.location.href = root + "/plat/listBox.do";
}

function showTipsWindown(){
	var root = parent.document.getElementById("_root").value;
	var ssId = x_G("ssId").value;
	var url = "iframe:"+root+"/plat/listEgis.do?ssId="+ssId;
	tipsWindown("添加维护员",url,"800","500","true","","false","","setEgisValue","true") 
}

function setEgisValue(){
	var frame = document.getElementById("_tipFram").contentWindow;
	var obj = frame.document.getElementsByName("egisId");
	
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i].checked==true){			
			x_G("egis").value=obj[i].id;
			x_G("egisId").value=obj[i].value;
			break;
		}
	}
}

function checkBox() {
	var flag = true;
	show_loading();	
	if (x_isEmpty("groupId")) {
		flag = false;
		show_err_msg("请选择物箱组！");
	} else if (x_isEmpty("ssCode")) {
		flag = false;
		show_err_msg("物箱代码不能为空！");
		jQuery('#ssCode').focus();		
	} /*else if (x_isEmpty("dataCard")) {
		flag = false;
		show_err_msg("数据卡号不能为空！");
		jQuery('#dataCard').focus();
	} else if (x_isEmpty("ipAdd")) {
		flag = false;
		show_err_msg("物箱IP地址不能为空！");
		jQuery('#ipAdd').focus();
	}*/ else if (x_isEmpty("ssType")) {
		flag = false;
		show_err_msg("请选择物箱类型！");
	} else if (x_isEmpty("linkType")) {
		flag = false;
		show_err_msg("请选择IP链接类型！");
	} else if (x_isEmpty("boxAddress")) {
		flag = false;
		show_err_msg("物箱地址不能为空！");
	} else if (x_isEmpty("assetSn")) {
		flag = false;
		show_err_msg("资产编号不能为空！");
		jQuery('#assetSn').focus();
	} else if (x_isEmpty("longitude")) {
		flag = false;
		show_err_msg("经度不能为空！");
		jQuery('#longitude').focus();
	} else if (x_isEmpty("latitude")) {
		flag = false;
		show_err_msg("纬度不能为空！");
		jQuery('#latitude').focus();
	} else if (x_isEmpty("port")) {
		flag = false;
		show_err_msg("端口不能为空！");
		jQuery('#port').focus();
	} /* else if (x_isEmpty("ssSeq")) {
		flag = false;
		show_err_msg("序号不能为空！");
		jQuery('#ssSeq').focus();
	} else if (x_isEmpty("model")) {
		flag = false;
		show_err_msg("请选择物箱版本！");
	} */ else if (x_isEmpty("baiduId")) {
		flag = false;
		show_err_msg("百度地图ID不能为空！");
		jQuery('#baiduId').focus();
	}  else if (x_isEmpty("egis")) {
		flag = false;
		show_err_msg("请选择维护员！");
	}
	return flag;
}

/**
 * 数据卡号与IP地址两个必须选择一个
 * @return
 */
function checkIpAndDataCard(){
	var flag = true;
	if(x_isEmpty("dataCard") && x_isEmpty("ipAdd")){
		flag = false;
		show_err_msg("物箱数据卡号与IP地址两个必须录入其中一个！");
		jQuery('#dataCard').focus();
	}
	return flag;
}


function checkAll(){
	var dataCard = jQuery("#dataCard").val();
	if(dataCard!=''){
		var bool = x_checkPhone(dataCard);
		if(!bool){
			show_err_msg("数据卡号输入错误！");
			jQuery('#dataCard').focus();
		}
		return bool;
	}else{
		return true;
	}	
}

function checkBaiduPid(){
	var root = parent.document.getElementById("_root").value;
	var baiduId = jQuery("#baiduId").val();
	var ssId = jQuery("#ssId").val();
	var url = root +"/plat/verifyBaiDuPid.do?pid="+baiduId+"&ssId="+ssId;
	if(""==baiduId){
		$("#msg").html("");
		$("#msg").html("百度地图ID不能为空！");
	}else{
		$.ajax({
			url: url,
			cache:false, //设置为 false 将不会从浏览器缓存中加载请求信息。
			dataType:'html', //接受数据格式 
			success: function(data,textStatus){
				if("OK"!=data){
					jQuery("#baiduId").val("");
				}
				$("#msg").html("");
				$("#msg").html(data);
			},
			error: function(XMLHttpRequest,textStatus, errorThrown){
				show_err_msg(" 请求出错!"+errorThrown);
			}
		});
	}
}

function checkSSCode(){
	var root = parent.document.getElementById("_root").value;
	var ssCode = jQuery("#ssCode").val();
	var ssId = jQuery("#ssId").val();
	var url = root +"/plat/verifySSCode.do?ssCode="+ssCode+"&ssId="+ssId;
	if(""==ssCode){
		$("#_ssCodeMsg").html("");
		$("#_ssCodeMsg").html("物箱代码不能为空！");
	}else{
		$.ajax({
			url: url,
			cache:false, //设置为 false 将不会从浏览器缓存中加载请求信息。
			dataType:'html', //接受数据格式 
			success: function(data,textStatus){
				if("OK"!=data){
					jQuery("#ssCode").val("");
				}
				$("#_ssCodeMsg").html("");
				$("#_ssCodeMsg").html(data);
			},
			error: function(XMLHttpRequest,textStatus, errorThrown){
				show_err_msg(" 请求出错!"+errorThrown);
			}
		});
	}
}

/*function checkMap(){
	var obj = jQuery("#msg").html();
	if("OK"!=obj && ''!=obj){
		show_err_msg(obj);
		return obj;
	}else{
		return "OK";
	}
}*/

function checkAndSubmit() {
	//var acResult = checkMap();
	if (checkBox()&& checkAll() && checkIpAndDataCard()) {
		document.getElementById("frm").submit();
	}
}