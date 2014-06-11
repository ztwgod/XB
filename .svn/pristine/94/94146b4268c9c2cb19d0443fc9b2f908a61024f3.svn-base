function tolistUser(){
		var root = parent.document.getElementById("_root").value;
		document.location.href = root+"/plat/listUser.do";
	}

function checkUser(){
		var flag = true;
		show_loading();
		if(x_isEmpty("userAccount")){
			flag = false;
			show_err_msg('用户名不能为空！');	
			$('#userAccount').focus();			
		}else if(x_isEmpty("chName")){
			flag = false;		
			show_err_msg('姓名不能为空！');	
			$('#chName').focus();			
		}else if(x_getRadioValue("gender")==""){
			flag = false;
			show_err_msg('请选择用户性别！');			
		}else if(x_isEmpty("mobile")){
			flag = false;
			show_err_msg("手机号不能为空！");
			$('#mobile').focus();
		} else if(x_isEmpty("idType")){
			flag = false;
			show_err_msg("请选择证件类型！");
		}else if(x_isEmpty("idNo")){
			flag = false;
			show_err_msg("证件号码不能为空！");
			$('#idNo').focus();
		}else if(x_isEmpty("password")){
			flag = false;
			show_err_msg("密码不能为空！");
			$('#password').focus();
		}else if(x_isEmpty("password2")){
			flag = false;
			show_err_msg("确认密码不能为空！");
			$('#password2').focus();
		}else if(x_isEmpty("usualAddress")){
			flag = false;
			show_err_msg("常住地址不能为空！");
			$('#usualAddress').focus();
		}else if(x_isEmpty("zipCode")){
			flag = false;
			show_err_msg("常住邮编不能为空！");
			$('#zipCode').focus();
		} else if(x_isEmpty("registerAddress")){
			flag = false;
			show_err_msg("户籍地址不能为空！");
			$('#registerAddress').focus();
		} else if(x_isEmpty("status")){
			flag = false;
			show_err_msg("请选择用户状态！");
		} else if (!x_verifyCheckBox("role")) {
			flag = false;
			show_err_msg("请给用户分配至少一个角色！");
		}
		return flag;
	}

function checkPassword(){
	var flag = true;
	if(x_G("password").value!=x_G("password2").value){
		flag = false;
		show_err_msg("密码和确认密码必须一致！");
		$('#password2').focus();
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

function passwordLen(){
	var pLen = x_G("password").value.length;
	var bool = true;
	if(pLen<5){
		show_err_msg("密码长度不能少于5位！");
		$('#password').focus();
		bool = false;
	}
	return bool;
}

function checkEmail(){
	var flag = true;
	var emailVal = x_trim(x_G("email").value);
	if(null!=emailVal && ""!=emailVal){
		flag = x_isEmail(emailVal);
		if(!flag){
			show_err_msg("请输入正确的Email地址！");
			$('#email').focus();
		}
	}
	return flag;
}

function checkUserAccount(){
	var root = parent.document.getElementById("_root").value;
	var userAccountVal = x_G("userAccount").value;
	var url = root +"/plat/checkUserAccount.do?userAccount="+userAccountVal;
	if(""==userAccountVal){
		$("#msg").html("");
		$("#msg").html("用户名不能为空！");
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

function verifyUserAcount(){
	var obj = $("#msg").html();
	if("OK"!=obj){
		show_err_msg(obj);
	}
	return obj;
}

function checekAll(){
	var flag = false;
	var acResult = verifyUserAcount();	
	if(checkUser() && checkPassword() && checekPhone() && checkEmail() && passwordLen() && "OK"==acResult){
		flag = true;
	}
	return flag;
}

function checkAndSubmit(){
	if(checekAll()){
		document.getElementById("frm").submit();
	}
}