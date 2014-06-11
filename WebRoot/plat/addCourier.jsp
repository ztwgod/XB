<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-添加快递员</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
    <script type="text/javascript">
    	function changeDistrict(selectValue, nextTdId)
    	{
    		if(selectValue == "")
    		{
    			// 清空下一级下拉框
    			if(nextTdId == "cityTD")
    			{
    				$("#cityTD").html('');
    				$("#districtTD").html('');
    			}
    			if(nextTdId == "districtTD")
    			{
    				$("#districtTD").html('');
    			}
    		} else {
    			// 调出下拉框
				$.ajax({
					url:'<%=path%>/plat/getGbDistrictListByParentId.do',
					type:'post',
					data:{districtId:selectValue,
						nextId:nextTdId
					},
					success:function(obj){
						$("#"+nextTdId).html(obj);
					}
				});
				if(nextTdId == "cityTD")
    			{
    				$("#districtTD").html('');
    			}
    		}
    		document.getElementById('localeId').value = selectValue;
    	}
    	
    	function checkForm(formObj)
    	{
    		show_loading();
    		if(x_isEmpty('userAccount'))
    		{
    			show_err_msg('请输入用户名');
    			return false;
    		}
    		else if(x_G('msg').innerHTML != 'OK')
    		{
    			show_err_msg('输入的用户名已存在');
    			return false;
    		}
    		if(x_isEmpty('chName'))
    		{
    			show_err_msg('请输入快递员姓名');
    			return false;
    		}
    		if(x_trim(x_getRadioValue('gender')) == "")
    		{
    			show_err_msg('请选择快递员性别');
    			return false;
    		}
    		if(x_isEmpty('courierStatus'))
    		{
    			show_err_msg('请选择快递员状态');
    			return false;
    		}
    		if(x_isEmpty('mobile'))
    		{
    			show_err_msg('请输入快递员联系电话');
    			return false;
    		}
    		else if(!x_checkPhone(x_G('mobile').value))
    		{
    			show_err_msg('请输入正确联系方式');
    			return false;
    		}
    		if(!x_isEmpty('email'))
    		{
    			if(!x_isEmail(x_G('email').value))
    			{
    				show_err_msg('请输入合法的Email地址');
    				return false;
    			}
    		}
    		if(x_isEmpty('password'))
    		{
    			show_err_msg('请输入用户密码');
    			return false;
    		}
    		if(x_isEmpty('password2'))
    		{
    			show_err_msg('请输入确认用户密码');
    			return false;
    		}
    		if(x_G('password').value != x_G('password2').value)
    		{
    			show_err_msg('两次密码输入不相符');
    			return false;
    		}
    		if(x_isEmpty('excoId'))
    		{
    			show_err_msg('请选择快递公司');
    			return false;
    		}
    		if(x_isEmpty('groupId'))
    		{
    			show_err_msg('请选择快递员组');
    			return false;
    		}
    		if(x_isEmpty('localeId'))
    		{
    			show_err_msg('请选择快递员所管辖区域');
    			return false;
    		}
    		if(x_isEmpty('usualAddress'))
    		{
    			show_err_msg('请输入快递员常住地址');
    			return false;
    		}
    		if(x_isEmpty('registerAddress'))
    		{
    			show_err_msg('请输入快递员户籍地址');
    			return false;
    		}
    		if(x_isEmpty('idType'))
    		{
    			show_err_msg('请选择快递员证件类型');
    			return false;
    		}
    		if(x_isEmpty('idNo'))
    		{
    			show_err_msg('请输入快递员证件号');
    			return false;
    		}
    		
    		return true;
    	}
    	
    	function changeCouCom(couComId)
    	{
    		if('' != couComId)
    		{
    			$.ajax({
					url:'<%=path%>/plat/getCourierGroupListBycouComId.do',
					type:'post',
					data:{couComId:couComId},
					success:function(obj){
						$("#courierGroupDiv").html(obj);
					}
				});
    		}
    		else
    		{
    			$("#courierGroupDiv").html('');
    		}
    	}
    	
    	function checkUserAccount(){
			var userAccountVal = x_G("userAccount").value;
			var url = "<%=path%>/plat/checkUserAccount.do?userAccount="+userAccountVal;
			if(""==userAccountVal){
				$("#msg").html("");
				$("#msg").html("用户名不能为空！");
			}else{
				$.ajax({
					url: url,
					cache:false, //设置为 false 将不会从浏览器缓存中加载请求信息。
					dataType:'html', //接受数据格式 
					success: function(data,textStatus){
						$("#msg").html(data);
					},
					error: function(XMLHttpRequest,textStatus, errorThrown){
						show_err_msg(" 请求出错!"+errorThrown);
					}
				});
			}
		}
	</script>
    
</head>
<body>
     
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li><a href="<%=path%>/plat/getCourierList.do" style="display: block; height: 100%; width: 100%;">快递员列表</a></li>
                        <li class="current"><a>添加快递员</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                    <div class="u-form-wrap" style="padding: 50px;">
                    
                     <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>快递员管理<em></em><i></i></li>							
							<li class="current">添加快递员<em></em><i></i></li>
						</ul>
					</div>
					
					<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、所有带<font style="color: red;">&nbsp;*&nbsp;</font>的为必录项。<br />
         					</div>
         		 	</fieldset>
                    
                    <div style="font-weight: 700; font-size: 28px; font-family: 'Curlz MT';">step 1 :</div>
                    <form action="<%=path %>/plat/addCourierInfo.do" method="post" onsubmit="return checkForm(this);">
                    
                    <fieldset>
                    	<legend>添加快递员基本信息</legend>
                    <table cellpadding="2" cellspacing="1" class="newTab">
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>用户名：</td>
					    <td>
                        	<input type="text" maxlength="20" onkeyup="x_NaNAndLetter(this);" id="userAccount" name="userAccount" onblur="x_NaNAndLetter(this);checkUserAccount();" />
                        	<font style="font-size: 12px;color: red;" id="msg"></font>
                        </td>
                        
                        <td align="right"><font style="color: red;">*&nbsp;</font>姓名：</td>
					    <td>
                        	<input type="text" maxlength="10" id="chName" name="chName" />
                        </td>
					  </tr>					  
					   <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>性别：</td>
					    <td>
					    	<input style="width: 20px;" type="radio" id="gender" name="gender" value="1" />男
                            <input style="width: 20px;" type="radio" id="gender" name="gender" value="2" />女                           
                        </td>
                        <td align="right"><font style="color: red;">*&nbsp;</font>快递员状态：</td>
					    <td>
                        	<select id="courierStatus" name="courierStatus">
                        		<option value="" selected="selected">请选择</option>
                        		<c:forEach items="${fds}" var="fd">
                        			<option value="${fd.code}">${fd.name}</option>
                        		</c:forEach>
                        	</select>
                        </td>                       
					  </tr>
					  
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>联系电话：</td>
					    <td>
                        	<input type="text" maxlength="11" onkeyup="x_isNaN(this)" onblur="x_isNaN(this)" id="mobile" name="mobile" />
                        </td>
                        <td align="right">Email：</td>
					    <td>
                        	<input type="text" maxlength="50" id="email" name="email" />
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
					
                       <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>快递公司：</td>
					    <td>
                        	<select id="excoId" name="excoId" onchange="changeCouCom(this.value);">
                            	<option value="">请选择</option>
                            	<c:forEach items="${ecs}" var="ec">
                            		<option value="${ec.excoId }">${ec.excoName }</option>
                            	</c:forEach>
                            </select>
                        </td>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>快递员组：</td>
					    <td>
					    	<div id="courierGroupDiv">
					    	<jsp:include page="/plat/courierGroupSelect.jsp"></jsp:include>
					    	</div>
                        </td>
					  </tr>
					
                      <tr>
	                    <td align="right" ><font style="color: red;">*&nbsp;</font>所属地区：</td>
					    <td colspan="3">
                        	<input type="hidden" id="localeId" name="localeId"/>
					    	<table border="0">
					    		<tr>
					    			<td id="provinceTD">
					    			<jsp:include page="/plat/gbDistrictTreeList.jsp"></jsp:include>
					    			</td>
					    			<td id="cityTD" style="padding-left: 10px;"></td>
					    			<td id="districtTD" style="padding-left: 10px;"></td>
					    		</tr>
					    	</table>
                        </td>
					  </tr>
                      
					  <tr>
					  	 <td align="right"><font style="color: red;">*&nbsp;</font>常住地址：</td>
					    <td>
                            <input type="text" maxlength="300" style="width: 260px;" id="usualAddress" name="usualAddress" />
                        </td>
                        <td align="right">常住邮编：</td>
					    <td>
                        	<input type="text" id="zipCode" onkeyup="x_isNaN(this)" onblur="x_isNaN(this)" name="zipCode" maxlength="6" />
                        </td>  
					  </tr>		
					  
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>户籍地址：</td>
					    <td colspan="3">
                            <input type="text" maxlength="300" style="width: 260px;" id="registerAddress" name="registerAddress" />
                        </td>
					  </tr>
					  
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>证件类型：</td>
					    <td>
                        	<select id="idType" name="idType">
                        		<option value="">请选择</option>
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
					    <td colspan="4" style="text-align: center;">
                        	<button type="submit" id="do_search" class="search">下一步</button>
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
    <!-- /.row -->
</body>

</html>
