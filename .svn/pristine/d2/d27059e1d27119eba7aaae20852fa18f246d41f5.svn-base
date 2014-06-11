//js工具类，异步调用的方法需要配合jquery.js才能使用

function x_G(id){
	return document.getElementById(id);
}

function x_getUrl(path){
	var rootPath = document.getElementById("root").value;
	var url = rootPath+path;
	return url;
}

function x_verifyCheckBox(name){
	var len = document.getElementsByName(name).length;
    var checked = false; 
    for (i = 0; i < len; i++){ 
        if (document.getElementsByName(name)[i].checked==true){ 
            checked = true; 
            break; 
        } 
    } 
    return checked;
}

function x_checkCheckBox(value,select){
	var valueObj = document.getElementsByName(value);
	var selectObj = document.getElementsByName(select);
	for ( var i = 0; i < valueObj.length; i++) {
		for ( var j = 0; j < selectObj.length; j++) {
			if(valueObj[i].value==selectObj[j].value){
				selectObj[j].checked=true
			}
		}
	}
}


function x_href(url){
	document.location.href = url;
}

//设置文本框不可用
//tagId文本框ID，flag：文本框属性值只能为空true或者为false
function x_disabled(tagId,flag){
	document.getElementById(tagId).style.display = flag;
}

//文本框可读属性
//tagId文本框id，flag：只能为true或者false标识改文本框是否为可读
function x_readOnly(tagID,flag){
	document.getElementById(tagID).readOnly = flag;
}

//修改radio按钮的选中状态
function x_change(radio_oj,aValue){    //传入一个对象
   for(var i=0;i<radio_oj.length;i++){
  	 if(radio_oj[i].value==aValue){ 
			radio_oj[i].checked=true; //修改选中状态
	   		break; //停止循环
  	 	}
	}
}

//只能输入整形或者double类型的数字
//1 第一个输入必须是数字，不能是小数点。例如.111
//2 不能存在多个.连续，只能一个。例如12....1
//3 不多出现一个.在不同地方。例如12.1.1
function x_clear(obj){
		//先把非数字的都替换掉，除了数字和.
		obj.value = obj.value.replace(/[^\d.]/g,"");
		//必须保证第一个为数字而不是.
		obj.value = obj.value.replace(/^\./g,"");
		//保证只有出现一个.而没有多个.
		obj.value = obj.value.replace(/\.{2,}/g,".");
		//保证.只出现一次，而不能出现两次以上
		obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
}

//该方法需要配合上面的方法使用用于input框失去焦点后执行
//input框失去焦点后执行的方法（防止用户复制粘贴输入非数字字符）
function x_delete(obj){		
		//先把非数字的都替换掉，除了数字和.
		obj.value = obj.value.replace(/[^\d.]/g,"");
		//必须保证第一个为数字而不是.
		obj.value = obj.value.replace(/^\./g,"");
		//保证只有出现一个.而没有多个.
		obj.value = obj.value.replace(/\.{2,}/g,".");
		//保证.只出现一次，而不能出现两次以上
		obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
		//不能以点结尾
		obj.value = obj.value.replace(/\.$/,"");
}

//只能输入数字
function x_isNaN(obj){
	obj.value=obj.value.replace(/[^\d]/g,'');
}

//只能输入数字和字母
function x_NaNAndLetter(obj){
	obj.value = obj.value.replace(/[^\w\.\/]/ig,'')
}

function x_IP(obj){
	obj.value = obj.value.replace(/[^\d|.]/g,'');
}

//全选
function x_selectAll(checkboxname) {
	var ids = document.getElementsByName(checkboxname);
	for (i = 0; i < ids.length; i++) {
		ids[i].checked = "checked";
	}
}
//全不选
function x_deselectAll(checkboxname) {
	var ids = document.getElementsByName(checkboxname);
	for (i = 0; i < ids.length; i++) {
		ids[i].checked = "";
	}
}
//反选
function x_deselect(checkboxname) {
	var ids = document.getElementsByName(checkboxname);
	for (i = 0; i < ids.length; i++) {
		if (ids[i].checked == "") {
			ids[i].checked = "checked";
		} else {
			ids[i].checked = "";
		}
	}
}
//获取单选按钮的值
function x_getRadioValue(tagName){
 		var name = "";
        var radios=document.getElementsByName(tagName);
        for(var i=0;i<radios.length;i++){
            if(radios[i].checked==true){
            	name = radios[i].value;
            	break;
            }
        }
        return name;
    }

//两个input标签之间的传值
//将id2的值赋值给id1
function x_setInputValue(id1, id2) {
	document.getElementById(id1).value = document.getElementById(id2).value;
}

//验证input是否为空
function x_isNull(id) {
	var obj = document.getElementById(id);
	if (obj != null && x_trim(obj.value) != "") {
		return true;
	} else {
		return false;
	}
}

// 验证EMAIL地址
function x_isEmail(email) {
	var flag = true;
	var s = email.replace(/(^\s*)|(\s*$)/g, "");
	//document.getElementById(id1).value = s;
	var patrn = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	if (s != "" && !patrn.exec(s)) {
		flag = false;
	}
	return flag;
}

// 验证电话号码
function x_checkTelephone(tele)
{
	var flag = true;
	
	var ab=/^(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
	if(ab.test(tele)==false){
		flag = false;
	}
	return flag;
}

// 验证手机号
function x_checkPhone(phone){
	var flag = true;
	var ab=/^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$/;
	if(ab.test(phone)==false){
		flag = false;
	}
	return flag;
}

//获取年龄
function getAge(tagId){
	var i_birthday = document.getElementById(tagId).value;
	var birthday = new Date(i_birthday.replace(/-/g, "\/")); 
	var d = new Date(); 
	var age = d.getFullYear()-birthday.getFullYear()-((d.getMonth()<birthday.getMonth()|| d.getMonth()==birthday.getMonth() && d.getDate()<birthday.getDate())?1:0);
	return age;
}

//校验身份证号码
function x_isIdCard(dataId) {
	var s = document.getElementById(dataId).value;
	document.getElementById(dataId).value = s.replace(/(^\s*)|(\s*$)/g, "");
	var Y, JYM;
	var S, M;
	var area = {
		11 : "北京",
		12 : "天津",
		13 : "河北",
		14 : "山西",
		15 : "内蒙古",
		21 : "辽宁",
		22 : "吉林",
		23 : "黑龙江",
		31 : "上海",
		32 : "江苏",
		33 : "浙江",
		34 : "安徽",
		35 : "福建",
		36 : "江西",
		37 : "山东",
		41 : "河南",
		42 : "湖北",
		43 : "湖南",
		44 : "广东",
		45 : "广西",
		46 : "海南",
		50 : "重庆",
		51 : "四川",
		52 : "贵州",
		53 : "云南",
		54 : "西藏",
		61 : "陕西",
		62 : "甘肃",
		63 : "青海",
		64 : "宁夏",
		65 : "新疆",
		71 : "台湾",
		81 : "香港",
		82 : "澳门",
		91 : "国外"
	}
	var idcard_array = new Array();

	// 地区检验
	if (area[parseInt(s.substr(0, 2))] == null)
		return false;

	// 身份号码位数及格式检验
	if (s.length == 15) {
		if ((parseInt(s.substr(6, 2)) + 1900) % 4 == 0
				|| ((parseInt(s.substr(6, 2)) + 1900) % 100 == 0 && (parseInt(s
						.substr(6, 2)) + 1900)
						% 4 == 0)) {
			ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;// 测试出生日期的合法性
		} else {
			ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;// 测试出生日期的合法性
		}

		if (!ereg.exec(s))
			return false;

		// 15位转换为18位
		s = s.substring(0, 6) + "19" + s.substring(6, 15);
		var strJiaoYan = ["1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"];
		var intTemp = eval(s.charAt(0) * 7 + s.charAt(1) * 9 + s.charAt(2) * 10
				+ s.charAt(3) * 5 + s.charAt(4) * 8 + s.charAt(5) * 4
				+ s.charAt(6) * 2 + s.charAt(7) * 1 + s.charAt(8) * 6
				+ s.charAt(9) * 3 + s.charAt(10) * 7 + s.charAt(11) * 9
				+ s.charAt(12) * 10 + s.charAt(13) * 5 + s.charAt(14) * 8
				+ s.charAt(15) * 4 + s.charAt(16) * 2);
		intTemp %= 11;
		s = s + strJiaoYan[intTemp];
	}

	if (s.length == 18) {
		// 18位身份号码检测
		// 出生日期的合法性检查
		// 闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
		// 平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
		if (parseInt(s.substr(6, 4)) % 4 == 0
				|| (parseInt(s.substr(6, 4)) % 100 == 0 && parseInt(s.substr(6,
						4))
						% 4 == 0)) {
			ereg = /^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;// 闰年出生日期的合法性正则表达式
		} else {
			ereg = /^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;// 平年出生日期的合法性正则表达式
		}

		// 测试出生日期的合法性
		if (!ereg.test(s))
			return false;

		// 计算校验位
		idcard_array = s.split("");
		S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
				+ (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
				+ (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
				+ (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
				+ (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
				+ (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
				+ (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
				+ parseInt(idcard_array[7]) * 1 + parseInt(idcard_array[8]) * 6
				+ parseInt(idcard_array[9]) * 3;

		Y = S % 11;
		M = "F";
		JYM = "10X98765432";
		M = JYM.substr(Y, 1);// 判断校验位

		if (M == idcard_array[17]) {
			return true; // 检测ID的校验位
		}
	}
	return false;
}
//去掉空格
function x_trim(args){
	return args.replace(/(^\s*)|(\s*$)/g, "");
}

 //是否为空校验
function x_isEmpty(id){
	var flag = false;
	var val = x_G(id).value;
	if(null==x_trim(val) || ""==x_trim(val)){
		flag = true;
	}
	return flag;
}


//ajax，需要配合jquery.js才能使用
//发送Get请求
//result:用于显示div的结果集的页面元素
//url：请求路径，参数需要在此拼接好。
function x_get(result,url){
	 var result = "#"+result;
	 //加上随机数防止缓存
	 if(url.indexOf('?')<1){
   	 	url+="?timestamp="+Math.random();
     }else{
     	url+="&timestamp="+Math.random();
     }	
	$(result).load(url);  
}

//发送Post请求, 返回后执行回调函数.
//callBack：回调函数名称如：test
function x_post(result,url,value,callBack){
	 var result = "#"+result;
     $(result).load(url, { "param": value },function(responseText, textStatus, XMLHttpRequest){
     		eval(callBack+"('"+ responseText +"')");
    });
}

//发送Post请求
//result:用于显示div的结果集的页面元素
//url：请求路径。 
function x_post1(result,url,value){
	 var result = "#"+result;
     $(result).load(url, { "param": value },function(responseText, textStatus, XMLHttpRequest){
     		$(result).html(responseText); //或者: $(this).html(responseText);  
    }); 
}


//ajax：默认以get方式发送请求
//var key = new Array("salesman");
//var value = new Array(value);
//详细参数设置：http://www.cnblogs.com/qleelulu/archive/2008/04/21/1163021.html
function x_ajax(url,key,value,success,error){
		var data = x_getData(key,value);
		$.ajax({
				url: url,
				cache:false, //(默认: true) jQuery 1.2 新功能，设置为 false 将不会从浏览器缓存中加载请求信息。
				dataType:'html', //接受数据格式 
				data:data,//要传递的数据 
				beforeSend: function(XMLHttpRequest){
					//ShowLoading();
				},
				success: function(data,textStatus){
					eval(success+"('"+ data +"')");
				},
				complete: function(XMLHttpRequest,textStatus){
					//HideLoading(); 请求完成后回调函数 (请求成功或失败时均调用)。
				},
				error: function(XMLHttpRequest,textStatus, errorThrown){
					//请求出错处理
					if(null == error){
						alert(" 请求出错!"+errorThrown);
					}else{
						eval(error+"()");
					}
				}
		});
}
//通过key和value组装数据
function x_getData(key,value){
	var context = "";
	if(key.length==value.length){
		for(var i=0;i<key.length;i++){
			context+=(key[i]+"="+value[i]+"&");
		}
	}else{
		alert(" 数据有误！");
	}
	if(context.charAt(context.length-1)=="&"){
		context=context.substring(0,context.length-1);
	}
	return context;
}