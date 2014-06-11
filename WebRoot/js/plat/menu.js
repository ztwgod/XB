/*jQuery(document).ready(function(){
	var flag = false;
	jQuery(".sub").click(function(){		
		//点击子菜单
		flag = true;
		//var parentId = jQuery(this).closest("ul").attr("id");
		
		if($("#"+parentId).is(":hidden")){ 
			jQuery("#"+parentId).slideToggle();
		}		
		//jQuery(this).find("a").css("color","#65AF00");
		//jQuery(this).find("a").css("font-weight","bold");
		//jQuery(this).attr("style","BACKGROUND-COLOR:#97D319");
	});
	
	jQuery(".item").click(function(){
		jQuery(this).toggleClass('bg-slide'); //控制背面样式
		var isVisble = jQuery(this).find("ul").is(":visible");//是否可见
		if(!isVisble){
			jQuery(this).find("ul").slideToggle();
		}else{
			if(!flag){
				jQuery(this).find("ul").slideToggle();
				//flag = true;
			}
		}
	});	
	
	flag = false;
	//var cook = jQuery.cookie("showMenu");
	//var parentId = jQuery(this).closest("ul").attr("id");
	//jQuery("#"+parentId).slideToggle();
	//var root = document.getElementById("_root").value;
	//jQuery(this).css("background","url("+root+"/images/plat/currr.jpg)");
	//jQuery(this).find("a").css("color","#65AF00");
	//jQuery(this).find("a").css("font-weight","bold");
	
	//jQuery("#"+cook).attr("style","BACKGROUND-COLOR:#97D319");
});
*/

function itemMenu(obj){
	jQuery(obj).toggleClass('bg-slide'); //控制背面样式
	var isVisble = jQuery(this).parent().find("ul").is(":visible");//是否可见
	if(!isVisble){
		jQuery(obj).parent().find("ul").slideToggle();
	}
}

/*function menuHref(url){
	jQuery("#iFrame").attr("src",url);
}*/
