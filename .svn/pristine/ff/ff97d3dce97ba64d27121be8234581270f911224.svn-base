package cn.com.xb.inter.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.daox.ITransactionDaox;
import cn.com.xb.inter.domain.IAppTransactionInfo;
import cn.com.xb.inter.domain.request.GetTransactionListWrapper;
import cn.com.xb.inter.domain.response.GetTransactionListResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.util.Global;
import cn.com.xb.util.VerifyTool;
import cn.com.xb.util.XstreamUtil;

public class XBProcessAppGetTransactionListServerImpl implements XBProcessServer {
	
	private Log log = LogFactory.getLog(XBProcessAppGetTransactionListServerImpl.class);
	private ITransactionDaox transactionDaox;

	public void setTransactionDaox(ITransactionDaox transactionDaox) {
		this.transactionDaox = transactionDaox;
	}

	@Override
	public String process(String message) throws Exception {
		GetTransactionListWrapper trans = null;
		GetTransactionListResult result = new GetTransactionListResult();
		try {
			trans = (GetTransactionListWrapper)XstreamUtil.JETTSON2JavaBean(message, GetTransactionListWrapper.class);
		} catch (Exception e) {
			log.equals(e);
			e.printStackTrace();
			result.setErrorMsg("解析数据异常"+e.getMessage());
			result.setResultStatus(Global.XB_INTER_FAIL);
			String jsonMsg = XstreamUtil.javaBean2JETTSON(result, GetTransactionListResult.class);
			return jsonMsg;
		}
		
		
		//验证数据
		String eMsg = VerifyTool.verify(trans);
		if(!VerifyTool.isNull(eMsg)){
			result.setErrorMsg(eMsg);
			result.setResultStatus(Global.XB_INTER_FAIL);
			String jsonMsg = XstreamUtil.javaBean2JETTSON(result, GetTransactionListResult.class);
			return jsonMsg;
		}
		
		List<IAppTransactionInfo> appTransactionInfos = transactionDaox.getAppTransactionInfos(trans);
		result.setTransList(appTransactionInfos);
		result.setResultStatus(Global.XB_INTER_SUCCESS);
		String jsonMsg = XstreamUtil.javaBean2JETTSON(result, GetTransactionListResult.class);
		return jsonMsg;
	}
}
