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
   
   <div style="height:400px;width:980px; margin-left:20px;border:1px solid #CCC; text-align:center; margin:0 auto;margin-top:30px;padding-top:50px;">
           <table style="margin-left:360px;">
            <tr>
            	<td align="right">用户名：</td>
                <td align="left">${user.userAccount} </td>
                <td align="right" style="padding-left: 40px;">真实姓名：</td>
                <td align="left">${user.userName}</td>
            </tr>
          
             <tr>
            	<td align="right">手机号：</td>
                <td align="left">${user.mobileNumber} </td>
                <td align="right">Email：</td>
                <td align="left">${user.email}</td>
            </tr>
        
             <tr>
            	<td align="right">证件类型：</td>
                <td align="left">
                	<c:if test="${user.paperworkType==1}">身份证</c:if>
                	<c:if test="${user.paperworkType==2}">军官证</c:if>
                	<c:if test="${user.paperworkType==3}">驾驶证</c:if>
                </td>
                <td align="right">证件号：</td>
                <td align="left">${user.paperworkNum}</td>
         
            </tr>
            
           <tr>
             	<td align="right">性别：</td>
                <td align="left">
                	<c:if test="${user.gender==1}">男</c:if>
                	<c:if test="${user.gender==2}">女</c:if>
                </td>
            	<td align="right">QQ：</td>
                <td align="left">${user.qq}</td>
            </tr>
          
            
            <tr>
            	<td align="right">微信：</td>
                <td align="left">${user.weixin}</td>
            	<td align="right">微博：</td>
                <td align="left">${user.wb}</td>
            </tr>
            
           
            <tr>
            	<td align="right">常住地址：</td>
                <td align="left">${user.householdRegisterAddress}</td>
                <td align="right">常住邮编：</td>
                <td align="left">${user.zipCode}</td>
            </tr>
            
            <tr>
            	<td align="right">户籍地址：</td>
                <td align="left" colspan="3">${user.habitualResidence}</td>
            </tr>
            
        </table>
    </div>
</body>
</html>