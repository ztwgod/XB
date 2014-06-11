package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.StoragestationPeripheral;

public interface IStoragestationPeripheralDao{

	public  List<StoragestationPeripheral> loadAll() throws Exception;
	
	public  StoragestationPeripheral loadStoragestationPeripheralByperipheralId(String peripheralId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String peripheralId) throws Exception;
	
	public  void update(StoragestationPeripheral storagestationperipheral) throws Exception;
	
	public  void insert(StoragestationPeripheral storagestationperipheral) throws Exception;
	
	public  StoragestationPeripheral fetch(Map map) throws Exception;
}

