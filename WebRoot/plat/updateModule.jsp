<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-修改模块信息</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/updateModule.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
</head>
<body>
   
    
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li  class="current"><a>修改模块信息</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                
                <div id="tab-box">
                    <div class="u-form-wrap">
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>模块管理<em></em><i></i></li>
							<li class="current">修改模块信息<em></em><i></i></li>
						</ul>
					</div>
                    
                    <form action="<%=path%>/plat/doUpdateModule.do" id="frm" name="frm">
                    <input type="hidden" id="moduleId" name="moduleId" value="${module.moduleId}" />
                    <input type="hidden" id="parentModuleCode" name="parentModuleCode" value="${parentModule.moduleCode}" />
                     
                     <fieldset>
                     	<legend>模块信息</legend>
                    
                    <table cellpadding="2" class="newTab" cellspacing="1">					 
					  <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>名称：</td>
					    <td>
                        	<input type="text" maxlength="33" id="moduleName" name="moduleName" value="${module.moduleName}" />
                        </td>
					  </tr>
                      
                      <tr>
                        <td align="right" >链接：</td>
					    <td>
                        	<input type="text" maxlength="128" id="moduleLink" name="moduleLink" value="${module.moduleLink }" />
                        </td>
					  </tr>
                    	
                       <tr>
                        <td align="right" >代码：</td>
					    <td>
                        	${module.moduleCode}
                        </td>
					  </tr>
                      <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>状态：</td>
					    <td>
                        	<select id="moduleStatus" name="moduleStatus">
                           		<option value="">请选择</option>
                           		<c:forEach items="${statusList}" var="s">
               						<option value="${s.code}" <c:if test="${module.status eq s.code}">selected="selected"</c:if> >${s.name}</option>
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
               						<option value="${t.code}" <c:if test="${module.moduleType eq t.code}">selected="selected"</c:if>>${t.name}</option>
               					</c:forEach>                                    		
                           	</select>
                        </td>
					  </tr>  
					   <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>排列顺序：</td>
					    <td>
					    	<input type="text" maxlength="3" onkeyup="x_isNaN(this)" onblur="x_isNaN(this)" id="showSeq" name="showSeq" value="${module.showSeq}" />
                        </td>
					  </tr>                      
                       <tr>
                        <td align="right" >描述：</td>
					    <td>
                        	<textarea id="moduleDesc" name="moduleDesc">${module.moduleDesc}</textarea>
                        </td>
					  </tr>
                      
                      <tr>
                        <td align="right" ></td>
					    <td>
                        	<button id="do_search" class="search" type="button" onclick="toModuleList();">返回</button>&nbsp;&nbsp;
                        	<button id="do_search" class="search" type="button" onclick="checkAndSubmit();">修改</button>
                        </td>
					  </tr>  
				</table>
				 </fieldset>
			</form>	
                    </div>
                    
                    <div class="u-form-wrap" style="display: none;">
                        
                    </div>
                    
                </div>
            </div>            
        </div>
        <!-- /.u-main -->
    </div>
    <!-- /.row -->
</body>

</html>
