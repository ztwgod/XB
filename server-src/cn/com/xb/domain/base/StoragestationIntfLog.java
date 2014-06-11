package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class StoragestationIntfLog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String logId;//
	private Timestamp logTime;//
	private String ssId;//
	private String intfId;//
	private String msgContent;//

	public String getLogId(){
		 return this.logId;
	}
 
	public void setLogId(String logId){
		 this.logId=logId;
	}
	public Timestamp getLogTime(){
		 return this.logTime;
	}
 
	public void setLogTime(Timestamp logTime){
		 this.logTime=logTime;
	}
	public String getSsId(){
		 return this.ssId;
	}
 
	public void setSsId(String ssId){
		 this.ssId=ssId;
	}
	public String getIntfId(){
		 return this.intfId;
	}
 
	public void setIntfId(String intfId){
		 this.intfId=intfId;
	}
	public String getMsgContent(){
		 return this.msgContent;
	}
 
	public void setMsgContent(String msgContent){
		 this.msgContent=msgContent;
	}
}

