package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class DictionaryType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String typeId;//
	private String typeName;//

	public String getTypeId(){
		 return this.typeId;
	}
 
	public void setTypeId(String typeId){
		 this.typeId=typeId;
	}
	public String getTypeName(){
		 return this.typeName;
	}
 
	public void setTypeName(String typeName){
		 this.typeName=typeName;
	}
}

