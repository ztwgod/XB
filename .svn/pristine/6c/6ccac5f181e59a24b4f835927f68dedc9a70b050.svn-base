<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <title>讯宝XB-门户子系统</title>
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/portal/login.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
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
	
    <div style="margin-left:auto; margin-right:auto; text-align:center;width:1000px;">
    	<div style="float:left;margin-top:20px; width:680px; height:400px;border:1px solid #CCC;">
    		<img  src="<%=path%>/images/portal/loginLogo.jpg" />
   		</div>
        
   		<div style="float:left;height:400px; margin-top:20px;width:260px; margin-left:20px;border:1px solid #CCC;">
   		<form action="<%=path%>/portal/doLogin.do" method="post" id="frm" name="frm">
            <table  style="margin-left:30px;">            	
                <tr>
                    <td colspan="2" align="center"><font style="font-weight:bold; font-size:15px;">用户登陆</font></td>
                </tr>
                <tr>
            		<td colspan="2">
            			<input type="hidden" id="msg" name="msg" value="${message}" />
            		</td>
            	</tr>
                <tr>
                    <td>用户名：</td>
                    <td align="left"><input type="text" id="userAccount" name="userAccount" value="${user.userAccount }" /></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td  align="left"><input type="password" id="password" name="password"/></td>
                </tr>
                <tr>
                    <td>验证码：</td>
                    <td  align="left"><input type="text" style="width: 35px;" maxlength="4" id="yzm" name="yzm" />
                    	<span><img  name="img" id="img" border="0" alt="校验码" src="<%=path%>/portal/image.jsp"/></span>
                    	<span class="thc" style="font-size: 12px;text-decoration: none;cursor: pointer;color: blue;" onclick="changeImage();" title="点击获取校验码">看不清楚?</span>
                    </td>
                </tr>
                 <tr>
                    <td colspan="2" align="right" ><input style="height:30px; width:60px;" onclick="doLogin();" type="button" id="loginBut" name="loginBut" value="登陆" /> </td>
                </tr>
            </table>
           </form>
             <!--  <div style="font-size:12px; color:#00F; text-align:right; margin-top:20px;"><a href="#" >忘记密码了？</a></div> -->
        </div>
   </div>
</body>
<script>
var msg = jQuery("#msg").val();
if(null!=msg && ""!=msg){
	show_err_msg(msg);
}
</script>

</html>