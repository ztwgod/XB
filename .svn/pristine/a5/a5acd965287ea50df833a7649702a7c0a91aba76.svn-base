function checkLogin(){
	var flag = true;
	if(x_isEmpty("TxtUserName")){
		flag = false;
		alert("用户名不能为空！");
	}else if(x_isEmpty("TxtPassword")){
		flag = false;
		alert("密码不能为空！");
	}else if(x_isEmpty("TxtYZM")){
		flag = false;
		alert("验证码不能为空！");
	}
	return flag;
}

function doLogin(){
	if(checkLogin()){
		x_G("frm").submit();
	}
}

function changeImage() {
	var root = parent.document.getElementById("_root").value;
	var obj = document.getElementById("img");
	var timenow = new Date().getTime();       
	obj.src = root+"/plat/image.jsp?d=" + timenow;
}