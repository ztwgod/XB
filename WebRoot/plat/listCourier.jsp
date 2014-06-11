<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-快递员列表</title>
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
		document.getElementById('frm').action = '<%=path%>/plat/getCourierList.do?pageNum=' + pageclickednumber;
		document.getElementById('do_search').click();
	}
	</script>
    
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li class="current"><a>快递员列表</a></li>
                        <li><a href="<%=path%>/plat/toAddCourierPage.do" style="display: block; height: 100%; width: 100%;">添加快递员</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                
                <div id="tab-box">
                    <div class="u-form-wrap">
                    <!--  <div class="m-sub-til" style="padding: 0;"></div> -->   
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>快递员管理<em></em><i></i></li>							
							<li class="current">快递员列表<em></em><i></i></li>
						</ul>
					</div>
                                       
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                         <form id="frm" name="frm" action="<%=path%>/plat/getCourierList.do" method="post">
                            <table class="tabSearch">
                                <tr>
                                    <td align="right">姓名：</td>
                                    <td><input type="text" id="userName" name="userName" value="${gclp.userName }"/></td>
                                    <td align="right">证件号：</td>
                                    <td><input type="text" id="paperworkNum" name="paperworkNum" value="${gclp.paperworkNum }"/></td>
                                </tr>
                                 <tr>
                                    <td align="right">手机号：</td>
                                    <td><input type="text" id="mobileNumber" name="mobileNumber" value="${gclp.mobileNumber }"/></td>
                                    <td align="right">快递公司：</td>
                                    <td>
                                    	<select id="excoId" name="excoId">
                                        	<option value="">请选择</option>
                                        	<c:forEach items="${ecs}" var="ec">
                                        		<option value="${ec.excoId }" <c:if test="${gclp.excoId eq ec.excoId }">selected</c:if>>${ec.excoName }</option>
                                        	</c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                
                                 <tr>
                                    <td align="right"></td>
                                    <td>
                                    	
                                    </td>
                                     <td></td>
                                    <td align="left"><button id="do_search" class="search" type="submit">查询</button></td>
                                </tr>
                            </table>
                          </form>
                        </div>
						
						<table class="u-table">
                            <tr>
                                <th width="12%">
                                    姓名
                                </th>
                                <th width="18%">
                                   证件号
                                </th>
                                <th width="12%">
                                    电话
                                </th>
                                <th width="15%">
                                    用户组
                                </th>
                                <th width="15%">
                                    快递公司
                                </th>
                                <th width="10%">
                                   状态
                                </th>
                                <th width="25px;">
                                	操作
                                </th>
                            </tr>
                            
                            <c:forEach items="${cws}" var="cw">
                            	<tr>
	                                <td>
	                                	${cw.userName }
	                                </td>
	                                <td>
	                                	${cw.paperworkNum }
	                                </td>
	                                <td>
	                                	${cw.mobileNumber }
	                                </td>
	                                <td>
	                                	${cw.groupName }
	                                </td>
	                                <td>
	                                	${cw.excoName }
	                                </td>
	                                <td>
	                                	${cw.courierStatusShow }
	                                </td>
	                                <td>
	                                	<a href="<%=path %>/plat/toModifyCourierPage.do?userId=${cw.userId}">修改</a>&nbsp;|&nbsp;<a href="<%=path %>/plat/deleteCourierInfo.do?userId=${cw.userId}">删除</a>
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
