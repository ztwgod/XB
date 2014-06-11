package cn.com.xb.test;

import java.util.Date;

import cn.com.xb.inter.domain.request.AppOpenBoxWrapper;
import cn.com.xb.util.DateTools;
import cn.com.xb.util.XstreamUtil;

public class AppOpenBoxTest {

	/**
	 * APP请求开箱
	 * @param args
	 */
	public static void main(String[] args) {
		AppOpenBoxWrapper app = new AppOpenBoxWrapper();
		app.setClientUploadTime(DateTools.formatDateToString(new Date(), DateTools.FORMAT_YYYYMMDD_HHMMSS));
		app.setRandomNum("000001");
		app.setTransId("2");
		app.setUserId("0101");
		String json = XstreamUtil.javaBean2JETTSON(app, AppOpenBoxWrapper.class);
		System.out.println(json);
	}
}
