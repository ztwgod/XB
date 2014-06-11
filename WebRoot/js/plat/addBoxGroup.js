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
	}  else if (x_isEmpty("seatDesc")) {
		flag = false;
		show_err_msg('位置描述不能为空！');
		$('#seatDesc').focus();
	} else if (x_isEmpty("groupCode")) {
		flag = false;
		show_err_msg('组代码不能为空！');
		$('#groupCode').focus();	
	}
	return flag;
}

function appendGroupCode(){
	var districtId = jQuery("#districtId").val();
	var groupCode = jQuery("#groupCode").val();
	var root = jQuery("_root").val();
	var url = root +"/plat/verifyGroupCode.do?districtId="+districtId+"&groupCode="+groupCode;
	if(""==districtId){
		show_err_msg("请先选择所属地区！");
	}else if(""==groupCode){
		show_err_msg("组代码不能为空！");
	}/*else if(groupCode.length>2){
		jQuery("#ssCode").val("");
		show_err_msg("组代码不能超过2位！");
	}*/else{
		$.ajax({
			url: url,
			cache:false, //设置为 false 将不会从浏览器缓存中加载请求信息。
			dataType:'html', //接受数据格式 
			success: function(data,textStatus){
				jQuery("#groupCode").val(data);
			},
			error: function(XMLHttpRequest,textStatus, errorThrown){
				show_err_msg(" 请求出错!"+errorThrown);
			}
		});
	}
}

function checkAndSubmit() {
	if (checkBoxGroup()) {
		document.getElementById("frm").submit();
	}
}