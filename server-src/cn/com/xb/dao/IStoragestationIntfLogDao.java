package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.StoragestationIntfLog;

public interface IStoragestationIntfLogDao{

	public  List<StoragestationIntfLog> loadAll() throws Exception;
	
	public  StoragestationIntfLog loadStoragestationIntfLogBylogId(String logId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String logId) throws Exception;
	
	public  void update(StoragestationIntfLog storagestationintflog) throws Exception;
	
	public  void insert(StoragestationIntfLog storagestationintflog) throws Exception;
	
	public  StoragestationIntfLog fetch(Map map) throws Exception;
}

