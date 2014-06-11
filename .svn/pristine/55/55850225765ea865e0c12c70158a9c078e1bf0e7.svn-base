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
    <script src="<%=path%>/js/portal/register.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
</head>
<body>
    <!-- 导航代码开始 -->
    <jsp:include page="nav.jsp"></jsp:include>
	<!--代码结束 -->
	
    <div style="margin:0 auto;width: 1000px; font-size:12px; cursor:pointer; margin-top:5px;">
    	
    </div>
    
	 <div style="text-align:center;width:600px;padding-left:350px;margin:0 auto; margin-top:30px;">
	 <form action="<%=path%>/portal/doRegister.do" id="frm" name="frm">
    	<table>
            <tr>
            	<td align="right"><font color="#FF0000">*</font>用户名：</td>
                <td align="left">
                	<input type="text" id="userAccount" onkeyup="x_NaNAndLetter(this)" maxlength="18" name="userAccount" onblur="x_NaNAndLetter(this);verifyUserAccount();" />
                 </td>
                <td><font style="font-size: 12px;" color="#FF0000" id="msg"></font></td>
            </tr>
            
            <tr>
            	<td align="right"><font color="#FF0000">*</font>密码：</td>
                <td  align="left"><input type="password" id="password" name="password" /> </td>
                <td>&nbsp;</td>
            </tr>
            
             <tr>
            	<td align="right"><font color="#FF0000">*</font>确认密码：</td>
                <td  align="left"><input type="password" id="password2" name="password2" /> </td>
                <td>&nbsp;</td>
            </tr>
            
             <tr>
            	<td align="right"><font color="#FF0000">*</font>性别：</td>
                <td align="left">
					<input style="width: 20px;" type="radio" id="gender" name="gender" value="1" />男
                    <input style="width: 20px;" type="radio" id="gender" name="gender" value="2" />女             
				</td>
                <td>&nbsp;</td>
            </tr>
            
              <tr>
            	<td align="right"><font color="#FF0000">*</font>姓名：</td>
                <td align="left"><input type="text" id="realName" maxlength="10" name="realName" /> </td>
                <td>&nbsp;</td>
            </tr>
          
             <tr>
            	<td align="right"><font color="#FF0000">*</font>手机号：</td>
                <td align="left"><input type="text" maxlength="11" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" id="mobile" name="mobile" /> </td>
                <td>&nbsp;</td>
            </tr>
            
             <!-- 
              <tr>
            	<td colspan="2" align="right" ><input style="height:30px; width:120px;" type="button" id="CodeBut" name="CodeBut" value="免费获取验证码" /> </td>
                <td>&nbsp;</td>
            </tr>
            
             <tr>
            	<td align="right"><font color="#FF0000">*</font>验证码：</td>
                <td align="left"><input type="text" id="Code" name="Code" /> </td>
                <td style="font-size:12px;"><font color="#FF0000">*</font>请查收短信，并填写短信中的验证码</td>
            </tr>
             -->
             <tr>
            	<td colspan="3" align="right" >
            		<input style="height:30px; width:60px;" onclick="checekAndSubmit();" type="button" id="loginBut" name="loginBut" value="下一步" /> 
            	</td>
            </tr>
        </table>
       </form>
   </div>
	
	
</body>
</html>