package cn.com.xb.util;

import cn.com.xb.domain.base.Storagestationx;

public class SMSTools {

	/**
	 * 维护密码发送模板
	 * @param storagestationx
	 * @return
	 */
	public static String getServiceSMS(Storagestationx storagestationx){
		StringBuffer buffer = new StringBuffer();
		buffer.append("尊敬的维护员，位于")
		.append(storagestationx.getSeatDesc())
		.append("的号物箱").append(storagestationx.getBoxCode())
		.append("号箱子的维护密码为：")
		.append(storagestationx.getMaintainPwd());
		
		return buffer.toString();
	}	
	
	/**
	 * 开箱密码发送模板
	 * @param storagestationx
	 * @return
	 */
	public static String getOpenBoxSMS(Storagestationx storagestationx){
		StringBuffer buffer = new StringBuffer();
		buffer.append("尊敬的用户，位于")
		.append(storagestationx.getSeatDesc())
		.append("的号物箱").append(storagestationx.getBoxCode())
		.append("号箱子的开箱密码为：")
		.append(storagestationx.getMaintainPwd());
		
		return buffer.toString();
	}
}
