package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IStoragestationModelDao;
import  cn.com.xb.domain.base.StoragestationModel;

public class StoragestationModelDaoImpl implements IStoragestationModelDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<StoragestationModel> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_STORAGESTATION_MODEL";
		 List<StoragestationModel> list = new ArrayList<StoragestationModel>();
		 List<StoragestationModel> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 StoragestationModel storagestationmodel = fetch(map); 
			 list.add(storagestationmodel); 
		 }
		 return list;
	}
	
	public StoragestationModel loadStoragestationModelBymodelId(String modelId) throws Exception {
		 StoragestationModel storagestationmodel = null;
		 String sql ="SELECT * FROM T_STORAGESTATION_MODEL WHERE MODEL_ID = ? ";
		 Object[] values = new Object[]{modelId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 storagestationmodel = fetch(map);
		 return storagestationmodel;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_STORAGESTATION_MODEL";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String modelId) throws Exception{
		 String sql ="DELETE FROM T_STORAGESTATION_MODEL WHERE MODEL_ID=?";
		 Object[] values = new Object[] { modelId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(StoragestationModel storagestationmodel) throws Exception{
		 String sql ="UPDATE T_STORAGESTATION_MODEL SET MODEL_ABB= ?,MODEL_FULL_CODE= ? WHERE MODEL_ID=?";
		 Object[] values = new Object[] {storagestationmodel.getModelAbb(),storagestationmodel.getModelFullCode(),storagestationmodel.getModelId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(StoragestationModel storagestationmodel) throws Exception{
		 String sql ="INSERT INTO T_STORAGESTATION_MODEL(MODEL_ID,MODEL_ABB,MODEL_FULL_CODE) VALUES(?,?,?)";
		 Object[] values = new Object[] {storagestationmodel.getModelId(),storagestationmodel.getModelAbb(),storagestationmodel.getModelFullCode()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public StoragestationModel fetch(Map map) throws Exception{
		StoragestationModel storagestationmodel = new StoragestationModel();		
		storagestationmodel.setModelId((String)map.get("MODEL_ID"));
		storagestationmodel.setModelAbb((String)map.get("MODEL_ABB"));
		storagestationmodel.setModelFullCode((String)map.get("MODEL_FULL_CODE"));
		return storagestationmodel;
	}
}
