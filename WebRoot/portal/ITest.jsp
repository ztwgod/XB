<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
	<script type="text/javascript">
	function commit(){
		var MSG = document.getElementById("MSG").value;
		//var sign = document.getElementById("sign").value;
		if(MSG==''){
			alert("请求参数不能为空!");
		}/*else if(sign==''){
			alert("签名不能为空！");
		}*/else{
			document.getElementById("frm").submit();
		}
	}
	</script>
  </head>
  <body>
  	<form action="<%=path%>/XBPhysicalBoxServlet" id="frm" name="frm" method="post">
  		<div style="margin-left: 400px;margin-top: 50px;">
  			<table>
  				<tr>
  					<td>请选择请求接口：</td>
  					<td>
  						<select id="applyCode" name="applyCode">
  							<option value="1">同步物箱</option>	
  							<option value="2">同步交易信息</option>
  							
  							<option value="6">平台计算快递费用</option>
  							<option value="7">同步箱子</option>	
  							<option value="8">同步快递员信息</option>
  							<option value="9">更新维护人员信息</option>
  							
	  						<option value="12">APP登陆</option>
	  						<option value="13">APP请求开箱</option>
	  						<option value="14">APP请求开箱结果反馈</option>
	  						<option value="15">APP获取交易列表</option>
	  					</select>
  					</td>
  				</tr>
  				<!-- 
  				<tr>
  					<td>
  						签名：
  					</td>
  					<td>
  						<input type="text" id="sign" name="sign" style="width: 300px;" />
  					</td>
  				</tr>
  				 -->
  				 
  				<tr>
  					<td>参数：</td>
  					<td><textarea rows="40" cols="100" id="MSG" name="MSG"></textarea></td>
  				</tr>
  				<tr>
  					<td colspan="2" align="center">
  						<input type="button" onclick="commit();" value="发送" />
  					</td>
  				</tr>
  			</table>
  		</div>
  	</form>
  </body>
</html>
