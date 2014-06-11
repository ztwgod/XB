package cn.com.xb.plat.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.com.xb.domain.base.FlagDictionary;
import cn.com.xb.domain.base.Module;
import cn.com.xb.domain.base.Page;
import cn.com.xb.service.FlagDictionaryService;
import cn.com.xb.service.ModuleService;

import com.opensymphony.xwork2.ActionSupport;

public class ModuleAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private static final long serialVersionUID = -578697069556382981L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ModuleService moduleService;
	private FlagDictionaryService flagDictionaryService;

	public void setFlagDictionaryService(FlagDictionaryService flagDictionaryService) {
		this.flagDictionaryService = flagDictionaryService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 跳转到模块首页
	 * @return
	 * @throws Exception
	 */
	public String listModule() throws Exception {
		String _pageNumber = request.getParameter("pageNumber")==null?"1":request.getParameter("pageNumber");
		String moduleName = request.getParameter("moduleName")==null?"":request.getParameter("moduleName");
		String moduleType = request.getParameter("moduleType")==null?"":request.getParameter("moduleType");
		if("".equals(moduleType)){
			moduleType = "0";
		}		
		Module module = new Module();
		module.setModuleName(moduleName);
		module.setModuleType(Integer.parseInt(moduleType));
		
		int items = moduleService.loadItems(module);
		Page page = new Page();
		page.setPageAllCount(items);
		page.setPageNumber(Integer.parseInt(_pageNumber));
		List<Module> modules = moduleService.loadModuleLimit(module, page);
		List<FlagDictionary> typelist = flagDictionaryService.loadDictionaryByTypeId("28");
		
		request.setAttribute("module", module);
		request.setAttribute("modules", modules);
		request.setAttribute("page", page);
		request.setAttribute("typelist", typelist);
		
		return SUCCESS;
	}

	/**
	 * 跳转到添加子模块页面
	 * @return
	 * @throws Exception
	 */
	public String toAddModule()throws Exception{
		String moduleId = request.getParameter("moduleId");		
		Module module = moduleService.loadModuleByModuleId(moduleId); 
		List<FlagDictionary> typelist = flagDictionaryService.loadDictionaryByTypeId("28");
		List<FlagDictionary> statusList = flagDictionaryService.loadDictionaryByTypeId("29");
		
		request.setAttribute("statusList", statusList);
		request.setAttribute("typelist", typelist);
		request.setAttribute("module", module);
		return SUCCESS;
	}
	
	/**
	 * 添加模块方法
	 * @return
	 * @throws Exception
	 */
	public String doAddModule() throws Exception{
		String parentModuleId = request.getParameter("parentModuleId");
		String moduleName = request.getParameter("moduleName");
		String moduleLink = request.getParameter("moduleLink");
		String moduleCode = request.getParameter("moduleCode");
		String moduleStatus = request.getParameter("moduleStatus");
		String moduleType = request.getParameter("moduleType");
		String showSeq =  request.getParameter("showSeq");
		String moduleDesc = request.getParameter("moduleDesc");
		
		Module module = new Module();
		module.setParentMId(parentModuleId);
		module.setModuleName(moduleName);
		module.setModuleLink(moduleLink);
		module.setModuleCode(moduleCode);
		module.setStatus(Integer.parseInt(moduleStatus));
		module.setModuleType(Integer.parseInt(moduleType));
		module.setShowSeq(Integer.parseInt(showSeq));
		module.setModuleDesc(moduleDesc);
		
		moduleService.insertModule(module);		
		return SUCCESS;
	}
	
	/**
	 * 删除模块信息
	 * @return
	 * @throws Exception
	 */
	public String doDeleteModule() throws Exception{
		String moduleId = request.getParameter("moduleId");
		moduleService.deleteModule(moduleId);
		return SUCCESS;
	}
	
	/**
	 * 修改模块信息
	 * @return
	 * @throws Exception
	 */
	public String toUpdateModule()throws Exception{
		String moduleId = request.getParameter("moduleId");
		Module module = moduleService.loadModuleByModuleId(moduleId);
		Module parentModule = moduleService.loadModuleByModuleId(module.getParentMId());
		
		List<FlagDictionary> typelist = flagDictionaryService.loadDictionaryByTypeId("28");
		List<FlagDictionary> statusList = flagDictionaryService.loadDictionaryByTypeId("29");
		
		request.setAttribute("parentModule", parentModule);
		request.setAttribute("statusList", statusList);
		request.setAttribute("typelist", typelist);
		request.setAttribute("module", module);
		return SUCCESS;
	}
	
	/**
	 * 修改模块方法
	 * @return
	 * @throws Exception
	 */
	public String doUpdateModule() throws Exception{
		String moduleId = request.getParameter("moduleId");
		String moduleName = request.getParameter("moduleName");
		String moduleLink = request.getParameter("moduleLink");
		//String moduleCode = request.getParameter("moduleCode");
		String moduleStatus = request.getParameter("moduleStatus");
		String moduleType = request.getParameter("moduleType");
		String showSeq =  request.getParameter("showSeq");
		String moduleDesc = request.getParameter("moduleDesc");
		
		Module module = moduleService.loadModuleByModuleId(moduleId);		
		module.setModuleName(moduleName);
		module.setModuleLink(moduleLink);
		//module.setModuleCode(moduleCode);
		module.setStatus(Integer.parseInt(moduleStatus));
		module.setModuleType(Integer.parseInt(moduleType));
		module.setShowSeq(Integer.parseInt(showSeq));
		module.setModuleDesc(moduleDesc);
		
		moduleService.updateModule(module);		
		return SUCCESS;
	}
	
	/**
	 * 校验模块名称是否重复
	 * @throws Exception
	 */
	public void verifyModuleCode() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");		
		String moduleCode = request.getParameter("moduleCode");
		int itmes = moduleService.loadItemsByModuleCode(moduleCode);
		if(itmes==0){
			response.getWriter().write("OK");
		}else{
			response.getWriter().write("该模块代码已存在！");
		}
	}	
}
