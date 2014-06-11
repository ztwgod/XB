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
  	<script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
  	<script src="<%=path%>/js/portal/updateUserInfo.js" type="text/javascript"></script>
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
	
    <div style="margin:0 auto;width: 1000px; font-size:12px; cursor:pointer; margin-top:5px;">
    	
    </div>
    
	 <div style="text-align:center;auto;padding-left:350px;margin:0 auto; margin-top:30px;">
    	<form action="<%=path%>/portal/doUdpateUserInfo.do" id="frm" name="frm">
    	<input type="hidden" id="userId" name="userId"  value="${user.userId}" />
    	<table>
    		<tr>
    			<td align="center" colspan="6">
    				<input type="hidden" id="message" name="message" value="${successMsg}" />
    			</td>
    		</tr>
    		<!--
    		 <tr>
            	<td>定制物箱别名：</td>
                <td align="left" colspan="5">
                    <input type="text"  id="detail" name="detail"/>
                </td>
            </tr>
    			
    		<tr>
            	<td>定制物箱：</td>
                <td align="left" colspan="4">
                	国家<select id="address" name="address">
                    	<option value="">请选择</option>
                    </select>
                    
                   	 省<select id="address" name="address">
                    	<option value="">请选择</option>
                    </select>
                    
                    	市<select id="address" name="address">
                    	<option value="">请选择</option>
                    </select>
                    
                    	地点<select id="address" name="address">
                    	<option value="">请选择</option>
                    </select>
                    
                    	物箱组<select id="address" name="address">
                    	<option value="">请选择</option>
                    </select>                    
                    	物箱<select id="address" name="address">
                    	<option value="">请选择</option>
                    </select>
                </td>
            </tr>    
    	  -->
    	  <tr>
            	<td>用户名：</td>
                <td align="left" colspan="2">
                	${user.userAccount}
                </td>
                <td style="padding-left: 30px;"><font color="#FF0000">*</font>性别：</td>
                <td align="left" colspan="2">
                    <input style="width: 20px;" type="radio" id="gender" name="gender" value="1" <c:if test="${user.gender==1}">checked="checked"</c:if> />男
                    <input style="width: 20px;" type="radio" id="gender" name="gender" value="2" <c:if test="${user.gender==2}">checked="checked"</c:if> />女     
                </td>
            </tr>
            
            <tr>
            	<td><font style="color: red;">*</font>姓名：</td>
                <td align="left" colspan="2">
                	<input type="text"  id="userName" name="userName" maxlength="10" value="${user.userName }"/>
                </td>
                <td style="padding-left: 30px;"><font color="#FF0000">*</font>手机号：</td>
                <td align="left" colspan="2">
                   <input type="text"  id="mobile" name="mobile" value="${user.mobileNumber }" maxlength="11" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" />
                </td>
            </tr>
    	  	
        	<tr>
            	<td><font style="color: red;">*</font>证件类型：</td>
                <td align="left" colspan="2">
                	<select style="height: 30px;" id="idType" name="idType">
                   		<option value="">请选择</option>
                   		<c:forEach items="${idList}" var="id">
                   			<option value="${id.code}" <c:if test="${user.paperworkType==id.code}">selected="selected"</c:if>>${id.name}</option>
                   		</c:forEach>
                    </select>
                </td>
                <td style="padding-left: 30px;"><font style="color: red;">*</font>证件号：</td>
                <td align="left" colspan="2">
                    <input type="text"  id="idNo" maxlength="50" onkeyup="x_NaNAndLetter(this)" onblur="x_NaNAndLetter(this)" name="idNo" value="${user.paperworkNum }"/>
                </td>
            </tr>
          
          	<tr>
            	<td>QQ：</td>
                <td align="left" colspan="2">                	
                    <input type="text"  id="QQ" name="QQ" value="${user.qq }"/>
                </td>
                <td style="padding-left: 30px;">微信：</td>
                <td align="left"><input type="text" id="weixin" maxlength="40" name="weixin" value="${user.weixin}" /></td>
                <td>&nbsp;</td>
            </tr>
             
            <tr>
            	<td>微博：</td>
                <td align="left" colspan="2">                	
                    <input type="text"  id="wb" name="wb" maxlength="200" value="${user.wb}"/>
                </td>
               <td style="padding-left: 30px;">Email：</td>
                <td align="left"><input type="text" maxlength="100" id="email" name="email" value="${user.email}" /></td>
                <td>&nbsp;</td>
            </tr>     
            
             <tr>
            	<td><font style="color: red;">*</font>常住地址：</td>
                <td align="left" colspan="2">                	
                    <input type="text"  id="usualAddress" name="usualAddress" maxlength="200" value="${user.habitualResidence}" style="width: 300px;"/>
                </td>
                <td style="padding-left: 30px;">常住邮编：</td>
                <td align="left"><input type="text" id="zipCode" name="zipCode" maxlength="6" value="${user.zipCode}" /></td>
                <td>&nbsp;</td>
            </tr>  
            <tr>
            	<td><font style="color: red;">*</font>户籍地址：</td>
                <td align="left" colspan="2">                	
                    <input type="text"  id="registerAddress" name="registerAddress" maxlength="200" value="${user.householdRegisterAddress}" style="width: 300px;"/>
                </td>
                <td></td>
                <td align="left"></td>
                <td>&nbsp;</td>
            </tr>          
             <tr>
            	<td colspan="5" align="right" >
                	<input style="height:30px; width:60px;" type="button" id="loginBut" name="loginBut" onclick="checkAndSubmit();" value="修改" />
                 </td>
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