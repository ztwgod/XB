package cn.com.xb.daox.impl;

import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.LocationDaoImpl;
import cn.com.xb.daox.ILocationDaox;
import cn.com.xb.domain.base.Location;
import cn.com.xb.util.StringUtil;

public class LocationDaoxImpl extends LocationDaoImpl implements ILocationDaox {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int getMaxCode(String districtId) throws Exception {
		
		String sql = "SELECT MAX(A.LOCATION_CODE) CODE FROM T_LOCATION A WHERE A.DISTRICT_ID = ? ";
		Map map = null;
		try {
			map = jdbcTemplate.queryForMap(sql,new String[]{districtId});
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object code = map.get("CODE");
		int _code = StringUtil.formatStringToInteger(code, 0);
		return _code;
	}

	@Override
	public Location gettLocation(String locationCode, String districtId) throws Exception {
		Location location = null;
		String sql ="SELECT * FROM T_LOCATION WHERE LOCATION_CODE = ? AND DISTRICT_ID = ? ";
		Object[] values = new Object[]{locationCode,districtId};
		Map map = null;
		try{ 
			map = jdbcTemplate.queryForMap(sql, values);
		} catch (DataAccessException e) {
			return null;
		}
		location = super.fetch(map);
		return location;
	}
}
