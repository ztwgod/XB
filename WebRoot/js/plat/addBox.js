function toListBox() {
	var root = parent.document.getElementById("_root").value;
	document.location.href = root + "/plat/listBox.do";
}

function showTipsWindown(){
	var root = parent.document.getElementById("_root").value;
	var url = "iframe:"+root+"/plat/listEgis.do";
	tipsWindown("添加维护员",url,"800","500","true","","false","","setEgisValue","true") 
}

function showCouries(obj){
	var root = parent.document.getElementById("_root").value;
	var url = "iframe:"+root+"/plat/listCourier.do?exePermission="+1;
	if(obj==1){
		tipsWindown("设置寄件快递员组",url,"800","600","false","","false","","sentCouriers","true");
	}else{
		tipsWindown("设置投件快递员组",url,"800","600","false","","false","","courierPickups","true");
	}
}

//设置寄件快递员组回调函数
function sentCouriers(){
	var frame = document.getElementById("_tipFram").contentWindow;
	var obj = frame.document.getElementsByName("groupIds");
	var strGroupIds = "";
	var objshow = frame.document.getElementById("_divSelected").innerHTML;
	objshow = objshow.replace("当前选择：",'');
	
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i].checked==true){
			var groupId = obj[i].value; //用户id
			strGroupIds+=(groupId+"@");
		}
	}
	var groupIds = "";
	if(strGroupIds.charAt(strGroupIds.length-1)=="@"){
		groupIds = strGroupIds.substring(0,strGroupIds.length-1);
	}
	
	document.getElementById("sentCouriers").value = objshow;
	document.getElementById("sentCouriersId").value = groupIds;
	
	//alert(groupIds+","+objshow);
}

//设置投件快递员组回调函数
function courierPickups(){
	var frame = document.getElementById("_tipFram").contentWindow;
	var obj = frame.document.getElementsByName("groupIds");
	var objshow = frame.document.getElementById("_divSelected").innerHTML;
	objshow = objshow.replace("当前选择：",'');
	
	var strGroupIds = "";
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i].checked==true){
			var groupId = obj[i].value; //用户id
			strGroupIds+=(groupId+"@");
		}
	}
	var groupIds = "";
	if(strGroupIds.charAt(strGroupIds.length-1)=="@"){
		groupIds = strGroupIds.substring(0,strGroupIds.length-1);
	}
	
	document.getElementById("courierPickups").value = objshow;
	document.getElementById("courierPickupsId").value = groupIds;
	
	//alert(groupIds+","+objshow);
}

//获取物箱代码根据组id
function getIntactCode(obj){
	if(""!=obj.value){
		jQuery("#ssCode").attr("disabled",false);
	}else{
		jQuery("#ssCode").val("");
		jQuery("#ssCode").attr("disabled",true);
	}
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
	if (x_isEmpty("ssCode")) {
		flag = false;
		show_err_msg("物箱代码不能为空！");
		jQuery('#ssCode').focus();		
	} else if (x_isEmpty("groupId")) {
		flag = false;
		show_err_msg("请选择物箱组！");
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
	}  /*else if (x_isEmpty("sentCouriers")) {
		flag = false;
		show_err_msg("寄件快递员组不能为空！");
	} else if (x_isEmpty("courierPickups")) {
		flag = false;
		show_err_msg("取件快递员组不能为空！");
	}*/ else if (x_isEmpty("boxAddress")) {
		flag = false;
		show_err_msg("物箱地址不能为空！");
	}  else if (x_isEmpty("assetSn")) {
		flag = false;
		show_err_msg("资产编号不能为空！");
		jQuery('#assetSn').focus();
	}  else if (x_isEmpty("longitude")) {
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
	}  /*else if (x_isEmpty("ssSeq")) {
		flag = false;
		show_err_msg("序号不能为空！");
		jQuery('#ssSeq').focus();
	} else if (x_isEmpty("model")) {
		flag = false;
		show_err_msg("请选择物箱版本！");
	}*/  else if (x_isEmpty("baiduId")) {
		flag = false;
		show_err_msg("百度地图ID不能为空！");
		jQuery('#baiduId').focus();
	} else if (x_isEmpty("egis")) {
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
	var url = root +"/plat/verifyBaiDuPid.do?pid="+baiduId;
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
	var groupId = jQuery("#groupId").val();
	var url = root +"/plat/verifySSCode.do?ssCode="+ssCode+"&groupId="+groupId;
	if(""==ssCode){
		//$("#_ssCodeMsg").html("");
		//$("#_ssCodeMsg").html("物箱代码不能为空！");
		show_err_msg("物箱代码不能为空！");
	}else if(""==groupId){
		show_err_msg("请先选择组代码！");
	}/*else if(ssCode.length>2){
		jQuery("#ssCode").val("");
		show_err_msg("物箱代码不能超过2位！");
	}*/else{
		$.ajax({
			url: url,
			cache:false, //设置为 false 将不会从浏览器缓存中加载请求信息。
			dataType:'html', //接受数据格式 
			success: function(data,textStatus){
				if("FAIL"==data){
					jQuery("#ssCode").val("");
					show_err_msg("物箱代码已经存在!");
				}else{
					jQuery("#ssCode").val(data);
				}
			},
			error: function(XMLHttpRequest,textStatus, errorThrown){
				show_err_msg(" 请求出错!"+errorThrown);
			}
		});
	}
}

/*function checkMap(){
	var obj = jQuery("#msg").html();
	if("OK"!=obj){
		show_err_msg(obj);
	}
	return obj;
}*/

function checkAndSubmit() {
	//var acResult = checkMap();
	if (checkBox() && checkAll() && checkIpAndDataCard()) {
		var r = confirm("物箱组与物箱代码在此处添加后将不再允许删除，是否确认？");
		if(r){
			document.getElementById("frm").submit();
		}
	}
}