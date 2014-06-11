package cn.com.xb.inter.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.org.apache.regexp.internal.recompile;

import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.Cabinet;
import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.domain.base.Peripheral;
import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.domain.base.Storagestation;
import cn.com.xb.domain.base.StoragestationPeripheral;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.http.comet.TomcatHttpServlet;
import cn.com.xb.inter.domain.IBoxInfo;
import cn.com.xb.inter.domain.ICabinetContainer;
import cn.com.xb.inter.domain.IPeripheral;
import cn.com.xb.inter.domain.IStorageStationInfo;
import cn.com.xb.inter.domain.SynchObject;
import cn.com.xb.inter.domain.request.SynchWrapper;
import cn.com.xb.inter.domain.response.SynchResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.service.BoxInfoService;
import cn.com.xb.service.CabinetServer;
import cn.com.xb.service.OperationLogService;
import cn.com.xb.service.PeripheralServer;
import cn.com.xb.service.SsBoxnumLogServer;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.StringUtil;
import cn.com.xb.util.VerifyTool;
import cn.com.xb.util.XstreamUtil;

public class XBProcessSynchServerImpl implements XBProcessServer {

	private Log log = LogFactory.getLog(XBProcessSynchServerImpl.class);
	
	private StoragestationaService storagestationaService;
	private PeripheralServer peripheralServer;
	private BoxInfoService boxInfoService;
	private CabinetServer cabinetServer;
	private OperationLogService operationLogService;
	private SsBoxnumLogServer ssBoxnumLogServer;
	
	public void setSsBoxnumLogServer(SsBoxnumLogServer ssBoxnumLogServer) {
		this.ssBoxnumLogServer = ssBoxnumLogServer;
	}

	public void setCabinetServer(CabinetServer cabinetServer) {
		this.cabinetServer = cabinetServer;
	}

	public void setBoxInfoService(BoxInfoService boxInfoService) {
		this.boxInfoService = boxInfoService;
	}

	public void setPeripheralServer(PeripheralServer peripheralServer) {
		this.peripheralServer = peripheralServer;
	}

	public void setStoragestationaService(
			StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}

	public void setOperationLogService(OperationLogService operationLogService)
	{
		this.operationLogService = operationLogService;
	}

	public String process(String message) throws Exception{
		List<Class> classs = new ArrayList<Class>();
		classs.add(IStorageStationInfo.class);
		classs.add(IPeripheral.class);
		classs.add(ICabinetContainer.class);
		classs.add(IBoxInfo.class);
		classs.add(SynchWrapper.class);
		SynchWrapper synchWrapper = null;

		// 处理日志信息
		OperationLog oLog = new OperationLog();
		oLog.setLogId(KeyHelper.creatKey());
		oLog.setSysPlatType(2);
		oLog.setOperationType(13);	// 操作类型
		oLog.setOperationUserId(Global.SYNC_OP_USER_ID);	// sync同步
		oLog.setOperationContent("同步物箱信息，相关参数："+message);
		oLog.setOperationTime(new Timestamp(new Date().getTime()));
		
		
		try {
			synchWrapper = (SynchWrapper)XstreamUtil.JETTSON2JavaBean(message,classs);
			
			//验证字段的合法性
			String eMsg = VerifyTool.verify(synchWrapper);
			if(!VerifyTool.isNull(eMsg)){
				SynchResult synchResult = new SynchResult();
				synchResult.setErrorMsg(eMsg);
				synchResult.setStorageStationId(synchWrapper.getStorageStationId());
				synchResult.setResultStatus(Global.XB_INTER_FAIL);
				String jsonResult = XstreamUtil.javaBean2JETTSON(synchResult, SynchResult.class);
				
				ResponseText resText = TomcatHttpServlet.getResultMapsValue(synchWrapper.getGuiSequenceNumber());
				if(null!=resText){
					resText.setResult(1);
					TomcatHttpServlet.put(resText);
				}
				return jsonResult;
			}
			
			try {
				oLog.setSsId(storagestationaService.getSSIdBySSCode(synchWrapper.getStorageStationId()));
			} catch (Exception e) {
				
				ResponseText resText = TomcatHttpServlet.getResultMapsValue(synchWrapper.getGuiSequenceNumber());
				if(null!=resText){
					resText.setResult(1);
					TomcatHttpServlet.put(resText);
				}
				log.error(e);
			}
			
			//查询平台是否存在该物箱
			Storagestationx storagestationx = storagestationaService.getStoragestationxBySSCode(synchWrapper.getStorageStationId());
			if(null==storagestationx){//平台拒绝同步，物箱不存在
				SynchResult synchResult = new SynchResult();
				synchResult.setSequenceNumber(synchWrapper.getSequenceNumber());
				synchResult.setStorageStationId(synchWrapper.getStorageStationId());
				synchResult.setSynchStatus(Global.SYN_7);
				synchResult.setResultStatus(Global.XB_INTER_FAIL);
				synchResult.setErrorMsg("拒绝同步，物箱在平台不存在。");
				String jsonResult = XstreamUtil.javaBean2JETTSON(synchResult, SynchResult.class);
				log.info(jsonResult);
				
				oLog.setOperationResult("同步失败，失败信息："+jsonResult);
				operationLogService.addOperationLogInfo(oLog);
				
				ResponseText resText = TomcatHttpServlet.getResultMapsValue(synchWrapper.getGuiSequenceNumber());
				if(null!=resText){
					resText.setResult(1);
					TomcatHttpServlet.put(resText);
				}
				
				return jsonResult;
			}
			this.insertObject(synchWrapper,storagestationx.getSsId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			SynchResult synchResult = new SynchResult();
			synchResult.setSynchStatus(Global.SYN_6);
			synchResult.setErrorMsg("系统异常，"+e.getMessage());
			synchResult.setSequenceNumber(synchWrapper.getSequenceNumber());
			synchResult.setStorageStationId(synchWrapper.getStorageStationId());
			synchResult.setResultStatus(Global.XB_INTER_FAIL);
			String jsonResult = XstreamUtil.javaBean2JETTSON(synchResult, SynchResult.class);
			
			oLog.setOperationResult("同步失败，失败信息："+jsonResult);
			operationLogService.addOperationLogInfo(oLog);
			
			ResponseText resText = TomcatHttpServlet.getResultMapsValue(synchWrapper.getGuiSequenceNumber());
			if(null!=resText){
				resText.setResult(1);
				TomcatHttpServlet.put(resText);
			}
			
			return jsonResult;
		}
		//同步状态 1,注册成功；2,失败、配置错误；3,失败、系统忙；4,失败、操作维护；5,同步成功；6,失败；7,拒绝同步
		SynchResult synchResult = new SynchResult();
		synchResult.setSynchStatus(this.getSynchStatus(synchWrapper.getSynchType()));
		synchResult.setSequenceNumber(synchWrapper.getSequenceNumber());
		synchResult.setStorageStationId(synchWrapper.getStorageStationId());
		synchResult.setGuiSequenceNumber(synchWrapper.getGuiSequenceNumber());
		synchResult.setResultStatus(Global.XB_INTER_SUCCESS);
		
		String jsonResult = XstreamUtil.javaBean2JETTSON(synchResult, SynchResult.class);
		log.info(jsonResult);
		
		oLog.setOperationResult("同步成功，信息："+jsonResult);
		operationLogService.addOperationLogInfo(oLog);
		
		//记录箱子状态变更记录
		ssBoxnumLogServer.insertSSBoxNumLog(oLog.getSsId());
		
		//移除记录
		TomcatHttpServlet.removeResultMaps(synchWrapper.getGuiSequenceNumber());
		return jsonResult;
	}
	
	/**
	 * 根据注册类型获取，同步状态
	 * @param synchType
	 * @return
	 */
	private int getSynchStatus(int synchType){
		int synchStatus = 0;
		//1，注册、新建；2，注册、故障恢复；3，注册、重启；4，注册、其他原因；
		if(synchType==Global.SYN_TYPE_1 || synchType==Global.SYN_TYPE_2|| synchType==Global.SYN_TYPE_3 || synchType == Global.SYN_TYPE_4){ //1，注册、新建
			synchStatus = Global.SYN_1;
		}else if(synchType==Global.SYN_TYPE_5 || synchType==Global.SYN_TYPE_6 || synchType==Global.SYN_TYPE_7 || synchType==Global.SYN_TYPE_8){
			synchStatus = Global.SYN_5;
		}
		return synchStatus;
	}
	
	/**
	 * 是否为注册
	 * @param synchType
	 * @return
	 */
	/*private boolean isRegeister(int synchType){
		if(synchType==Global.SYN_TYPE_1 || synchType==Global.SYN_TYPE_2|| synchType==Global.SYN_TYPE_3 || synchType == Global.SYN_TYPE_4){
			return true;
		}else{
			return false;
		}
	}*/
	
	/**
	 * 同步物箱信息
	 * @param synchWrapper
	 * @param SSId
	 * @throws Exception
	 */
	private void insertObject(SynchWrapper synchWrapper,String SSId) throws Exception{
		IStorageStationInfo iStorageStation = synchWrapper.getStorageStation();
		List<IPeripheral> peripherals = iStorageStation.getPeripherals();
		List<ICabinetContainer>	cabinetContainers = iStorageStation.getCabinetContainers();
		
		Storagestation storagestation = iStorageStation.getStoragestation();
		storagestation.setSsId(SSId);//物箱主键
		storagestation.setSsCode(synchWrapper.getStorageStationId()); //物箱代码
		
		List<Peripheral> perList = new ArrayList<Peripheral>();//外围设备信息
		List<StoragestationPeripheral> storPerList = new ArrayList<StoragestationPeripheral>(); //物箱外围设备中间表
		
		for (IPeripheral iPeripheral : peripherals) {
			Peripheral peripheral = iPeripheral.getPeripheral();
			peripheral.setPeripheralId(KeyHelper.creatKey()); //外围设备ID
			perList.add(peripheral);
			
			StoragestationPeripheral storagestationPeripheral = new StoragestationPeripheral();
			storagestationPeripheral.setPeripheralId(peripheral.getPeripheralId());
			storagestationPeripheral.setSsId(storagestation.getSsId());
			storagestationPeripheral.setRunStatus(peripheral.getStatus());
			storPerList.add(storagestationPeripheral);
		}
		
		List<Cabinet> insertCabinets = new ArrayList<Cabinet>();//需要添加的柜子信息
		List<Cabinet> updateCabinets = new ArrayList<Cabinet>();//需要修改的柜子信息
		
		List<BoxInfo> insertBoxInfos = new ArrayList<BoxInfo>(); //添加：箱子信息
		List<BoxInfo> updateBoxInfos = new ArrayList<BoxInfo>(); //修改：箱子信息
		
		
		Map<String, BoxInfo> boxInfoMaps = boxInfoService.getBoxInfoListBySSId(SSId);//查询箱子列表信息
		Map<String,Cabinet> cabinetMpas = cabinetServer.getCabinetListBySSId(SSId);//柜子信息表
		
		for (ICabinetContainer iCabinetContainer : cabinetContainers) {
			Cabinet cabinet = iCabinetContainer.getCabinet();
			cabinet.setSsId(storagestation.getSsId());
			String _key = cabinet.getSsId()+cabinet.getCabinetCode();
			if(cabinetMpas.containsKey(_key)){
				Cabinet _cabCabinet = cabinetMpas.get(_key);
				cabinet.setCabinetId(_cabCabinet.getCabinetId());
				updateCabinets.add(cabinet); //数据库已经存在需要修改的柜子信息
			}else{
				cabinet.setCabinetId(KeyHelper.creatKey()); //柜子主键ID
				insertCabinets.add(cabinet);//数据库不存在，需要添加的柜子信息
			}
			
			List<IBoxInfo>	boxInfos = iCabinetContainer.getBoxInfos();
			for (IBoxInfo iBoxInfo : boxInfos) {
				BoxInfo boxInfo = iBoxInfo.getBoxInfo();
				boxInfo.setSsId(storagestation.getSsId());
				String key = boxInfo.getSsId()+boxInfo.getBoxCode();
				boxInfo.setCabinetId(cabinet.getCabinetId());
				
				if(boxInfoMaps.containsKey(key)){
					BoxInfo _box = boxInfoMaps.get(key);
					boxInfo.setBoxId(_box.getBoxId());
					updateBoxInfos.add(boxInfo); //修改的箱子信息
				}else{
					boxInfo.setBoxId(KeyHelper.creatKey());
					insertBoxInfos.add(boxInfo);//添加觉得箱子信息
				}
			}
		}
		
		//校验是否有需要新添加的外围设备
		Map<String, Peripheral> exisMaps = peripheralServer.loadAllPerpheral();
		List<Peripheral> insertPeripherals = this.filterNewPeripheral(exisMaps,perList);
		
		List<Cabinet> allCabinets = new ArrayList<Cabinet>(); //请求的所有的柜子信息
		allCabinets.addAll(insertCabinets);
		allCabinets.addAll(updateCabinets);
		List<Cabinet> deleteCabinets = this.getDeleteCabinets(cabinetMpas, allCabinets);//需要删除的柜子信息
		
		SynchObject synchObject = new SynchObject();
		synchObject.setDeleteCabinets(deleteCabinets);
		synchObject.setInsertBoxInfos(insertBoxInfos);
		synchObject.setInsertCabinets(insertCabinets);
		synchObject.setStoragestation(storagestation);
		synchObject.setStoragestationPeripherals(storPerList);
		synchObject.setUpdateBoxInfos(updateBoxInfos);
		synchObject.setUpdateCabinets(updateCabinets);
		synchObject.setPeripherals(insertPeripherals);
		
		//添加
		storagestationaService.insertIniStorInfo(synchObject);
		
	}
	
	/**
	 * 获取需要删除的无物箱信息
	 * @param cabinetMpas
	 * @param lists
	 * @return
	 */
	private List<Cabinet> getDeleteCabinets(Map<String,Cabinet> cabinetMpas,List<Cabinet> allCabinets){
		List<Cabinet> newCabinets = new ArrayList<Cabinet>();
		for (Cabinet cabinet : allCabinets) {
			String key = cabinet.getSsId()+cabinet.getCabinetCode();
			cabinetMpas.remove(key);
			/*if(!cabinetMpas.containsKey(key)){
				newCabinets.add(cabinet);
			}*/
		}
		
		for(String dataKey : cabinetMpas.keySet()){
			newCabinets.add(cabinetMpas.get(dataKey));
		}		
		return newCabinets;
	}
	
	/**
	 * 获取需要添加的外围设备
	 * @param exisMaps
	 * @param requestList
	 * @return
	 */
	private List<Peripheral> filterNewPeripheral(Map<String, Peripheral> exisMaps,List<Peripheral> requestList){
		List<Peripheral> newPer = new ArrayList<Peripheral>();
		for (Peripheral rPer : requestList) {
			String key = rPer.getAssetSn()+rPer.getPeripheralCode();
			if(!exisMaps.containsKey(key)){
				newPer.add(rPer);
			}
		}
		return newPer;
	}
}
