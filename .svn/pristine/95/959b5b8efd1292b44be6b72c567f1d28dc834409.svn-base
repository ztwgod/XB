<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table id="parentMId_${moduleId }">
	<c:forEach items="${rmos}" var="module">
		<tr>
			<td width="20px;"></td>
			<td><input name="selectedModuleId" id="moduleId_${module.moduleId }" value="${module.moduleId }" type="checkbox"<c:if test="${module.isAssignRole == 1}"> checked="checked"</c:if><c:if test="${module.hasSubModule == 1}"> onclick="checkModule('${module.moduleId }')"</c:if>/>&nbsp;&nbsp;&nbsp;${module.moduleName }<div id="subMId_${module.moduleId }"></div>
			<c:if test="${module.isAssignRole == 1 and module.hasSubModule == 1}"><script type="text/javascript">checkModule('${module.moduleId }');</script></c:if></td>
		</tr>
	</c:forEach>
</table>