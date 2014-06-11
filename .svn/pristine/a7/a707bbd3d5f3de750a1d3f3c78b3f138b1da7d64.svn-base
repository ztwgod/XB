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
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/portal/updatePassword.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
</head>
<body>
    <!-- 导航代码开始 -->
   <jsp:include page="nav.jsp"></jsp:include>
	<!--代码结束 -->
	
    <div style="margin:0 auto;width: 1000px; font-size:12px; cursor:pointer; margin-top:5px;">
    	
    </div>
   
     <div style="height:400px;width:980px; margin-left:20px;border:1px solid #CCC; text-align:center; margin:0 auto;margin-top:30px;padding-top:50px;">
     <form action="<%=path%>/portal/doUpdatePassword.do" id="frm" name="frm">
     	<input type="hidden" id="userId" name="userId" value="${user.userId}" />
          <table style="margin-left:360px;">
          	<tr>
          		<td colspan="3">
          			<input type="hidden" id="message" name="message" value="${successMsg}" />
          		</td>
          	</tr>
            <tr>
                <td>用户名：</td>
                <td align="left">${user.userAccount}</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>旧密码：</td>
                <td  align="left">
                	<input type="password" id="oldPassword" maxlength="30" name="oldPassword" onblur="checkOldPassword();" />
                </td>
                <td><font id="msg" style="color: orange;"></font></td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td  align="left"><input type="password" maxlength="30" id="newPassword" name="newPassword" /> </td>
                <td>&nbsp;</td>
            </tr>
             <tr>
                <td>确认密码：</td>
                <td  align="left"><input type="password" maxlength="30" id="newPassword2" name="newPassword2" /> </td>
                <td>&nbsp;</td>
            </tr>
             <tr>
                <td colspan="2" align="right" ><input style="height:30px;width:60px;" onclick="checkAndSubmit();" type="button" id="loginBut" name="loginBut" value="修改" /> </td>
                <td>&nbsp;</td>
            </tr>
        </table>
       </form>
    </div>
</body>
<script>
var message = document.getElementById("message").value;
if(null!=message && ""!=message){
	show_msg(message);
}
</script>
</html>