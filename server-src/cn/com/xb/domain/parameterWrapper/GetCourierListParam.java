package cn.com.xb.domain.parameterWrapper;

import java.io.Serializable;

public class GetCourierListParam implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String paperworkNum;
	private String mobileNumber;
	private String excoId;

	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPaperworkNum()
	{
		return paperworkNum;
	}
	public void setPaperworkNum(String paperworkNum)
	{
		this.paperworkNum = paperworkNum;
	}
	public String getMobileNumber()
	{
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
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
