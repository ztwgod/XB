package cn.com.xb.daox;

import java.util.List;

import cn.com.xb.domain.displayWrapper.OrderWrapper;
import cn.com.xb.domain.parameterWrapper.GetOrderListParam;

public interface IOrderDaox
{
	public int getOrderListSize(GetOrderListParam golp) throws Exception;
	
	public List<OrderWrapper> getOrderListLimit(GetOrderListParam golp, int startInd, int pageSize) throws Exception;
}
