package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.PSys;

public interface IPSysDao{

	public  List<PSys> loadAll() throws Exception;
	
	public  PSys loadPSysByuserId(String userId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String userId) throws Exception;
	
	public  void update(PSys psys) throws Exception;
	
	public  void insert(PSys psys) throws Exception;
	
	public  PSys fetch(Map map) throws Exception;
}

