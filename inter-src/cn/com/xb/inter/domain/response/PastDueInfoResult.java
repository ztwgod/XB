package cn.com.xb.inter.domain.response;

import java.io.Serializable;

public class PastDueInfoResult extends BaseResponse implements Serializable {

	/**
	 * 逾期处理结果
	 */
	private static final long serialVersionUID = 1L;

	private String boxCode;// 对应箱子Code
	private String transactionID;// 交易ID
	private int additionalPayMode;// 补充金额支付方式（1，投币；2，平台支付）这里目前必须平台支付
	private int additionalPrice;// 已补充金额（通常因超时计算，单位：RMB元）

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

	public int getAdditionalPayMode() {
		return additionalPayMode;
	}

	public void setAdditionalPayMode(int additionalPayMode) {
		this.additionalPayMode = additionalPayMode;
	}

	public int getAdditionalPrice() {
		return additionalPrice;
	}

	public void setAdditionalPrice(int additionalPrice) {
		this.additionalPrice = additionalPrice;
	}
}
