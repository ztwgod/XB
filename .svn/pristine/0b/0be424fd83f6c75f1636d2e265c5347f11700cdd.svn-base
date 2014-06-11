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
  	<script src="<%=path%>/js/portal/register2.js" type="text/javascript"></script>
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
	 
    	<form action="<%=path%>/portal/doRegister2.do" id="frm" name="frm">
    	<input type="hidden" id="userId" name="userId"  value="${userId}" />
    	<table>
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
            	<td><font style="color: red;">*</font>证件类型：</td>
                <td align="left" colspan="2">
                	<select style="height: 23px;" id="idType" name="idType">
                   		<option value="" selected="selected">请选择</option>
                   		<c:forEach items="${idList}" var="id">
                   			<option value="${id.code}">${id.name}</option>
                   		</c:forEach>
                    </select>
                </td>
                <td style="padding-left: 30px;"><font style="color: red;">*</font>证件号：</td>
                <td align="left" colspan="2">
                    <input type="text"  id="idNo" name="idNo" maxlength="50" onkeyup="x_NaNAndLetter(this)" onblur="x_NaNAndLetter(this)" />
                </td>
            </tr>
          
          	<tr>
            	<td>QQ：</td>
                <td align="left" colspan="2">                	
                    <input type="text" maxlength="15"  id="QQ" name="QQ"/>
                </td>
                <td style="padding-left: 30px;">微信：</td>
                <td align="left"><input type="text" maxlength="40" id="weixin" name="weixin" /></td>
                <td>&nbsp;</td>
            </tr>
             
            <tr>
            	<td>微博：</td>
                <td align="left" colspan="2">                	
                    <input type="text"  id="wb"  maxlength="200" name="wb"/>
                </td>
               <td style="padding-left: 30px;">Email：</td>
                <td align="left"><input maxlength="100" type="text" id="email" name="email" /></td>
                <td>&nbsp;</td>
            </tr>           
            
             <tr>
            	<td><font style="color: red;">*</font>常住地址：</td>
                <td align="left" colspan="2">                	
                    <input type="text"  id="usualAddress" maxlength="200" name="usualAddress" style="width: 300px;"/>
                </td>
                <td style="padding-left: 30px;">常住邮编：</td>
                <td align="left"><input type="text" id="zipCode"  name="zipCode" maxlength="6" /></td>
                <td>&nbsp;</td>
            </tr>  
            <tr>
            	<td><font style="color: red;">*</font>户籍地址：</td>
                <td align="left" colspan="2">                	
                    <input type="text"  id="registerAddress" maxlength="200" name="registerAddress" style="width: 300px;"/>
                </td>
                <td></td>
                <td align="left"></td>
                <td>&nbsp;</td>
            </tr>           
          
             <tr>
            	<td colspan="5" align="right" >
                	<!-- <input style="height:30px; width:60px;" type="button" id="loginBut" name="loginBut" onclick="Skip();" value="跳过" />  -->
                	<input style="height:30px;width:60px;" type="button" id="loginBut" name="loginBut" onclick="checekAndSubmit();" value="下一步" />
                 </td>
            </tr>            
        </table>
       </form>
   </div>
</body>
</html>