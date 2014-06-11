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

import cn.com.xb.domain.base.UserSession;

public class PlatFilter implements Filter {

	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response2 = (HttpServletResponse)response;
		HttpServletRequest request2 = (HttpServletRequest)request;
		
		String loginPath = request2.getContextPath()+"/plat/Admin.do";		
		String requestUrl = request2.getRequestURI();
		
		if(requestUrl.indexOf("/plat/")!=-1){//平台请求
			UserSession userSession = SessionManger.loadPlatUserSession(request2);
			if(null==userSession){
				if(!verifyRequest(requestUrl,request2.getContextPath())){
					response2.sendRedirect(loginPath);
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}
	
	private boolean verifyRequest(String requestUrl,String path){
		List<String> list = new ArrayList<String>();
		list.add(path+"/plat/Admin.do");
		list.add(path+"/plat/doPlatLogin.do");
		list.add(path+"/plat/image.jsp");
		list.add(path+"/plat/t_action.jsp");
		list.add(path+"/plat/t.jsp");
		boolean flag = false;
		if(list.contains(requestUrl)){
			flag = true;			
		}
		return flag;
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
