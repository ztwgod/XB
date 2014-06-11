package cn.com.xb.inter.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.inter.domain.IAddresseeInfo;
import cn.com.xb.inter.domain.ICourierInfo;
import cn.com.xb.inter.domain.ISenderInfo;
import cn.com.xb.inter.domain.ITransactionInfo;
import cn.com.xb.inter.domain.request.TransactionWrapper;
import cn.com.xb.inter.domain.response.SynchSysUserResult;
import cn.com.xb.inter.domain.response.TransactionResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.service.OperationLogService;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.service.TransactionService;
import cn.com.xb.util.VerifyTool;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.StringUtil;
import cn.com.xb.util.XstreamUtil;

public class XBProcessTransactionServerImpl implements XBProcessServer{

	private static Log log = LogFactory.getLog(XBProcessTransactionServerImpl.class);
	private TransactionService transactionService;
	private OperationLogService operationLogService;
	private StoragestationaService ssService;
	
	public void setTransactionService(TransactionService transactionService)
	{
		this.transactionService = transactionService;
	}
	public void setOperationLogService(OperationLogService operationLogService)
	{
		this.operationLogService = operationLogService;
	}
	public void setSsService(StoragestationaService ssService)
	{
		this.ssService = ssService;
	}
	

	@Override
	public String process(String message) throws Exception {
		List<Class> classs = new ArrayList<Class>();
		classs.add(TransactionWrapper.class);
		classs.add(ITransactionInfo.class);
		classs.add(ISenderInfo.class);
		classs.add(IAddresseeInfo.class);
		classs.add(ICourierInfo.class);
		
		TransactionWrapper transactionWrapper = null;
		TransactionResult result = new TransactionResult();
		
		// 处理日志信息
		OperationLog oLog = new OperationLog();
		oLog.setLogId(KeyHelper.creatKey());
		oLog.setSysPlatType(2);
		oLog.setOperationType(20);	// 默认操作类型
		oLog.setOperationUserId(Global.SYNC_OP_USER_ID);	// sync同步
		oLog.setOperationContent("同步物箱交易信息，相关参数："+message);
		oLog.setOperationTime(new Timestamp(new Date().getTime()));
		
		
		try {
			transactionWrapper = (TransactionWrapper) XstreamUtil.JETTSON2JavaBean(message, classs);
			
			//非空验证
			String errorMsg = VerifyTool.verify(transactionWrapper);
			if(!VerifyTool.isNull(errorMsg)){
				result.setStorageStationId(transactionWrapper.getStorageStationId());
				result.setResultStatus(Global.XB_INTER_FAIL);
				result.setErrorMsg(errorMsg);
				String jsonResult = XstreamUtil.javaBean2JETTSON(result, TransactionResult.class);
				return jsonResult;
			}
			
			try {
				oLog.setSsId(ssService.getSSIdBySSCode(transactionWrapper.getStorageStationId()));
				oLog.setBoxId(ssService.getBoxIdByBoxCode(transactionWrapper.getTransactionInfo().getBoxCode()));
			} catch (Exception e) {
				log.error(e);
			}
			
			if(StringUtil.isBlank(oLog.getSsId()))	// 物箱不存在，不允许同步
			{
				result.setSequenceNumber(transactionWrapper.getSequenceNumber());
				result.setStorageStationId(transactionWrapper.getStorageStationId());
				result.setResultStatus(Global.XB_INTER_FAIL);
				result.setErrorMsg("物箱在平台不存在。");
				String jsonResult = XstreamUtil.javaBean2JETTSON(result, TransactionResult.class);
				log.info(jsonResult);
				
				oLog.setOperationResult("同步失败，失败信息："+jsonResult);
				operationLogService.addOperationLogInfo(oLog);
				return jsonResult;
			}
			oLog.setOperationType(getTransTypeByTransActionType(transactionWrapper.getTransActionType()));	// 操作类型
			
			//判断物箱密码是否为空（如果物箱上来的消息中没有密码，平台需要生成一个，在确认消息中携带给物箱）
			if(StringUtil.isNull(transactionWrapper.getTransactionInfo().getPickupPassword())){
				transactionWrapper.getTransactionInfo().setPickupPassword(KeyHelper.creatKey(6));
			}
			transactionService.syncTransactionInfo(transactionWrapper);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			result.setResultStatus(Global.XB_INTER_FAIL);//是否上传同步交易成功：0，失败；1，成功
			result.setErrorMsg("系统异常，"+e.getMessage());
			result.setSequenceNumber(transactionWrapper.getSequenceNumber());
			result.setStorageStationId(transactionWrapper.getStorageStationId());
			String json = XstreamUtil.javaBean2JETTSON(result, TransactionResult.class);
			
			oLog.setOperationResult("同步失败，失败信息："+json);
			operationLogService.addOperationLogInfo(oLog);
			return json;
		}
		
		//成功
		result.setResultStatus(Global.XB_INTER_SUCCESS); //是否上传同步交易成功：0，失败；1，成功
		result.setSequenceNumber(transactionWrapper.getSequenceNumber());
		result.setStorageStationId(transactionWrapper.getStorageStationId());
		result.setTransactionID(transactionWrapper.getTransactionInfo().getTransactionID());
		result.setBoxcode(transactionWrapper.getTransactionInfo().getBoxCode());
		
		//密码 KeyHelper.creatKey(6)  如果物箱上来的消息中没有密码，平台需要生成一个，在确认消息中携带给物箱。
		result.setPickupPassword(transactionWrapper.getTransactionInfo().getPickupPassword());
		
		
		/*
		 * 				快递		寄存
		 * 起步价		0		5
		 * 免费时长		6h		6h
		 * 超时后单价	1		1
		 * 封顶			10		10
		 * 超期时长		24h		24h
		 */
		// 是否为快递单
		if(isExpressTrans(transactionWrapper.getTransActionType()))
		{
			result.setPricingStarts(0);
		}
		// 是否为寄存单
		if(isDepositTrans(transactionWrapper.getTransActionType()))
		{
			result.setPricingStarts(5);
		}
		result.setFreeTime(6*60);
		result.setOverTimeUnitPrice(1);
		result.setMaximumPrice(10);
		result.setOverdueTime(24*60);
		
		String json = XstreamUtil.javaBean2JETTSON(result, TransactionResult.class);
		log.info(json);
		
		oLog.setOperationResult("同步成功，相关信息："+json);
		operationLogService.addOperationLogInfo(oLog);
		return json;
	}

	
	/**
	 * 是否为快递交易单
	 * @param transActionType
	 * @return
	 */
	public boolean isExpressTrans(int transActionType)
	{
		boolean flag = false;
		/*
		 * 1，成功：寄件人寄件；
		 * 2，成功：快递员取件；
		 * 3，成功：快递员投件；
		 * 4，成功：收件人收件；
		 * 7，无空箱：寄件人寄件；
		 * 8，无空箱：快递员投件；
		 * 10，退件：快递员投件；
		 * 
		 * 5，成功：寄存人寄件；
		 * 6，成功：寄存人取件；
		 * 9，无空箱：寄存；
		 * 11，退件：寄存人寄件
		 */
		switch (transActionType)
		{
		case Global.SYN_TRANS_ACTION_TYPE_1:
		case Global.SYN_TRANS_ACTION_TYPE_2:
		case Global.SYN_TRANS_ACTION_TYPE_3:
		case Global.SYN_TRANS_ACTION_TYPE_4:
		case Global.SYN_TRANS_ACTION_TYPE_7:
		case Global.SYN_TRANS_ACTION_TYPE_8:
		case Global.SYN_TRANS_ACTION_TYPE_10:
			flag = true;
			break;
		}

		return flag;
	}
	
	
	/**
	 * 是否为寄存交易单
	 * @param transActionType
	 * @return
	 */
	public boolean isDepositTrans(int transActionType)
	{
		boolean flag = false;
		switch (transActionType)
		{
		case Global.SYN_TRANS_ACTION_TYPE_5:
		case Global.SYN_TRANS_ACTION_TYPE_6:
		case Global.SYN_TRANS_ACTION_TYPE_9:
		case Global.SYN_TRANS_ACTION_TYPE_11:
			flag = true;
			break;
		}
		
		return flag;
	}
	

	/**
	 * 获取操作类型
	 * 		20,'同步交易信息'
			21,'客户寄件'
			22,'快递员投件
			23,'客户寄存'
			24,'快递员取件
			25,'客户取件'
			26，退件
	 * @param transActionType
	 * @return
	 */
	public int getTransTypeByTransActionType(int transActionType)
	{
		int flag = 20;
		switch (transActionType)
		{
		case Global.SYN_TRANS_ACTION_TYPE_7:
			flag = 21;
			break;
		//case Global.SYN_TRANS_ACTION_TYPE_1:
		case Global.SYN_TRANS_ACTION_TYPE_3:
		case Global.SYN_TRANS_ACTION_TYPE_8:
			flag = 22;
			break;
		case Global.SYN_TRANS_ACTION_TYPE_5:
		case Global.SYN_TRANS_ACTION_TYPE_9:
			flag = 23;
			break;
		case Global.SYN_TRANS_ACTION_TYPE_2:
			flag = 24;
			break;
		case Global.SYN_TRANS_ACTION_TYPE_4:
		case Global.SYN_TRANS_ACTION_TYPE_6:
			flag = 25;
			break;
		case Global.SYN_TRANS_ACTION_TYPE_10:
		case Global.SYN_TRANS_ACTION_TYPE_11:
			flag = 26;
			break;
		}
		
		return flag;
	}
}
