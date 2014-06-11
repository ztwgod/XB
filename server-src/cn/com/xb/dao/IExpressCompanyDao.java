package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.ExpressCompany;

public interface IExpressCompanyDao{

	public  List<ExpressCompany> loadAll() throws Exception;
	
	public  ExpressCompany loadExpressCompanyByexcoId(String excoId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String excoId) throws Exception;
	
	public  void update(ExpressCompany expresscompany) throws Exception;
	
	public  void insert(ExpressCompany expresscompany) throws Exception;
	
	public  ExpressCompany fetch(Map map) throws Exception;
}

