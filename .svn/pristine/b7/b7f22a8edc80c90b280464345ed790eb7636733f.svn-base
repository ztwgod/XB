package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IStoragestationMatainLogDao;
import  cn.com.xb.domain.base.StoragestationMatainLog;

public class StoragestationMatainLogDaoImpl implements IStoragestationMatainLogDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<StoragestationMatainLog> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_STORAGESTATION_MATAIN_LOG";
		 List<StoragestationMatainLog> list = new ArrayList<StoragestationMatainLog>();
		 List<StoragestationMatainLog> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 StoragestationMatainLog storagestationmatainlog = fetch(map); 
			 list.add(storagestationmatainlog); 
		 }
		 return list;
	}
	
	public StoragestationMatainLog loadStoragestationMatainLogBymatainId(String matainId) throws Exception {
		 StoragestationMatainLog storagestationmatainlog = null;
		 String sql ="SELECT * FROM T_STORAGESTATION_MATAIN_LOG WHERE MATAIN_ID = ? ";
		 Object[] values = new Object[]{matainId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 storagestationmatainlog = fetch(map);
		 return storagestationmatainlog;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_STORAGESTATION_MATAIN_LOG";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String matainId) throws Exception{
		 String sql ="DELETE FROM T_STORAGESTATION_MATAIN_LOG WHERE MATAIN_ID=?";
		 Object[] values = new Object[] { matainId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(StoragestationMatainLog storagestationmatainlog) throws Exception{
		 String sql ="UPDATE T_STORAGESTATION_MATAIN_LOG SET MATAIN_TYPE= ?,USER_ID= ?,ASSIGN_TIME= ?,COMPLETE_TIME= ?,COMPLETE_RESULT= ?,MATAIN_STATUS= ?,MEMO= ?,SS_ID= ? WHERE MATAIN_ID=?";
		 Object[] values = new Object[] {storagestationmatainlog.getMatainType(),storagestationmatainlog.getUserId(),storagestationmatainlog.getAssignTime(),storagestationmatainlog.getCompleteTime(),storagestationmatainlog.getCompleteResult(),storagestationmatainlog.getMatainStatus(),storagestationmatainlog.getMemo(),storagestationmatainlog.getSsId(),storagestationmatainlog.getMatainId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(StoragestationMatainLog storagestationmatainlog) throws Exception{
		 String sql ="INSERT INTO T_STORAGESTATION_MATAIN_LOG(MATAIN_ID,MATAIN_TYPE,USER_ID,ASSIGN_TIME,COMPLETE_TIME,COMPLETE_RESULT,MATAIN_STATUS,MEMO,SS_ID) VALUES(?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {storagestationmatainlog.getMatainId(),storagestationmatainlog.getMatainType(),storagestationmatainlog.getUserId(),storagestationmatainlog.getAssignTime(),storagestationmatainlog.getCompleteTime(),storagestationmatainlog.getCompleteResult(),storagestationmatainlog.getMatainStatus(),storagestationmatainlog.getMemo(),storagestationmatainlog.getSsId()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public StoragestationMatainLog fetch(Map map) throws Exception{
		StoragestationMatainLog storagestationmatainlog = new StoragestationMatainLog();		
		storagestationmatainlog.setMatainId((String)map.get("MATAIN_ID"));
		storagestationmatainlog.setMatainType(Integer.parseInt(map.get("MATAIN_TYPE").toString()));
		storagestationmatainlog.setUserId((String)map.get("USER_ID"));
		Timestamp assignTime = (Timestamp)map.get("ASSIGN_TIME");
		if(null == assignTime){
			storagestationmatainlog.setAssignTime(null);
		}else{
			storagestationmatainlog.setAssignTime(new Timestamp(assignTime.getTime()));
		}
		Timestamp completeTime = (Timestamp)map.get("COMPLETE_TIME");
		if(null == completeTime){
			storagestationmatainlog.setCompleteTime(null);
		}else{
			storagestationmatainlog.setCompleteTime(new Timestamp(completeTime.getTime()));
		}
		storagestationmatainlog.setCompleteResult((String)map.get("COMPLETE_RESULT"));
		storagestationmatainlog.setMatainStatus(Integer.parseInt(map.get("MATAIN_STATUS").toString()));
		storagestationmatainlog.setMemo((String)map.get("MEMO"));
		storagestationmatainlog.setSsId((String)map.get("SS_ID"));
		return storagestationmatainlog;
	}
}
