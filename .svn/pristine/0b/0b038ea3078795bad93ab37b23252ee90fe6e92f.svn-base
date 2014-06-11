package cn.com.xb.daox;

import java.util.List;

import cn.com.xb.domain.base.Module;
import cn.com.xb.domain.base.RoleModuleObject;

public interface IModuleDaox {

	public List<Module> loadModuleLimit(Module module, int start, int end) throws Exception;
	
	public int loadItems(Module module) throws Exception;
	
	public List<Module> loadUserModule(String roleId) throws Exception;
	
	public List<RoleModuleObject> getRoleModuleObjectList(String roleId, String moduleId) throws Exception;
	
	public int loadItemsByModuleCode(String moduleCode) throws Exception;
}
