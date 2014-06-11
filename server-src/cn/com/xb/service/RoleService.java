package cn.com.xb.service;

import java.util.List;

import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Role;

/**
 * 角色管理相关事务
 * @author DiGua
 *
 */
public interface RoleService
{
	
	/**
	 * 添加角色信息
	 * @throws Exception
	 */
	public void insertRoleInfo(Role role) throws Exception;
	
	
	/**
	 * 获取角色总记录数
	 * @return
	 * @throws Exception
	 */
	public int getRoleListSize() throws Exception;
	
	
	/**
	 * 查询角色列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Role> getRoleList(Page page) throws Exception;
	
	
	/**
	 * 删除角色信息
	 * @param roleId
	 * @throws Exception
	 */
	public void deleteRoleInfo(String roleId) throws Exception;
	
	
	/**
	 * 获取角色详情
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public Role getRoleInfoByRoleId(String roleId) throws Exception;
	
	
	/**
	 * 修改角色信息
	 * @param role
	 * @throws Exception
	 */
	public void updateRoleInfo(Role role) throws Exception;
	
	
	/**
	 * 更新角色模块关联信息
	 * @param roleId
	 * @param moduleIds
	 * @throws Exception
	 */
	public void updateRoleModule(String roleId, List<String> moduleIds) throws Exception;
	
	/**
	 * 获取所有角色信息
	 * @return
	 * @throws Exception
	 */
	public List<Role> getAllRoles() throws Exception;
	
	
	public List<Role> getRoles(Role role) throws Exception;
}
