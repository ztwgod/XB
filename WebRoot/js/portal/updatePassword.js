function checkPassword(){
		var flag = true;
		show_loading();
		if(x_isEmpty("oldPassword")){
			flag = false;
			show_err_msg("旧密码不能为空！");
			jQuery('#oldPassword').focus();
		}else if(x_isEmpty("newPassword")){
			flag = false;
			show_err_msg("新密码不能为空！");
			jQuery('#newPassword').focus();
		}else if(x_isEmpty("newPassword2")){
			flag = false;
			show_err_msg("确认密码不能为空！");
			jQuery('#newPassword2').focus();
		}
		return flag;
	}

function checkPasswordSame(){
	var flag = true;
	if(x_G("newPassword").value!=x_G("newPassword2").value){
		flag = false;
		show_err_msg("新密码和确认密码必须一致！");
		jQuery('#newPassword2').focus();
	}
	return flag;
}

function checkOldPassword(){
	var root = document.getElementById("_root").value;
	var oldPasswordVal = x_G("oldPassword").value;
	var url = root +"/portal/checkOldPasswod.do?oldPassword="+oldPasswordVal;
	if(""==oldPasswordVal){
		$("#msg").html("");
		$("#msg").html("旧密码不能为空！");
		jQuery('#oldPassword').focus();
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
	var obj = $("#msg").html();
	if("OK"!=obj){
		show_err_msg(obj);
	}
	return obj;
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

function checkAndSubmit(){
	if(checkPassword() && checkPasswordSame() && passwordLen() && getMsg()=="OK"){
		x_G("frm").submit();
	}
}