function toModuleList() {
	var root = parent.document.getElementById("_root").value;
	document.location.href = root + "/plat/listModule.do";
}

function checkModule() {
	var flag = true;
	show_loading();
	if (x_isEmpty("moduleName")) {
		flag = false;
		show_err_msg("名称不能为空！");
		$('#moduleName').focus();
	} else if (x_isEmpty("moduleCode")) {
		flag = false;
		show_err_msg("代码不能为空！");
		$('#moduleCode').focus();
	} else if (x_isEmpty("moduleStatus")) {
		flag = false;
		show_err_msg("请选择模块状态！");
	} else if (x_isEmpty("moduleType")) {
		flag = false;
		show_err_msg("请选择模块类型！");
	} else if (x_isEmpty("showSeq")) {
		flag = false;
		show_err_msg("排列顺序不能为空！");
		$('#showSeq').focus();
	}
	return flag;
}

function checkModuleCode(){
	var root = parent.document.getElementById("_root").value;
	var moduleCodeVal = x_G("moduleCode").value;
	var url = root +"/plat/verifyModuleCode.do?moduleCode="+moduleCodeVal;
	if(""==moduleCodeVal){
		show_loading();
		show_err_msg("模块代码不能为空！");
	}else{
		$.ajax({
			url: url,
			cache:false, //设置为 false 将不会从浏览器缓存中加载请求信息。
			dataType:'html', //接受数据格式 
			success: function(data,textStatus){
				$("#msg").html(data);
			},
			error: function(XMLHttpRequest,textStatus, errorThrown){
				show_err_msg(" 请求出错!"+errorThrown);
			}
		});
	}
}

function appendCode(){
	var _code = x_G("moduleCode");
	if(null!=_code.value && ""!=_code.value){
		_code.value = x_G("parentModuleCode").value+"."+_code.value;
	}
}

function clearCode(){
	var _code = x_G("moduleCode");
	if(_code.value){
		var parentCode = x_G("parentModuleCode").value +".";
		_code.value = _code.value.replace(parentCode,"");
	}
}

function getCheckModuleCodeResult(){
	var obj = $("#msg").html();
	if("OK"!=obj){
		show_err_msg(obj);
	}
	return obj;
}

function checekAll(){
	var flag = false;
	var acResult = getCheckModuleCodeResult();	
	if(checkModule()&& "OK"==acResult){
		flag = true;
	}
	return flag;
}

function checkAndSubmit(){
	if(checekAll()){
		x_G("frm").submit();
	}
}