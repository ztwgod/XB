package cn.com.xb.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import cn.com.xb.dao.IOperationLogDao;
import cn.com.xb.dao.IPClientDao;
import cn.com.xb.dao.IPSysDao;
import cn.com.xb.dao.ISysuserStoragestationDao;
import cn.com.xb.dao.IUserDao;
import cn.com.xb.dao.IUserRoleDao;
import cn.com.xb.daox.IAuthCardDaox;
import cn.com.xb.daox.IMysqlDbUtilDao;
import cn.com.xb.daox.IRoleDaox;
import cn.com.xb.daox.IUserDaox;
import cn.com.xb.daox.IUserRoleDaox;
import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.domain.base.PClient;
import cn.com.xb.domain.base.PSys;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.SysuserStoragestation;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.base.UserRole;
import cn.com.xb.domain.base.Userx;
import cn.com.xb.service.UserService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.MD5;
import cn.com.xb.util.StringUtil;

public class UserServiceImpl implements UserService {
	
	private IUserDao userDao;
	private IUserDaox userDaox;
	private IPClientDao pClientDao;
	private IPSysDao pSysDao;
	private IMysqlDbUtilDao mysqlDbUtilDao;
	private IUserRoleDao userRoleDao;
	private IUserRoleDaox userRoleDaox;
	private IRoleDaox roleDaox;
	private ISysuserStoragestationDao sysuserStoragestationDao;
	private IAuthCardDaox authCardDaox;
	private IOperationLogDao operationLogDao;
	

	public void setOperationLogDao(IOperationLogDao operationLogDao)
	{
		this.operationLogDao = operationLogDao;
	}
	public void setAuthCardDaox(IAuthCardDaox authCardDaox) {
		this.authCardDaox = authCardDaox;
	}

	public void setSysuserStoragestationDao(
			ISysuserStoragestationDao sysuserStoragestationDao) {
		this.sysuserStoragestationDao = sysuserStoragestationDao;
	}

	public void setRoleDaox(IRoleDaox roleDaox) {
		this.roleDaox = roleDaox;
	}

	public void setUserRoleDaox(IUserRoleDaox userRoleDaox) {
		this.userRoleDaox = userRoleDaox;
	}

	public void setUserRoleDao(IUserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public void setMysqlDbUtilDao(IMysqlDbUtilDao mysqlDbUtilDao) {
		this.mysqlDbUtilDao = mysqlDbUtilDao;
	}

	public void setpSysDao(IPSysDao pSysDao) {
		this.pSysDao = pSysDao;
	}

	public void setpClientDao(IPClientDao pClientDao) {
		this.pClientDao = pClientDao;
	}

	public void setUserDaox(IUserDaox userDaox) {
		this.userDaox = userDaox;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void insertUser(User user,int registerType) throws Exception {
		user.setUserId(KeyHelper.creatKey());
		user.setPassword(MD5.getMD5Str(user.getPassword()));
		user.setLastLoginTime(null);
		Timestamp time = mysqlDbUtilDao.getSystemDate();
		user.setCreateTime(time);
		/*if(user.getUserType()==Global.USER_TYPE_1){//普通注册用户
			PClient pclient = new PClient();
			pclient.setUserId(user.getUserId());
			pclient.setRegisterType(registerType);
			pclient.setOverage(0);//账户余额	
			pClientDao.insert(pclient);
		}else if(user.getUserType() == Global.USER_TYPE_3){//系统人员
			PSys pSys = new PSys();
			pSys.setUserId(user.getUserId());
			pSysDao.insert(pSys);
		}*/
		//系统人员
		PSys pSys = new PSys();
		pSys.setUserId(user.getUserId());
		pSysDao.insert(pSys);
		userDao.insert(user);
	}
	
	public void insertPortalUser(User user,int registerType) throws Exception {
		//user.setUserId(KeyHelper.creatKey());
		user.setPassword(MD5.getMD5Str(user.getPassword()));
		user.setLastLoginTime(null);
		Timestamp time = mysqlDbUtilDao.getSystemDate();
		user.setCreateTime(time);
		
		PClient pclient = new PClient();
		pclient.setUserId(user.getUserId());
		pclient.setRegisterType(registerType);
		pclient.setOverage(0);//账户余额	
		pClientDao.insert(pclient);
		
		UserRole userrole = new UserRole();
		userrole.setUserId(user.getUserId());
		userrole.setRoleId(Global.ROLE_ID_ZCYH);
		userRoleDao.insert(userrole);
		
		userDao.insert(user);
	}

	public int loadItemsByUserAccount(String userAccount) throws Exception {
		return userDaox.loadItemsByUserAccount(userAccount);
	}

	public List<User> loadUserLimit(User user,Page page) throws Exception {
		return userDaox.loadUserLimit(user,page.getStartItems(), page.getPageSize());
	}
	
	public int loadItems(User user) throws Exception{
		int items = userDaox.loadItems(user);
		return items;
	}

	public User loadUserByUserId(String userId) throws Exception {
		return userDao.loadUserByuserId(userId);
	}

	public void updateUser(User user) throws Exception {
		userDao.update(user);
	}

	public void deleteUserByUserId(String userId) throws Exception {
		userDao.delete(userId);
		pSysDao.delete(userId); //删除系统用户系统
		userRoleDaox.delteByUserId(userId);//删除用户角色信息
		authCardDaox.deleteByUserId(userId); //删除卡片配置信息
	}

	public User portalLogin(User user) throws Exception {
		user.setPassword(MD5.getMD5Str(user.getPassword()));
		return userDaox.loadPortalUser(user);
	}
	
	public User platLogin(User user) throws Exception {
		user.setPassword(MD5.getMD5Str(user.getPassword()));
		return userDaox.loadPlatUser(user);
	}

	public void updateLastLoginTime(User user) throws Exception {
		Timestamp time = mysqlDbUtilDao.getSystemDate();
		user.setLastLoginTime(time);
		userDaox.updateLastLoginTime(user);
	}

	public void updateUserAndRole(User user,String[] roles) throws Exception {
		userDao.update(user);
		userRoleDaox.delteByUserId(user.getUserId());
		for (String roleId : roles){			
			UserRole userrole = new UserRole();
			userrole.setUserId(user.getUserId());
			userrole.setRoleId(roleId);
			userRoleDao.insert(userrole);
		}
	}

	public void insertUserAndUserRole(User user,int registerType,String[] roles)
			throws Exception {
		this.insertUser(user, registerType);
		for (String roleId : roles) {
			UserRole userrole = new UserRole();
			userrole.setUserId(user.getUserId());
			userrole.setRoleId(roleId);
			userRoleDao.insert(userrole);
		}
	}

	
	public String verifyUserLogin(User user) throws Exception {
		String result = null;
		if(null==user){
			result = "用户名或者密码错误！";
		}else if(user.getStatus()==Global.USER_STATUS_WJH){
			result = "用户未激活！";
		}else if(user.getStatus()==Global.USER_STATUS_JY){
			result = "用户已禁用！";
		}else if(user.getStatus()==Global.USER_STATUS_WX){
			result = "用户无效！";
		}else if(user.getStatus()==Global.USER_STATUS_JH){//可用
			//用户状态可用,需要判断用户是否有分配角色
			List<UserRole> userRole = userRoleDaox.loadUserRoleByUserId(user.getUserId());
			if(null==userDao || userRole.isEmpty()){
				result = "用户未分配任何角色,不能登陆！";
			}
			//判断用户的角色是否处于开启状态
			String roleIds = getUseRoleIds(userRole);
			if(roleIds.trim().equals("")){
				result = "用户未分配任何角色,不能登陆！";
			}else{
				int items = roleDaox.getRoleItems(roleIds);
				if(items==0){
					result = "用户角色已关闭不能登陆！";
				}else{
					result = "OK";
				}
			}	
		}else{
			result = "未知异常，登陆失败！";
		}
		return result;
	}
	
	private String getUseRoleIds(List<UserRole> roles){
		StringBuilder builder = new StringBuilder();
		for (UserRole userRole : roles) {
			builder.append("'").append(userRole.getRoleId()).append("'").append(",");
		}
		if(builder.toString().endsWith(",")){
			builder.deleteCharAt(builder.length()-1);
		}
		return builder.toString();
	}

	public List<Userx> loadSystemUser(User user,String ssId, Page page) throws Exception {
		
		return userDaox.loadSystemUser(user,ssId, page);
	}

	public int loadSystemUserItems(User user,String ssId) throws Exception {
		
		return userDaox.loadSystemUserItems(user,ssId);
	}

	public User getSystemUserById(String ssId) throws Exception {
	
		return userDaox.getSystemUserById(ssId);
	}
	
	public void updateSystemUser(String opUserId, SysuserStoragestation sysUser) throws Exception {
		sysuserStoragestationDao.update(sysUser);
		
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(16);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("修改物箱维护人员组信息，相关参数："+StringUtil.getOptionContent(new Object[]{sysUser}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}
}
