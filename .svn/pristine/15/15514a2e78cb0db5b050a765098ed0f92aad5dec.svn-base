<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-物箱列表</title>
     <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
     <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
     
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/listBox.js" type="text/javascript"></script>
    
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li  class="current"><a>物箱列表</a></li>
                        <li onclick="toAddBox();"><a>添加物箱</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                <div id="tab-box">
                    <div class="u-form-wrap">
                    	
                    	<div class="demo">
							<ul class="clearfix">
								<li>物箱管理<em></em><i></i></li>
								<li>物箱维护<em></em><i></i></li>
								<li class="current">物箱列表<em></em><i></i></li>
							</ul>
						</div>
                              
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                           <form action="<%=path%>/plat/listBox.do" id="frm" name="frm">
                           	<input type="hidden" value="${page.pageCount}" id="pagecount" name="pagecount" />
    				   		<input type="hidden" value="${page.pageNumber}" id="pageNumber" name="pageNumber" />
                            <table class="tabSearch">
                                <tr>
                                    <td align="right">物箱站代码：</td>
                                    <td><input type="text" id="ssCode" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" name="ssCode" value="${stro.ssCode}"/></td>
                                    <td align="right">数据卡号：</td>
                                    <td><input type="text" id="dataCard" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" name="dataCard" value="${stro.dataCard}" /></td>
                                </tr>
                                 <tr>
                                    <td align="right">所属组：</td>
                                    <td>
                                    	<select id="groupId" name="groupId">
                                        	<option value="">请选择</option>
                                            <c:forEach items="${storGroup}" var="g">
                            					<option value="${g.groupId}"  <c:if test="${stro.groupId eq g.groupId}">selected="selected"</c:if> >${g.groupAbb}</option>
                            				</c:forEach>
                                        </select>
                                    </td>                                    
                                    <td align="right"></td>
                                     <td></td>
                                </tr>
                                
                                 <tr>
                                    <td align="right"></td>
                                    <td>
                                    	&nbsp;
                                    </td>                                    
                                    <td align="right">&nbsp;</td>
                                    <td><button id="do_search" class="search">查询</button></td>
                                </tr>
                            </table>
                           </form>
                        </div>
						
						<table class="u-table">
                            <tr>
                                <th width="10%">
                                    	物箱站代码
                                </th>
                                
                                <th width="10%">
                                    	物箱IP
                                </th>
                                 <th width="12%">
                                    	数据卡号
                                </th>
                                <th width="8%">
                                   	 	维护员
                                </th>
                                <th width="14%">
                                    	所属组
                                </th>
                                <th width="24%">
                                    	详细地址
                                </th>
                                <th>
                                	操作
                                </th>
                            </tr>
                            <c:forEach items="${listBox}" var="b">
                            <tr>
                                <td>
                                	<a href="<%=path%>/plat/loadGUIBox.do?ssId=${b.ssId}&ssType=${b.ssType}">${b.ssCode}</a>
                                </td>
                               
                                <td>
                                	${b.ipAdd}
                                </td>
                                 <td>
                                	${b.dataCard}
                                </td>
                                <td>
                                	${b.userName}
                                </td>
                                <td>
                                	${b.groupAbb}
                                </td>
                                <td>
                                	${b.ssAddress}
                                </td>
                                <td>
                                	<!-- <a href="<%=path%>/plat/toUpdateBox.do?ssId=${b.ssId}">修改</a>&nbsp;|&nbsp; -->
                                	<a href="<%=path%>/plat/toUpdateBox.do?ssId=${b.ssId}">修改</a>&nbsp;|&nbsp;
                                	<a href="#" onclick="deleteBox('${b.ssId}');">删除</a> &nbsp;|&nbsp;
                                	<a href="<%=path%>/plat/loadGUIBox.do?ssId=${b.ssId}&ssType=${b.ssType}">物箱GUI</a> &nbsp;|&nbsp;
                                	<a href="<%=path%>/plat/loadBox.do?ssId=${b.ssId}">查看</a> 
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                         <div id="pager" ></div>						
                    </div>
                    <div class="u-form-wrap" style="padding: 50px; display: none;"></div>
                </div>
            </div>
        </div>
</body>
</html>
