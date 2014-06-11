package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class Intf implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String intfId;//
	private String intfUrl;//
	private String intfName;//
	private int updown;//

	public String getIntfId(){
		 return this.intfId;
	}
 
	public void setIntfId(String intfId){
		 this.intfId=intfId;
	}
	public String getIntfUrl(){
		 return this.intfUrl;
	}
 
	public void setIntfUrl(String intfUrl){
		 this.intfUrl=intfUrl;
	}
	public String getIntfName(){
		 return this.intfName;
	}
 
	public void setIntfName(String intfName){
		 this.intfName=intfName;
	}
	public int getUpdown(){
		 return this.updown;
	}
 
	public void setUpdown(int updown){
		 this.updown=updown;
	}
}

