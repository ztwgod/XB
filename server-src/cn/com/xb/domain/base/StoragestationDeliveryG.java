package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class StoragestationDeliveryG implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String ssId;//
	private String groupId;//
	private int exePermission;//

	public String getSsId(){
		 return this.ssId;
	}
 
	public void setSsId(String ssId){
		 this.ssId=ssId;
	}
	public String getGroupId(){
		 return this.groupId;
	}
 
	public void setGroupId(String groupId){
		 this.groupId=groupId;
	}
	public int getExePermission(){
		 return this.exePermission;
	}
 
	public void setExePermission(int exePermission){
		 this.exePermission=exePermission;
	}
}

