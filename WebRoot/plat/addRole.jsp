<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-添加角色</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
    <script type="text/javascript">
    	function checkForm(formObj)
    	{
    		show_loading();
    		if(x_isEmpty('roleName'))
    		{
    			show_err_msg('请输入角色名称');
    			return false;
    		}
    		if(x_isEmpty('roleType'))
    		{
    			show_err_msg('请选择角色类型');
    			return false;
    		}
    		if(x_isEmpty('roleDesc'))
    		{
    			show_err_msg('请输入角色描述');
    			return false;
    		}
    		if(x_isEmpty('status'))
    		{
    			show_err_msg('请选择角色状态');
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
                        <li><a href="<%=path%>/plat/getRoleList.do" style="display: block; height: 100%; width: 100%;">角色列表</a></li>
                        <li class="current"><a>添加角色</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                
                <div id="tab-box">
                    <div class="u-form-wrap">
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>角色管理<em></em><i></i></li>
							<li class="current">添加角色<em></em><i></i></li>
						</ul>
					</div>
					
					<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、所有带<font style="color: red;">&nbsp;*&nbsp;</font>的为必录项。<br />
         					</div>
         		 	</fieldset>
                    
                    <form action="<%=path %>/plat/addRole.do" method="post" onsubmit="return checkForm(this);">
                    
                    <fieldset>
                    	<legend>添加角色</legend>
                   
				 <table cellpadding="2" class="newTab" cellspacing="1" >
					 
					  <tr>
                        <td align="right" ><font color="red">*&nbsp;</font>角色名称：</td>
					    <td>
                        	<input type="text" maxlength="30" id="roleName" name="roleName"/>
                        </td>
					  </tr>
					  
                      <tr>
                        <td align="right" ><font color="red">*&nbsp;</font>角色类型：</td>
					    <td>
                        	<select id="roleType" name="roleType">
                        		<option value="">请选择</option>
                        		<c:forEach items="${roleTypeList}" var="rt">
                        			<option value="${rt.code }">${rt.name }</option>
                        		</c:forEach>
                        	</select>
                        </td>
					  </tr>
                      
                      <tr>
                        <td align="right" ><font color="red">*&nbsp;</font>角色描述：</td>
					    <td>
                        	<textarea rows="3" cols="60" id="roleDesc" name="roleDesc"></textarea>
                        </td>
					  </tr>
                      
                       <tr>
                        <td align="right" ><font color="red">*&nbsp;</font>状态：</td>
					    <td>
                        	<select id="status" name="status">
                            	<option value="">请选择</option>
                            	<c:forEach items="${serviceStatusList}" var="ss">
                            		<option value="${ss.code}">${ss.name}</option>
                            	</c:forEach>
                            </select>
                        </td>
					  </tr>
                      <tr>
                      	<td></td>
                        <td><button id="do_search" class="search" type="submit">添加</button></td>
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
