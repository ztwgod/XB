package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.RoleModule;

public interface IRoleModuleDao{

	public  List<RoleModule> loadAll() throws Exception;
	
	public  RoleModule loadRoleModuleBymoduleId(String moduleId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String moduleId) throws Exception;
	
	public  void update(RoleModule rolemodule) throws Exception;
	
	public  void insert(RoleModule rolemodule) throws Exception;
	
	public  RoleModule fetch(Map map) throws Exception;
}

