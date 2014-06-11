package cn.com.xb.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class FeeProof implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String feeId;//
	private String transId;//
	private String transActionId;//
	private int payMethods;//
	private double amount;//
	private String voucherId;//
	private int voucherTotal;//
	private String boxFeeId;//
	private int payType;//
	private String payDesc;//

	public String getFeeId(){
		 return this.feeId;
	}
 
	public void setFeeId(String feeId){
		 this.feeId=feeId;
	}
	public String getTransId(){
		 return this.transId;
	}
 
	public void setTransId(String transId){
		 this.transId=transId;
	}
	public String getTransActionId(){
		 return this.transActionId;
	}
 
	public void setTransActionId(String transActionId){
		 this.transActionId=transActionId;
	}
	public int getPayMethods(){
		 return this.payMethods;
	}
 
	public void setPayMethods(int payMethods){
		 this.payMethods=payMethods;
	}
	public double getAmount(){
		 return this.amount;
	}
 
	public void setAmount(double amount){
		 this.amount=amount;
	}
	public String getVoucherId(){
		 return this.voucherId;
	}
 
	public void setVoucherId(String voucherId){
		 this.voucherId=voucherId;
	}
	public int getVoucherTotal(){
		 return this.voucherTotal;
	}
 
	public void setVoucherTotal(int voucherTotal){
		 this.voucherTotal=voucherTotal;
	}
	public String getBoxFeeId(){
		 return this.boxFeeId;
	}
 
	public void setBoxFeeId(String boxFeeId){
		 this.boxFeeId=boxFeeId;
	}
	public int getPayType(){
		 return this.payType;
	}
 
	public void setPayType(int payType){
		 this.payType=payType;
	}
	public String getPayDesc(){
		 return this.payDesc;
	}
 
	public void setPayDesc(String payDesc){
		 this.payDesc=payDesc;
	}
}

