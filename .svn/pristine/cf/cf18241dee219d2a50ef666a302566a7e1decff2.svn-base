package cn.com.xb.inter.domain.request;

import java.io.Serializable;

import cn.com.xb.util.VerifyTool;

public class AppOpenBoxWrapper implements Serializable {

	/**
	 * 请求开箱信息封装
	 */
	private static final long serialVersionUID = 1L;

	private String transId;// 交易ID（此处交易的为平台中的交易ID）
	private String userId;// 当前用户ID（平台的ID）
	private String randomNum;// 柜子随机数（物箱上的LED显示器显示的随机数）
	private String clientUploadTime;// 上传提交时间 （格式：yyyy-MM-dd HH24:mm:ss）
	
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(VerifyTool.isNull(this.transId)){
			buffer.append("transId不能为空。");
		}
		if(VerifyTool.isNull(this.userId)){
			buffer.append("userId不能为空。");
		}
		if(VerifyTool.isNull(this.randomNum)){
			buffer.append("randomNum不能为空。");
		}
		if(!VerifyTool.isDate(this.clientUploadTime)){
			buffer.append("clientUploadTime非法。");
		}
		return buffer.toString();
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(String randomNum) {
		this.randomNum = randomNum;
	}

	public String getClientUploadTime() {
		return clientUploadTime;
	}

	public void setClientUploadTime(String clientUploadTime) {
		this.clientUploadTime = clientUploadTime;
	}
}
