package cn.com.xb.inter.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.daox.ITransactionDaox;
import cn.com.xb.inter.domain.request.AppOpenBoxWrapper;
import cn.com.xb.inter.domain.request.RemoteUnpackeInfoWarpper;
import cn.com.xb.inter.domain.response.AppOpenBoxResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.inter.util.AppResponseUtil;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.VerifyTool;
import cn.com.xb.util.XstreamUtil;

public class XBProcessAppOpenBoxServerImpl implements XBProcessServer {

	/**
	 * APP请求开箱
	 */
	private static Log log = LogFactory.getLog(XBProcessAppOpenBoxServerImpl.class); 
	
	private ITransactionDaox transactionDaox;
	
	public void setTransactionDaox(ITransactionDaox transactionDaox) {
		this.transactionDaox = transactionDaox;
	}

	@Override
	public String process(String message) throws Exception {
		AppOpenBoxWrapper appOpenBoxWrapper = null;
		AppOpenBoxResult result = new AppOpenBoxResult();
		try {
			appOpenBoxWrapper = (AppOpenBoxWrapper) XstreamUtil.JETTSON2JavaBean(message, AppOpenBoxWrapper.class);
			
			//验证数据
			String eMsg = VerifyTool.verify(appOpenBoxWrapper);
			if(!VerifyTool.isNull(eMsg)){
				result.setErrorMsg(eMsg);
				result.setResultStatus(Global.XB_INTER_FAIL);
				String json = XstreamUtil.javaBean2JETTSON(result, AppOpenBoxResult.class);
				return json;
			}
			
		} catch (Exception e) {
			log.equals(e);
			e.printStackTrace();
			result.setErrorMsg("请求数据格式错误，"+e.getMessage());
			result.setResultStatus(Global.XB_INTER_FAIL);
			String json = XstreamUtil.javaBean2JETTSON(result, AppOpenBoxResult.class);
			return json;
		}
		RemoteUnpackeInfoWarpper remote = transactionDaox.getAppOpenBoxInfo(appOpenBoxWrapper.getTransId());
		if(null==remote){
			result.setErrorMsg("未查询到物箱交易数据！");
			result.setResultStatus(Global.XB_INTER_FAIL);
			String json = XstreamUtil.javaBean2JETTSON(result, AppOpenBoxResult.class);
			return json;
		}
		
		remote.setUserId(appOpenBoxWrapper.getUserId());
		remote.setRandomNum(appOpenBoxWrapper.getRandomNum());
		String guiSequenceNumber = KeyHelper.creatKey();
		remote.setGuiSequenceNumber(guiSequenceNumber);
		//初始化请求信息
		log.info("guiSequenceNumber:"+guiSequenceNumber);
		AppResponseUtil.putValue(guiSequenceNumber, null);
		
		String json = XstreamUtil.javaBean2JETTSON(remote, RemoteUnpackeInfoWarpper.class);
		log.info(json);
		return json;
	}

}
