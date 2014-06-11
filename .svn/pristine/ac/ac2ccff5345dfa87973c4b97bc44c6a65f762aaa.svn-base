package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.ISsTypeExteriorDao;
import  cn.com.xb.domain.base.SsTypeExterior;

public class SsTypeExteriorDaoImpl implements ISsTypeExteriorDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<SsTypeExterior> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_SS_TYPE_EXTERIOR";
		 List<SsTypeExterior> list = new ArrayList<SsTypeExterior>();
		 List<SsTypeExterior> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 SsTypeExterior sstypeexterior = fetch(map); 
			 list.add(sstypeexterior); 
		 }
		 return list;
	}
	
	public SsTypeExterior loadSsTypeExteriorByexteriorId(String exteriorId) throws Exception {
		 SsTypeExterior sstypeexterior = null;
		 String sql ="SELECT * FROM T_SS_TYPE_EXTERIOR WHERE EXTERIOR_ID = ? ";
		 Object[] values = new Object[]{exteriorId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 sstypeexterior = fetch(map);
		 return sstypeexterior;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_SS_TYPE_EXTERIOR";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String exteriorId) throws Exception{
		 String sql ="DELETE FROM T_SS_TYPE_EXTERIOR WHERE EXTERIOR_ID=?";
		 Object[] values = new Object[] { exteriorId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(SsTypeExterior sstypeexterior) throws Exception{
		 String sql ="UPDATE T_SS_TYPE_EXTERIOR SET TYPE_ID= ? WHERE EXTERIOR_ID=?";
		 Object[] values = new Object[] {sstypeexterior.getTypeId(),sstypeexterior.getExteriorId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(SsTypeExterior sstypeexterior) throws Exception{
		 String sql ="INSERT INTO T_SS_TYPE_EXTERIOR(TYPE_ID,EXTERIOR_ID) VALUES(?,?)";
		 Object[] values = new Object[] {sstypeexterior.getTypeId(),sstypeexterior.getExteriorId()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public SsTypeExterior fetch(Map map) throws Exception{
		SsTypeExterior sstypeexterior = new SsTypeExterior();		
		sstypeexterior.setTypeId((String)map.get("TYPE_ID"));
		sstypeexterior.setExteriorId((String)map.get("EXTERIOR_ID"));
		return sstypeexterior;
	}
}
