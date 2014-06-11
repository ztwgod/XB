package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.ICabinetDao;
import  cn.com.xb.domain.base.Cabinet;

public class CabinetDaoImpl implements ICabinetDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<Cabinet> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_CABINET";
		 List<Cabinet> list = new ArrayList<Cabinet>();
		 List<Cabinet> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 Cabinet cabinet = fetch(map); 
			 list.add(cabinet); 
		 }
		 return list;
	}
	
	public Cabinet loadCabinetBycabinetId(String cabinetId) throws Exception {
		 Cabinet cabinet = null;
		 String sql ="SELECT * FROM T_CABINET WHERE CABINET_ID = ? ";
		 Object[] values = new Object[]{cabinetId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 cabinet = fetch(map);
		 return cabinet;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_CABINET";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String cabinetId) throws Exception{
		 String sql ="DELETE FROM T_CABINET WHERE CABINET_ID=?";
		 Object[] values = new Object[] { cabinetId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(Cabinet cabinet) throws Exception{
		 String sql ="UPDATE T_CABINET SET SS_ID= ?,CABINET_MODEL= ?,ASSET_SN= ?,CABINET_WIDTH= ?,CABINET_HEIGHT= ?,BOX_NUMBER= ?,CABINET_STATUS= ?,CABINET_INDEX= ?,CABINET_CODE= ?,CABINET_TYPE= ? WHERE CABINET_ID=?";
		 Object[] values = new Object[] {cabinet.getSsId(),cabinet.getCabinetModel(),cabinet.getAssetSn(),cabinet.getCabinetWidth(),cabinet.getCabinetHeight(),cabinet.getBoxNumber(),cabinet.getCabinetStatus(),cabinet.getCabinetIndex(),cabinet.getCabinetCode(),cabinet.getCabinetType(),cabinet.getCabinetId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(Cabinet cabinet) throws Exception{
		 String sql ="INSERT INTO T_CABINET(CABINET_ID,SS_ID,CABINET_MODEL,ASSET_SN,CABINET_WIDTH,CABINET_HEIGHT,BOX_NUMBER,CABINET_STATUS,CABINET_INDEX,CABINET_CODE,CABINET_TYPE) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {cabinet.getCabinetId(),cabinet.getSsId(),cabinet.getCabinetModel(),cabinet.getAssetSn(),cabinet.getCabinetWidth(),cabinet.getCabinetHeight(),cabinet.getBoxNumber(),cabinet.getCabinetStatus(),cabinet.getCabinetIndex(),cabinet.getCabinetCode(),cabinet.getCabinetType()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public Cabinet fetch(Map map) throws Exception{
		Cabinet cabinet = new Cabinet();		
		cabinet.setCabinetId((String)map.get("CABINET_ID"));
		cabinet.setSsId((String)map.get("SS_ID"));
		cabinet.setCabinetModel((String)map.get("CABINET_MODEL"));
		cabinet.setAssetSn((String)map.get("ASSET_SN"));
		cabinet.setCabinetWidth(Integer.parseInt(map.get("CABINET_WIDTH").toString()));
		cabinet.setCabinetHeight(Integer.parseInt(map.get("CABINET_HEIGHT").toString()));
		cabinet.setBoxNumber(Integer.parseInt(map.get("BOX_NUMBER").toString()));
		cabinet.setCabinetStatus(Integer.parseInt(map.get("CABINET_STATUS").toString()));
		cabinet.setCabinetIndex((String)map.get("CABINET_INDEX"));
		cabinet.setCabinetCode((String)map.get("CABINET_CODE"));
		cabinet.setCabinetType(Integer.parseInt(map.get("CABINET_TYPE").toString()));
		return cabinet;
	}
}
