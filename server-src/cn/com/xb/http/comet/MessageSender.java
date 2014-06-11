package cn.com.xb.http.comet;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.jmx.snmp.Timestamp;

import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.inter.domain.request.ConfigureCommandWarpper;
import cn.com.xb.inter.domain.request.DepositUnpackInfoWarpper;
import cn.com.xb.inter.domain.request.RemoteUnpackeInfoWarpper;
import cn.com.xb.util.XstreamUtil;

public class MessageSender implements Runnable{

	protected boolean running = true;
	protected static List<String> messages = new ArrayList<String>();
	private static Map<String,Integer> oldMessage = new HashMap<String, Integer>();
	private Log log = LogFactory.getLog(MessageSender.class);
	
	private final static int TIME_OUT = 5; //重试5次（5秒）如果还没有获取到连接，证明物箱已经断链，需要将消息移除出消息队列。减少服务器压力。

	/*private String url;
	
	public MessageSender(String url) {
		this.url = url;
	}*/

	public void stop() {
		running = false;
	}

	public void send(String message) {
		synchronized (messages){
			messages.add(message.trim());
			messages.notify();
		}		
	}

	public void run() {
		while (running) {
			if (messages.size() == 0) {
				try {
					synchronized (messages) {
						log.info("messages wait....");
						messages.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
			try {
				synchronized (messages){
					for (int i = 0; i < messages.size(); i++) {
						if(messages.get(i).indexOf("@")==-1){
							throw new Exception("请求参数错误！");
						}
						
						if(oldMessage.containsKey(messages.get(i))){
							int size = oldMessage.get(messages.get(i));
							if(size>=TIME_OUT){
								oldMessage.remove(messages.get(i));
								messages.remove(messages.get(i));
								continue;
							}else{
								Thread.sleep(1000);
							}
							log.info(new Timestamp());
						}
						
						String arr[] = messages.get(i).split("@");
						String requestType = arr[0];
						String requestMsg = arr[1];
						log.info("requestType="+requestType+",requestMsg="+requestMsg);
						//根据参数执行方法
						if(this.process(requestType, requestMsg)){//消息发送成功，否则等待获取到链接再发送消息
							messages.remove(messages.get(i));
						}else{
							//放入二次消息队列，表示该消息发送过，但是失败了，当消息失败次数到一定量时，需要从队列中移除该消息，减轻服务器压力。
							if(oldMessage.containsKey(messages.get(i))){
								int size = oldMessage.get(messages.get(i))+1;
								oldMessage.put(messages.get(i), size);
							}else{
								oldMessage.put(messages.get(i), 1);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//发送请求核心方法
	private boolean process(String requestType,String requestMsg){
		if(requestType.equals("1")){//APP请求开箱
			RemoteUnpackeInfoWarpper remote = (RemoteUnpackeInfoWarpper)XstreamUtil.JETTSON2JavaBean(requestMsg, RemoteUnpackeInfoWarpper.class);
			HttpServletResponse response = TomcatHttpServlet.connections.get(remote.getStorageStationId());
			
			ResponseText resText = new ResponseText();
			resText.setSsCode(remote.getStorageStationId());
			resText.setTransNo(remote.getGuiSequenceNumber());
			TomcatHttpServlet.put(resText);//将response交易存入待处理队列中，等到下次接收到该请求结果时再拿出来处理。
			
			if(null == response){
				return false;
			}else{
				PrintWriter writer;
				try {
					writer = response.getWriter();
					writer.println(requestMsg);//发送消息
					writer.flush();
					writer.close();
				} catch (Exception e) {
					return false;
				}
			}
		}else if(requestType.equals("2")){ //GUI远程开箱
			DepositUnpackInfoWarpper remote = (DepositUnpackInfoWarpper)XstreamUtil.JETTSON2JavaBean(requestMsg,DepositUnpackInfoWarpper.class);
			HttpServletResponse response = TomcatHttpServlet.connections.get(remote.getStorageStationId());
			
			ResponseText resText = new ResponseText();
			resText.setSsCode(remote.getStorageStationId());
			resText.setTransNo(remote.getGuiSequenceNumber());
			TomcatHttpServlet.put(resText);//将response交易存入待处理队列中，等到下次接收到该请求结果时再拿出来处理。
			
			if(null == response){
				return false;			
			}
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.println(requestMsg);//发送消息
				writer.flush();
				writer.close();
				
			} catch (Exception e) {
				return false;
			}
		}else if("3".equals(requestType)){ //一般的消息，走该方法
			ConfigureCommandWarpper deposit = (ConfigureCommandWarpper)XstreamUtil.JETTSON2JavaBean(requestMsg,ConfigureCommandWarpper.class);
			HttpServletResponse response = TomcatHttpServlet.connections.get(deposit.getStorageStationId());
			
			ResponseText resText = new ResponseText();
			resText.setSsCode(deposit.getStorageStationId());
			resText.setTransNo(deposit.getGuiSequenceNumber());
			TomcatHttpServlet.put(resText);//将response交易存入待处理队列中，等到下次接收到该请求结果时再拿出来处理。
			
			if(null == response){
				return false;			
			}
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.println(requestMsg);//发送消息
				writer.flush();
				writer.close();
				
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 *
	 * @param resText
	 * @return
	 */
	/*private String getMessage(ResponseText resText){
		ConfigureCommandWarpper deposit = new ConfigureCommandWarpper();
		deposit.setBoxCode(resText.getBoxCode());
		deposit.setGuiSequenceNumber(resText.getTransNo());
		deposit.setStorageStationId(resText.getSsCode());
		deposit.setUserId(resText.getUserId());
		deposit.setGuiOperationType(resText.getResponseType());
		String message = XstreamUtil.javaBean2JETTSON(deposit, ConfigureCommandWarpper.class);
		return message;
	}*/
	
	
}
