package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.User;

public interface IUserDao{

	public  List<User> loadAll() throws Exception;
	
	public  User loadUserByuserId(String userId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String userId) throws Exception;
	
	public  void update(User user) throws Exception;
	
	public  void insert(User user) throws Exception;
	
	public  User fetch(Map map) throws Exception;
}

