<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-修改快递员</title>
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
    		if(x_G('groupIsChange').value == '1' && x_isEmpty('groupId'))
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
    	
    	function changeCouCom(couComId, flag)
    	{
    		if(flag == 1)
    		{
	    		document.getElementById('groupShow').style.display='none';
	    		document.getElementById('groupIsChange').value='1';
	    		document.getElementById('courierGroupDiv').style.display='block';
    		}
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
    	
	</script>
    
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li class="current"><a>修改快递员信息</a></li>
                        <li><a href="<%=path%>/plat/toModifyCourierPicPage.do?userId=${userId}" style="display: block; height: 100%; width: 100%;">修改照片</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                    <div class="u-form-wrap">
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>快递员管理<em></em><i></i></li>							
							<li class="current">修改快递员信息<em></em><i></i></li>
						</ul>
					</div>
					
					<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、所有带<font style="color: red;">&nbsp;*&nbsp;</font>的为必录项。<br />
         					</div>
         		 	</fieldset>
                    
                    <div style="font-weight: 700; font-size: 28px; font-family: 'Curlz MT';">step 1 :</div>
                    <form action="<%=path %>/plat/doModifyCourierInfo.do" method="post" onsubmit="return checkForm(this);">
                    
                    <fieldset>
                    	<legend>修改快递员信息</legend>
                    <table cellpadding="2" cellspacing="1" class="newTab">
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>用户名：</td>
					    <td><input type="hidden" id="userId" name="userId" value="${cw.userId }"/>
                        	<input type="text" value="${cw.userAccount }" disabled="disabled"/>
                        </td>
                        
                        <td align="right"><font style="color: red;">*&nbsp;</font>姓名：</td>
					    <td>
                        	<input type="text" id="chName" maxlength="10" name="chName" value="${cw.userName }"/>
                        </td>
					  </tr>					  
					   <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>性别：</td>
					    <td>
					    	<input style="width: 20px;" type="radio" id="gender" name="gender" value="1" <c:if test="${cw.gender eq 1}">checked</c:if>/>男
                            <input style="width: 20px;" type="radio" id="gender" name="gender" value="2" <c:if test="${cw.gender eq 2}">checked</c:if>/>女                           
                        </td>
                        <td align="right"><font style="color: red;">*&nbsp;</font>快递员状态：</td>
					    <td>
                        	<select id="courierStatus" name="courierStatus">
                        		<option value="" selected="selected">请选择</option>
                        		<c:forEach items="${fds}" var="fd">
                        			<option value="${fd.code}"<c:if test="${cw.courierStatus eq fd.code}">selected</c:if>>${fd.name}</option>
                        		</c:forEach>
                        	</select>
                        </td>                       
					  </tr>
					  
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>联系电话：</td>
					    <td>
                        	<input type="text" id="mobile" maxlength="11" onkeyup="x_isNaN(this)" onblur="x_isNaN(this)" name="mobile" value="${cw.mobileNumber }"/>
                        </td>
                        <td align="right">Email：</td>
					    <td>
                        	<input type="text" maxlength="50" id="email" name="email" value="${cw.email }"/>
                        </td>
					  </tr>
					  
					  <tr>
					    <td align="right">密码：</td>
					    <td>
                        	<input type="password" maxlength="30" id="password" name="password" />
                        </td>
                         <td align="right">确认密码：</td>
					    <td>
                        	<input type="password" maxlength="30" id="password2" name="password2" />
                        </td>
					  </tr>
					
                       <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>快递公司：</td>
					    <td>
                        	<select id="excoId" name="excoId" onchange="changeCouCom(this.value, 1);">
                            	<option value="">请选择</option>
                            	<c:forEach items="${ecs}" var="ec">
                            		<option value="${ec.excoId }" <c:if test="${cw.excoId eq ec.excoId}">selected</c:if>>${ec.excoName }</option>
                            	</c:forEach>
                            </select>
                        </td>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>快递员组：</td>
					    <td>
					    	<input type="hidden" id="groupIsChange" name="groupIsChange" value="0"/>
					    	<input type="text" id="groupShow" value="${cw.groupName }" title="单击修改" readonly="readonly" onclick="this.style.display='none';document.getElementById('groupIsChange').value='1';document.getElementById('courierGroupDiv').style.display='block';"/>
					    	<div id="courierGroupDiv" style="display: none;">
					    	<jsp:include page="/plat/courierGroupSelect.jsp"></jsp:include>
					    	</div>
                        </td>
					  </tr>
					
                      <tr>
	                    <td align="right" ><font style="color: red;">*&nbsp;</font>所属地区：</td>
					    <td colspan="3">
                        	<input type="hidden" id="localeId" name="localeId" value="${cw.localeId }"/>
                        	<input type="text" value="${cw.localeName }" title="单击修改" readonly="readonly" onclick="this.style.display='none';document.getElementById('localeId').value='';document.getElementById('localeTable').style.display='block';"/>
					    	<table border="0" style="display: none;" id="localeTable">
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
                            <input type="text" maxlength="300" style="width: 260px;" id="usualAddress" name="usualAddress" value="${cw.habitualResidence }"/>
                        </td>
                        <td align="right">常住邮编：</td>
					    <td>
                        	<input type="text" onkeyup="x_isNaN(this)" onblur="x_isNaN(this)" id="zipCode" name="zipCode" maxlength="6" value="${cw.zipCode }"/>
                        </td>  
					  </tr>		
					  
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>户籍地址：</td>
					    <td colspan="3">
                            <input type="text" style="width: 260px;" maxlength="300" id="registerAddress" name="registerAddress" value="${cw.householdRegisterAddress }"/>
                        </td>
					  </tr>
					  
					  <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>证件类型：</td>
					    <td>
                        	<select id="idType" name="idType">
                        		<option value="">请选择</option>
                        		<c:forEach items="${idList}" var="id">
                        			<option value="${id.code}" <c:if test="${cw.paperworkType eq id.code}">selected</c:if>>${id.name}</option>
                        		</c:forEach>
                        	</select>
                        </td>
                         <td align="right"><font style="color: red;">*&nbsp;</font>证件号码：</td>
					    <td>
                        	<input type="text" id="idNo" maxlength="50" onkeyup="x_NaNAndLetter(this)" onblur="x_NaNAndLetter(this)" name="idNo" value="${cw.paperworkNum }"/>
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
<script type="text/javascript">changeCouCom('${cw.excoId}', 0);</script>
</html>
