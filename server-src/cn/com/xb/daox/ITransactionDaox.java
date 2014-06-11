package cn.com.xb.daox;

import java.util.List;

import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Transaction;
import cn.com.xb.domain.base.Transactionx;
import cn.com.xb.inter.domain.IAppTransactionInfo;
import cn.com.xb.inter.domain.request.GetTransactionListWrapper;
import cn.com.xb.inter.domain.request.RemoteUnpackeInfoWarpper;

public interface ITransactionDaox {

	public Transaction getTransaction(String boxId) throws Exception;
	
	public String getUserIdByTransactionId(String transactionId) throws Exception;
	
	public RemoteUnpackeInfoWarpper getAppOpenBoxInfo(String transId) throws Exception;
	
	public List<IAppTransactionInfo> getAppTransactionInfos(GetTransactionListWrapper trans) throws Exception;
	
	public boolean isExistTransByBoxTransID(String transId) throws Exception;
	
	public String getTransIdByBoxTransID(String boxTransId) throws Exception;
	
	public String getSenderIdByTransId(String transId) throws Exception;

	public String getAddresseeIdByTransId(String transId) throws Exception;

	public void updateTransactionInfo(Transaction transaction) throws Exception;
	
	public List<Transactionx> getTransLists(Transactionx tranx,Page page) throws Exception;
	
	public int getTransItems(Transactionx tranx) throws Exception;
}
