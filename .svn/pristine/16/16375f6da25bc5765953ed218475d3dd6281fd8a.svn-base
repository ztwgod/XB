function checkLogin(){
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
	}else if(x_isEmpty("yzm")){
		flag = false;
		show_err_msg("验证码不能为空！");
		jQuery('#yzm').focus();
	}
	return flag;
}

function doLogin(){
	if(checkLogin()){
		x_G("frm").submit();
	}
}

function changeImage() {
	var root = document.getElementById("_root").value;
	var obj = document.getElementById("img");
	var timenow = new Date().getTime();       
	obj.src = root+"/portal/image.jsp?d=" + timenow;
}