package cn.com.xb.service.impl;

import java.util.List;

import cn.com.xb.dao.IModuleDao;
import cn.com.xb.daox.IModuleDaox;
import cn.com.xb.domain.base.Module;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.RoleModuleObject;
import cn.com.xb.domain.base.UserRole;
import cn.com.xb.service.ModuleService;
import cn.com.xb.util.KeyHelper;

public class ModuleServiceImpl implements ModuleService{

	private IModuleDao moduleDao;
	private IModuleDaox moduleDaox;

	public void setModuleDaox(IModuleDaox moduleDaox) {
		this.moduleDaox = moduleDaox;
	}

	public void setModuleDao(IModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	public int loadItems(Module module) throws Exception {
		
		return moduleDaox.loadItems(module);
	}

	public List<Module> loadModuleLimit(Module module, Page page)throws Exception {
		
		return moduleDaox.loadModuleLimit(module, page.getStartItems(), page.getPageSize());
	}

	public Module loadModuleByModuleId(String moduleId) throws Exception {
		
		return moduleDao.loadModuleBymoduleId(moduleId);
	}

	public void insertModule(Module module) throws Exception {
		module.setModuleId(KeyHelper.creatKey());
		Module parentModule = moduleDao.loadModuleBymoduleId(module.getParentMId());
		module.setModuleLevel(parentModule.getModuleLevel()+1);
		moduleDao.insert(module);
	}
	
	public void deleteModule(String moduleId) throws Exception{
		moduleDao.delete(moduleId);
	}
	
	public void updateModule(Module module) throws Exception{
		moduleDao.update(module);
	}

	public List<Module> loadUserModule(List<UserRole> roleId){
		StringBuilder builder = new StringBuilder();
		for (UserRole userRole : roleId) {
			builder.append("'").append(userRole.getRoleId()).append("'").append(",");
		}
		if(builder.toString().endsWith(",")){
			builder.deleteCharAt(builder.length()-1);
		}
		
		List<Module> list = null;
		try {
			list = moduleDaox.loadUserModule(builder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RoleModuleObject> getRoleModuleObjectList(String roleId, String moduleId) throws Exception
	{
		return moduleDaox.getRoleModuleObjectList(roleId, moduleId);
	}

	public int loadItemsByModuleCode(String moduleCode) throws Exception {
		
		return moduleDaox.loadItemsByModuleCode(moduleCode);
	}
}
