package cn.com.xb.service.impl;

import java.util.List;

import cn.com.xb.dao.IGbDistrictDao;
import cn.com.xb.daox.IGbDistrictDaox;
import cn.com.xb.domain.base.GbDistrict;
import cn.com.xb.service.GbDistrictService;

public class GbDistrictServiceImpl implements GbDistrictService
{
	private IGbDistrictDao gbDistrictDao;
	private IGbDistrictDaox gbDistrictDaox;

	public void setGbDistrictDao(IGbDistrictDao gbDistrictDao)
	{
		this.gbDistrictDao = gbDistrictDao;
	}
	public void setGbDistrictDaox(IGbDistrictDaox gbDistrictDaox)
	{
		this.gbDistrictDaox = gbDistrictDaox;
	}


	@Override
	public List<GbDistrict> getGBDistrictList(String parentGbId) throws Exception
	{
		return gbDistrictDaox.getGbDistrictListByParentId(parentGbId);
	}
	@Override
	public String getGBDistrictFullName(String districtId) throws Exception
	{
		return gbDistrictDaox.getGBDistrictFullName(districtId);
	}

}
