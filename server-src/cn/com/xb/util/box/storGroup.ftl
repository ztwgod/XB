物箱组：<select id="storGroup" name="storGroup" style="height: 28px;" onchange="changeStorInfo(this.value)" >
            <option value="">请选择</option>
            <#list storGroups as s>
				<option value="${s.groupId}">${s.groupAbb}</option>
			</#list>
        </select>