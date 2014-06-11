package cn.com.xb.gui.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.daox.IUserDaox;
import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.gui.service.GUIHelperServer;
import cn.com.xb.inter.domain.request.ConfigureCommandWarpper;
import cn.com.xb.inter.domain.request.DepositUnpackInfoWarpper;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.XstreamUtil;

public class OpenBoxServerImpl implements GUIHelperServer{

	private static Log log = LogFactory.getLog(OpenBoxServerImpl.class);
	
	private IUserDaox userDaox;
	
	public void setUserDaox(IUserDaox userDaox) {
		this.userDaox = userDaox;
	}
	
	public String openBoxJsonMessage(ResponseText resText) throws Exception{
		DepositUnpackInfoWarpper deposit = new DepositUnpackInfoWarpper();
		deposit.setBoxCode(resText.getBoxCode());
		deposit.setDelayTime(0);
		
		deposit.setStorageStationId(resText.getSsCode());
		String guiSequenceNumber = KeyHelper.creatKey();
		
		deposit.setUserId(resText.getUserId());
		String userMobile = userDaox.loadUserMobileByBoxId(resText.getSsId(),resText.getBoxCode());
		deposit.setUserMobilePhone(userMobile);
		deposit.setGuiSequenceNumber(guiSequenceNumber);
		
		String json = XstreamUtil.javaBean2JETTSON(deposit, DepositUnpackInfoWarpper.class);
		log.info(json);
		return json;
	}
}
