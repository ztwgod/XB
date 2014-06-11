<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-物箱组列表</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/listBoxGroup.js" type="text/javascript"></script>
    
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
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li  class="current"><a>物箱组列表</a></li>
                        <li onclick="toAddBoxGroup();"><a>添加物箱组</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                    <div class="u-form-wrap">                    	
                    	<div class="demo">
							<ul class="clearfix">
								<li>物箱管理<em></em><i></i></li>
								<li>物箱组<em></em><i></i></li>
								<li class="current">物箱组列表<em></em><i></i></li>
							</ul>
						</div>               
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                       <input type="hidden" id="_districtId" name="_districtId" value="${storGroup.districtId}" />
                       <form action="<%=path%>/plat/listBoxGroup.do" id="frm" name="frm">
                       <input type="hidden" value="${page.pageCount}" id="pagecount" name="pagecount" />
    				   <input type="hidden" value="${page.pageNumber}" id="pageNumber" name="pageNumber" />  
                       <table class="tabSearch">
                           <tr>
                               <td align="right">所属区域：</td>
                               <td style="width: 360px;">
                              	<input type="hidden" id="districtId" name="districtId"/>
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
                               <td align="right">组简称：</td>
                               <td><input type="text" maxlength="12" id="groupName" name="groupName" value="${storGroup.groupAbb}"/></td>
                           </tr>
                           <tr>
                              <td align="right">&nbsp;</td>
                              <td>&nbsp;</td>
                              <td align="right">&nbsp;</td>
                              <td><button id="do_search" class="search" type="button" onclick="search();">查询</button></td>
                          </tr>
                       </table>
                       </form>
                       </div>
						
						<table class="u-table">
                            <tr>
                                <th width="20%">
                                    	组简称
                                </th>
                                <th width="20%">
                                    	组代码
                                </th>
                                <th width="20%">
                                    	组位置描述
                                </th>
                                <th width="20%">
                                    	组描述
                                </th>
                                
                                <th>
                                	操作
                                </th>
                            </tr>
                            <c:forEach items="${listGroup}" var="g">
                            <tr>
                                <td>
                                	${g.groupAbb}
                                </td>
                                <td>
                                	${g.groupCode}
                                </td>
                                <td>
                              		${g.seatDesc}
                                </td>
                                 <td>
                                	${g.groupDesc}
                                </td>
                                <td>
                                	<a href="<%=path%>/plat/toUpdateBoxGroup.do?groupId=${g.groupId}">修改</a>&nbsp;|&nbsp;
                                	<a href="#" onclick="deleteBoxGroup('${g.groupId}','${g.locationId}');">删除</a>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                        <div id="pager" ></div>
                    </div>
                    <div class="u-form-wrap" style="padding: 50px; display: none;"></div>
                </div>
            </div>
        </div>
</body>

</html>
