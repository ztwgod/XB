function toListBoxGroup() {
	var root = parent.document.getElementById("_root").value;
	document.location.href = root + "/plat/listBoxGroup.do";
}

function checkBoxGroup() {
	var flag = true;
	show_loading();
	if (x_isEmpty("groupAbb")) {
		flag = false;
		show_err_msg('组简称不能为空！');	
		$('#groupAbb').focus();		
	}else if (x_isEmpty("groupCode")) {
		flag = false;
		show_err_msg('组代码不能为空！');
		$('#groupCode').focus();	
	} else if (x_isEmpty("longitude")) {
		flag = false;
		show_err_msg('经度不能为空！');
		$('#longitude').focus();		
	} else if (x_isEmpty("latitude")) {
		flag = false;
		show_err_msg('纬度不能为空！');
		$('#latitude').focus();
	}  else if (x_isEmpty("districtId")) {
		flag = false;
		show_err_msg('请选择所属地区！');
	}else if (x_isEmpty("locationAbb")) {
		flag = false;
		show_err_msg('街道/地址不能为空！');
		$('#locationAbb').focus();
	} else if (x_isEmpty("seatDesc")) {
		flag = false;
		show_err_msg('位置描述不能为空！');
		$('#seatDesc').focus();
	}
	return flag;
}

function checkAndSubmit() {
	if (checkBoxGroup()) {
		document.getElementById("frm").submit();
	}
}