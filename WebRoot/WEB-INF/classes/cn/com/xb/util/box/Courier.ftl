<#list listCourier as s>
<tr>
	<td><input type="checkbox" name="groupIds" onclick="getDefaultValue();" <#if s.check=='1'>checked="checked"</#if> id="${s.groupName}" value="${s.groupId}"></td>
	<td>${s.groupName}</td>
	<td>${s.contactorName}</td>
	<td>${s.contactorPhone}</td>
	<td>${s.districtName}</td>
	<td>${s.excoName}</td>
</tr>
</#list>