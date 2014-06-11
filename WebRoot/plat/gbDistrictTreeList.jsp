<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<select onchange="changeDistrict(this.value, '${nextId }')">
	<option value="">请选择</option>
	<c:forEach items="${gds}" var="gd">
		<option value="${gd.districtId }">${gd.districtName }</option>
	</c:forEach>
</select>