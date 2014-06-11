package cn.com.xb.inter.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.xb.dao.ITransactionDao;
import cn.com.xb.daox.IBoxInfoDaox;
import cn.com.xb.daox.IStoragestationDaox;
import cn.com.xb.daox.IUserDaox;
import cn.com.xb.domain.base.Transaction;
import cn.com.xb.inter.service.XBProcessServer;

public class XBProcessWeChatGetOrderServerImpl implements XBProcessServer {
	private ITransactionDao transactionDao;
	private IUserDaox userDaox;
	private IBoxInfoDaox boxInfoDaox;
	private IStoragestationDaox storagestationDaox;

	public void setStoragestationDaox(IStoragestationDaox storagestationDaox) {
		this.storagestationDaox = storagestationDaox;
	}

	public void setBoxInfoDaox(IBoxInfoDaox boxInfoDaox) {
		this.boxInfoDaox = boxInfoDaox;
	}

	public void setUserDaox(IUserDaox userDaox) {
		this.userDaox = userDaox;
	}

	public void setTransactionDao(ITransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	public String process(String message) throws Exception {
		// 得到参数
		String[] msg = message.split(" ");
		String res = "";
			String userId = userDaox.getUserIdByMobileNum(msg[0]);
			// 判断寄件，收件，寄存，开箱查询
			if (userId==null||userId.equals("")) {
				res="该手机尚未注册!请确认手机号输入正确!";
				return res;
			}
			List<Transaction> result = new ArrayList();
			List<Transaction> list = new ArrayList();
			if (msg[1].equals("1") || msg[1].equals("3")) {
				list = transactionDao.loadTransactionByUserId(userId);
				result = getOrder1(list, Integer.valueOf(msg[1]));
				if (result==null||result.size()==0) {
					res="该手机没有对应交易记录!";
					return res;
				}
			} else {
				list = transactionDao.loadTransactionByAddressId(userId);
				result = getOrder2(list, 2);
				if (result==null||result.size()==0) {
					res="该手机没有对应交易记录!";
					return res;
				}
			}
			res = res + result.size();
			for (int i = 0; i < result.size(); i++) {
				String ssId = boxInfoDaox.getSSIDByBoxId(result.get(i)
						.getBoxId());
				String boxIndex = boxInfoDaox.getBoxIndexByBoxId(result.get(i)
						.getBoxId());
				String address = storagestationDaox.getAddressByssId(ssId);
				res = res + " " + address + " " + boxIndex + " "
						+ result.get(i).getTransId() + " "
						+ result.get(i).getLastModifyTime() + " "
						+ result.get(i).getTransStatus();
				System.out.print(result.get(i).getLastModifyTime());
			}
		return res;
	}

	private List<Transaction> getOrder1(List<Transaction> transaction, int type) {
		List<Transaction> result = new ArrayList();
		for (int i = 0; i < transaction.size(); i++) {
			if (transaction.get(i).getTransType() == type) {
				result.add(transaction.get(i));
			}
		}
		return result;
	}

	private List<Transaction> getOrder2(List<Transaction> transaction, int type) {
		List<Transaction> result = new ArrayList();
		for (int i = 0; i < transaction.size(); i++) {
			if (transaction.get(i).getTransType() == 2
					|| transaction.get(i).getTransType() == 3) {
				result.add(transaction.get(i));
			}
		}
		return result;
	}
}
