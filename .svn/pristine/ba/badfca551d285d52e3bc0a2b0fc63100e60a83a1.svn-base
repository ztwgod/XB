package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IPSysDao;
import  cn.com.xb.domain.base.PSys;

public class PSysDaoImpl implements IPSysDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<PSys> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_P_SYS";
		 List<PSys> list = new ArrayList<PSys>();
		 List<PSys> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 PSys psys = fetch(map); 
			 list.add(psys); 
		 }
		 return list;
	}
	
	public PSys loadPSysByuserId(String userId) throws Exception {
		 PSys psys = null;
		 String sql ="SELECT * FROM T_P_SYS WHERE USER_ID = ? ";
		 Object[] values = new Object[]{userId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 psys = fetch(map);
		 return psys;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_P_SYS";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String userId) throws Exception{
		 String sql ="DELETE FROM T_P_SYS WHERE USER_ID=?";
		 Object[] values = new Object[] { userId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(PSys psys) throws Exception{
		 String sql ="UPDATE T_P_SYS SET ORG_DESC= ?,DEPT_DESC= ? WHERE USER_ID=?";
		 Object[] values = new Object[] {psys.getOrgDesc(),psys.getDeptDesc(),psys.getUserId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(PSys psys) throws Exception{
		 String sql ="INSERT INTO T_P_SYS(USER_ID,ORG_DESC,DEPT_DESC) VALUES(?,?,?)";
		 Object[] values = new Object[] {psys.getUserId(),psys.getOrgDesc(),psys.getDeptDesc()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public PSys fetch(Map map) throws Exception{
		PSys psys = new PSys();		
		psys.setUserId((String)map.get("USER_ID"));
		psys.setOrgDesc((String)map.get("ORG_DESC"));
		psys.setDeptDesc((String)map.get("DEPT_DESC"));
		return psys;
	}
}
