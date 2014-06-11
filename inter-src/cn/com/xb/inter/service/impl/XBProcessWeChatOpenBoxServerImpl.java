package cn.com.xb.inter.service.impl;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import cn.com.xb.dao.ITransactionDao;
import cn.com.xb.daox.ITransactionDaox;
import cn.com.xb.daox.IUserDaox;
import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.domain.base.StoragestationIntfLog;
import cn.com.xb.domain.base.Transaction;
import cn.com.xb.inter.domain.request.RemoteUnpackeInfoWarpper;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.service.InterfaceLogService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.SpringTool;
import cn.com.xb.util.XstreamUtil;

public class XBProcessWeChatOpenBoxServerImpl implements XBProcessServer{

	private ITransactionDaox transactionDaox;
	private static Map<String, ResponseText> resultMaps = new ConcurrentHashMap<String, ResponseText>(); //已经发送请求个物箱，但是还未收到处理结果的交易请求
	protected static Map<String, HttpServletResponse> connections = new ConcurrentHashMap<String, HttpServletResponse>();//<物箱Code,长连接>
	public void setTransactionDaox(ITransactionDaox transactionDaox) {
		this.transactionDaox=transactionDaox;
	}
//得到开箱信息包装类
	public String process(String message) throws Exception {
		String []msg=message.split(" ");
		String transId=msg[0];
		String password=msg[1];
		System.out.println(msg[0]+msg[1]);
		String userId = transactionDaox.getUserIdByTransactionId(transId);
		RemoteUnpackeInfoWarpper remote=transactionDaox.getAppOpenBoxInfo(transId);
		remote.setRandomNum("123123");
		remote.setUserId(userId);
		String guiSequenceNumber = KeyHelper.creatKey();
		remote.setGuiSequenceNumber(guiSequenceNumber);
		String json = XstreamUtil.javaBean2JETTSON(remote, RemoteUnpackeInfoWarpper.class);	
		
		return json;
	}
	
	
}
