<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <title>讯宝-门户系统</title>
  	<script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
  	<script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
  	<script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
  	<script src="<%=path%>/js/portal/register3.js" type="text/javascript"></script>
  	
  	<script type="text/javascript">
	function changeDistrict(selectValue, nextTdId)
	{
		if(selectValue == "")
		{
			// 清空下一级下拉框
			if(nextTdId == "cityTD")
			{
				$("#cityTD").html('');
				$("#districtTD").html('');
			}
			if(nextTdId == "districtTD")
			{
				$("#districtTD").html('');
			}
		} else {
			// 调出下拉框
			$.ajax({
				url:'<%=path%>/portal/getGbDistrictListByPId.do',
				type:'post',
				data:{districtId:selectValue,
					nextId:nextTdId
				},
				success:function(obj){
					$("#"+nextTdId).html(obj);
					changeStorGroup(selectValue);
				}
			});
			if(nextTdId == "cityTD")
			{
				$("#districtTD").html('');
			}
		}
		document.getElementById('districtId').value = selectValue;
	}
	
	//获取物箱组信息
	function changeStorGroup(selectValue){
		// 调出下拉框
		$.ajax({
			url:'<%=path%>/portal/getStorGroupListByDistrict.do',
			type:'post',
			data:{
				districtId:selectValue
			},
			success:function(obj){
				jQuery("#storGroupTD").html('');
				jQuery("#storGroupTD").html(obj);
				clearSelected();
			}
		});
	}

	function clearSelected(){
		$("#stor").empty();
		$("#box").empty();
		$("#stor").append("<option value=''>请选择</option>");
		$("#box").append("<option value=''>请选择</option>");
	}

	//获取物箱组下面的物箱列表
	function changeStorInfo(selectValue){
		// 调出下拉框
		$.ajax({
			url:'<%=path%>/portal/getStorListByGroupId.do',
			type:'post',
			data:{
				groupId:selectValue
			},
			success:function(obj){
				jQuery("#storTD").html('');
				jQuery("#storTD").html(obj);
			}
		});
	}

	//获取箱子信息
	function changeBoxInfo(selectValue){
		// 调出下拉框
		$.ajax({
			url:'<%=path%>/portal/getBoxInfoBySSId.do',
			type:'post',
			data:{
				ssId:selectValue
			},
			success:function(obj){
				jQuery("#boxTD").html('');
				jQuery("#boxTD").html(obj);
			}
		});
	}
	</script>
    <style type="text/css">
    td{
		height:40px;
		font-size:14px;
	}
	input{
		height:25px;
	}
    </style>
</head>
<body>
    <!-- 导航代码开始 -->
    <jsp:include page="nav.jsp"></jsp:include>
	<!--代码结束 -->
	
    <div style="margin:0 auto;width: 1000px; font-size:12px; cursor:pointer; margin-top:5px;">
    	
    </div>
    
	 <div style="text-align:center;auto;padding-left:350px;margin:0 auto; margin-top:30px;">
    	<form action="<%=path%>/portal/doRegister3.do" id="frm" name="frm">
    	<input type="hidden" id="userId" name="userId"  value="${userId}" />
    	<table>
    	
    		 <tr>
            	<td align="right"><font style="color: red;">*</font>定制物箱别名：</td>
                <td align="left">
                     <input type="text"  id="boxAliases" name="boxAliases"/>
                </td>
            </tr>
    		
    		<tr>
            	<td align="right"><font style="color: red;">*</font>定制物箱：</td>
                <td align="left" style="width:500px;">
                		<input type="hidden" id="districtId" name="districtId" value="${districtId}"/>
				    	<c:if test="${not empty districtName}"><input type="text" value="${districtName }" title="单击修改" readonly="readonly" onclick="this.style.display='none';document.getElementById('districtId').value='';document.getElementById('districtTable').style.display='block';"/></c:if>
				    	<table border="0" id="districtTable" <c:if test="${not empty districtName}"> style="display: none;"</c:if>>
				    		<tr>
				    			<td id="provinceTD">
				    			<jsp:include page="/portal/gbDistrictTreeList.jsp"></jsp:include>
				    			</td>
				    			<td id="cityTD" style="padding-left: 10px;"></td>
				    			<td id="districtTD" style="padding-left: 10px;"></td>
				    		</tr>
				    	</table>
				    	<table>
				    		<tr>
				    			<td id="storGroupTD">
				    			物箱组：<select id="storGroup" style="height: 28px;">
                							<option value="">请选择</option>
                						</select>
                				</td>
				    			<td id="storTD">
				    			物箱：<select id="stor" style="height: 28px;">
                						<option value="">请选择</option>
                					</select>
				    			</td>
				    			<td id="boxTD">
				    			箱子：<select id="box" style="height: 28px;">
                						<option value="">请选择</option>
                					</select>
				    			</td>
				    		</tr>
				    	</table>
                </td>
            </tr> 
             <tr>
            	<td colspan="2" align="center" >
            		<br />
                	<input style="height:30px; width:60px;" type="button" id="loginBut" name="loginBut" onclick="Skip();" value="跳过" />
                	<input style="height:30px; width:60px;" type="button" id="loginBut" name="loginBut" onclick="checekAndSubmit();" value="完成" />
                 </td>
            </tr>            
        </table>
       </form>
   </div>
</body>
</html>