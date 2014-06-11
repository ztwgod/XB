package cn.com.xb.inter.domain.request;

import java.io.Serializable;

import cn.com.xb.util.VerifyTool;

public class DepositUnpackInfoWarpper extends BaseRequest implements Serializable {

	/**
	 * 请求开箱封装信息
	 */
	private static final long serialVersionUID = 1L;

	private String userId;// 用户ID
	private String userMobilePhone;// 用户手机号码
	private String boxCode;// 需打开的箱子Code
	private int delayTime;// 开箱延迟时间（单位：秒）
	private String randomNum; //柜子随机数
	
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(VerifyTool.isNull(this.userId)){
			buffer.append("userId不能为空。");
		}
		if(VerifyTool.isNull(this.userMobilePhone)){
			buffer.append("userMobilePhone不能为空。");
		}
		if(VerifyTool.isNull(this.boxCode)){
			buffer.append("boxCode不能为空。");
		}
		if(VerifyTool.isNull(this.randomNum)){
			buffer.append("randomNum不能为空。");
		}
		return buffer.toString();
	}

	public String getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(String randomNum) {
		this.randomNum = randomNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserMobilePhone() {
		return userMobilePhone;
	}

	public void setUserMobilePhone(String userMobilePhone) {
		this.userMobilePhone = userMobilePhone;
	}

	public String getBoxCode() {
		return boxCode;
	}

	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	public int getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(int delayTime) {
		this.delayTime = delayTime;
	}

}
