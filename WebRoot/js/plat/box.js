jQuery(document).ready(function(){
	jQuery(".clos_box,.cols2,.clos_box_XL,.clos_box_XXL,.clos_box_L").mouseover(function(){
		jQuery(this).attr("style","BACKGROUND-COLOR:#97D319");
	});
	
	jQuery(".clos_box,.cols2,.clos_box_XL,.clos_box_XXL,.clos_box_L").mouseout(function(){
		jQuery(this).attr("style","BACKGROUND-COLOR:#88c424");
	});
});

var _tagId = "";
function showTipsWindown(objValue,tagId){
	_tagId = tagId;
	var root = parent.document.getElementById("_root").value;
	var ssId = x_G("ssId").value;
	
	if(objValue=='1'){ //同步
		var url = "iframe:"+root+"/plat/synchronizedBox.do?boxId="+tagId+"&ssId="+ssId;
		tipsWindown("同步物箱信息",url,"300","80","false","","false","","","false");
		
	}else if(objValue=='2'){
		var url = "iframe:"+root+"/plat/listCourier.do?boxId="+tagId+"&ssId="+ssId+"&exePermission="+1;
		tipsWindown("设置收件快递员组",url,"800","600","false","","false","","setCourierGroup","true");
		
	}else if(objValue=='3'){
		var url = "iframe:"+root+"/plat/listCourier.do?boxId="+tagId+"&ssId="+ssId+"&exePermission="+2;
		tipsWindown("设置投件快递员组",url,"800","600","false","","false","","setCastPartsGroup","true");
		
	}else if(objValue=='4'){
		
		var root = parent.document.getElementById("_root").value;
		var url = "iframe:"+root+"/plat/listEgis.do?ssId="+ssId;
		tipsWindown("设置维护员",url,"800","500","false","","false","","getSystemValue","true");
		
	}else if(objValue=='5'){
		
		var root = parent.document.getElementById("_root").value;
		var url = "iframe:"+root+"/plat/searchStorStatus.do?ssId="+ssId+"&boxId="+tagId;
		tipsWindown("物箱状态",url,"500","100","false","","false","","","false");
		
	}else if(objValue=='6'){
		
		var root = parent.document.getElementById("_root").value;
		var url = "iframe:"+root+"/plat/searchPeripheralStatus.do?ssId="+ssId+"&boxId="+tagId;
		tipsWindown("外围设备状态",url,"400","340","false","","false","","","false");
		
		
	}else if(objValue=='7'){
		var height = 100;
		if(tagId=="box_0"){
			height = 500;
		}		
		var root = parent.document.getElementById("_root").value;
		var url = "iframe:"+root+"/plat/searchBoxInfoStatus.do?ssId="+ssId+"&boxId="+tagId;
		tipsWindown("箱子状态",url,"500",height,"false","","false","","","false");
		
	}else if(objValue=='8'){
		
		//var url = "iframe:"+root+"/plat/openBox.do?boxId="+tagId+"&ssId="+ssId;
		//tipsWindown("开箱",url,"300","80","false","","false","","","true");
		var url = "iframe:"+root+"/plat/toOpenBox.do?boxId="+tagId+"&ssId="+ssId;
		tipsWindown("开箱",url,"400","100","false","","false","","openBox","true");
		
	}else if(objValue=='9'){
		
		var url = "iframe:"+root+"/plat/sendServiceSMS.do?boxId="+tagId+"&ssId="+ssId;
		tipsWindown("维修密码发送",url,"300","80","false","3000","false","","","false");
		
	}else if(objValue=='10'){
		
		var url = "iframe:"+root+"/plat/sendOpenBoxSMS.do?boxId="+tagId+"&ssId="+ssId;
		tipsWindown("开箱密码重发",url,"300","80","false","3000","false","","","false");
		
	}	
}

//开箱回调函数
function openBox(){
	var frame = document.getElementById("_tipFram").contentWindow;
	var mobile = frame.document.getElementById("mobile").value;
	var randCode = frame.document.getElementById("randCode").value;
	
	var boxId = frame.document.getElementById("boxId").value;
	var ssId = frame.document.getElementById("ssId").value;
	var root = frame.document.getElementById("_root").value;
	
	if(null == mobile || ""==mobile){
		alert("手机号不能为空！");
		var url = "iframe:"+root+"/plat/toOpenBox.do?boxId="+boxId+"&ssId="+ssId+"&randCode="+randCode+"&mobile="+mobile;
		tipsWindown("开箱",url,"400","100","false","","false","","openBox","true");
	}else if(null == randCode ||"" == randCode){
		alert("随机码不能为空！");
		var url = "iframe:"+root+"/plat/toOpenBox.do?boxId="+boxId+"&ssId="+ssId+"&randCode="+randCode+"&mobile="+mobile;
		tipsWindown("开箱",url,"400","100","false","","false","","openBox","true");
	}else{
		var url = "iframe:"+root+"/plat/openBox.do?boxId="+boxId+"&ssId="+ssId+"&randCode="+randCode+"&mobile="+mobile;
		tipsWindown("开箱",url,"300","80","false","","false","","","false");
	}
}


//设置维护员回调函数
function getSystemValue(){
	var frame = document.getElementById("_tipFram").contentWindow;
	var obj = frame.document.getElementsByName("egisId");
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i].checked==true){
			var userName=obj[i].id; //用户姓名
			var userId = obj[i].value; //用户id
			var root = parent.document.getElementById("_root").value;
			var ssId = x_G("ssId").value;
			
			var url = "iframe:"+root+"/plat/setSystemUser.do?boxId="+_tagId+"&ssId="+ssId+"&userId="+userId;
			tipsWindown("设置维护员",url,"300","80","false","","false","","","false");
			
			break;
		}
	}
}

//设置收件快递员组
function setCourierGroup(){
	var frame = document.getElementById("_tipFram").contentWindow;
	var obj = frame.document.getElementsByName("groupIds");
	var strGroupIds = "";
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i].checked==true){
			//var groupName=obj[i].id; //组名称
			var groupId = obj[i].value; //用户id
			strGroupIds+=(groupId+"@");
		}
	}
	var groupIds = "";
	if(strGroupIds.charAt(strGroupIds.length-1)=="@"){
		groupIds = strGroupIds.substring(0,strGroupIds.length-1);
	}
	//alert(groupIds);
	var root = parent.document.getElementById("_root").value;
	var ssId = x_G("ssId").value;	
	var url = "iframe:"+root+"/plat/setRecipientCourier.do?boxId="+_tagId+"&ssId="+ssId+"&groupIds="+groupIds;
	tipsWindown("设置收件快递员组",url,"300","80","false","","false","","","false");
}

//设置投件快递员组
function setCastPartsGroup(){
	var frame = document.getElementById("_tipFram").contentWindow;
	var obj = frame.document.getElementsByName("groupIds");
	var strGroupIds = "";
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i].checked==true){
			var groupId = obj[i].value; //用户id
			strGroupIds+=(groupId+"@");
		}
	}
	var groupIds = "";
	if(strGroupIds.charAt(strGroupIds.length-1)=="@"){
		groupIds = strGroupIds.substring(0,strGroupIds.length-1);
	}
	var root = parent.document.getElementById("_root").value;
	var ssId = x_G("ssId").value;	
	var url = "iframe:"+root+"/plat/setCastPartsCourier.do?boxId="+_tagId+"&ssId="+ssId+"&groupIds="+groupIds;
	tipsWindown("设置投件快递员组",url,"300","80","false","","false","","","false");
}
