package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class LeaseBoxRela implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String aliasesId;//
	private String boxId;//

	public String getAliasesId(){
		 return this.aliasesId;
	}
 
	public void setAliasesId(String aliasesId){
		 this.aliasesId=aliasesId;
	}
	public String getBoxId(){
		 return this.boxId;
	}
 
	public void setBoxId(String boxId){
		 this.boxId=boxId;
	}
}

