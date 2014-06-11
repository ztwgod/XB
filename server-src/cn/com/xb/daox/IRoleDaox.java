package cn.com.xb.daox;

import java.util.List;

import cn.com.xb.domain.base.Role;

public interface IRoleDaox
{
	/**
	 * 查询角色记录数
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
	public List<Role> getRoleList(int startInd, int pageSize) throws Exception;
	
	
	/**
	 * 删除与roleId相关的所有角色模块关联记录
	 * @param roleId
	 * @throws Exception
	 */
	public void deleteRoleModuleByRoleId(String roleId) throws Exception;
	
	
	/**
	 * 插入语roleId相关的所有角色模块关联记录
	 * @param roleId
	 * @param moduleIds
	 * @throws Exception
	 */
	public void insertRoleModuleByRoleId(String roleId, List moduleIds) throws Exception;
	
	/**
	 * 获取未关闭的记录数
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public int getRoleItems(String roleId) throws Exception;
	
	public List<Role> getRoles(Role role) throws Exception;
}
