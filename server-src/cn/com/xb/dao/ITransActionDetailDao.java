package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.TransActionDetail;

public interface ITransActionDetailDao{

	public  List<TransActionDetail> loadAll() throws Exception;
	
	public  TransActionDetail loadTransActionDetailBytransActionId(String transActionId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String transActionId) throws Exception;
	
	public  void update(TransActionDetail transactiondetail) throws Exception;
	
	public  void insert(TransActionDetail transactiondetail) throws Exception;
	
	public  TransActionDetail fetch(Map map) throws Exception;
}

