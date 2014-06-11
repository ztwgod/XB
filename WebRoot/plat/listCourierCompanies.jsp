<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-快递公司列表</title>
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
		var mobileNumber = jQuery("#mobileNumber").val();
		var excoName = jQuery("#excoName").val();
		window.location.href = '<%=path%>/plat/getListCourierCompanies.do?pageNum=' + pageclickednumber+'&mobileNumber='+mobileNumber+'&excoName='+excoName;
		}
	</script>
    
</head>
<body>
  
         <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li class="current"><a>快递公司列表</a></li>
                        <li><a href="<%=path%>/plat/toAddCourierCompanyPage.do" style="display: block; height: 100%; width: 100%;">添加快递公司</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                
                <div id="tab-box">
                    <div class="u-form-wrap" >
                    
                    <div class="demo">
						<ul class="clearfix">
							<li>合作方管理<em></em><i></i></li>
							<li>快递公司管理<em></em><i></i></li>							
							<li class="current">快递公司列表<em></em><i></i></li>
						</ul>
					</div>
					
					
					 <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                         <form id="frm" name="frm" action="<%=path%>/plat/getListCourierCompanies.do" method="post">
                            <table class="tabSearch">
                                
                                 <tr>
                                    <td align="right">联系电话：</td>
                                    <td><input type="text" id="mobileNumber" maxlength="15" name="mobileNumber" value="${expressCompany.contactPhone }"/></td>
                                    <td align="right">快递公司名称：</td>
                                    <td>
                                    	<input type="text" id="excoName" name="excoName" value="${expressCompany.excoName}"/>
                                    </td>
                                </tr>
                                
                                 <tr>
                                    <td align="right"></td>
                                    <td>
                                    	
                                    </td>
                                     <td></td>
                                    <td align="left"><button id="do_search" class="search" onclick="search();" type="submit">查询</button></td>
                                </tr>
                            </table>
                          </form>
                        </div>
					
                    
                    <!--  <div class="m-sub-til" style="padding: 0;"></div> -->                      
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                           
                        </div>
						
						<table class="u-table">
                            <tr>
                                <th width="15%">
                                    公司名称
                                </th>
                                <th width="10%">
                                    联系电话
                                </th>
                                <th width="auto">
                                    联系地址
                                </th>
                                <th width="10%">
                                    合同代码
                                </th>
                                <th width="10%">
                                    服务状态
                                </th>
                                <th width="10%">
                                    合作有效期
                                </th>
                                <th width="100px;">
                                	操作
                                </th>
                            </tr>
                            <c:forEach items="${ecs}" var="ec">
                            	<tr>
	                                <td>
	                                	${ec.excoName}
	                                </td>
	                                <td>
	                                	${ec.contactPhone}
	                                </td>
	                                <td>
	                                	${ec.contactAdd}
	                                </td>
	                                <td>
	                                	${ec.contractNo}
	                                </td>
	                                <td>
	                                	<c:if test="${ec.serviceStatus == 1}"><font color="green">正常服务</font></c:if>
	                                	<c:if test="${ec.serviceStatus == 2}"><font color="red">服务终止</font></c:if>
	                                </td>
	                                <td>
	                                	<jsp:useBean id="now" class="java.util.Date"/>
	                                	<c:if test="${ec.validDate.time - now.time >= 0}"><font color="green"><fmt:formatDate value="${ec.validDate}" pattern="yyyy-MM-dd"/></font></c:if>
	                                	<c:if test="${ec.validDate.time - now.time < 0}"><font color="red"><fmt:formatDate value="${ec.validDate}" pattern="yyyy-MM-dd"/></font></c:if>
	                                </td>
	                                <td>
	                                	<a href="<%=path%>/plat/toModifyCourierCompanyPage.do?excoId=${ec.excoId}">修改</a>&nbsp;|&nbsp;<a href="<%=path%>/plat/deleteCourierCompany.do?excoId=${ec.excoId}" onclick="return confirm('是否确认删除');">删除</a>
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
