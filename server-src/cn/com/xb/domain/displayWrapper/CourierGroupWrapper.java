package cn.com.xb.domain.displayWrapper;

import java.io.Serializable;

/**
 * 快递员组列表
 * @author DiGua
 *
 */
public class CourierGroupWrapper implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String groupId;			// 组ID
	private String groupName;		// 组名
	private String excoId;			// 快递公司ID
	private String excoName;		// 快递公司名称
	private String districtId;		// 所属区域ID
	private String districtName;	// 所属区域名称
	private String pickContactorM;	// 取件联系方式
	
	
	public String getGroupId()
	{
		return groupId;
	}
	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}
	public String getGroupName()
	{
		return groupName;
	}
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}
	public String getExcoId()
	{
		return excoId;
	}
	public void setExcoId(String excoId)
	{
		this.excoId = excoId;
	}
	public String getExcoName()
	{
		return excoName;
	}
	public void setExcoName(String excoName)
	{
		this.excoName = excoName;
	}
	public String getDistrictId()
	{
		return districtId;
	}
	public void setDistrictId(String districtId)
	{
		this.districtId = districtId;
	}
	public String getDistrictName()
	{
		return districtName;
	}
	public void setDistrictName(String districtName)
	{
		this.districtName = districtName;
	}
	public String getPickContactorM()
	{
		return pickContactorM;
	}
	public void setPickContactorM(String pickContactorM)
	{
		this.pickContactorM = pickContactorM;
	}
}