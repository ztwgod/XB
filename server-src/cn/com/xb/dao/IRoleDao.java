package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.Role;

public interface IRoleDao{

	public  List<Role> loadAll() throws Exception;
	
	public  Role loadRoleByroleId(String roleId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String roleId) throws Exception;
	
	public  void update(Role role) throws Exception;
	
	public  void insert(Role role) throws Exception;
	
	public  Role fetch(Map map) throws Exception;
}

