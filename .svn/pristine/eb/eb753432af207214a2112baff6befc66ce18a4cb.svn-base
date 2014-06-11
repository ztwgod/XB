package cn.com.xb.inter.service.impl;

import cn.com.xb.domain.base.User;
import cn.com.xb.inter.domain.request.AppLoginWrapper;
import cn.com.xb.inter.domain.response.AppLoginResult;
import cn.com.xb.inter.service.XBProcessServer;
import cn.com.xb.service.UserService;
import cn.com.xb.util.Global;
import cn.com.xb.util.XstreamUtil;

public class XBProcessAppLoginServerImpl implements XBProcessServer {

	/**
	 * APP登陆
	 */
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String process(String message) throws Exception {
		AppLoginWrapper appLoginWrapper = null;
		AppLoginResult result = new AppLoginResult();
		try {
			appLoginWrapper = (AppLoginWrapper) XstreamUtil.JETTSON2JavaBean(message, AppLoginWrapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			result.setErrorMsg("请求数据格式错误，"+e.getMessage());
			result.setResultStatus(Global.XB_INTER_FAIL);
			String json = XstreamUtil.javaBean2JETTSON(result, AppLoginResult.class);
			return json;
		}
		
		User user = new User();
		user.setUserAccount(appLoginWrapper.getUserName());
		user.setPassword(appLoginWrapper.getPassword());
		User _user = userService.portalLogin(user);			
		String loginMsg = userService.verifyUserLogin(_user);
		if(loginMsg.equals("OK")){
			result.setResultStatus(Global.XB_INTER_SUCCESS);
			result.setUserId(_user.getUserId());
			result.setUserName(_user.getUserName());
			String json = XstreamUtil.javaBean2JETTSON(result, AppLoginResult.class);
			return json;
		}else{
			result.setErrorMsg(loginMsg);
			result.setResultStatus(Global.XB_INTER_FAIL);
			String json = XstreamUtil.javaBean2JETTSON(result, AppLoginResult.class);
			return json;
		}
	}
}
