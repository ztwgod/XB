package cn.com.xb.inter.domain;

import java.io.Serializable;

public class ICourierAuthorityInfo implements Serializable {

	/**
	 * 快递员权限信息
	 */
	private static final long serialVersionUID = 1L;

	private ICourierInfo courierInfo; // 快递员信息
	private ICourierCardInfo courierCardInfo; // 快递员关联卡信息
	private int authorityType;// 权限类型（1，派件寄存；2，寄件取件）

	public ICourierInfo getCourierInfo() {
		return courierInfo;
	}

	public void setCourierInfo(ICourierInfo courierInfo) {
		this.courierInfo = courierInfo;
	}

	public ICourierCardInfo getCourierCardInfo() {
		return courierCardInfo;
	}

	public void setCourierCardInfo(ICourierCardInfo courierCardInfo) {
		this.courierCardInfo = courierCardInfo;
	}

	public int getAuthorityType() {
		return authorityType;
	}

	public void setAuthorityType(int authorityType) {
		this.authorityType = authorityType;
	}

}
