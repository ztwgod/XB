package cn.com.xb.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringTool {

	public static Object getBean(HttpServletRequest request,String beanName){
		ServletContext servletContext = request.getSession().getServletContext();    
	    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	    //Object object = (Object)ctx.getBean(beanName);
	    return ctx.getBean(beanName);
	}
	
}
