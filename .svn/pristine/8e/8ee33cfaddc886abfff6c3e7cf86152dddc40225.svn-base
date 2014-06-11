package cn.com.xb.inter.domain.request;

import java.io.Serializable;

public class RemoteUnpackeInfoWarpper extends BaseRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 请求开箱封装信息（APP）
	 */

	private String userId; // 用户ID
	
	private String boxCode;// 需打开的箱子Code
	private String randomNum; // 开箱延迟时间（单位：秒）
	private String transactionID; // 交易ID

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBoxCode() {
		return boxCode;
	}

	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(String randomNum) {
		this.randomNum = randomNum;
	}

	@Override
	public String toString() {
		return this.getBoxCode()+","+this.getRandomNum()+","+this.getSequenceNumber()+","+this.getStorageStationId()+","+this.getTransactionID()+","+this.getUserId();
	}
}
