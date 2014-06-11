function checkUser(){
		var flag = true;
		show_loading();
		if(x_isEmpty("userAccount")){
			flag = false;
			show_err_msg("用户名不能为空！");
			jQuery('#userAccount').focus();
		}else if(x_isEmpty("password")){
			flag = false;
			show_err_msg("密码不能为空！");
			jQuery('#password').focus();
		}else if(x_isEmpty("password2")){
			flag = false;
			show_err_msg("确认密码不能为空！");
			jQuery('#password2').focus();
		}else if(x_getRadioValue("gender")==""){
			flag = false;
			show_err_msg("请选择用户性别！");
		}else if(x_isEmpty("realName")){
			flag = false;
			show_err_msg("用户姓名不能为空！");
			jQuery('#realName').focus();
		}else if(x_isEmpty("mobile")){
			flag = false;
			show_err_msg("手机号不能为空！");
			jQuery('#mobile').focus();
		}
		return flag;
	}

function verifyUserAccount(){
	var root = document.getElementById("_root").value;
	var userAccountVal = x_G("userAccount").value;
	var url = root +"/portal/verifyUserAccount.do?userAccount="+userAccountVal;
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

function getUserAcount(){
	var obj = $("#msg").html();
	if("OK"!=obj){
		show_err_msg(obj);
	}
	return obj;
	
}

function checkPhone(){
	var phone = x_G("mobile").value;
	var flag = x_checkPhone(phone);
	if(!flag){
		show_err_msg("请输入正确的手机号！");
		$('#mobile').focus();
	}
	return flag;
}

function checkPassword(){
	var flag = true;
	if(x_G("password").value!=x_G("password2").value){
		flag = false;
		show_err_msg("密码和确认密码必须一致！");
		jQuery('#password2').focus();
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

function checekAndSubmit(){
	if(checkUser() && checkPassword() &&passwordLen() && checkPhone() && getUserAcount()=="OK"){
		x_G("frm").submit();
	}
}