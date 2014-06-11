package cn.com.xb.inter.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.http.comet.TomcatHttpServlet;
import cn.com.xb.inter.domain.ICourierAuthorityInfo;
import cn.com.xb.inter.domain.ICourierCardInfo;
import cn.com.xb.inter.domain.ICourierInfo;
import cn.com.xb.inter.domain.request.SynchCourierWrapper;
import cn.com.xb.inter.domain.response.SynchCourierResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.service.CourierService;
import cn.com.xb.service.OperationLogService;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.VerifyTool;
import cn.com.xb.util.XstreamUtil;

public class XBProcessSynchCourierServerImpl implements XBProcessServer {

	
	private StoragestationaService storagestationaService;
	private CourierService courierService;
	private OperationLogService operationLogService;
	private static Log log = LogFactory.getLog(XBProcessSynchCourierServerImpl.class);
	
	public void setCourierService(CourierService courierService) {
		this.courierService = courierService;
	}

	public void setStoragestationaService(
			StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}

	public StoragestationaService getStoragestationaService()
	{
		return storagestationaService;
	}

	public void setOperationLogService(OperationLogService operationLogService)
	{
		this.operationLogService = operationLogService;
	}

	/**
	 * 快递员同步信息同步
	 */
	public String process(String message) throws Exception {
		SynchCourierWrapper synchCourierWrapper = null;

		// 处理日志信息
		OperationLog oLog = new OperationLog();
		oLog.setLogId(KeyHelper.creatKey());
		oLog.setSysPlatType(2);
		oLog.setOperationType(29);	// 操作类型
		oLog.setOperationUserId(Global.SYNC_OP_USER_ID);	// sync同步
		oLog.setOperationContent("快递员同步信息同步，相关参数："+message);
		oLog.setOperationTime(new Timestamp(new Date().getTime()));
		
		
		try {
			synchCourierWrapper = (SynchCourierWrapper)XstreamUtil.JETTSON2JavaBean(message,SynchCourierWrapper.class);
			
			try {
				oLog.setSsId(storagestationaService.getSSIdBySSCode(synchCourierWrapper.getStorageStationId()));
			} catch (Exception e) {
				
				ResponseText resText = TomcatHttpServlet.getResultMapsValue(synchCourierWrapper.getGuiSequenceNumber());
				if(null!=resText){
					resText.setResult(1);
					TomcatHttpServlet.put(resText);
				}
				log.error(e);
			}
			
			//验证
			String eMsg = VerifyTool.verify(synchCourierWrapper);
			if(!VerifyTool.isNull(eMsg)){
				SynchCourierResult result = new SynchCourierResult();
				result.setErrorMsg(eMsg);
				result.setResultStatus(Global.XB_INTER_FAIL);
				String json = XstreamUtil.javaBean2JETTSON(result, SynchCourierResult.class);
				return json;
			}
			
			String ssCode = synchCourierWrapper.getStorageStationId();
			//int exePermission = synchCourierWrapper.getExePermissionType();
			Storagestationx storagestationx = storagestationaService.getStoragestationxBySSCode(ssCode);
			if(null==storagestationx){
				SynchCourierResult result = new SynchCourierResult();
				result.setErrorMsg("物箱在平台不存在。");
				result.setResultStatus(Global.XB_INTER_FAIL);
				String json = XstreamUtil.javaBean2JETTSON(result, SynchCourierResult.class);
				
				oLog.setOperationResult("同步失败，失败信息："+json);
				operationLogService.addOperationLogInfo(oLog);
				
				ResponseText resText = TomcatHttpServlet.getResultMapsValue(synchCourierWrapper.getGuiSequenceNumber());
				if(null!=resText){
					resText.setResult(1);
					TomcatHttpServlet.put(resText);
				}
				
				return json;
			}
			String json = this.synchCourierInfo(storagestationx.getSsId(),synchCourierWrapper);
			
			oLog.setOperationResult("同步成功，信息："+json);
			operationLogService.addOperationLogInfo(oLog);
			
			TomcatHttpServlet.removeResultMaps(synchCourierWrapper.getGuiSequenceNumber());
			
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			SynchCourierResult result = new SynchCourierResult();
			result.setErrorMsg("参数解析异常，"+e.getMessage());
			result.setResultStatus(Global.XB_INTER_FAIL);
			String json = XstreamUtil.javaBean2JETTSON(result, SynchCourierResult.class);
			
			oLog.setOperationResult("同步失败，失败信息："+json);
			operationLogService.addOperationLogInfo(oLog);
			
			ResponseText resText = TomcatHttpServlet.getResultMapsValue(synchCourierWrapper.getGuiSequenceNumber());
			if(null!=resText){
				resText.setResult(1);
				TomcatHttpServlet.put(resText);
			}
			
			return json;
		}
	}
	
	/**
	 * 同步快递员信息
	 * @ssCode 物箱代码
	 * @return
	 * @throws Exception 
	 */
	public String synchCourierInfo(String ssId,SynchCourierWrapper synchCourierWrapper) throws Exception{
		List<ICourierAuthorityInfo> listsAuthorityInfos = courierService.getCourierInfoBySSid(ssId, synchCourierWrapper.getExePermissionType());
		SynchCourierResult result = new SynchCourierResult();
		result.setCourierAuthorityInfos(listsAuthorityInfos);
		result.setSequenceNumber(synchCourierWrapper.getSequenceNumber());
		result.setStorageStationId(synchCourierWrapper.getStorageStationId());
		result.setResultStatus(Global.XB_INTER_SUCCESS);
		result.setGuiSequenceNumber(synchCourierWrapper.getGuiSequenceNumber());
		
		List<Class> classs = new ArrayList<Class>();
		classs.add(ICourierAuthorityInfo.class);
		classs.add(SynchCourierResult.class);
		classs.add(ICourierCardInfo.class);
		classs.add(ICourierInfo.class);
		
		String json = XstreamUtil.javaBean2JETTSON(result, classs);
		log.info(json);
		return json;
	}

}
