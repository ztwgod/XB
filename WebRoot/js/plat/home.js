function checkPassword(){
		var flag = true;
		show_loading();
		if(x_isEmpty("oldPassword")){
			flag = false;
			show_err_msg("旧密码不能为空！");
			$('#oldPassword').focus();
		}else if(x_isEmpty("newPassword")){
			flag = false;
			show_err_msg("新密码不能为空！");
			$('#newPassword').focus();
		}else if(x_isEmpty("newPassword2")){
			flag = false;
			show_err_msg("确认密码不能为空！");
			$('#newPassword2').focus();
		}
		return flag;
	}

function checkPasswordSame(){
	var flag = true;
	if(x_G("newPassword").value!=x_G("newPassword2").value){
		show_err_msg("新密码和确认密码必须一致！");
		flag = false;
		$('#newPassword2').focus();
	}
	return flag;
}

function passwordLen(){
	var pLen = x_G("newPassword").value.length;
	var bool = true;
	if(pLen<5){
		show_err_msg("密码长度不能少于5位！");
		$('#newPassword').focus();
		bool = false;
	}
	return bool;
}

function checkOldPassword(){
	var root = parent.document.getElementById("_root").value;
	var oldPasswordVal = x_G("oldPassword").value;
	var url = root +"/plat/checkPlatOldPasswod.do?oldPassword="+oldPasswordVal;
	if(""==oldPasswordVal){
		$("#msg").html("");
		$("#msg").html("旧密码不能为空！");
		$('#oldPassword').focus();	
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

function getMsg(){
	return $("#msg").html();
}

function updatePassword(){
	if(checkPassword() && checkPasswordSame() && passwordLen() && getMsg()=="OK"){
		x_G("frm1").submit();
	}
}



/**修改基本信息***/

function checkUserInfo(){
	var flag = true;
	show_loading();
	if(x_isEmpty("chName")){
		flag = false;
		show_err_msg("用户姓名不能为空！");
		$('#chName').focus();
	}else if(x_getRadioValue("gender")==""){
		flag = false;
		show_err_msg("请选择用户性别！");
	}else if(x_isEmpty("mobile")){
		flag = false;
		show_err_msg("手机号不能为空！");
		$('#mobile').focus();
	}else if(x_isEmpty("idType")){
		flag = false;
		show_err_msg("证件类型不能为空！");
		$('#idType').focus();
	}else if(x_isEmpty("idNo")){
		flag = false;
		show_err_msg("证件号不能为空！");
		$('#idNo').focus();
	}else if(x_isEmpty("usualAddress")){
		flag = false;
		show_err_msg("常住地址不能为空！");
		$('#usualAddress').focus();
	} else if(x_isEmpty("zipCode")){
		flag = false;
		show_err_msg("常住邮编不能为空！");
		$('#zipCode').focus();
	} else if(x_isEmpty("registerAddress")){
		flag = false;
		show_err_msg("户籍地址不能为空！");
		$('#registerAddress').focus();
	}
	return flag;
}

function checekPhone(){
	var phone = x_G("mobile").value;
	var flag = x_checkPhone(phone);
	if(!flag){
		show_err_msg("请输入正确的手机号！");
		$('#mobile').focus();
	}
	return flag;
}

function checkAndSubmit(){
	if(checkUserInfo() && checekPhone()){
		x_G("frm2").submit();
	}
}





