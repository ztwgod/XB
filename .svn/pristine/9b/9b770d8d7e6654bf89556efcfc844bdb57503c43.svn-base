<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>讯宝-查看物箱状态</title>
	<link href="<%=path%>/css/plat/gui.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/plat/tipswindown.css" rel="stylesheet" type="text/css" />
	
	<script src="<%=path%>/js/plat/tipswindown.js" type="text/javascript"></script>
	<script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
	<script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
	<script type="text/javascript">
	var timer;
	function setTimer() {
		timer = setInterval("getResponseResult()", 1000 * 3);
	}

	function clearTimer() {
		clearInterval(timer);		
	}
	// 获取请求结果
	function getResponseResult() {
		var tranNO = x_G("_tranNO").value;
		var root = x_G("_root").value;
		var transType = x_G("_transType").value;
		var ssId = x_G("_ssId").value;
		
		var url = root + "/plat/getGUIResponseText.do?tranNO="+tranNO+"&transType="+transType+"&ssId="+ssId;
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
					if(''!=tranNO){
						jQuery('#divMsg').remove();
						jQuery("#_message").html(data);
					}else{
						closeEigsx();
					}
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
					clearTimer();
					jQuery("#_message").attr("style","color:#e9373b");
					jQuery("#_message").html("请求出错!" + errorThrown);				
					setTimeout("closeEigsx()", 1000 * 3);
				}
		});
	}	
	</script>
	</head>
	<body>
		<div style="text-align: center;padding-top: 20px;font-weight: bold;" id="divMsg">
			<font style="font-size:14px;color:#0087BD;" id="_message">${message}</font>
			<input type="hidden" id="_tranNO" name="_tranNO" value="${tranNO}" />
			<input type="hidden" id="_ssId" name="_ssId" value="${ssId}" />
			<input type="hidden" id="_transType" name="_transType" value="${transType}" />
			<input type="hidden" id="_root" name="_root" value="<%=path%>" />
		</div>
		<div id="_message">
			
		</div>
	</body>
	<script type="text/javascript">
		setTimer();
	</script>
</html>
