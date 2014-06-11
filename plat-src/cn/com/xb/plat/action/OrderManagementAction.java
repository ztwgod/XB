package cn.com.xb.plat.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.StoragestationGroup;
import cn.com.xb.domain.displayWrapper.OrderWrapper;
import cn.com.xb.domain.parameterWrapper.GetOrderListParam;
import cn.com.xb.service.OrderService;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.util.Global;
import cn.com.xb.util.StringUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 订单管理
 * 
 * @author DiGua
 * 
 */
public class OrderManagementAction extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	private OrderService orderService;
	private StoragestationaService storagestationaService;
	
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

	public void setOrderService(OrderService orderService)
	{
		this.orderService = orderService;
	}
	public void setStoragestationaService(StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}
	
	
	
	
	
	/**
	 * 查询订单列表
	 * @return
	 * @throws Exception
	 */
	public String getOrderList() throws Exception
	{
		int pageNum 		= StringUtil.formatStringToInteger(request.getParameter("pageNum"), 1);
		String userId		= StringUtil.formatStringTrimToNull(request.getParameter("userId"));
		String orderCode 	= StringUtil.formatStringTrimToNull(request.getParameter("orderCode"));
		String mobileNumber = StringUtil.formatStringTrimToNull(request.getParameter("mobileNumber"));
		// 添加查询条件  add 2013-12-31
		String groupId		= StringUtil.formatStringTrimToNull(request.getParameter("groupId"));
		String ssCode		= StringUtil.formatStringTrimToNull(request.getParameter("ssCode"));
		String startDate	= StringUtil.formatStringTrimToNull(request.getParameter("startDate"));
		String endDate		= StringUtil.formatStringTrimToNull(request.getParameter("endDate"));
		int    pageSize		= StringUtil.formatStringToInteger(request.getParameter("pageSize"), 10);
		
		
		GetOrderListParam golp = new GetOrderListParam();
		golp.setUserId(userId);
		golp.setOrderCode(orderCode);
		golp.setMobileNumber(mobileNumber);
		golp.setGroupId(groupId);
		golp.setSsCode(ssCode);
		golp.setStartDate(startDate);
		golp.setEndDate(endDate);

		int allCount = orderService.getOrderListSize(golp);
		
		Page page = new Page();
		page.setPageNumber(pageNum);
		page.setPageSize(pageSize);
		page.setPageAllCount(allCount);
		
		List<OrderWrapper> ows = orderService.getOrderListLimit(golp, page);
		List<StoragestationGroup> storGroup = storagestationaService.loadAllStoragestationGroup();
		
		request.setAttribute("storGroup", storGroup);
		request.setAttribute("page", page);
		request.setAttribute("golp", golp);
		request.setAttribute("ows", ows);
		return SUCCESS;
	}
	
}
