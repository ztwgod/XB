package cn.com.xb.domain.parameterWrapper;

import java.io.Serializable;

public class GetCourierGroupParam implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String groupName;	// 快递员组名称
	private String permission;	// 快递员组权限
	private String districtId;	// 快递员组所属区域
	private String excoId;		// 快递员ID
	
	
	public String getGroupName()
	{
		return groupName;
	}
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}
	public String getPermission()
	{
		return permission;
	}
	public void setPermission(String permission)
	{
		this.permission = permission;
	}
	public String getDistrictId()
	{
		return districtId;
	}
	public void setDistrictId(String districtId)
	{
		this.districtId = districtId;
	}
	public String getExcoId()
	{
		return excoId;
	}
	public void setExcoId(String excoId)
	{
		this.excoId = excoId;
	}
}
