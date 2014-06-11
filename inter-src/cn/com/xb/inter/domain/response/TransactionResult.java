package cn.com.xb.inter.domain.response;

import java.io.Serializable;

public class TransactionResult extends BaseResponse implements Serializable {

	/**
	 * 交易返回结果
	 */
	private static final long serialVersionUID = 1L;

	private String transactionID;// 交易ID [物箱端的ID，用于与服务器中的数据对应]
	private String storageStationId;	// 物箱编码
	private String boxcode;// 箱子编码
	
	private double pricingStarts;	// 起步价
	private int freeTime;		// 免费时长
	private double overTimeUnitPrice;	// 超时后单价
	private double maximumPrice;	// 最高限额
	private int overdueTime;	// 超时时长
	
	
	private String pickupPassword;// 取件密码

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getStorageStationId()
	{
		return storageStationId;
	}

	public void setStorageStationId(String storageStationId)
	{
		this.storageStationId = storageStationId;
	}

	public String getBoxcode()
	{
		return boxcode;
	}

	public void setBoxcode(String boxcode)
	{
		this.boxcode = boxcode;
	}

	public double getPricingStarts()
	{
		return pricingStarts;
	}

	public void setPricingStarts(double pricingStarts)
	{
		this.pricingStarts = pricingStarts;
	}

	public int getFreeTime()
	{
		return freeTime;
	}

	public void setFreeTime(int freeTime)
	{
		this.freeTime = freeTime;
	}

	public double getOverTimeUnitPrice()
	{
		return overTimeUnitPrice;
	}

	public void setOverTimeUnitPrice(double overTimeUnitPrice)
	{
		this.overTimeUnitPrice = overTimeUnitPrice;
	}

	public double getMaximumPrice()
	{
		return maximumPrice;
	}

	public void setMaximumPrice(double maximumPrice)
	{
		this.maximumPrice = maximumPrice;
	}

	public int getOverdueTime()
	{
		return overdueTime;
	}

	public void setOverdueTime(int overdueTime)
	{
		this.overdueTime = overdueTime;
	}

	public String getPickupPassword() {
		return pickupPassword;
	}

	public void setPickupPassword(String pickupPassword) {
		this.pickupPassword = pickupPassword;
	}

}
