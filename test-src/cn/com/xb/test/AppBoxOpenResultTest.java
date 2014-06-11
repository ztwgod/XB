package cn.com.xb.test;

import cn.com.xb.inter.domain.response.RemoteUnpackeInfoResult;
import cn.com.xb.util.Global;
import cn.com.xb.util.XstreamUtil;

public class AppBoxOpenResultTest {

	/**
	 * APP开箱结果反馈接口
	 * @param args
	 */
	public static void main(String[] args) {
		RemoteUnpackeInfoResult result = new RemoteUnpackeInfoResult();
		result.setResultStatus(Global.XB_INTER_SUCCESS);
		result.setGuiSequenceNumber("110000111110");
		String json = XstreamUtil.javaBean2JETTSON(result, RemoteUnpackeInfoResult.class);
		System.out.println(json);
	}
}