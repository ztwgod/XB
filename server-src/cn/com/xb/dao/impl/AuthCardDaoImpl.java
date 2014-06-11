package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IAuthCardDao;
import  cn.com.xb.domain.base.AuthCard;

public class AuthCardDaoImpl implements IAuthCardDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<AuthCard> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_AUTH_CARD";
		 List<AuthCard> list = new ArrayList<AuthCard>();
		 List<AuthCard> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 AuthCard authcard = fetch(map); 
			 list.add(authcard); 
		 }
		 return list;
	}
	
	public AuthCard loadAuthCardBycardId(String cardId) throws Exception {
		 AuthCard authcard = null;
		 String sql ="SELECT * FROM T_AUTH_CARD WHERE CARD_ID = ? ";
		 Object[] values = new Object[]{cardId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 authcard = fetch(map);
		 return authcard;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_AUTH_CARD";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String cardId) throws Exception{
		 String sql ="DELETE FROM T_AUTH_CARD WHERE CARD_ID=?";
		 Object[] values = new Object[] { cardId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(AuthCard authcard) throws Exception{
		 String sql ="UPDATE T_AUTH_CARD SET USER_ID= ?,CARD_TYPE= ?,EXPIRATION_DATE= ?,ISSUED_AGENCY= ?,CARD_STATUS= ?,CARD_CODE= ?,CARD_PWD= ?,DESCRIPTION= ? WHERE CARD_ID=?";
		 Object[] values = new Object[] {authcard.getUserId(),authcard.getCardType(),authcard.getExpirationDate(),authcard.getIssuedAgency(),authcard.getCardStatus(),authcard.getCardCode(),authcard.getCardPwd(),authcard.getDescription(),authcard.getCardId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(AuthCard authcard) throws Exception{
		 String sql ="INSERT INTO T_AUTH_CARD(CARD_ID,USER_ID,CARD_TYPE,EXPIRATION_DATE,ISSUED_AGENCY,CARD_STATUS,CARD_CODE,CARD_PWD,DESCRIPTION) VALUES(?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {authcard.getCardId(),authcard.getUserId(),authcard.getCardType(),authcard.getExpirationDate(),authcard.getIssuedAgency(),authcard.getCardStatus(),authcard.getCardCode(),authcard.getCardPwd(),authcard.getDescription()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public AuthCard fetch(Map map) throws Exception{
		AuthCard authcard = new AuthCard();		
		authcard.setCardId((String)map.get("CARD_ID"));
		authcard.setUserId((String)map.get("USER_ID"));
		authcard.setCardType(Integer.parseInt(map.get("CARD_TYPE").toString()));
		Timestamp expirationDate = (Timestamp)map.get("EXPIRATION_DATE");
		if(null == expirationDate){
			authcard.setExpirationDate(null);
		}else{
			authcard.setExpirationDate(new Timestamp(expirationDate.getTime()));
		}
		authcard.setIssuedAgency((String)map.get("ISSUED_AGENCY"));
		authcard.setCardStatus(Integer.parseInt(map.get("CARD_STATUS").toString()));
		authcard.setCardCode((String)map.get("CARD_CODE"));
		authcard.setCardPwd((String)map.get("CARD_PWD"));
		authcard.setDescription((String)map.get("DESCRIPTION"));
		return authcard;
	}
}
