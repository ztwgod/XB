package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class FlagDictionary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int code;//
	private String name;//
	private String typeId;//
	private String description;//
	private int status;//

	public int getCode(){
		 return this.code;
	}
 
	public void setCode(int code){
		 this.code=code;
	}
	public String getName(){
		 return this.name;
	}
 
	public void setName(String name){
		 this.name=name;
	}
	public String getTypeId(){
		 return this.typeId;
	}
 
	public void setTypeId(String typeId){
		 this.typeId=typeId;
	}
	public String getDescription(){
		 return this.description;
	}
 
	public void setDescription(String description){
		 this.description=description;
	}
	public int getStatus(){
		 return this.status;
	}
 
	public void setStatus(int status){
		 this.status=status;
	}
}

