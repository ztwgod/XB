function checkUser(){
		var flag = true;
		show_loading();
		if(x_isEmpty("boxAliases")){
			flag = false;
			show_err_msg("物箱别名不能为空！");
		}else if(x_isEmpty("storGroup")){
			flag = false;
			show_err_msg("请选择定制物箱组！");
		}else if(x_isEmpty("stor")){
			flag = false;
			show_err_msg("请选择定制物箱！");
		}else if(x_isEmpty("box")){
			flag = false;
			show_err_msg("请选择定制箱子！");
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