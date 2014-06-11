package cn.com.xb.inter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.inter.domain.request.CalculateCourierCostsWrapper;
import cn.com.xb.inter.domain.response.CalculateCourierCostsResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.util.Global;
import cn.com.xb.util.XstreamUtil;

public class XBProcessCalculateCourierCostsServerImpl implements
		XBProcessServer {

	/**
	 * 计算快递费用
	 * @deprecated
	 */
	private Log log = LogFactory.getLog(XBProcessCalculateCourierCostsServerImpl.class);
	
	@Override
	public String process(String message) throws Exception {
		List<Class> classs = new ArrayList<Class>();
		classs.add(CalculateCourierCostsWrapper.class);
		
		CalculateCourierCostsWrapper courierCosts = null;
		CalculateCourierCostsResult result = new CalculateCourierCostsResult();
		try {
			courierCosts = (CalculateCourierCostsWrapper) XstreamUtil.JETTSON2JavaBean(message, classs);
			//TODO:获取快递详情
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			
			result.setResultStatus(Global.XB_INTER_FAIL);
			result.setErrorMsg("系统异常，"+e.getMessage());
			result.setSequenceNumber(courierCosts.getSequenceNumber());
			result.setStorageStationId(courierCosts.getStorageStationId());
			String json = XstreamUtil.javaBean2JETTSON(result, CalculateCourierCostsResult.class);
			return json;
		}
		
		result.setCourierCosts(10);
		result.setResultStatus(Global.XB_INTER_SUCCESS);
		result.setSequenceNumber(courierCosts.getSequenceNumber());
		result.setStorageStationId(courierCosts.getStorageStationId());
		String json = XstreamUtil.javaBean2JETTSON(result, CalculateCourierCostsResult.class);
		return json;
	}

}
