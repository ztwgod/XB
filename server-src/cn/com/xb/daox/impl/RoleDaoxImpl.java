package cn.com.xb.daox.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.RoleDaoImpl;
import cn.com.xb.daox.IRoleDaox;
import cn.com.xb.domain.base.Role;
import cn.com.xb.util.StringUtil;

public class RoleDaoxImpl extends RoleDaoImpl implements IRoleDaox
{
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public int getRoleListSize() throws Exception
	{
		int count = 0;
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT COUNT(1) CNT FROM T_ROLE");
		
		try
		{
			count = jdbcTemplate.queryForInt(sql.toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}


	@Override
	public List<Role> getRoleList(int startInd, int pageSize) throws Exception
	{
		List<Role> roles = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ROLE_ID, ROLE_NAME, ROLE_TYPE, ROLE_DESC, CREATE_TIME, CREATOR, LAST_UPDATE_TIME, LAST_UPDATE_USER, STATUS");
		sql.append(" FROM T_ROLE ORDER BY LAST_UPDATE_TIME DESC LIMIT ?, ?");
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{startInd, pageSize});
			
			if(null != list && list.size() != 0)
			{
				roles = new ArrayList<Role>();
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					Map map = (Map) it.next();
					
					Role role = new Role();
					role.setRoleId(StringUtil.formatStringTrimToNull(map.get("ROLE_ID")));
					role.setRoleName(StringUtil.formatStringTrimToNull(map.get("ROLE_NAME")));
					role.setRoleType(StringUtil.formatStringToInteger(map.get("ROLE_TYPE"), 0));
					role.setRoleDesc(StringUtil.formatStringTrimToNull(map.get("ROLE_DESC")));
					role.setCreator(StringUtil.formatStringTrimToNull(map.get("CREATOR")));
					role.setCreateTime((Timestamp) map.get("CREATE_TIME"));
					role.setLastUpdateUser(StringUtil.formatStringTrimToNull(map.get("LAST_UPDATE_USER")));
					role.setLastUpdateTime((Timestamp) map.get("LAST_UPDATE_TIME"));
					role.setStatus(StringUtil.formatStringToInteger(map.get("STATUS"), 2));
					
					roles.add(role);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return roles;
	}


	@Override
	public void deleteRoleModuleByRoleId(String roleId) throws Exception
	{
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM T_ROLE_MODULE WHERE ROLE_ID = ?");
		
		try
		{
			jdbcTemplate.update(sql.toString(), new Object[]{roleId});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	@Override
	public void insertRoleModuleByRoleId(String roleId, List moduleIds) throws Exception
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO T_ROLE_MODULE(ROLE_ID, MODULE_ID) VALUES");
		
		List<String> params = new ArrayList<String>();
		Iterator it = moduleIds.iterator();
		int i = 0;
		while(it.hasNext())
		{
			sql.append((i++ > 0 ? "," : "")+"(?, ?)");
			params.add(roleId);
			params.add((String) it.next());
		}
		
		try
		{
			jdbcTemplate.update(sql.toString(), params.toArray());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int getRoleItems(String roleId) throws Exception {
		StringBuilder sql =  new StringBuilder();
		sql.append("SELECT COUNT(*) FROM T_ROLE WHERE STATUS = 1 AND ROLE_ID IN ( ")
		.append(roleId).append(")");
		
		return jdbcTemplate.queryForInt(sql.toString());	
	}


	public List<Role> getRoles(Role role) throws Exception {
		String sql ="SELECT * FROM T_ROLE WHERE STATUS =1 AND ROLE_TYPE = ? ";
		 List<Role> list = new ArrayList<Role>();
		 Object[] value = new Object[]{role.getRoleType()};
		 List<Role> mapList = jdbcTemplate.queryForList(sql,value);
		 Iterator it = mapList.iterator();		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 Role _role = fetch(map); 
			 list.add(_role); 
		 }
		 return list;
	}

}
