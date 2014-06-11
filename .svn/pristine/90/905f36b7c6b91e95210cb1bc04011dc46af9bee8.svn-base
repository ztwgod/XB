package cn.com.xb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.xb.daox.IBoxInfoDaox;
import cn.com.xb.daox.ICabinetDaox;
import cn.com.xb.daox.IStoragestationDaox;
import cn.com.xb.daox.IStoragestationPeripheralDaox;
import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.inter.domain.IDeviceStatus;
import cn.com.xb.inter.domain.SynchBoxInfoObject;
import cn.com.xb.service.BoxInfoService;
import cn.com.xb.util.Global;

public class BoxInfoServiceImpl implements BoxInfoService {

	private IBoxInfoDaox boxInfoDaox;
	private IStoragestationDaox storagestationDaox;
	private ICabinetDaox cabinetDaox;
	private IStoragestationPeripheralDaox storagestationPeripheralDaox;
	
	public void setStoragestationPeripheralDaox(
			IStoragestationPeripheralDaox storagestationPeripheralDaox) {
		this.storagestationPeripheralDaox = storagestationPeripheralDaox;
	}

	public void setCabinetDaox(ICabinetDaox cabinetDaox) {
		this.cabinetDaox = cabinetDaox;
	}

	public void setStoragestationDaox(IStoragestationDaox storagestationDaox) {
		this.storagestationDaox = storagestationDaox;
	}

	public void setBoxInfoDaox(IBoxInfoDaox boxInfoDaox) {
		this.boxInfoDaox = boxInfoDaox;
	}

	public Map<Integer,Integer> getBoxInfoByLoadStatus(String poiId,int loadStatus) throws Exception {
		List<BoxInfo> boList = boxInfoDaox.getBoxInfoByLoadStatus(poiId,loadStatus);
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		int xxl = 0;
		int xl = 0;
		int l = 0;
		int m = 0;
		int s = 0;
		
		for (BoxInfo boxInfo : boList) {
			if(boxInfo.getSize()==Global.BOX_SIZE_XXL){
				xxl++;
			}else if(boxInfo.getSize()==Global.BOX_SIZE_XL){
				xl++;
			}else if(boxInfo.getSize()==Global.BOX_SIZE_L){
				l++;
			}else if(boxInfo.getSize()==Global.BOX_SIZE_M){
				m++;
			}else if(boxInfo.getSize()==Global.BOX_SIZE_S){
				s++;
			}
		}
		map.put(Global.BOX_SIZE_XXL, xxl);
		map.put(Global.BOX_SIZE_XL, xl);
		map.put(Global.BOX_SIZE_L, l);
		map.put(Global.BOX_SIZE_M, m);
		map.put(Global.BOX_SIZE_S, s);
		
		return map;
	}

	public Map<Integer, Integer> getStoragestationByPoiId(String poiId) throws Exception {
		List<Storagestationx> storList = boxInfoDaox.getStoragestationByPoiId(poiId);
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		int xxl = 0;
		int xl = 0;
		int l = 0;
		int m = 0;
		int s = 0;
		
		for (Storagestationx stor : storList) {
			if(stor.getSize()==Global.BOX_SIZE_XXL){
				xxl++;
			}else if(stor.getSize()==Global.BOX_SIZE_XL){
				xl++;
			}else if(stor.getSize()==Global.BOX_SIZE_L){
				l++;
			}else if(stor.getSize()==Global.BOX_SIZE_M){
				m++;
			}else if(stor.getSize()==Global.BOX_SIZE_S){
				s++;
			}
		}
		map.put(Global.BOX_SIZE_XXL, xxl);
		map.put(Global.BOX_SIZE_XL, xl);
		map.put(Global.BOX_SIZE_L, l);
		map.put(Global.BOX_SIZE_M, m);
		map.put(Global.BOX_SIZE_S, s);
		
		return map;
	}

	@Override
	public Map<String, BoxInfo> getBoxInfoListBySSId(String ssId) throws Exception {
		Map<String, BoxInfo> maps = new HashMap<String, BoxInfo>();
		List<BoxInfo> boxInfos = boxInfoDaox.getBoxInfoListBySSId(ssId);
		if(null!=boxInfos){
			for (BoxInfo boxInfo : boxInfos) {
				String key = boxInfo.getSsId()+boxInfo.getBoxCode();
				maps.put(key, boxInfo);
			}
		}
		return maps;
	}

	@Override
	public void updateBoxInfo(BoxInfo boxInfo) throws Exception {
		boxInfoDaox.updateBoxInfo(boxInfo);
	}

	@Override
	public void synchBoxInfo(SynchBoxInfoObject object) throws Exception {
		//同步箱子信息
		for (IDeviceStatus runstatus : object.getBoxRunStatus()) {
			boxInfoDaox.updateRunStatus(runstatus, object.getSsId());
		}
		for (IDeviceStatus loadstatus : object.getBoxLoadStatus()) {
			boxInfoDaox.updateLoadStatus(loadstatus, object.getSsId());
		}
		//柜子信息
		for (IDeviceStatus cabinetDev : object.getCabinetContainerStatus()) {
			cabinetDaox.updateCabinet(cabinetDev, object.getSsId());
		}
		//外围设备
		for (IDeviceStatus perDeviceStatus : object.getPeripheralRunStatus()) {
			storagestationPeripheralDaox.updatePeripheral(perDeviceStatus, object.getSsId());
		}
		//物箱信息
		if(object.getStatus()!=0){//如果物箱信息状态为0，不需要同步证明物箱信息不需要同步
			storagestationDaox.updateStatus(object.getStatus(), object.getStorageStationId());
		}
	}
}
