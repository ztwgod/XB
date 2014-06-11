package cn.com.xb.service.helper;

import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.inter.domain.request.RemoteUnpackeInfoWarpper;


public interface BoxHelperServer {

	
	/**
	 * 物箱GUI远程开箱
	 * @throws Exception
	 */
	public void openBox(ResponseText resText) throws Exception;
	
	
}
