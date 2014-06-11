<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<select id="groupId" name="groupId">
	<option value="">请选择</option>
   	<c:forEach items="${cgs}" var="cg">
   		<option value="${cg.groupId }">${cg.groupName }</option>
   	</c:forEach>
   <!-- 	<c:if test="${empty cgs}"><option value="">该快递公司未添加快递员组，请先添加</option></c:if>  -->
</select>