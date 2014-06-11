package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.StoragestationModel;

public interface IStoragestationModelDao{

	public  List<StoragestationModel> loadAll() throws Exception;
	
	public  StoragestationModel loadStoragestationModelBymodelId(String modelId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String modelId) throws Exception;
	
	public  void update(StoragestationModel storagestationmodel) throws Exception;
	
	public  void insert(StoragestationModel storagestationmodel) throws Exception;
	
	public  StoragestationModel fetch(Map map) throws Exception;
}

