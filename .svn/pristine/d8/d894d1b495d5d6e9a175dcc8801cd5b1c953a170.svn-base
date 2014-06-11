package cn.com.xb.inter.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.inter.domain.response.AppOpenBoxResult;
import cn.com.xb.inter.domain.response.RemoteUnpackeInfoResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.inter.util.AppResponseUtil;
import cn.com.xb.util.Global;
import cn.com.xb.util.XstreamUtil;

public class XBProcessAppOpenBoxResultServerImpl implements XBProcessServer {

	private Log log = LogFactory.getLog(XBProcessAppOpenBoxResultServerImpl.class);
	
	/**
	 * APP开箱结果反馈接口
	 */
	@Override
	public String process(String message) throws Exception {
		RemoteUnpackeInfoResult remote = null;
		AppOpenBoxResult result = new AppOpenBoxResult();
		try {
			remote = (RemoteUnpackeInfoResult)XstreamUtil.JETTSON2JavaBean(message, RemoteUnpackeInfoResult.class);
			/*if(remote.getResultStatus()==1){ //开箱成功！
				//TomcatHttpServlet.removeResultMaps(remote.getGuiSequenceNumber());
			}else{//开箱失败
				ResponseText resText = TomcatHttpServlet.getResultMapsValue(remote.getGuiSequenceNumber());
				resText.setResult(1);
				TomcatHttpServlet.put(resText);
			}*/
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			result.setResultStatus(Global.XB_INTER_FAIL);
			result.setErrorMsg("接口数据异常："+e.getMessage());
			String jsonMsg = XstreamUtil.javaBean2JETTSON(result, AppOpenBoxResult.class);
			AppResponseUtil.putValue(remote.getGuiSequenceNumber(), jsonMsg);
			return null;
		}
		result.setErrorMsg(remote.getErrorMsg());
		result.setResultStatus(remote.getResultStatus());
		String jsonMsg = XstreamUtil.javaBean2JETTSON(result, AppOpenBoxResult.class);
		AppResponseUtil.putValue(remote.getGuiSequenceNumber(), jsonMsg);
		return null;
	}

}
