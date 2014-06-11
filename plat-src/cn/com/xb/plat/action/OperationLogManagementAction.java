package cn.com.xb.plat.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.displayWrapper.OperationLogWrapper;
import cn.com.xb.domain.parameterWrapper.GetOperationLogListParam;
import cn.com.xb.service.OperationLogService;
import cn.com.xb.util.ExcelUtils;
import cn.com.xb.util.Global;
import cn.com.xb.util.StringUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 操作日志管理
 * 
 * @author DiGua
 * 
 */
public class OperationLogManagementAction extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	private OperationLogService operationLogService;
	
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
	public void setOperationLogService(OperationLogService operationLogService)
	{
		this.operationLogService = operationLogService;
	}
	
	
	
	/**
	 * 查询订单列表
	 * @return
	 * @throws Exception
	 */
	public String getOperationLogList() throws Exception
	{
		int pageNum 		= StringUtil.formatStringToInteger(request.getParameter("pageNum"), 1);
		String operationUserName	= StringUtil.formatStringTrimToNull(request.getParameter("operationUserName"));
		String ssCode 		= StringUtil.formatStringTrimToNull(request.getParameter("ssCode"));
		String startDate 	= StringUtil.formatStringTrimToNull(request.getParameter("startDate"));
		String endDate 		= StringUtil.formatStringTrimToNull(request.getParameter("endDate"));
		String startTime 	= StringUtil.formatStringTrimToNull(request.getParameter("startTime"));
		String endTime 		= StringUtil.formatStringTrimToNull(request.getParameter("endTime"));
		
		GetOperationLogListParam golp = new GetOperationLogListParam();
		golp.setOperationUserName(operationUserName);
		golp.setSsCode(ssCode);
		golp.setStartDate(startDate);
		golp.setEndDate(endDate);
		golp.setStartTime(startTime);
		golp.setEndTime(endTime);

		int allCount = operationLogService.getOperationLogListSize(golp);
		
		Page page = new Page();
		page.setPageNumber(pageNum);
		page.setPageSize(Global.PAGE_SIZE);
		page.setPageAllCount(allCount);
		
		List<OperationLogWrapper> olws = operationLogService.getOperationLogListLimit(golp, page);

		request.setAttribute("page", page);
		request.setAttribute("golp", golp);
		request.setAttribute("olws", olws);
		return SUCCESS;
	}
	
	
	/**
	 * 导出操作日志Excel
	 * @throws Exception
	 */
	public void exportOperationLogExcel() throws Exception
	{
		String operationUserName	= StringUtil.formatStringTrimToNull(request.getParameter("operationUserName"));
		String ssCode 		= StringUtil.formatStringTrimToNull(request.getParameter("ssCode"));
		String startDate 	= StringUtil.formatStringTrimToNull(request.getParameter("startDate"));
		String endDate 		= StringUtil.formatStringTrimToNull(request.getParameter("endDate"));
		String startTime 	= StringUtil.formatStringTrimToNull(request.getParameter("startTime"));
		String endTime 		= StringUtil.formatStringTrimToNull(request.getParameter("endTime"));
		
		GetOperationLogListParam golp = new GetOperationLogListParam();
		golp.setOperationUserName(operationUserName);
		golp.setSsCode(ssCode);
		golp.setStartDate(startDate);
		golp.setEndDate(endDate);
		golp.setStartTime(startTime);
		golp.setEndTime(endTime);

		List<OperationLogWrapper> olws = operationLogService.getOperationLogListLimit(golp, null);

		HttpServletResponse response = ServletActionContext.getResponse();
		ExcelUtils.writeOperationLogExcel(response, olws);
	}
	
	
	/**
	 * 获取日志详情
	 * @return
	 * @throws Exception
	 */
	public String getOperationLogDetail() throws Exception
	{
		String opLogId = StringUtil.formatStringTrimToNull(request.getParameter("opLogId"));
		
		OperationLogWrapper olw = operationLogService.getOperationLogDetailByLogId(opLogId);
		
		request.setAttribute("olw", olw);
		return SUCCESS;
	}
}
