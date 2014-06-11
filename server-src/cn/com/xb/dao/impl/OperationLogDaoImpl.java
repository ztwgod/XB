package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IOperationLogDao;
import  cn.com.xb.domain.base.OperationLog;

public class OperationLogDaoImpl implements IOperationLogDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<OperationLog> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_OPERATION_LOG";
		 List<OperationLog> list = new ArrayList<OperationLog>();
		 List<OperationLog> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 OperationLog operationlog = fetch(map); 
			 list.add(operationlog); 
		 }
		 return list;
	}
	
	public OperationLog loadOperationLogBylogId(String logId) throws Exception {
		 OperationLog operationlog = null;
		 String sql ="SELECT * FROM T_OPERATION_LOG WHERE LOG_ID = ? ";
		 Object[] values = new Object[]{logId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 operationlog = fetch(map);
		 return operationlog;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_OPERATION_LOG";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String logId) throws Exception{
		 String sql ="DELETE FROM T_OPERATION_LOG WHERE LOG_ID=?";
		 Object[] values = new Object[] { logId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(OperationLog operationlog) throws Exception{
		 String sql ="UPDATE T_OPERATION_LOG SET SYS_PLAT_TYPE= ?,OPERATION_USER_ID= ?,OPERATION_TYPE= ?,SS_ID= ?,BOX_ID= ?,OPERATION_CONTENT= ?,OPERATION_RESULT= ?,OPERATION_TIME= ? WHERE LOG_ID=?";
		 Object[] values = new Object[] {operationlog.getSysPlatType(),operationlog.getOperationUserId(),operationlog.getOperationType(),operationlog.getSsId(),operationlog.getBoxId(),operationlog.getOperationContent(),operationlog.getOperationResult(),operationlog.getOperationTime(),operationlog.getLogId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(OperationLog operationlog) throws Exception{
		 String sql ="INSERT INTO T_OPERATION_LOG(LOG_ID,SYS_PLAT_TYPE,OPERATION_USER_ID,OPERATION_TYPE,SS_ID,BOX_ID,OPERATION_CONTENT,OPERATION_RESULT,OPERATION_TIME) VALUES(?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {operationlog.getLogId(),operationlog.getSysPlatType(),operationlog.getOperationUserId(),operationlog.getOperationType(),operationlog.getSsId(),operationlog.getBoxId(),operationlog.getOperationContent(),operationlog.getOperationResult(),operationlog.getOperationTime()};
		 System.out.println("LOGINFO:::"+Arrays.asList(values));
		 jdbcTemplate.update(sql, values);

	}	
	
	public OperationLog fetch(Map map) throws Exception{
		OperationLog operationlog = new OperationLog();		
		operationlog.setLogId((String)map.get("LOG_ID"));
		operationlog.setSysPlatType(Integer.parseInt(map.get("SYS_PLAT_TYPE").toString()));
		operationlog.setOperationUserId((String)map.get("OPERATION_USER_ID"));
		operationlog.setOperationType(Integer.parseInt(map.get("OPERATION_TYPE").toString()));
		operationlog.setSsId((String)map.get("SS_ID"));
		operationlog.setBoxId((String)map.get("BOX_ID"));
		operationlog.setOperationContent((String)map.get("OPERATION_CONTENT"));
		operationlog.setOperationResult((String)map.get("OPERATION_RESULT"));
		Timestamp operationTime = (Timestamp)map.get("OPERATION_TIME");
		if(null == operationTime){
			operationlog.setOperationTime(null);
		}else{
			operationlog.setOperationTime(new Timestamp(operationTime.getTime()));
		}
		return operationlog;
	}
}
