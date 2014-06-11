<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-用户列表</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>    
    <script src="<%=path%>/js/plat/listUser.js" type="text/javascript"></script>
</head>
<body>
   
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab">
                        <li class="current"><a>用户列表</a></li>
                        <li onclick="toAddUser();"><a>添加用户</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>                
                <div id="tab-box">
                    <div class="u-form-wrap">  
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>用户信息<em></em><i></i></li>
							<li class="current">用户列表<em></em><i></i></li>
						</ul>
					</div>
                                   
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                       <form action="<%=path%>/plat/listUser.do" id="searchFrm" name="searchFrm"> 
                       <input type="hidden" value="${page.pageCount}" id="pagecount" name="pagecount" />
    				   <input type="hidden" value="${page.pageNumber}" id="pageNumber" name="pageNumber" />    
                            <table class="tabSearch">
                                <tr>
                                    <td align="right">账号：</td>
                                    <td><input type="text" id="userAccount" name="userAccount" value="${user.userAccount}"/></td>
                                    <td align="right">姓名：</td>
                                    <td><input type="text" id="userName" name="userName" value="${user.userName}"/></td>
                                </tr>
                                 <tr>
                                    <td align="right">手机号：</td>
                                    <td><input type="text" id="mobileNumber" name="mobileNumber" value="${user.mobileNumber}"/></td>
                                    <td align="right">状态：</td>
                                    <td>
                                    	<select id="status" name="status">
                                        	<option value="">请选择</option>
                                            <c:forEach items="${statusList}" var="id">
                        						<option value="${id.code}" <c:if test="${user.status eq id.code }">selected="selected"</c:if> >${id.name}</option>
                        					</c:forEach>
                                        </select>
                                    </td>
                                </tr>                                
                                 <tr>
                                    <td align="right">用户类型：</td>
                                    <td>
                                    	<select id="userType" name="userType">
                                           		<option value="">请选择</option>
                                           <c:forEach items="${userTypeList}" var="id">
                        						<option value="${id.code}" <c:if test="${user.userType eq id.code }">selected="selected"</c:if> >${id.name}</option>
                        				   </c:forEach>
                                        </select>
                                    </td>
                                     <td></td>
                                    <td align="left"><button id="do_search" class="search" onclick="search();">查询</button></td>
                                </tr>
                            </table>
                           </form>
                        </div>
						
						<table class="u-table">
                            <tr>
                                <th width="15%">
                                    	用户名
                                </th>
                                <th width="15%">
                                    	账号
                                </th>
                                <th width="15%">
                                    	状态
                                </th>
                                <th width="15%">
                                    	用户类型
                                </th>
                                <th width="15%">
                                    	手机
                                </th>
                                <th width="25px;">
                                	操作
                                </th>
                            </tr>                            
                            <c:forEach items="${userList}" var="user">
                            <tr>
                                <td>${user.userName}</td>
                                <td>${user.userAccount}</td>
                                <td>                                	
                                	<c:if test="${user.status==1}">未激活</c:if>
                                	<c:if test="${user.status==2}">激活</c:if>
                                	<c:if test="${user.status==3}">禁用</c:if>
                                	<c:if test="${user.status==4}">无效</c:if>
                                </td>
                                <td>
                                	<c:if test="${user.userType==1}">普通注册用户</c:if>
                                	<c:if test="${user.userType==3}">系统维护管理人员</c:if>
                                </td>
                                <td>${user.mobileNumber}</td>
                                <td>
                                	<a href="<%=path%>/plat/toUpdateUser.do?userId=${user.userId}">修改</a>&nbsp;|&nbsp;
                                	<a onclick="deleteUser('${user.userId}');" href="#">删除</a>
                                </td>
                            </tr>
                            </c:forEach>                            
                        </table>
                         <div id="pager" ></div>
                    </div>
                </div>
            </div>
           
        </div>
        <!-- /.u-main -->
    </div>
    <!-- /.row -->
</body>

</html>
