package cn.com.xb.service.helper;

public interface SMSHelperService {

	/**
	 * 短信发送接口
	 * @param mobileNumber 手机号
	 * @param message 短信内容
	 * @return
	 * @throws Exception
	 */
	public boolean sendSMS(String[] mobileNumber,String message) throws Exception;
}
