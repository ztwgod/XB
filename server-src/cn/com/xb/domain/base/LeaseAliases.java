package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class LeaseAliases implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String aliasesId;//
	private String aliasesName;//
	private String userId;//
	private String ssId;//
	private int leaseBoxNum;//
	private int aliasesLevel;//

	public String getAliasesId(){
		 return this.aliasesId;
	}
 
	public void setAliasesId(String aliasesId){
		 this.aliasesId=aliasesId;
	}
	public String getAliasesName(){
		 return this.aliasesName;
	}
 
	public void setAliasesName(String aliasesName){
		 this.aliasesName=aliasesName;
	}
	public String getUserId(){
		 return this.userId;
	}
 
	public void setUserId(String userId){
		 this.userId=userId;
	}
	public String getSsId(){
		 return this.ssId;
	}
 
	public void setSsId(String ssId){
		 this.ssId=ssId;
	}
	public int getLeaseBoxNum(){
		 return this.leaseBoxNum;
	}
 
	public void setLeaseBoxNum(int leaseBoxNum){
		 this.leaseBoxNum=leaseBoxNum;
	}
	public int getAliasesLevel(){
		 return this.aliasesLevel;
	}
 
	public void setAliasesLevel(int aliasesLevel){
		 this.aliasesLevel=aliasesLevel;
	}
}

