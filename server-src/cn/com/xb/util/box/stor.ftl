物箱：<select id="stor" name="stor" style="height: 28px;"onchange="changeBoxInfo(this.value)" >
            <option value="">请选择</option>
            <#list storList as s>
				<option value="${s.ssId}">${s.ssName}</option>
			</#list>
        </select>