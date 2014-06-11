package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IDistrictRelaDao;
import  cn.com.xb.domain.base.DistrictRela;

public class DistrictRelaDaoImpl implements IDistrictRelaDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<DistrictRela> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_DISTRICT_RELA";
		 List<DistrictRela> list = new ArrayList<DistrictRela>();
		 List<DistrictRela> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 DistrictRela districtrela = fetch(map); 
			 list.add(districtrela); 
		 }
		 return list;
	}
	
	public DistrictRela loadDistrictRelaBydistrictId(String districtId) throws Exception {
		 DistrictRela districtrela = null;
		 String sql ="SELECT * FROM T_DISTRICT_RELA WHERE DISTRICT_ID = ? ";
		 Object[] values = new Object[]{districtId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 districtrela = fetch(map);
		 return districtrela;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_DISTRICT_RELA";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String districtId) throws Exception{
		 String sql ="DELETE FROM T_DISTRICT_RELA WHERE DISTRICT_ID=?";
		 Object[] values = new Object[] { districtId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(DistrictRela districtrela) throws Exception{
		 String sql ="UPDATE T_DISTRICT_RELA SET PARENT_D_ID= ?,DISTRICT_LEVEL= ?,PARENT_D_LEVEL= ? WHERE DISTRICT_ID=?";
		 Object[] values = new Object[] {districtrela.getParentDId(),districtrela.getDistrictLevel(),districtrela.getParentDLevel(),districtrela.getDistrictId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(DistrictRela districtrela) throws Exception{
		 String sql ="INSERT INTO T_DISTRICT_RELA(DISTRICT_ID,PARENT_D_ID,DISTRICT_LEVEL,PARENT_D_LEVEL) VALUES(?,?,?,?)";
		 Object[] values = new Object[] {districtrela.getDistrictId(),districtrela.getParentDId(),districtrela.getDistrictLevel(),districtrela.getParentDLevel()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public DistrictRela fetch(Map map) throws Exception{
		DistrictRela districtrela = new DistrictRela();		
		districtrela.setDistrictId((String)map.get("DISTRICT_ID"));
		districtrela.setParentDId((String)map.get("PARENT_D_ID"));
		districtrela.setDistrictLevel(Integer.parseInt(map.get("DISTRICT_LEVEL").toString()));
		districtrela.setParentDLevel(Integer.parseInt(map.get("PARENT_D_LEVEL").toString()));
		return districtrela;
	}
}
