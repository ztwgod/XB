package cn.com.xb.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import cn.com.xb.dao.IFeeProofDao;
import cn.com.xb.dao.IPClientDao;
import cn.com.xb.dao.ITransActionDetailDao;
import cn.com.xb.dao.ITransactionDao;
import cn.com.xb.dao.IUserDao;
import cn.com.xb.daox.IBoxInfoDaox;
import cn.com.xb.daox.IStoragestationDaox;
import cn.com.xb.daox.ITransactionDaox;
import cn.com.xb.daox.IUserDaox;
import cn.com.xb.domain.base.FeeProof;
import cn.com.xb.domain.base.PClient;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.TransActionDetail;
import cn.com.xb.domain.base.Transaction;
import cn.com.xb.domain.base.Transactionx;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.displayWrapper.BoxStatusWrapper;
import cn.com.xb.domain.parameterWrapper.GetBoxStatusListParam;
import cn.com.xb.inter.domain.request.TransactionWrapper;
import cn.com.xb.service.TransactionService;
import cn.com.xb.util.DateTools;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.MD5;
import cn.com.xb.util.StringUtil;

public class TransactionServiceImpl implements TransactionService {

	private ITransactionDao transactionDao;
	private ITransactionDaox transactionDaox;
	private IBoxInfoDaox boxInfoDaox;
	private IUserDao userDao;
	private IUserDaox userDaox;
	private IPClientDao clientDao;
	private ITransActionDetailDao transActionDetailDao;
	private IFeeProofDao feeProofDao;
	
	
	
	public void setTransactionDao(ITransactionDao transactionDao)
	{
		this.transactionDao = transactionDao;
	}

	public void setTransactionDaox(ITransactionDaox transactionDaox) {
		this.transactionDaox = transactionDaox;
	}

	public Transaction getTransaction(String boxId) throws Exception {
		
		return transactionDaox.getTransaction(boxId);
	}

	public void setBoxInfoDaox(IBoxInfoDaox boxInfoDaox)
	{
		this.boxInfoDaox = boxInfoDaox;
	}
	
	public void setUserDao(IUserDao userDao)
	{
		this.userDao = userDao;
	}

	public void setUserDaox(IUserDaox userDaox)
	{
		this.userDaox = userDaox;
	}

	public void setClientDao(IPClientDao clientDao)
	{
		this.clientDao = clientDao;
	}

	public void setTransActionDetailDao(ITransActionDetailDao transActionDetailDao)
	{
		this.transActionDetailDao = transActionDetailDao;
	}

	public void setFeeProofDao(IFeeProofDao feeProofDao)
	{
		this.feeProofDao = feeProofDao;
	}

	

	@Override
	public int getTransItems(Transactionx tranx) throws Exception {
		
		
		return transactionDaox.getTransItems(tranx);
	}

	@Override
	public List<Transactionx> getTransLists(Transactionx tranx, Page page)
			throws Exception {
		
		return transactionDaox.getTransLists(tranx, page);
	}
	
	
	
	
	
	/*
	 * ************************************************************** 
	 * 				下面为物箱端交易接口数据处理
	 * **************************************************************
	 */
	public  List<Transaction> loadTransactionByUserId(String userId) throws Exception {
		return transactionDao.loadTransactionByUserId(userId);
	}


	/**
	 * 查看该交易ID是否已存在
	 */
	public boolean isExistTransByID(String transId) throws Exception
	{
		return false;
	}
	
	public void syncTransactionInfo(TransactionWrapper tw) throws Exception
	{
		if (null == tw || null == tw.getTransactionInfo())
		{
			return;
		}
		// 交易订单存在, 新增订单动作，修改订单状态，后续动作记录
		String transId = transactionDaox.getTransIdByBoxTransID(tw.getTransactionInfo().getTransactionID());
		if(StringUtil.isNotBlank(transId))
		{
			// 添加交易动作等，修改交易订单信息
			// 订单信息
			Transaction ta = new Transaction();
			ta.setTransId(transId);
			ta.setCourierId(null != tw.getTransactionInfo().getCourierInfo() ? tw.getTransactionInfo().getCourierInfo().getCourierId() : null);
			ta.setExpressDeliveryId(tw.getTransactionInfo().getExpressDeliveryId());
			ta.setExpressCode(tw.getTransactionInfo().getExpressCode());
			ta.setExpressDesc(tw.getTransactionInfo().getExpressDescription());
			ta.setTotalAmount(tw.getTransactionInfo().getTotalAmount());
			ta.setStorageTime(tw.getTransactionInfo().getStorageTime());
			ta.setPastDueTime(tw.getTransactionInfo().getPastDueTime());
			ta.setPickupPwd(tw.getTransactionInfo().getPickupPassword());
			ta.setIsStandardsCompliant(tw.getTransactionInfo().getIsStandardsCompliant());
			ta.setNotStandardsCompliantCause(tw.getTransactionInfo().getNotStandardsCompliantCause());
			
			// 接口中交易类型：1，成功：寄件人寄件；2，成功：快递员取件；3，成功：快递员投件；4，成功：收件人收件；5，成功：寄存人寄件；6，成功：寄存人取件；7，无空箱：寄件人寄件；8，无空箱：快递员投件；9，无空箱：寄存；10，退件：快递员投件；11，退件：寄存人寄件
			ta.setTransType(getTransTypeByActionType(tw.getTransActionType()));	// 交易类型
			ta.setTransStatus(getTransStatusByActionType(tw.getTransActionType()));		// 交易状态，通过交易类型确定
			
			ta.setLastModifyTime(DateTools.formatStringToTimestamp(tw.getClientTime(), DateTools.FORMAT_YYYYMMDD_HHMMSS));	// 最后修改时间
			if(ta.getTransStatus() == Global.TRANS_ORDER_STATUS_FINISH || ta.getTransStatus() == Global.TRANS_ORDER_STATUS_FAILED)
			{
				ta.setCloseTime(DateTools.formatStringToTimestamp(tw.getClientTime(), DateTools.FORMAT_YYYYMMDD_HHMMSS));		// 关闭时间
			}
			
			String boxId = boxInfoDaox.getBoxIdByBoxCode(tw.getTransactionInfo().getBoxCode());
			//ta.setBoxId(boxId);	// 对应物箱ID
			transactionDaox.updateTransactionInfo(ta);		// update

			// 修改箱子状态
			int boxStatus = getBoxStatusByActionType(tw.getTransActionType());
			if(0 != boxStatus)
			{
				boxInfoDaox.updateLoadStatusByBoxId(boxId, boxStatus);
			}
			
			
			// 订单交易动作详情
			TransActionDetail tad = new TransActionDetail();
			tad.setTransActionId(KeyHelper.creatKey());
			tad.setTransActionType(tw.getTransActionType());
			tad.setTransId(ta.getTransId());
			tad.setActionTime(DateTools.formatStringToTimestamp(tw.getClientTime(), DateTools.FORMAT_YYYYMMDD_HHMMSS));
			
			// 操作用户ID
			if(tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_1 || 
					tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_5 || 
					tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_6 || 
					tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_7 || 
					tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_9 || 
					tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_11)	// 发件人
			{
				String senderId = transactionDaox.getSenderIdByTransId(transId);
				tad.setActioner(senderId);
			}
			else if (tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_4)	// 收件人
			{
				String addresseeId = transactionDaox.getAddresseeIdByTransId(transId);
				tad.setActioner(addresseeId);
			}
			else if (tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_2 || 
					tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_3 || 
					tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_8 || 
					tw.getTransActionType() == Global.SYN_TRANS_ACTION_TYPE_10)	// 快递员
			{
				tad.setActioner(ta.getCourierId());
			}
//			tad.setBoxActionId("");		// 柜子端交易动作ID，目前没有提供
			transActionDetailDao.insert(tad);
			
			// 订单交易动作涉及收费凭证
			if(tw.getTransactionInfo().getPayType() != 0 && tw.getTransactionInfo().getPayMode() != 0)
			{
				FeeProof fp = new FeeProof();
				fp.setFeeId(KeyHelper.creatKey());
				fp.setTransId(tad.getTransId());
				fp.setTransActionId(tad.getTransActionId());
				fp.setPayType(tw.getTransactionInfo().getPayType());
				fp.setPayMethods(tw.getTransactionInfo().getPayMode());
				fp.setAmount(tw.getTransactionInfo().getPayPrice());
				fp.setVoucherId(tw.getTransactionInfo().getVoucherId());
				fp.setVoucherTotal(tw.getTransactionInfo().getVoucherTotal());
//				fp.setPayDesc("");		// 支付详情，目前没有提供
//				fp.setBoxFeeId("");		// 物箱端凭证ID，目前没有提供
				feeProofDao.insert(fp);
			}
		}
		else	// 交易订单不存在, 添加初始订单，第一笔动作
		{
			// 添加交易订单信息和交易动态等
			// 订单信息
			Transaction ta = new Transaction();
			ta.setTransId(KeyHelper.creatKey());
			ta.setTransCode(tw.getTransactionInfo().getTransactionID());
			ta.setSupplierId(tw.getTransactionInfo().getSupplierId());
			ta.setCourierId(null != tw.getTransactionInfo().getCourierInfo() ? tw.getTransactionInfo().getCourierInfo().getCourierId() : null);
			ta.setExpressDeliveryId(tw.getTransactionInfo().getExpressDeliveryId());
			ta.setExpressCode(tw.getTransactionInfo().getExpressCode());
			ta.setExpressDesc(tw.getTransactionInfo().getExpressDescription());
			ta.setTotalAmount(tw.getTransactionInfo().getTotalAmount());
			ta.setStorageTime(tw.getTransactionInfo().getStorageTime());
			ta.setPastDueTime(tw.getTransactionInfo().getPastDueTime());
			ta.setPickupPwd(tw.getTransactionInfo().getPickupPassword());
			ta.setSizeType(tw.getTransactionInfo().getExpressSizeType());
			ta.setIsStandardsCompliant(tw.getTransactionInfo().getIsStandardsCompliant());
			ta.setNotStandardsCompliantCause(tw.getTransactionInfo().getNotStandardsCompliantCause());
			ta.setBoxTransId(tw.getTransactionInfo().getTransactionID());
			// sender
			User sender = new User();
			if(null != tw.getTransactionInfo().getSenderInfo())
			{
				sender.setUserName(tw.getTransactionInfo().getSenderInfo().getName());
				sender.setMobileNumber(tw.getTransactionInfo().getSenderInfo().getMobilePhone());
				sender.setHabitualResidence(tw.getTransactionInfo().getSenderInfo().getAddress());
				sender.setEmail(tw.getTransactionInfo().getSenderInfo().getEmail());
				
				String userId = userDaox.getUserIdByMobileNum(tw.getTransactionInfo().getSenderInfo().getMobilePhone());
				if(null == userId)
				{
					userId = KeyHelper.creatKey();
					sender.setUserId(userId);
					sender.setUserName(tw.getTransactionInfo().getSenderInfo().getMobilePhone());
					sender.setUserAccount(tw.getTransactionInfo().getSenderInfo().getMobilePhone());
					sender.setPassword(MD5.getMD5Str("123456"));
					sender.setUserType(Global.USER_TYPE_1);
					sender.setStatus(Global.USER_STATUS_WX);
					sender.setCreateTime(new Timestamp(new Date().getTime()));
					
					PClient pc = new PClient();
					pc.setUserId(userId);
					pc.setRegisterType(Global.REGISTER_TYPE_4);
					pc.setOverage(0);
					
					userDao.insert(sender);
					clientDao.insert(pc);
				}
				else
				{
					sender.setUserId(userId);
					userDaox.updateUserInfo(sender);
				}
				
				ta.setSenderId(userId);
			}
			
			// addressee
			User addressee = new User();
			if(null != tw.getTransactionInfo().getAddresseeInfo())
			{
				addressee.setUserName(tw.getTransactionInfo().getAddresseeInfo().getName());
				addressee.setMobileNumber(tw.getTransactionInfo().getAddresseeInfo().getMobilePhone());
				addressee.setHabitualResidence(tw.getTransactionInfo().getAddresseeInfo().getAddress());
				addressee.setEmail(tw.getTransactionInfo().getAddresseeInfo().getEmail());
				
				String userId = userDaox.getUserIdByMobileNum(tw.getTransactionInfo().getAddresseeInfo().getMobilePhone());
				if(null == userId)
				{
					userId = KeyHelper.creatKey();
					addressee.setUserId(userId);
					addressee.setUserName(tw.getTransactionInfo().getAddresseeInfo().getMobilePhone());
					addressee.setUserAccount(tw.getTransactionInfo().getAddresseeInfo().getMobilePhone());
					addressee.setPassword(MD5.getMD5Str("123456"));
					addressee.setUserType(Global.USER_TYPE_1);
					addressee.setStatus(Global.USER_STATUS_WX);
					addressee.setCreateTime(new Timestamp(new Date().getTime()));
					
					PClient pc = new PClient();
					pc.setUserId(userId);
					pc.setRegisterType(Global.REGISTER_TYPE_4);
					pc.setOverage(0);
					
					userDao.insert(addressee);
					clientDao.insert(pc);
				}
				else
				{
					addressee.setUserId(userId);
					userDaox.updateUserInfo(addressee);
				}
				
				ta.setAddresseeId(userId);
			}

			// 接口中交易类型：1，成功：寄件人寄件；2，成功：快递员取件；3，成功：快递员投件；4，成功：收件人收件；5，成功：寄存人寄件；6，成功：寄存人取件；7，无空箱：寄件人寄件；8，无空箱：快递员投件；9，无空箱：寄存；10，退件：快递员投件；11，退件：寄存人寄件
			ta.setTransType(getTransTypeByActionType(tw.getTransActionType()));	// 交易类型
			ta.setTransStatus(getTransStatusByActionType(tw.getTransActionType()));		// 交易状态，通过交易类型确定
			if(ta.getTransType() == Global.TRANS_TYPE_1 || ta.getTransType() == Global.TRANS_TYPE_3)	// 创建用户ID
			{
				ta.setUserId(sender.getUserId());
			}
			else if (ta.getTransType() == Global.TRANS_TYPE_2)
			{
				ta.setUserId(ta.getCourierId());
			}
			
			ta.setCreateTime(DateTools.formatStringToTimestamp(tw.getClientTime(), DateTools.FORMAT_YYYYMMDD_HHMMSS));		// 创建时间
			ta.setLastModifyTime(DateTools.formatStringToTimestamp(tw.getClientTime(), DateTools.FORMAT_YYYYMMDD_HHMMSS));	// 最后修改时间
			if(ta.getTransStatus() == Global.TRANS_ORDER_STATUS_FINISH || ta.getTransStatus() == Global.TRANS_ORDER_STATUS_FAILED)
			{
				ta.setCloseTime(DateTools.formatStringToTimestamp(tw.getClientTime(), DateTools.FORMAT_YYYYMMDD_HHMMSS));		// 关闭时间
			}
			
			String boxId = boxInfoDaox.getBoxIdByBoxCode(tw.getTransactionInfo().getBoxCode());
			ta.setBoxId(boxId);	// 对应物箱ID
			transactionDao.insert(ta);
			
			// 修改箱子状态
			int boxStatus = getBoxStatusByActionType(tw.getTransActionType());
			if(0 != boxStatus)
			{
				boxInfoDaox.updateLoadStatusByBoxId(boxId, boxStatus);
			}
			
			// 订单交易动作详情
			TransActionDetail tad = new TransActionDetail();
			tad.setTransActionId(KeyHelper.creatKey());
			tad.setTransActionType(tw.getTransActionType());
			tad.setTransId(ta.getTransId());
			tad.setActionTime(DateTools.formatStringToTimestamp(tw.getClientTime(), DateTools.FORMAT_YYYYMMDD_HHMMSS));
			tad.setActioner(ta.getUserId());
//			tad.setBoxActionId("");		// 柜子端交易动作ID，目前没有提供
			transActionDetailDao.insert(tad);
			
			// 订单交易动作涉及收费凭证
			if(tw.getTransactionInfo().getPayType() != 0 && tw.getTransactionInfo().getPayMode() != 0)
			{
				FeeProof fp = new FeeProof();
				fp.setFeeId(KeyHelper.creatKey());
				fp.setTransId(tad.getTransId());
				fp.setTransActionId(tad.getTransActionId());
				fp.setPayType(tw.getTransactionInfo().getPayType());
				fp.setPayMethods(tw.getTransactionInfo().getPayMode());
				fp.setAmount(tw.getTransactionInfo().getPayPrice());
				fp.setVoucherId(tw.getTransactionInfo().getVoucherId());
				fp.setVoucherTotal(tw.getTransactionInfo().getVoucherTotal());
//				fp.setPayDesc("");		// 支付详情，目前没有提供
//				fp.setBoxFeeId("");		// 物箱端凭证ID，目前没有提供
				feeProofDao.insert(fp);
			}
		}
	}
	
	
	
	/**
	 * 根据接口中的交易动作类型，转换为平台的交易订单类型
	 */
	public int getTransTypeByActionType(int iTransActionType)
	{
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
		int actionType = 0;
		switch (iTransActionType)
		{
		case Global.SYN_TRANS_ACTION_TYPE_1:
		case Global.SYN_TRANS_ACTION_TYPE_2:
		case Global.SYN_TRANS_ACTION_TYPE_7:
			actionType = Global.TRANS_TYPE_1;
			break;
		case Global.SYN_TRANS_ACTION_TYPE_3:
		case Global.SYN_TRANS_ACTION_TYPE_4:
		case Global.SYN_TRANS_ACTION_TYPE_8:
		case Global.SYN_TRANS_ACTION_TYPE_10:
			actionType = Global.TRANS_TYPE_2;
			break;
		case Global.SYN_TRANS_ACTION_TYPE_5:
		case Global.SYN_TRANS_ACTION_TYPE_6:
		case Global.SYN_TRANS_ACTION_TYPE_9:
		case Global.SYN_TRANS_ACTION_TYPE_11:
			actionType = Global.TRANS_TYPE_3;
			break;
		}
		return actionType;
	}
	
	
	/**
	 * 根据接口中的交易动作类型，转换为平台的交易订单类型
	 */
	public int getTransStatusByActionType(int iTransActionType)
	{
		/*
		 * 1，成功：寄件人寄件；
		 * 3，成功：快递员投件；
		 * 5，成功：寄存人寄件；
		 * 
		 * 2，成功：快递员取件；
		 * 4，成功：收件人收件；
		 * 6，成功：寄存人取件；
		 * 
		 * 7，无空箱：寄件人寄件；
		 * 8，无空箱：快递员投件；
		 * 9，无空箱：寄存；
		 * 
		 * 11，退件：寄存人寄件
		 * 10，退件：快递员投件；
		 */
		int transStatus = 0;
		switch (iTransActionType)
		{
		case Global.SYN_TRANS_ACTION_TYPE_1:
		case Global.SYN_TRANS_ACTION_TYPE_3:
		case Global.SYN_TRANS_ACTION_TYPE_5:
			transStatus = Global.TRANS_ORDER_STATUS_PUT_INTO_BOX;	// 已投入物箱
			break;
		case Global.SYN_TRANS_ACTION_TYPE_2:
		case Global.SYN_TRANS_ACTION_TYPE_4:
		case Global.SYN_TRANS_ACTION_TYPE_6:
			transStatus = Global.TRANS_ORDER_STATUS_FINISH;		// 已完成订单
			break;
		case Global.SYN_TRANS_ACTION_TYPE_7:
		case Global.SYN_TRANS_ACTION_TYPE_8:
		case Global.SYN_TRANS_ACTION_TYPE_9:
			transStatus = Global.TRANS_ORDER_STATUS_FAILED;		// 失败（无空箱）
			break;
		case Global.SYN_TRANS_ACTION_TYPE_10:
		case Global.SYN_TRANS_ACTION_TYPE_11:
			transStatus = Global.TRANS_ORDER_STATUS_REVOKE;		// 撤回（超期/快件不符合规则）
			break;
		}
		return transStatus;
	}
	

	
	/**
	 * 根据接口中的交易动作类型，转换为平台的交易对应箱子的状态
	 * 1,空闲;2,占用;3,占用超时;4,弃件（占用超期）
	 * 0，不修改状态
	 */
	public int getBoxStatusByActionType(int iTransActionType)
	{
		/*
		 * 1，成功：寄件人寄件；
		 * 3，成功：快递员投件；
		 * 5，成功：寄存人寄件；
		 * 
		 * 2，成功：快递员取件；
		 * 4，成功：收件人收件；
		 * 6，成功：寄存人取件；
		 * 
		 * 7，无空箱：寄件人寄件；
		 * 8，无空箱：快递员投件；
		 * 9，无空箱：寄存；
		 * 
		 * 11，退件：寄存人寄件
		 * 10，退件：快递员投件；
		 */
		int transStatus = 0;
		switch (iTransActionType)
		{
		case Global.SYN_TRANS_ACTION_TYPE_1:
		case Global.SYN_TRANS_ACTION_TYPE_3:
		case Global.SYN_TRANS_ACTION_TYPE_5:
			transStatus = 2;	// 占用
			break;
		case Global.SYN_TRANS_ACTION_TYPE_2:
		case Global.SYN_TRANS_ACTION_TYPE_4:
		case Global.SYN_TRANS_ACTION_TYPE_6:
			transStatus = 1;		// 空闲
			break;
		case Global.SYN_TRANS_ACTION_TYPE_7:
		case Global.SYN_TRANS_ACTION_TYPE_8:
		case Global.SYN_TRANS_ACTION_TYPE_9:
			transStatus = 0;		// 无需修改状态
			break;
		case Global.SYN_TRANS_ACTION_TYPE_10:
		case Global.SYN_TRANS_ACTION_TYPE_11:
			transStatus = 4;		// 弃件
			break;
		}
		return transStatus;
	}

}