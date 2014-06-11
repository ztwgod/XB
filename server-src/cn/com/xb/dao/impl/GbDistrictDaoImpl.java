package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IGbDistrictDao;
import  cn.com.xb.domain.base.GbDistrict;

public class GbDistrictDaoImpl implements IGbDistrictDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<GbDistrict> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_GB_DISTRICT";
		 List<GbDistrict> list = new ArrayList<GbDistrict>();
		 List<GbDistrict> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 GbDistrict gbdistrict = fetch(map); 
			 list.add(gbdistrict); 
		 }
		 return list;
	}
	
	public GbDistrict loadGbDistrictBydistrictId(String districtId) throws Exception {
		 GbDistrict gbdistrict = null;
		 String sql ="SELECT * FROM T_GB_DISTRICT WHERE DISTRICT_ID = ? ";
		 Object[] values = new Object[]{districtId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 gbdistrict = fetch(map);
		 return gbdistrict;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_GB_DISTRICT";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String districtId) throws Exception{
		 String sql ="DELETE FROM T_GB_DISTRICT WHERE DISTRICT_ID=?";
		 Object[] values = new Object[] { districtId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(GbDistrict gbdistrict) throws Exception{
		 String sql ="UPDATE T_GB_DISTRICT SET DISTRICT_NAME= ?,DISTRICT_STATUS= ?,PARENT_D_ID= ? WHERE DISTRICT_ID=?";
		 Object[] values = new Object[] {gbdistrict.getDistrictName(),gbdistrict.getDistrictStatus(),gbdistrict.getParentDId(),gbdistrict.getDistrictId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(GbDistrict gbdistrict) throws Exception{
		 String sql ="INSERT INTO T_GB_DISTRICT(DISTRICT_ID,DISTRICT_NAME,DISTRICT_STATUS,PARENT_D_ID) VALUES(?,?,?,?)";
		 Object[] values = new Object[] {gbdistrict.getDistrictId(),gbdistrict.getDistrictName(),gbdistrict.getDistrictStatus(),gbdistrict.getParentDId()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public GbDistrict fetch(Map map) throws Exception{
		GbDistrict gbdistrict = new GbDistrict();		
		gbdistrict.setDistrictId((String)map.get("DISTRICT_ID"));
		gbdistrict.setDistrictName((String)map.get("DISTRICT_NAME"));
		gbdistrict.setDistrictStatus(Integer.parseInt(map.get("DISTRICT_STATUS").toString()));
		gbdistrict.setParentDId((String)map.get("PARENT_D_ID"));
		return gbdistrict;
	}
}
