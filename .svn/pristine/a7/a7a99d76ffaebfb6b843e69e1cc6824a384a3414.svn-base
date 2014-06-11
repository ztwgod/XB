package cn.com.xb.inter.service.impl;

import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.http.comet.TomcatHttpServlet;
import cn.com.xb.inter.domain.response.DepositUnpackInfoResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.util.XstreamUtil;

public class XBProcessOpenBoxServerImpl implements XBProcessServer{

	/**
	 * 开箱结果反馈
	 * @deprecated
	 */
	public String process(String message) throws Exception {
		DepositUnpackInfoResult deposit = (DepositUnpackInfoResult) XstreamUtil.JETTSON2JavaBean(message,DepositUnpackInfoResult.class);
		if(deposit.getResultStatus()==1){ //开箱成功！
			TomcatHttpServlet.removeResultMaps(deposit.getGuiSequenceNumber());
		}else{//开箱失败
			ResponseText resText = TomcatHttpServlet.getResultMapsValue(deposit.getGuiSequenceNumber());
			resText.setResult(1);
			TomcatHttpServlet.put(resText);
		}
		return null;
	}
}
