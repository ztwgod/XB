package cn.com.xb.inter.domain.response;

import java.io.Serializable;
import java.util.List;

import cn.com.xb.inter.domain.IAppTransactionInfo;

public class GetTransactionListResult extends BaseResponse implements
		Serializable {

	/**
	 * 同步箱子状态返回结果
	 */
	private static final long serialVersionUID = 1L;
	private List<IAppTransactionInfo> transList;// 交易信息列表

	public List<IAppTransactionInfo> getTransList() {
		return transList;
	}

	public void setTransList(List<IAppTransactionInfo> transList) {
		this.transList = transList;
	}
}
