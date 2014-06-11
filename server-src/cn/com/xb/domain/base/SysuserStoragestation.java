package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class SysuserStoragestation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String ssId;//
	private String userId;//

	public String getSsId(){
		 return this.ssId;
	}
 
	public void setSsId(String ssId){
		 this.ssId=ssId;
	}
	public String getUserId(){
		 return this.userId;
	}
 
	public void setUserId(String userId){
		 this.userId=userId;
	}
}

