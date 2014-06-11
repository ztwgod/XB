package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.LeaseBoxRela;

public interface ILeaseBoxRelaDao{

	public  List<LeaseBoxRela> loadAll() throws Exception;
	
	public  LeaseBoxRela loadLeaseBoxRelaByaliasesId(String aliasesId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String aliasesId) throws Exception;
	
	public  void update(LeaseBoxRela leaseboxrela) throws Exception;
	
	public  void insert(LeaseBoxRela leaseboxrela) throws Exception;
	
	public  LeaseBoxRela fetch(Map map) throws Exception;
}

