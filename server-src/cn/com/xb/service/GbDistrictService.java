package cn.com.xb.service;

import java.util.List;

import cn.com.xb.domain.base.GbDistrict;

public interface GbDistrictService
{
	
	/**
	 * 获取区域列表
	 * @param parentGbId
	 * @return
	 * @throws Exception
	 */
	public List<GbDistrict> getGBDistrictList(String parentGbId) throws Exception;
	
	
	/**
	 * 根据区域ID查询全称
	 * @param districtId
	 * @return
	 * @throws Exception
	 */
	public String getGBDistrictFullName(String districtId) throws Exception;
}
