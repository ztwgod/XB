package cn.com.xb.service.impl;

import java.util.List;

import cn.com.xb.dao.IRoleDao;
import cn.com.xb.daox.IRoleDaox;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Role;
import cn.com.xb.service.RoleService;

public class RoleServiceImpl implements RoleService
{
	private IRoleDao roleDao;
	private IRoleDaox roleDaox;
	
	public void setRoleDao(IRoleDao roleDao)
	{
		this.roleDao = roleDao;
	}
	public void setRoleDaox(IRoleDaox roleDaox)
	{
		this.roleDaox = roleDaox;
	}
	
	
	
	@Override
	public void insertRoleInfo(Role role) throws Exception
	{
		roleDao.insert(role);
	}


	@Override
	public int getRoleListSize() throws Exception
	{
		return roleDaox.getRoleListSize();
	}
	
	@Override
	public List<Role> getRoleList(Page page) throws Exception
	{
		return roleDaox.getRoleList(page.getStartItems(), page.getPageSize());
	}
	@Override
	public void deleteRoleInfo(String roleId) throws Exception
	{
		roleDao.delete(roleId);
		roleDaox.deleteRoleModuleByRoleId(roleId);
	}
	@Override
	public Role getRoleInfoByRoleId(String roleId) throws Exception
	{
		return roleDao.loadRoleByroleId(roleId);
	}
	@Override
	public void updateRoleInfo(Role role) throws Exception
	{
		roleDao.update(role);
	}
	@Override
	public void updateRoleModule(String roleId, List<String> moduleIds) throws Exception
	{
		// 删除所有关联记录
		roleDaox.deleteRoleModuleByRoleId(roleId);
		
		// 添加选择的所有关联记录
		if(moduleIds != null)
			roleDaox.insertRoleModuleByRoleId(roleId, moduleIds);
	}	
	
	public List<Role> getAllRoles() throws Exception {
		return roleDao.loadAll();
	}
	
	public List<Role> getRoles(Role role) throws Exception {
		
		return roleDaox.getRoles(role);
	}
	
}
