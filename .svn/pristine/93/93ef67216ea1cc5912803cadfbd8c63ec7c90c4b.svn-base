package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IUserDao;
import  cn.com.xb.domain.base.User;

public class UserDaoImpl implements IUserDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<User> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_USER";
		 List<User> list = new ArrayList<User>();
		 List<User> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 User user = fetch(map); 
			 list.add(user); 
		 }
		 return list;
	}
	
	public User loadUserByuserId(String userId) throws Exception {
		 User user = null;
		 String sql ="SELECT * FROM T_USER WHERE USER_ID = ? ";
		 Object[] values = new Object[]{userId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 user = fetch(map);
		 return user;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_USER";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String userId) throws Exception{
		 String sql ="DELETE FROM T_USER WHERE USER_ID=?";
		 Object[] values = new Object[] { userId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(User user) throws Exception{
		 String sql ="UPDATE T_USER SET USER_ACCOUNT= ?,PASSWORD= ?,USER_TYPE= ?,USER_NAME= ?,GENDER= ?,PAPERWORK_TYPE= ?,PAPERWORK_NUM= ?,MOBILE_NUMBER= ?,EMAIL= ?,QQ= ?,WB= ?,WEIXIN= ?,HOUSEHOLD_REGISTER_ADDRESS= ?,HABITUAL_RESIDENCE= ?,ZIP_CODE= ?,CREATE_TIME= ?,LAST_LOGIN_TIME= ?,STATUS= ? WHERE USER_ID=?";
		 Object[] values = new Object[] {user.getUserAccount(),user.getPassword(),user.getUserType(),user.getUserName(),user.getGender(),user.getPaperworkType(),user.getPaperworkNum(),user.getMobileNumber(),user.getEmail(),user.getQq(),user.getWb(),user.getWeixin(),user.getHouseholdRegisterAddress(),user.getHabitualResidence(),user.getZipCode(),user.getCreateTime(),user.getLastLoginTime(),user.getStatus(),user.getUserId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(User user) throws Exception{
		 String sql ="INSERT INTO T_USER(USER_ID,USER_ACCOUNT,PASSWORD,USER_TYPE,USER_NAME,GENDER,PAPERWORK_TYPE,PAPERWORK_NUM,MOBILE_NUMBER,EMAIL,QQ,WB,WEIXIN,HOUSEHOLD_REGISTER_ADDRESS,HABITUAL_RESIDENCE,ZIP_CODE,CREATE_TIME,LAST_LOGIN_TIME,STATUS) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {user.getUserId(),user.getUserAccount(),user.getPassword(),user.getUserType(),user.getUserName(),user.getGender(),user.getPaperworkType(),user.getPaperworkNum(),user.getMobileNumber(),user.getEmail(),user.getQq(),user.getWb(),user.getWeixin(),user.getHouseholdRegisterAddress(),user.getHabitualResidence(),user.getZipCode(),user.getCreateTime(),user.getLastLoginTime(),user.getStatus()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public User fetch(Map map) throws Exception{
		User user = new User();		
		user.setUserId((String)map.get("USER_ID"));
		user.setUserAccount((String)map.get("USER_ACCOUNT"));
		user.setPassword((String)map.get("PASSWORD"));
		user.setUserType(Integer.parseInt(map.get("USER_TYPE").toString()));
		user.setUserName((String)map.get("USER_NAME"));
		user.setGender(Integer.parseInt(map.get("GENDER").toString()));
		user.setPaperworkType(Integer.parseInt(map.get("PAPERWORK_TYPE").toString()));
		user.setPaperworkNum((String)map.get("PAPERWORK_NUM"));
		user.setMobileNumber((String)map.get("MOBILE_NUMBER"));
		user.setEmail((String)map.get("EMAIL"));
		user.setQq((String)map.get("QQ"));
		user.setWb((String)map.get("WB"));
		user.setWeixin((String)map.get("WEIXIN"));
		user.setHouseholdRegisterAddress((String)map.get("HOUSEHOLD_REGISTER_ADDRESS"));
		user.setHabitualResidence((String)map.get("HABITUAL_RESIDENCE"));
		user.setZipCode((String)map.get("ZIP_CODE"));
		Timestamp createTime = (Timestamp)map.get("CREATE_TIME");
		if(null == createTime){
			user.setCreateTime(null);
		}else{
			user.setCreateTime(new Timestamp(createTime.getTime()));
		}
		Timestamp lastLoginTime = (Timestamp)map.get("LAST_LOGIN_TIME");
		if(null == lastLoginTime){
			user.setLastLoginTime(null);
		}else{
			user.setLastLoginTime(new Timestamp(lastLoginTime.getTime()));
		}
		user.setStatus(Integer.parseInt(map.get("STATUS").toString()));
		return user;
	}
}
