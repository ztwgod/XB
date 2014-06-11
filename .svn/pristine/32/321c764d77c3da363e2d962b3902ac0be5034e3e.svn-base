package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.ITransActionDetailDao;
import  cn.com.xb.domain.base.TransActionDetail;

public class TransActionDetailDaoImpl implements ITransActionDetailDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<TransActionDetail> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_TRANS_ACTION_DETAIL";
		 List<TransActionDetail> list = new ArrayList<TransActionDetail>();
		 List<TransActionDetail> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 TransActionDetail transactiondetail = fetch(map); 
			 list.add(transactiondetail); 
		 }
		 return list;
	}
	
	public TransActionDetail loadTransActionDetailBytransActionId(String transActionId) throws Exception {
		 TransActionDetail transactiondetail = null;
		 String sql ="SELECT * FROM T_TRANS_ACTION_DETAIL WHERE TRANS_ACTION_ID = ? ";
		 Object[] values = new Object[]{transActionId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 transactiondetail = fetch(map);
		 return transactiondetail;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_TRANS_ACTION_DETAIL";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String transActionId) throws Exception{
		 String sql ="DELETE FROM T_TRANS_ACTION_DETAIL WHERE TRANS_ACTION_ID=?";
		 Object[] values = new Object[] { transActionId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(TransActionDetail transactiondetail) throws Exception{
		 String sql ="UPDATE T_TRANS_ACTION_DETAIL SET TRANS_ID= ?,TRANS_ACTION_TYPE= ?,ACTION_TIME= ?,ACTIONER= ?,BOX_ACTION_ID= ? WHERE TRANS_ACTION_ID=?";
		 Object[] values = new Object[] {transactiondetail.getTransId(),transactiondetail.getTransActionType(),transactiondetail.getActionTime(),transactiondetail.getActioner(),transactiondetail.getBoxActionId(),transactiondetail.getTransActionId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(TransActionDetail transactiondetail) throws Exception{
		 String sql ="INSERT INTO T_TRANS_ACTION_DETAIL(TRANS_ACTION_ID,TRANS_ID,TRANS_ACTION_TYPE,ACTION_TIME,ACTIONER,BOX_ACTION_ID) VALUES(?,?,?,?,?,?)";
		 Object[] values = new Object[] {transactiondetail.getTransActionId(),transactiondetail.getTransId(),transactiondetail.getTransActionType(),transactiondetail.getActionTime(),transactiondetail.getActioner(),transactiondetail.getBoxActionId()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public TransActionDetail fetch(Map map) throws Exception{
		TransActionDetail transactiondetail = new TransActionDetail();		
		transactiondetail.setTransActionId((String)map.get("TRANS_ACTION_ID"));
		transactiondetail.setTransId((String)map.get("TRANS_ID"));
		transactiondetail.setTransActionType(Integer.parseInt(map.get("TRANS_ACTION_TYPE").toString()));
		Timestamp actionTime = (Timestamp)map.get("ACTION_TIME");
		if(null == actionTime){
			transactiondetail.setActionTime(null);
		}else{
			transactiondetail.setActionTime(new Timestamp(actionTime.getTime()));
		}
		transactiondetail.setActioner((String)map.get("ACTIONER"));
		transactiondetail.setBoxActionId((String)map.get("BOX_ACTION_ID"));
		return transactiondetail;
	}
}
