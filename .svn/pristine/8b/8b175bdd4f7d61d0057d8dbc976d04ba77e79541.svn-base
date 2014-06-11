function checkUser(){
		var flag = true;
		show_loading();
		if(x_isEmpty("idType")){
			flag = false;
			show_err_msg("请选择用户证件类型！");
		}else if(x_isEmpty("idNo")){
			flag = false;
			show_err_msg("证件号不能为空！");
			jQuery('#idNo').focus();
		}else if(x_isEmpty("usualAddress")){
			flag = false;
			show_err_msg("常住地址不能为空！");
			jQuery('#usualAddress').focus();
		}else if(x_isEmpty("registerAddress")){
			flag = false;
			show_err_msg("户籍地址不能为空！");
			jQuery('#registerAddress').focus();
		}
		return flag;
}

function checekAndSubmit(){
	if(checkUser()){
		x_G("frm").submit();
	}
}

function Skip(){
	var root = document.getElementById("_root").value;
	document.location.href = root+"/portal/toLogin.do";
}