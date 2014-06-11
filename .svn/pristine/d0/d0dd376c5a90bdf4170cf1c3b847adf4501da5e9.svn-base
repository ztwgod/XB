package cn.com.xb.domain.base;

import java.io.Serializable;

public class ResponseText implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ssId;// 物箱ID
	private String ssCode; // 物箱ID
	private String boxCode; // 箱子ID，只有是对箱子的操作才有

	private int responseType; // 请求类型 1：同步
	private String message; // 发送给物箱的信息
	private String transNo; // 交易序列号
	private String userId; // 用户ID
	private int result; // 结果 0 成功 1失败
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSsId() {
		return ssId;
	}

	public void setSsId(String ssId) {
		this.ssId = ssId;
	}

	public String getSsCode() {
		return ssCode;
	}

	public void setSsCode(String ssCode) {
		this.ssCode = ssCode;
	}

	public String getBoxCode() {
		return boxCode;
	}

	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	public int getResponseType() {
		return responseType;
	}

	public void setResponseType(int responseType) {
		this.responseType = responseType;
	}

	public String toString() {
		return "ssId=" + this.ssId + ",ssCod=" + this.ssCode + ",responseType="
				+ this.responseType + ",message=" + this.message + ",transNo"
				+ this.transNo;
	}
}
