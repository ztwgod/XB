package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.daox.IGbDistrictDaox;
import cn.com.xb.domain.base.GbDistrict;
import cn.com.xb.util.StringUtil;

public class GbDistrictDaoxImpl implements IGbDistrictDaox
{
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<GbDistrict> getGbDistrictListByParentId(String parentDId) throws Exception
	{
		List<GbDistrict> gds = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTRICT_ID, DISTRICT_NAME, DISTRICT_STATUS, PARENT_D_ID FROM T_GB_DISTRICT WHERE PARENT_D_ID = ? AND DISTRICT_STATUS = ?");
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{parentDId, 1});
			
			if(null != list && list.size() != 0)
			{
				gds = new ArrayList<GbDistrict>();
				
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					Map map = (Map) it.next();
					
					GbDistrict gd = new GbDistrict();
					gd.setDistrictId(StringUtil.formatStringTrimToNull(map.get("DISTRICT_ID")));
					gd.setDistrictName(StringUtil.formatStringTrimToNull(map.get("DISTRICT_NAME")));
					gd.setParentDId(StringUtil.formatStringTrimToNull(map.get("PARENT_D_ID")));
					gd.setDistrictStatus(StringUtil.formatStringToInteger(map.get("DISTRICT_STATUS"), 1));
					
					gds.add(gd);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return gds;
	}


	@Override
	public String getGBDistrictFullName(String districtId) throws Exception
	{
		String districtName = "";
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DR.DISTRICT_ID, GD1.DISTRICT_NAME, DR.DISTRICT_LEVEL, DR.PARENT_D_ID, GD2.DISTRICT_NAME PARENT_NAME, DR.PARENT_D_LEVEL");
		sql.append(" FROM T_GB_DISTRICT GD1,T_DISTRICT_RELA DR LEFT JOIN T_GB_DISTRICT GD2 ON DR.PARENT_D_ID = GD2.DISTRICT_ID");
		sql.append(" WHERE DR.DISTRICT_ID = GD1.DISTRICT_ID AND DR.DISTRICT_ID = ?");
		sql.append(" ORDER BY DR.PARENT_D_LEVEL");
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{districtId});
			
			if(null != list && list.size() != 0)
			{
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					Map map = (Map) it.next();

					String districtNameT = StringUtil.formatStringTrim(map.get("DISTRICT_NAME"));
					int districtLevel = StringUtil.formatStringToInteger(map.get("DISTRICT_LEVEL"), 0);
					int parentLevel = StringUtil.formatStringToInteger(map.get("PARENT_D_LEVEL"), 0);
					String parentName = StringUtil.formatStringTrimToNull(map.get("PARENT_NAME"));
					
					if(districtLevel - parentLevel > 1)
					{
						districtName = StringUtil.formatStringTrim(districtName) + " " + StringUtil.formatStringTrim(parentName);
					}
					if(districtLevel - parentLevel == 1)
					{
						districtName = StringUtil.formatStringTrim(districtName) + " " + StringUtil.formatStringTrim(parentName) + " " + StringUtil.formatStringTrim(districtNameT);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return districtName;
	}

	
	
}
