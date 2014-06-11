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
import cn.com.xb.inter.domain.IDeviceStatus;
import cn.com.xb.inter.domain.SynchBoxInfoObject;
import cn.com.xb.inter.domain.request.StorageStationStatusWrapper;
import cn.com.xb.inter.domain.response.StorageStationStatusResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.service.BoxInfoService;
import cn.com.xb.service.OperationLogService;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.VerifyTool;
import cn.com.xb.util.XstreamUtil;

public class XBProcessSynchStorageStationServerImpl implements XBProcessServer {
	
	private StoragestationaService storagestationaService;
	private BoxInfoService boxInfoService;
	private OperationLogService operationLogService;
	private static Log log = LogFactory.getLog(XBProcessSynchStorageStationServerImpl.class);

	public void setBoxInfoService(BoxInfoService boxInfoService) {
		this.boxInfoService = boxInfoService;
	}

	public void setStoragestationaService(StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}

	public void setOperationLogService(OperationLogService operationLogService)
	{
		this.operationLogService = operationLogService;
	}
	

	/**
	 * 同步箱子状态
	 */
	
	@Override
	public String process(String message) throws Exception {
		List<Class> classs = new ArrayList<Class>();
		classs.add(StorageStationStatusWrapper.class);
		classs.add(IDeviceStatus.class);
		StorageStationStatusWrapper storageStationStatusWrapper = null;
		StorageStationStatusResult result = new StorageStationStatusResult();

		// 处理日志信息
		OperationLog oLog = new OperationLog();
		oLog.setLogId(KeyHelper.creatKey());
		oLog.setSysPlatType(2);
		oLog.setOperationType(28);	// 操作类型
		oLog.setOperationUserId(Global.SYNC_OP_USER_ID);	// sync同步
		oLog.setOperationContent("同步物箱状态，相关参数："+message);
		oLog.setOperationTime(new Timestamp(new Date().getTime()));
		
		
		try {
			storageStationStatusWrapper = (StorageStationStatusWrapper) XstreamUtil.JETTSON2JavaBean(message, classs);
			
			try {
				oLog.setSsId(storagestationaService.getSSIdBySSCode(storageStationStatusWrapper.getStorageStationId()));
			} catch (Exception e) {
				
				ResponseText resText = TomcatHttpServlet.getResultMapsValue(storageStationStatusWrapper.getGuiSequenceNumber());
				if(null!=resText){
					resText.setResult(1);
					TomcatHttpServlet.put(resText);
				}
				log.error(e);
			}
			
			//验证非空
			String eMsg = VerifyTool.verify(storageStationStatusWrapper);
			if(!VerifyTool.isNull(eMsg)){
				result.setResultStatus(Global.XB_INTER_FAIL);
				result.setErrorMsg(eMsg);
				String resultJson = XstreamUtil.javaBean2JETTSON(result, StorageStationStatusResult.class);
				return resultJson;
			}
			
			Storagestationx storagestationx = storagestationaService.getStoragestationxBySSCode(storageStationStatusWrapper.getStorageStationId());
			if(null==storagestationx){
				result.setResultStatus(Global.XB_INTER_FAIL);
				result.setErrorMsg("拒绝同步，物箱在平台不存在。");
				result.setStorageStationId(storageStationStatusWrapper.getStorageStationId());
				result.setSequenceNumber(storageStationStatusWrapper.getSequenceNumber());
				String resultJson = XstreamUtil.javaBean2JETTSON(result, StorageStationStatusResult.class);
				
				oLog.setOperationResult("同步失败，失败信息："+resultJson);
				operationLogService.addOperationLogInfo(oLog);
				
				ResponseText resText = TomcatHttpServlet.getResultMapsValue(storageStationStatusWrapper.getGuiSequenceNumber());
				if(null!=resText){
					resText.setResult(1);
					TomcatHttpServlet.put(resText);
				}
				
				return resultJson;
			}
			this.synchBoxInfo(storageStationStatusWrapper,storagestationx.getSsId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			result.setResultStatus(Global.XB_INTER_FAIL);
			result.setErrorMsg("系统异常，"+e.getMessage());
			result.setStorageStationId(storageStationStatusWrapper.getStorageStationId());
			result.setSequenceNumber(storageStationStatusWrapper.getSequenceNumber());
			String resultJson = XstreamUtil.javaBean2JETTSON(result, StorageStationStatusResult.class);
			
			oLog.setOperationResult("同步失败，失败信息："+resultJson);
			operationLogService.addOperationLogInfo(oLog);
			
			ResponseText resText = TomcatHttpServlet.getResultMapsValue(storageStationStatusWrapper.getGuiSequenceNumber());
			if(null!=resText){
				resText.setResult(1);
				TomcatHttpServlet.put(resText);
			}
			
			return resultJson;
		}
		result.setResultStatus(Global.XB_INTER_SUCCESS); //1：成功 	0：失败
		result.setStorageStationId(storageStationStatusWrapper.getStorageStationId());
		result.setSequenceNumber(storageStationStatusWrapper.getSequenceNumber());
		result.setGuiSequenceNumber(storageStationStatusWrapper.getGuiSequenceNumber());
		
		String resultJson = XstreamUtil.javaBean2JETTSON(result, StorageStationStatusResult.class);
		
		oLog.setOperationResult("同步成功，信息："+resultJson);
		operationLogService.addOperationLogInfo(oLog);
		
		TomcatHttpServlet.removeResultMaps(storageStationStatusWrapper.getGuiSequenceNumber());
		return resultJson;
	}
	
	/**
	 * 箱子信息同步到数据库
	 * @param storageStationStatusWrapper
	 * @throws Exception
	 */
	private void synchBoxInfo(StorageStationStatusWrapper storageStationStatusWrapper,String ssId) throws Exception{
		//获取需要同步的箱子信息
		List<IDeviceStatus> boxLoadStatus = storageStationStatusWrapper.getBoxLoadStatus();
		List<IDeviceStatus> boxRunStatus = storageStationStatusWrapper.getBoxRunStatus();
		List<IDeviceStatus>	cabinetContainerStatus = storageStationStatusWrapper.getCabinetContainerStatus();
		List<IDeviceStatus>	peripheralRunStatus = storageStationStatusWrapper.getPeripheralRunStatus();
		
		SynchBoxInfoObject object = new SynchBoxInfoObject();
		object.setSsId(ssId);
		object.setBoxLoadStatus(boxLoadStatus);
		object.setBoxRunStatus(boxRunStatus);
		object.setCabinetContainerStatus(cabinetContainerStatus);
		object.setPeripheralRunStatus(peripheralRunStatus);
		object.setStorageStationId(storageStationStatusWrapper.getStorageStationId());
		object.setStatus(storageStationStatusWrapper.getStorageStationStatus());
		boxInfoService.synchBoxInfo(object);
	}
	
}
