package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IRoleDao;
import  cn.com.xb.domain.base.Role;

public class RoleDaoImpl implements IRoleDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<Role> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_ROLE";
		 List<Role> list = new ArrayList<Role>();
		 List<Role> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 Role role = fetch(map); 
			 list.add(role); 
		 }
		 return list;
	}
	
	public Role loadRoleByroleId(String roleId) throws Exception {
		 Role role = null;
		 String sql ="SELECT * FROM T_ROLE WHERE ROLE_ID = ? ";
		 Object[] values = new Object[]{roleId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 role = fetch(map);
		 return role;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_ROLE";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String roleId) throws Exception{
		 String sql ="DELETE FROM T_ROLE WHERE ROLE_ID=?";
		 Object[] values = new Object[] { roleId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(Role role) throws Exception{
		 String sql ="UPDATE T_ROLE SET ROLE_NAME= ?,ROLE_TYPE= ?,ROLE_DESC= ?,CREATE_TIME= ?,CREATOR= ?,LAST_UPDATE_TIME= ?,LAST_UPDATE_USER= ?,STATUS= ? WHERE ROLE_ID=?";
		 Object[] values = new Object[] {role.getRoleName(),role.getRoleType(),role.getRoleDesc(),role.getCreateTime(),role.getCreator(),role.getLastUpdateTime(),role.getLastUpdateUser(),role.getStatus(),role.getRoleId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(Role role) throws Exception{
		 String sql ="INSERT INTO T_ROLE(ROLE_ID,ROLE_NAME,ROLE_TYPE,ROLE_DESC,CREATE_TIME,CREATOR,LAST_UPDATE_TIME,LAST_UPDATE_USER,STATUS) VALUES(?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {role.getRoleId(),role.getRoleName(),role.getRoleType(),role.getRoleDesc(),role.getCreateTime(),role.getCreator(),role.getLastUpdateTime(),role.getLastUpdateUser(),role.getStatus()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public Role fetch(Map map) throws Exception{
		Role role = new Role();		
		role.setRoleId((String)map.get("ROLE_ID"));
		role.setRoleName((String)map.get("ROLE_NAME"));
		role.setRoleType(Integer.parseInt(map.get("ROLE_TYPE").toString()));
		role.setRoleDesc((String)map.get("ROLE_DESC"));
		Timestamp createTime = (Timestamp)map.get("CREATE_TIME");
		if(null == createTime){
			role.setCreateTime(null);
		}else{
			role.setCreateTime(new Timestamp(createTime.getTime()));
		}
		role.setCreator((String)map.get("CREATOR"));
		Timestamp lastUpdateTime = (Timestamp)map.get("LAST_UPDATE_TIME");
		if(null == lastUpdateTime){
			role.setLastUpdateTime(null);
		}else{
			role.setLastUpdateTime(new Timestamp(lastUpdateTime.getTime()));
		}
		role.setLastUpdateUser((String)map.get("LAST_UPDATE_USER"));
		role.setStatus(Integer.parseInt(map.get("STATUS").toString()));
		return role;
	}
}
