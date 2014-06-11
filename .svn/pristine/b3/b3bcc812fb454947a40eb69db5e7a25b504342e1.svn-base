package cn.com.xb.domain.displayWrapper;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.com.xb.util.Global;

/**
 * 订单信息封装类
 * 
 * @author DiGua
 * 
 */
public class OrderWrapper implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String transId;		// 订单ID
	private String transCode;	// 订单CODE
	private String userId;		// 用户ID
	private int transType;		// 订单交易类型
	private String transTypeShow;	// 交易类型显示
	private String supplierId;	// 电商代码
	private String courierId;	// 快递员ID
	private String courierName;	// 快递员姓名
	private String expressDeliveryId;	// 快递员供应商代码
//	private String expDelName;	// 快递员供应商名称
	private String expressCode;			// 快递单号
	private String expressDesc;			// 快递描述信息
	private int sizeType;		// 快件尺寸
	private int storageTime;	// 默认存放时长（min）
	private int pastDueTime;	// 逾期时长（min）
	private double totalAmount;// 总花费费用
	private String pickupPwd;	// 取件密码
	private int isStandardsCompliant;	// 物品是否符合标准
	private String notStandardsCompliantCause;	// 不符合标准原因
	private String senderId;	// 发件人
	private String senderName;	// 发件人姓名
	private String senderMobileNum;	// 发件人用户手机号
	private String addresseeId;		// 收件人
	private String addresseeName;	// 收件人姓名
	private String addresseeMobileNum;	// 收件人用户手机号
	private String boxId;		// 对应箱子ID
	private Timestamp createTime;	// 创建时间
	private Timestamp closeTime;	// 交易关闭时间
	private Timestamp lastModifyTime;	// 最后修改时间
	private String boxTransId;		// 物箱端交易ID
	private int transStatus;		// 状态

	private List<TransActionDetailWrapper> tadws;	// 交易动作详情列表

	public String getTransId()
	{
		return transId;
	}

	public void setTransId(String transId)
	{
		this.transId = transId;
	}

	public String getTransCode()
	{
		return transCode;
	}

	public void setTransCode(String transCode)
	{
		this.transCode = transCode;
	}

	public Timestamp getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getSupplierId()
	{
		return supplierId;
	}

	public void setSupplierId(String supplierId)
	{
		this.supplierId = supplierId;
	}

	public String getCourierId()
	{
		return courierId;
	}

	public void setCourierId(String courierId)
	{
		this.courierId = courierId;
	}

	public String getExpressDeliveryId()
	{
		return expressDeliveryId;
	}

	public void setExpressDeliveryId(String expressDeliveryId)
	{
		this.expressDeliveryId = expressDeliveryId;
	}

	public String getExpressCode()
	{
		return expressCode;
	}

	public void setExpressCode(String expressCode)
	{
		this.expressCode = expressCode;
	}

	public String getExpressDesc()
	{
		return expressDesc;
	}

	public void setExpressDesc(String expressDesc)
	{
		this.expressDesc = expressDesc;
	}

	public int getPastDueTime()
	{
		return pastDueTime;
	}

	public void setPastDueTime(int pastDueTime)
	{
		this.pastDueTime = pastDueTime;
	}

	public int getStorageTime()
	{
		return storageTime;
	}

	public void setStorageTime(int storageTime)
	{
		this.storageTime = storageTime;
	}

	public String getPickupPwd()
	{
		return pickupPwd;
	}

	public void setPickupPwd(String pickupPwd)
	{
		this.pickupPwd = pickupPwd;
	}

	public int getIsStandardsCompliant()
	{
		return isStandardsCompliant;
	}

	public void setIsStandardsCompliant(int isStandardsCompliant)
	{
		this.isStandardsCompliant = isStandardsCompliant;
	}

	public String getNotStandardsCompliantCause()
	{
		return notStandardsCompliantCause;
	}

	public void setNotStandardsCompliantCause(String notStandardsCompliantCause)
	{
		this.notStandardsCompliantCause = notStandardsCompliantCause;
	}

	public String getSenderId()
	{
		return senderId;
	}

	public void setSenderId(String senderId)
	{
		this.senderId = senderId;
	}

	public String getAddresseeId()
	{
		return addresseeId;
	}

	public void setAddresseeId(String addresseeId)
	{
		this.addresseeId = addresseeId;
	}

	public String getSenderMobileNum()
	{
		return senderMobileNum;
	}

	public void setSenderMobileNum(String senderMobileNum)
	{
		this.senderMobileNum = senderMobileNum;
	}

	public String getAddresseeMobileNum()
	{
		return addresseeMobileNum;
	}

	public void setAddresseeMobileNum(String addresseeMobileNum)
	{
		this.addresseeMobileNum = addresseeMobileNum;
	}

	public Timestamp getLastModifyTime()
	{
		return lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime)
	{
		this.lastModifyTime = lastModifyTime;
	}

	public Timestamp getCloseTime()
	{
		return closeTime;
	}

	public void setCloseTime(Timestamp closeTime)
	{
		this.closeTime = closeTime;
	}

	public String getBoxId()
	{
		return boxId;
	}

	public void setBoxId(String boxId)
	{
		this.boxId = boxId;
	}

	public int getTransType()
	{
		return transType;
	}

	public void setTransType(int transType)
	{
		this.transType = transType;
	}

	public String getTransTypeShow()
	{
		return transTypeShow;
	}

	public void setTransTypeShow(String transTypeShow)
	{
		this.transTypeShow = transTypeShow;
	}

	public String getCourierName()
	{
		return courierName;
	}

	public void setCourierName(String courierName)
	{
		this.courierName = courierName;
	}

	public String getSenderName()
	{
		return senderName;
	}

	public void setSenderName(String senderName)
	{
		this.senderName = senderName;
	}

	public String getAddresseeName()
	{
		return addresseeName;
	}

	public void setAddresseeName(String addresseeName)
	{
		this.addresseeName = addresseeName;
	}

	public String getBoxTransId()
	{
		return boxTransId;
	}

	public void setBoxTransId(String boxTransId)
	{
		this.boxTransId = boxTransId;
	}

	public double getTotalAmount()
	{
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	public int getSizeType()
	{
		return sizeType;
	}

	public void setSizeType(int sizeType)
	{
		this.sizeType = sizeType;
	}

	public int getTransStatus()
	{
		return transStatus;
	}
	
	public String getTransStatusShow()
	{
		return transStatus == Global.TRANS_ORDER_STATUS_FINISH ? "完成" : transStatus == Global.TRANS_ORDER_STATUS_PUT_INTO_BOX ? "已投入物箱" : transStatus == Global.TRANS_ORDER_STATUS_REVOKE ? "撤回" : transStatus == Global.TRANS_ORDER_STATUS_ASSIGNED_COURIERS ? "已分配快递员" : transStatus == Global.TRANS_ORDER_STATUS_FAILED ? "失败（无空箱）" : "未知";
	}

	public void setTransStatus(int transStatus)
	{
		this.transStatus = transStatus;
	}
	
	public List<TransActionDetailWrapper> getTadws()
	{
		return tadws;
	}

	public void setTadws(List<TransActionDetailWrapper> tadws)
	{
		this.tadws = tadws;
	}

	public void addTadws(TransActionDetailWrapper tadw)
	{
		if(tadws == null)
		{
			tadws = new ArrayList<TransActionDetailWrapper>();
		}
		tadws.add(tadw);
	}
}
