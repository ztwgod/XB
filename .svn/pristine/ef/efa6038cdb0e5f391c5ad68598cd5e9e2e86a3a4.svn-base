package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IFlagDictionaryDao;
import  cn.com.xb.domain.base.FlagDictionary;

public class FlagDictionaryDaoImpl implements IFlagDictionaryDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<FlagDictionary> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_FLAG_DICTIONARY";
		 List<FlagDictionary> list = new ArrayList<FlagDictionary>();
		 List<FlagDictionary> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 FlagDictionary flagdictionary = fetch(map); 
			 list.add(flagdictionary); 
		 }
		 return list;
	}
	
	public FlagDictionary loadFlagDictionaryBycode(int code) throws Exception {
		 FlagDictionary flagdictionary = null;
		 String sql ="SELECT * FROM T_FLAG_DICTIONARY WHERE CODE = ? ";
		 Object[] values = new Object[]{code};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 flagdictionary = fetch(map);
		 return flagdictionary;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_FLAG_DICTIONARY";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(int code) throws Exception{
		 String sql ="DELETE FROM T_FLAG_DICTIONARY WHERE CODE=?";
		 Object[] values = new Object[] { code };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(FlagDictionary flagdictionary) throws Exception{
		 String sql ="UPDATE T_FLAG_DICTIONARY SET NAME= ?,TYPE_ID= ?,DESCRIPTION= ?,STATUS= ? WHERE CODE=?";
		 Object[] values = new Object[] {flagdictionary.getName(),flagdictionary.getTypeId(),flagdictionary.getDescription(),flagdictionary.getStatus(),flagdictionary.getCode()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(FlagDictionary flagdictionary) throws Exception{
		 String sql ="INSERT INTO T_FLAG_DICTIONARY(CODE,NAME,TYPE_ID,DESCRIPTION,STATUS) VALUES(?,?,?,?,?)";
		 Object[] values = new Object[] {flagdictionary.getCode(),flagdictionary.getName(),flagdictionary.getTypeId(),flagdictionary.getDescription(),flagdictionary.getStatus()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public FlagDictionary fetch(Map map) throws Exception{
		FlagDictionary flagdictionary = new FlagDictionary();		
		flagdictionary.setCode(Integer.parseInt(map.get("CODE").toString()));
		flagdictionary.setName((String)map.get("NAME"));
		flagdictionary.setTypeId((String)map.get("TYPE_ID"));
		flagdictionary.setDescription((String)map.get("DESCRIPTION"));
		flagdictionary.setStatus(Integer.parseInt(map.get("STATUS").toString()));
		return flagdictionary;
	}
}
