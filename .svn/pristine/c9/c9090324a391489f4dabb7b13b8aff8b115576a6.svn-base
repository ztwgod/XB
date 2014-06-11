package cn.com.xb.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.com.xb.domain.base.Module;
import cn.com.xb.domain.base.SnapVerifyCode;
import cn.com.xb.domain.base.UserSession;

public class SessionManger {

	private final static String PORTAL_USER = "PORTAL_USER_SESSION"; // 登陆用户
	private final static String PLAT_MODULE = "PLAT_MODULE";// 菜单
	private final static String PORTAL_MODULE = "PORTAL_MODULE";// 菜单
	private final static String CODE = "CODE";// 验证码
	private final static String LOGIN_YZM = "LOGIN_YZM"; //登陆验证码
	private final static String PLAT_USER = "PLAT_USER_SESSION"; //登陆用户
	
	public static void updatePortalUserSession(HttpServletRequest request,UserSession userSession) {
		request.getSession().setAttribute(PORTAL_USER, userSession);
	}
	
	public static void updatePlatUserSession(HttpServletRequest request,UserSession userSession) {
		request.getSession().setAttribute(PLAT_USER, userSession);
	}

	public static void updatePlatModuleSession(HttpServletRequest request,
			List<Module> modules) {
		request.getSession().setAttribute(PLAT_MODULE, modules);
	}
	
	public static void updatePortalModuleSession(HttpServletRequest request,
			List<Module> modules) {
		request.getSession().setAttribute(PORTAL_MODULE, modules);
	}

	public static void updateCodeSession(HttpServletRequest request,
			SnapVerifyCode snapVerifyCode) {
		request.getSession().setAttribute(CODE, snapVerifyCode);
	}
	
	public static void updateYZMSession(HttpServletRequest request,String yzm) {
		request.getSession().setAttribute(LOGIN_YZM, yzm);
	}
	
	public static UserSession loadPlatUserSession(HttpServletRequest request) {
		UserSession user = null;
		if (null != request.getSession().getAttribute(PLAT_USER)) {
			user = (UserSession) request.getSession().getAttribute(PLAT_USER);
		}
		return user;
	}
	
	public static UserSession loadPortalUserSession(HttpServletRequest request) {
		UserSession user = null;
		if (null != request.getSession().getAttribute(PORTAL_USER)) {
			user = (UserSession) request.getSession().getAttribute(PORTAL_USER);
		}
		return user;
	}

	public static List<Module> loadPlatModuleSession(HttpServletRequest request) {
		List<Module> modules = null;
		if (null != request.getSession().getAttribute(PLAT_MODULE)) {
			modules = (List<Module>) request.getSession().getAttribute(PLAT_MODULE);
		}
		return modules;
	}
	
	public static List<Module> loadPortalModuleSession(HttpServletRequest request) {
		List<Module> modules = null;
		if (null != request.getSession().getAttribute(PORTAL_MODULE)) {
			modules = (List<Module>) request.getSession().getAttribute(PORTAL_MODULE);
		}
		return modules;
	}

	public static SnapVerifyCode loadCodeSession(HttpServletRequest request) {
		SnapVerifyCode snapVerifyCode = null;
		if (null != request.getSession().getAttribute(CODE)) {
			snapVerifyCode = (SnapVerifyCode) request.getSession()
					.getAttribute(CODE);
		}
		return snapVerifyCode;
	}
	
	public static String loadYZMSession(HttpServletRequest request) {
		String yzm = null;
		if (null != request.getSession().getAttribute(LOGIN_YZM)) {
			yzm = (String) request.getSession().getAttribute(LOGIN_YZM);
		}
		return yzm;
	}

}
