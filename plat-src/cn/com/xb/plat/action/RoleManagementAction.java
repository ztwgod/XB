package cn.com.xb.plat.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.com.xb.domain.base.ExpressCompany;
import cn.com.xb.domain.base.FlagDictionary;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Role;
import cn.com.xb.domain.base.RoleModuleObject;
import cn.com.xb.service.CourierService;
import cn.com.xb.service.FlagDictionaryService;
import cn.com.xb.service.ModuleService;
import cn.com.xb.service.RoleService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.StringUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 角色管理
 * 	1、处理角色的添加，修改，查询
 * 
 * @author DiGua
 * 
 */
public class RoleManagementAction extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	private FlagDictionaryService flagDictionaryService;
	private RoleService roleService;
	private ModuleService moduleService;
	private String roleId;
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;

	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}
	public void setHttpSession(HttpSession session)
	{
		this.session = session;
	}
	public void setFlagDictionaryService(FlagDictionaryService flagDictionaryService)
	{
		this.flagDictionaryService = flagDictionaryService;
	}
	public void setRoleService(RoleService roleService)
	{
		this.roleService = roleService;
	}
	public void setModuleService(ModuleService moduleService)
	{
		this.moduleService = moduleService;
	}
	public String getRoleId()
	{
		return roleId;
	}
	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}
	
	
	
	/**
	 * 跳转至添加角色页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toAddRolePage() throws Exception
	{
		// 获取角色状态列表
		List<FlagDictionary> serviceStatusList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_ROLE_STATUS);
		// 获取角色类型列表
		List<FlagDictionary> roleTypeList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_ROLE_TYPE);
		
		request.setAttribute("serviceStatusList", serviceStatusList);
		request.setAttribute("roleTypeList", roleTypeList);
		return SUCCESS;
	}

	
	/**
	 * 添加角色
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addRole() throws Exception
	{
		String roleId = KeyHelper.creatKey();
		String roleName = StringUtil.formatStringTrimToNull(request.getParameter("roleName"));
		int    roleType = StringUtil.formatStringToInteger(request.getParameter("roleType"), 0);
		String roleDesc = StringUtil.formatStringTrimToNull(request.getParameter("roleDesc"));
		int status = StringUtil.formatStringToInteger(request.getParameter("status"), 2);
		
		Role role = new Role();
		role.setRoleId(roleId);
		role.setRoleName(roleName);
		role.setRoleType(roleType);
		role.setRoleDesc(roleDesc);
		role.setCreator("1");
		role.setCreateTime(new Timestamp(new Date().getTime()));
		role.setLastUpdateUser("1");
		role.setLastUpdateTime(new Timestamp(new Date().getTime()));
		role.setStatus(status);
		
		roleService.insertRoleInfo(role);
		
		return SUCCESS;
	}
	
	
	/**
	 * 查询角色列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getRoleList() throws Exception
	{
		int pageNo = StringUtil.formatStringToInteger(request.getParameter("pageNo"), 1);
		
		int roleCount = roleService.getRoleListSize();
		
		Page page = new Page();
		page.setPageNumber(pageNo);
		page.setPageSize(Global.PAGE_SIZE);
		page.setPageAllCount(roleCount);
		
		List<Role> roles = roleService.getRoleList(page);
		
		request.setAttribute("roles", roles);
		request.setAttribute("page", page);
		return SUCCESS;
	}
	
	
	/**
	 * 删除角色信息
	 * @return
	 * @throws Exception
	 */
	public String deleteRoleInfo() throws Exception
	{
		String roleId = StringUtil.formatStringTrimToNull(request.getParameter("roleId"));
		
		roleService.deleteRoleInfo(roleId);
		return SUCCESS;
	}
	
	
	/**
	 * 跳转至修改角色信息页面
	 * @return
	 * @throws Exception
	 */
	public String toModifyRolePage() throws Exception
	{
		String roleId = StringUtil.formatStringTrimToNull(request.getParameter("roleId"));
		
		Role role = roleService.getRoleInfoByRoleId(roleId);
		List<FlagDictionary> serviceStatusList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_ROLE_STATUS);
		List<FlagDictionary> roleTypeList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_ROLE_TYPE);

		request.setAttribute("serviceStatusList", serviceStatusList);
		request.setAttribute("roleTypeList", roleTypeList);
		request.setAttribute("role", role);
		return SUCCESS;
	}
	
	
	/**
	 * 执行角色信息修改
	 * @return
	 * @throws Exception
	 */
	public String doModifyRole() throws Exception
	{
		String roleId = StringUtil.formatStringTrimToNull(request.getParameter("roleId"));
		String roleName = StringUtil.formatStringTrimToNull(request.getParameter("roleName"));
		int    roleType = StringUtil.formatStringToInteger(request.getParameter("roleType"), 0);
		String roleDesc = StringUtil.formatStringTrimToNull(request.getParameter("roleDesc"));
		int status = StringUtil.formatStringToInteger(request.getParameter("status"), 2);
		
		Role role = new Role();
		role.setRoleId(roleId);
		role.setRoleName(roleName);
		role.setRoleType(roleType);
		role.setRoleDesc(roleDesc);
		role.setCreator("1");
		role.setCreateTime(new Timestamp(new Date().getTime()));
		role.setLastUpdateUser("1");
		role.setLastUpdateTime(new Timestamp(new Date().getTime()));
		role.setStatus(status);
		
		roleService.updateRoleInfo(role);
		this.roleId = roleId;
		return SUCCESS;
	}
	
	
	/**
	 * 跳转至修改角色关联模块界面
	 * @return
	 * @throws Exception
	 */
	public String toModifyRoleModulePage() throws Exception
	{
		String roleId = StringUtil.formatStringTrimToNull(request.getParameter("roleId"));
		roleId = roleId == null ? StringUtil.formatStringTrimToNull(request.getAttribute("roleId")) : roleId;
		String moduleId = StringUtil.formatStringTrimToNull(request.getParameter("moduleId"));
		
		moduleId = moduleId == null ? "0" : moduleId;
		List<RoleModuleObject> rmos = moduleService.getRoleModuleObjectList(roleId, moduleId);
		
		request.setAttribute("rmos", rmos);
		request.setAttribute("roleId", roleId);
		request.setAttribute("moduleId", moduleId);
		return SUCCESS;
	}
	
	/**
	 * 获取模块子目录列表
	 * @return
	 * @throws Exception
	 */
	public String getSubRoleModuleList() throws Exception
	{
		String roleId = StringUtil.formatStringTrimToNull(request.getParameter("roleId"));
		String moduleId = StringUtil.formatStringTrimToNull(request.getParameter("moduleId"));
		
		List<RoleModuleObject> rmos = moduleService.getRoleModuleObjectList(roleId, moduleId == null ? "0" : moduleId);

		request.setAttribute("rmos", rmos);
		request.setAttribute("moduleId", moduleId);
		return SUCCESS;
	}
	
	
	/**
	 * 修改角色关联模块
	 * @return
	 * @throws Exception
	 */
	public String doModifyRoleModule() throws Exception
	{
		String roleId = StringUtil.formatStringTrimToNull(request.getParameter("roleId"));
		String[] moduleId = request.getParameterValues("selectedModuleId");
		
		List<String> moduleIdList = StringUtil.asList(moduleId);
		
		roleService.updateRoleModule(roleId, moduleIdList);
		
		return SUCCESS;
	}
}
