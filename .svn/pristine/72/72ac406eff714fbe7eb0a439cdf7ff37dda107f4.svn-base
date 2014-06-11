package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IStoragestationDao;
import  cn.com.xb.domain.base.Storagestation;

public class StoragestationDaoImpl implements IStoragestationDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<Storagestation> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_STORAGESTATION";
		 List<Storagestation> list = new ArrayList<Storagestation>();
		 List<Storagestation> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 Storagestation storagestation = fetch(map); 
			 list.add(storagestation); 
		 }
		 return list;
	}
	
	public Storagestation loadStoragestationByssId(String ssId) throws Exception {
		 Storagestation storagestation = null;
		 String sql ="SELECT * FROM T_STORAGESTATION WHERE SS_ID = ? ";
		 Object[] values = new Object[]{ssId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 storagestation = fetch(map);
		 return storagestation;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_STORAGESTATION";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String ssId) throws Exception{
		 String sql ="DELETE FROM T_STORAGESTATION WHERE SS_ID=?";
		 Object[] values = new Object[] { ssId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(Storagestation storagestation) throws Exception{
		 String sql ="UPDATE T_STORAGESTATION SET SS_NAME= ?,SS_CODE= ?,ASSET_SN= ?,DATA_CARD= ?,IP_ADD= ?,PORT= ?,LINK_TYPE= ?,GROUP_ID= ?,SS_TYPE= ?,MODEL_ID= ?,LONGITUDE= ?,LATITUDE= ?,AVAILABLE_BOX_NUM= ?,RUN_STATUS= ?,INSTALL_DATE= ?,POI_ID= ?,SS_ADDRESS= ?,CONTROL_CABINET_LOCATION= ? WHERE SS_ID=?";
		 Object[] values = new Object[] {storagestation.getSsName(),storagestation.getSsCode(),storagestation.getAssetSn(),storagestation.getDataCard(),storagestation.getIpAdd(),storagestation.getPort(),storagestation.getLinkType(),storagestation.getGroupId(),storagestation.getSsType(),storagestation.getModelId(),storagestation.getLongitude(),storagestation.getLatitude(),storagestation.getAvailableBoxNum(),storagestation.getRunStatus(),storagestation.getInstallDate(),storagestation.getPoiId(),storagestation.getSsAddress(),storagestation.getControlCabinetLocation(),storagestation.getSsId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(Storagestation storagestation) throws Exception{
		 String sql ="INSERT INTO T_STORAGESTATION(SS_ID,SS_NAME,SS_CODE,ASSET_SN,DATA_CARD,IP_ADD,PORT,LINK_TYPE,GROUP_ID,SS_TYPE,MODEL_ID,LONGITUDE,LATITUDE,AVAILABLE_BOX_NUM,RUN_STATUS,INSTALL_DATE,POI_ID,SS_ADDRESS,CONTROL_CABINET_LOCATION) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {storagestation.getSsId(),storagestation.getSsName(),storagestation.getSsCode(),storagestation.getAssetSn(),storagestation.getDataCard(),storagestation.getIpAdd(),storagestation.getPort(),storagestation.getLinkType(),storagestation.getGroupId(),storagestation.getSsType(),storagestation.getModelId(),storagestation.getLongitude(),storagestation.getLatitude(),storagestation.getAvailableBoxNum(),storagestation.getRunStatus(),storagestation.getInstallDate(),storagestation.getPoiId(),storagestation.getSsAddress(),storagestation.getControlCabinetLocation()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public Storagestation fetch(Map map) throws Exception{
		Storagestation storagestation = new Storagestation();		
		storagestation.setSsId((String)map.get("SS_ID"));
		storagestation.setSsName((String)map.get("SS_NAME"));
		storagestation.setSsCode((String)map.get("SS_CODE"));
		storagestation.setAssetSn((String)map.get("ASSET_SN"));
		storagestation.setDataCard((String)map.get("DATA_CARD"));
		storagestation.setIpAdd((String)map.get("IP_ADD"));
		storagestation.setPort((String)map.get("PORT"));
		storagestation.setLinkType(Integer.parseInt(map.get("LINK_TYPE").toString()));
		storagestation.setGroupId((String)map.get("GROUP_ID"));
		storagestation.setSsType((String)map.get("SS_TYPE"));
		storagestation.setModelId((String)map.get("MODEL_ID"));
		storagestation.setLongitude(Double.parseDouble(map.get("LONGITUDE").toString()));
		storagestation.setLatitude(Double.parseDouble(map.get("LATITUDE").toString()));
		storagestation.setAvailableBoxNum(Integer.parseInt(map.get("AVAILABLE_BOX_NUM").toString()));
		storagestation.setRunStatus(Integer.parseInt(map.get("RUN_STATUS").toString()));
		Timestamp installDate = (Timestamp)map.get("INSTALL_DATE");
		if(null == installDate){
			storagestation.setInstallDate(null);
		}else{
			storagestation.setInstallDate(new Timestamp(installDate.getTime()));
		}
		storagestation.setPoiId((String)map.get("POI_ID"));
		storagestation.setSsAddress((String)map.get("SS_ADDRESS"));
		storagestation.setControlCabinetLocation(Integer.parseInt(map.get("CONTROL_CABINET_LOCATION").toString()));
		return storagestation;
	}
}
