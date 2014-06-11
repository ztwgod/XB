function checkCard(){
		var flag = true;
		show_loading();
		if(x_isEmpty("cardExpirationDate")){
			flag = false;
			show_err_msg("有效期不能为空！");
			$('#cardExpirationDate').focus();
		}else if(x_isEmpty("type")) {
			flag = false;
			show_err_msg("请选择类型！");
		}else if(x_isEmpty("cardStatus")) {
			flag = false;
			show_err_msg("请选择卡片状态！");
		}else if(x_isEmpty("cardCode")) {
			flag = false;
			show_err_msg("卡片代码不能为空！");
		}else if(x_isEmpty("cardPassword")) {
			flag = false;
			show_err_msg("卡片密码不能为空！");
		}else if(x_isEmpty("scardPassword")) {
			flag = false;
			show_err_msg("确认卡片密码不能为空！");
		}else if(x_isEmpty("issuedAgency")) {
			flag = false;
			show_err_msg("请选择颁发机构！");
		}
		return flag;
	}

function checkPassword(){
	var flag = true;
	if(x_G("cardPassword").value!=x_G("scardPassword").value){
		flag = false;
		show_err_msg("密码和确认密码必须一致！");
		$('#scardPassword').focus();
	}
	return flag;
}

function passwordLen(){
	var pLen = x_G("cardPassword").value.length;
	var bool = true;
	if(pLen<5){
		show_err_msg("密码长度不能少于5位！");
		$('#cardPassword').focus();
		bool = false;
	}
	return bool;
}

function checkAll(){
	if(checkCard() && checkPassword() && passwordLen()){
		return true;
	}else{
		return false;
	}
}

function checkAndSubmit(){
	if(checkAll()){
		document.getElementById("frm").submit();
	}
}