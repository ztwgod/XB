package cn.com.xb.test;

import cn.com.xb.inter.domain.request.AppLoginWrapper;
import cn.com.xb.util.XstreamUtil;

public class AppLoginTest {

	/**
	 * APP登陆测试
	 * @param args
	 */
	public static void main(String[] args) {
		AppLoginWrapper app = new AppLoginWrapper();
		app.setUserName("test");
		app.setPassword("12345");
		String json = XstreamUtil.javaBean2JETTSON(app, AppLoginWrapper.class);
		System.out.println(json);
	}

}
