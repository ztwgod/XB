<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-添加用户</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>    
    <script src="<%=path%>/js/plat/addUser.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab">
                        <li onclick="tolistUser();"><a>用户列表</a></li>
                        <li class="current"><a>添加用户</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>                
                <div id="tab-box">
                <div class="u-form-wrap">
                
                <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>用户信息<em></em><i></i></li>
							<li class="current">添加用户<em></em><i></i></li>
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
                    
              	<form action="<%=path%>/plat/doAddUser.do" id="frm" name="frm" method="post">
              	
              	<fieldset>
              		<legend>基本信息</legend>
              	
				<table cellpadding="2" cellspacing="1" class="newTab">
					
					  <tr>
                        <td width="200px;" align="right"><font style="color: red;">*&nbsp;</font>用户名：</td>
					    <td width="200px;">
                        	<input type="text" onkeyup="x_NaNAndLetter(this)" maxlength="18" id="userAccount" name="userAccount" onblur="x_NaNAndLetter(this);checkUserAccount();" />
                        	<font style="font-size: 12px;color: orange;" id="msg"></font>
                        </td>
                        
                        <td width="200px;" align="right"><font style="color: red;">*&nbsp;</font>姓名：</td>
					    <td width="200px;">
                        	<input type="text" maxlength="10" id="chName" name="chName" />
                        </td>
					  </tr>					  
					   <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>性别：</td>
					    <td>
					    	<input style="width: 20px;" type="radio" id="gender" name="gender" value="1" />男
                            <input style="width: 20px;" type="radio" id="gender" name="gender" value="2" />女                           
                        </td>
                        <td align="right"><font style="color: red;">*&nbsp;</font>手机：</td>
					    <td>
                        	<input type="text" maxlength="11" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" id="mobile" name="mobile" />
                        </td>                       
					  </tr>
					
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>证件类型：</td>
					    <td>
                        	<select id="idType" name="idType">
                        		<option value="" selected="selected">请选择</option>
                        		<c:forEach items="${idList}" var="id">
                        			<option value="${id.code}">${id.name}</option>
                        		</c:forEach>
                        	</select>
                        </td>
                         <td align="right"><font style="color: red;">*&nbsp;</font>证件号码：</td>
					    <td>
                        	<input type="text" maxlength="50" onkeyup="x_NaNAndLetter(this)" onblur="x_NaNAndLetter(this)" id="idNo" name="idNo" />
                        </td>
					  </tr>
                      <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>密码：</td>
					    <td>
                        	<input type="password" maxlength="30" id="password" name="password" />
                        </td>
                         <td align="right"><font style="color: red;">*&nbsp;</font>确认密码：</td>
					    <td>
                        	<input type="password" maxlength="30" id="password2" name="password2" />
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
                            <input type="text" maxlength="300" style="width: 260px;" id="usualAddress" name="usualAddress" />
                        </td>
                        <td width="200px;" align="right"><font style="color: red;">*&nbsp;</font>常住邮编：</td>
					    <td width="200px;">
                        	<input maxlength="6" type="text" id="zipCode" name="zipCode" maxlength="6" />
                        </td>  
					  </tr>		
					  
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>户籍地址：</td>
					    <td>
                            <input type="text" maxlength="300" style="width: 260px;" id="registerAddress" name="registerAddress" />
                        </td>
                        
                        <td align="right"><font style="color: red;">*&nbsp;</font>状态：</td>
					    <td>
                        	<select id="status" name="status">
                        		<option value="" selected="selected">请选择</option>
                        		<c:forEach items="${statusList}" var="id">
                        			<option value="${id.code}">${id.name}</option>
                        		</c:forEach>
                        	</select>
                        </td>
					  </tr>
                      <tr> 
                        <td align="right"><font style="color: red;">*&nbsp;</font>角色分配：</td>
					    <td>
                        	<c:forEach items="${roles}" var="r">
                           		<input type="checkbox" style="width: 20px;" id="role" name="role" value="${r.roleId}" />${r.roleName}
                           </c:forEach>
                        </td>
					  </tr>
					  
					 
					  
					</table>					
				</fieldset>
				
				<fieldset>
					<legend>选录信息</legend>
					<table cellpadding="2" cellspacing="1" class="newTab">
						 <tr>
                        <td width="200px;"  align="right">Email：</td>
					    <td  width="200px;">
                            <input type="text" maxlength="100" id="email" name="email" />
                        </td>
                        
                        <td  width="200px;" align="right">QQ：</td>
					    <td  width="200px;">
                        	<input type="text" maxlength="15" id="QQ" name="QQ" />
                        </td>
					  </tr>
					   <tr>
                        <td align="right">微博：</td>
					    <td>
                        	<input type="text" maxlength="200" id="weibo" name="weibo" />
                        </td>
                         <td align="right">微信：</td>
					    <td>
                        	<input type="text" maxlength="40" id="weixin" name="weixin" />
                        </td>
					  </tr>
						<tr>
					    <td colspan="4" style="text-align: center;">
                        	<button type="button" style="margin-left:290px;" id="do_search" class="search" onclick="checkAndSubmit();">添加</button>
                        </td>
					  </tr>  
					</table>
				</fieldset>
				</form>             
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
