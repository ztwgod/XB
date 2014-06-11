package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IModuleDao;
import  cn.com.xb.domain.base.Module;

public class ModuleDaoImpl implements IModuleDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<Module> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_MODULE";
		 List<Module> list = new ArrayList<Module>();
		 List<Module> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 Module module = fetch(map); 
			 list.add(module); 
		 }
		 return list;
	}
	
	public Module loadModuleBymoduleId(String moduleId) throws Exception {
		 Module module = null;
		 String sql ="SELECT * FROM T_MODULE WHERE MODULE_ID = ? ";
		 Object[] values = new Object[]{moduleId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 module = fetch(map);
		 return module;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_MODULE";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String moduleId) throws Exception{
		 String sql ="DELETE FROM T_MODULE WHERE MODULE_ID=?";
		 Object[] values = new Object[] { moduleId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(Module module) throws Exception{
		 String sql ="UPDATE T_MODULE SET MODULE_CODE= ?,PARENT_M_ID= ?,MODULE_NAME= ?,MODULE_LINK= ?,MODULE_DESC= ?,MODULE_LEVEL= ?,SHOW_SEQ= ?,MODULE_TYPE= ?,CREATE_TIME= ?,CREATOR= ?,ENABLE_TIME= ?,STATUS= ? WHERE MODULE_ID=?";
		 Object[] values = new Object[] {module.getModuleCode(),module.getParentMId(),module.getModuleName(),module.getModuleLink(),module.getModuleDesc(),module.getModuleLevel(),module.getShowSeq(),module.getModuleType(),module.getCreateTime(),module.getCreator(),module.getEnableTime(),module.getStatus(),module.getModuleId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(Module module) throws Exception{
		 String sql ="INSERT INTO T_MODULE(MODULE_ID,MODULE_CODE,PARENT_M_ID,MODULE_NAME,MODULE_LINK,MODULE_DESC,MODULE_LEVEL,SHOW_SEQ,MODULE_TYPE,CREATE_TIME,CREATOR,ENABLE_TIME,STATUS) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {module.getModuleId(),module.getModuleCode(),module.getParentMId(),module.getModuleName(),module.getModuleLink(),module.getModuleDesc(),module.getModuleLevel(),module.getShowSeq(),module.getModuleType(),module.getCreateTime(),module.getCreator(),module.getEnableTime(),module.getStatus()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public Module fetch(Map map) throws Exception{
		Module module = new Module();		
		module.setModuleId((String)map.get("MODULE_ID"));
		module.setModuleCode((String)map.get("MODULE_CODE"));
		module.setParentMId((String)map.get("PARENT_M_ID"));
		module.setModuleName((String)map.get("MODULE_NAME"));
		module.setModuleLink((String)map.get("MODULE_LINK"));
		module.setModuleDesc((String)map.get("MODULE_DESC"));
		module.setModuleLevel(Integer.parseInt(map.get("MODULE_LEVEL").toString()));
		module.setShowSeq(Integer.parseInt(map.get("SHOW_SEQ").toString()));
		module.setModuleType(Integer.parseInt(map.get("MODULE_TYPE").toString()));
		Timestamp createTime = (Timestamp)map.get("CREATE_TIME");
		if(null == createTime){
			module.setCreateTime(null);
		}else{
			module.setCreateTime(new Timestamp(createTime.getTime()));
		}
		module.setCreator((String)map.get("CREATOR"));
		Timestamp enableTime = (Timestamp)map.get("ENABLE_TIME");
		if(null == enableTime){
			module.setEnableTime(null);
		}else{
			module.setEnableTime(new Timestamp(enableTime.getTime()));
		}
		module.setStatus(Integer.parseInt(map.get("STATUS").toString()));
		return module;
	}
}
