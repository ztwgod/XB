package cn.com.xb.service.impl;

import java.util.List;

import cn.com.xb.daox.IOrderDaox;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.displayWrapper.OrderWrapper;
import cn.com.xb.domain.parameterWrapper.GetOrderListParam;
import cn.com.xb.service.OrderService;

public class OrderServiceImpl implements OrderService
{
	private IOrderDaox orderDaox;
	
	public void setOrderDaox(IOrderDaox orderDaox)
	{
		this.orderDaox = orderDaox;
	}
	
	
	@Override
	public List<OrderWrapper> getOrderListLimit(GetOrderListParam golp, Page page) throws Exception
	{
		if(golp == null)
		{
			golp = new GetOrderListParam();
		}
		return orderDaox.getOrderListLimit(golp, page.getStartItems(), page.getPageSize());
	}
	
	
	@Override
	public int getOrderListSize(GetOrderListParam golp) throws Exception
	{
		if(golp == null)
		{
			golp = new GetOrderListParam();
		}
		return orderDaox.getOrderListSize(golp);
	}	
}
