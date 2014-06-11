<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-模块列表</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>    
    <script src="<%=path%>/js/plat/listModule.js" type="text/javascript"></script>
    
</head>
<body>
        
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li  class="current"><a>模块列表</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                    <div class="u-form-wrap">
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>模块管理<em></em><i></i></li>
							<li class="current">模块列表<em></em><i></i></li>
						</ul>
					</div>
                    
                    <!--  <div class="m-sub-til" style="padding: 0;"></div> -->                      
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                       	<form action="<%=path%>/plat/listModule.do" id="frm" name="frm">
                       		 <input type="hidden" value="${page.pageCount}" id="pagecount" name="pagecount" />
    				   		 <input type="hidden" value="${page.pageNumber}" id="pageNumber" name="pageNumber" /> 
    				   		 
                             <table class="tabSearch">
                                <tr>
                                    <td align="right">名称：</td>
                                    <td><input type="text" id="moduleName" name="moduleName" value="${module.moduleName}"/></td>
                                    <td align="right">类型：</td>
                                    <td>
                                    	<select id="moduleType" name="moduleType">
                                    		<option value="">请选择</option>
                                    		<c:forEach items="${typelist}" var="t">
                        						<option value="${t.code}" <c:if test="${module.moduleType eq t.code}">selected="selected"</c:if> >${t.name}</option>
                        					</c:forEach>                                    		
                                    	</select>
                                    </td>
                                </tr>                                                  
                                 <tr>
                                    <td align="right"></td>
                                    <td></td>
                                     <td></td>
                                    <td align="left"><button id="do_search" class="search" onclick="search();">查询</button></td>
                                </tr>
                            </table>
                           </form>
                        </div>
						
						<table class="u-table">
                            <tr>
                                <th width="12%">
                                    	名称
                                </th>
                                
                                <th width="16%">
                                    	链接
                                </th>
                                <th width="18%">
                                   	 描述
                                </th>
                                <th width="10%">
                                   	 级别
                                </th>
                                <th width="10%;">
                                	状态
                                </th>
                                 <th width="12%;">
                                	类型
                                </th>
                                 <th>
                                	操作
                                </th>
                            </tr>
                            
                            <c:forEach items="${modules}" var="m">
                            <tr>
                                <td>
                                	${m.moduleName}
                                </td>
                               
                                <td>
                                	${m.moduleLink}
                                </td>
                                <td>
                                	${m.moduleDesc}
                                </td>
                                <td>
                                	${m.moduleLevel}
                                </td>
                                <td>
                                	<c:if test="${m.status==1}">启用</c:if>
                                	<c:if test="${m.status==2}">停用</c:if>
                                </td>
                                <td>
                                	<c:if test="${m.moduleType==1}">根节点</c:if>
                                	<c:if test="${m.moduleType==2}">门户菜单</c:if>
                                	<c:if test="${m.moduleType==3}">门户按钮</c:if>
                                	<c:if test="${m.moduleType==4}">平台菜单</c:if>
                                	<c:if test="${m.moduleType==5}">平台按钮</c:if>
                                	<c:if test="${m.moduleType==6}">android菜单</c:if>
                                	<c:if test="${m.moduleType==7}">android按钮</c:if>
                                	<c:if test="${m.moduleType==8}">iphone菜单</c:if>
                                	<c:if test="${m.moduleType==9}">iphone按钮</c:if>
                                </td>
                                <td>
                                	<a href="<%=path%>/plat/toUpdateModule.do?moduleId=${m.moduleId}">修改</a>&nbsp;|&nbsp;                              	                             	
                                	<a href="<%=path%>/plat/toAddModule.do?moduleId=${m.moduleId}">添加子模块</a>
                                	<c:if test="${m.moduleLevel!=0}">
                                		&nbsp;|&nbsp;<a href="#" onclick="deleteModule('${m.moduleId}')">删除</a>
                                	</c:if>
                                </td>
                            </tr>
                           </c:forEach>
                        </table>
                         <div id="pager" ></div>
                    </div>
                    <div class="u-form-wrap" style="padding: 50px; display: none;">
							&nbsp;                  
                    </div>
                </div>
            </div>
           
        </div>
        <!-- /.u-main -->
    </div>
    <!-- /.row -->
</body>

</html>
