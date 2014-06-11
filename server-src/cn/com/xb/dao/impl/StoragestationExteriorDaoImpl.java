package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IStoragestationExteriorDao;
import  cn.com.xb.domain.base.StoragestationExterior;

public class StoragestationExteriorDaoImpl implements IStoragestationExteriorDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<StoragestationExterior> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_STORAGESTATION_EXTERIOR";
		 List<StoragestationExterior> list = new ArrayList<StoragestationExterior>();
		 List<StoragestationExterior> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 StoragestationExterior storagestationexterior = fetch(map); 
			 list.add(storagestationexterior); 
		 }
		 return list;
	}
	
	public StoragestationExterior loadStoragestationExteriorByexteriorId(String exteriorId) throws Exception {
		 StoragestationExterior storagestationexterior = null;
		 String sql ="SELECT * FROM T_STORAGESTATION_EXTERIOR WHERE EXTERIOR_ID = ? ";
		 Object[] values = new Object[]{exteriorId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 storagestationexterior = fetch(map);
		 return storagestationexterior;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_STORAGESTATION_EXTERIOR";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String exteriorId) throws Exception{
		 String sql ="DELETE FROM T_STORAGESTATION_EXTERIOR WHERE EXTERIOR_ID=?";
		 Object[] values = new Object[] { exteriorId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(StoragestationExterior storagestationexterior) throws Exception{
		 String sql ="UPDATE T_STORAGESTATION_EXTERIOR SET EXTERIOR_NAME= ?,EXTERIOR_CODE= ?,EXTERIOR_TYPE= ?,EXTERIOR_DESC= ? WHERE EXTERIOR_ID=?";
		 Object[] values = new Object[] {storagestationexterior.getExteriorName(),storagestationexterior.getExteriorCode(),storagestationexterior.getExteriorType(),storagestationexterior.getExteriorDesc(),storagestationexterior.getExteriorId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(StoragestationExterior storagestationexterior) throws Exception{
		 String sql ="INSERT INTO T_STORAGESTATION_EXTERIOR(EXTERIOR_ID,EXTERIOR_NAME,EXTERIOR_CODE,EXTERIOR_TYPE,EXTERIOR_DESC) VALUES(?,?,?,?,?)";
		 Object[] values = new Object[] {storagestationexterior.getExteriorId(),storagestationexterior.getExteriorName(),storagestationexterior.getExteriorCode(),storagestationexterior.getExteriorType(),storagestationexterior.getExteriorDesc()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public StoragestationExterior fetch(Map map) throws Exception{
		StoragestationExterior storagestationexterior = new StoragestationExterior();		
		storagestationexterior.setExteriorId((String)map.get("EXTERIOR_ID"));
		storagestationexterior.setExteriorName((String)map.get("EXTERIOR_NAME"));
		storagestationexterior.setExteriorCode((String)map.get("EXTERIOR_CODE"));
		storagestationexterior.setExteriorType(Integer.parseInt(map.get("EXTERIOR_TYPE").toString()));
		storagestationexterior.setExteriorDesc((String)map.get("EXTERIOR_DESC"));
		return storagestationexterior;
	}
}
