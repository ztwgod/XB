package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IExpressCompanyDao;
import  cn.com.xb.domain.base.ExpressCompany;

public class ExpressCompanyDaoImpl implements IExpressCompanyDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<ExpressCompany> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_EXPRESS_COMPANY";
		 List<ExpressCompany> list = new ArrayList<ExpressCompany>();
		 List<ExpressCompany> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 ExpressCompany expresscompany = fetch(map); 
			 list.add(expresscompany); 
		 }
		 return list;
	}
	
	public ExpressCompany loadExpressCompanyByexcoId(String excoId) throws Exception {
		 ExpressCompany expresscompany = null;
		 String sql ="SELECT * FROM T_EXPRESS_COMPANY WHERE EXCO_ID = ? ";
		 Object[] values = new Object[]{excoId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 expresscompany = fetch(map);
		 return expresscompany;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_EXPRESS_COMPANY";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String excoId) throws Exception{
		 String sql ="DELETE FROM T_EXPRESS_COMPANY WHERE EXCO_ID=?";
		 Object[] values = new Object[] { excoId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(ExpressCompany expresscompany) throws Exception{
		 String sql ="UPDATE T_EXPRESS_COMPANY SET EXCO_NAME= ?,CONTACTOR_NAME= ?,CONTACT_PHONE= ?,CONTACT_ADD= ?,SERVICE_STATUS= ?,CONTRACT_NO= ?,VALID_DATE= ? WHERE EXCO_ID=?";
		 Object[] values = new Object[] {expresscompany.getExcoName(),expresscompany.getContactorName(),expresscompany.getContactPhone(),expresscompany.getContactAdd(),expresscompany.getServiceStatus(),expresscompany.getContractNo(),expresscompany.getValidDate(),expresscompany.getExcoId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(ExpressCompany expresscompany) throws Exception{
		 String sql ="INSERT INTO T_EXPRESS_COMPANY(EXCO_ID,EXCO_NAME,CONTACTOR_NAME,CONTACT_PHONE,CONTACT_ADD,SERVICE_STATUS,CONTRACT_NO,VALID_DATE) VALUES(?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {expresscompany.getExcoId(),expresscompany.getExcoName(),expresscompany.getContactorName(),expresscompany.getContactPhone(),expresscompany.getContactAdd(),expresscompany.getServiceStatus(),expresscompany.getContractNo(),expresscompany.getValidDate()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public ExpressCompany fetch(Map map) throws Exception{
		ExpressCompany expresscompany = new ExpressCompany();		
		expresscompany.setExcoId((String)map.get("EXCO_ID"));
		expresscompany.setExcoName((String)map.get("EXCO_NAME"));
		expresscompany.setContactorName((String)map.get("CONTACTOR_NAME"));
		expresscompany.setContactPhone((String)map.get("CONTACT_PHONE"));
		expresscompany.setContactAdd((String)map.get("CONTACT_ADD"));
		expresscompany.setServiceStatus(Integer.parseInt(map.get("SERVICE_STATUS").toString()));
		expresscompany.setContractNo((String)map.get("CONTRACT_NO"));
		Timestamp validDate = (Timestamp)map.get("VALID_DATE");
		if(null == validDate){
			expresscompany.setValidDate(null);
		}else{
			expresscompany.setValidDate(new Timestamp(validDate.getTime()));
		}
		return expresscompany;
	}
}
