package cn.com.xb.domain.parameterWrapper;

import java.io.Serializable;

public class GetOrderListParam implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String userId;		// 用户ID
	private String orderCode;	// 订单号
	private String mobileNumber;// 电话号码
	private String groupId;		// 物箱组ID
	private String ssCode;		// 物箱Code
	private String startDate;	// 开始时间
	private String endDate;		// 结束时间
	
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getOrderCode()
	{
		return orderCode;
	}
	public void setOrderCode(String orderCode)
	{
		this.orderCode = orderCode;
	}
	public String getMobileNumber()
	{
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}
	public String getGroupId()
	{
		return groupId;
	}
	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}
	public String getSsCode()
	{
		return ssCode;
	}
	public void setSsCode(String ssCode)
	{
		this.ssCode = ssCode;
	}
	public String getStartDate()
	{
		return startDate;
	}
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	public String getEndDate()
	{
		return endDate;
	}
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
}
