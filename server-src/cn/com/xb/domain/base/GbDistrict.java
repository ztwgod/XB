package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class GbDistrict implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String districtId;//
	private String districtName;//
	private int districtStatus;//
	private String parentDId;//

	public String getDistrictId(){
		 return this.districtId;
	}
 
	public void setDistrictId(String districtId){
		 this.districtId=districtId;
	}
	public String getDistrictName(){
		 return this.districtName;
	}
 
	public void setDistrictName(String districtName){
		 this.districtName=districtName;
	}
	public int getDistrictStatus(){
		 return this.districtStatus;
	}
 
	public void setDistrictStatus(int districtStatus){
		 this.districtStatus=districtStatus;
	}
	public String getParentDId(){
		 return this.parentDId;
	}
 
	public void setParentDId(String parentDId){
		 this.parentDId=parentDId;
	}
}

