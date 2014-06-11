package cn.com.xb.domain.base;

import java.io.Serializable;

public class Peripheralx extends Peripheral implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ssId; // 物箱ID
	private int runStatus; // 运行状态
	private String runStatusName; // 运行状态名称
	private String ssCode; // 物箱代码
	private String ssName; // 物箱名称

	public String getRunStatusName() {
		return runStatusName;
	}

	public void setRunStatusName(String runStatusName) {
		this.runStatusName = runStatusName;
	}

	public String getSsId() {
		return ssId;
	}

	public void setSsId(String ssId) {
		this.ssId = ssId;
	}

	public int getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(int runStatus) {
		this.runStatus = runStatus;
	}

	public String getSsCode() {
		return ssCode;
	}

	public void setSsCode(String ssCode) {
		this.ssCode = ssCode;
	}

	public String getSsName() {
		return ssName;
	}

	public void setSsName(String ssName) {
		this.ssName = ssName;
	}

}
