package cn.com.xb.inter.domain.request;

import java.io.Serializable;

import cn.com.xb.util.VerifyTool;

public class GetTransactionListWrapper extends BaseRequest implements
		Serializable {

	/**
	 * 获取交易信息列表信息封装
	 */
	private static final long serialVersionUID = 1L;
	private String userId;// 当前用户ID（平台的ID）
	private int transType;// 交易类型
	private int transStatus;// 交易状态
	private String clientUploadTime;// 上传提交时间 （格式：yyyy-MM-dd HH24:mm:ss）
	
	
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(VerifyTool.isNull(this.userId)){
			buffer.append("userId不能为空。");
		}
		if(!VerifyTool.isDate(this.clientUploadTime)){
			buffer.append("clientUploadTime非法。");
		}
		return buffer.toString();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTransType() {
		return transType;
	}

	public void setTransType(int transType) {
		this.transType = transType;
	}

	public int getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(int transStatus) {
		this.transStatus = transStatus;
	}

	public String getClientUploadTime() {
		return clientUploadTime;
	}

	public void setClientUploadTime(String clientUploadTime) {
		this.clientUploadTime = clientUploadTime;
	}
}
