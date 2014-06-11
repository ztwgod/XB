package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IVocherDao;
import  cn.com.xb.domain.base.Vocher;

public class VocherDaoImpl implements IVocherDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<Vocher> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_VOCHER";
		 List<Vocher> list = new ArrayList<Vocher>();
		 List<Vocher> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 Vocher vocher = fetch(map); 
			 list.add(vocher); 
		 }
		 return list;
	}
	
	public Vocher loadVocherByvoucherId(String voucherId) throws Exception {
		 Vocher vocher = null;
		 String sql ="SELECT * FROM T_VOCHER WHERE VOUCHER_ID = ? ";
		 Object[] values = new Object[]{voucherId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 vocher = fetch(map);
		 return vocher;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_VOCHER";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String voucherId) throws Exception{
		 String sql ="DELETE FROM T_VOCHER WHERE VOUCHER_ID=?";
		 Object[] values = new Object[] { voucherId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(Vocher vocher) throws Exception{
		 String sql ="UPDATE T_VOCHER SET USER_ID= ?,ACCOUNT= ?,TOTAL= ?,USED_TOTAL= ?,VALID_DATE= ?,STATUS= ? WHERE VOUCHER_ID=?";
		 Object[] values = new Object[] {vocher.getUserId(),vocher.getAccount(),vocher.getTotal(),vocher.getUsedTotal(),vocher.getValidDate(),vocher.getStatus(),vocher.getVoucherId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(Vocher vocher) throws Exception{
		 String sql ="INSERT INTO T_VOCHER(VOUCHER_ID,USER_ID,ACCOUNT,TOTAL,USED_TOTAL,VALID_DATE,STATUS) VALUES(?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {vocher.getVoucherId(),vocher.getUserId(),vocher.getAccount(),vocher.getTotal(),vocher.getUsedTotal(),vocher.getValidDate(),vocher.getStatus()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public Vocher fetch(Map map) throws Exception{
		Vocher vocher = new Vocher();		
		vocher.setVoucherId((String)map.get("VOUCHER_ID"));
		vocher.setUserId((String)map.get("USER_ID"));
		vocher.setAccount(Double.parseDouble(map.get("ACCOUNT").toString()));
		vocher.setTotal(Integer.parseInt(map.get("TOTAL").toString()));
		vocher.setUsedTotal(Integer.parseInt(map.get("USED_TOTAL").toString()));
		Timestamp validDate = (Timestamp)map.get("VALID_DATE");
		if(null == validDate){
			vocher.setValidDate(null);
		}else{
			vocher.setValidDate(new Timestamp(validDate.getTime()));
		}
		vocher.setStatus(Integer.parseInt(map.get("STATUS").toString()));
		return vocher;
	}
}
