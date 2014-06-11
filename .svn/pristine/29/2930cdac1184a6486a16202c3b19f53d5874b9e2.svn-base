package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.FlagDictionaryDaoImpl;
import cn.com.xb.daox.IFlagDictionaryDaox;
import cn.com.xb.domain.base.FlagDictionary;

public class FlagDictionaryDaoxImpl extends FlagDictionaryDaoImpl implements IFlagDictionaryDaox {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<FlagDictionary> loadDictionaryByTypeIdAndStauts(String typeId,int status) throws Exception {
		 String sql ="SELECT * FROM T_FLAG_DICTIONARY WHERE TYPE_ID = ? AND STATUS = ? ";
		 Object[] values = new Object[]{typeId,status};
		 List<FlagDictionary> list = new ArrayList<FlagDictionary>();
		 List<FlagDictionary> mapList = jdbcTemplate.queryForList(sql,values);
		 Iterator it = mapList.iterator();
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 FlagDictionary flagdictionary = fetch(map); 
			 list.add(flagdictionary); 
		 }
		 return list;
	}

	public List<FlagDictionary> loadDictionaryByTypeId(String typeId)throws Exception {

		 String sql ="SELECT * FROM T_FLAG_DICTIONARY WHERE TYPE_ID = ?";
		 Object[] values = new Object[]{typeId};
		 List<FlagDictionary> list = new ArrayList<FlagDictionary>();
		 List<FlagDictionary> mapList = jdbcTemplate.queryForList(sql,values);
		 Iterator it = mapList.iterator();
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 FlagDictionary flagdictionary = fetch(map); 
			 list.add(flagdictionary); 
		 }
		 return list;
	}
}
