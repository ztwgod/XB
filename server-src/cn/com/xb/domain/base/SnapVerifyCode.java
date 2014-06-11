package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class SnapVerifyCode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;//
	private String mobileNumber;//
	private String verifyCode;//
	private Timestamp takeEffectTime;//
	private int effectiveLen;//

	public String getId(){
		 return this.id;
	}
 
	public void setId(String id){
		 this.id=id;
	}
	public String getMobileNumber(){
		 return this.mobileNumber;
	}
 
	public void setMobileNumber(String mobileNumber){
		 this.mobileNumber=mobileNumber;
	}
	public String getVerifyCode(){
		 return this.verifyCode;
	}
 
	public void setVerifyCode(String verifyCode){
		 this.verifyCode=verifyCode;
	}
	public Timestamp getTakeEffectTime(){
		 return this.takeEffectTime;
	}
 
	public void setTakeEffectTime(Timestamp takeEffectTime){
		 this.takeEffectTime=takeEffectTime;
	}
	public int getEffectiveLen(){
		 return this.effectiveLen;
	}
 
	public void setEffectiveLen(int effectiveLen){
		 this.effectiveLen=effectiveLen;
	}
}

