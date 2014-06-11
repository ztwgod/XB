<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-日志列表</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/tipswindown.css" rel="stylesheet" type="text/css" />
    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/calendar.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/setTimer.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/tipswindown.js" type="text/javascript"></script>
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
		document.getElementById('frm').action = '<%=path%>/plat/getOperationLogList.do?pageNum=' + pageclickednumber;
		document.getElementById('frm').submit();
	}
	
	
	function exportOperationLogExcel()
	{
		document.getElementById('frm').action = '<%=path%>/plat/exportOperationLogExcel.do';
		document.getElementById('frm').submit();
	}
	
	
	// 弹出日志详情窗口
	function showLogInfo(obj){
		var root = document.getElementById("_root").value;
		var url = "iframe:"+root+"/plat/getOperationLogDetail.do?opLogId="+obj;
		tipsWindown("显示日志详情",url,"800","500","true","","false","","","false") 
	}
	</script>
</head>
<body>
  
       
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li  class="current"><a>日志列表</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                
                <div id="tab-box">
                    <div class="u-form-wrap">
                    <!--  <div class="m-sub-til" style="padding: 0;"></div> -->       
                    	<input id="_root" name="_root" value="<%=path %>" type="hidden"/>
		                <div class="demo">
							<ul class="clearfix">
								<li>业务管理<em></em><i></i></li>
								<li>日志管理<em></em><i></i></li>							
								<li class="current">日志列表<em></em><i></i></li>
							</ul>
						</div>                  
                       <div class="search-box" style="margin-bottom: 15px; border:#ebebeb solid 1px;">
                       <form id="frm" name="frm" action="<%=path%>/plat/getOperationLogList.do" method="post">
                            <table class="tabSearch">
                                <tr>
                                    <td align="right">日期：</td>
                                    <td><input type="text" id="startDate" name="startDate" value="${golp.startDate }" style="border:1px solid #999; width: 80px;" onclick="new Calendar().show(this);" readonly="readonly" />
                                    	&nbsp;至&nbsp;
									<input type="text" id="endDate" name="endDate" value="${golp.endDate }" style="border:1px solid #999; width: 80px;" onclick="new Calendar().show(this);" readonly="readonly" /></td>
                                    <td align="right">时段：</td>
                                    <td><input type="text" id="startTime" name="startTime" value="${golp.startTime }" style="width:80px;" readonly="readonly" onclick="_SetTime(this)"/>&nbsp;至&nbsp;
                                    <input type="text" id="endTime" name="endTime" value="${golp.endTime }" style="width:80px;" onclick="_SetTime(this)" readonly="readonly"/></td>
                                </tr>
                                 <tr>
                                    <td align="right">物箱代码：</td>
                                    <td><input type="text" id="ssCode" name="ssCode" value="${golp.ssCode }"/></td>
                                    <td align="right">操作者：</td>
                                    <td>
                                    	<input type="text" id="operationUserName" name="operationUserName" value="${golp.operationUserName }"/>
                                    </td>
                                </tr>
                                
                                 <tr>
                                    <td align="right" colspan="3"></td>
                                    
                                    <td align="left">
                                    	<button id="do_search" type="submit" class="search" onclick="document.getElementById('frm').action = '<%=path%>/plat/getOperationLogList.do';">查询</button>
                                    	<button id="do_export" type="button" class="search" onclick="exportOperationLogExcel();">导出Excel</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                        </div>
						
						<table class="u-table">
                            <tr>
                                <th width="10%">
                                   操作平台
                                </th>
                                <th width="15%">
                                    操作类型
                                </th>
                                <th width="10%">
                                    物箱代码
                                </th>
                                <th width="10%">
                                    操作者
                                </th>
                                <th width="18%">
                                    操作时间
                                </th>
                                <th width="37%">
                                    操作内容
                                </th>
                            </tr>
                            <c:forEach items="${olws}" var="olw">
                            <tr>
                                <td>
                                	${olw.sysPlatTypeShow }
                                </td>
                                <td>
                                	${olw.operationTypeShow }
                                </td>
                                <td>
                                	${olw.ssCode }
                                </td>
                                <td>
                                	${olw.operationUserName }
                                </td>
                                <td onclick="showLogInfo('${olw.logId}');">
                                	<a href="#"><fmt:formatDate value="${olw.operationTime}" pattern="yyyy-MM-dd HH:mm:ss"/></a>
                                </td>
                                <td title="${olw.operationContentHtml }">
                                <div style="height: 36px;overflow: hidden;">
                                	<script type="text/javascript">
                                		var countentStr = '${olw.operationContent}';
                                		if(countentStr.length > 40)
                                		{
                                			document.write(countentStr.substring(0,40));
                                		}
                                		else
                                		{
                                			document.write(countentStr);
                                		}
                                	</script>
	 							</div>
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
