package cn.com.xb.service;

public interface LocationServer {

	public int getMaxCode(String districtId) throws Exception;
	
	public boolean isExistLocation(String locationCode,String districtId) throws Exception;
}
