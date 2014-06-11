package cn.com.xb.service.helper.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.service.helper.SMSHelperService;

public class SMSHelperServiceImpl implements SMSHelperService {

	private Log log = LogFactory.getLog(SMSHelperServiceImpl.class);
	
	public boolean sendSMS(String[] mobileNumber, String message)throws Exception {
		
		for (int i = 0; i < mobileNumber.length; i++) {
			//TODO:发送密码
			log.info("mobileNumber:"+mobileNumber[i]+",message:"+message+",time:"+new Date());
		}
		return true;
	}

}
