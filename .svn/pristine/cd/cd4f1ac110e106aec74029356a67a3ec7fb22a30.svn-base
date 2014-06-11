package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IStoragestationPeripheralDao;
import  cn.com.xb.domain.base.StoragestationPeripheral;

public class StoragestationPeripheralDaoImpl implements IStoragestationPeripheralDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<StoragestationPeripheral> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_STORAGESTATION_PERIPHERAL";
		 List<StoragestationPeripheral> list = new ArrayList<StoragestationPeripheral>();
		 List<StoragestationPeripheral> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 StoragestationPeripheral storagestationperipheral = fetch(map); 
			 list.add(storagestationperipheral); 
		 }
		 return list;
	}
	
	public StoragestationPeripheral loadStoragestationPeripheralByperipheralId(String peripheralId) throws Exception {
		 StoragestationPeripheral storagestationperipheral = null;
		 String sql ="SELECT * FROM T_STORAGESTATION_PERIPHERAL WHERE PERIPHERAL_ID = ? ";
		 Object[] values = new Object[]{peripheralId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 storagestationperipheral = fetch(map);
		 return storagestationperipheral;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_STORAGESTATION_PERIPHERAL";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String peripheralId) throws Exception{
		 String sql ="DELETE FROM T_STORAGESTATION_PERIPHERAL WHERE PERIPHERAL_ID=?";
		 Object[] values = new Object[] { peripheralId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(StoragestationPeripheral storagestationperipheral) throws Exception{
		 String sql ="UPDATE T_STORAGESTATION_PERIPHERAL SET SS_ID= ?,RUN_STATUS= ? WHERE PERIPHERAL_ID=?";
		 Object[] values = new Object[] {storagestationperipheral.getSsId(),storagestationperipheral.getRunStatus(),storagestationperipheral.getPeripheralId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(StoragestationPeripheral storagestationperipheral) throws Exception{
		 String sql ="INSERT INTO T_STORAGESTATION_PERIPHERAL(SS_ID,PERIPHERAL_ID,RUN_STATUS) VALUES(?,?,?)";
		 Object[] values = new Object[] {storagestationperipheral.getSsId(),storagestationperipheral.getPeripheralId(),storagestationperipheral.getRunStatus()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public StoragestationPeripheral fetch(Map map) throws Exception{
		StoragestationPeripheral storagestationperipheral = new StoragestationPeripheral();		
		storagestationperipheral.setSsId((String)map.get("SS_ID"));
		storagestationperipheral.setPeripheralId((String)map.get("PERIPHERAL_ID"));
		storagestationperipheral.setRunStatus(Integer.parseInt(map.get("RUN_STATUS").toString()));
		return storagestationperipheral;
	}
}
