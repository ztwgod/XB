package cn.com.xb.domain.base;

import java.io.Serializable;

public class Transactionx extends Transaction implements Serializable {

	/**
	 * 物箱业务级统计实体类
	 */
	private static final long serialVersionUID = 1L;

	private String sDate; // 开始日期
	private String eDate; // 结束日期

	private String sTime; // 开始时段
	private String eTime; // 结束时段

	private String ssCode; // 物箱代码
	private String groupId; // 物箱组ID

	private boolean isExcel;// 是否为导出EXCEL
	
	private String boxCode; // 箱子代码
	private String boxIndex; // 箱子索引
	
	private String sizeName; //箱子尺寸
	private String transTypeName; //交易类型
	
	public String getTransTypeName() {
		return transTypeName;
	}

	public void setTransTypeName(String transTypeName) {
		this.transTypeName = transTypeName;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public String getBoxIndex() {
		return boxIndex;
	}

	public void setBoxIndex(String boxIndex) {
		this.boxIndex = boxIndex;
	}

	public String getBoxCode() {
		return boxCode;
	}

	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public String geteTime() {
		return eTime;
	}

	public void seteTime(String eTime) {
		this.eTime = eTime;
	}

	public String getSsCode() {
		return ssCode;
	}

	public void setSsCode(String ssCode) {
		this.ssCode = ssCode;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean isExcel() {
		return isExcel;
	}

	public void setExcel(boolean isExcel) {
		this.isExcel = isExcel;
	}

}
