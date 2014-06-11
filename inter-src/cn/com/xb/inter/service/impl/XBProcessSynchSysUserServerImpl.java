package cn.com.xb.inter.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.daox.ISysUserDaox;
import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.http.comet.TomcatHttpServlet;
import cn.com.xb.inter.domain.ISysUserAuthorityInfo;
import cn.com.xb.inter.domain.ISysUserCardInfo;
import cn.com.xb.inter.domain.ISysUserInfo;
import cn.com.xb.inter.domain.request.SynchSysUserWrapper;
import cn.com.xb.inter.domain.response.SynchSysUserResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.service.OperationLogService;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.XstreamUtil;

public class XBProcessSynchSysUserServerImpl implements XBProcessServer {
	
	private ISysUserDaox sysUserDaox;
	private StoragestationaService storagestationaService;
	private OperationLogService operationLogService;
	private static Log log = LogFactory.getLog(XBProcessSynchSysUserServerImpl.class);

	public void setStoragestationaService(
			StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}

	public void setSysUserDaox(ISysUserDaox sysUserDaox) {
		this.sysUserDaox = sysUserDaox;
	}
	public void setOperationLogService(OperationLogService operationLogService)
	{
		this.operationLogService = operationLogService;
	}



	/**
	 * 维护人员信息同步
	 */
	
	@Override
	public String process(String message) throws Exception {
		SynchSysUserWrapper wrapper = null;
		SynchSysUserResult synchResult = new SynchSysUserResult();

		// 处理日志信息
		OperationLog oLog = new OperationLog();
		oLog.setLogId(KeyHelper.creatKey());
		oLog.setSysPlatType(2);
		oLog.setOperationType(27);	// 操作类型
		oLog.setOperationUserId(Global.SYNC_OP_USER_ID);	// sync同步
		oLog.setOperationContent("维护人员信息同步，相关参数："+message);
		oLog.setOperationTime(new Timestamp(new Date().getTime()));
		
		try {
			wrapper = (SynchSysUserWrapper) XstreamUtil.JETTSON2JavaBean(message, SynchSysUserWrapper.class);
			
			try {
				oLog.setSsId(storagestationaService.getSSIdBySSCode(wrapper.getStorageStationId()));
			} catch (Exception e) {
				
				ResponseText resText = TomcatHttpServlet.getResultMapsValue(wrapper.getGuiSequenceNumber());
				if(null!=resText){
					resText.setResult(1);
					TomcatHttpServlet.put(resText);
				}
				
				log.error(e);
			}
			
			Storagestationx storagestationx = storagestationaService.getStoragestationxBySSCode(wrapper.getStorageStationId());
			if(null==storagestationx){//平台拒绝同步，物箱不存在
				synchResult.setSequenceNumber(wrapper.getSequenceNumber());
				synchResult.setStorageStationId(wrapper.getStorageStationId());
				synchResult.setResultStatus(Global.XB_INTER_FAIL);
				synchResult.setErrorMsg("物箱在平台不存在。");
				String jsonResult = XstreamUtil.javaBean2JETTSON(synchResult, SynchSysUserResult.class);
				log.info(jsonResult);
				
				oLog.setOperationResult("同步失败，失败信息："+jsonResult);
				operationLogService.addOperationLogInfo(oLog);
				
				ResponseText resText = TomcatHttpServlet.getResultMapsValue(wrapper.getGuiSequenceNumber());
				if(null!=resText){
					resText.setResult(1);
					TomcatHttpServlet.put(resText);
				}
				
				return jsonResult;
			}
			String json = this.syncnSysUser(wrapper,storagestationx.getSsId());
			//operationLogService.addOperationLogInfo(oLog);
			
			oLog.setOperationResult("同步成功，信息："+json);
			operationLogService.addOperationLogInfo(oLog);
			
			//移除记录
			TomcatHttpServlet.removeResultMaps(wrapper.getGuiSequenceNumber());
			
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			synchResult.setResultStatus(Global.XB_INTER_FAIL);
			synchResult.setErrorMsg("系统异常，"+e.getMessage());
			synchResult.setSequenceNumber(wrapper.getSequenceNumber());
			synchResult.setStorageStationId(wrapper.getStorageStationId());
			String jsonResult = XstreamUtil.javaBean2JETTSON(synchResult, SynchSysUserResult.class);

			oLog.setOperationResult("同步失败，失败信息："+jsonResult);
			operationLogService.addOperationLogInfo(oLog);
			
			ResponseText resText = TomcatHttpServlet.getResultMapsValue(wrapper.getGuiSequenceNumber());
			if(null!=resText){
				resText.setResult(1);
				TomcatHttpServlet.put(resText);
			}
			
			return jsonResult;
		}
	}
	
	/**
	 * 获取同步信息
	 * @param ssId
	 * @return
	 */
	private String syncnSysUser(SynchSysUserWrapper wrapper,String ssId) throws Exception{
		List<ISysUserAuthorityInfo> authorityInfos = sysUserDaox.getSysUserAuthorityInfos(ssId);
		SynchSysUserResult result = new SynchSysUserResult();
		result.setSysUserAuthorityInfos(authorityInfos);
		result.setGuiSequenceNumber(wrapper.getGuiSequenceNumber());
		result.setResultStatus(Global.XB_INTER_SUCCESS);
		result.setSequenceNumber(wrapper.getSequenceNumber());
		result.setStorageStationId(wrapper.getStorageStationId());
		
		List<Class> classs = new ArrayList<Class>();
		classs.add(SynchSysUserResult.class);
		classs.add(ISysUserAuthorityInfo.class);
		classs.add(ISysUserCardInfo.class);
		classs.add(ISysUserInfo.class);
		String message = XstreamUtil.javaBean2JETTSON(result, classs);
		return message;
	}
	
}
