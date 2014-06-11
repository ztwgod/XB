package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IDictionaryTypeDao;
import  cn.com.xb.domain.base.DictionaryType;

public class DictionaryTypeDaoImpl implements IDictionaryTypeDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<DictionaryType> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_DICTIONARY_TYPE";
		 List<DictionaryType> list = new ArrayList<DictionaryType>();
		 List<DictionaryType> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 DictionaryType dictionarytype = fetch(map); 
			 list.add(dictionarytype); 
		 }
		 return list;
	}
	
	public DictionaryType loadDictionaryTypeBytypeId(String typeId) throws Exception {
		 DictionaryType dictionarytype = null;
		 String sql ="SELECT * FROM T_DICTIONARY_TYPE WHERE TYPE_ID = ? ";
		 Object[] values = new Object[]{typeId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 dictionarytype = fetch(map);
		 return dictionarytype;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_DICTIONARY_TYPE";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String typeId) throws Exception{
		 String sql ="DELETE FROM T_DICTIONARY_TYPE WHERE TYPE_ID=?";
		 Object[] values = new Object[] { typeId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(DictionaryType dictionarytype) throws Exception{
		 String sql ="UPDATE T_DICTIONARY_TYPE SET TYPE_NAME= ? WHERE TYPE_ID=?";
		 Object[] values = new Object[] {dictionarytype.getTypeName(),dictionarytype.getTypeId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(DictionaryType dictionarytype) throws Exception{
		 String sql ="INSERT INTO T_DICTIONARY_TYPE(TYPE_ID,TYPE_NAME) VALUES(?,?)";
		 Object[] values = new Object[] {dictionarytype.getTypeId(),dictionarytype.getTypeName()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public DictionaryType fetch(Map map) throws Exception{
		DictionaryType dictionarytype = new DictionaryType();		
		dictionarytype.setTypeId((String)map.get("TYPE_ID"));
		dictionarytype.setTypeName((String)map.get("TYPE_NAME"));
		return dictionarytype;
	}
}
