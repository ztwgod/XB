package cn.com.xb.domain.parameterWrapper;

import java.io.Serializable;

public class GetBoxStatusListParam implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String userId;		// 用户ID
	private String groupId;		// 物箱组ID
	private String ssCode;		// 物箱Code
	private String startDate;	// 开始日期
	private String endDate;		// 结束日期
	private String startTime;	// 开始时间
	private String endTime;		// 结束时间
	private int boxType;		// 箱子类型
	private int boxStatus;		// 箱子运行状态
	
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
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
	public String getStartTime()
	{
		return startTime;
	}
	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}
	public String getEndTime()
	{
		return endTime;
	}
	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}
	public int getBoxType()
	{
		return boxType;
	}
	public void setBoxType(int boxType)
	{
		this.boxType = boxType;
	}
	public int getBoxStatus()
	{
		return boxStatus;
	}
	public void setBoxStatus(int boxStatus)
	{
		this.boxStatus = boxStatus;
	}
}
