package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class Location implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String locationId;//
	private String locationCode;//
	private String locationAbb;//
	private String address;//
	private String districtId;//

	public String getLocationId(){
		 return this.locationId;
	}
 
	public void setLocationId(String locationId){
		 this.locationId=locationId;
	}
	public String getLocationCode(){
		 return this.locationCode;
	}
 
	public void setLocationCode(String locationCode){
		 this.locationCode=locationCode;
	}
	public String getLocationAbb(){
		 return this.locationAbb;
	}
 
	public void setLocationAbb(String locationAbb){
		 this.locationAbb=locationAbb;
	}
	public String getAddress(){
		 return this.address;
	}
 
	public void setAddress(String address){
		 this.address=address;
	}
	public String getDistrictId(){
		 return this.districtId;
	}
 
	public void setDistrictId(String districtId){
		 this.districtId=districtId;
	}
}

