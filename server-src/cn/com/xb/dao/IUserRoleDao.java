package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.UserRole;

public interface IUserRoleDao{

	public  List<UserRole> loadAll() throws Exception;
	
	public  UserRole loadUserRoleByroleId(String roleId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String roleId) throws Exception;
	
	public  void update(UserRole userrole) throws Exception;
	
	public  void insert(UserRole userrole) throws Exception;
	
	public  UserRole fetch(Map map) throws Exception;
}

