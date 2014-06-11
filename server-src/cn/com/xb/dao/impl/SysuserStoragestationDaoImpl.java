package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.ISysuserStoragestationDao;
import  cn.com.xb.domain.base.SysuserStoragestation;

public class SysuserStoragestationDaoImpl implements ISysuserStoragestationDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<SysuserStoragestation> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_SYSUSER_STORAGESTATION";
		 List<SysuserStoragestation> list = new ArrayList<SysuserStoragestation>();
		 List<SysuserStoragestation> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 SysuserStoragestation sysuserstoragestation = fetch(map); 
			 list.add(sysuserstoragestation); 
		 }
		 return list;
	}
	
	public SysuserStoragestation loadSysuserStoragestationByssId(String ssId) throws Exception {
		 SysuserStoragestation sysuserstoragestation = null;
		 String sql ="SELECT * FROM T_SYSUSER_STORAGESTATION WHERE SS_ID = ? ";
		 Object[] values = new Object[]{ssId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 sysuserstoragestation = fetch(map);
		 return sysuserstoragestation;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_SYSUSER_STORAGESTATION";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String ssId) throws Exception{
		 String sql ="DELETE FROM T_SYSUSER_STORAGESTATION WHERE SS_ID=?";
		 Object[] values = new Object[] { ssId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(SysuserStoragestation sysuserstoragestation) throws Exception{
		 String sql ="UPDATE T_SYSUSER_STORAGESTATION SET USER_ID= ? WHERE SS_ID=?";
		 Object[] values = new Object[] {sysuserstoragestation.getUserId(),sysuserstoragestation.getSsId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(SysuserStoragestation sysuserstoragestation) throws Exception{
		 String sql ="INSERT INTO T_SYSUSER_STORAGESTATION(SS_ID,USER_ID) VALUES(?,?)";
		 Object[] values = new Object[] {sysuserstoragestation.getSsId(),sysuserstoragestation.getUserId()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public SysuserStoragestation fetch(Map map) throws Exception{
		SysuserStoragestation sysuserstoragestation = new SysuserStoragestation();		
		sysuserstoragestation.setSsId((String)map.get("SS_ID"));
		sysuserstoragestation.setUserId((String)map.get("USER_ID"));
		return sysuserstoragestation;
	}
}
