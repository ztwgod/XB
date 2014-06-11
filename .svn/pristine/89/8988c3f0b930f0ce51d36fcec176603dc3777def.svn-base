package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IPeripheralDao;
import  cn.com.xb.domain.base.Peripheral;

public class PeripheralDaoImpl implements IPeripheralDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<Peripheral> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_PERIPHERAL";
		 List<Peripheral> list = new ArrayList<Peripheral>();
		 List<Peripheral> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 Peripheral peripheral = fetch(map); 
			 list.add(peripheral); 
		 }
		 return list;
	}
	
	public Peripheral loadPeripheralByperipheralId(String peripheralId) throws Exception {
		 Peripheral peripheral = null;
		 String sql ="SELECT * FROM T_PERIPHERAL WHERE PERIPHERAL_ID = ? ";
		 Object[] values = new Object[]{peripheralId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 peripheral = fetch(map);
		 return peripheral;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_PERIPHERAL";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String peripheralId) throws Exception{
		 String sql ="DELETE FROM T_PERIPHERAL WHERE PERIPHERAL_ID=?";
		 Object[] values = new Object[] { peripheralId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(Peripheral peripheral) throws Exception{
		 String sql ="UPDATE T_PERIPHERAL SET PERIPHERAL_ABB_NAME= ?,ASSET_SN= ?,TYPE= ?,VERSION= ?,START_TIME= ?,STOP_TIME= ?,STATUS= ?,MEMO= ?,PERIPHERAL_CODE= ? WHERE PERIPHERAL_ID=?";
		 Object[] values = new Object[] {peripheral.getPeripheralAbbName(),peripheral.getAssetSn(),peripheral.getType(),peripheral.getVersion(),peripheral.getStartTime(),peripheral.getStopTime(),peripheral.getStatus(),peripheral.getMemo(),peripheral.getPeripheralCode(),peripheral.getPeripheralId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(Peripheral peripheral) throws Exception{
		 String sql ="INSERT INTO T_PERIPHERAL(PERIPHERAL_ID,PERIPHERAL_ABB_NAME,ASSET_SN,TYPE,VERSION,START_TIME,STOP_TIME,STATUS,MEMO,PERIPHERAL_CODE) VALUES(?,?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {peripheral.getPeripheralId(),peripheral.getPeripheralAbbName(),peripheral.getAssetSn(),peripheral.getType(),peripheral.getVersion(),peripheral.getStartTime(),peripheral.getStopTime(),peripheral.getStatus(),peripheral.getMemo(),peripheral.getPeripheralCode()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public Peripheral fetch(Map map) throws Exception{
		Peripheral peripheral = new Peripheral();		
		peripheral.setPeripheralId((String)map.get("PERIPHERAL_ID"));
		peripheral.setPeripheralAbbName((String)map.get("PERIPHERAL_ABB_NAME"));
		peripheral.setAssetSn((String)map.get("ASSET_SN"));
		peripheral.setType(Integer.parseInt(map.get("TYPE").toString()));
		peripheral.setVersion((String)map.get("VERSION"));
		Timestamp startTime = (Timestamp)map.get("START_TIME");
		if(null == startTime){
			peripheral.setStartTime(null);
		}else{
			peripheral.setStartTime(new Timestamp(startTime.getTime()));
		}
		Timestamp stopTime = (Timestamp)map.get("STOP_TIME");
		if(null == stopTime){
			peripheral.setStopTime(null);
		}else{
			peripheral.setStopTime(new Timestamp(stopTime.getTime()));
		}
		peripheral.setStatus(Integer.parseInt(map.get("STATUS").toString()));
		peripheral.setMemo((String)map.get("MEMO"));
		peripheral.setPeripheralCode((String)map.get("PERIPHERAL_CODE"));
		return peripheral;
	}
}
