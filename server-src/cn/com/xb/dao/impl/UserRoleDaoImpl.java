package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IUserRoleDao;
import  cn.com.xb.domain.base.UserRole;

public class UserRoleDaoImpl implements IUserRoleDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<UserRole> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_USER_ROLE";
		 List<UserRole> list = new ArrayList<UserRole>();
		 List<UserRole> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 UserRole userrole = fetch(map); 
			 list.add(userrole); 
		 }
		 return list;
	}
	
	public UserRole loadUserRoleByroleId(String roleId) throws Exception {
		 UserRole userrole = null;
		 String sql ="SELECT * FROM T_USER_ROLE WHERE ROLE_ID = ? ";
		 Object[] values = new Object[]{roleId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 userrole = fetch(map);
		 return userrole;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_USER_ROLE";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String roleId) throws Exception{
		 String sql ="DELETE FROM T_USER_ROLE WHERE ROLE_ID=?";
		 Object[] values = new Object[] { roleId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(UserRole userrole) throws Exception{
		 String sql ="UPDATE T_USER_ROLE SET USER_ID= ? WHERE ROLE_ID=?";
		 Object[] values = new Object[] {userrole.getUserId(),userrole.getRoleId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(UserRole userrole) throws Exception{
		 String sql ="INSERT INTO T_USER_ROLE(USER_ID,ROLE_ID) VALUES(?,?)";
		 Object[] values = new Object[] {userrole.getUserId(),userrole.getRoleId()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public UserRole fetch(Map map) throws Exception{
		UserRole userrole = new UserRole();		
		userrole.setUserId((String)map.get("USER_ID"));
		userrole.setRoleId((String)map.get("ROLE_ID"));
		return userrole;
	}
}
