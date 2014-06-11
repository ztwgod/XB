箱子：<select id="box" name="box" style="height: 28px;">
            <option value="">请选择</option>
            <#list boxList as s>
				<option value="${s.boxId}">${s.boxCode}</option>
			</#list>
        </select>