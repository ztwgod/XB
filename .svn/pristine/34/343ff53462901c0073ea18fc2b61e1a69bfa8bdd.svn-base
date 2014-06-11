package cn.com.xb.daox.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.AuthCardDaoImpl;
import cn.com.xb.daox.IAuthCardDaox;
import cn.com.xb.domain.base.ListCard;
import cn.com.xb.domain.base.Page;

public class AuthCardDaoxImpl extends AuthCardDaoImpl implements IAuthCardDaox {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int getItems(ListCard card) throws Exception {
		StringBuilder sql =  new StringBuilder("SELECT COUNT(*) FROM T_USER A LEFT JOIN T_AUTH_CARD B ON A.USER_ID = B.USER_ID WHERE 1=1 ");
		
		List<Object> params = new ArrayList<Object>();	
		if(!"".equals(card.getUserAccount())){
			sql.append(" AND A.USER_ACCOUNT = '%").append(card.getUserAccount()).append("%'");
			//params.add(card.getUserAccount());
		}
		
		if(!"".equals(card.getUserName())){
			sql.append(" AND A.USER_NAME LIKE '%").append(card.getUserName()).append("%'");
			//params.add(card.getUserName());
		}
		
		if(0!=card.getCardStatus()){
			sql.append(" AND B.CARD_STATUS = ? ");
			params.add(card.getCardStatus());
		}
		
		if(null!=card.getStartTime()){
			sql.append(" AND B.EXPIRATION_DATE >= ?");
			params.add(card.getStartTime());
		}
		
		if(null!=card.getEndTime()){
			sql.append(" AND B.EXPIRATION_DATE <= ?");
			params.add(card.getEndTime());
		}
		
		return jdbcTemplate.queryForInt(sql.toString(),params.toArray());
	}

	public List<ListCard> loadListCard(ListCard card, Page page) throws Exception {
		StringBuilder sql =  new StringBuilder("SELECT A.USER_ACCOUNT,A.USER_ID,A.USER_NAME, ");
		sql.append(" A.USER_TYPE,B.EXPIRATION_DATE,B.ISSUED_AGENCY,B.CARD_TYPE,B.CARD_STATUS,B.CARD_ID ");
		sql.append(" FROM T_USER A LEFT JOIN T_AUTH_CARD B ON A.USER_ID = B.USER_ID WHERE 1=1 ");
		List<Object> params = new ArrayList<Object>();	
		
		if(!"".equals(card.getUserAccount())){
			sql.append(" AND A.USER_ACCOUNT LIKE '%").append(card.getUserAccount()).append("%'");
		}
		
		if(!"".equals(card.getUserName())){
			sql.append(" AND A.USER_NAME LIKE '%").append(card.getUserName()).append("%'");
		}
		
		if(0!=card.getCardStatus()){
			sql.append(" AND B.CARD_STATUS = ? ");
			params.add(card.getCardStatus());
		}
		
		if(null!=card.getStartTime()){
			sql.append(" AND B.EXPIRATION_DATE >= ?");
			params.add(card.getStartTime());
		}
		
		if(null!=card.getEndTime()){
			sql.append(" AND B.EXPIRATION_DATE <= ?");
			params.add(card.getEndTime());
		}		
		
		sql.append(" ORDER BY A.CREATE_TIME DESC LIMIT ?,? ");
		params.add(page.getStartItems());
		params.add(page.getPageSize());
		
		List<ListCard> list = new ArrayList<ListCard>();
		List<ListCard> mapList = jdbcTemplate.queryForList(sql.toString(),params.toArray());
		Iterator it = mapList.iterator();		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 ListCard _card = new ListCard();
			 _card.setUserAccount((String)map.get("USER_ACCOUNT"));
			 _card.setUserId((String)map.get("USER_ID"));
			 _card.setUserName((String)map.get("USER_NAME"));		 
			 _card.setUserType(Integer.parseInt(map.get("USER_TYPE").toString()));
			 
			 Timestamp cardExpirationDate = (Timestamp)map.get("EXPIRATION_DATE"); 
			 if(null == cardExpirationDate){
				 _card.setCardExpirationDate(null);
			 }else{
				 _card.setCardExpirationDate(new Timestamp(cardExpirationDate.getTime()));
			 }
			 _card.setIssuedAgency((String)map.get("ISSUED_AGENCY"));
			 
			 String cardType = "0";
			 if(null!=map.get("CARD_TYPE") && !"".equals(map.get("CARD_TYPE"))){
				 cardType = map.get("CARD_TYPE").toString();
			 }
			 String cardStatus = "0";
			 if(null!=map.get("CARD_STATUS") && !"".equals(map.get("CARD_STATUS"))){
				 cardStatus = map.get("CARD_STATUS").toString();
			 }			 
			 _card.setCardType(Integer.parseInt(cardType));
			 _card.setCardStatus(Integer.parseInt(cardStatus));
			 _card.setCardId((String)map.get("CARD_ID"));
			 list.add(_card); 
		 }
		 return list;
	}


	public void deleteByUserId(String userId) throws Exception {
		 String sql ="DELETE FROM T_AUTH_CARD WHERE USER_ID = ?";
		 Object[] values = new Object[] { userId };
		 jdbcTemplate.update(sql, values);
	}
}
