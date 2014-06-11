<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-快递员组列表</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script type="text/javascript">
		jQuery(document).ready(function() { 
			jQuery("#pager").pager({ 
				pagenumber: ${page.pageNumber}, 
				pagecount: ${page.pageCount},
				buttonClickCallback: PageClick }); 
			});
		
			PageClick = function(pageclickednumber) { 
				jQuery("#pager").pager({ 
					pagenumber: pageclickednumber, 
					pagecount: ${page.pageCount}, 
					buttonClickCallback: PageClick 
			}); 
			//alert("当前第" + pageclickednumber + "页");
			document.getElementById('frm').action = '<%=path%>/plat/getListCourierGroup.do?pageNum=' + pageclickednumber;
			//document.getElementById('districtId').value = '${gcgp.districtId }';
			document.getElementById('do_search').click();
		}
		
		
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
                        <li class="current"><a>快递员组列表</a></li>
                        <li><a href="<%=path%>/plat/toAddCourierGroupPage.do" style="display: block; height: 100%; width: 100%;">添加快递员组</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                
                <div id="tab-box">
                    <div class="u-form-wrap" >
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>快递员组管理<em></em><i></i></li>
							<li class="current">快递员组列表<em></em><i></i></li>
						</ul>
					</div>
                    
                    <!--  <div class="m-sub-til" style="padding: 0;"></div> -->                      
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                       	   <form id="frm" name="frm" action="<%=path%>/plat/getListCourierGroup.do" method="post">
                            <table class="tabSearch">
                                <tr>
                                    <td align="right">组名称：</td>
                                    <td><input type="text" id="groupName" name="groupName" value="${gcgp.groupName }"/></td>
                                    <td align="right">快递公司：</td>
                                    <td>
			                        	<select id="excoId" name="excoId" style="width: 120px;">
			                            	<option value="">请选择</option>
			                            	<c:forEach items="${ecs}" var="ec">
			                            		<option value="${ec.excoId }" <c:if test="${gcgp.excoId eq ec.excoId}">selected</c:if>>${ec.excoName }</option>
			                            	</c:forEach>
			                            </select>
                                    </td>
                                </tr>
                                 <tr>
                                    <td align="right">所属地区：</td>
                                    <td colspan="3">
								    	<input type="hidden" id="districtId" name="districtId" value="${gcgp.districtId }"/>
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
                                    <!-- td align="right">类型：</td>
                                    <td>
                                    	<select id="permission" name="permission">
                                        	<option>请选择</option>
                                        	<c:forEach items="${permission}" var="p">
                                        		<option value="${p.code }" <c:if test="${gcgp.permission eq p.code}">selected</c:if>>${p.name }</option>
                                        	</c:forEach>
                                        </select>
                                    </td -->
                                </tr>
                                
                                 <tr>
                                    <td align="right"></td>
                                    <td></td>
                                     <td><br /></td>
                                    <td align="left"><button id="do_search" class="search" type="submit">查询</button></td>
                                </tr>
                            </table>
                           </form>
                        </div>
						
						<table class="u-table">
                            <tr>
                                <th width="20%">
                                    名称
                                </th>
                                <th width="20%">
                                    快递公司
                                </th>
                                <th width="20%">
                                    所属地区
                                </th>
                                <th width="20%">
                                    取件联系方式
                                </th>
                                <th width="20%">
                                    操作
                                </th>
                            </tr>
                            <c:forEach items="${cgws}" var="cgw">
                            	<tr>
	                                <td>
	                                	${cgw.groupName }
	                                </td>
	                                <td>
	                                	${cgw.excoName }
	                                </td>
	                                <td>
	                                	${cgw.districtName }
	                                </td>
	                                <td>
	                                	${cgw.pickContactorM }
	                                </td>
	                                <td>
	                                	<a href="<%=path %>/plat/toModifyCourierGroupPage.do?groupId=${cgw.groupId }">修改</a>&nbsp;|&nbsp;<a href="<%=path %>/plat/deleteCourierGroup.do?groupId=${cgw.groupId}" onclick="return confirm('是否确认删除');">删除</a>
	                                </td>
	                            </tr>
                            </c:forEach>
                        </table>
                        <div id="pager" ></div>
						
                    </div>
               </div>
            </div>
           
        </div>
        <!-- /.u-main -->
    </div>
    <!-- /.row -->
</body>

</html>
