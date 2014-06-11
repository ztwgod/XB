jQuery(document).ready(function() {
	jQuery("#pager").pager( {
		pagenumber : x_G("pageNumber").value,
		pagecount : x_G("pagecount").value,
		buttonClickCallback : PageClick
	});
});

PageClick = function(pageclickednumber) {
	jQuery("#pager").pager( {
		pagenumber : pageclickednumber,
		pagecount : x_G("pagecount").value,
		buttonClickCallback : PageClick
	});
	getPage(pageclickednumber);
}

function getPage(pageNumber) {
	x_G("pageNumber").value = pageNumber;
	x_G("frm").submit();
}

function search() {
	x_G("pageNumber").value = 1;
	x_G("frm").submit();
}

function toAddBox() {
	var root = parent.document.getElementById("_root").value;
	document.location.href = root + "/plat/toAddBox.do";
}

function deleteBox(obj) {
	var r = confirm("确定删除该物箱？");
	if (r) {
		var root = parent.document.getElementById("_root").value;
		document.location.href = root + "/plat/doDeleteBox.do?ssId=" + obj;
	}
}
