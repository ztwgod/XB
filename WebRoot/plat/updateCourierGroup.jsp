<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-修改快递员组</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
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
    	
    	function checkForm(formObj)
    	{
    		show_loading();
    		if(x_isEmpty('groupName'))
    		{
    			show_err_msg('请输入组名称');
    			return false;
    		}
    		if(x_isEmpty('pickContactorM'))
    		{
    			show_err_msg('请输入取件联系人电话');
    			return false;
    		}
    		if(x_isEmpty('excoId'))
    		{
    			show_err_msg('请选择快递公司');
    			return false;
    		}
    		if(x_isEmpty('districtId'))
    		{
    			show_err_msg('请选择所在区域');
    			return false;
    		}
    		
    		return true;
    	}
	</script>
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li  class="current"><a>修改快递员组</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                
                <div id="tab-box">
                    <div class="u-form-wrap">
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>快递员组管理<em></em><i></i></li>
							<li class="current">修改快递员组<em></em><i></i></li>
						</ul>
					</div>
                    
                    <!--  <div class="m-sub-til" style="padding: 0;"></div> -->                      
                      <form action="<%=path %>/plat/doModifyCourierGroup.do" method="post" onsubmit="return checkForm(this);">
					
					<fieldset>
						<legend>修改快递员组</legend>
					<table cellpadding="2" cellspacing="1" class="newTab">
					  <tr>
					      <td align="right"><font color="red">*&nbsp;</font>组名称：</td>
                          <td><input type="hidden" maxlength="60" id="groupId" name="groupId" value="${cg.groupId }"/><input type="text" id="groupName" name="groupName" value="${cg.groupName }"/> </td>
                       </tr>
					  <tr>
					      <td align="right"><font color="red">*&nbsp;</font>取件联系方式：</td>
                          <td><input type="text" maxlength="11" onkeyup="x_isNaN(this)" onblur="x_isNaN(this)" id="pickContactorM" name="pickContactorM" value="${cg.pickContactorM }"/> </td>
                       </tr>
                       <tr>
					    <td align="right" width="12%"><font color="red">*&nbsp;</font>快递公司：</td>
					    <td align="left" width="16%">
                        	<select id="excoId" name="excoId" style="width: 120px;">
                            	<option value="">请选择</option>
                            	<c:forEach items="${ecs}" var="ec">
                            		<option value="${ec.excoId }" <c:if test="${cg.excoId eq ec.excoId}">selected</c:if>>${ec.excoName }</option>
                            	</c:forEach>
                            </select>
                        </td>
					  </tr>
                     <tr>
                        <td align="right" width="13%"><font color="red">*&nbsp;</font>所属地区：</td>
					    <td>
					    	<input type="hidden" id="districtId" name="districtId" value="${cg.districtId }"/>
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
                      </tr>
                      <!-- tr>
                         <td align="right">类型：</td>
                         <td>
                            <select id="status" name="status" >
                                <option value="" selected="selected">请选择</option>
                                <option value="1">派件</option>
                                <option value="2">取件</option>
                            </select>
           				 </td>
					  </tr -->
                      
                      <!-- tr>
                        <td align="right">物箱组列表：</td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱1组</td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱2组</td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱3组</td>
					  </tr>
                      <tr>
                        <td align="right"></td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱1组</td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱2组</td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱3组</td>
					  </tr>
                      <tr>
                        <td align="right"></td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱1组</td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱2组</td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱3组</td>
					  </tr>
                      <tr>
                        <td align="right"></td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱1组</td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱2组</td>
                        <td><input class="pur" type="checkbox"  name="purview" value="1" />物箱3组</td>
					  </tr -->
                      
                      <tr>
                        <td align="right"></td>
                        <td align="left"><button id="do_search" class="search">返回</button>&nbsp;&nbsp;&nbsp;<button id="do_search" class="search">修改</button></td>
					  </tr>
					</table>
					</fieldset>
					</form>
                    </div>
                </div>
            </div>            
        </div>
</body>

</html>
