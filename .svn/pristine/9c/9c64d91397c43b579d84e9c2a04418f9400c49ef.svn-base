package cn.com.xb.test;

import cn.com.xb.inter.domain.request.SynchCourierWrapper;
import cn.com.xb.util.XstreamUtil;

public class SynchCourierTest {

	/**
	 * 同步快递员信息
	 */
	
	public static void main(String[] args) {
		SynchCourierWrapper wrapper = new SynchCourierWrapper();
		wrapper.setExePermissionType(0);
		wrapper.setSequenceNumber(1);
		wrapper.setStorageStationId("100001");
		String json = XstreamUtil.javaBean2JETTSON(wrapper, SynchCourierWrapper.class);
		System.out.println(json);
	}
}
