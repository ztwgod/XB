<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>讯宝-快递员列表</title>
	<link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
		
	<script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
	<script src="<%=path%>/js/plat/tipswindown.js" type="text/javascript"></script>
	<script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
	<script src="<%=path%>/js/plat/listcourier.js" type="text/javascript"></script>
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
				url:'<%=path%>/plat/getGbDistrictListByParentId.do',
				type:'post',
				data:{districtId:selectValue,
					nextId:nextTdId
				},
				success:function(obj){
					$("#"+nextTdId).html(obj);
				}
			});
			if(nextTdId == "cityTD")
			{
				$("#districtTD").html('');
			}
		}
		document.getElementById('districtId').value = selectValue;
	}
	</script>
	</head>
	<body>
		<form action="<%=path%>/plat/listCourier.do" id="frm" name="frm">
			<input type="hidden" value="${page.pageCount}" id="pagecount" name="pagecount" />
    		<input type="hidden" value="${page.pageNumber}" id="pageNumber" name="pageNumber" />
    		<input type="hidden" value="${page.pageSize}" id="pageSize" name="pageSize" />
    		
    		<input type="hidden" value="<%=path%>" id="root" name="root" />
    		<input type="hidden" id="ssId" name="ssId" value="${courierx.ssId}" />
    		<input type="hidden" id="exePermission" name="exePermission" value="${courierx.exePermission}" />
    		<input type="hidden" id="checkedGroupId" name="checkedGroupId" value="${checkedGroupId}" />
  			<input type="hidden" id="checkedGroupName" name="checkedGroupName" value="${checkedGroupName}" />
  			
    		
			<table  class="tabSearch">
				<tr>
					<td align="right">地址：</td>
					<td  colspan="2" style="width:360px;" align="left">
						<input type="hidden" id="districtId" name="districtId" value="${districtId}"/>
				    	<c:if test="${not empty districtName}"><input type="text" value="${districtName }" title="单击修改" readonly="readonly" onclick="this.style.display='none';document.getElementById('districtId').value='';document.getElementById('districtTable').style.display='block';"/></c:if>
				    	<table border="0" id="districtTable" <c:if test="${not empty districtName}"> style="display: none;"</c:if>>
				    		<tr>
				    			<td id="provinceTD">
				    			<jsp:include page="/plat/gbDistrictTreeList.jsp"></jsp:include>
				    			</td>
				    			<td id="cityTD" style="padding-left: 10px;"></td>
				    			<td id="districtTD" style="padding-left: 10px;"></td>
				    		</tr>
				    	</table>
					</td>
					<td align="right">组名称：</td>
					<td>
						<input type="text" id="groupName" name="groupName" style="height:30px;" value="${courierx.groupName}">											
					</td>
				</tr>
				<tr>
					<td align="left" style="padding-left: 40px;" colspan="4"></td>
					<td align="right" style="padding-right:35px;">
					<button class="search" id="sBut" name="sBut" onclick="search();" >查询</button>
				</tr>
			</table>
		</form>
		
		<table class="u-table" id="courierTab">
			<tr>
				<th>选择</th>
				<th>组名称</th>
				<th>联系人</th>
				<th>联系人电话</th>
				<th>所属地区</th>
				<th>快递公司名称</th>
			</tr>
				
			<c:forEach items="${listCourier}" var="s">		
			<tr>
				<td><input type="checkbox" name="groupIds" onclick="getDefaultValue();" <c:if test="${s.check eq 1}">checked="checked"</c:if> id="${s.groupName}" value="${s.groupId}"></td>
				<td>${s.groupName}</td>
				<td>${s.contactorName}</td>
				<td>${s.contactorPhone}</td>
				<td>${s.districtName}</td>
				<td>${s.excoName}</td>
			</tr>
			</c:forEach>
		</table>
		<div id="showMoreBut" style="margin: auto 0;font-size: 14px;text-align: center;padding-top:5px;cursor:pointer;margin-top: 10px;color:ORANGE;">
			<c:if test="${page.pageSize<page.pageAllCount}">
				 <span id="showMoreMsg" onclick="showMorelist();">显示更多...</span>
			</c:if>
		</div>
		<div id="_divSelected" style="font-size: 13px;color:#0087BD;font-weight:bold;margin-top:10px;margin-bottom: 10px;"></div>
	</body>
	<script type="text/javascript">
		getDefaultValue();
		//getHidenValue();
	</script>
</html>
