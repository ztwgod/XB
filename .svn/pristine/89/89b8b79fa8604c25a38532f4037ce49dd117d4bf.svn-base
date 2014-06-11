<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-角色列表</title>
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
		window.location.href = '<%=path%>/plat/getRoleList.do?pageNo=' + pageclickednumber;
		}
	</script>
</head>
<body>
         <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li class="current"><a>角色列表</a></li>
                        <li><a href="<%=path%>/plat/toAddRolePage.do" style="display: block; height: 100%; width: 100%;">添加角色</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                
                <div id="tab-box">
                    <div class="u-form-wrap">
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>角色管理<em></em><i></i></li>
							<li class="current">角色列表<em></em><i></i></li>
						</ul>
					</div>
                    
                    <!--  <div class="m-sub-til" style="padding: 0;"></div> -->                      
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                         
                        </div>
						
						<table class="u-table">
                            <tr>
                                <th width="15%">
                                    角色名称
                                </th>
                                <th width="25%">
                                   角色描述
                                </th>
                                <th width="20%">
                                    角色类别
                                </th>
                                <th width="10%">
                                    状态
                                </th>
                                <th width="10%">
                                    最后修改时间
                                </th>
                                <th width="100">
                                	操作
                                </th>
                            </tr>
                            
                            <c:forEach items="${roles}" var="role">
                            <tr>
                                <td>
                                	${role.roleName }
                                </td>
                                <td>
                                	${role.roleDesc }
                                </td>
                                <td>
                                	${role.roleType eq 1 ? "普通用户角色" : role.roleType eq 2 ? "系统管理用户角色" : "未知类型" }
                                </td>
                                <td>
                                	<c:if test="${role.status == 1 }">有效</c:if>
                                	<c:if test="${role.status == 2 }">无效</c:if>
                                </td>
                                <td>
                                	<fmt:formatDate value="${role.lastUpdateTime }" pattern="yyyy-MM-dd"/>
                                </td>
                                <td>
                                <a href="<%=path %>/plat/toModifyRolePage.do?roleId=${role.roleId }">修改</a>&nbsp;|&nbsp;<a href="<%=path %>/plat/toModifyRoleModulePage.do?roleId=${role.roleId }">分配模块</a>&nbsp;
                                <c:if test="${role.roleId != '141b5744cc728976' and role.roleId != '141bb27b81935887' and role.roleId != '141bf0d677125221' and role.roleId != '141bfe241d429158'}">
                                	|&nbsp;<a href="<%=path %>/plat/deleteRoleInfo.do?roleId=${role.roleId }" onclick="return confirm('是否确认删除');">删除</a>
                                </c:if>	
                                	
                                	
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
