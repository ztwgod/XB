package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IStoragestationDeliveryGDao;
import  cn.com.xb.domain.base.StoragestationDeliveryG;

public class StoragestationDeliveryGDaoImpl implements IStoragestationDeliveryGDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<StoragestationDeliveryG> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_STORAGESTATION_DELIVERY_G";
		 List<StoragestationDeliveryG> list = new ArrayList<StoragestationDeliveryG>();
		 List<StoragestationDeliveryG> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 StoragestationDeliveryG storagestationdeliveryg = fetch(map); 
			 list.add(storagestationdeliveryg); 
		 }
		 return list;
	}
	
	public StoragestationDeliveryG loadStoragestationDeliveryGByexePermission(int exePermission) throws Exception {
		 StoragestationDeliveryG storagestationdeliveryg = null;
		 String sql ="SELECT * FROM T_STORAGESTATION_DELIVERY_G WHERE EXE_PERMISSION = ? ";
		 Object[] values = new Object[]{exePermission};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 storagestationdeliveryg = fetch(map);
		 return storagestationdeliveryg;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_STORAGESTATION_DELIVERY_G";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(int exePermission) throws Exception{
		 String sql ="DELETE FROM T_STORAGESTATION_DELIVERY_G WHERE EXE_PERMISSION=?";
		 Object[] values = new Object[] { exePermission };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(StoragestationDeliveryG storagestationdeliveryg) throws Exception{
		 String sql ="UPDATE T_STORAGESTATION_DELIVERY_G SET SS_ID= ?,GROUP_ID= ? WHERE EXE_PERMISSION=?";
		 Object[] values = new Object[] {storagestationdeliveryg.getSsId(),storagestationdeliveryg.getGroupId(),storagestationdeliveryg.getExePermission()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(StoragestationDeliveryG storagestationdeliveryg) throws Exception{
		 String sql ="INSERT INTO T_STORAGESTATION_DELIVERY_G(SS_ID,GROUP_ID,EXE_PERMISSION) VALUES(?,?,?)";
		 Object[] values = new Object[] {storagestationdeliveryg.getSsId(),storagestationdeliveryg.getGroupId(),storagestationdeliveryg.getExePermission()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public StoragestationDeliveryG fetch(Map map) throws Exception{
		StoragestationDeliveryG storagestationdeliveryg = new StoragestationDeliveryG();		
		storagestationdeliveryg.setSsId((String)map.get("SS_ID"));
		storagestationdeliveryg.setGroupId((String)map.get("GROUP_ID"));
		storagestationdeliveryg.setExePermission(Integer.parseInt(map.get("EXE_PERMISSION").toString()));
		return storagestationdeliveryg;
	}
}
