package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IStoragestationGroupDao;
import  cn.com.xb.domain.base.StoragestationGroup;

public class StoragestationGroupDaoImpl implements IStoragestationGroupDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<StoragestationGroup> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_STORAGESTATION_GROUP";
		 List<StoragestationGroup> list = new ArrayList<StoragestationGroup>();
		 List<StoragestationGroup> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 StoragestationGroup storagestationgroup = fetch(map); 
			 list.add(storagestationgroup); 
		 }
		 return list;
	}
	
	public StoragestationGroup loadStoragestationGroupBygroupId(String groupId) throws Exception {
		 StoragestationGroup storagestationgroup = null;
		 String sql ="SELECT * FROM T_STORAGESTATION_GROUP WHERE GROUP_ID = ? ";
		 Object[] values = new Object[]{groupId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 storagestationgroup = fetch(map);
		 return storagestationgroup;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_STORAGESTATION_GROUP";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String groupId) throws Exception{
		 String sql ="DELETE FROM T_STORAGESTATION_GROUP WHERE GROUP_ID=?";
		 Object[] values = new Object[] { groupId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(StoragestationGroup storagestationgroup) throws Exception{
		 String sql ="UPDATE T_STORAGESTATION_GROUP SET GROUP_ABB= ?,GROUP_CODE= ?,GROUP_DESC= ?,LOCATION_ID= ?,AVAILABLE_BOX_NUM= ?,SEAT_DESC= ?,LONGITUDE= ?,LATITUDE= ? WHERE GROUP_ID=?";
		 Object[] values = new Object[] {storagestationgroup.getGroupAbb(),storagestationgroup.getGroupCode(),storagestationgroup.getGroupDesc(),storagestationgroup.getLocationId(),storagestationgroup.getAvailableBoxNum(),storagestationgroup.getSeatDesc(),storagestationgroup.getLongitude(),storagestationgroup.getLatitude(),storagestationgroup.getGroupId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(StoragestationGroup storagestationgroup) throws Exception{
		 String sql ="INSERT INTO T_STORAGESTATION_GROUP(GROUP_ID,GROUP_ABB,GROUP_CODE,GROUP_DESC,LOCATION_ID,AVAILABLE_BOX_NUM,SEAT_DESC,LONGITUDE,LATITUDE) VALUES(?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {storagestationgroup.getGroupId(),storagestationgroup.getGroupAbb(),storagestationgroup.getGroupCode(),storagestationgroup.getGroupDesc(),storagestationgroup.getLocationId(),storagestationgroup.getAvailableBoxNum(),storagestationgroup.getSeatDesc(),storagestationgroup.getLongitude(),storagestationgroup.getLatitude()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public StoragestationGroup fetch(Map map) throws Exception{
		StoragestationGroup storagestationgroup = new StoragestationGroup();		
		storagestationgroup.setGroupId((String)map.get("GROUP_ID"));
		storagestationgroup.setGroupAbb((String)map.get("GROUP_ABB"));
		storagestationgroup.setGroupCode((String)map.get("GROUP_CODE"));
		storagestationgroup.setGroupDesc((String)map.get("GROUP_DESC"));
		storagestationgroup.setLocationId((String)map.get("LOCATION_ID"));
		storagestationgroup.setAvailableBoxNum(Integer.parseInt(map.get("AVAILABLE_BOX_NUM").toString()));
		storagestationgroup.setSeatDesc((String)map.get("SEAT_DESC"));
		storagestationgroup.setLongitude(Double.parseDouble(map.get("LONGITUDE").toString()));
		storagestationgroup.setLatitude(Double.parseDouble(map.get("LATITUDE").toString()));
		return storagestationgroup;
	}
}
