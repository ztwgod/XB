package cn.com.xb.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import cn.com.xb.dao.IAuthCardDao;
import cn.com.xb.dao.IIssuedAgencyDao;
import cn.com.xb.dao.IOperationLogDao;
import cn.com.xb.daox.IAuthCardDaox;
import cn.com.xb.domain.base.AuthCard;
import cn.com.xb.domain.base.IssuedAgency;
import cn.com.xb.domain.base.ListCard;
import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.domain.base.Page;
import cn.com.xb.service.AuthCardService;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.StringUtil;

public class AuthCardServiceImpl implements AuthCardService {

	private IAuthCardDaox authCardDaox;
	private IAuthCardDao authCardDao;
	private IIssuedAgencyDao issuedAgencyDao;
	private IOperationLogDao operationLogDao;
	

	public void setOperationLogDao(IOperationLogDao operationLogDao)
	{
		this.operationLogDao = operationLogDao;
	}
	public void setIssuedAgencyDao(IIssuedAgencyDao issuedAgencyDao) {
		this.issuedAgencyDao = issuedAgencyDao;
	}

	public void setAuthCardDao(IAuthCardDao authCardDao) {
		this.authCardDao = authCardDao;
	}

	public void setAuthCardDaox(IAuthCardDaox authCardDaox) {
		this.authCardDaox = authCardDaox;
	}

	public int getItems(ListCard card) throws Exception {
		return authCardDaox.getItems(card);
	}

	public List<ListCard> loadListCard(ListCard card, Page page)
			throws Exception {
		return authCardDaox.loadListCard(card, page);
	}
	
	public void insertCard(String opUserId, AuthCard authcard) throws Exception{
		authCardDao.insert(authcard);
		
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(5);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("添加并绑定卡片信息，相关参数："+StringUtil.getOptionContent(new Object[]{authcard}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}

	public AuthCard getAuthCardByCardId(String cardId) throws Exception {
		
		return authCardDao.loadAuthCardBycardId(cardId);
	}

	public void updateCard(String opUserId, AuthCard authcard) throws Exception {
		
		authCardDao.update(authcard);
		
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(6);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("修改绑定卡片信息，相关参数："+StringUtil.getOptionContent(new Object[]{authcard}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}
	
	public List<IssuedAgency> loadAllIssuedAgency() throws Exception{
		
		return issuedAgencyDao.loadAll();
	}
	

}
