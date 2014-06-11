$(function () {
    var $menu = $(".menu"), $menuLi = $menu.find("li"), $current = $menu.find('.current'), $li_3 = $menu.find('li.li_3'), $li_3_content = $li_3.find('.li_3_content'),$li_2 = $menu.find('li.li_2'), $li_2_content = $li_2.find('.li_2_content');
    $menuLi.hover(function () {
        var $this = $(this), num = $menuLi.index($this), current = $menuLi.index($(".first")), len = current - num;
        $menu.css("background-position", (101 * current) + "px" + " bottom");
        $menuLi.removeClass("current");
        $this.addClass("current");
    });
    $li_3.hover(function () {
        $li_3_content.stop(true, true).fadeIn(0);
    }, function () {
        $li_3_content.fadeOut(500, function () {
            $li_3_content.css("display", "none");
        });
    });
	
	
	$li_2.hover(function () {
        $li_2_content.stop(true, true).fadeIn(0);
    }, function () {
        $li_2_content.fadeOut(500, function () {
            $li_2_content.css("display", "none");
        });
    });
	
    $menu.mouseleave(function () {
        var $this = $(this), num = $menuLi.index($this), current = $menuLi.index($current), len = current - num;
        $menuLi.removeClass("current");
		//$current.removeClass("current");
        $current.addClass("current");
    });
    $("a.noclick").click(function (event) {
        event.preventDefault();
    });
});