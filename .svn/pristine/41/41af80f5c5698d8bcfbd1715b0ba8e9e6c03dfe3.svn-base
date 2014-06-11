package cn.com.xb.service.helper.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.inter.domain.request.RemoteUnpackeInfoWarpper;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.service.helper.BoxHelperServer;

public class BoxHelperServerImpl implements BoxHelperServer {

	private static Log log = LogFactory.getLog(BoxHelperServerImpl.class);
	
	private StoragestationaService storagestationaService;
	
	public void setStoragestationaService(StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}


	public void openBox(ResponseText resText) throws Exception{
		Storagestationx storagestationx = storagestationaService.loadStoragestationxBySSId(resText.getSsId(), resText.getSsCode());
		
		
	}
}