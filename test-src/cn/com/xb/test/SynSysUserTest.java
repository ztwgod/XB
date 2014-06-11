package cn.com.xb.test;

import cn.com.xb.inter.domain.request.SynchSysUserWrapper;
import cn.com.xb.util.XstreamUtil;

public class SynSysUserTest {

	private final static String SS_CODE = "31011000010101"; //物箱ID
	
	/**
	 * 更新维护人员信息
	 * @param args
	 */
	public static void main(String[] args) {
		SynchSysUserWrapper syn = new SynchSysUserWrapper();
		syn.setGuiSequenceNumber("EB20000211001");
		syn.setSequenceNumber(0);
		syn.setStorageStationId(SS_CODE);
		String message = XstreamUtil.javaBean2JETTSON(syn, SynchSysUserWrapper.class);
		System.out.println(message);
	}
}
