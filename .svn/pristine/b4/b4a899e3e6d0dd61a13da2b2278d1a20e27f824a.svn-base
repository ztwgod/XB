package cn.com.xb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.xb.dao.IPeripheralDao;
import cn.com.xb.dao.IStoragestationPeripheralDao;
import cn.com.xb.domain.base.Peripheral;
import cn.com.xb.domain.base.StoragestationPeripheral;
import cn.com.xb.service.PeripheralServer;

public class PeripheralServerImpl implements PeripheralServer {

	private IPeripheralDao peripheralDao;
	private IStoragestationPeripheralDao storagestationPeripheralDao;
	
	public void setStoragestationPeripheralDao(IStoragestationPeripheralDao storagestationPeripheralDao) {
		this.storagestationPeripheralDao = storagestationPeripheralDao;
	}

	public void setPeripheralDao(IPeripheralDao peripheralDao) {
		this.peripheralDao = peripheralDao;
	}

	@Override
	public Map<String, Peripheral> loadAllPerpheral() throws Exception {
		List<Peripheral> lists = peripheralDao.loadAll();
		Map<String, Peripheral> maps = new HashMap<String, Peripheral>();
		for (Peripheral peripheral : lists) {
			String key = peripheral.getAssetSn()+peripheral.getPeripheralCode();
			maps.put(key, peripheral);
		}
		return maps;
	}
	
	public void updateStorPeripheral(List<StoragestationPeripheral> storPerList) throws Exception{
		for (StoragestationPeripheral storagestationPeripheral : storPerList) {
			storagestationPeripheralDao.delete(storagestationPeripheral.getPeripheralId());
			storagestationPeripheralDao.insert(storagestationPeripheral);
		}
	}

	@Override
	public void insert(Peripheral peripheral) throws Exception {
		peripheralDao.insert(peripheral);
	}
}
