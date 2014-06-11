package cn.com.xb.inter.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.inter.domain.request.PastDueInfoWarpper;
import cn.com.xb.inter.domain.response.PastDueInfoResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.util.Global;
import cn.com.xb.util.XstreamUtil;

public class XBProcessPastDueServerImpl implements XBProcessServer {

	/**
	 * 开箱逾期信息发送 [物箱 ---> 平台]
	 */
	private static Log log = LogFactory.getLog(XBProcessPastDueServerImpl.class);
	
	/**
	 * @deprecated
	 */
	public String process(String message) throws Exception {
		PastDueInfoWarpper pastDue = null;
		PastDueInfoResult result = new PastDueInfoResult();
		try {
			pastDue = (PastDueInfoWarpper) XstreamUtil.JETTSON2JavaBean(message, PastDueInfoWarpper.class);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			result.setResultStatus(Global.XB_INTER_FAIL);//申请开箱状态：1，逾期费用已交，可开箱；2，费用不够，开箱失败
			result.setErrorMsg("系统异常，"+e.getMessage());
			String json = XstreamUtil.javaBean2JETTSON(result, PastDueInfoResult.class);
			return json;
		}
		//成功
		result.setResultStatus(Global.XB_INTER_SUCCESS);
		String json = XstreamUtil.javaBean2JETTSON(result, PastDueInfoResult.class);
		log.info(json);
		return json;
	}

}
