package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.StoragestationGroupDaoImpl;
import cn.com.xb.daox.IStoragestationGroupDaox;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.StoragestationGroupx;
import cn.com.xb.util.StringUtil;

public class StoragestationGroupDaoxImpl extends StoragestationGroupDaoImpl implements IStoragestationGroupDaox {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<StoragestationGroupx> loadList(StoragestationGroupx storGroup,Page page) throws Exception {
		StringBuilder sql = new StringBuilder(" SELECT A.GROUP_ID,A.GROUP_ABB,A.AVAILABLE_BOX_NUM,A.GROUP_CODE,A.GROUP_DESC,A.SEAT_DESC,B.DISTRICT_ID,A.LOCATION_ID " +
				" FROM T_STORAGESTATION_GROUP A,T_LOCATION B WHERE A.LOCATION_ID=B.LOCATION_ID ");
		List<Object> params = new ArrayList<Object>();
		if(!"".equals(storGroup.getGroupCode())){
			sql.append(" AND A.GROUP_ABB LIKE '%").append(storGroup.getGroupAbb()).append("%'");
		}
		if(""!=storGroup.getDistrictId()){
			sql.append(" AND B.DISTRICT_ID = ? ");
			params.add(storGroup.getDistrictId());
		}		
		sql.append(" LIMIT ?,?");
		params.add(page.getStartItems());
		params.add(page.getPageSize());
		
		List<StoragestationGroupx> list = new ArrayList<StoragestationGroupx>();
		List<StoragestationGroupx> mapList = jdbcTemplate.queryForList(sql.toString(),params.toArray());
		Iterator it = mapList.iterator();
		while (it.hasNext()) {
			Map map = (Map) it.next();
			StoragestationGroupx _storGroup = new StoragestationGroupx();
			_storGroup.setGroupId((String)map.get("GROUP_ID"));
			_storGroup.setGroupAbb((String)map.get("GROUP_ABB"));
			_storGroup.setGroupDesc((String)map.get("GROUP_DESC"));
			_storGroup.setAvailableBoxNum(Integer.parseInt(map.get("AVAILABLE_BOX_NUM").toString()));
			_storGroup.setSeatDesc((String)map.get("SEAT_DESC"));
			_storGroup.setDistrictId((String)map.get("DISTRICT_ID"));
			_storGroup.setGroupCode((String)map.get("GROUP_CODE"));
			_storGroup.setLocationId((String)map.get("LOCATION_ID"));
			list.add(_storGroup);
		}
		return list;
	}
	
	public int getItems(StoragestationGroupx storGroup) throws Exception {
		StringBuilder sql = new StringBuilder(" SELECT COUNT(*) FROM T_STORAGESTATION_GROUP A,T_LOCATION B WHERE A.LOCATION_ID=B.LOCATION_ID ");
		List<Object> params = new ArrayList<Object>();
		if(!"".equals(storGroup.getGroupCode())){
			sql.append(" AND A.GROUP_ABB LIKE '%").append(storGroup.getGroupCode()).append("%'");
		}
		if(""!=storGroup.getDistrictId()){
			sql.append(" AND B.DISTRICT_ID = ? ");
			params.add(storGroup.getDistrictId());
		}			
		return jdbcTemplate.queryForInt(sql.toString(),params.toArray());
	}


	public StoragestationGroupx loadStoragestationGroupxByGroupId(String groupId) throws Exception {
		StringBuilder sql = new StringBuilder("SELECT A.GROUP_ID,A.GROUP_ABB,A.AVAILABLE_BOX_NUM,A.GROUP_CODE,A.GROUP_DESC,A.SEAT_DESC,B.DISTRICT_ID ");
		sql.append(" ,A.LATITUDE,A.LONGITUDE,B.LOCATION_ABB ");
		sql.append("  FROM T_STORAGESTATION_GROUP A,T_LOCATION B WHERE A.LOCATION_ID=B.LOCATION_ID AND A.GROUP_ID = ? ");
		String[] values = new String[]{groupId};
		Map map = null;
		try{
			 map = jdbcTemplate.queryForMap(sql.toString(), values);
		} catch (DataAccessException e) {
			 return null;
		}
		 StoragestationGroupx _storGroup = new StoragestationGroupx();
		_storGroup.setGroupId((String)map.get("GROUP_ID"));
		_storGroup.setGroupAbb((String)map.get("GROUP_ABB"));
		_storGroup.setGroupDesc((String)map.get("GROUP_DESC"));
		_storGroup.setAvailableBoxNum(Integer.parseInt(map.get("AVAILABLE_BOX_NUM").toString()));
		_storGroup.setSeatDesc((String)map.get("SEAT_DESC"));
		_storGroup.setDistrictId((String)map.get("DISTRICT_ID"));
		_storGroup.setGroupCode((String)map.get("GROUP_CODE"));
		//_storGroup.setPoiId((String)map.get("POI_ID"));
		_storGroup.setLocationApp(StringUtil.formatStringTrimToNull(map.get("LOCATION_ABB")));
		_storGroup.setLatitude(Double.parseDouble(map.get("LATITUDE").toString()));
		_storGroup.setLongitude(Double.parseDouble(map.get("LONGITUDE").toString()));
		return _storGroup;
	}


	public List<StoragestationGroupx> getStoragestationGroup(String districtId)
			throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.GROUP_ABB,A.GROUP_ID FROM T_STORAGESTATION_GROUP A,T_LOCATION B WHERE A.LOCATION_ID = B.LOCATION_ID  ");
		sql.append(" AND (B.DISTRICT_ID IN ( SELECT D.DISTRICT_ID FROM T_DISTRICT_RELA D WHERE D.PARENT_D_ID = ?) OR B.DISTRICT_ID = ?)");
		
		Object[] values = new Object[]{districtId,districtId};
		List<StoragestationGroupx> list = new ArrayList<StoragestationGroupx>();
		List<StoragestationGroupx> mapList = jdbcTemplate.queryForList(sql.toString(),values);
		Iterator it = mapList.iterator();
		while (it.hasNext()) {
			Map map = (Map) it.next();
			StoragestationGroupx _storGroup = new StoragestationGroupx();
			_storGroup.setGroupId((String)map.get("GROUP_ID"));
			_storGroup.setGroupAbb((String)map.get("GROUP_ABB"));
			list.add(_storGroup);
		}
		return list;
	}


	@Override
	public String getLocationCodeByGroupId(String groupId) throws Exception {
		String sql = "SELECT A.GROUP_CODE FROM T_STORAGESTATION_GROUP A WHERE A.GROUP_ID = ? ";
		Map map = null;
		try {
			map = jdbcTemplate.queryForMap(sql,new String[]{groupId});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		Object obj = map.get("GROUP_CODE");
		String groupCode = StringUtil.formatStringTrimToNull(obj);
		return groupCode;
	}	
}
