package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IPClientDao;
import  cn.com.xb.domain.base.PClient;

public class PClientDaoImpl implements IPClientDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<PClient> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_P_CLIENT";
		 List<PClient> list = new ArrayList<PClient>();
		 List<PClient> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 PClient pclient = fetch(map); 
			 list.add(pclient); 
		 }
		 return list;
	}
	
	public PClient loadPClientByuserId(String userId) throws Exception {
		 PClient pclient = null;
		 String sql ="SELECT * FROM T_P_CLIENT WHERE USER_ID = ? ";
		 Object[] values = new Object[]{userId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 pclient = fetch(map);
		 return pclient;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_P_CLIENT";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String userId) throws Exception{
		 String sql ="DELETE FROM T_P_CLIENT WHERE USER_ID=?";
		 Object[] values = new Object[] { userId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(PClient pclient) throws Exception{
		 String sql ="UPDATE T_P_CLIENT SET REGISTER_TYPE= ?,OVERAGE= ? WHERE USER_ID=?";
		 Object[] values = new Object[] {pclient.getRegisterType(),pclient.getOverage(),pclient.getUserId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(PClient pclient) throws Exception{
		 String sql ="INSERT INTO T_P_CLIENT(USER_ID,REGISTER_TYPE,OVERAGE) VALUES(?,?,?)";
		 Object[] values = new Object[] {pclient.getUserId(),pclient.getRegisterType(),pclient.getOverage()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public PClient fetch(Map map) throws Exception{
		PClient pclient = new PClient();		
		pclient.setUserId((String)map.get("USER_ID"));
		pclient.setRegisterType(Integer.parseInt(map.get("REGISTER_TYPE").toString()));
		pclient.setOverage(Double.parseDouble(map.get("OVERAGE").toString()));
		return pclient;
	}
}
