<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-个人主页</title>
    <meta name="Keywords" content="" />
    <meta name="Description" content="" />
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <script src="<%=path%>/js/plat/home.js" type="text/javascript"></script>
    
	<script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
	<script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
	<script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
	<script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
</head>
<body>	
    <input type="hidden" value="user_menu_my@index" name="currMenu" id="currMenu" />	
        <div class="u-main">
            <div class="ucenter">
                <div class="ucenter-info mt10">
                    <div class="info-title">
                        <h5>我的个人主页</h5>
                    </div>
                    <div class="info">
                        <ul class="info-img"><li><img src="<%=path %>/images/plat/ico13.gif" class="avatar" /></li></ul>
                        <div class="info-main">
                            <div class="row">
                                <label>
                                    	用户名：</label>${user.userName}</div>
                            <div class="row">
                                <label>
                                    	注册时间：</label>${user.createTime}</div>
                            <div class="row">
                                <label>
                                    	手机：</label>${user.mobileNumber}</div>
                            <div class="row">
                                <label>
                                    	角色：</label><span class="orange">
                                    		<c:if test="${user.userType==1}">普通注册用户</c:if>
                                    		<c:if test="${user.userType==2}">快递员</c:if>
                                    		<c:if test="${user.userType==3}">系统维护人员</c:if>
                                    	</span></div>
                            <div class="row">
                                <input type="hidden" id="successMsg" name="successMsg" value="${successMsg}" />
                            </div>
                        </div>
                        <div class="clear"> </div>
                    </div>
                </div> 
                <div class="ucenter-info mt10">
                <div class="ucenter-tab-box">
                        <ul class="u-tab clearfix">
                            <li><a>修改密码</a></li>
                            <li><a>修改信息</a></li>
                        </ul>
             </div>
                <div id="tab_box">                    
                    <div class="u-form-wrap" style="display: none;">
                     <div>
	                     <form action="<%=path%>/plat/doUpdatePlatPassword.do" id="frm1" name="frm2">
	                     <input type="hidden" id="userId" name="userId" value="${user.userId}" />
	                     <fieldset>
                   		<legend>修改密码</legend>
	                        <table border="0" cellpadding="2" class="newTab" cellspacing="1">
							  <tr>
		                        <td align="right" >旧密码：</td>
							    <td>
		                        	<input type="password" id="oldPassword" name="oldPassword" onblur="checkOldPassword();" />
		                        	<font id="msg" style="font-size: 12px;color: orange;"></font>
		                        </td>
							  </tr>
		                      
		                      <tr>
		                        <td align="right" >新密码：</td>
							    <td>
		                        	<input type="password" maxlength="30" id="newPassword" name="newPassword" />
		                        </td>
							  </tr>
		                    
		                    <tr>
		                        <td align="right" >确认密码：</td>
							    <td>
		                        	<input type="password" maxlength="30" id="newPassword2" name="newPassword2" />
		                        </td>
							  </tr>
							  
							  <tr>
		                        <td align="right" ></td>
							    <td>
		                        	<button id="do_search" class="search" type="button" onclick="updatePassword();">修改</button>
		                        </td>
							  </tr>
						</table>
						</fieldset>
						</form>
				
               </div>
                    </div>
                    <div class="u-form-wrap" style="display: none;">
                        <div>
                   
                   <form action="<%=path%>/plat/doUpdatePlatUserInfo.do" id="frm2" name="frm2">
                   	<fieldset>
                   		<legend>基本信息</legend>
                   	
                     <table cellpadding="2" cellspacing="1" class="newTab">
					  <tr>
					    <td align="right" width="200px;"><font style="color: red;">*&nbsp;</font>姓名：</td>
					    <td width="200px;"><input maxlength="10" type="text" id="chName" name="chName" value="${user.userName}" /></td>
					    <td align="right" width="200px;"><font style="color: red;">*&nbsp;</font>性别：</td>
					    <td width="200px;">
					    	<input style="width: 20px;" type="radio" id="gender" name="gender" <c:if test="${user.gender==1}"> checked="checked"  </c:if> value="1" />男
                            <input style="width: 20px;" type="radio" id="gender" name="gender" <c:if test="${user.gender==2}"> checked="checked"  </c:if> value="2" />女   
					    </td>
					  </tr>					  
					  <tr>
					    <td align="right"><font style="color: red;">*&nbsp;</font>手机号：</td>
					    <td><input type="text" id="mobile" maxlength="11" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" name="mobile" value="${user.mobileNumber }" /></td>
					    <td align="right"><font style="color: red;">*&nbsp;</font>账号：</td>
					    <td>${user.userAccount}</td>
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
					    <td align="right"><font style="color: red;">*&nbsp;</font>证件号：</td>
					    <td >
							<input type="text" id="idNo" name="idNo" maxlength="50" onkeyup="x_NaNAndLetter(this)" onblur="x_NaNAndLetter(this)" value="${user.paperworkNum}" />
						</td>
					  </tr>
					  
					    <tr>
					    <td align="right"><font style="color: red;">*&nbsp;</font>常住地址：</td>
					    <td>
							<input type="text" style="width: 260px;" maxlength="300" id="usualAddress" name="usualAddress" value="${user.habitualResidence }" />
						</td>
					    <td align="right"><font style="color: red;">*&nbsp;</font>常住邮编：</td>
					    <td >
							<input type="text" id="zipCode" name="zipCode" maxlength="6" value="${user.zipCode }" maxlength="6" />
						</td>
					  </tr>
					  
					  <tr>
					    <td align="right"><font style="color: red;">*&nbsp;</font>户籍地址：</td>
					    <td colspan="3">
							<input type="text" style="width: 260px;" maxlength="300" id="registerAddress" name="registerAddress" value="${user.householdRegisterAddress }" />
						</td>
					  </tr>
				</table>
				</fieldset>
				<fieldset>
					<legend>详细信息</legend>
					<table cellpadding="2" cellspacing="1" class="newTab">
						<tr>
						    <td width="200px;" align="right">Email：</td>
						    <td  width="200px;" ><input type="text" maxlength="100" id="email" name="email" value="${user.email }" /></td>
						    <td align="right"  width="200px;" >QQ：</td>
						    <td  width="200px;" ><input type="text" maxlength="15" id="QQ" name="QQ" value="${user.qq }" /></td>
					 	 </tr>
					 	 
					 	 <tr>
					    <td align="right">微信：</td>
					    <td>
							<input type="text" id="weixin" name="weixin" maxlength="40" value="${user.weixin }" />
						</td>
					    <td align="right">微博：</td>
					    <td >
							<input type="text" id="weibo" name="weibo" maxlength="200" value="${user.wb }" />
						</td>
					  </tr>
					
						<tr>
					    <td colspan="3"></td>
					    <td>
							<button id="do_search" class="search" type="button" onclick="checkAndSubmit();">修改</button>
						</td>
                       </tr>
					</table>
				</fieldset>
					</form>
                        </div>
                    </div>
                </div>                
            </div>
            </div>           
        </div>
    <script>
    var div_li = jQuery(".ucenter-tab-box ul li");
	jQuery(div_li).click(function () {
		jQuery(this).addClass("current").siblings().removeClass("current");
		var div_index = div_li.index(this);
		jQuery("#tab_box>div").eq(div_index).show().siblings().hide();


		var iFramHeight = document.documentElement.scrollHeight;
		var obj = parent.document.getElementById("iFrame");
		obj.height = (iFramHeight+150);
		
	}).hover(function () {
		jQuery(this).addClass("hover");
	}, function () {
		jQuery(this).removeClass("hover");
	});

	var div_li_x = $(".u-tab-wrap ul li");
	jQuery(div_li_x).click(function () {
		jQuery(this).addClass("current").siblings().removeClass("current");
		var div_index = div_li_x.index(this);
		jQuery("#tab-box>div").eq(div_index).show().siblings().hide();

		var iFramHeight = document.documentElement.scrollHeight;
		var obj = parent.document.getElementById("iFrame");
		obj.height = (iFramHeight+240);
		
	}).hover(function () {
		jQuery(this).addClass("hover");
	}, function () {
		$(this).removeClass("hover");
	}); 

	var successMsg = jQuery("#successMsg").val();
	if(null!=successMsg && ""!=successMsg){
		show_msg(successMsg,"");
	}

	//var iFrameObj = document.getElementById("iFrame");
	
	
	
    </script>
</body>
</html>