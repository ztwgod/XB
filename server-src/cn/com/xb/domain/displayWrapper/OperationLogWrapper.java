package cn.com.xb.domain.displayWrapper;

import java.io.Serializable;
import java.sql.Timestamp;

public class OperationLogWrapper implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String logId;				// 日志ID
	private int sysPlatType;			// 操作平台
	private String sysPlatTypeShow;		// 操作平台名称
	private String operationUserId;		// 操作用户ID
	private String operationUserName;	// 操作用户姓名
	private int operationType;			// 操作类型ID
	private String operationTypeShow;	// 操作类型名称
	private String ssId;				// 操作关联物箱
	private String ssCode;				// 操作物箱Code
	private String ssAddress;			// 操作物箱地址
	private String boxId;				// 操作关联箱子
	private String operationContent;	// 操作内容详情
	private String operationResult;		// 操作返回结果
	private Timestamp operationTime;	// 操作时间
	
	
	public String getLogId()
	{
		return logId;
	}
	public void setLogId(String logId)
	{
		this.logId = logId;
	}
	public int getSysPlatType()
	{
		return sysPlatType;
	}
	public void setSysPlatType(int sysPlatType)
	{
		this.sysPlatType = sysPlatType;
	}
	public String getSysPlatTypeShow()
	{
		return sysPlatTypeShow;
	}
	public void setSysPlatTypeShow(String sysPlatTypeShow)
	{
		this.sysPlatTypeShow = sysPlatTypeShow;
	}
	public String getOperationUserId()
	{
		return operationUserId;
	}
	public void setOperationUserId(String operationUserId)
	{
		this.operationUserId = operationUserId;
	}
	public String getOperationUserName()
	{
		return operationUserName;
	}
	public void setOperationUserName(String operationUserName)
	{
		this.operationUserName = operationUserName;
	}
	public int getOperationType()
	{
		return operationType;
	}
	public void setOperationType(int operationType)
	{
		this.operationType = operationType;
	}
	public String getOperationTypeShow()
	{
		return operationTypeShow;
	}
	public void setOperationTypeShow(String operationTypeShow)
	{
		this.operationTypeShow = operationTypeShow;
	}
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
	public String getSsAddress()
	{
		return ssAddress;
	}
	public void setSsAddress(String ssAddress)
	{
		this.ssAddress = ssAddress;
	}
	public String getBoxId()
	{
		return boxId;
	}
	public void setBoxId(String boxId)
	{
		this.boxId = boxId;
	}
	public String getOperationContentHtml()
	{
		return operationContent.replaceAll("\"", "");
	}
	public String getOperationContent()
	{
		return operationContent;
	}
	public void setOperationContent(String operationContent)
	{
		this.operationContent = operationContent;
	}
	public String getOperationResult()
	{
		return operationResult;
	}
	public void setOperationResult(String operationResult)
	{
		this.operationResult = operationResult;
	}
	public Timestamp getOperationTime()
	{
		return operationTime;
	}
	public void setOperationTime(Timestamp operationTime)
	{
		this.operationTime = operationTime;
	}
}
