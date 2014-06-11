window.onload = function (){
	var menuClosed = Ops.getCookie('menuClosed');
	var menuArray = ["user_menu_my","user_menu_manger","user_menu_box","user_menu_kdy","user_menu_kdgs","user_menu_log","user_menu_order","user_menu_link"];
	var currMenu = $("#currMenu").val();
	//alert(currMenu);
	menuArray.splice(jQuery.inArray(currMenu,menuArray),1);
	
	$(".item h3 span").click(function () {
		menuClosed = Ops.getCookie('menuClosed');
		if (menuClosed == undefined || menuClosed == null) {
			menuClosed = '';
			Ops.setCookie('menuClosed', menuClosed);
		}
		var parentId = $(this).parent().parent().attr("id");
		//alert(parentId);
		$(this).parent().parent().toggleClass('bg-slide');
		$(this).parent().parent().find(".sub").slideToggle('fast');
		if ($(this).attr('title') == '折叠') {
			$(this).attr('title', '展开');
		} else {
			$(this).attr('title', '折叠');
		}
		var pid = $(this).parent().parent().attr('id');

		if ($(this).parent().parent().hasClass('bg-slide') && menuClosed.indexOf("#" + pid + "#") == -1) {
			var cookies = menuClosed + '#' + pid + '#';
		} else {
			var cookies = menuClosed.replace("#" + pid + "#", '');
		}
		Ops.setCookie('menuClosed', cookies);
	});

	if (menuClosed != null) {
		var closedMatch = menuClosed.match(/([a-z_]+)/g);
		for (var i in closedMatch) {
			var idObj = $('#' + closedMatch[i]);
			idObj.toggleClass('bg-slide');
			idObj.find(".sub").hide();
			idObj.find('h3 span').attr('title', '展开');
		}
	} else {
		for(var i=0;i<menuArray.length;i++){
		　　var m = menuArray[i];
			var mId = '#'+m+' h3 span';
			$(mId).click();
		}
	}
 
	var $div_li = $(".ucenter-tab-box ul li");
	$div_li.click(function () {
		$(this).addClass("current").siblings().removeClass("current");
		var div_index = $div_li.index(this);
		$("#tab_box>div").eq(div_index).show().siblings().hide();
	}).hover(function () {
		$(this).addClass("hover");
	}, function () {
		$(this).removeClass("hover");
	});
	
	var $div_li_x = $(".u-tab-wrap ul li");
	$div_li_x.click(function () {
		$(this).addClass("current").siblings().removeClass("current");
		var div_index = $div_li_x.index(this);
		$("#tab-box>div").eq(div_index).show().siblings().hide();
	}).hover(function () {
		$(this).addClass("hover");
	}, function () {
		$(this).removeClass("hover");
	});
}