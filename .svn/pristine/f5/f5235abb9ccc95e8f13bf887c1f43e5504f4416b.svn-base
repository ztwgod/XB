package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IIssuedAgencyDao;
import  cn.com.xb.domain.base.IssuedAgency;

public class IssuedAgencyDaoImpl implements IIssuedAgencyDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<IssuedAgency> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_ISSUED_AGENCY";
		 List<IssuedAgency> list = new ArrayList<IssuedAgency>();
		 List<IssuedAgency> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 IssuedAgency issuedagency = fetch(map); 
			 list.add(issuedagency); 
		 }
		 return list;
	}
	
	public IssuedAgency loadIssuedAgencyByagencyId(String agencyId) throws Exception {
		 IssuedAgency issuedagency = null;
		 String sql ="SELECT * FROM T_ISSUED_AGENCY WHERE AGENCY_ID = ? ";
		 Object[] values = new Object[]{agencyId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 issuedagency = fetch(map);
		 return issuedagency;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_ISSUED_AGENCY";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String agencyId) throws Exception{
		 String sql ="DELETE FROM T_ISSUED_AGENCY WHERE AGENCY_ID=?";
		 Object[] values = new Object[] { agencyId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(IssuedAgency issuedagency) throws Exception{
		 String sql ="UPDATE T_ISSUED_AGENCY SET AGENCY_CODE= ?,AGENCY_NAME= ?,AGENCY_DESC= ? WHERE AGENCY_ID=?";
		 Object[] values = new Object[] {issuedagency.getAgencyCode(),issuedagency.getAgencyName(),issuedagency.getAgencyDesc(),issuedagency.getAgencyId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(IssuedAgency issuedagency) throws Exception{
		 String sql ="INSERT INTO T_ISSUED_AGENCY(AGENCY_ID,AGENCY_CODE,AGENCY_NAME,AGENCY_DESC) VALUES(?,?,?,?)";
		 Object[] values = new Object[] {issuedagency.getAgencyId(),issuedagency.getAgencyCode(),issuedagency.getAgencyName(),issuedagency.getAgencyDesc()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public IssuedAgency fetch(Map map) throws Exception{
		IssuedAgency issuedagency = new IssuedAgency();		
		issuedagency.setAgencyId((String)map.get("AGENCY_ID"));
		issuedagency.setAgencyCode((String)map.get("AGENCY_CODE"));
		issuedagency.setAgencyName((String)map.get("AGENCY_NAME"));
		issuedagency.setAgencyDesc((String)map.get("AGENCY_DESC"));
		return issuedagency;
	}
}
