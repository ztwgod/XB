<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/plat/tipswindown.css" rel="stylesheet" type="text/css" />
<script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
<script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
</head>
<!-- 菜单 -->
<div class="top" style="margin-top: 10px;">
		<input type="hidden" value="<%=path%>" id="_root" name="_root" />
		<div style="margin-top: 30px;margin-left: 750px;;">
			<c:if test="${null != PLAT_USER_SESSION}">
    			欢迎：${PLAT_USER_SESSION.chName} &nbsp;&nbsp;<a href="<%=path%>/plat/logout.do" >退出登陆</a>&nbsp;
    			<input type="hidden" id="userid" name="userid" value="${PLAT_USER_SESSION.userId }" />
    		</c:if>
    		<c:forEach items="${PLAT_MODULE}" var="t">
    			<c:if test="${t.moduleType==5}">
    				<a href="<%=path%>${t.moduleLink}" target="iFrame">${t.moduleName}</a>&nbsp;
    			</c:if>
			</c:forEach>
		</div>
    </div>
<div class="row">
<div class="u-menu">
          <ul class="u-nav" id="user_menu">
          
          <c:forEach items="${PLAT_MODULE}" var="m">
          	<c:if test="${m.moduleType==4 and m.moduleLevel==2}">
          	<li class="item">
                  <!-- 主菜单 -->
					<h3 class="t1" onclick="itemMenu(this)" >${m.moduleName}</h3>					
					<ul id="${m.moduleId}" style="display:none;"  > 
                  	<c:forEach items="${PLAT_MODULE}" var="s" varStatus="idx">                  		
                  		<c:if test="${s.parentMId eq m.moduleId and s.moduleLevel==3}">
	                  		<li class="sub" id="${s.moduleId}"><a target="iFrame" href="<%=path%>${s.moduleLink}">${s.moduleName}</a></li>	                  		
                  		</c:if>                  		
                  	</c:forEach>
                  	</ul> 
              </li> 
             </c:if>         
          </c:forEach>
          </ul>
 </div>
 <!-- /.u-menu -->
<!-- 菜单 -->
</html>