package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IPCourierDao;
import  cn.com.xb.domain.base.PCourier;

public class PCourierDaoImpl implements IPCourierDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<PCourier> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_P_COURIER";
		 List<PCourier> list = new ArrayList<PCourier>();
		 List<PCourier> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 PCourier pcourier = fetch(map); 
			 list.add(pcourier); 
		 }
		 return list;
	}
	
	public PCourier loadPCourierByuserId(String userId) throws Exception {
		 PCourier pcourier = null;
		 String sql ="SELECT * FROM T_P_COURIER WHERE USER_ID = ? ";
		 Object[] values = new Object[]{userId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 pcourier = fetch(map);
		 return pcourier;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_P_COURIER";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String userId) throws Exception{
		 String sql ="DELETE FROM T_P_COURIER WHERE USER_ID=?";
		 Object[] values = new Object[] { userId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(PCourier pcourier) throws Exception{
		 String sql ="UPDATE T_P_COURIER SET GROUP_ID= ?,EXCO_ID= ?,COURIER_STATUS= ?,LOCALE_ID= ?,SNAPSHOT_PIC_ID= ?,PAPERWORK_PIC1_ID= ?,PAPERWORK_PIC2_ID= ? WHERE USER_ID=?";
		 Object[] values = new Object[] {pcourier.getGroupId(),pcourier.getExcoId(),pcourier.getCourierStatus(),pcourier.getLocaleId(),pcourier.getSnapshotPicId(),pcourier.getPaperworkPic1Id(),pcourier.getPaperworkPic2Id(),pcourier.getUserId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(PCourier pcourier) throws Exception{
		 String sql ="INSERT INTO T_P_COURIER(USER_ID,GROUP_ID,EXCO_ID,COURIER_STATUS,LOCALE_ID,SNAPSHOT_PIC_ID,PAPERWORK_PIC1_ID,PAPERWORK_PIC2_ID) VALUES(?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {pcourier.getUserId(),pcourier.getGroupId(),pcourier.getExcoId(),pcourier.getCourierStatus(),pcourier.getLocaleId(),pcourier.getSnapshotPicId(),pcourier.getPaperworkPic1Id(),pcourier.getPaperworkPic2Id()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public PCourier fetch(Map map) throws Exception{
		PCourier pcourier = new PCourier();		
		pcourier.setUserId((String)map.get("USER_ID"));
		pcourier.setGroupId((String)map.get("GROUP_ID"));
		pcourier.setExcoId((String)map.get("EXCO_ID"));
		pcourier.setCourierStatus(Integer.parseInt(map.get("COURIER_STATUS").toString()));
		pcourier.setLocaleId((String)map.get("LOCALE_ID"));
		pcourier.setSnapshotPicId((String)map.get("SNAPSHOT_PIC_ID"));
		pcourier.setPaperworkPic1Id((String)map.get("PAPERWORK_PIC1_ID"));
		pcourier.setPaperworkPic2Id((String)map.get("PAPERWORK_PIC2_ID"));
		return pcourier;
	}
}
