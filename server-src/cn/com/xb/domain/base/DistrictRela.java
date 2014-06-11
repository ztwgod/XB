package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class DistrictRela implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String districtId;//
	private String parentDId;//
	private int districtLevel;//
	private int parentDLevel;//

	public String getDistrictId(){
		 return this.districtId;
	}
 
	public void setDistrictId(String districtId){
		 this.districtId=districtId;
	}
	public String getParentDId(){
		 return this.parentDId;
	}
 
	public void setParentDId(String parentDId){
		 this.parentDId=parentDId;
	}
	public int getDistrictLevel(){
		 return this.districtLevel;
	}
 
	public void setDistrictLevel(int districtLevel){
		 this.districtLevel=districtLevel;
	}
	public int getParentDLevel(){
		 return this.parentDLevel;
	}
 
	public void setParentDLevel(int parentDLevel){
		 this.parentDLevel=parentDLevel;
	}
}

