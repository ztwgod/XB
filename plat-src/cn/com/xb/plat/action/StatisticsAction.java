package cn.com.xb.plat.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.com.xb.domain.base.ExpressCompany;
import cn.com.xb.domain.base.FlagDictionary;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.SsBoxnumLogx;
import cn.com.xb.domain.base.StoragestationGroup;
import cn.com.xb.domain.base.Transactionx;
import cn.com.xb.domain.displayWrapper.BoxStatusWrapper;
import cn.com.xb.domain.parameterWrapper.GetBoxStatusListParam;
import cn.com.xb.service.CourierService;
import cn.com.xb.service.FlagDictionaryService;
import cn.com.xb.service.SsBoxnumLogServer;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.service.TransactionService;
import cn.com.xb.util.ExcelUtils;
import cn.com.xb.util.Global;
import cn.com.xb.util.StringUtil;

import com.opensymphony.xwork2.ActionSupport;

public class StatisticsAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SsBoxnumLogServer ssBoxnumLogServer;
	private StoragestationaService storagestationaService;
	private TransactionService transactionService;
	private FlagDictionaryService flagDictionaryService;
	private CourierService courierService;
	
	public void setCourierService(CourierService courierService) {
		this.courierService = courierService;
	}

	public void setFlagDictionaryService(FlagDictionaryService flagDictionaryService) {
		this.flagDictionaryService = flagDictionaryService;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	public void setStoragestationaService(
			StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}

	public void setSsBoxnumLogServer(SsBoxnumLogServer ssBoxnumLogServer) {
		this.ssBoxnumLogServer = ssBoxnumLogServer;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 物箱使用情况统计
	 */
	public String usage() throws Exception{
		String startDate = request.getParameter("startDate")==null?"":request.getParameter("startDate");
		String endDate = request.getParameter("endDate")==null?"":request.getParameter("endDate");
		String startTime = request.getParameter("startTime")==null?"":request.getParameter("startTime");
		String endTime = request.getParameter("endTime")==null?"":request.getParameter("endTime");
		String ssCode = request.getParameter("ssCode")==null?"":request.getParameter("ssCode");
		String groupId = request.getParameter("groupId")==null?"":request.getParameter("groupId");
		String _pageNumber = request.getParameter("pageNumber")==null?"1":request.getParameter("pageNumber");
		int pageNumber = Integer.parseInt(_pageNumber);
		
		SsBoxnumLogx params = new SsBoxnumLogx();
		params.setsDate(startDate);
		params.seteDate(endDate);
		params.setsTime(startTime);
		params.seteTime(endTime);
		params.setSsCode(ssCode);
		params.setGroupId(groupId);
		
		int allItems = ssBoxnumLogServer.getItems(params);

		Page page = new Page();
		page.setPageAllCount(allItems);
		page.setPageNumber(pageNumber);
		
		List<SsBoxnumLogx> lists = ssBoxnumLogServer.getSSBoxNumLogLists(params, page);
		List<StoragestationGroup> storGroup = storagestationaService.loadAllStoragestationGroup();
		
		request.setAttribute("lists", lists);
		request.setAttribute("page", page);
		request.setAttribute("params", params);
		request.setAttribute("storGroup", storGroup);
		
		return SUCCESS;
	}
	
	/**
	 * 导出EXCEL
	 * @return
	 * @throws Exception
	 */
	public void createUsageExcel() throws Exception{
		String startDate = request.getParameter("startDate")==null?"":request.getParameter("startDate");
		String endDate = request.getParameter("endDate")==null?"":request.getParameter("endDate");
		String startTime = request.getParameter("startTime")==null?"":request.getParameter("startTime");
		String endTime = request.getParameter("endTime")==null?"":request.getParameter("endTime");
		String ssCode = request.getParameter("ssCode")==null?"":request.getParameter("ssCode");
		String groupId = request.getParameter("groupId")==null?"":request.getParameter("groupId");
		
		SsBoxnumLogx params = new SsBoxnumLogx();
		params.setsDate(startDate);
		params.seteDate(endDate);
		params.setsTime(startTime);
		params.seteTime(endTime);
		params.setSsCode(ssCode);
		params.setGroupId(groupId);
		params.setExcel(true);
		
		List<SsBoxnumLogx> lists = ssBoxnumLogServer.getSSBoxNumLogLists(params, null);
		//HttpServletResponse response = ServletActionContext.getResponse();
		ExcelUtils.writeBoxNumLogExcel(response,lists);
		//return SUCCESS;
	}
	
	/**
	 * 物箱业务记录
	 * @return
	 * @throws Exception
	 */
	public String business() throws Exception{
		String _pageNumber = request.getParameter("pageNumber")==null?"1":request.getParameter("pageNumber");
		int pageNumber = Integer.parseInt(_pageNumber);
		
		String startDate = request.getParameter("startDate")==null?"":request.getParameter("startDate");
		String endDate = request.getParameter("endDate")==null?"":request.getParameter("endDate");
		String startTime = request.getParameter("startTime")==null?"":request.getParameter("startTime");
		String endTime = request.getParameter("endTime")==null?"":request.getParameter("endTime");
		String ssCode = request.getParameter("ssCode")==null?"":request.getParameter("ssCode");
		String groupId = request.getParameter("groupId")==null?"":request.getParameter("groupId");
		
		int boxType = StringUtil.formatStringToInteger(request.getParameter("boxType"), 0);
		String express = request.getParameter("express")==null?"":request.getParameter("express");
		int transType = StringUtil.formatStringToInteger(request.getParameter("transType"), 0);
		
		Transactionx tranx = new Transactionx();
		tranx.setsDate(startDate);
		tranx.seteDate(endDate);
		tranx.setsTime(startTime);
		tranx.seteTime(endTime);
		tranx.setSsCode(ssCode);
		tranx.setGroupId(groupId);
		tranx.setExpressDeliveryId(express);//快递公司
		tranx.setTransType(transType);
		tranx.setSizeType(boxType);
		
		int allCount = transactionService.getTransItems(tranx);
		Page page = new Page();
		page.setPageAllCount(allCount);
		page.setPageNumber(pageNumber);
		
		List<Transactionx> lists = transactionService.getTransLists(tranx, page);
		List<StoragestationGroup> storGroup = storagestationaService.loadAllStoragestationGroup();
		
		List<FlagDictionary> boxTypes = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_BOX_SIZE);
		List<FlagDictionary> transTypes = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_TRANS_TYPE);
		
		// 查询快递公司列表
		List<ExpressCompany> ecs = courierService.getCourierCompanies(null,null);
		
		request.setAttribute("lists", lists);
		request.setAttribute("page", page);
		request.setAttribute("storGroup", storGroup);
		request.setAttribute("tranx", tranx);
		request.setAttribute("boxTypes", boxTypes);
		request.setAttribute("transTypes", transTypes);
		request.setAttribute("ecs", ecs);
		
		return SUCCESS;
	}
	
	/**
	 * 导出Excel
	 * @throws Exception
	 */
	public void createBusinessExcel() throws Exception{
		String startDate = request.getParameter("startDate")==null?"":request.getParameter("startDate");
		String endDate = request.getParameter("endDate")==null?"":request.getParameter("endDate");
		String startTime = request.getParameter("startTime")==null?"":request.getParameter("startTime");
		String endTime = request.getParameter("endTime")==null?"":request.getParameter("endTime");
		String ssCode = request.getParameter("ssCode")==null?"":request.getParameter("ssCode");
		String groupId = request.getParameter("groupId")==null?"":request.getParameter("groupId");
		
		int boxType = StringUtil.formatStringToInteger(request.getParameter("boxType"), 0);
		String express = request.getParameter("express")==null?"":request.getParameter("express");
		int transType = StringUtil.formatStringToInteger(request.getParameter("transType"), 0);
		
		Transactionx tranx = new Transactionx();
		tranx.setsDate(startDate);
		tranx.seteDate(endDate);
		tranx.setsTime(startTime);
		tranx.seteTime(endTime);
		tranx.setSsCode(ssCode);
		tranx.setGroupId(groupId);
		tranx.setExpressDeliveryId(express);//快递公司
		tranx.setTransType(transType);
		tranx.setSizeType(boxType);
		tranx.setExcel(true);
		
		List<Transactionx> lists = transactionService.getTransLists(tranx, null);
		ExcelUtils.writeBusinessExcel(response,lists);
	}
	
	/**
	 * 获取箱子状态信息
	 * @return
	 * @throws Exception
	 */
	public String getStorStatusList() throws Exception
	{
		int pageNo = StringUtil.formatStringToInteger(request.getParameter("pageNo"), 1);
		
		String startDate = request.getParameter("startDate")==null?"":request.getParameter("startDate");
		String endDate = request.getParameter("endDate")==null?"":request.getParameter("endDate");
		String startTime = request.getParameter("startTime")==null?"":request.getParameter("startTime");
		String endTime = request.getParameter("endTime")==null?"":request.getParameter("endTime");
		
		String groupId = request.getParameter("groupId")==null?"":request.getParameter("groupId");
		String ssCode = request.getParameter("ssCode")==null?"":request.getParameter("ssCode");
		int boxType = StringUtil.formatStringToInteger(request.getParameter("boxType"), 0);
		int boxStatus = StringUtil.formatStringToInteger(request.getParameter("boxStatus"), 0);
		
		GetBoxStatusListParam bslp = new GetBoxStatusListParam();
		bslp.setGroupId(groupId);
		bslp.setSsCode(ssCode);
		bslp.setBoxType(boxType);
		bslp.setBoxStatus(boxStatus);
		bslp.setStartDate(startDate);
		bslp.setEndDate(endDate);
		bslp.setStartTime(startTime);
		bslp.setEndTime(endTime);
		
		int count = storagestationaService.getBoxStatusListSize(bslp);
		Page page = new Page();
		page.setPageNumber(pageNo);
		page.setPageAllCount(count);
		
		List<BoxStatusWrapper> bsws = storagestationaService.getBoxStatusListLimit(bslp, page);
		
		// 箱子类型
		List<FlagDictionary> boxTypes = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_BOX_SIZE);
		// 箱子运行状态
		List<FlagDictionary> boxStatusP = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_BOX_RUN_STATUS);
		List<StoragestationGroup> storGroup = storagestationaService.loadAllStoragestationGroup();
		
		
		request.setAttribute("bsws", bsws);
		request.setAttribute("page", page);
		request.setAttribute("bslp", bslp);
		request.setAttribute("boxTypes", boxTypes);
		request.setAttribute("boxStatuss", boxStatusP);
		request.setAttribute("storGroup", storGroup);
		return SUCCESS;
	}
	
	/**
	 * 导出箱子状态信息到Excel
	 * @throws Exception
	 */
	public void exportStorStatusExcel() throws Exception
	{
		String startDate = request.getParameter("startDate")==null?"":request.getParameter("startDate");
		String endDate = request.getParameter("endDate")==null?"":request.getParameter("endDate");
		String startTime = request.getParameter("startTime")==null?"":request.getParameter("startTime");
		String endTime = request.getParameter("endTime")==null?"":request.getParameter("endTime");
		
		String groupId = request.getParameter("groupId")==null?"":request.getParameter("groupId");
		String ssCode = request.getParameter("ssCode")==null?"":request.getParameter("ssCode");
		int boxType = StringUtil.formatStringToInteger(request.getParameter("boxType"), 0);
		int boxStatus = StringUtil.formatStringToInteger(request.getParameter("boxStatus"), 0);
		
		GetBoxStatusListParam bslp = new GetBoxStatusListParam();
		bslp.setGroupId(groupId);
		bslp.setSsCode(ssCode);
		bslp.setBoxType(boxType);
		bslp.setBoxStatus(boxStatus);
		bslp.setStartDate(startDate);
		bslp.setEndDate(endDate);
		bslp.setStartTime(startTime);
		bslp.setEndTime(endTime);
		
		List<BoxStatusWrapper> bsws = storagestationaService.getBoxStatusListLimit(bslp, null);
		
		ExcelUtils.writeStorStatusExcel(response,bsws);
	}
}
