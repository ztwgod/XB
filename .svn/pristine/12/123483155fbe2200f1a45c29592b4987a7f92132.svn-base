package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.ICourierGroupDao;
import  cn.com.xb.domain.base.CourierGroup;

public class CourierGroupDaoImpl implements ICourierGroupDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<CourierGroup> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_COURIER_GROUP";
		 List<CourierGroup> list = new ArrayList<CourierGroup>();
		 List<CourierGroup> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 CourierGroup couriergroup = fetch(map); 
			 list.add(couriergroup); 
		 }
		 return list;
	}
	
	public CourierGroup loadCourierGroupBygroupId(String groupId) throws Exception {
		 CourierGroup couriergroup = null;
		 String sql ="SELECT * FROM T_COURIER_GROUP WHERE GROUP_ID = ? ";
		 Object[] values = new Object[]{groupId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 couriergroup = fetch(map);
		 return couriergroup;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_COURIER_GROUP";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String groupId) throws Exception{
		 String sql ="DELETE FROM T_COURIER_GROUP WHERE GROUP_ID=?";
		 Object[] values = new Object[] { groupId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(CourierGroup couriergroup) throws Exception{
		 String sql ="UPDATE T_COURIER_GROUP SET GROUP_NAME= ?,EXCO_ID= ?,DISTRICT_ID= ?,PICK_CONTACTOR_M= ? WHERE GROUP_ID=?";
		 Object[] values = new Object[] {couriergroup.getGroupName(),couriergroup.getExcoId(),couriergroup.getDistrictId(),couriergroup.getPickContactorM(),couriergroup.getGroupId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(CourierGroup couriergroup) throws Exception{
		 String sql ="INSERT INTO T_COURIER_GROUP(GROUP_ID,GROUP_NAME,EXCO_ID,DISTRICT_ID,PICK_CONTACTOR_M) VALUES(?,?,?,?,?)";
		 Object[] values = new Object[] {couriergroup.getGroupId(),couriergroup.getGroupName(),couriergroup.getExcoId(),couriergroup.getDistrictId(),couriergroup.getPickContactorM()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public CourierGroup fetch(Map map) throws Exception{
		CourierGroup couriergroup = new CourierGroup();		
		couriergroup.setGroupId((String)map.get("GROUP_ID"));
		couriergroup.setGroupName((String)map.get("GROUP_NAME"));
		couriergroup.setExcoId((String)map.get("EXCO_ID"));
		couriergroup.setDistrictId((String)map.get("DISTRICT_ID"));
		couriergroup.setPickContactorM((String)map.get("PICK_CONTACTOR_M"));
		return couriergroup;
	}
}
