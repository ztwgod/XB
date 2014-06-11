package cn.com.xb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.xb.http.comet.TomcatHttpServlet;
import cn.com.xb.inter.domain.request.RemoteUnpackeInfoWarpper;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.inter.util.XBProcessFactory;

public class WeChatServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		String applyCode=request.getParameter("applyCode");
		String msg=request.getParameter("msg");
		if (applyCode==null||msg==null) {
			try {
				response.getWriter().print("请求参数有误");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		//根据applyCode 调用开箱和查询接口
		XBProcessServer xbProcessServer = XBProcessFactory.create(applyCode,request);
		String result=null;
		try {
			//得到处理结果
			result = xbProcessServer.process(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result="查询处理出错！";
			e.printStackTrace();
		}
		//如果是开箱请求 需要发送到物箱
		if (applyCode.equals("16")) {
		String[] arr = TomcatHttpServlet.sendAppOpenBox(result, request);//发送一个开箱请求到指定物箱
		try {
			//返回开箱结果
			response.getWriter().print(arr[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} else {
			try {
				//返回查询结果
				response.getWriter().print(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
