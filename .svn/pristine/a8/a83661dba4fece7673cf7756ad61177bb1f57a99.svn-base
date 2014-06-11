<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-添加快递公司</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/calendar.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
    <script type="text/javascript">
    	function checkForm(formObj)
    	{
    		show_loading();
    		if(x_isEmpty('excoName'))
    		{
    			show_err_msg('请输入公司名称');
    			return false;
    		}
    		if(x_isEmpty('contactorName'))
    		{
    			show_err_msg('请输入联系人姓名');
    			return false;
    		}
    		if(x_isEmpty('contactPhone'))
    		{
    			show_err_msg('请输入联系电话');
    			return false;
    		}
    		if(x_isEmpty('validDate'))
    		{
    			show_err_msg('请输入有效期限');
    			return false;
    		}
    		if(x_isEmpty('contractNo'))
    		{
    			show_err_msg('请输入合同代码');
    			return false;
    		}
    		
    		return true;
    	}
    </script>
</head>
<body>
  
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li><a href="<%=path%>/plat/getListCourierCompanies.do" style="display: block; height: 100%; width: 100%;">快递公司列表</a></li>
                        <li class="current"><a>添加快递公司</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                    
                <div class="u-form-wrap">
                
                <div class="demo">
						<ul class="clearfix">
							<li>合作方管理<em></em><i></i></li>
							<li>快递公司管理<em></em><i></i></li>							
							<li class="current">添加快递公司<em></em><i></i></li>
						</ul>
					</div>
				
				<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、所有带<font style="color: red;">&nbsp;*&nbsp;</font>的为必录项。<br />
         					</div>
         		 	</fieldset>	
					
                
                <form action="<%=path%>/plat/addCourierCompany.do" method="post" onsubmit="return checkForm(this);">
                
                <fieldset>
                	<legend>添加快递公司</legend>
              
				<table cellpadding="2" class="newTab" cellspacing="1">
					 
					  <tr>
                        <td align="right" width="42%"><font color="red" size="4">*</font> 公司名称：</td>
					    <td>
                        	<input type="text" maxlength="60" id="excoName" name="excoName"/>
                        </td>
					  </tr>
					  
					  <tr>
                        <td align="right" width="42%"><font color="red" size="4">*</font> 联系人：</td>
					    <td>
                        	<input type="text" maxlength="10" id="contactorName" name="contactorName"/>
                        </td>
					  </tr>
                      
                      <tr>
                        <td align="right" width="42%"><font color="red" size="4">*</font> 联系电话：</td>
					    <td>
                        		<input type="text" maxlength="15" id="contactPhone" name="contactPhone" onblur="if(!x_checkTelephone(this.value)){show_err_msg('请输入合法联系电话');this.value='';}"/>
                        </td>
					  </tr>
                      
                       <tr>
                        <td align="right" width="42%">联系地址：</td>
					    <td>
                        	<input type="text" id="contactAdd" maxlength="80" name="contactAdd" style="width: 300px;"/>
                        </td>
					  </tr>
                      
                       <tr>
                        <td align="right" width="42%">服务状态：</td>
					    <td>
                        	<select id="serviceStatus" name="serviceStatus" style="height: 25px; width: 125px;">
                        		<c:forEach items="${serviceStatusList}" var="ss">
                        			<option value="${ss.code}">${ss.name}</option>
                        		</c:forEach>
                        	</select>
                        </td>
					  </tr>
                      
                       <tr>
                        <td align="right" width="42%"><font color="red" size="4">*</font> 合作有效期至：</td>
					    <td>
                        	<input type="text" id="validDate" name="validDate" onclick="new Calendar().show(this);" readonly="readonly"/>
                        </td>
					  </tr>
                      
                       <tr>
                        <td align="right" width="42%"><font color="red" size="4">*</font> 合同代码：</td>
					    <td>
                        	<input type="text" maxlength="30" onkeyup="x_NaNAndLetter(this)" onblur="x_NaNAndLetter(this)" id="contractNo" name="contractNo"/>
                        </td>
					  </tr>
                      
                       <tr>
                        <td align="right" width="42%"></td>
					    <td>
                        	<button id="do_search" class="search" type="submit">添加</button>
                        </td>
					  </tr>
                    
				</table>
				  </fieldset>
				</form>
			 <br />           
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
