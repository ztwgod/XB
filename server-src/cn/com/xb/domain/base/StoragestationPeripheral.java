package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class StoragestationPeripheral implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String ssId;//
	private String peripheralId;//
	private int runStatus;//

	public String getSsId(){
		 return this.ssId;
	}
 
	public void setSsId(String ssId){
		 this.ssId=ssId;
	}
	public String getPeripheralId(){
		 return this.peripheralId;
	}
 
	public void setPeripheralId(String peripheralId){
		 this.peripheralId=peripheralId;
	}
	public int getRunStatus(){
		 return this.runStatus;
	}
 
	public void setRunStatus(int runStatus){
		 this.runStatus=runStatus;
	}
}

