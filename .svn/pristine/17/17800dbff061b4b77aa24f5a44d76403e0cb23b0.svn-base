<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-卡片列表</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>    
    <script src="<%=path%>/js/plat/listCard.js" type="text/javascript"></script>
    <script src="<%=path%>/js/calendar.js" type="text/javascript"></script>
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab">
                        <li class="current"><a>卡片列表</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>                
                <div id="tab-box">
                    <div class="u-form-wrap">    
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>卡片管理<em></em><i></i></li>
							<li class="current">卡片列表<em></em><i></i></li>
						</ul>
					</div>
                                 
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                       <form action="<%=path%>/plat/listCard.do" id="searchFrm" name="searchFrm"> 
                       <input type="hidden" value="${page.pageCount}" id="pagecount" name="pagecount" />
    				   <input type="hidden" value="${page.pageNumber}" id="pageNumber" name="pageNumber" />    
                            <table class="tabSearch">
                                <tr>
                                    <td align="right">账号：</td>
                                    <td><input type="text" onkeyup="x_NaNAndLetter(this)" onblur="x_NaNAndLetter(this)" maxlength="18" id="userAccount" name="userAccount" value="${card.userAccount}"/></td>
                                    <td align="right">姓名：</td>
                                    <td><input type="text" id="userName" name="userName" maxlength="10" value="${card.userName}"/></td>
                                </tr>                                
                                <tr>
                                    <td align="right">卡片状态：</td>
                                    <td>
										<select id="cardStatus" name="cardStatus">
                                           		<option value="">请选择</option>
                                           <c:forEach items="${cardStatusList}" var="id">
                        						<option value="${id.code}" <c:if test="${card.cardStatus eq id.code }">selected="selected"</c:if> >${id.name}</option>
                        				   </c:forEach>
                                        </select>
									</td>
                                    <td align="right">卡片有效期：</td>
                                    <td><input id="startTime" name="startTime" value="<fmt:formatDate value="${card.startTime}" pattern="yyyy-MM-dd"/>" type="text" style="border:1px solid #999;" onclick="new Calendar().show(this);" readonly="readonly" />
                                    	&nbsp;至&nbsp;
									<input type="text" id="endTime" name="endTime" value="<fmt:formatDate value="${card.endTime}" pattern="yyyy-MM-dd"/>" style="border:1px solid #999;" onclick="new Calendar().show(this);" readonly="readonly" /></td>
                                </tr>
                                                     
                                 <tr>
                                    <td align="right"></td>
                                    <td>
                                    	
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
                                    	用户类型
                                </th>
                                 <th width="15%">
                                    	卡片有效期
                                </th>
                                
                                <th width="15%">
                                    	卡片状态
                                </th>
                                <th width="25px;">
                                	操作
                                </th>
                            </tr>                            
                            <c:forEach items="${cardList}" var="card">
                            <tr>
                                <td>${card.userName}</td>
                                <td>${card.userAccount}</td>                               
                                <td>
                                	<c:if test="${card.userType==1}">普通注册用户</c:if>
                                	<c:if test="${card.userType==3}">系统维护管理人员</c:if>
                                </td>
                                <td><fmt:formatDate value="${card.cardExpirationDate}" pattern="yyyy-MM-dd"/></td>
                                <td>
                                	<c:if test="${card.cardStatus==1}">启用</c:if>
                                	<c:if test="${card.cardStatus==2}">停用</c:if>
                                	<c:if test="${card.cardStatus==3}">挂失</c:if>
                                </td>
                                <td>
                                	
                                	<c:if test="${card.cardStatus==0}">
                                		<a href="<%=path%>/plat/toAddCard.do?userId=${card.userId}&userAccount=${card.userAccount}">绑定卡片</a>
                                	</c:if>
                                	<c:if test="${card.cardStatus!=0}">
                                		<a href="<%=path%>/plat/toUpdateCard.do?cardId=${card.cardId}&userAccount=${card.userAccount}">修改</a>
                                	</c:if>
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
