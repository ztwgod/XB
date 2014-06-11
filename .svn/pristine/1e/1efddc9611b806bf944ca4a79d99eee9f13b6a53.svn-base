package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IRoleModuleDao;
import  cn.com.xb.domain.base.RoleModule;

public class RoleModuleDaoImpl implements IRoleModuleDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<RoleModule> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_ROLE_MODULE";
		 List<RoleModule> list = new ArrayList<RoleModule>();
		 List<RoleModule> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 RoleModule rolemodule = fetch(map); 
			 list.add(rolemodule); 
		 }
		 return list;
	}
	
	public RoleModule loadRoleModuleBymoduleId(String moduleId) throws Exception {
		 RoleModule rolemodule = null;
		 String sql ="SELECT * FROM T_ROLE_MODULE WHERE MODULE_ID = ? ";
		 Object[] values = new Object[]{moduleId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 rolemodule = fetch(map);
		 return rolemodule;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_ROLE_MODULE";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String moduleId) throws Exception{
		 String sql ="DELETE FROM T_ROLE_MODULE WHERE MODULE_ID=?";
		 Object[] values = new Object[] { moduleId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(RoleModule rolemodule) throws Exception{
		 String sql ="UPDATE T_ROLE_MODULE SET ROLE_ID= ? WHERE MODULE_ID=?";
		 Object[] values = new Object[] {rolemodule.getRoleId(),rolemodule.getModuleId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(RoleModule rolemodule) throws Exception{
		 String sql ="INSERT INTO T_ROLE_MODULE(ROLE_ID,MODULE_ID) VALUES(?,?)";
		 Object[] values = new Object[] {rolemodule.getRoleId(),rolemodule.getModuleId()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public RoleModule fetch(Map map) throws Exception{
		RoleModule rolemodule = new RoleModule();		
		rolemodule.setRoleId((String)map.get("ROLE_ID"));
		rolemodule.setModuleId((String)map.get("MODULE_ID"));
		return rolemodule;
	}
}
