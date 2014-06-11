package cn.com.xb.service;

import java.util.List;

import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.displayWrapper.OrderWrapper;
import cn.com.xb.domain.parameterWrapper.GetOrderListParam;

/**
 * 订单管理相关服务
 * 
 * @author DiGua
 *
 */
public interface OrderService
{
	
	public int getOrderListSize(GetOrderListParam golp) throws Exception;
	
	
	public List<OrderWrapper> getOrderListLimit(GetOrderListParam golp, Page page) throws Exception;
	
}