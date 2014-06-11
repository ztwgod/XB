<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>讯宝-日志详情</title>
	<link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
			
	<script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
	<script src="<%=path%>/js/plat/tipswindown.js" type="text/javascript"></script>
	<script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
	<script src="<%=path%>/js/x_tools.js" type="text/javascript"></script> 
	<script src="<%=path%>/js/plat/listEgisx.js" type="text/javascript"></script>
	</head>
	<body>
		<form action="<%=path%>/plat/listEgis.do" id="frm" name="frm">
    		
    		<fieldset>
    			<legend>日志内容</legend>
				<table class="tabSearch" height="130">
					<tr>
						<td align="right"><textarea style="width: 100%; height: 100%;" disabled="disabled">${olw.operationContent }</textarea></td>
					</tr>
				</table>
			</fieldset>
			
    		<fieldset>
    			<legend>日志返回结果</legend>
				<table class="tabSearch" height="130">
					<tr>
						<td align="right"><textarea style="width: 100%; height: 100%;" disabled="disabled">${olw.operationResult }</textarea></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</body>
</html>
