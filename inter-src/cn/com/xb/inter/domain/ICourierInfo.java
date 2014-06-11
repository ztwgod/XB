package cn.com.xb.inter.domain;

import java.io.Serializable;

import cn.com.xb.util.StringUtil;
import cn.com.xb.util.VerifyTool;

public class ICourierInfo implements Serializable {

	/**
	 * 快递员信息
	 */
	private static final long serialVersionUID = 1L;

	private String courierId; // 快递员编号
	private String name; // 姓名
	private String mobilePhone; // 移动电话
	private String excoName; // 所属公司Name
	private String email; // 电子邮箱
	private int status; // 状态
	
	/**
	 * 非空验证
	 * @return
	 */
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		/*if(VerifyTool.isNull(this.mobilePhone)){
			buffer.append("mobilePhone不能为空 。");
		}
		if(VerifyTool.isNull(this.courierId)){
			buffer.append("courierId不能为空 。");
		}*/
		return buffer.toString();
	}

	public String getCourierId() {
		return courierId;
	}

	public void setCourierId(String courierId) {
		this.courierId = courierId;
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

	public String getExcoName() {
		return excoName;
	}

	public void setExcoName(String excoName) {
		this.excoName = excoName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}