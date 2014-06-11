package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.UserRoleDaoImpl;
import cn.com.xb.daox.IUserRoleDaox;
import cn.com.xb.domain.base.UserRole;

public class UserRoleDaoxImpl extends UserRoleDaoImpl implements IUserRoleDaox {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void delteByUserId(String userId) throws Exception {
		 String sql ="DELETE FROM T_USER_ROLE WHERE USER_ID=?";
		 Object[] values = new Object[] { userId };
		 jdbcTemplate.update(sql, values);
	}

	public List<UserRole> loadUserRoleByUserId(String userId) throws Exception {
		String sql ="SELECT * FROM T_USER_ROLE WHERE USER_ID=?";
		 List<UserRole> list = new ArrayList<UserRole>();
		 Object[] values = new Object[]{userId};
		 List<UserRole> mapList = jdbcTemplate.queryForList(sql,values);
		 Iterator it = mapList.iterator();
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 UserRole userrole = fetch(map); 
			 list.add(userrole); 
		 }
		 return list;
	}
	
}
