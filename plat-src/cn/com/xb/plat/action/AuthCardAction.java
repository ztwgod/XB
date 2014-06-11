package cn.com.xb.plat.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.com.xb.domain.base.AuthCard;
import cn.com.xb.domain.base.FlagDictionary;
import cn.com.xb.domain.base.IssuedAgency;
import cn.com.xb.domain.base.ListCard;
import cn.com.xb.domain.base.Page;
import cn.com.xb.service.AuthCardService;
import cn.com.xb.service.FlagDictionaryService;
import cn.com.xb.util.DateTools;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.SessionManger;

import com.opensymphony.xwork2.ActionSupport;

public class AuthCardAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	private static final long serialVersionUID = -578697069556382981L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private AuthCardService authCardService;
	private FlagDictionaryService flagDictionaryService;
	
	public void setFlagDictionaryService(FlagDictionaryService flagDictionaryService) {
		this.flagDictionaryService = flagDictionaryService;
	}
	public void setAuthCardService(AuthCardService authCardService) {
		this.authCardService = authCardService;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 跳转到卡片列表页面
	 * @return
	 * @throws Exception
	 */
	public String listCard() throws Exception{		
		String userAccount = request.getParameter("userAccount")==null?"":request.getParameter("userAccount");
		String userName = request.getParameter("userName")==null?"":request.getParameter("userName");
		String cardStatus = "";
		if(null==request.getParameter("cardStatus") || "".equals(request.getParameter("cardStatus"))){
			cardStatus = "0";
		}else{
			cardStatus = request.getParameter("cardStatus");
		}
		String _pageNumber = request.getParameter("pageNumber")==null?"1":request.getParameter("pageNumber");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		
		int pageNumber = Integer.parseInt(_pageNumber);
		int _cardStatus = Integer.parseInt(cardStatus);
		
		ListCard card = new ListCard();
		card.setUserAccount(userAccount);
		card.setUserName(userName);
		card.setCardStatus(_cardStatus);
		card.setStartTime(DateTools.formatStringToTimestamp(startTime,DateTools.FORMAT_YYYYMMDD));
		card.setEndTime(DateTools.formatStringToTimestamp(endTime,DateTools.FORMAT_YYYYMMDD));
		
		int items = authCardService.getItems(card);
		Page page = new Page();
		page.setPageAllCount(items);
		page.setPageNumber(pageNumber);
			
		List<ListCard> cardList = authCardService.loadListCard(card, page);
		List<FlagDictionary> cardStatusList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_CARD_STATUS);	
		
		request.setAttribute("cardStatusList",cardStatusList);
		request.setAttribute("card", card);
		request.setAttribute("page", page);
		request.setAttribute("cardList", cardList);
		
		return SUCCESS;
	}
	
	/**
	 * 跳转到绑定卡片页面
	 * @return
	 * @throws Exception
	 */
	public String toAddCard() throws Exception{
		String userId = request.getParameter("userId");
		String userAccount = request.getParameter("userAccount");
		
		List<FlagDictionary> cardTypeList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_CARD_TYPE);	
		List<FlagDictionary> cardStatusList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_CARD_STATUS);	
		
		List<IssuedAgency> issuredAgency = authCardService.loadAllIssuedAgency();
		
		ListCard card = new ListCard();
		card.setUserId(userId);
		card.setUserAccount(userAccount);
		
		request.setAttribute("cardTypeList",cardTypeList);
		request.setAttribute("cardStatusList", cardStatusList);
		request.setAttribute("issuredAgency", issuredAgency);		
		request.setAttribute("card",card);
		return SUCCESS;
	}
	
	/**
	 * 用户绑定卡片
	 * @return
	 * @throws Exception
	 */
	public String doAddCard() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String userId = request.getParameter("userId");
		String cardExpirationDate = request.getParameter("cardExpirationDate");
		String type = request.getParameter("type");
		String cardStatus = request.getParameter("cardStatus");
		String issuedAgency = request.getParameter("issuedAgency");
		String cardCode = request.getParameter("cardCode");
		String cardPwd = request.getParameter("cardPassword");
		
		AuthCard authCard = new AuthCard();
		authCard.setCardId(KeyHelper.creatKey());
		authCard.setCardStatus(Integer.parseInt(cardStatus));
		authCard.setCardType(Integer.parseInt(type));
		authCard.setExpirationDate(DateTools.formatStringToTimestamp(cardExpirationDate,DateTools.FORMAT_YYYYMMDD));
		authCard.setIssuedAgency(issuedAgency);
		authCard.setUserId(userId);
		authCard.setCardCode(cardCode);
		authCard.setCardPwd(cardPwd);
		
		authCardService.insertCard(opUserId, authCard);		
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改卡片页面
	 * @return
	 * @throws Exception
	 */
	public String toUpdateCard() throws Exception{
		String cardId = request.getParameter("cardId");
		String userAccount = request.getParameter("userAccount");
		
		AuthCard card = authCardService.getAuthCardByCardId(cardId);
		List<FlagDictionary> cardTypeList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_CARD_TYPE);	
		List<FlagDictionary> cardStatusList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_CARD_STATUS);
		List<IssuedAgency> issuredAgency = authCardService.loadAllIssuedAgency();
		
		request.setAttribute("cardTypeList",cardTypeList);
		request.setAttribute("cardStatusList", cardStatusList);
		request.setAttribute("card", card);
		request.setAttribute("issuredAgency", issuredAgency);
		request.setAttribute("userAccount", userAccount);
		return SUCCESS;
	}
	
	/**
	 * 修改卡片
	 * @return
	 * @throws Exception
	 */
	public String doUpdateCard() throws Exception{		
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String cardId = request.getParameter("cardId");
		String cardExpirationDate = request.getParameter("cardExpirationDate");
		String type = request.getParameter("type");
		String cardStatus = request.getParameter("cardStatus");
		String issuedAgency = request.getParameter("issuedAgency");
		String cardCode = request.getParameter("cardCode");
		String cardPwd = request.getParameter("cardPassword");
		
		AuthCard authCard = authCardService.getAuthCardByCardId(cardId);
		authCard.setCardStatus(Integer.parseInt(cardStatus));
		authCard.setCardType(Integer.parseInt(type));
		authCard.setExpirationDate(DateTools.formatStringToTimestamp(cardExpirationDate,DateTools.FORMAT_YYYYMMDD));
		authCard.setIssuedAgency(issuedAgency);
		authCard.setCardCode(cardCode);
		authCard.setCardPwd(cardPwd);
		
		authCardService.updateCard(opUserId, authCard);		
		return SUCCESS;
	}
	
}
