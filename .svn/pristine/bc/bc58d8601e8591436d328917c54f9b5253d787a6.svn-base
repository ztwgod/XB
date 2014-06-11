package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IStoragestationTypeDao;
import  cn.com.xb.domain.base.StoragestationType;

public class StoragestationTypeDaoImpl implements IStoragestationTypeDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<StoragestationType> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_STORAGESTATION_TYPE";
		 List<StoragestationType> list = new ArrayList<StoragestationType>();
		 List<StoragestationType> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 StoragestationType storagestationtype = fetch(map); 
			 list.add(storagestationtype); 
		 }
		 return list;
	}
	
	public StoragestationType loadStoragestationTypeBytypeId(String typeId) throws Exception {
		 StoragestationType storagestationtype = null;
		 String sql ="SELECT * FROM T_STORAGESTATION_TYPE WHERE TYPE_ID = ? ";
		 Object[] values = new Object[]{typeId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 storagestationtype = fetch(map);
		 return storagestationtype;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_STORAGESTATION_TYPE";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String typeId) throws Exception{
		 String sql ="DELETE FROM T_STORAGESTATION_TYPE WHERE TYPE_ID=?";
		 Object[] values = new Object[] { typeId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(StoragestationType storagestationtype) throws Exception{
		 String sql ="UPDATE T_STORAGESTATION_TYPE SET TYPE_NAME= ?,TYPE_CODE= ?,TYPE_DESC= ? WHERE TYPE_ID=?";
		 Object[] values = new Object[] {storagestationtype.getTypeName(),storagestationtype.getTypeCode(),storagestationtype.getTypeDesc(),storagestationtype.getTypeId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(StoragestationType storagestationtype) throws Exception{
		 String sql ="INSERT INTO T_STORAGESTATION_TYPE(TYPE_ID,TYPE_NAME,TYPE_CODE,TYPE_DESC) VALUES(?,?,?,?)";
		 Object[] values = new Object[] {storagestationtype.getTypeId(),storagestationtype.getTypeName(),storagestationtype.getTypeCode(),storagestationtype.getTypeDesc()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public StoragestationType fetch(Map map) throws Exception{
		StoragestationType storagestationtype = new StoragestationType();		
		storagestationtype.setTypeId((String)map.get("TYPE_ID"));
		storagestationtype.setTypeName((String)map.get("TYPE_NAME"));
		storagestationtype.setTypeCode((String)map.get("TYPE_CODE"));
		storagestationtype.setTypeDesc((String)map.get("TYPE_DESC"));
		return storagestationtype;
	}
}
