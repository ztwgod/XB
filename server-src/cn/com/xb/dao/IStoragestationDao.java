package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.Storagestation;

public interface IStoragestationDao{

	public  List<Storagestation> loadAll() throws Exception;
	
	public  Storagestation loadStoragestationByssId(String ssId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String ssId) throws Exception;
	
	public  void update(Storagestation storagestation) throws Exception;
	
	public  void insert(Storagestation storagestation) throws Exception;
	
	public  Storagestation fetch(Map map) throws Exception;
}

