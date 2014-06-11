package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.ISnapVerifyCodeDao;
import  cn.com.xb.domain.base.SnapVerifyCode;

public class SnapVerifyCodeDaoImpl implements ISnapVerifyCodeDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<SnapVerifyCode> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_SNAP_VERIFY_CODE";
		 List<SnapVerifyCode> list = new ArrayList<SnapVerifyCode>();
		 List<SnapVerifyCode> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 SnapVerifyCode snapverifycode = fetch(map); 
			 list.add(snapverifycode); 
		 }
		 return list;
	}
	
	public SnapVerifyCode loadSnapVerifyCodeByid(String id) throws Exception {
		 SnapVerifyCode snapverifycode = null;
		 String sql ="SELECT * FROM T_SNAP_VERIFY_CODE WHERE ID = ? ";
		 Object[] values = new Object[]{id};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 snapverifycode = fetch(map);
		 return snapverifycode;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_SNAP_VERIFY_CODE";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String id) throws Exception{
		 String sql ="DELETE FROM T_SNAP_VERIFY_CODE WHERE ID=?";
		 Object[] values = new Object[] { id };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(SnapVerifyCode snapverifycode) throws Exception{
		 String sql ="UPDATE T_SNAP_VERIFY_CODE SET MOBILE_NUMBER= ?,VERIFY_CODE= ?,TAKE_EFFECT_TIME= ?,EFFECTIVE_LEN= ? WHERE ID=?";
		 Object[] values = new Object[] {snapverifycode.getMobileNumber(),snapverifycode.getVerifyCode(),snapverifycode.getTakeEffectTime(),snapverifycode.getEffectiveLen(),snapverifycode.getId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(SnapVerifyCode snapverifycode) throws Exception{
		 String sql ="INSERT INTO T_SNAP_VERIFY_CODE(ID,MOBILE_NUMBER,VERIFY_CODE,TAKE_EFFECT_TIME,EFFECTIVE_LEN) VALUES(?,?,?,?,?)";
		 Object[] values = new Object[] {snapverifycode.getId(),snapverifycode.getMobileNumber(),snapverifycode.getVerifyCode(),snapverifycode.getTakeEffectTime(),snapverifycode.getEffectiveLen()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public SnapVerifyCode fetch(Map map) throws Exception{
		SnapVerifyCode snapverifycode = new SnapVerifyCode();		
		snapverifycode.setId((String)map.get("ID"));
		snapverifycode.setMobileNumber((String)map.get("MOBILE_NUMBER"));
		snapverifycode.setVerifyCode((String)map.get("VERIFY_CODE"));
		Timestamp takeEffectTime = (Timestamp)map.get("TAKE_EFFECT_TIME");
		if(null == takeEffectTime){
			snapverifycode.setTakeEffectTime(null);
		}else{
			snapverifycode.setTakeEffectTime(new Timestamp(takeEffectTime.getTime()));
		}
		snapverifycode.setEffectiveLen(Integer.parseInt(map.get("EFFECTIVE_LEN").toString()));
		return snapverifycode;
	}
}
