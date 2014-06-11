function getDefaultValue(){
	var obj = document.getElementsByName('groupIds');
	var strGroupIds = "";
	var strGroupNames = "";	
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i].checked==true){
			var groupName = obj[i].id; //组名称
			var groupId = obj[i].value; //用户id
			strGroupIds+=(groupId+"@");
			strGroupNames+=(groupName+" ");
		}
	}
	var groupIds = "";
	if(strGroupIds.charAt(strGroupIds.length-1)=="@"){
		groupIds = strGroupIds.substring(0,strGroupIds.length-1);
	}	
	document.getElementById('checkedGroupId').value = groupIds;
	document.getElementById('checkedGroupName').value = strGroupNames;
	document.getElementById('_divSelected').innerHTML = '当前选择：'+strGroupNames;
}

function search() {
	x_G("pageNumber").value = 1;
	x_G("frm").submit();
}

function showMorelist(){	
	var pageNumber = jQuery("#pageNumber").val();
	var pagecount = jQuery("#pagecount").val();
	
	var nextPageNumber = parseInt(pageNumber)+parseInt(1);
	if(parseInt(nextPageNumber)>parseInt(pagecount)){
		jQuery('#showMoreBut').html("已经获取所有信息...");
		return;
	}else{
		jQuery('#pageNumber').val(nextPageNumber);
	}
	
	var ssId = jQuery("#ssId").val();
	var pageSize = jQuery('#pageSize').val();
	var groupName = jQuery("#groupName").val();
	var districtId = jQuery("#districtId").val();
	var root = jQuery("#root").val();
	
	var url = root + "/plat/showMoreCourier.do?pageSize="+jQuery('#pageSize').val()+ "&ssId="+ssId +"&pageNumber="+jQuery('#pageNumber').val()+"&groupName="+groupName+"&districtId="+districtId;

	jQuery.ajax( {
		type : "GET",
		cache : false,
		url : url,
		dataType : 'html',
		success : function(data, textStatus) {
			var tableHtml = jQuery("#courierTab").html();
			jQuery("#courierTab").html(tableHtml+data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			jQuery("#showMoreBut").html("请求出错!");
		}
	});
	
}