package cn.com.xb.inter.domain;

import java.io.Serializable;

import cn.com.xb.util.StringUtil;
import cn.com.xb.util.VerifyTool;

public class IAddresseeInfo implements Serializable {

	/**
	 * 收件人信息
	 */
	private static final long serialVersionUID = 1L;

	private String name;// 姓名
	private String mobilePhone;// 移动电话
	private String address;// 地址
	private String email;// 电子邮箱
	
	/**
	 * 非空验证
	 * @return
	 */
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(VerifyTool.isNull(this.mobilePhone)){
			buffer.append("mobilePhone不能为空 。");
		}
		return buffer.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
