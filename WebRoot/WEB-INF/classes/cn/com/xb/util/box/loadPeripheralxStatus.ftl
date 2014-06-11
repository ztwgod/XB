<table border="0" align="center" class="eigTab" cellspacing="0">
	<tr>
		<th>设备名称</th>
		<th>运行状态</th>
	</tr>
	<#list peripheralx as s>			
	<tr>
		<td>${s.memo}</td>
		<td>${s.runStatusName}</td>
	</tr>
	</#list>
</table>