package cn.com.xb.inter.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.inter.domain.request.ConfigureCommandWarpper;
import cn.com.xb.util.Global;
import cn.com.xb.util.XstreamUtil;

public class GUIMessageUtil {
	
	private static final Log log = LogFactory.getLog(GUIMessageUtil.class);

	public String getMessage(ResponseText resText,HttpServletRequest request) throws Exception{
		String sendMessage = null;
		int responseType  = resText.getResponseType();
		//gui指令类型（1，物箱信息同步；2，设置收件快递员组；3，设置投件快递员组；4，设置维护员；5，查询物箱状态；6，查询外围设备状态；7，查询箱子状态；8，开箱；）
		if(responseType==Global.BOX_GUI_RESPONSETYPE_SYN){//同步
			sendMessage = this.appendMessage(resText);
		}/*else if(responseType==Global.BOX_GUI_OPENBOX){ //开箱
			GUIHelperServer guiHelperServer = (GUIHelperServer)SpringTool.getBean(request,"openBoxServerImpl");
			sendMessage = guiHelperServer.openBoxJsonMessage(resText);
		}*/
		else if(responseType==Global.BOX_GUI_SETSYSTEMUSER){//设置维护员
			sendMessage = this.appendMessage(resText);
		}else if(responseType==Global.BOX_GUI_RECIPIENTCOURIER){//设置收件快递员组
			sendMessage = this.appendMessage(resText);
		}else if(responseType==Global.BOX_GUI_CASTPARTS){//设置投件快递员组 
			sendMessage = this.appendMessage(resText);
		}else if(responseType==Global.BOX_GUI_BOXSTATUS){//查询物箱状态
			sendMessage = this.appendMessage(resText);
		}else if(responseType==Global.BOX_GUI_PERIPHERAL){//查询外围设备
			sendMessage = this.appendMessage(resText);
		}else if(responseType==Global.BOX_GUI_BOXINFO){//查询箱子信息
			sendMessage = this.appendMessage(resText);
		}
		log.info("sendMessage："+sendMessage);
		return sendMessage;
	}
	
	private String appendMessage(ResponseText resText){
		ConfigureCommandWarpper deposit = new ConfigureCommandWarpper();
		deposit.setBoxCode(resText.getBoxCode());
		deposit.setGuiSequenceNumber(resText.getTransNo());
		deposit.setStorageStationId(resText.getSsCode());
		deposit.setUserId(resText.getUserId());
		deposit.setGuiOperationType(resText.getResponseType());
		String message = XstreamUtil.javaBean2JETTSON(deposit, ConfigureCommandWarpper.class);
		return message;
	}
	
}
