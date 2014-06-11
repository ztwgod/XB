package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.SysuserStoragestation;

public interface ISysuserStoragestationDao{

	public  List<SysuserStoragestation> loadAll() throws Exception;
	
	public  SysuserStoragestation loadSysuserStoragestationByssId(String ssId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String ssId) throws Exception;
	
	public  void update(SysuserStoragestation sysuserstoragestation) throws Exception;
	
	public  void insert(SysuserStoragestation sysuserstoragestation) throws Exception;
	
	public  SysuserStoragestation fetch(Map map) throws Exception;
}

