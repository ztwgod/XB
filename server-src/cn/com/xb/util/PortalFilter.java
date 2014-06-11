package cn.com.xb.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.xb.domain.base.Module;
import cn.com.xb.domain.base.UserRole;
import cn.com.xb.domain.base.UserSession;
import cn.com.xb.service.ModuleService;

public class PortalFilter implements Filter {


	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response2 = (HttpServletResponse)response;
		HttpServletRequest request2 = (HttpServletRequest)request;
		
		String requestUrl = request2.getRequestURI();
		if(requestUrl.indexOf("/portal/")!=-1){
			UserSession userSession = SessionManger.loadPortalUserSession(request2);
			if(null==userSession){//当前用户未登陆				
				this.initModule(request2);
			}
		}
		chain.doFilter(request, response);
	}
	
	private void initModule(HttpServletRequest request){
		List<Module> modules = SessionManger.loadPortalModuleSession(request);
		if(null==modules){ //
			ModuleService moduleService = (ModuleService)SpringTool.getBean(request,"moduleService");
			modules = moduleService.loadUserModule(initUser()); //赋予其匿名用户的角色
			SessionManger.updatePortalModuleSession(request, modules);
		}
	}

	/**
	 * 初始化匿名用户
	 * @return
	 */
	private List<UserRole> initUser(){
		List<UserRole> list = new ArrayList<UserRole>();
		UserRole userRole = new UserRole();
		userRole.setRoleId(Global.ROLE_ID_NM);
		list.add(userRole);
		return list;
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
