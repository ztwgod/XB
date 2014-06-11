package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class Module implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String moduleId;//
	private String moduleCode;//
	private String parentMId;//
	private String moduleName;//
	private String moduleLink;//
	private String moduleDesc;//
	private int moduleLevel;//
	private int showSeq;//
	private int moduleType;//
	private Timestamp createTime;//
	private String creator;//
	private Timestamp enableTime;//
	private int status;//

	public String getModuleId(){
		 return this.moduleId;
	}
 
	public void setModuleId(String moduleId){
		 this.moduleId=moduleId;
	}
	public String getModuleCode(){
		 return this.moduleCode;
	}
 
	public void setModuleCode(String moduleCode){
		 this.moduleCode=moduleCode;
	}
	public String getParentMId(){
		 return this.parentMId;
	}
 
	public void setParentMId(String parentMId){
		 this.parentMId=parentMId;
	}
	public String getModuleName(){
		 return this.moduleName;
	}
 
	public void setModuleName(String moduleName){
		 this.moduleName=moduleName;
	}
	public String getModuleLink(){
		 return this.moduleLink;
	}
 
	public void setModuleLink(String moduleLink){
		 this.moduleLink=moduleLink;
	}
	public String getModuleDesc(){
		 return this.moduleDesc;
	}
 
	public void setModuleDesc(String moduleDesc){
		 this.moduleDesc=moduleDesc;
	}
	public int getModuleLevel(){
		 return this.moduleLevel;
	}
 
	public void setModuleLevel(int moduleLevel){
		 this.moduleLevel=moduleLevel;
	}
	public int getShowSeq(){
		 return this.showSeq;
	}
 
	public void setShowSeq(int showSeq){
		 this.showSeq=showSeq;
	}
	public int getModuleType(){
		 return this.moduleType;
	}
 
	public void setModuleType(int moduleType){
		 this.moduleType=moduleType;
	}
	public Timestamp getCreateTime(){
		 return this.createTime;
	}
 
	public void setCreateTime(Timestamp createTime){
		 this.createTime=createTime;
	}
	public String getCreator(){
		 return this.creator;
	}
 
	public void setCreator(String creator){
		 this.creator=creator;
	}
	public Timestamp getEnableTime(){
		 return this.enableTime;
	}
 
	public void setEnableTime(Timestamp enableTime){
		 this.enableTime=enableTime;
	}
	public int getStatus(){
		 return this.status;
	}
 
	public void setStatus(int status){
		 this.status=status;
	}
}

