package cn.com.xb.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.domain.base.StoragestationIntfLog;
import cn.com.xb.inter.domain.response.BaseResponse;
import cn.com.xb.service.InterfaceLogService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.MD5;
import cn.com.xb.util.SpringTool;
import cn.com.xb.util.XstreamUtil;

public abstract class RootServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(RootServlet.class);
	private final static String KEY = "XB_XUNBAO";
	
	public RootServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy();
	}
	
	/**
	 * 子类需要实现该方法做业务逻辑处理
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public abstract void process(HttpServletRequest request,HttpServletResponse response) throws Exception;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		log.info("Request URL:"+request.getRequestURI());
		try {
			String msg = request.getParameter("MSG")==null?"":request.getParameter("MSG"); //报文
			//String sign = request.getParameter("sign")==null?"":request.getParameter("sign"); //签名认证
			String applyCode = request.getParameter("applyCode")==null?"":request.getParameter("applyCode"); //接口ID
			
			// 添加接口日志
			InterfaceLogService ilService = (InterfaceLogService) SpringTool.getBean(request,"interfaceLogService");
			StoragestationIntfLog sil = new StoragestationIntfLog();
			sil.setLogId(KeyHelper.creatKey());
			sil.setLogTime(new Timestamp(new Date().getTime()));
			sil.setMsgContent(msg);
			ilService.addInterfaceLogInfo(applyCode, Global.INTF_UP, sil);
			
			log.info("Request Msg:"+ msg +",applyCode："+applyCode);
			
			if(verifyEmptyParams(msg,applyCode)){
				BaseResponse result = new BaseResponse();
				result.setErrorMsg("请求参数不能为空！");
				result.setResultStatus(Global.XB_INTER_FAIL);
				String jsonResult = XstreamUtil.javaBean2JETTSON(result, BaseResponse.class);
				writeOut(request, response, jsonResult);
				return;
			}
			process(request, response);
			/*if(verifySign(msg)){
				process(request, response);
			}else{
				BaseResponse result = new BaseResponse();
				String jsonResult = XstreamUtil.javaBean2JETTSON(result, BaseResponse.class);
				writeOut(response, jsonResult);
				return;
			}*/
		} catch (Exception e) {
			BaseResponse result = new BaseResponse();
			result.setErrorMsg("接口异常！"+e.getMessage());
			result.setResultStatus(Global.XB_INTER_FAIL);
			String jsonResult = XstreamUtil.javaBean2JETTSON(result, BaseResponse.class);
			writeOut(request, response, jsonResult);
			log.error(e);
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 参数是否为空
	 * @param msg
	 * @param sign
	 * @param applyCode
	 * @return
	 */
	private boolean verifyEmptyParams(String msg,/*String sign,*/String applyCode){
		boolean flag = false;
		if("".equals(msg)){
			flag = true;
		}/*else if("".equals(sign)){
			flag = true;
		}*/else if("".equals(applyCode)){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 签名验证
	 * @param msg
	 * @param sign
	 * @return
	 */
	/*private boolean verifySign(String msg,String sign){
		String signString = MD5.sign(msg.trim(),KEY);
		if(sign.equals(signString)){
			return true;
		}else{
			return false;
		}
		return true;
	}*/

	
	public void init() throws ServletException {
		
	}
	
	/** 输出到客户端
	 * @param response
	 * @param result
	 */
	protected void writeOut(HttpServletRequest request, HttpServletResponse response,String result) {
		try {
			// 添加接口日志
			InterfaceLogService ilService = (InterfaceLogService) SpringTool.getBean(request,"interfaceLogService");
			StoragestationIntfLog sil = new StoragestationIntfLog();
			sil.setLogId(KeyHelper.creatKey());
			sil.setLogTime(new Timestamp(new Date().getTime()));
			sil.setMsgContent(result);
			ilService.addInterfaceLogInfo(request.getParameter("applyCode")==null?"":request.getParameter("applyCode"), Global.INTF_DOWN, sil);
			
			ServletOutputStream out = response.getOutputStream();
			log.info("Response: "+result);
			out.write(result.getBytes("UTF-8"));
			out.flush();
		} catch (Exception e) {
			log.error("", e);
		}
	}
}
