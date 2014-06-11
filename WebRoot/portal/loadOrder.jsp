<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <title>XB讯宝</title>
    
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <!-- 导航代码开始 -->
    <jsp:include page="nav.jsp"></jsp:include>
	<!--代码结束 -->
	
	
    <div style="margin:0 auto;width: 980px; font-size:12px; cursor:pointer; margin-top:5px;">
      
    </div>
   
	 <div style="margin:0 auto; margin-top:30px;border:1px solid #CCC; width:980px;">     
	 <form id="frm" name="frm" action="<%=path%>/portal/loadOrderList.do" method="post">
        <table style="margin-left:300px;font-size:14px;">
            <tr>
            	<td height="40">订单号：</td>
                <td align="left"><input type="text" id="orderCode" name="orderCode" style="height:25px;" value="${golp.orderCode }"/> </td>
                <td style="padding-left:40px;">手机号：</td>
                <td align="left"><input type="text" id="mobileNumber" name="mobileNumber" style="height:25px;" value="${golp.mobileNumber }"/> </td>
            </tr>          
            <tr>
            	<td colspan="4" align="right" ><input style="height:30px; width:60px;" type="submit" id="do_search" name="searchBut" value="查询" /> </td>
            </tr>
        </table>
     </form>
     <div style="text-align:left; border:1px solid #CCC; padding:10px; margin:5px 10px 5px 10px; font-size:13px; margin-bottom:5px;">
        <table border="0" bgcolor="#CCC" cellpadding="1" cellspacing="1" width="100%">
        <c:forEach items="${ows}" var="ow" varStatus="indX">
        <tbody>
        	<c:if test="${indX.count != 1 }"><tr><td height="7" colspan="6" bgcolor="#FFF"></td></tr></c:if>
        	<tr>
        		<td bgcolor="#e6e6e6" colspan="6"><span style="padding-right: 25px;">交易订单编号：${ow.transCode }</span><span style="padding-right: 25px;">变更时间：<fmt:formatDate value="${not empty ow.lastModifyTime ? ow.lastModifyTime : ow.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span><span style="padding-right: 25px;">订单类型：${ow.transTypeShow }</span><span style="padding-right: 25px;">当前状态：${ow.transStatusShow }</span></td>
        	</tr>
        	<c:forEach items="${ow.tadws}" var="tadw">
        	<tr>
        		<td bgcolor="#FFF" width="150">&nbsp;于 <fmt:formatDate value="${tadw.actionTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        		<td bgcolor="#FFF">&nbsp;
        			<c:if test="${tadw.transActionType eq 1}">
              			<b title="联系方式: ${tadw.actionerMobileNum }"><u>${PORTAL_USER_SESSION.userId eq tadw.actioner ? "您" : tadw.actionerName }</u></b>成功投入寄件快件
              		</c:if>
              		<c:if test="${tadw.transActionType eq 2}">
              			快递员<b title="联系方式: ${tadw.actionerMobileNum }"><u>${tadw.actionerName }</u></b>已成功将快件取走
              		</c:if>
              		<c:if test="${tadw.transActionType eq 3}">
              			快递员<b title="联系方式: ${tadw.actionerMobileNum }"><u>${tadw.actionerName }</u></b>已成功将快件投递进物箱
              		</c:if>
              		<c:if test="${tadw.transActionType eq 4}">
              			<b title="联系方式: ${tadw.actionerMobileNum }"><u>${PORTAL_USER_SESSION.userId eq tadw.actioner ? "您" : tadw.actionerName }</u></b>已成功将快件取走
              		</c:if>
              		<c:if test="${tadw.transActionType eq 5}">
              			<b title="联系方式: ${tadw.actionerMobileNum }"><u>${PORTAL_USER_SESSION.userId eq tadw.actioner ? "您" : tadw.actionerName }</u></b>成功寄存一个快件
              		</c:if>
              		<c:if test="${tadw.transActionType eq 6}">
              			客户<b title="联系方式: ${tadw.actionerMobileNum }"><u>${PORTAL_USER_SESSION.userId eq tadw.actioner ? "您" : tadw.actionerName }</u></b>成功将寄存件取走
              		</c:if>
              		<c:if test="${tadw.transActionType eq 7}">
              			客户<b title="联系方式: ${tadw.actionerMobileNum }"><u>${PORTAL_USER_SESSION.userId eq tadw.actioner ? "您" : tadw.actionerName }</u></b>想寄件，但无空箱
              		</c:if>
              		<c:if test="${tadw.transActionType eq 8}">
              			快递员<b title="联系方式: ${tadw.actionerMobileNum }"><u>${tadw.actionerName }</u></b>想投件，但无空箱
              		</c:if>
              		<c:if test="${tadw.transActionType eq 9}">
              			客户<b title="联系方式: ${tadw.actionerMobileNum }"><u>${PORTAL_USER_SESSION.userId eq tadw.actioner ? "您" : tadw.actionerName }</u></b>想寄存，但无空箱
              		</c:if>
              		<c:if test="${tadw.transActionType eq 10}">
              			快递员<b title="联系方式: ${tadw.actionerMobileNum }"><u>${tadw.actionerName }</u></b>的投件被退件
              		</c:if>
              		<c:if test="${tadw.transActionType eq 11}">
              			客户<b title="联系方式: ${tadw.actionerMobileNum }"><u>${PORTAL_USER_SESSION.userId eq tadw.actioner ? "您" : tadw.actionerName }</u></b>的寄存件被退件
              		</c:if>
              		
              		
              		
              		<c:if test="${not empty tadw.feeProof}">
              			通过<b>${tadw.feeProof.payMethods eq 1 ? "投币" : "优惠劵" }</b>方式付费<b>${tadw.feeProof.amount }</b>元RMB
              		</c:if></td>
        	</tr>
        	</c:forEach>
       	</tbody>
        </c:forEach>
        </table>
        <div id="pager" ></div>
     </div>
   </div>
   
   
   
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
			buttonClickCallback: PageClick });
		//alert("当前第" + pageclickednumber + "页");
		document.getElementById('frm').action = '<%=path%>/portal/loadOrderList.do?pageNum=' + pageclickednumber;
		document.getElementById('do_search').click();
	}
	</script>
</body>
</html>