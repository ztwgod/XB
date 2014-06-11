<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>讯宝-维护员列表</title>
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
			<input type="hidden" value="${page.pageCount}" id="pagecount" name="pagecount" />
    		<input type="hidden" value="${page.pageNumber}" id="pageNumber" name="pageNumber" />
    		
    		<fieldset>
    			<legend>维护员查询</legend>
				<table class="tabSearch">
					<tr>
						<td align="right">账号：</td>
						<td><input type="text" id="userAccount" onkeyup="x_NaNAndLetter(this)" onblur="x_NaNAndLetter(this)" name="userAccount" style="height:30px;" value="${user.userAccount}"></td>
						<td align="right">姓名：</td>
						<td><input type="text" id="userName" name="userName" style="height:30px;" value="${user.userName}"></td>
						<td>
							<button class="search" id="sBut" name="sBut" onclick="search();">查询</button>
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
				
		<table class="u-table">
			<tr>
				<th>选择</th>
				<th>账号</th>
				<th>姓名</th>
				<th>手机</th>
			</tr>				
			<c:forEach items="${listSys}" var="s">		
			<tr style="font-size: 13px;">
				<td><input type="radio" name="egisId" <c:if test="${s.check eq 1}">checked="checked"</c:if> id="${s.userName}" value="${s.userId}"></td>
				<td>${s.userAccount}</td>
				<td>${s.userName}</td>
				<td>${s.mobileNumber}</td>
			</tr>
			</c:forEach>
		</table>
		<div id="pager" ></div>
	</body>
</html>
