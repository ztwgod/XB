package cn.com.xb.inter.domain.request;

import java.io.Serializable;

public class AppLoginWrapper implements Serializable {

	/**
	 * 登陆信息封装
	 */
	private static final long serialVersionUID = 1L;

	private String userName;// 用户名
	private String password;// 密码

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
