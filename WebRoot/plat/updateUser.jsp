<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-修改用户信息</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>    
    <script src="<%=path%>/js/plat/updateUser.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab">
                        <li class="current"><a>修改用户信息</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>                
                <div id="tab-box">
                <div class="u-form-wrap">    
                
                <div class="demo" style="width: 450px;">
						<ul class="clearfix">
							<li style="width: 150px;">用户管理<em></em><i></i></li>
							<li style="width: 150px;">用户信息<em></em><i></i></li>
							<li style="width: 150px;" class="current">修改用户信息<em></em><i></i></li>
						</ul>
					</div>
					
					<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、所有带<font style="color: red;">&nbsp;*&nbsp;</font>的为必录项。<br />
         						2、该页面所添加的用户为管理员用户，只能用于登陆平台子系统，不能用于门户系统的登陆。<br />
         						3、用户密码的长度不能少于5位。<br />
         						4、可以给一个用户分配多个角色。<br />
         					</div>
         		 	</fieldset>
                
              	<form action="<%=path%>/plat/doUpdateUser.do" id="frm" name="frm" method="post">
              	
              	<fieldset>
              		<legend>基本信息</legend>
				<table cellpadding="2" cellspacing="1" class="newTab">
					
					  <tr>
                        <td align="right" width="200px;"><font style="color: red;">*&nbsp;</font>用户名：</td>
					    <td width="200px;">
                        	${user.userAccount}
                        	<input type="hidden" id="userId" name="userId" value="${user.userId}" />
                        	<font style="font-size: 12px;color: red;" id="msg"></font>
                        </td>
                        
                        <td width="200px;" align="right"><font style="color: red;">*&nbsp;</font>姓名：</td>
					    <td width="200px;">
                        	<input type="text" maxlength="10" id="chName" name="chName" value="${user.userName}" />
                        </td>
					  </tr>					  
					   <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>性别：</td>
					    <td>
					    	
					    	<input style="width: 20px;" type="radio" id="gender" name="gender" <c:if test="${user.gender==1}"> checked="checked"  </c:if> value="1" />男
                            <input style="width: 20px;" type="radio" id="gender" name="gender" <c:if test="${user.gender==2}"> checked="checked"  </c:if> value="2" />女                           
                        </td>
                        
                         <td align="right"><font style="color: red;">*&nbsp;</font>手机：</td>
					    <td>
                        	<input type="text" maxlength="11" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" id="mobile" name="mobile" value="${user.mobileNumber }" />
                        </td>
                        
                                          
					  </tr>
					
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>证件类型：</td>
					    <td>
                        	<select id="idType" name="idType">
                        		<option value="" >请选择</option>
                        		<c:forEach items="${idList}" var="id">
                        			<option value="${id.code}" <c:if test="${user.paperworkType==id.code}"> selected="selected" </c:if> >${id.name}</option>
                        		</c:forEach>
                        	</select>
                        </td>
                         <td align="right"><font style="color: red;">*&nbsp;</font>证件号码：</td>
					    <td>
                        	<input type="text" id="idNo" maxlength="50" onkeyup="x_NaNAndLetter(this)" onblur="x_NaNAndLetter(this)" name="idNo" value="${user.paperworkNum}" />
                        </td>
					  </tr>
					         
				</table> 
				</fieldset>
				<fieldset>
					<legend>详细信息</legend>
					<table cellpadding="2" cellspacing="1" class="newTab">
						 <tr>
					  	 <td width="200px;" align="right"><font style="color: red;">*&nbsp;</font>常住地址：</td>
					    <td width="200px;">
                            <input type="text" style="width: 260px;" maxlength="300" id="usualAddress" name="usualAddress" value="${user.habitualResidence }" />
                        </td>
                        <td width="200px;" align="right"><font style="color: red;">*&nbsp;</font>常住邮编：</td>
					    <td width="200px;">
                        	<input type="text" maxlength="6" id="zipCode" name="zipCode" value="${user.zipCode }" />
                        </td>  
					  </tr>	
					  
					   <tr>
					   	<td align="right"><font style="color: red;">*&nbsp;</font>户籍地址：</td>
					    <td>
                            <input type="text" style="width: 260px;" maxlength="300" id="registerAddress" name="registerAddress" value="${user.householdRegisterAddress }" />
                        </td> 
                        <td align="right"><font style="color: red;">*&nbsp;</font>状态：</td>
					    <td>
                        	<select id="status" name="status">
                        		<option value="" selected="selected">请选择</option>
                        		<c:forEach items="${statusList}" var="id">
                        			<option value="${id.code}" <c:if test="${user.status==id.code}"> selected="selected" </c:if> >${id.name}</option>
                        		</c:forEach>
                        	</select>
                        </td>
					  </tr>
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>角色分配：</td>
					    <td colspan="3">			    	
                           <c:forEach items="${roles}" var="r">
                           		<input type="checkbox" style="width: 20px;" id="role" name="role" value="${r.roleId}" />${r.roleName}
                           </c:forEach>
                           <c:forEach items="${userRoles}" var="m">
                           		<input type="hidden" name="userRoles" value="${m.roleId}" />
                           </c:forEach>                           
                        </td>    
					  </tr>
					  <tr>
                       	 <td align="right"><font style="color: red;">*&nbsp;</font>用户类型：</td>
					    <td colspan="3">
                        	<c:if test="${user.userType==1}">普通注册用户</c:if>
                            <c:if test="${user.userType==3}">系统维护管理人员</c:if>
                        </td> 
					  </tr>					
					</table>
				</fieldset>
				
				<fieldset>
					<legend>选录信息</legend>
					<table cellpadding="2" cellspacing="1" class="newTab">
						
						<tr>
                        
                         <td width="200px;" align="right">Email：</td>
					    <td width="200px;">
                        	<input type="text" id="email" maxlength="100" name="email" value="${user.email }" />
                        </td>
                        
                        <td width="200px;" align="right">QQ：</td>
					    <td width="200px;">
                        	<input type="text" id="QQ" name="QQ" maxlength="15" value="${user.qq }" />
                        </td>
					  </tr>
					  
					   <tr>
                        <td align="right">微博：</td>
					    <td>
                        	<input type="text" maxlength="200" id="weibo" name="weibo" value="${user.wb }" />
                        </td>
                         <td align="right">微信：</td>
					    <td>
                        	<input type="text" maxlength="40" id="weixin" name="weixin" value="${user.weixin }" />
                        </td>
					  </tr>
					
                      <tr>
					    <td colspan="4" style="text-align: center;">
					    	<button type="button" id="do_search" class="search" onclick="tolistUser();">返回</button>&nbsp;&nbsp;
                        	<button type="button" id="do_search" class="search" onclick="checkAndSubmit();" >修改</button>
                        </td>
					  </tr>  
					
					</table>
				</fieldset>
					</form>             
                    </div>
                </div>
            </div>
           
        </div>
        <!-- /.u-main -->
    </div>
    <!-- /.row -->
</body>
<script type="text/javascript">
x_checkCheckBox("userRoles","role");
</script>
</html>