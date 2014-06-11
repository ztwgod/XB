package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class SsTypeExterior implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String typeId;//
	private String exteriorId;//

	public String getTypeId(){
		 return this.typeId;
	}
 
	public void setTypeId(String typeId){
		 this.typeId=typeId;
	}
	public String getExteriorId(){
		 return this.exteriorId;
	}
 
	public void setExteriorId(String exteriorId){
		 this.exteriorId=exteriorId;
	}
}

