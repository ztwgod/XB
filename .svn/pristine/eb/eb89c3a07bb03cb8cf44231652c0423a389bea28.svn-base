package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IIntfDao;
import  cn.com.xb.domain.base.Intf;

public class IntfDaoImpl implements IIntfDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<Intf> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_INTF";
		 List<Intf> list = new ArrayList<Intf>();
		 List<Intf> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 Intf intf = fetch(map); 
			 list.add(intf); 
		 }
		 return list;
	}
	
	public Intf loadIntfByintfId(String intfId) throws Exception {
		 Intf intf = null;
		 String sql ="SELECT * FROM T_INTF WHERE INTF_ID = ? ";
		 Object[] values = new Object[]{intfId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 intf = fetch(map);
		 return intf;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_INTF";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String intfId) throws Exception{
		 String sql ="DELETE FROM T_INTF WHERE INTF_ID=?";
		 Object[] values = new Object[] { intfId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(Intf intf) throws Exception{
		 String sql ="UPDATE T_INTF SET INTF_URL= ?,INTF_NAME= ?,UPDOWN= ? WHERE INTF_ID=?";
		 Object[] values = new Object[] {intf.getIntfUrl(),intf.getIntfName(),intf.getUpdown(),intf.getIntfId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(Intf intf) throws Exception{
		 String sql ="INSERT INTO T_INTF(INTF_ID,INTF_URL,INTF_NAME,UPDOWN) VALUES(?,?,?,?)";
		 Object[] values = new Object[] {intf.getIntfId(),intf.getIntfUrl(),intf.getIntfName(),intf.getUpdown()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public Intf fetch(Map map) throws Exception{
		Intf intf = new Intf();		
		intf.setIntfId((String)map.get("INTF_ID"));
		intf.setIntfUrl((String)map.get("INTF_URL"));
		intf.setIntfName((String)map.get("INTF_NAME"));
		intf.setUpdown(Integer.parseInt(map.get("UPDOWN").toString()));
		return intf;
	}
}
