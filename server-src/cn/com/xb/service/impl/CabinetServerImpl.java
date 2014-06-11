package cn.com.xb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.xb.daox.ICabinetDaox;
import cn.com.xb.domain.base.Cabinet;
import cn.com.xb.service.CabinetServer;

public class CabinetServerImpl implements CabinetServer {

	private ICabinetDaox cabinetDaox;
	
	public void setCabinetDaox(ICabinetDaox cabinetDaox) {
		this.cabinetDaox = cabinetDaox;
	}

	@Override
	public Map<String,Cabinet> getCabinetListBySSId(String ssId) throws Exception {
		List<Cabinet> lists = cabinetDaox.loadCabinetsBySSId(ssId);
		Map<String,Cabinet> cabMaps = new HashMap<String, Cabinet>();
		for (Cabinet cabinet : lists) {
			String key = cabinet.getSsId()+cabinet.getCabinetCode();
			cabMaps.put(key, cabinet);
		}
		return cabMaps;
	}
	
	public void updateCabinet(Cabinet cabinet) throws Exception{
		cabinetDaox.update(cabinet);
	}
}
