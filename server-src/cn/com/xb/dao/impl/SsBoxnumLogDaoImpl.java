package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.ISsBoxnumLogDao;
import  cn.com.xb.domain.base.SsBoxnumLog;

public class SsBoxnumLogDaoImpl implements ISsBoxnumLogDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<SsBoxnumLog> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_SS_BOXNUM_LOG";
		 List<SsBoxnumLog> list = new ArrayList<SsBoxnumLog>();
		 List<SsBoxnumLog> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 SsBoxnumLog ssboxnumlog = fetch(map); 
			 list.add(ssboxnumlog); 
		 }
		 return list;
	}
	
	public SsBoxnumLog loadSsBoxnumLogByrecordId(String recordId) throws Exception {
		 SsBoxnumLog ssboxnumlog = null;
		 String sql ="SELECT * FROM T_SS_BOXNUM_LOG WHERE RECORD_ID = ? ";
		 Object[] values = new Object[]{recordId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 ssboxnumlog = fetch(map);
		 return ssboxnumlog;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_SS_BOXNUM_LOG";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String recordId) throws Exception{
		 String sql ="DELETE FROM T_SS_BOXNUM_LOG WHERE RECORD_ID=?";
		 Object[] values = new Object[] { recordId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(SsBoxnumLog ssboxnumlog) throws Exception{
		 String sql ="UPDATE T_SS_BOXNUM_LOG SET SS_ID= ?,TOTAL_NUM= ?,FAULT_NUM= ?,OCCUPATION_NUM= ?,EMPTY_NUM= ?,RECORD_TIME= ? WHERE RECORD_ID=?";
		 Object[] values = new Object[] {ssboxnumlog.getSsId(),ssboxnumlog.getTotalNum(),ssboxnumlog.getFaultNum(),ssboxnumlog.getOccupationNum(),ssboxnumlog.getEmptyNum(),ssboxnumlog.getRecordTime(),ssboxnumlog.getRecordId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(SsBoxnumLog ssboxnumlog) throws Exception{
		 String sql ="INSERT INTO T_SS_BOXNUM_LOG(RECORD_ID,SS_ID,TOTAL_NUM,FAULT_NUM,OCCUPATION_NUM,EMPTY_NUM,RECORD_TIME) VALUES(?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {ssboxnumlog.getRecordId(),ssboxnumlog.getSsId(),ssboxnumlog.getTotalNum(),ssboxnumlog.getFaultNum(),ssboxnumlog.getOccupationNum(),ssboxnumlog.getEmptyNum(),ssboxnumlog.getRecordTime()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public SsBoxnumLog fetch(Map map) throws Exception{
		SsBoxnumLog ssboxnumlog = new SsBoxnumLog();		
		ssboxnumlog.setRecordId((String)map.get("RECORD_ID"));
		ssboxnumlog.setSsId((String)map.get("SS_ID"));
		ssboxnumlog.setTotalNum(Integer.parseInt(map.get("TOTAL_NUM").toString()));
		ssboxnumlog.setFaultNum(Integer.parseInt(map.get("FAULT_NUM").toString()));
		ssboxnumlog.setOccupationNum(Integer.parseInt(map.get("OCCUPATION_NUM").toString()));
		ssboxnumlog.setEmptyNum(Integer.parseInt(map.get("EMPTY_NUM").toString()));
		Timestamp recordTime = (Timestamp)map.get("RECORD_TIME");
		if(null == recordTime){
			ssboxnumlog.setRecordTime(null);
		}else{
			ssboxnumlog.setRecordTime(new Timestamp(recordTime.getTime()));
		}
		return ssboxnumlog;
	}
}
