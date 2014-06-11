package cn.com.xb.plat.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.com.xb.domain.base.FlagDictionary;
import cn.com.xb.domain.base.Module;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Role;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.base.UserRole;
import cn.com.xb.domain.base.UserSession;
import cn.com.xb.service.FlagDictionaryService;
import cn.com.xb.service.ModuleService;
import cn.com.xb.service.RoleService;
import cn.com.xb.service.UserRoleService;
import cn.com.xb.service.UserService;
import cn.com.xb.util.Global;
import cn.com.xb.util.MD5;
import cn.com.xb.util.SessionManger;

import com.opensymphony.xwork2.ActionSupport;

public class PlatUserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	private static final long serialVersionUID = -578697069556382981L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserService userService;
	private FlagDictionaryService flagDictionaryService;
	private RoleService roleService;
	private UserRoleService userRoleService;
	private ModuleService moduleService;

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public void setFlagDictionaryService(FlagDictionaryService flagDictionaryService) {
		this.flagDictionaryService = flagDictionaryService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
	/**
	 * 跳转到登陆页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String Admin() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 登陆
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doPlatLogin() throws Exception {
		String userAccount = request.getParameter("TxtUserName");
		String password = request.getParameter("TxtPassword");
		String yzm = request.getParameter("TxtYZM");
		String sRand = SessionManger.loadYZMSession(request);
		
		User user = new User();
		user.setUserAccount(userAccount);
		user.setPassword(password);	
		
		if(null!=yzm && yzm.equals(sRand)){
			User _user = userService.platLogin(user);
			String result = userService.verifyUserLogin(_user);
			if("OK".equals(result)){
				UserSession userSession = new UserSession();
				userSession.setUserSession(_user);
				userService.updateLastLoginTime(_user);
				SessionManger.updatePlatUserSession(request,userSession); //更新用户信息
				
				List<UserRole> userRoles = userRoleService.getUserRoleByUserId(_user.getUserId());
				List<Module> modules = moduleService.loadUserModule(userRoles);
				SessionManger.updatePlatModuleSession(request, modules); //更新模块信息
				
				request.setAttribute("user", _user);
				SessionManger.updateYZMSession(request, null);
				return SUCCESS;
			}else{
				request.setAttribute("user", user);
				request.setAttribute("message", result);
				return ERROR;
			}
		}else{
			request.setAttribute("user", user);
			request.setAttribute("message", "验证码输入错误！");
			return ERROR;
		}
	}	
	
	/**
	 * 注销
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception{
		SessionManger.updatePlatUserSession(request, null);
		SessionManger.updatePlatModuleSession(request, null);
		request.getSession().invalidate();
		return SUCCESS;
	}
	
	/**
	 * 用户列表
	 * @throws Exception
	 */
	public String listUser() throws Exception{		
		String userAccount = request.getParameter("userAccount")==null?"":request.getParameter("userAccount");
		String userName = request.getParameter("userName")==null?"":request.getParameter("userName");
		String mobileNumber = request.getParameter("mobileNumber")==null?"":request.getParameter("mobileNumber");
		
		String _status = "";
		if(null == request.getParameter("status") || "".equals(request.getParameter("status"))){
			_status = "0";
		}else{
			_status = request.getParameter("status");
		}
		String _userType = "";
		if(null==request.getParameter("userType") || "".equals(request.getParameter("userType"))){
			_userType = "0";
		}else{
			_userType = request.getParameter("userType");
		}
		String _pageNumber = request.getParameter("pageNumber")==null?"1":request.getParameter("pageNumber");
		
		int pageNumber = Integer.parseInt(_pageNumber);
		int status = Integer.parseInt(_status);
		int userType = Integer.parseInt(_userType);
		
		User user = new User();
		user.setUserAccount(userAccount);
		user.setUserName(userName);
		user.setMobileNumber(mobileNumber);
		user.setStatus(status);
		user.setUserType(userType);
		
		int items = userService.loadItems(user);
		Page page = new Page();
		page.setPageAllCount(items);
		page.setPageNumber(pageNumber);
		
		List<FlagDictionary> statusList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_STATUS);//状态
		List<FlagDictionary> userTypeList = flagDictionaryService.loadDictionaryByTypeIdAndStauts(Global.DICTIONARY_TYPE_USER_TYPE,1);//用户类型		
		List<User> userList = userService.loadUserLimit(user, page);
		
		request.setAttribute("user", user);
		request.setAttribute("page", page);
		request.setAttribute("statusList", statusList);
		request.setAttribute("userTypeList", userTypeList);
		request.setAttribute("userList", userList);
		return SUCCESS;
	}
	
	
	/**
	 * 跳转到添加用户页面
	 * @return
	 * @throws Exception
	 */
	public String toAddUser() throws Exception {
		List<FlagDictionary> idList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_PAPERWORK_TYPE);//证件类型
		List<FlagDictionary> statusList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_STATUS);//状态
		//List<FlagDictionary> userTypeList = flagDictionaryService.loadDictionaryByTypeIdAndStauts(Global.DICTIONARY_TYPE_USER_TYPE,1);//用户类型
		
		Role role = new Role();
		role.setRoleType(Global.ROLE_TYPE_PLAT);
		List<Role> roles = roleService.getRoles(role);
		
		request.setAttribute("roles", roles);
		request.setAttribute("idList", idList);
		request.setAttribute("statusList", statusList);
		//request.setAttribute("userTypeList", userTypeList);
		
		return SUCCESS;
	}
	
	/**
	 * 添加用户信息
	 * @return
	 * @throws Exception
	 */
	public String doAddUser() throws Exception{
		String userAccount = request.getParameter("userAccount");
		String chName = request.getParameter("chName");
		String idType = request.getParameter("idType");
		String idNo = request.getParameter("idNo");
		String status = request.getParameter("status");
		String weibo = request.getParameter("weibo");
		String weixin = request.getParameter("weixin");
		String QQ = request.getParameter("QQ");
		//String userType = request.getParameter("userType");		
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String registerAddress = request.getParameter("registerAddress"); //户籍地址
		String usualAddress = request.getParameter("usualAddress"); //常住地址
		String gender = request.getParameter("gender");
		String zipCode = request.getParameter("zipCode");
		String[] role = request.getParameterValues("role");
		
		User user = new User();
		user.setUserAccount(userAccount);
		user.setPassword(password);
		user.setMobileNumber(mobile);
		user.setEmail(email);
		user.setHouseholdRegisterAddress(registerAddress);
		user.setHabitualResidence(usualAddress);
		user.setUserName(chName);
		user.setPaperworkType(Integer.parseInt(idType));
		user.setPaperworkNum(idNo);
		user.setStatus(Integer.parseInt(status));
		user.setWeixin(weixin);
		user.setWb(weibo);
		user.setQq(QQ);
		user.setUserType(Global.USER_TYPE_3);//系统维护人员
		user.setGender(Integer.parseInt(gender));
		user.setZipCode(zipCode);
		
		userService.insertUserAndUserRole(user,Global.REGISTER_TYPE_1,role);		
		return SUCCESS;
	}
	
	/**
	 * 校验用户名是否重复！
	 * @throws Exception
	 */
	public void checkUserAccount() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");		
		String userAccount = request.getParameter("userAccount");
		int itmes = userService.loadItemsByUserAccount(userAccount);
		if(itmes==0){
			response.getWriter().write("OK");
		}else{
			response.getWriter().write("该用户名已经被注册！");
		}
	}
	
	/**
	 * 跳转到修改用户信息页面
	 * @return
	 * @throws Exception
	 */
	public String toUpdateUser() throws Exception{
		String userId = request.getParameter("userId");
		List<FlagDictionary> idList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_PAPERWORK_TYPE);//证件类型
		List<FlagDictionary> statusList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_STATUS);//状态
		List<FlagDictionary> userTypeList = flagDictionaryService.loadDictionaryByTypeIdAndStauts(Global.DICTIONARY_TYPE_USER_TYPE,1);//用户类型
		User user = userService.loadUserByUserId(userId);
		//List<Role> roles = roleService.getAllRoles();
		Role role = new Role();
		if(user.getUserType()==Global.USER_TYPE_1){
			role.setRoleType(Global.ROLE_TYPE_PORTAL);
		}else if(user.getUserType()==Global.USER_TYPE_3){
			role.setRoleType(Global.ROLE_TYPE_PLAT);
		}
		List<Role> roles = roleService.getRoles(role);
		
		List<UserRole> userRoles = userRoleService.getUserRoleByUserId(userId);
		
		request.setAttribute("userRoles", userRoles);
		request.setAttribute("roles", roles);
		request.setAttribute("user", user);
		request.setAttribute("idList", idList);
		request.setAttribute("statusList", statusList);
		request.setAttribute("userTypeList", userTypeList);
		
		return SUCCESS;
	}
	
	/**
	 * 修改用户信息
	 * @return
	 * @throws Exception
	 */
	public String doUpdateUser() throws Exception{
		String userId = request.getParameter("userId");
		String chName = request.getParameter("chName");
		String idType = request.getParameter("idType");
		String idNo = request.getParameter("idNo");
		String status = request.getParameter("status");
		String weibo = request.getParameter("weibo");
		String weixin = request.getParameter("weixin");
		String QQ = request.getParameter("QQ");
		//String userType = request.getParameter("userType");		
		//String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String registerAddress = request.getParameter("registerAddress"); //户籍地址
		String usualAddress = request.getParameter("usualAddress"); //常住地址
		String gender = request.getParameter("gender");
		String zipCode = request.getParameter("zipCode");
		String[] role = request.getParameterValues("role");
		
		
		User user = userService.loadUserByUserId(userId);
		//user.setUserId(userId);
		//user.setPassword(password);
		user.setMobileNumber(mobile);
		user.setEmail(email);
		user.setHouseholdRegisterAddress(registerAddress);
		user.setHabitualResidence(usualAddress);
		user.setUserName(chName);
		user.setPaperworkType(Integer.parseInt(idType));
		user.setPaperworkNum(idNo);
		user.setStatus(Integer.parseInt(status));
		user.setWeixin(weixin);
		user.setWb(weibo);
		user.setQq(QQ);
		//user.setUserType(Integer.parseInt(userType));
		user.setGender(Integer.parseInt(gender));
		user.setZipCode(zipCode);
		
		userService.updateUserAndRole(user,role);
		
		return SUCCESS;
	}
	
	/**
	 * 删除用户
	 * @return
	 * @throws Exception
	 */
	public String doDelete() throws Exception{
		String userId = request.getParameter("userId");
		userService.deleteUserByUserId(userId);
		return SUCCESS;
	}
	
	/**
	 * 跳转到个人主页
	 * @return
	 * @throws Exception
	 */
	public String toUserHome() throws Exception{
		String userId = SessionManger.loadPlatUserSession(request).getUserId();
		List<FlagDictionary> idList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_PAPERWORK_TYPE);//证件类型
		User user = userService.loadUserByUserId(userId);
		
		request.setAttribute("idList", idList);
		request.setAttribute("user", user);
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改密码页面
	 * @return
	 * @throws Exception
	 */
	public String toUpdatePlatPassword() throws Exception{
		String userId = SessionManger.loadPlatUserSession(request).getUserId();
		User user = userService.loadUserByUserId(userId);		
		request.setAttribute("user", user);
		return SUCCESS;
	}
	
	/**
	 * 校验旧密码是否正确
	 * @throws Exception
	 */
	public void checkPlatOldPasswod() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String oldPassword = MD5.getMD5Str(request.getParameter("oldPassword"));
		String userId = SessionManger.loadPlatUserSession(request).getUserId();
		User user = userService.loadUserByUserId(userId);
		if(oldPassword.equals(user.getPassword())){
			response.getWriter().write("OK");
		}else{
			response.getWriter().write("旧密码输入错误！");
		}
	}
	
	/**
	 * 修改密码
	 * @return
	 * @throws Exception
	 */
	public String doUpdatePlatPassword() throws Exception{
		String userId = request.getParameter("userId");
		String newPassword = request.getParameter("newPassword");
		User user = userService.loadUserByUserId(userId);
		user.setPassword(MD5.getMD5Str(newPassword));
		userService.updateUser(user);
		List<FlagDictionary> idList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_PAPERWORK_TYPE);//证件类型
		
		request.setAttribute("idList", idList);
		request.setAttribute("user", user);
		request.setAttribute("successMsg", "密码修改成功！");		
		return SUCCESS;
	}
	
	/**
	 * 修改登陆用户信息
	 * @return
	 * @throws Exception
	 */
	public String doUpdatePlatUserInfo() throws Exception{
		String userId = SessionManger.loadPlatUserSession(request).getUserId();
		String chName = request.getParameter("chName");
		String gender = request.getParameter("gender");
		String mobile = request.getParameter("mobile");
		String QQ = request.getParameter("QQ");
		String idType = request.getParameter("idType");
		String idNo = request.getParameter("idNo");
		String weixin = request.getParameter("weixin");
		String weibo = request.getParameter("weibo");
		String usualAddress = request.getParameter("usualAddress");
		String zipCode = request.getParameter("zipCode");
		String registerAddress = request.getParameter("registerAddress");
		String email = request.getParameter("email");
		
		User user = userService.loadUserByUserId(userId);
		user.setUserName(chName);
		user.setGender(Integer.parseInt(gender));
		user.setMobileNumber(mobile);
		user.setQq(QQ);
		user.setPaperworkType(Integer.parseInt(idType));
		user.setPaperworkNum(idNo);
		user.setWeixin(weixin);
		user.setWb(weibo);
		user.setHabitualResidence(usualAddress);
		user.setZipCode(zipCode);
		user.setHouseholdRegisterAddress(registerAddress);
		user.setEmail(email);
		
		userService.updateUser(user);
		List<FlagDictionary> idList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_PAPERWORK_TYPE);//证件类型
		request.setAttribute("idList", idList);
		request.setAttribute("user", user);
		request.setAttribute("successMsg", "用户信息修改成功！");		
		
		return SUCCESS;
	}
	
	public String toMain() throws Exception{
		
		
		return SUCCESS;
	}
	
}
