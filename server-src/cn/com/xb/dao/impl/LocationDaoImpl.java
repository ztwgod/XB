package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.ILocationDao;
import  cn.com.xb.domain.base.Location;

public class LocationDaoImpl implements ILocationDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<Location> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_LOCATION";
		 List<Location> list = new ArrayList<Location>();
		 List<Location> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 Location location = fetch(map); 
			 list.add(location); 
		 }
		 return list;
	}
	
	public Location loadLocationBylocationId(String locationId) throws Exception {
		 Location location = null;
		 String sql ="SELECT * FROM T_LOCATION WHERE LOCATION_ID = ? ";
		 Object[] values = new Object[]{locationId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 location = fetch(map);
		 return location;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_LOCATION";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String locationId) throws Exception{
		 String sql ="DELETE FROM T_LOCATION WHERE LOCATION_ID=?";
		 Object[] values = new Object[] { locationId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(Location location) throws Exception{
		 String sql ="UPDATE T_LOCATION SET LOCATION_CODE= ?,LOCATION_ABB= ?,ADDRESS= ?,DISTRICT_ID= ? WHERE LOCATION_ID=?";
		 Object[] values = new Object[] {location.getLocationCode(),location.getLocationAbb(),location.getAddress(),location.getDistrictId(),location.getLocationId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(Location location) throws Exception{
		 String sql ="INSERT INTO T_LOCATION(LOCATION_ID,LOCATION_CODE,LOCATION_ABB,ADDRESS,DISTRICT_ID) VALUES(?,?,?,?,?)";
		 Object[] values = new Object[] {location.getLocationId(),location.getLocationCode(),location.getLocationAbb(),location.getAddress(),location.getDistrictId()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public Location fetch(Map map) throws Exception{
		Location location = new Location();		
		location.setLocationId((String)map.get("LOCATION_ID"));
		location.setLocationCode((String)map.get("LOCATION_CODE"));
		location.setLocationAbb((String)map.get("LOCATION_ABB"));
		location.setAddress((String)map.get("ADDRESS"));
		location.setDistrictId((String)map.get("DISTRICT_ID"));
		return location;
	}
}
