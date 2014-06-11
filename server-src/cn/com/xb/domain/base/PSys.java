package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class PSys implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userId;//
	private String orgDesc;//
	private String deptDesc;//

	public String getUserId(){
		 return this.userId;
	}
 
	public void setUserId(String userId){
		 this.userId=userId;
	}
	public String getOrgDesc(){
		 return this.orgDesc;
	}
 
	public void setOrgDesc(String orgDesc){
		 this.orgDesc=orgDesc;
	}
	public String getDeptDesc(){
		 return this.deptDesc;
	}
 
	public void setDeptDesc(String deptDesc){
		 this.deptDesc=deptDesc;
	}
}

