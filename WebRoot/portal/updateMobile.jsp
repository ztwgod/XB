<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <title>XB讯宝</title>
    <style type="text/css">
    td{
		height:40px;
		font-size:14px;
	}
	input{
		height:25px;
	}
    </style>
</head>
<body>
    <!-- 导航代码开始 -->
    <jsp:include page="nav.jsp"></jsp:include>
	<!--代码结束 -->
	
    <div style="margin:0 auto;width: 1000px; font-size:12px; cursor:pointer; margin-top:5px;">
    	
    </div>
 
        
	<div style="height:300px;width:980px; margin-left:20px;border:1px solid #CCC; text-align:center; margin:0 auto;margin-top:30px;padding-top:50px;">
	  <table style="margin-left:360px;">
		<tr>
			<td>新手机号：</td>
			<td  align="left"><input type="text" id="newMobile" name="newMobile" /> </td>
			<td>&nbsp;</td>
		</tr>
		 <tr>
			<td colspan="2" align="right" ><input style="height:30px; width:120px;" type="button" id="CodeBut" name="CodeBut" value="免费获取验证码" /> </td>
			<td>&nbsp;</td>
		</tr>
		 <tr>
			<td>验证码：</td>
			<td align="left"><input type="text" id="Code" name="Code" /> </td>
			<td style="font-size:12px;"><font color="#FF0000">*</font>请查收短信，并填写短信中的验证码</td>
		</tr>
		   <tr>
			<td colspan="2" align="right" ><input style="height:30px; width:60px;" type="button" id="loginBut" name="loginBut" value="修改" /> </td>
			<td>&nbsp;</td>
		</tr>
	</table>
	</div>  
   
</body>
</html>