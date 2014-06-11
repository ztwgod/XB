package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class Peripheral implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String peripheralId;//
	private String peripheralAbbName;//
	private String assetSn;//
	private int type;//
	private String version;//
	private Timestamp startTime;//
	private Timestamp stopTime;//
	private int status;//
	private String memo;//
	private String peripheralCode;//

	public String getPeripheralId(){
		 return this.peripheralId;
	}
 
	public void setPeripheralId(String peripheralId){
		 this.peripheralId=peripheralId;
	}
	public String getPeripheralAbbName(){
		 return this.peripheralAbbName;
	}
 
	public void setPeripheralAbbName(String peripheralAbbName){
		 this.peripheralAbbName=peripheralAbbName;
	}
	public String getAssetSn(){
		 return this.assetSn;
	}
 
	public void setAssetSn(String assetSn){
		 this.assetSn=assetSn;
	}
	public int getType(){
		 return this.type;
	}
 
	public void setType(int type){
		 this.type=type;
	}
	public String getVersion(){
		 return this.version;
	}
 
	public void setVersion(String version){
		 this.version=version;
	}
	public Timestamp getStartTime(){
		 return this.startTime;
	}
 
	public void setStartTime(Timestamp startTime){
		 this.startTime=startTime;
	}
	public Timestamp getStopTime(){
		 return this.stopTime;
	}
 
	public void setStopTime(Timestamp stopTime){
		 this.stopTime=stopTime;
	}
	public int getStatus(){
		 return this.status;
	}
 
	public void setStatus(int status){
		 this.status=status;
	}
	public String getMemo(){
		 return this.memo;
	}
 
	public void setMemo(String memo){
		 this.memo=memo;
	}
	public String getPeripheralCode(){
		 return this.peripheralCode;
	}
 
	public void setPeripheralCode(String peripheralCode){
		 this.peripheralCode=peripheralCode;
	}
}

