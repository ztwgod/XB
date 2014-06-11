<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-修改物箱组</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/updateBoxGroup.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
    <script>
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

		//当所属地区未选择时不能填写物箱代码，物箱代码需要根据所属地区动态生成。
		if(""!=selectValue){
			jQuery("#groupCode").val("");
			jQuery("#groupCode").attr("disabled",false);
		}else{
			jQuery("#groupCode").val("");
			jQuery("#groupCode").attr("disabled",true);
		}
	}
    </script>
    <style type="text/css">
    	.boxTab{
    		font-size: 14px;
			border: 0;
			height: 40px;
			margin-top: 40px;
    	}
    	.boxTab tr{
    		height: 30px;
    	}
    </style>
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li  class="current"><a>修改物箱组信息</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                <div class="u-form-wrap">
                
                <div class="demo">
					<ul class="clearfix">
						<li>物箱管理<em></em><i></i></li>
						<li>物箱组<em></em><i></i></li>
						<li class="current">修改物箱组<em></em><i></i></li>
					</ul>
				</div>
				<fieldset>
       				<legend>页面说明</legend>
       					<div class="smDiv">
       						1、所有带<font style="color: red;">&nbsp;*&nbsp;</font>的为必录项。<br />
       					</div>
         		 </fieldset>
                
                <form action="<%=path%>/plat/doUpdateBoxGroup.do" id="frm" name="frm">
                <input type="hidden" id="groupId" name="groupId" value="${storGroupx.groupId}" />
                
                <fieldset>
                	<legend>基本信息</legend>                
                 <table cellpadding="2" cellspacing="1" class="newTab">					 
					  	<tr>
						    <td width="200px;" align="right">
						    	<font style="color: red;">*&nbsp;</font>组简称：
						    </td>
						    <td width="640px;" align="left">
	                        	<input type="text" maxlength="15" id="groupAbb" name="groupAbb" value="${storGroupx.groupAbb}" />
	                        </td>
                        </tr>
                       
                    </table>
                    </fieldset>
                    
                    <fieldset>
                    	<legend>扩展信息</legend>
                    	 <table cellpadding="2" cellspacing="1" class="newTab">
                    	 
                    	  <tr>
                       		<td width="200px;" align="right">
                       			<font style="color: red;">*&nbsp;</font>经度：
                       		</td>
                         	<td width="200px;">
                         		<input type="text" maxlength="10" onkeyup="x_clear(this);" onblur="x_clear(this);" id="longitude" name="longitude" value="${storGroupx.longitude}"/>
                        	</td>
                        	<td width="200px;" align="right">
                       			<font style="color: red;">*&nbsp;</font>纬度：
                       		</td>
                         	<td width="200px;">
                         		<input type="text" maxlength="10" onkeyup="x_clear(this);" onblur="x_clear(this);" id="latitude" name="latitude" value="${storGroupx.latitude}"/>
                        	</td>
                        </tr>
                        
                        <tr>
                         	<td align="right">
	                        	<font style="color: red;">*&nbsp;</font>所属地区：
	                        </td>
						    <td colspan="3">
						    	<input type="hidden" id="districtId" name="districtId" value="${storGroupx.districtId}"/>
	                        	<table border="0">
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
                        
                       <tr>
                         	<td align="right">
                       			<font style="color: red;">*&nbsp;</font>街道/地址：
                       		</td>
                         	<td>
                         		<input type="text" id="locationAbb" maxlength="40" name="locationAbb" value="${storGroupx.locationApp}" />
                        	</td>
                        	
                        	
                        	<td align="right">
                       			<font style="color: red;">*&nbsp;</font>位置描述：
                       		</td>
                         	<td >
                         		<input type="text" id="seatDesc" maxlength="40" name="seatDesc" value="${storGroupx.seatDesc}" />
                        	</td>
                        </tr>
                        
                         <tr>
                         	<td align="right">
                       			<font style="color: red;">*&nbsp;</font>组代码：
                       		</td>
                         	<td >${storGroupx.groupCode}
                         		<input type="hidden" id="groupCode" name="groupCode" value="${storGroupx.groupCode}" />
                         		<!-- 
                         		<input type="text" maxlength="12" id="groupCode" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" readonly="readonly" name="groupCode" value="${storGroupx.groupCode}" />
                        		 -->
                        	</td>
                         	<td align="right">组描述：</td>
                         	<td >
                         		<input type="text" value="${storGroupx.groupDesc}" maxlength="150" id="groupDesc" name="groupDesc" />
                        	</td>
                        	
                        </tr>
                    	<tr>
                         	<td colspan="4" align="center">
                         		 <button id="do_search" class="search" type="button" onclick="toListBoxGroup();">返回</button>
                         		 <button id="do_search" class="search" type="button" onclick="checkAndSubmit();">修改</button>                         		
                        	</td>
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