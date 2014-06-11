<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <title>XunBao讯宝-门户子系统</title>
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <style type="text/css">
		*{margin:0;padding:0;list-style-type:none;}
		a,img{border:0;}
		a,a:visited{color:#5e5e5e; text-decoration:none;}
		a:hover{color:#333;text-decoration:underline;}
		body{font:12px/180% Arial,Lucida,Verdana,"宋体",Helvetica,sans-serif;color:#333;background:#fff;}
		.navTitle{height:70px;background-position:0 -138px;background-repeat:repeat-x;position:relative;z-index:9; background-color: #F9F9F9;}
		/* navbox */
		.navbox,.nav li,.nav li.current a,.nav li.selected a span,.nav li a.selected,.nav li a.selected span{background:url(../images/portal/headerbg.png) no-repeat;}
		.navbox{height:39px;background-position:0 -138px;background-repeat:repeat-x;position:relative;z-index:100;}
		.nav{width:960px;margin:0 auto;}
		.nav li{float:left;height:39px;background-position:100% -99px;padding:0 3px 0 2px;position:relative;}
		.nav li.last{background:none;}
		.nav li a{float:left;display:block;padding:0 0 0 4px;height:39px;overflow:hidden;}
		.nav li a span{float:left;display:block;padding:0 4px 0 0;line-height:39px;font-size:14px;color:#fff;font-weight:800;cursor:pointer;width:142px;text-align:center;}
		.nav li.selected a,.nav li a.selected{background-position:0 -60px;text-decoration:none;}
		.nav li.selected a span,.nav li a.selected span{background-position:100% -60px;color:#ff7e00;}
		.nav li.selected .submenu{display:block;}
		.nav li .submenu{display:none;position:absolute;top:39px;left:6px;}
		.nav li .submenu{border-style:solid;border-width:0px 1px 1px 1px;border-color:#ddd;padding:0 5px 5px 5px;width:132px;background:#fff;}
		.nav li .submenu{-moz-border-radius:0 0 3px 3px;-webkit-border-radius:0 0 3px 3px;border-radius:0 0 3px 3px;-moz-box-shadow:0 5px 5px #D3D3D3;-webkit-box-shadow:0 5px 5px #D3D3D3;box-shadow:0 5px 5px #D3D3D3;}
		.nav li .submenu li{float:none;padding:0;background:none;height:auto;border-bottom:dotted 1px #BEBEBE;}
		.nav li .submenu li.last{border:none;}
		.nav li .submenu li a{float:none;padding:0;text-align:center;height:28px;line-height:28px;background:none;}
		.nav li .submenu li a:hover{background:#ddd;font-weight:800;}
		.top a{
			color: #999999;
		}
		.top span{
			color: #999999;
			padding-left: 5px;
			padding-right: 5px;		
		}
</style>
<script type="text/javascript">
function dropMenu(obj){
	$(obj).each(function(){
		var theSpan = $(this);
		var theMenu = theSpan.find(".submenu");
		var tarHeight = theMenu.height();
		theMenu.css({height:0,opacity:0});
		theSpan.hover(
			function(){
				$(this).addClass("selected");
				theMenu.stop().show().animate({height:tarHeight,opacity:1},400);
			},
			function(){
				$(this).removeClass("selected");
				theMenu.stop().animate({height:0,opacity:0},400,function(){
					$(this).css({display:"none"});
				});
			}
		);
	});
}
$(document).ready(function(){	
	dropMenu(".drop-menu-effect");
});

function home(){
	document.location.href="<%=path%>/portal/index.jsp";
}

</script> 
</head>
<body>
	<div class="navTitle">
	<input type="hidden" value="<%=path%>" id="_root" name="_root" />
    <div style="margin-left: 260px;float: left;padding-top: 20px;cursor: pointer;"><img title="首页" onclick="home();" class="home_logo" src="<%=path%>/images/portal/logo.png" alt="网站logo" /></div>
    <div class="top" style="text-align: right; margin-right: 60px; padding: 15px;">    	
    		<c:if test="${null != PORTAL_USER_SESSION}">
    			欢迎：${PORTAL_USER_SESSION.chName}&nbsp;&nbsp;<a href="<%=path%>/portal/portalLogout.do" >退出登陆</a>
    		</c:if>    		
    		<c:forEach items="${PORTAL_MODULE}" var="b">
    			<c:if test="${b.moduleType==3 and b.moduleLevel==2}">
    				<a <c:if test="${null!=b.moduleLink}"> href="<%=path%>${b.moduleLink}" </c:if>>${b.moduleName}</a>&nbsp;
    				
    			</c:if>
    		</c:forEach>
    	</div>
	</div>
   <div class="navbox">
	<div class="nav">
		<ul class="clearfix">
		
			<c:forEach items="${PORTAL_MODULE}" var="m">
				<c:if test="${m.moduleType==2 and m.moduleLevel==2}">
					<li class="drop-menu-effect">
						<!-- 主菜单 --> 
						<a  <c:if test="${null!=m.moduleLink and ''!= m.moduleLink}"> href="<%=path%>${m.moduleLink}" </c:if> ><span>${m.moduleName}</span></a>
						<!-- 子菜单 -->
						<ul class="submenu">
							<c:forEach items="${PORTAL_MODULE}" var="c">
								<c:if test="${c.parentMId eq m.moduleId and c.moduleLevel==3}">
									<li><a <c:if test="${null!=c.moduleLink and ''!= c.moduleLink}"> href="<%=path%>${c.moduleLink}" </c:if>>${c.moduleName}</a></li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
				</c:if>
			</c:forEach>
		
			<!-- 
		 	<li class="drop-menu-effect">
				<a href="index.jsp"><span>网站首页</span></a>
			</li>
			<li class="drop-menu-effect">
				<a  href="#"><span>解决方案</span></a>
				<ul class="submenu">
					<li><a href="#">白皮书</a></li>
					<li><a href="#">解决方案介绍</a></li>
				</ul>
			</li>
			<li class="drop-menu-effect">
				<a  href="#"><span>技术支持</span></a>	
				<ul class="submenu">
					<li><a href="#">使用帮助</a></li>
				</ul>
			</li>
			<li class="drop-menu-effect">
				<a href="#"><span>关于讯宝</span></a>
				<ul class="submenu">
					<li><a href="#">公司新闻</a></li>
					<li><a href="#">业界新闻</a></li>
					<li><a href="#">关于我们</a></li>
				</ul>
			</li>
			
			<li class="drop-menu-effect">
				<a  href="#"><span>服务</span></a>	
				<ul class="submenu">
					<li><a href="<%=path%>/portal/loadMap.do">物箱查询</a></li>
					<li><a href="loadOrder.jsp">订单查询</a></li>
				</ul>
			</li>
			
			<li class="drop-menu-effect">
				<a href="#"><span>个人管理</span></a>
				<ul class="submenu">
					<li><a href="<%=path%>/portal/getUserInfo.do">个人信息</a></li>
					<li><a href="<%=path%>/portal/toUpdatePassword.do">修改密码</a></li>
					<li><a href="<%=path%>/portal/toUdpateUserInfo.do">修改基本信息</a></li>
				</ul>
			</li>
			 -->
		</ul>
	</div>
</div>
</body>
</html>