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

function checkAndSubmit(){
	if(checkModule()){
		x_G("frm").submit();
	}
}