<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-物箱管理</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />	
	<link href="<%=path%>/css/plat/rightMenu.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/plat/tipswindown.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/plat/box.css" rel="stylesheet" type="text/css"/>
	
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>    
	<script src="<%=path%>/js/plat/tipswindown.js" type="text/javascript"></script>
	<script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/rightMenu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/box.js" type="text/javascript"></script>
</head>
<body>
		<input type="hidden" id="ssId" name="ssId" value="${stor.ssId}" />
		<input type="hidden" id="boxId" name="boxId" />
		<input type="hidden" id="tranNO" name="tranNO" />
		<input type="hidden" id="transType" name="transType"/>
		
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                    <!-- 
                    	 <li onclick="javascript:document.location.href='<%=path%>/plat/listBox.do'"><a>物箱维护</a></li>  -->
                        <li  class="current"><a>物箱管理</a></li>
                    </ul>
                </div>       
                
                <div class="demo" style="margin-top: 5px;">
						<ul class="clearfix">
							<li>物箱管理<em></em><i></i></li>
							<li>物箱维护<em></em><i></i></li>
							<li class="current">物箱GUI<em></em><i></i></li>
						</ul>
					</div>
					
				<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、平台物箱GUI操作界面。<br />
         						2、箱子状态说明：<img src="<%=path%>/images/plat/colorTip.jpg" style="vertical-align: middle;"/><br />
         						3、主控柜状态说明：<img src="<%=path%>/images/plat/colorTip2.jpg" style="vertical-align: middle;"/>
         					</div>
         		 	</fieldset>	
            </div>
            
            <div class="box-main">
	            <!-- box start -->
	           	<div class="box-title">物箱GUI</div>
	           	<div class="box-content">
		            <c:if test="${boxHTML eq ''}">
		            	<font color="red" style="font-size: 14px;">当前物箱还未与服务器同步，暂时未查询到物箱相关信息，请稍后同步后重试。</font>
		            </c:if>
		            <c:if test="${not(boxHTML eq '')}">
		            	 ${boxHTML}
		            </c:if>
		            <!-- end -->
	            </div>
	           <div class="clear"></div>
	           <br />              
	    	</div>
            
        </div>
    <div id="rightMenu">
    <ul>
        <li id="syn">
            	同步
            <ul>
                <li class="nav" value="1">同步物箱信息</li>
            </ul>
        </li>
		
        <li id="config">
            	配置
            <ul>
                <li class="nav" value="2">设置收件快递员组</li>
                <li class="nav" value="3">设置投件快递员组</li>
                <li class="nav" value="4">设置维护员</li>
            </ul>
        </li>
		
		<li id="search">
            	查询
            <ul>
                <li class="nav" value="5">物箱状态</li>
                <li class="nav" value="6">外围设备状态</li>
				<li class="nav" value="7">箱子状态</li>
            </ul>
        </li>
		
		<li id="operate">
            	操作
            <ul>
                <li class="nav" value="8">开箱</li>
                <li class="nav" value="9">维修密码发送</li>
                <li class="nav" value="10">开箱密码重发</li>
            </ul>
        </li>
    </ul>
</div>
</body>
<script type="text/javascript">
var iFramHeight = document.documentElement.scrollHeight;
var obj = parent.document.getElementById("iFrame");
obj.height = 1140;
</script>
</html>
