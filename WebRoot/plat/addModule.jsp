<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-添加模块</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>  
    <script src="<%=path%>/js/plat/addModule.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li class="current"><a>添加子模块</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                <div id="tab-box">
                    <div class="u-form-wrap">
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>模块管理<em></em><i></i></li>
							<li class="current">添加子模块<em></em><i></i></li>
						</ul>
					</div>
                    
                    <form action="<%=path%>/plat/doAddModule.do" id="frm" name="frm">
                    <input type="hidden" id="parentModuleId" name="parentModuleId" value="${module.moduleId}" />
                    <input type="hidden" id="parentModuleCode" name="parentModuleCode" value="${module.moduleCode}" />
                    
                    <fieldset>
                    	<legend>添加模块</legend>
                    
                    <table cellpadding="2" class="newTab" cellspacing="1">					 
					   <tr>
                        <td align="right" >父模块：</td>
					    <td>
                        	${module.moduleName }
                        </td>
					  </tr>
					  
					  <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>名称：</td>
					    <td>
                        	<input type="text" maxlength="33" id="moduleName" name="moduleName" />
                        </td>
					  </tr>
                      
                      <tr>
                        <td align="right" >链接：</td>
					    <td>
                        	<input type="text" maxlength="128" id="moduleLink" name="moduleLink" />
                        </td>
					  </tr>
                    	
                       <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>代码：</td>
					    <td>
                        	<input type="text" id="moduleCode" maxlength="15" onkeyup="x_NaNAndLetter(this)" name="moduleCode" onblur="x_NaNAndLetter(this);appendCode();checkModuleCode();" onfocus="clearCode();" />
                        	<font style="font-size: 12px;color: orange;" id="msg"></font>
                        </td>
					  </tr>
                      <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>状态：</td>
					    <td>
                        	<select id="moduleStatus" name="moduleStatus">
                           		<option value="">请选择</option>
                           		<c:forEach items="${statusList}" var="s">
               						<option value="${s.code}">${s.name}</option>
               					</c:forEach>                                    		
                           	</select>
                        </td>
					  </tr>
                      
                      <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>类型：</td>
					    <td>
                            <select id="moduleType" name="moduleType">
                           		<option value="">请选择</option>
                           		<c:forEach items="${typelist}" var="t">
               						<option value="${t.code}">${t.name}</option>
               					</c:forEach>                                    		
                           	</select>
                        </td>
					  </tr>  
					   <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>排列顺序：</td>
					    <td>
					    	<input type="text" maxlength="3" onkeyup="x_isNaN(this)" onblur="x_isNaN(this)" id="showSeq" name="showSeq" />
                        </td>
					  </tr>                      
                       <tr>
                        <td align="right" >描述：</td>
					    <td>
                        	<textarea id="moduleDesc" name="moduleDesc"></textarea>
                        </td>
					  </tr>
                      
                      <tr>
                        <td align="right" ></td>
					    <td>
                        	<button id="do_search" class="search" type="button" onclick="toModuleList();">返回</button>&nbsp;&nbsp;
                        	<button id="do_search" class="search" type="button" onclick="checkAndSubmit();">添加</button>
                        </td>
					  </tr>
				</table>
				</fieldset>
			</form>
			</div>
            <div class="u-form-wrap" style="display: none;">&nbsp;</div>
                    
                </div>
            </div>            
        </div>
</body>
</html>
