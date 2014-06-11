package cn.com.xb.service;

import java.util.List;

import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.SysuserStoragestation;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.base.Userx;


public interface UserService {

	public void insertUser(User user,int registerType) throws Exception;
	
	public void insertPortalUser(User user,int registerType) throws Exception;
	
	public int loadItemsByUserAccount(String userAccount) throws Exception;
	
	public List<User> loadUserLimit(User user,Page page) throws Exception;
	
	public int loadItems(User user) throws Exception;
	
	public User loadUserByUserId(String userId) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public void deleteUserByUserId(String userId) throws Exception;
	
	public User portalLogin(User user) throws Exception;
	
	public User platLogin(User user) throws Exception;
	
	public void updateLastLoginTime(User user) throws Exception;
	
	public void updateUserAndRole(User user,String[] roles) throws Exception;
	
	public void insertUserAndUserRole(User user,int registerType,String[] roles) throws Exception;
	
	public String verifyUserLogin(User user) throws Exception;
	
	public List<Userx> loadSystemUser(User user,String ssId,Page page) throws Exception;
	
	public int loadSystemUserItems(User user,String ssId) throws Exception;
	
	public User getSystemUserById(String ssId) throws Exception;
	
	//修改维护员信息
	public void updateSystemUser(String opUserId, SysuserStoragestation sysUser) throws Exception; 
}
