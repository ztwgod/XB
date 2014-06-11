package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class StoragestationMatainLog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String matainId;//
	private int matainType;//
	private String userId;//
	private Timestamp assignTime;//
	private Timestamp completeTime;//
	private String completeResult;//
	private int matainStatus;//
	private String memo;//
	private String ssId;//

	public String getMatainId(){
		 return this.matainId;
	}
 
	public void setMatainId(String matainId){
		 this.matainId=matainId;
	}
	public int getMatainType(){
		 return this.matainType;
	}
 
	public void setMatainType(int matainType){
		 this.matainType=matainType;
	}
	public String getUserId(){
		 return this.userId;
	}
 
	public void setUserId(String userId){
		 this.userId=userId;
	}
	public Timestamp getAssignTime(){
		 return this.assignTime;
	}
 
	public void setAssignTime(Timestamp assignTime){
		 this.assignTime=assignTime;
	}
	public Timestamp getCompleteTime(){
		 return this.completeTime;
	}
 
	public void setCompleteTime(Timestamp completeTime){
		 this.completeTime=completeTime;
	}
	public String getCompleteResult(){
		 return this.completeResult;
	}
 
	public void setCompleteResult(String completeResult){
		 this.completeResult=completeResult;
	}
	public int getMatainStatus(){
		 return this.matainStatus;
	}
 
	public void setMatainStatus(int matainStatus){
		 this.matainStatus=matainStatus;
	}
	public String getMemo(){
		 return this.memo;
	}
 
	public void setMemo(String memo){
		 this.memo=memo;
	}
	public String getSsId(){
		 return this.ssId;
	}
 
	public void setSsId(String ssId){
		 this.ssId=ssId;
	}
}

