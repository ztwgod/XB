<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
	<HEAD>
		<TITLE>讯宝-平台登陆</TITLE>
		<LINK href="<%=path%>/css/plat/User_Login.css" type=text/css rel=stylesheet>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		
		<script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    	<script src="<%=path%>/js/jquery.cookie.js" type="text/javascript"></script>		
		<script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    	<script src="<%=path%>/js/plat/login.js" type="text/javascript"></script>
	</HEAD>
	<BODY id=userlogin_body>
		<DIV>
			<input type="hidden" id="_root" name="_root" value="<%=path%>" />
		</DIV>

		<DIV id=user_login>
			<DL>
				<DD id=user_top>
					<UL>
						<LI class=user_top_l></LI>
						<LI class=user_top_c></LI>
						<LI class=user_top_r></LI>
					</UL>
					<DD id=user_main>
					<form action="<%=path%>/plat/doPlatLogin.do" id="frm" name="frm">
						<UL>
							<LI class=user_main_l></LI>
							<LI class=user_main_c>
								<DIV class=user_main_box>
									<UL>
										<LI class=user_main_text>
											用户名：
										</LI>
										<LI class=user_main_input>
											<INPUT style="height: 23px;"  id="TxtUserName"
												maxLength="20" name="TxtUserName" value="${user.userAccount}">
										</LI>
									</UL>
									<UL>
										<LI class=user_main_text>
											密码：
										</LI>
										<LI class=user_main_input>
											<INPUT id="TxtPassword" style="height: 23px;"
												type="password" name="TxtPassword" />
										</LI>
									</UL>
									<UL>
										<LI class=user_main_text>
											验证码：
										</LI>
										<LI class=user_main_input>
											<INPUT style="height: 23px;width: 40px;margin-left: 2px;" maxlength="4" id="TxtYZM" type="text" name="TxtYZM" />
											<span style="margin-left: 30px;padding-top: 5px;"><img  name="img" id="img" border="0" alt="校验码" src="<%=path%>/plat/image.jsp"/></span>
											<span class="thc" style="font-size: 12px;text-decoration: none;cursor: pointer;color: blue;" onclick="changeImage();" title="点击获取校验码">看不清楚?</span>
										</LI>
									</UL>
									<ul>
										<li style="width: 60px;">&nbsp;</li>
										<li><font style="color: red;font-size: 12px;">${message}</font></li>
									</ul>
								</DIV>
							</LI>
							<LI class=user_main_r>
								<INPUT class="IbtnEnterCssClass" id="IbtnEnter"	 onclick='doLogin();' type="button" src="<%=path%>/images/plat/user_botton.gif" name="IbtnEnter">
							</LI>
						</UL>
					</form>
				
			<DD id=user_bottom>
				<UL>
					<LI class=user_bottom_l></LI>
					<LI class=user_bottom_c>
						<SPAN style="MARGIN-TOP: 40px"></SPAN>
					</LI>
					<LI class=user_bottom_r></LI>
				</UL>
			</DD>
				
			</DL>
		</DIV>
		<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN>
		<SPAN id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN>
		<SPAN id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
		<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>
		<DIV></DIV>
		</FORM>
	</BODY>
<script type="text/javascript">
jQuery.cookie("showMenu", null);
</script>
</HTML>
