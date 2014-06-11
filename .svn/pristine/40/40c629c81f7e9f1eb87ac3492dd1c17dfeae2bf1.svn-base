package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.ILeaseAliasesDao;
import  cn.com.xb.domain.base.LeaseAliases;

public class LeaseAliasesDaoImpl implements ILeaseAliasesDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<LeaseAliases> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_LEASE_ALIASES";
		 List<LeaseAliases> list = new ArrayList<LeaseAliases>();
		 List<LeaseAliases> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 LeaseAliases leasealiases = fetch(map); 
			 list.add(leasealiases); 
		 }
		 return list;
	}
	
	public LeaseAliases loadLeaseAliasesByaliasesId(String aliasesId) throws Exception {
		 LeaseAliases leasealiases = null;
		 String sql ="SELECT * FROM T_LEASE_ALIASES WHERE ALIASES_ID = ? ";
		 Object[] values = new Object[]{aliasesId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 leasealiases = fetch(map);
		 return leasealiases;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_LEASE_ALIASES";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String aliasesId) throws Exception{
		 String sql ="DELETE FROM T_LEASE_ALIASES WHERE ALIASES_ID=?";
		 Object[] values = new Object[] { aliasesId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(LeaseAliases leasealiases) throws Exception{
		 String sql ="UPDATE T_LEASE_ALIASES SET ALIASES_NAME= ?,USER_ID= ?,SS_ID= ?,LEASE_BOX_NUM= ?,ALIASES_LEVEL= ? WHERE ALIASES_ID=?";
		 Object[] values = new Object[] {leasealiases.getAliasesName(),leasealiases.getUserId(),leasealiases.getSsId(),leasealiases.getLeaseBoxNum(),leasealiases.getAliasesLevel(),leasealiases.getAliasesId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(LeaseAliases leasealiases) throws Exception{
		 String sql ="INSERT INTO T_LEASE_ALIASES(ALIASES_ID,ALIASES_NAME,USER_ID,SS_ID,LEASE_BOX_NUM,ALIASES_LEVEL) VALUES(?,?,?,?,?,?)";
		 Object[] values = new Object[] {leasealiases.getAliasesId(),leasealiases.getAliasesName(),leasealiases.getUserId(),leasealiases.getSsId(),leasealiases.getLeaseBoxNum(),leasealiases.getAliasesLevel()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public LeaseAliases fetch(Map map) throws Exception{
		LeaseAliases leasealiases = new LeaseAliases();		
		leasealiases.setAliasesId((String)map.get("ALIASES_ID"));
		leasealiases.setAliasesName((String)map.get("ALIASES_NAME"));
		leasealiases.setUserId((String)map.get("USER_ID"));
		leasealiases.setSsId((String)map.get("SS_ID"));
		leasealiases.setLeaseBoxNum(Integer.parseInt(map.get("LEASE_BOX_NUM").toString()));
		leasealiases.setAliasesLevel(Integer.parseInt(map.get("ALIASES_LEVEL").toString()));
		return leasealiases;
	}
}
