package cn.com.xb.portal.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.com.xb.domain.base.BoxInfox;
import cn.com.xb.domain.base.FlagDictionary;
import cn.com.xb.domain.base.GbDistrict;
import cn.com.xb.domain.base.LeaseAliases;
import cn.com.xb.domain.base.LeaseBoxRela;
import cn.com.xb.domain.base.Module;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.StoragestationGroupx;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.base.UserRole;
import cn.com.xb.domain.base.UserSession;
import cn.com.xb.domain.displayWrapper.OrderWrapper;
import cn.com.xb.domain.parameterWrapper.GetOrderListParam;
import cn.com.xb.service.FlagDictionaryService;
import cn.com.xb.service.GbDistrictService;
import cn.com.xb.service.ModuleService;
import cn.com.xb.service.OrderService;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.service.UserRoleService;
import cn.com.xb.service.UserService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.MD5;
import cn.com.xb.util.SessionManger;
import cn.com.xb.util.StringUtil;
import cn.com.xb.util.box.FreemarkerUtil;

import com.opensymphony.xwork2.ActionSupport;

public class PortalUserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private static final long serialVersionUID = -578697069556382981L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserService userService;
	private FlagDictionaryService flagDictionaryService;
	private String userId;
	private UserRoleService userRoleService;
	private ModuleService moduleService;
	private GbDistrictService gbDistrictService;
	private StoragestationaService storagestationaService;
	private OrderService orderService;
	private Log log = LogFactory.getLog(PortalUserAction.class);

	public void setStoragestationaService(
			StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}

	public void setGbDistrictService(GbDistrictService gbDistrictService) {
		this.gbDistrictService = gbDistrictService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	public void setOrderService(OrderService orderService)
	{
		this.orderService = orderService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	public String toLogin() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 登陆
	 * @return
	 * @throws Exception
	 */
	public String doLogin() throws Exception{
		String userAccount = request.getParameter("userAccount");
		String password = request.getParameter("password");
		String yzm = request.getParameter("yzm");
		String sRand = SessionManger.loadYZMSession(request);
		
		User user = new User();
		user.setUserAccount(userAccount);
		user.setPassword(password);	
		
		if(null!=yzm && yzm.equals(sRand)){			
			User _user = userService.portalLogin(user);			
			String result = userService.verifyUserLogin(_user);
			if(result.equals("OK")){
				UserSession userSession = new UserSession();
				userSession.setUserSession(_user);
				userService.updateLastLoginTime(_user);
				List<UserRole> userRoles = userRoleService.getUserRoleByUserId(_user.getUserId());
				List<Module> modules = moduleService.loadUserModule(userRoles);
				SessionManger.updatePortalModuleSession(request, modules); //更新模块信息
				SessionManger.updatePortalUserSession(request, userSession); //更新用户信息				
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
	 * 退出登陆
	 * @throws Exception
	 */
	public String portalLogout() throws Exception{
		SessionManger.updatePortalUserSession(request, null);
		//request.getSession().invalidate();
		
		List<UserRole> list = new ArrayList<UserRole>();
		UserRole userRole = new UserRole();
		userRole.setRoleId(Global.ROLE_ID_NM);
		list.add(userRole);
		
		List<Module> modules = moduleService.loadUserModule(list); //赋予其匿名用户的角色
		SessionManger.updatePortalModuleSession(request, modules);
		return SUCCESS;
	}
	
	/**
	 * 跳转到用户注册页面
	 * @return
	 * @throws Exception
	 */
	public String toRegister()throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 注册
	 * @return
	 * @throws Exception
	 */
	public String doRegister() throws Exception{
		String userAccount = request.getParameter("userAccount");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String realName = request.getParameter("realName");
		String mobileNumber = request.getParameter("mobile");
		
		User user = new User();
		user.setUserId(KeyHelper.creatKey());
		user.setUserAccount(userAccount);
		user.setPassword(password);
		user.setGender(Integer.parseInt(gender));
		user.setUserName(realName);
		user.setMobileNumber(mobileNumber);
		user.setStatus(Global.USER_STATUS_JH);
		user.setUserType(Global.USER_TYPE_1);
		userService.insertPortalUser(user, Global.REGISTER_TYPE_2);
		//request.setAttribute("userId", user.getUserId());		
		userId = user.getUserId();
		
		return SUCCESS;
	}
	
	/**
	 * 跳转到用户注册页面
	 * @return
	 * @throws Exception
	 */
	public String toRegister2()throws Exception{
		List<FlagDictionary> idList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_PAPERWORK_TYPE);//证件类型
		request.setAttribute("idList", idList);
		return SUCCESS;
	}
	
	/**
	 * 注册信息第二步
	 * @return
	 * @throws Exception
	 */
	public String doRegister2() throws Exception{
		String userId = request.getParameter("userId");
		String idType = request.getParameter("idType");
		String idNo = request.getParameter("idNo");
		String QQ = request.getParameter("QQ");
		String weixin = request.getParameter("weixin");
		String wb = request.getParameter("wb");
		String email = request.getParameter("");
		String usualAddress = request.getParameter("usualAddress");
		String zipCode = request.getParameter("zipCode");
		String registerAddress = request.getParameter("registerAddress");
		
		User user = userService.loadUserByUserId(userId);
		user.setPaperworkType(Integer.parseInt(idType));
		user.setPaperworkNum(idNo);
		user.setQq(QQ);
		user.setWeixin(weixin);
		user.setWb(wb);
		user.setEmail(email);
		user.setHabitualResidence(usualAddress);
		user.setZipCode(zipCode);
		user.setHouseholdRegisterAddress(registerAddress);
		
		userService.updateUser(user);
		
		return SUCCESS;
	}
	
	/**
	 * 跳转到定制箱子页面
	 * @return
	 * @throws Exception
	 */
	public String toRegister3() throws Exception{
		String userId = request.getParameter("userId");
		String districtId = request.getParameter("districtId")==null?"":request.getParameter("districtId");
		
		// 调出区域目录树
		String parentGbId = Global.GB_DISTRICT_TREE_ROOT;
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(parentGbId);
		request.setAttribute("gds", gds);
		String districtName = "";
		if(StringUtil.isNotBlank(districtId)){
			districtName = gbDistrictService.getGBDistrictFullName(districtId);
		}
		request.setAttribute("districtName", districtName);
		request.setAttribute("nextId", "cityTD");
		request.setAttribute("districtId", districtId);
		//地域end
		
		
		request.setAttribute("userId",userId);
		return SUCCESS;
	}
	
	/**
	 * 获取子级区域列表
	 * @return
	 * @throws Exception
	 */
	public String getGbDistrictListByPId() throws Exception
	{
		String nextId = StringUtil.formatStringTrimToNull(request.getParameter("nextId"));
		String parentGbId = StringUtil.formatStringTrimToNull(request.getParameter("districtId"));
		parentGbId = parentGbId == null ? Global.GB_DISTRICT_TREE_ROOT : parentGbId;
		
		// 调出区域列表
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(parentGbId);
		
		request.setAttribute("gds", gds);
		request.setAttribute("nextId", "cityTD".equals(nextId) ? "districtTD" : "districtTD".equals(nextId) ? "____" : "cityTD");
		return SUCCESS;
	}
	
	/**
	 * 获取物箱组下拉框信息
	 * @return
	 * @throws Exception
	 */
	public void getStorGroupListByDistrict() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String districtId = StringUtil.formatStringTrimToNull(request.getParameter("districtId"));
		List<StoragestationGroupx> storGroups = storagestationaService.getStoragestationGroup(districtId);
		Map<String,Object> root=new HashMap<String,Object>();
		root.put("storGroups", storGroups);
		String context = new FreemarkerUtil().getContext(root, "storGroup.ftl");
		log.info(context);
		response.getWriter().write(context);
	}
	
	/**
	 * 获取物箱下拉框信息
	 * @return
	 * @throws Exception
	 */
	public void getStorListByGroupId() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String groupId = StringUtil.formatStringTrimToNull(request.getParameter("groupId"));
		List<Storagestationx> storList = storagestationaService.loadStoragestationByGroupId(groupId);
		Map<String,Object> root=new HashMap<String,Object>();		
		root.put("storList", storList);
		String context = new FreemarkerUtil().getContext(root, "stor.ftl");
		log.info(context);
		response.getWriter().write(context);
	}
	
	/**
	 * 获取箱子信息
	 * @throws Exception
	 */
	public void getBoxInfoBySSId() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String ssId = StringUtil.formatStringTrimToNull(request.getParameter("ssId"));
		List<BoxInfox> boxList = storagestationaService.loadBoxInfoxList(ssId);
		
		Map<String,Object> root=new HashMap<String,Object>();		
		root.put("boxList", boxList);
		String context = new FreemarkerUtil().getContext(root, "box.ftl");
		log.info(context);
		response.getWriter().write(context);
	}
	
	/**
	 * 定制物箱方法
	 * @return
	 * @throws Exception
	 */
	public String doRegister3() throws Exception{
		String userId = StringUtil.formatStringTrimToNull(request.getParameter("userId"));
		String boxAliases = StringUtil.formatStringTrimToNull(request.getParameter("boxAliases"));
		//String districtId = StringUtil.formatStringTrimToNull(request.getParameter("districtId"));
		//String storGroup = StringUtil.formatStringTrimToNull(request.getParameter("storGroup"));
		String stor = StringUtil.formatStringTrimToNull(request.getParameter("stor"));
		String box = StringUtil.formatStringTrimToNull(request.getParameter("box"));
		
		LeaseAliases leaseAliases = new LeaseAliases();
		String aliasesId = KeyHelper.creatKey();
		leaseAliases.setAliasesId(aliasesId);
		leaseAliases.setAliasesName(boxAliases);
		leaseAliases.setUserId(userId);
		leaseAliases.setSsId(stor);
		leaseAliases.setLeaseBoxNum(1);
		leaseAliases.setAliasesLevel(Global.ALIASESLEVEL_1);
		
		LeaseBoxRela boxRela = new LeaseBoxRela();
		boxRela.setAliasesId(aliasesId);
		boxRela.setBoxId(box);
		
		storagestationaService.insertBoxInfoToRegisterUser(leaseAliases,boxRela);
		
		return SUCCESS;
	}
	
	
	/**
	 * 校验用户名是否重复！
	 * @throws Exception
	 */
	public void verifyUserAccount() throws Exception{
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
	 * 查看个人信息
	 * @return
	 * @throws Exception
	 */
	public String getUserInfo() throws Exception{
		String userId = SessionManger.loadPortalUserSession(request).getUserId();
		User user = userService.loadUserByUserId(userId);
		request.setAttribute("user",user);
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改密码页面
	 * @return
	 * @throws Exception
	 */
	public String toUpdatePassword() throws Exception{
		String userId = SessionManger.loadPortalUserSession(request).getUserId();
		
		User user = userService.loadUserByUserId(userId);
		request.setAttribute("user", user);
		return SUCCESS;
	}
	
	/**
	 * 修改密码
	 * @return
	 * @throws Exception
	 */
	public String doUpdatePassword() throws Exception{
		String userId = request.getParameter("userId");
		String password = request.getParameter("newPassword");
		
		User user = userService.loadUserByUserId(userId);
		user.setUserId(userId);
		user.setPassword(MD5.getMD5Str(password));
		userService.updateUser(user);
		
		request.setAttribute("user", user);
		request.setAttribute("successMsg", "密码修改成功！");
		return SUCCESS;
	}
	
	/**
	 * 校验旧密码是否正确
	 * @throws Exception
	 */
	public void checkOldPasswod() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String oldPassword = MD5.getMD5Str(request.getParameter("oldPassword"));
		String userId = SessionManger.loadPortalUserSession(request).getUserId();
		User user = userService.loadUserByUserId(userId);
		if(oldPassword.equals(user.getPassword())){
			response.getWriter().write("OK");
		}else{
			response.getWriter().write("旧密码输入错误！");
		}
	}
	
	/**
	 * 跳转到修改用户基本信息页面
	 * @return
	 * @throws Exception
	 */
	public String toUdpateUserInfo() throws Exception{
		String userId = SessionManger.loadPortalUserSession(request).getUserId();
		User user = userService.loadUserByUserId(userId);
		List<FlagDictionary> idList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_PAPERWORK_TYPE);//证件类型
		
		request.setAttribute("idList", idList);
		request.setAttribute("user", user);
		return SUCCESS;
	}
	
	/**
	 * 修改用户基本信息
	 * @return
	 * @throws Exception
	 */
	public String doUdpateUserInfo() throws Exception{
		String userId = request.getParameter("userId");
		String gender = request.getParameter("gender");
		String userName = request.getParameter("userName");
		String mobile = request.getParameter("mobile");		
		String idType = request.getParameter("idType");
		String idNo = request.getParameter("idNo");
		String QQ = request.getParameter("QQ");
		String weixin = request.getParameter("weixin");
		String wb = request.getParameter("wb");
		String email = request.getParameter("email");
		String usualAddress = request.getParameter("usualAddress");
		String zipCode = request.getParameter("zipCode");
		String registerAddress = request.getParameter("registerAddress");
		
		User user = userService.loadUserByUserId(userId);
		user.setGender(Integer.parseInt(gender));
		user.setUserName(userName);
		user.setMobileNumber(mobile);
		user.setPaperworkType(Integer.parseInt(idType));
		user.setPaperworkNum(idNo);
		user.setQq(QQ);
		user.setWeixin(weixin);
		user.setWb(wb);
		user.setEmail(email);
		user.setHabitualResidence(usualAddress);
		user.setZipCode(zipCode);
		user.setHouseholdRegisterAddress(registerAddress);
		
		userService.updateUser(user);
		List<FlagDictionary> idList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_PAPERWORK_TYPE);//证件类型
		
		request.setAttribute("idList", idList);
		request.setAttribute("successMsg", "用户信息修改成功！");
		request.setAttribute("user", user);
		return SUCCESS;
	}
	
	
	/**
	 * 获取用户的订单列表
	 * @return
	 * @throws Exception
	 */
	public String loadOrderList() throws Exception
	{
		String userId = SessionManger.loadPortalUserSession(request).getUserId();
		int pageNum 		= StringUtil.formatStringToInteger(request.getParameter("pageNum"), 1);
		String orderCode 	= StringUtil.formatStringTrimToNull(request.getParameter("orderCode"));
		String mobileNumber = StringUtil.formatStringTrimToNull(request.getParameter("mobileNumber"));
		
		GetOrderListParam golp = new GetOrderListParam();
		golp.setUserId(userId);
		golp.setOrderCode(orderCode);
		golp.setMobileNumber(mobileNumber);

		int allCount = orderService.getOrderListSize(golp);
		
		Page page = new Page();
		page.setPageNumber(pageNum);
		page.setPageSize(Global.PAGE_SIZE);
		page.setPageAllCount(allCount);
		
		List<OrderWrapper> ows = orderService.getOrderListLimit(golp, page);

		request.setAttribute("page", page);
		request.setAttribute("golp", golp);
		request.setAttribute("ows", ows);
		return SUCCESS;
	}
	
}
