package cn.com.xb.service.impl;

import cn.com.xb.daox.ILocationDaox;
import cn.com.xb.domain.base.Location;
import cn.com.xb.service.LocationServer;

public class LocationServerImpl implements LocationServer {

	private ILocationDaox locationDaox;
	
	public void setLocationDaox(ILocationDaox locationDaox) {
		this.locationDaox = locationDaox;
	}

	@Override
	public int getMaxCode(String districtId) throws Exception {
		int maxCode = locationDaox.getMaxCode(districtId);
		return maxCode+1;
	}

	@Override
	public boolean isExistLocation(String locationCode, String districtId) throws Exception {
		Location location = locationDaox.gettLocation(locationCode, districtId);
		if(null==location){
			return true;
		}else{
			return false;
		}
	}
}
