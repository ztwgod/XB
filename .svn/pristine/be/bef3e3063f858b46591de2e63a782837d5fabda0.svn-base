package cn.com.xb.plat.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.com.xb.domain.base.FlagDictionary;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Storagestation;
import cn.com.xb.domain.base.StoragestationGroup;
import cn.com.xb.domain.base.StoragestationModel;
import cn.com.xb.domain.base.StoragestationType;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.base.Userx;
import cn.com.xb.service.FlagDictionaryService;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.service.UserService;
import cn.com.xb.util.Global;
import cn.com.xb.util.SessionManger;
import cn.com.xb.util.StringUtil;

import com.opensymphony.xwork2.ActionSupport;

public class StoragestationaAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	private static final long serialVersionUID = -578697069556382981L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserService userService;
	private FlagDictionaryService flagDictionaryService;
	private StoragestationaService storagestationaService;
	
	public void setStoragestationaService(StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}
	public void setFlagDictionaryService(FlagDictionaryService flagDictionaryService) {
		this.flagDictionaryService = flagDictionaryService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 跳转到物箱列表页面
	 * @return
	 * @throws Exception
	 */
	public String listBox() throws Exception{	
		String _pageNumber = request.getParameter("pageNumber")==null?"1":request.getParameter("pageNumber");
		int pageNumber = Integer.parseInt(_pageNumber);
		
		String ssCode = request.getParameter("ssCode")==null?"":request.getParameter("ssCode");
		String ssName = request.getParameter("ssName")==null?"":request.getParameter("ssName");
		String groupId = request.getParameter("groupId")==null?"":request.getParameter("groupId");
		String dataCard = request.getParameter("dataCard")==null?"":request.getParameter("dataCard");
		
		Storagestationx stro = new Storagestationx();
		stro.setSsCode(ssCode);
		stro.setSsName(ssName);
		stro.setGroupId(groupId);
		stro.setDataCard(dataCard);
		
		int items = storagestationaService.loadStoragestationxItems(stro);		
		Page page = new Page();
		page.setPageAllCount(items);
		page.setPageNumber(pageNumber);
		
		List<Storagestationx> listBox = storagestationaService.loadStoragestationxList(stro, page);
		List<StoragestationGroup> storGroup = storagestationaService.loadAllStoragestationGroup();
		
		request.setAttribute("listBox", listBox);
		request.setAttribute("storGroup", storGroup);
		request.setAttribute("page", page);
		request.setAttribute("stro", stro);
		return SUCCESS;
	}
	
	
	/**
	 * 跳转到添加物箱页面
	 * @return
	 * @throws Exception
	 */
	public String toAddBox() throws Exception{
		List<FlagDictionary> ipLinkType = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_IPLINK_TYPE);//IP链路类型
		List<StoragestationType> storageType = storagestationaService.loadAllBoxType();
		//List<StoragestationModel> model = storagestationaService.loadAllStoragestationModel();
		List<StoragestationGroup> storGroup = storagestationaService.loadAllStoragestationGroup();
		
		request.setAttribute("storGroup", storGroup);
		//request.setAttribute("model", model);
		request.setAttribute("storageType", storageType);
		request.setAttribute("ipLinkType", ipLinkType);
		return SUCCESS;
	}
	
	/**
	 * 添加物箱
	 * @return
	 * @throws Exception
	 */
	public String doAddBox() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String ssCode = request.getParameter("ssCode");
		//String ssName = request.getParameter("ssName");
		String dataCard = request.getParameter("dataCard");
		String ipAdd = request.getParameter("ipAdd");
		String ssType = request.getParameter("ssType");
		String egisId = request.getParameter("egisId");
		String linkType = request.getParameter("linkType");
		String groupId = request.getParameter("groupId");
		String assetSn = request.getParameter("assetSn");
		//String availableBoxNum = request.getParameter("availableBoxNum");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		String port = request.getParameter("port");
		//String model = request.getParameter("model");
		//String ssSeq = request.getParameter("ssSeq");
		String baiduPid = request.getParameter("baiduId"); //百度地图ID
		
		String sentCouriersId = request.getParameter("sentCouriersId"); //寄件快递员组
		String courierPickupsId = request.getParameter("courierPickupsId"); //取件快递员组
		String boxAddress = request.getParameter("boxAddress"); //物箱地址
		
		String[] sendCArr = null;
		String[] pickCArr = null;
		if(null!= sentCouriersId && !"".equals(sentCouriersId)){
			sendCArr = sentCouriersId.split("@");
		}
		if(null!=courierPickupsId && !"".equals(courierPickupsId)){
			pickCArr = courierPickupsId.split("@");
		}
		
		Storagestation stor = new Storagestation();
		stor.setSsCode(ssCode);
		//stor.setSsName(ssName);
		stor.setDataCard(dataCard);
		stor.setIpAdd(ipAdd);
		stor.setSsType(ssType);
		
		//stor.setSsIndex(ssSeq);
		//stor.setModelId(model);
		stor.setGroupId(groupId);
		stor.setLinkType(Integer.parseInt(linkType));
		stor.setAssetSn(assetSn);
		//stor.setAvailableBoxNum(Integer.parseInt(availableBoxNum));
		stor.setLongitude(Double.parseDouble(longitude));
		stor.setLatitude(Double.parseDouble(latitude));
		stor.setPort(port);
		stor.setPoiId(baiduPid);
		stor.setSsAddress(boxAddress);
		
		storagestationaService.insertStoragestation(opUserId, stor,egisId,sendCArr,pickCArr);
		
		return SUCCESS;
	}
	
	/**
	 * 维护员列表
	 * @return
	 * @throws Exception
	 */
	public String listEgis() throws Exception{
		String _pageNumber = request.getParameter("pageNumber")==null?"1":request.getParameter("pageNumber");
		String userAccount = request.getParameter("userAccount")==null?"":request.getParameter("userAccount");
		String userName = request.getParameter("userName")==null?"":request.getParameter("userName");
		String ssId = request.getParameter("ssId")==null?"":request.getParameter("ssId");
		
		int pageNumber = Integer.parseInt(_pageNumber);
		User user = new User();
		user.setUserAccount(userAccount);
		user.setUserName(userName);
		
		int items = userService.loadSystemUserItems(user,ssId);
		Page page = new Page();
		page.setPageAllCount(items);
		page.setPageNumber(pageNumber);
		
		List<Userx> listSys = userService.loadSystemUser(user,ssId,page);
		request.setAttribute("listSys", listSys);
		request.setAttribute("page", page);
		request.setAttribute("user", user);
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改物箱页面
	 * @return
	 * @throws Exception
	 */
	public String toUpdateBox() throws Exception{
		String ssId = request.getParameter("ssId");
		Storagestation stor = storagestationaService.loadStoragestationBySSId(ssId);
		
		List<FlagDictionary> ipLinkType = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_IPLINK_TYPE);//IP链路类型
		List<StoragestationType> storageType = storagestationaService.loadAllBoxType();
		//List<StoragestationModel> model = storagestationaService.loadAllStoragestationModel();
		List<StoragestationGroup> storGroup = storagestationaService.loadAllStoragestationGroup();
		
		//获取维护员信息
		User user = userService.getSystemUserById(ssId);
		
		request.setAttribute("user", user);
		request.setAttribute("storGroup", storGroup);
		//request.setAttribute("model", model);
		request.setAttribute("storageType", storageType);
		request.setAttribute("ipLinkType", ipLinkType);		
		request.setAttribute("stor", stor);
		return SUCCESS;
	}
	
	/**
	 * 修改物箱
	 * @return
	 * @throws Exception
	 */
	public String doUpdateBox() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String ssId = request.getParameter("ssId");
		String ssCode = request.getParameter("ssCode");
		//String ssName = request.getParameter("ssName");
		String dataCard = request.getParameter("dataCard");
		String ipAdd = request.getParameter("ipAdd");
		String ssType = request.getParameter("ssType");
		String egisId = request.getParameter("egisId");
		String linkType = request.getParameter("linkType");
		String groupId = request.getParameter("groupId");
		String assetSn = request.getParameter("assetSn");
		//String availableBoxNum = request.getParameter("availableBoxNum");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		String port = request.getParameter("port");
		String model = request.getParameter("model");
		//String ssSeq = request.getParameter("ssSeq");
		String baiduPid = request.getParameter("baiduId"); //百度地图ID
		
		String boxAddress = request.getParameter("boxAddress"); //物箱地址
		
		Storagestation stor = storagestationaService.loadStoragestationBySSId(ssId);
		stor.setSsCode(ssCode);
		//stor.setSsName(ssName);
		stor.setDataCard(dataCard);
		stor.setIpAdd(ipAdd);
		stor.setSsType(ssType);
		//stor.setSsIndex(ssSeq);
		stor.setModelId(model);
		stor.setGroupId(groupId);
		stor.setLinkType(Integer.parseInt(linkType));
		stor.setAssetSn(assetSn);
		//stor.setAvailableBoxNum(Integer.parseInt(availableBoxNum));
		stor.setLongitude(Double.parseDouble(longitude));
		stor.setLatitude(Double.parseDouble(latitude));
		stor.setPort(port);
		stor.setPoiId(baiduPid);
		stor.setSsAddress(boxAddress);
		
		storagestationaService.updateStoragestation(opUserId, stor,egisId);
		return SUCCESS;
	}
	
	/**
	 * 校验百度地图ID是否已经录入过
	 * @throws Exception
	 */
	public void verifyBaiDuPid() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String pid = request.getParameter("pid");
		String ssId = request.getParameter("ssId")==null?"":request.getParameter("ssId");
		if("".equals(ssId)){ //添加
			int size = storagestationaService.getItemsByPid(pid);
			if(size<=0){
				response.getWriter().write("OK");
			}else{
				response.getWriter().write(pid+"该百度地图ID已被使用！");
			}
		}else{ //修改
			Storagestationx storx = storagestationaService.getStoragestationxByPid(pid);
			if(null==storx){
				response.getWriter().write("OK");
			}else{
				//判断是否为当前自己使用的百度地图ID
				if(storx.getSsId().equals(ssId)){
					response.getWriter().write("OK");
				}else{
					response.getWriter().write(pid+"该百度地图ID已被使用！");
				}
			}
		}		
	}
	
	/**
	 * 验证物箱代码是否重复
	 * @throws Exception
	 */
	public void verifySSCode() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String ssCode = request.getParameter("ssCode");
		//String ssId = request.getParameter("ssId")==null?"":request.getParameter("ssId");
		String groupId = request.getParameter("groupId");
		
		String locationCode = storagestationaService.getLocationCodeByGroupId(groupId);
		
		if(ssCode.contains(locationCode)){
			response.getWriter().write(ssCode);
			return;
		}
		
		String newSsCode = StringUtil.appendZero(2, ssCode);
		String newCode = locationCode+newSsCode;
		
		Storagestationx storx = storagestationaService.getStoragestationxBySSCode(newCode);
		if(null==storx){ //未查询到物箱信息，该代码可用。
			response.getWriter().write(newCode);
		}else{
			response.getWriter().write("FAIL");
		}
	}
	
	/**
	 * 跳转到查看物箱信息页面
	 * @return
	 * @throws Exception
	 */
	public String loadBox() throws Exception{
		String ssId = request.getParameter("ssId");
		Storagestation stor = storagestationaService.loadStoragestationBySSId(ssId);
		
		List<FlagDictionary> ipLinkType = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_IPLINK_TYPE);//IP链路类型
		List<StoragestationType> storageType = storagestationaService.loadAllBoxType();
		List<StoragestationModel> model = storagestationaService.loadAllStoragestationModel();
		List<StoragestationGroup> storGroup = storagestationaService.loadAllStoragestationGroup();
		
		//获取维护员信息
		User user = userService.getSystemUserById(ssId);
		
		String pientCourierGoup = storagestationaService.getCourierGroupsName(ssId, Global.RECIPIENT);
		String sendCourierGroup = storagestationaService.getCourierGroupsName(ssId, Global.SENDPIECES);
		
		
		request.setAttribute("user", user);
		request.setAttribute("storGroup", storGroup);
		request.setAttribute("model", model);
		request.setAttribute("storageType", storageType);
		request.setAttribute("ipLinkType", ipLinkType);		
		request.setAttribute("stor", stor);
		request.setAttribute("pientCourierGoup", pientCourierGoup);
		request.setAttribute("sendCourierGroup", sendCourierGroup);
		
		return SUCCESS;
	}
	
	
	/**
	 * 删除物箱
	 * @return
	 * @throws Exception
	 */
	public String doDeleteBox() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String ssId = request.getParameter("ssId");
		storagestationaService.deleteStoragestation(opUserId, ssId);
		return SUCCESS;
	}
}
