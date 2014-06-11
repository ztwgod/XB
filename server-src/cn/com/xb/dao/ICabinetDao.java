package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.Cabinet;

public interface ICabinetDao{

	public  List<Cabinet> loadAll() throws Exception;
	
	public  Cabinet loadCabinetBycabinetId(String cabinetId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String cabinetId) throws Exception;
	
	public  void update(Cabinet cabinet) throws Exception;
	
	public  void insert(Cabinet cabinet) throws Exception;
	
	public  Cabinet fetch(Map map) throws Exception;
}

