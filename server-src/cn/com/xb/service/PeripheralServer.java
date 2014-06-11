package cn.com.xb.service;

import java.util.List;
import java.util.Map;

import cn.com.xb.domain.base.Peripheral;
import cn.com.xb.domain.base.StoragestationPeripheral;

public interface PeripheralServer {

	public Map<String, Peripheral> loadAllPerpheral() throws Exception;
	
	public void updateStorPeripheral(List<StoragestationPeripheral> storPerList) throws Exception;
	
	public void insert(Peripheral peripheral) throws Exception;
	
}
