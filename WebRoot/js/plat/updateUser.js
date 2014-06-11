function tolistUser() {
	var root = parent.document.getElementById("_root").value;
	document.location.href = root + "/plat/listUser.do";
}

function checkUser() {
	var flag = true;
	show_loading();
	if (x_isEmpty("chName")) {
		flag = false;
		show_err_msg("姓名不能为空！");
		$('#chName').focus();
	} else if (x_getRadioValue("gender") == "") {
		flag = false;
		show_err_msg("请选择用户性别！");
	}else if (x_isEmpty("mobile")) {
		flag = false;
		show_err_msg("手机号不能为空！");
		$('#mobile').focus();
	}  else if (x_isEmpty("idType")) {
		flag = false;
		show_err_msg("请选择证件类型！");
	} else if (x_isEmpty("idNo")) {
		flag = false;
		show_err_msg("证件号码不能为空！");
		$('#idNo').focus();
	} else if (x_isEmpty("usualAddress")) {
		flag = false;
		show_err_msg("常住地址不能为空！");
		$('#usualAddress').focus();
	} else if (x_isEmpty("zipCode")) {
		flag = false;
		show_err_msg("常住邮编不能为空！");
		$('#zipCode').focus();
	} else if (x_isEmpty("registerAddress")) {
		flag = false;
		show_err_msg("户籍地址不能为空！");
		$('#registerAddress').focus();
	}  else if (x_isEmpty("status")) {
		flag = false;
		show_err_msg("请选择用户状态！");
	} else if (!x_verifyCheckBox("role")) {
		flag = false;
		show_err_msg("请给用户分配至少一个角色！");
	}
	return flag;
}

function checekPhone() {
	var phone = x_G("mobile").value;
	var flag = x_checkPhone(phone);
	if (!flag) {
		show_err_msg("请输入正确的手机号！");
		$('#mobile').focus();
	}
	return flag;
}

function checkEmail() {
	var flag = true;
	var emailVal = x_trim(x_G("email").value);
	if (null != emailVal && "" != emailVal) {
		flag = x_isEmail(emailVal);
		if (!flag) {
			show_err_msg("请输入正确的Email地址！");
			$('#email').focus();
		}
	}
	return flag;
}

function checekAll() {
	var flag = false;
	if (checkUser() && checekPhone() && checkEmail()) {
		flag = true;
	}
	return flag;
}

function checkAndSubmit() {
	if (checekAll()) {
		document.getElementById("frm").submit();
	}
}