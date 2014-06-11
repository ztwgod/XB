var timer;
function setTimer() {
	timer = setInterval("getResponseResult()", 1000 * 1);
}

function clearTimer() {
	clearInterval(timer);
	
}

// 获取请求结果
function getResponseResult() {
	var tranNO = x_G("_tranNO").value;
	var root = document.getElementById("_root").value;
	var transType = x_G("_transType").value;

	var url = root + "/plat/getGUIResponseText.do?tranNO=" + tranNO+ "&transType=" + transType;

	jQuery.ajax( {
		type : "POST",
		cache : false,
		url : url,
		dataType : 'html',
		success : function(data, textStatus) {
			if (data == '1') {
				// 请求已经发送给物箱，但是还没收到物箱的反馈。
			} else {
				clearTimer();
				if(''!=tranNO){ //获取返回结果，3秒后关闭窗口
					jQuery("#_message").html(data);
					setTimeout("closeEigsx(1)", 1000 * 3);
				}else{
					closeEigsx(); //关闭窗口
				}
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
				clearTimer();
				jQuery("#_message").attr("style","color:#e9373b");
				jQuery("#_message").html("请求出错!" + errorThrown);				
				setTimeout("closeEigsx()", 1000 * 5);
			}
	});
}