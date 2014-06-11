package cn.com.xb.service;

import java.util.List;

import cn.com.xb.domain.base.Module;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.RoleModuleObject;
import cn.com.xb.domain.base.UserRole;

public interface ModuleService {

	public List<Module> loadModuleLimit(Module module,Page page)throws Exception;

	public int loadItems(Module module) throws Exception;
	
	public Module loadModuleByModuleId(String moduleId) throws Exception;
	
	public void insertModule(Module module) throws Exception;
	
	public void deleteModule(String moduleId) throws Exception;
	
	public void updateModule(Module module) throws Exception;
	
	public List<Module> loadUserModule(List<UserRole> roleId);

	/**
	 * 根据角色ID和父模块ID查询其子模块列表[只查询有效模块]
	 * @return
	 * @throws Exception
	 */
	public List<RoleModuleObject> getRoleModuleObjectList(String roleId, String moduleId) throws Exception;
	
	public int loadItemsByModuleCode(String moduleCode) throws Exception;
	
}
