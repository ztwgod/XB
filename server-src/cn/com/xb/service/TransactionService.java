package cn.com.xb.service;

import java.util.List;

import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Transaction;
import cn.com.xb.domain.base.Transactionx;
import cn.com.xb.domain.displayWrapper.BoxStatusWrapper;
import cn.com.xb.domain.parameterWrapper.GetBoxStatusListParam;
import cn.com.xb.inter.domain.request.TransactionWrapper;

public interface TransactionService {

	public Transaction getTransaction(String boxId) throws Exception;
	
	public  List<Transaction> loadTransactionByUserId(String userId) throws Exception;
	/**
	 * 同步交易信息
	 * @param tw
	 * @throws Exception
	 */
	public void syncTransactionInfo(TransactionWrapper tw) throws Exception;
	
	/**
	 * 交易信息统计列表 
	 * @param tranx
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Transactionx> getTransLists(Transactionx tranx,Page page) throws Exception;
	
	
	/**
	 * 总记录数
	 * @param tranx
	 * @return
	 * @throws Exception
	 */
	public int getTransItems(Transactionx tranx) throws Exception;
}
