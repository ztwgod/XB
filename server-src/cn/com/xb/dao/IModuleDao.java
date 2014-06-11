package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.Module;

public interface IModuleDao{

	public  List<Module> loadAll() throws Exception;
	
	public  Module loadModuleBymoduleId(String moduleId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String moduleId) throws Exception;
	
	public  void update(Module module) throws Exception;
	
	public  void insert(Module module) throws Exception;
	
	public  Module fetch(Map map) throws Exception;
}

