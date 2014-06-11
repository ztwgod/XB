package cn.com.xb.domain.base;

import java.io.Serializable;

public class Storagestationx extends Storagestation implements Serializable {

	private static final long serialVersionUID = 1L;

	private String seatDesc; // 物箱地址
	private String userName; // 维护员
	private String groupAbb; // 组简称

	private String mobileNumber; // 手机号
	private String boxCode; // 箱子代码
	private String boxId; // 箱子ID
	private String maintainPwd; // 开箱密码
	private String runStatusName; // 运行状态

	private int size; // 尺寸

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getRunStatusName() {
		return runStatusName;
	}

	public void setRunStatusName(String runStatusName) {
		this.runStatusName = runStatusName;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getMaintainPwd() {
		return maintainPwd;
	}

	public void setMaintainPwd(String maintainPwd) {
		this.maintainPwd = maintainPwd;
	}

	public String getBoxCode() {
		return boxCode;
	}

	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGroupAbb() {
		return groupAbb;
	}

	public void setGroupAbb(String groupAbb) {
		this.groupAbb = groupAbb;
	}

	public String getSeatDesc() {
		return seatDesc;
	}

	public void setSeatDesc(String seatDesc) {
		this.seatDesc = seatDesc;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
