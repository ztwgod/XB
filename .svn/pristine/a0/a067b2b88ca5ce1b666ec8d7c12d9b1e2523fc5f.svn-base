function checkUserInfo() {
	var flag = true;
	show_loading();
	if(x_getRadioValue("gender")==""){
		flag = false;
		show_err_msg("请选择用户性别！");
	}else if(x_isEmpty("userName")){
		flag = false;
		show_err_msg("用户姓名不能为空！");
		jQuery('#userName').focus();
	}else if(x_isEmpty("mobile")){
		flag = false;
		show_err_msg("手机号不能为空！");
		jQuery('#mobile').focus();
	}else if(x_isEmpty("idType")){
		flag = false;
		show_err_msg("请选择证件类型！");
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

function checekPhone(){
	var phone = x_G("mobile").value;
	var flag = x_checkPhone(phone);
	if(!flag){
		show_err_msg("请输入正确的手机号！");
		jQuery('#mobile').focus();
	}
	return flag;
}

function checkAndSubmit() {
	if (checkUserInfo() && checekPhone()) {
		x_G("frm").submit();
	}
}