package cn.com.xb.domain.displayWrapper;

import java.io.Serializable;
import java.sql.Timestamp;

public class BoxStatusWrapper implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String ssId;
	private String ssCode;
	private String boxId;
	private String boxCode;
	private String boxIndex;
	private int boxSize;
	private int boxStatus;
	private Timestamp startTime;
	private Timestamp endTime;
	
	public String getSsId()
	{
		return ssId;
	}
	public void setSsId(String ssId)
	{
		this.ssId = ssId;
	}
	public String getSsCode()
	{
		return ssCode;
	}
	public void setSsCode(String ssCode)
	{
		this.ssCode = ssCode;
	}
	public String getBoxId()
	{
		return boxId;
	}
	public void setBoxId(String boxId)
	{
		this.boxId = boxId;
	}
	public String getBoxCode()
	{
		return boxCode;
	}
	public void setBoxCode(String boxCode)
	{
		this.boxCode = boxCode;
	}
	public String getBoxIndex()
	{
		return boxIndex;
	}
	public void setBoxIndex(String boxIndex)
	{
		this.boxIndex = boxIndex;
	}
	public String getBoxSizeShow()
	{
		return boxSize == 1 ? "超大" : boxSize == 2 ? "大" : boxSize == 3 ? "中" : boxSize == 4 ? "小" : boxSize == 5 ? "超小" : "其他";
	}
	public int getBoxSize()
	{
		return boxSize;
	}
	public void setBoxSize(int boxSize)
	{
		this.boxSize = boxSize;
	}
	public String getBoxStatusShow()
	{
		return boxStatus == 1 ? "空闲" : boxStatus == 2 ? "占用" : boxStatus == 3 ? "占用超时" : boxStatus == 4 ? "弃件（占用超期）" : boxStatus == 5 ? "开启" : boxStatus == 6 ? "故障" : boxStatus == 7 ? "租用" : boxStatus == 8 ? "预留" : boxStatus == 9 ? "闭塞" : boxStatus == 10 ? "未关闭" : boxStatus == 11 ? "被破坏" : boxStatus == 12 ? "维修" : "未知";
	}
	public int getBoxStatus()
	{
		return boxStatus;
	}
	public void setBoxStatus(int boxStatus)
	{
		this.boxStatus = boxStatus;
	}
	public Timestamp getStartTime()
	{
		return startTime;
	}
	public void setStartTime(Timestamp startTime)
	{
		this.startTime = startTime;
	}
	public Timestamp getEndTime()
	{
		return endTime;
	}
	public void setEndTime(Timestamp endTime)
	{
		this.endTime = endTime;
	}
}
