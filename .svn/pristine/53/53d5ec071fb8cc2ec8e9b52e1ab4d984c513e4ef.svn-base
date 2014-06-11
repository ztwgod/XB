package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import cn.com.xb.dao.impl.UserDaoImpl;
import cn.com.xb.daox.IUserDaox;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.base.Userx;
import cn.com.xb.util.StringUtil;

public class UserDaoxImpl extends UserDaoImpl implements IUserDaox{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int loadItemsByUserAccount(String userAccount) {
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_USER WHERE USER_ACCOUNT = ? ";
		Object[] values = new Object[]{userAccount};
		items = jdbcTemplate.queryForInt(sql,values);
		return items;
	}

	public List<User> loadUserLimit(User user, int start, int end) throws Exception {
		StringBuilder sql =  new StringBuilder("SELECT * FROM T_USER WHERE USER_TYPE!=2 ");
		
		List<Object> params = new ArrayList<Object>();		
		if(!"".equals(user.getUserAccount())){
			sql.append(" AND USER_ACCOUNT LIKE '%").append(user.getUserAccount()).append("%'");
			//params.add(user.getUserAccount());
		}		
		if(!"".equals(user.getUserName())){
			sql.append(" AND USER_NAME LIKE '%").append(user.getUserName()).append("%'");
			//params.add(user.getUserName());
		}		
		if(!"".equals(user.getMobileNumber())){
			sql.append(" AND MOBILE_NUMBER = ? ");
			params.add(user.getMobileNumber());
		}		
		if(0!=user.getStatus()){
			sql.append(" AND STATUS = ? ");
			params.add(user.getStatus());
		}		
		if(0!=user.getUserType()){
			sql.append(" AND USER_TYPE = ? ");
			params.add(user.getUserType());
		}
		
		sql.append(" ORDER BY CREATE_TIME DESC LIMIT ?,? ");
		params.add(start);
		params.add(end);
		
		List<User> list = new ArrayList<User>();
		List<User> mapList = jdbcTemplate.queryForList(sql.toString(),params.toArray());
		Iterator it = mapList.iterator();		 
		while (it.hasNext()) { 
			Map map = (Map) it.next();
			User _user = fetch(map);
			list.add(_user); 
		}
		return list;
	}
	
	public int loadItems(User user) throws Exception{
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) CNT FROM T_USER WHERE USER_TYPE!=2 ");
		
		List<Object> params = new ArrayList<Object>();		
		if(!"".equals(user.getUserAccount())){
			sql.append(" AND USER_ACCOUNT LIKE '%").append(user.getUserAccount()).append("%'");
			//params.add(user.getUserAccount());
		}		
		if(!"".equals(user.getUserName())){
			sql.append(" AND USER_NAME LIKE '%").append(user.getUserName()).append("%'");
			//params.add(user.getUserName());
		}
		if(!"".equals(user.getMobileNumber())){
			sql.append(" AND MOBILE_NUMBER = ? ");
			params.add(user.getMobileNumber());
		}		
		if(0!=user.getStatus()){
			sql.append(" AND STATUS = ? ");
			params.add(user.getStatus());
		}		
		if(0!=user.getUserType()){
			sql.append(" AND USER_TYPE = ? ");
			params.add(user.getUserType());
		}
		
		int items = jdbcTemplate.queryForInt(sql.toString(),params.toArray());
		return items;
	}

	public User loadPortalUser(User user) throws Exception {
		String sql ="SELECT * FROM T_USER A,T_P_CLIENT B WHERE A.USER_ID = B.USER_ID AND A.USER_ACCOUNT = ? AND A.PASSWORD = ?";
		Object[] values = new Object[]{user.getUserAccount(),user.getPassword()};
		Map map = null;
		try{ 
			map = jdbcTemplate.queryForMap(sql, values);
		} catch (DataAccessException e) {
			return null;
		}
		User _user = fetch(map);
		return _user;
	 }


	public void updateLastLoginTime(User user) throws Exception {
		 String sql ="UPDATE T_USER SET LAST_LOGIN_TIME= ? WHERE USER_ID=? ";
		 Object[] values = new Object[] {user.getLastLoginTime(),user.getUserId()};
		 jdbcTemplate.update(sql, values);
	}

	public User loadPlatUser(User user) throws Exception {
		String sql ="SELECT * FROM T_USER A,T_P_SYS B WHERE A.USER_ID = B.USER_ID AND A.USER_ACCOUNT = ? AND A.PASSWORD = ?";
		Object[] values = new Object[]{user.getUserAccount(),user.getPassword()};
		Map map = null;
		try{ 
			map = jdbcTemplate.queryForMap(sql, values);
		} catch (DataAccessException e) {
			return null;
		}
		User _user = fetch(map);
		return _user;
	 }

	public List<Userx> loadSystemUser(User user,String ssId, Page page) throws Exception {
		StringBuilder sql =  new StringBuilder();
		sql.append(" SELECT A.USER_ID,A.USER_ACCOUNT,A.USER_TYPE,A.USER_NAME,A.MOBILE_NUMBER,C.SS_ID,C.SS_ID=? CK ");
		sql.append(" FROM T_USER A,T_P_SYS B LEFT JOIN (SELECT * FROM T_SYSUSER_STORAGESTATION D WHERE D.SS_ID = ? ) C ON C.USER_ID = B.USER_ID ,T_USER_ROLE E");
		sql.append(" WHERE A.USER_ID = B.USER_ID AND E.USER_ID = A.USER_ID AND E.ROLE_ID = '141bfe241d429158' ");
		
		List<Object> params = new ArrayList<Object>();
		params.add(ssId);
		params.add(ssId);
		
		if(!"".equals(user.getUserAccount())){
			sql.append(" AND USER_ACCOUNT LIKE '%").append(user.getUserAccount()).append("%'");
		}	
		if(!"".equals(user.getUserName())){
			sql.append(" AND USER_NAME LIKE '%").append(user.getUserName()).append("%'");
		}
		
		sql.append(" ORDER BY (C.SS_ID=?) DESC LIMIT ?,? ");
		params.add(ssId);
		params.add(page.getStartItems());
		params.add(page.getPageSize());
		
		List<Userx> list = new ArrayList<Userx>();
		List<Userx> mapList = jdbcTemplate.queryForList(sql.toString(),params.toArray());
		Iterator it = mapList.iterator();		 
		while (it.hasNext()) { 
			Map map = (Map) it.next();
			Userx _user = new Userx();		
			_user.setUserId((String)map.get("USER_ID"));
			_user.setUserAccount((String)map.get("USER_ACCOUNT"));
			_user.setUserType(Integer.parseInt(map.get("USER_TYPE").toString()));
			_user.setUserName((String)map.get("USER_NAME"));
			_user.setMobileNumber((String)map.get("MOBILE_NUMBER"));
			String ck = map.get("CK")==null?"":map.get("CK").toString();
			_user.setCheck(ck);			
			list.add(_user); 
		}
		return list;
	}

	public int loadSystemUserItems(User user,String ssId) throws Exception {
		StringBuilder sql =  new StringBuilder();
		sql.append(" SELECT COUNT(*) ");
		sql.append(" FROM T_USER A,T_P_SYS B LEFT JOIN (SELECT * FROM T_SYSUSER_STORAGESTATION D WHERE D.SS_ID = ? ) C ON C.USER_ID = B.USER_ID ,T_USER_ROLE E ");
		sql.append("  WHERE A.USER_ID = B.USER_ID AND E.USER_ID = A.USER_ID AND E.ROLE_ID = '141bfe241d429158' ");
		
		List<Object> params = new ArrayList<Object>();
		params.add(ssId);
		
		if(!"".equals(user.getUserAccount())){
			sql.append(" AND USER_ACCOUNT LIKE '%").append(user.getUserAccount()).append("%'");
		}	
		if(!"".equals(user.getUserName())){
			sql.append(" AND USER_NAME LIKE '%").append(user.getUserName()).append("%'");
		}
		return jdbcTemplate.queryForInt(sql.toString(),params.toArray());
	}

	public User getSystemUserById(String ssId) throws Exception {
		String sql = "SELECT A.USER_ACCOUNT,A.USER_ID FROM T_USER A,T_SYSUSER_STORAGESTATION B WHERE A.USER_ID = B.USER_ID AND B.SS_ID = ? ";
		String[] values = new String[]{ssId};
		Map map = null;
		try{ 
			map = jdbcTemplate.queryForMap(sql, values);
		} catch (DataAccessException e) {
			return null;
		}
		User user = new User();		
		user.setUserId((String)map.get("USER_ID"));
		user.setUserAccount((String)map.get("USER_ACCOUNT"));
		return user;
	}

	@Override
	public void updateUserStatus(String userId, int status) throws Exception
	{
		StringBuffer sql = new StringBuffer("UPDATE T_USER SET STATUS = ? WHERE USER_ID = ?");
		jdbcTemplate.update(sql.toString(), new Object[]{status, userId});
	}

	@Override
	public void updateUserInfo(User user) throws Exception
	{
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();

		sql.append("UPDATE T_USER SET");
		if(StringUtil.isNotBlank(user.getUserAccount()))
		{
			sql.append(" USER_ACCOUNT = ?");
			params.add(user.getUserAccount());
		}
		if(StringUtil.isNotBlank(user.getPassword()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " PASSWORD = ?");
			params.add(user.getPassword());
		}
		if(user.getUserType() != 0)
		{
			sql.append((params.size() != 0 ? " ," : "") + " USER_TYPE = ?");
			params.add(user.getUserType());
		}
		if(StringUtil.isNotBlank(user.getUserName()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " USER_NAME = ?");
			params.add(user.getUserName());
		}
		if(user.getGender() != 0)
		{
			sql.append((params.size() != 0 ? " ," : "") + " GENDER = ?");
			params.add(user.getGender());
		}
		if(user.getPaperworkType() != 0)
		{
			sql.append((params.size() != 0 ? " ," : "") + " PAPERWORK_TYPE = ?");
			params.add(user.getPaperworkType());
		}
		if(StringUtil.isNotBlank(user.getPaperworkNum()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " PAPERWORK_NUM = ?");
			params.add(user.getPaperworkNum());
		}
		if(StringUtil.isNotBlank(user.getMobileNumber()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " MOBILE_NUMBER = ?");
			params.add(user.getMobileNumber());
		}
		if(StringUtil.isNotBlank(user.getEmail()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " EMAIL = ?");
			params.add(user.getEmail());
		}
		if(StringUtil.isNotBlank(user.getQq()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " QQ = ?");
			params.add(user.getQq());
		}
		if(StringUtil.isNotBlank(user.getWb()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " WB = ?");
			params.add(user.getWb());
		}
		if(StringUtil.isNotBlank(user.getWeixin()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " WEIXIN = ?");
			params.add(user.getWeixin());
		}
		if(StringUtil.isNotBlank(user.getHouseholdRegisterAddress()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " HOUSEHOLD_REGISTER_ADDRESS = ?");
			params.add(user.getHouseholdRegisterAddress());
		}
		if(StringUtil.isNotBlank(user.getHabitualResidence()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " HABITUAL_RESIDENCE = ?");
			params.add(user.getHabitualResidence());
		}
		if(StringUtil.isNotBlank(user.getZipCode()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " ZIP_CODE = ?");
			params.add(user.getZipCode());
		}
		if(user.getStatus() != 0)
		{
			sql.append((params.size() != 0 ? " ," : "") + " STATUS = ?");
			params.add(user.getStatus());
		}
		sql.append(" WHERE USER_ID = ?");
		
		params.add(user.getUserId());
		
		jdbcTemplate.update(sql.toString(), params.toArray());
	}

	public String loadUserMobileByBoxId(String SSid,String boxCode) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT U.MOBILE_NUMBER FROM T_USER U WHERE U.USER_ID = ( ");
		sql.append(" SELECT T.ADDRESSEE_ID FROM T_BOX_INFO I,T_TRANSACTION T WHERE I.BOX_ID = T.BOX_ID" +
				"  AND T.TRANS_STATUS = 2 AND I.SS_ID = ? AND I.BOX_CODE = ? ) ");
		
		Map map = null;
		try {
			map= jdbcTemplate.queryForMap(sql.toString(),new String[]{SSid,boxCode});
		} catch (Exception e) {
			return null;
		}
		String mobile = (String) map.get("MOBILE_NUMBER");
		return mobile;
	}
	
	
	public String getUserIdByMobileNum(String mobileNum) throws Exception
	{
		String userId = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT U.USER_ID FROM T_USER U WHERE U.MOBILE_NUMBER = ?");

		List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{mobileNum});
		if(null != list && list.size() != 0)
		{
			userId = StringUtil.formatStringTrimToNull(((Map) list.get(0)).get("USER_ID"));
		}
		
		return userId;
	}
}
