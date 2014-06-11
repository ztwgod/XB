var getOffset = {
	top: function (obj) {
		return obj.offsetTop + (obj.offsetParent ? arguments.callee(obj.offsetParent) : 0) 
	},
	left: function (obj) {
		return obj.offsetLeft + (obj.offsetParent ? arguments.callee(obj.offsetParent) : 0) 
	}	
};

window.onload = function (){
	var oMenu = document.getElementById("rightMenu");
	var aUl = oMenu.getElementsByTagName("ul");
	var aLi = oMenu.getElementsByTagName("li");
	var showTimer = hideTimer = null;
	var i = 0;
	var maxWidth = maxHeight = 0;
	var aDoc = [document.documentElement.offsetWidth, document.documentElement.offsetHeight];
	
	oMenu.style.display = "none";
	
	for (i = 0; i < aLi.length; i++)
	{
		//为含有子菜单的li加上箭头
		aLi[i].getElementsByTagName("ul")[0] && (aLi[i].className = "sub");
		//鼠标移入
		aLi[i].onmouseover = function ()
		{
			var oThis = this;
			var oUl = oThis.getElementsByTagName("ul");
			//鼠标移入样式
			oThis.className += " active";
			//显示子菜单
			if (oUl[0])
			{
				clearTimeout(hideTimer);				
				showTimer = setTimeout(function ()
				{
					for (i = 0; i < oThis.parentNode.children.length; i++)
					{
						oThis.parentNode.children[i].getElementsByTagName("ul")[0] &&
						(oThis.parentNode.children[i].getElementsByTagName("ul")[0].style.display = "none");
					}
					oUl[0].style.display = "block";
					oUl[0].style.top = oThis.offsetTop + "px";
					oUl[0].style.left = oThis.offsetWidth + "px";
					setWidth(oUl[0]);
					
					//最大显示范围					
					maxWidth = aDoc[0] - oUl[0].offsetWidth;
					maxHeight = aDoc[1] - oUl[0].offsetHeight;
					
					//防止溢出
					maxWidth < getOffset.left(oUl[0]) && (oUl[0].style.left = -oUl[0].clientWidth + "px");
					maxHeight < getOffset.top(oUl[0]) && (oUl[0].style.top = -oUl[0].clientHeight + oThis.offsetTop + oThis.clientHeight + "px")
				},300);
			}			
		};
			
		//鼠标移出	
		aLi[i].onmouseout = function ()
		{
			var oThis = this;
			var oUl = oThis.getElementsByTagName("ul");
			//鼠标移出样式
			oThis.className = oThis.className.replace(/\s?active/,"");
			
			clearTimeout(showTimer);
			hideTimer = setTimeout(function ()
			{
				for (i = 0; i < oThis.parentNode.children.length; i++)
				{
					oThis.parentNode.children[i].getElementsByTagName("ul")[0] &&
					(oThis.parentNode.children[i].getElementsByTagName("ul")[0].style.display = "none");
				}
			},300);
		};
	}	
	
	//自定义右键菜单
	var objId = "";
	document.oncontextmenu = function (event){
		var event = event || window.event;
		var  target = event.target  ||event.srcElement; // 获得事件源 
		//target.getAttribute()是获取该事件源对像里面的一些属性。比如对像中有（name，id，type等等）；
		objId = target.getAttribute('id');
		
		if(null == objId){
			return;
		}		
		if(objId.indexOf("box")==-1){
			return;
		}else{
			/*if(objId.indexOf("box_0")!=-1){ //主控制面板，控制整个物箱
				
			}*/
		}		
		
		oMenu.style.display = "block";
		if(objId.indexOf("box_0")!=-1){ //主控制面板，控制整个物箱
			//隐藏操作选项
			var operateObj = document.getElementById("operate");
			operateObj.style.display = "none";
			
			//显示同步
			var synObj = document.getElementById("syn");
			synObj.style.display = "block";
			
			//显示配置
			var configObj = document.getElementById("config");
			configObj.style.display = "block";
			
		}else{//小箱子
			//显示操作选项
			var operateObj = document.getElementById("operate");
			operateObj.style.display = "block";
			
			//隐藏同步选择
			var synObj = document.getElementById("syn");
			synObj.style.display = "none";
			
			//隐藏配置
			var configObj = document.getElementById("config");
			configObj.style.display = "none";
		}
		
		oMenu.style.top = event.clientY + "px";
		oMenu.style.left = event.clientX + "px";
		setWidth(aUl[0]);
		
		//最大显示范围
		maxWidth = aDoc[0] - oMenu.offsetWidth;
		maxHeight = aDoc[1] - oMenu.offsetHeight;
		
		//防止菜单溢出
		oMenu.offsetTop > maxHeight && (oMenu.style.top = maxHeight + "px");
		oMenu.offsetLeft > maxWidth && (oMenu.style.left = maxWidth + "px");
		
		//alert(objId);
		return false;
	};
	
	//点击隐藏菜单
	document.onclick = function (){
		oMenu.style.display = "none"	
	};
	
	//设置右键菜单点击事件监听
	jQuery(".nav").click(function(){
		process(jQuery(this).attr("value"),objId);
	});
	
	
	//取li中最大的宽度, 并赋给同级所有li	
	function setWidth(obj){
		maxWidth = 0;
		for (i = 0; i < obj.children.length; i++)
		{
			var oLi = obj.children[i];			
			var iWidth = oLi.clientWidth - parseInt(oLi.currentStyle ? oLi.currentStyle["paddingLeft"] : getComputedStyle(oLi,null)["paddingLeft"]) * 2
			if (iWidth > maxWidth) maxWidth = iWidth;
		}
		for (i = 0; i < obj.children.length; i++) 
			obj.children[i].style.width = maxWidth + "px";
	}
	
	function process(value,tagId){
		showTipsWindown(value,tagId);
	}
};