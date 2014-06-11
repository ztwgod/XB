package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class CourierGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String groupId;//
	private String groupName;//
	private String excoId;//
	private String districtId;//
	private String pickContactorM;//

	public String getGroupId(){
		 return this.groupId;
	}
 
	public void setGroupId(String groupId){
		 this.groupId=groupId;
	}
	public String getGroupName(){
		 return this.groupName;
	}
 
	public void setGroupName(String groupName){
		 this.groupName=groupName;
	}
	public String getExcoId(){
		 return this.excoId;
	}
 
	public void setExcoId(String excoId){
		 this.excoId=excoId;
	}
	public String getDistrictId(){
		 return this.districtId;
	}
 
	public void setDistrictId(String districtId){
		 this.districtId=districtId;
	}
	public String getPickContactorM(){
		 return this.pickContactorM;
	}
 
	public void setPickContactorM(String pickContactorM){
		 this.pickContactorM=pickContactorM;
	}
}

