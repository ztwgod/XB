<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>讯宝-开箱</title>
	<script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
	<script src="<%=path%>/js/plat/tipswindown.js" type="text/javascript"></script>
	<script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
	<script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
	<script src="<%=path%>/js/plat/box_timer.js" type="text/javascript"></script>
	</head>
	<body>
		<div style="text-align: center;padding-top: 20px;font-weight: bold;">
			<input type="hidden" id="_root" name="_root" value="<%=path%>" />
			<input type="hidden" id="boxId" name="boxId" value="${boxId}" />
			<input type="hidden" id="ssId" name="ssId" value="${ssId}" />
			<table align="center">
				<tr>
					<td>用户手机号：</td>
					<td><input type="text" id="mobile" name="mobile" value="${mobile}" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" maxlength="12" /></td>
				</tr>
				<tr>
					<td>随机码：</td>
					<td><input type="text" id="randCode" name="randCode" value="${randCode}" onkeyup="x_NaNAndLetter(this);" onblur="x_NaNAndLetter(this)" maxlength="10" /></td>
				</tr>
			</table>
		</div>
	</body>
</html>