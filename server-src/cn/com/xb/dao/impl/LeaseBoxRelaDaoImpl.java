package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.ILeaseBoxRelaDao;
import  cn.com.xb.domain.base.LeaseBoxRela;

public class LeaseBoxRelaDaoImpl implements ILeaseBoxRelaDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<LeaseBoxRela> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_LEASE_BOX_RELA";
		 List<LeaseBoxRela> list = new ArrayList<LeaseBoxRela>();
		 List<LeaseBoxRela> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 LeaseBoxRela leaseboxrela = fetch(map); 
			 list.add(leaseboxrela); 
		 }
		 return list;
	}
	
	public LeaseBoxRela loadLeaseBoxRelaByaliasesId(String aliasesId) throws Exception {
		 LeaseBoxRela leaseboxrela = null;
		 String sql ="SELECT * FROM T_LEASE_BOX_RELA WHERE ALIASES_ID = ? ";
		 Object[] values = new Object[]{aliasesId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 leaseboxrela = fetch(map);
		 return leaseboxrela;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_LEASE_BOX_RELA";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String aliasesId) throws Exception{
		 String sql ="DELETE FROM T_LEASE_BOX_RELA WHERE ALIASES_ID=?";
		 Object[] values = new Object[] { aliasesId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(LeaseBoxRela leaseboxrela) throws Exception{
		 String sql ="UPDATE T_LEASE_BOX_RELA SET BOX_ID= ? WHERE ALIASES_ID=?";
		 Object[] values = new Object[] {leaseboxrela.getBoxId(),leaseboxrela.getAliasesId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(LeaseBoxRela leaseboxrela) throws Exception{
		 String sql ="INSERT INTO T_LEASE_BOX_RELA(ALIASES_ID,BOX_ID) VALUES(?,?)";
		 Object[] values = new Object[] {leaseboxrela.getAliasesId(),leaseboxrela.getBoxId()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public LeaseBoxRela fetch(Map map) throws Exception{
		LeaseBoxRela leaseboxrela = new LeaseBoxRela();		
		leaseboxrela.setAliasesId((String)map.get("ALIASES_ID"));
		leaseboxrela.setBoxId((String)map.get("BOX_ID"));
		return leaseboxrela;
	}
}
