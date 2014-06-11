package cn.com.xb.service;

import java.util.List;

import cn.com.xb.domain.base.AuthCard;
import cn.com.xb.domain.base.IssuedAgency;
import cn.com.xb.domain.base.ListCard;
import cn.com.xb.domain.base.Page;

public interface AuthCardService {

	public int getItems(ListCard card) throws Exception;
	
	public List<ListCard> loadListCard(ListCard card,Page page) throws Exception;
	
	public void insertCard(String opUserId, AuthCard authcard) throws Exception;
	
	public AuthCard getAuthCardByCardId(String cardId) throws Exception; 
	
	public void updateCard(String opUserId, AuthCard authcard) throws Exception;
	
	public List<IssuedAgency> loadAllIssuedAgency() throws Exception;
}
