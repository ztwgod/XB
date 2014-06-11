package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class OperationLog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String logId;//
	private int sysPlatType;//
	private String operationUserId;//
	private int operationType;//
	private String ssId;//
	private String boxId;//
	private String operationContent;//
	private String operationResult;//
	private Timestamp operationTime;//

	public String getLogId(){
		 return this.logId;
	}
 
	public void setLogId(String logId){
		 this.logId=logId;
	}
	public int getSysPlatType(){
		 return this.sysPlatType;
	}
 
	public void setSysPlatType(int sysPlatType){
		 this.sysPlatType=sysPlatType;
	}
	public String getOperationUserId(){
		 return this.operationUserId;
	}
 
	public void setOperationUserId(String operationUserId){
		 this.operationUserId=operationUserId;
	}
	public int getOperationType(){
		 return this.operationType;
	}
 
	public void setOperationType(int operationType){
		 this.operationType=operationType;
	}
	public String getSsId(){
		 return this.ssId;
	}
 
	public void setSsId(String ssId){
		 this.ssId=ssId;
	}
	public String getBoxId(){
		 return this.boxId;
	}
 
	public void setBoxId(String boxId){
		 this.boxId=boxId;
	}
	public String getOperationContent(){
		 return this.operationContent;
	}
 
	public void setOperationContent(String operationContent){
		 this.operationContent=operationContent;
	}
	public String getOperationResult(){
		 return this.operationResult;
	}
 
	public void setOperationResult(String operationResult){
		 this.operationResult=operationResult;
	}
	public Timestamp getOperationTime(){
		 return this.operationTime;
	}
 
	public void setOperationTime(Timestamp operationTime){
		 this.operationTime=operationTime;
	}
}

