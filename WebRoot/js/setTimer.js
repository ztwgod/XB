/**//***********************************
* 简单时间控件： version 1.0
* 作者：李禄燊 
* 时间：2007-10-31
* 
* 使用说明：
* 首先把本控件包含到页面 
* <script src="XXX/setTime.js" type="text/javascript"></script>
* 控件调用函数：_SetTime(field)
* 例如 <input name="time" type="text" onclick="_SetTime(this)"/>
*
************************************/
var str = "";
document.writeln("<div id=\"_contents\" name=\"_contents\" style=\"padding:6px; background-color:#FFFFFF; font-size: 12px; border: 1px solid #777777; position:absolute; left:?px; top:?px; width:?px; height:?px; z-index:1; visibility:hidden\">");
str += "\u65f6<select id=\"_hour\" name=\"_hour\">";
for (h = 0; h <= 9; h++) {
str += "<option name=\"_options\" value=\"0" + h + "\">0" + h + "</option>";
}
for (h = 10; h <= 23; h++) {
str += "<option name=\"_options\" value=\"" + h + "\">" + h + "</option>";
}
str += "</select> \u5206<select id=\"_minute\" name=\"_minute\" >";
for (m = 0; m <= 9; m++) {
str += "<option name=\"_options\" value=\"0" + m + "\">0" + m + "</option>";
}
for (m = 10; m <= 59; m++) {
str += "<option name=\"_options\" value=\"" + m + "\">" + m + "</option>";
}
str += "</select> \u79d2<select id=\"_second\" name=\"_second\" >";
for (s = 0; s <= 9; s++) {
str += "<option name=\"_options\" value=\"0" + s + "\">0" + s + "</option>";
}
for (s = 10; s <= 59; s++) {
str += "<option name=\"_options\" value=\"" + s + "\">" + s + "</option>";
}
str += "</select> <input name=\"_ok\" type=\"button\" onclick=\"_select()\" value=\"确定\" style=\"font-size:12px;width:40px;height:23px;\" />" +
		"&nbsp;&nbsp;&nbsp;<input name=\"_quit\" type=\"button\" onclick=\"_hidden()\" value=\"清除\" style=\"font-size:12px;width:40px;height:23px;\" />" +
		"</div>";
document.writeln(str);
var _fieldname;
function _SetTime(tt) {
	_fieldname = tt;
	var ttop = tt.offsetTop; //TT控件的定位点高
	var thei = tt.clientHeight; //TT控件本身的高
	var tleft = tt.offsetLeft; //TT控件的定位点宽
	while (tt = tt.offsetParent) {
		ttop += tt.offsetTop;
		tleft += tt.offsetLeft;
	}
	document.getElementById("_contents").style.top = (ttop + thei + 4)+"px";
	document.getElementById("_contents").style.left = tleft+"px";
	document.getElementById("_contents").style.visibility = "visible";
}

function _select() {
	_fieldname.value = document.getElementById("_hour").value + ":" + document.getElementById("_minute").value + ":" + document.getElementById("_second").value;
	document.getElementById("_contents").style.visibility = "hidden";
}

function _hidden(){
	document.getElementById("_contents").style.visibility = "hidden";
	_fieldname.value="";
}

jQuery(document).ready(function(){
	document.onclick = function (event){//监听onclick事件
		var obj = "";
	    if (event.srcElement){
	    	obj = event.srcElement;  //IE
	    } else {
	    	obj = event.currentTarget;	    	
	    }	    
	    var parNode = obj.parentNode;
	    var isHidden = false;
	    if(""==obj.name){
	    	isHidden = true;
	    }else{
	    	if(obj.id!="_contents" && obj.id!=_fieldname.id && obj.name!="_hour" && obj.name!="_minute" && obj.name!="_second"){		    	
	    		isHidden = true;	    		
	    		if(null!=parNode && ""!=parNode){
	    			if(undefined!=parNode.name){
	    				if(parNode.name=="_hour" || parNode.name=="_minute" || parNode.name=="_second"){
	    					isHidden = false;
	    				}
	    			}
	    		}
	    	}
	    }	    
	    if(isHidden){
	    	//alert(obj.name);
	    	document.getElementById("_contents").style.visibility = "hidden";
	    }
	}	
});
