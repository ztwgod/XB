package cn.com.xb.daox;

import java.util.List;

import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.base.Userx;

public interface IUserDaox{

	public int loadItemsByUserAccount(String userAccount) throws Exception;
	
	public List<User> loadUserLimit(User user,int start, int end) throws Exception;
	
	public int loadItems(User user) throws Exception;
	
	public User loadPortalUser(User user) throws Exception;
	
	public User loadPlatUser(User user) throws Exception;
	
	public  void updateLastLoginTime(User user) throws Exception;
	
	public List<Userx> loadSystemUser(User user,String ssId,Page page) throws Exception;
	
	public int loadSystemUserItems(User user,String ssId) throws Exception;
	
	public User getSystemUserById(String ssId) throws Exception;
	
	public void updateUserStatus(String userId, int status) throws Exception;
	
	public void updateUserInfo(User user) throws Exception;

	public String loadUserMobileByBoxId(String SSid,String boxCode) throws Exception;
	
	public String getUserIdByMobileNum(String mobileNum) throws Exception;
}
