package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.OperationLog;

public interface IOperationLogDao{

	public  List<OperationLog> loadAll() throws Exception;
	
	public  OperationLog loadOperationLogBylogId(String logId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String logId) throws Exception;
	
	public  void update(OperationLog operationlog) throws Exception;
	
	public  void insert(OperationLog operationlog) throws Exception;
	
	public  OperationLog fetch(Map map) throws Exception;
}

