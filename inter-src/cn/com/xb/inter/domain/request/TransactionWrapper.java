package cn.com.xb.inter.domain.request;

import java.io.Serializable;

import cn.com.xb.inter.domain.ITransactionInfo;
import cn.com.xb.util.VerifyTool;

public class TransactionWrapper extends BaseRequest implements Serializable {

	/**
	 * 交易信息封装
	 */
	private static final long serialVersionUID = 1L;

	private int sequenceprivateNumber;// 序列号
	private int transActionType;// 交易动作类型（1，成功：寄件人寄件；2，成功：快递员取件；3，成功：快递员投件；4，成功：收件人收件；5，成功：寄存人寄件；6，成功：寄存人取件；7，无空箱：寄件人寄件；8，无空箱：快递员投件；9，无空箱：寄存；10，退件：快递员投件；11，退件：寄存人寄件）
	private String storageStationId;// 物箱编码
	private String clientTime;// 操作时间 yyyy-MM-dd hh24:mm:ss
	private String clientUploadTime;// 上传提交时间 yyyy-MM-dd hh24:mm:ss
	private ITransactionInfo transactionInfo;// 交易信息
	
	/**
	 * 非空验证
	 * @return
	 */
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		/*if(0<=this.transActionType || this.transActionType>=12){
			buffer.append("transActionType输入非法");
		}
		if(VerifyTool.isNull(this.storageStationId)){
			buffer.append("storageStationId不能为空。");
		}
		if(VerifyTool.isNull(this.clientTime)){
			buffer.append("clientTime不能为空。");
		}
		if(VerifyTool.isNull(this.clientUploadTime)){
			buffer.append("clientUploadTime不能为空。");
		}
		if(!VerifyTool.isDate(this.clientTime)){
			buffer.append("clientTime格式不正确");
		}
		if(!VerifyTool.isDate(this.clientUploadTime)){
			buffer.append("clientUploadTime格式不正确。");
		}
		if(null==this.transactionInfo){
			buffer.append("transactionInfo不能为空。");
		}*/
		return buffer.toString();
	}
	

	public int getSequenceprivateNumber() {
		return sequenceprivateNumber;
	}

	public void setSequenceprivateNumber(int sequenceprivateNumber) {
		this.sequenceprivateNumber = sequenceprivateNumber;
	}

	public int getTransActionType() {
		return transActionType;
	}

	public void setTransActionType(int transActionType) {
		this.transActionType = transActionType;
	}

	public String getStorageStationId() {
		return storageStationId;
	}

	public void setStorageStationId(String storageStationId) {
		this.storageStationId = storageStationId;
	}

	public String getClientTime() {
		return clientTime;
	}

	public void setClientTime(String clientTime) {
		this.clientTime = clientTime;
	}

	public String getClientUploadTime() {
		return clientUploadTime;
	}

	public void setClientUploadTime(String clientUploadTime) {
		this.clientUploadTime = clientUploadTime;
	}

	public ITransactionInfo getTransactionInfo() {
		return transactionInfo;
	}

	public void setTransactionInfo(ITransactionInfo transactionInfo) {
		this.transactionInfo = transactionInfo;
	}

}
