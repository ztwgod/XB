package cn.com.xb.inter.domain.request;

import java.io.Serializable;

public class PastDueInfoWarpper extends BaseRequest implements Serializable {

	/**
	 * 逾期封装信息
	 */
	private static final long serialVersionUID = 1L;

	private String userId;// 用户ID
	private String userMobilePhone;// 用户手机号码
	private String boxCode;// 对应箱子Code
	private String transactionID;// 交易ID
	private int pastDueTime;// 逾期时长 [单位：min]
	private double needAdditionalPrice;// 需补充金额（通常因超时计算，单位：RMB元）

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserMobilePhone() {
		return userMobilePhone;
	}

	public void setUserMobilePhone(String userMobilePhone) {
		this.userMobilePhone = userMobilePhone;
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

	public int getPastDueTime() {
		return pastDueTime;
	}

	public void setPastDueTime(int pastDueTime) {
		this.pastDueTime = pastDueTime;
	}

	public double getNeedAdditionalPrice() {
		return needAdditionalPrice;
	}

	public void setNeedAdditionalPrice(double needAdditionalPrice) {
		this.needAdditionalPrice = needAdditionalPrice;
	}
}
