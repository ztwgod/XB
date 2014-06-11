package cn.com.xb.inter.domain.response;

import java.io.Serializable;

public class AppLoginResult implements Serializable {

	/**
	 * APP用户登陆返回结果
	 */
	private static final long serialVersionUID = 1L;

	private String userId;// 用户ID（登陆成功，则返回用户ID信息）
	private String userName;// 用户昵称（登陆成功，则返回用户昵称信息）
	private int resultStatus;// 登陆状态[1，成功；0，失败]
	private String errorMsg; // 失败提示信息

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
