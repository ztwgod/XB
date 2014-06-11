package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cabinet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cabinetId;//
	private String ssId;//
	private String cabinetModel;//
	private String assetSn;//
	private int cabinetWidth;//
	private int cabinetHeight;//
	private int boxNumber;//
	private int cabinetStatus;//
	private String cabinetIndex;//
	private String cabinetCode;//
	private int cabinetType;//

	public String getCabinetId(){
		 return this.cabinetId;
	}
 
	public void setCabinetId(String cabinetId){
		 this.cabinetId=cabinetId;
	}
	public String getSsId(){
		 return this.ssId;
	}
 
	public void setSsId(String ssId){
		 this.ssId=ssId;
	}
	public String getCabinetModel(){
		 return this.cabinetModel;
	}
 
	public void setCabinetModel(String cabinetModel){
		 this.cabinetModel=cabinetModel;
	}
	public String getAssetSn(){
		 return this.assetSn;
	}
 
	public void setAssetSn(String assetSn){
		 this.assetSn=assetSn;
	}
	public int getCabinetWidth(){
		 return this.cabinetWidth;
	}
 
	public void setCabinetWidth(int cabinetWidth){
		 this.cabinetWidth=cabinetWidth;
	}
	public int getCabinetHeight(){
		 return this.cabinetHeight;
	}
 
	public void setCabinetHeight(int cabinetHeight){
		 this.cabinetHeight=cabinetHeight;
	}
	public int getBoxNumber(){
		 return this.boxNumber;
	}
 
	public void setBoxNumber(int boxNumber){
		 this.boxNumber=boxNumber;
	}
	public int getCabinetStatus(){
		 return this.cabinetStatus;
	}
 
	public void setCabinetStatus(int cabinetStatus){
		 this.cabinetStatus=cabinetStatus;
	}
	public String getCabinetIndex(){
		 return this.cabinetIndex;
	}
 
	public void setCabinetIndex(String cabinetIndex){
		 this.cabinetIndex=cabinetIndex;
	}
	public String getCabinetCode(){
		 return this.cabinetCode;
	}
 
	public void setCabinetCode(String cabinetCode){
		 this.cabinetCode=cabinetCode;
	}
	public int getCabinetType(){
		 return this.cabinetType;
	}
 
	public void setCabinetType(int cabinetType){
		 this.cabinetType=cabinetType;
	}
}

