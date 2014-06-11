package cn.com.xb.test;

import cn.com.xb.inter.domain.request.GetTransactionListWrapper;
import cn.com.xb.util.XstreamUtil;

public class AppTransTest {

	/**
	 * APP获取交易列表
	 * @param args
	 */
	public static void main(String[] args) {
		GetTransactionListWrapper trans = new GetTransactionListWrapper();
		trans.setStorageStationId("1430df3e15282701");
		trans.setUserId("141b5cad90528491");
		trans.setTransType(1);
		trans.setTransStatus(2);
		String jsonMsg = XstreamUtil.javaBean2JETTSON(trans, GetTransactionListWrapper.class);
		System.out.println(jsonMsg);
	}
}
