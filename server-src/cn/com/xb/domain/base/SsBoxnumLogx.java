package cn.com.xb.domain.base;

import java.io.Serializable;

public class SsBoxnumLogx extends SsBoxnumLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sDate; // 开始日期
	private String eDate; // 结束日期

	private String sTime; // 开始时段
	private String eTime; // 结束时段

	private String ssCode; // 物箱代码
	private String groupId; // 物箱组ID

	private boolean isExcel;// 是否为导出EXCEL

	public boolean isExcel() {
		return isExcel;
	}

	public void setExcel(boolean isExcel) {
		this.isExcel = isExcel;
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
}
