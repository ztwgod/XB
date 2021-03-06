package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.Transaction;

public interface ITransactionDao{

	public  List<Transaction> loadAll() throws Exception;
	public  List<Transaction> loadTransactionByUserId(String userId) throws Exception;
	public  List<Transaction> loadTransactionByAddressId(String AdId) throws Exception;
	public  Transaction loadTransactionBytransId(String transId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String transId) throws Exception;
	
	public  void update(Transaction transaction) throws Exception;
	
	public  void insert(Transaction transaction) throws Exception;
	
	public  Transaction fetch(Map map) throws Exception;
}

