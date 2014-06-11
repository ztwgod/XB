<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-数据业务统计</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
    
     <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script src="<%=path%>/js/calendar.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/setTimer.js" type="text/javascript"></script>
    
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
				pagecount:${page.pageCount}, 
				buttonClickCallback: PageClick 
		}); 
		//alert("当前第" + pageclickednumber + "页");
		document.getElementById('frm').action = '<%=path%>/plat/getStorStatusList.do?pageNo='+pageclickednumber;
		document.getElementById('frm').submit();
	}
	
	
	
	function exportBoxStatusExcel()
	{
		document.getElementById('frm').action = '<%=path%>/plat/exportStorStatusExcel.do';
		document.getElementById('frm').submit();
	}
	</script>
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li  class="current"><a>物箱状态情况</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                    <div class="u-form-wrap"> 
                    
		                <div class="demo">
							<ul class="clearfix">
								<li>业务管理<em></em><i></i></li>
								<li>业务统计<em></em><i></i></li>							
								<li class="current">物箱状态情况<em></em><i></i></li>
							</ul>
						</div>                  
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                       <form id="frm" name="frm" action="<%=path%>/plat/getStorStatusList.do" method="post">
                            <table class="tabSearch">
                                 <tr>
                                    <td align="right">日期：</td>
                                    <td><input type="text" id="startDate" name="startDate" value="${bslp.startDate }" style="border:1px solid #999; width: 80px;" onclick="new Calendar().show(this);" readonly="readonly" />
                                    	&nbsp;至&nbsp;
									<input type="text" id="endDate" name="endDate" value="${bslp.endDate }" style="border:1px solid #999; width: 80px;" onclick="new Calendar().show(this);" readonly="readonly" /></td>
                                    <td align="right">时段：</td>
                                    <td><input type="text" id="startTime" name="startTime" value="${bslp.startTime }" style="width:80px;" readonly="readonly" onclick="_SetTime(this)"/>&nbsp;至&nbsp;
                                    <input type="text" id="endTime" name="endTime" value="${bslp.endTime }" style="width:80px;" onclick="_SetTime(this)" readonly="readonly"/></td>
                                </tr>
                                 
                                 <tr>
                                    <td align="right">物箱代码：</td>
                                    <td><input type="text" id="ssCode" name="ssCode" value="${bslp.ssCode }"/></td>
                                    <td align="right">箱子尺寸类型：</td>
                                    <td>
                                    	<select id="boxType" name="boxType">
                                    		<option value="">请选择</option>
                                    		<c:forEach items="${boxTypes}" var="bt">
                            					<option value="${bt.code}"  <c:if test="${bslp.boxType eq bt.code}">selected="selected"</c:if> >${bt.name}</option>
                                    		</c:forEach>
                                    	</select>
                                    </td>
                                </tr>
                                
                                 <tr>
                                    <td align="right">物箱组：</td>
                                    <td>
                                    	<select id="groupId" name="groupId">
                                    		<option value="">请选择</option>
                                    		<c:forEach items="${storGroup}" var="g">
                            					<option value="${g.groupId}"  <c:if test="${bslp.groupId eq g.groupId}">selected="selected"</c:if> >${g.groupAbb}</option>
                            				</c:forEach>
                                    	</select>
                                    </td>
                                    <td align="right">物箱状态：</td>
                                    <td>
                                    	<select id="boxStatus" name="boxStatus">
                                    		<option value="">请选择</option>
                                    		<c:forEach items="${boxStatuss}" var="bs">
                            					<option value="${bs.code}"  <c:if test="${bslp.boxStatus eq bs.code}">selected="selected"</c:if> >${bs.name}</option>
                                    		</c:forEach>
                                    	</select>
                                    </td>
                                </tr>
                                
                                 <tr>
                                    <td align="right" colspan="3"></td>
                                    <td align="left">
                                    	<button id="do_search" type="submit" class="search" onclick="document.getElementById('frm').action = '<%=path%>/plat/getStorStatusList.do';">查询</button>
                                    	<button id="do_export" type="button" class="search" onclick="exportBoxStatusExcel();">导出Excel</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                        </div>
						
						<table class="u-table">
                            <tr>
                                <th width="20%">
                                   	物箱代码
                                </th>
                                <th width="10%">
                                                                                              箱子编号
                                </th>
                                <th width="10%">
                         	                   箱子尺寸类
                                </th>
                                <th width="10%">
                                   	状态类型
                                </th>
                                <th width="25%">
                                   	起始时间
                                </th>
                                <th>
                                   	终止时间
                                </th>
                            </tr>
                            
                            <c:forEach items="${bsws}" var="bsw">
                             <tr>
                                <td>
                                	${bsw.ssCode }
                                </td>
                                <td>
                                	${bsw.boxIndex }
                                </td>
                                <td>
                                	${bsw.boxSizeShow }
                                </td>
                                <td>
                               		${bsw.boxStatusShow }
                                </td>
                                <td>
                                	<fmt:formatDate value="${bsw.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                	<fmt:formatDate value="${bsw.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            </c:forEach>
                            
                        </table>
                         <div id="pager" ></div>
                    </div>
                </div>
            </div>
        </div>
</body>

</html>
