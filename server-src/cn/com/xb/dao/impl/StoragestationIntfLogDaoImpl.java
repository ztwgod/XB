package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IStoragestationIntfLogDao;
import  cn.com.xb.domain.base.StoragestationIntfLog;

public class StoragestationIntfLogDaoImpl implements IStoragestationIntfLogDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<StoragestationIntfLog> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_STORAGESTATION_INTF_LOG";
		 List<StoragestationIntfLog> list = new ArrayList<StoragestationIntfLog>();
		 List<StoragestationIntfLog> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 StoragestationIntfLog storagestationintflog = fetch(map); 
			 list.add(storagestationintflog); 
		 }
		 return list;
	}
	
	public StoragestationIntfLog loadStoragestationIntfLogBylogId(String logId) throws Exception {
		 StoragestationIntfLog storagestationintflog = null;
		 String sql ="SELECT * FROM T_STORAGESTATION_INTF_LOG WHERE LOG_ID = ? ";
		 Object[] values = new Object[]{logId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 storagestationintflog = fetch(map);
		 return storagestationintflog;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_STORAGESTATION_INTF_LOG";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String logId) throws Exception{
		 String sql ="DELETE FROM T_STORAGESTATION_INTF_LOG WHERE LOG_ID=?";
		 Object[] values = new Object[] { logId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(StoragestationIntfLog storagestationintflog) throws Exception{
		 String sql ="UPDATE T_STORAGESTATION_INTF_LOG SET LOG_TIME= ?,SS_ID= ?,INTF_ID= ?,MSG_CONTENT= ? WHERE LOG_ID=?";
		 Object[] values = new Object[] {storagestationintflog.getLogTime(),storagestationintflog.getSsId(),storagestationintflog.getIntfId(),storagestationintflog.getMsgContent(),storagestationintflog.getLogId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(StoragestationIntfLog storagestationintflog) throws Exception{
		 String sql ="INSERT INTO T_STORAGESTATION_INTF_LOG(LOG_ID,LOG_TIME,SS_ID,INTF_ID,MSG_CONTENT) VALUES(?,?,?,?,?)";
		 Object[] values = new Object[] {storagestationintflog.getLogId(),storagestationintflog.getLogTime(),storagestationintflog.getSsId(),storagestationintflog.getIntfId(),storagestationintflog.getMsgContent()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public StoragestationIntfLog fetch(Map map) throws Exception{
		StoragestationIntfLog storagestationintflog = new StoragestationIntfLog();		
		storagestationintflog.setLogId((String)map.get("LOG_ID"));
		Timestamp logTime = (Timestamp)map.get("LOG_TIME");
		if(null == logTime){
			storagestationintflog.setLogTime(null);
		}else{
			storagestationintflog.setLogTime(new Timestamp(logTime.getTime()));
		}
		storagestationintflog.setSsId((String)map.get("SS_ID"));
		storagestationintflog.setIntfId((String)map.get("INTF_ID"));
		storagestationintflog.setMsgContent((String)map.get("MSG_CONTENT"));
		return storagestationintflog;
	}
}
