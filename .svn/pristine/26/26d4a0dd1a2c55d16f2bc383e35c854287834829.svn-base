package cn.com.xb.inter.domain.request;

import java.io.Serializable;

public class ConfigureCommandWarpper extends BaseRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;// 操作用户ID（平台操作用户）
	private String boxCode;// 对应的箱子Code
	private int guiOperationType;// gui指令类型（1，物箱信息同步；2，设置收件快递员组；3，设置投件快递员组；4，设置维护员；5，查询物箱状态；6，查询外围设备状态；7，查询箱子状态；8，开箱；）

	public int getGuiOperationType() {
		return guiOperationType;
	}

	public void setGuiOperationType(int guiOperationType) {
		this.guiOperationType = guiOperationType;
	}

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
}
