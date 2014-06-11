package cn.com.xb.plat.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.BoxInfox;
import cn.com.xb.domain.base.Cabinet;
import cn.com.xb.domain.base.Courierx;
import cn.com.xb.domain.base.GbDistrict;
import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Peripheralx;
import cn.com.xb.domain.base.ResponseText;
import cn.com.xb.domain.base.Storagestation;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.domain.base.SysuserStoragestation;
import cn.com.xb.domain.base.Transaction;
import cn.com.xb.http.comet.TomcatHttpServlet;
import cn.com.xb.inter.domain.request.DepositUnpackInfoWarpper;
import cn.com.xb.inter.domain.request.RemoteUnpackeInfoWarpper;
import cn.com.xb.service.CourierService;
import cn.com.xb.service.GbDistrictService;
import cn.com.xb.service.OperationLogService;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.service.TransactionService;
import cn.com.xb.service.UserService;
import cn.com.xb.service.helper.SMSHelperService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.SMSTools;
import cn.com.xb.util.SessionManger;
import cn.com.xb.util.StringUtil;
import cn.com.xb.util.XstreamUtil;
import cn.com.xb.util.box.FreemarkerUtil;
import cn.com.xb.util.box.WriterBox;

import com.opensymphony.xwork2.ActionSupport;

public class StoragestationaGUIAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	private static final long serialVersionUID = -578697069556382981L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private StoragestationaService storagestationaService;
	private SMSHelperService smsHelperService;
	private TransactionService transactionService;
	private UserService userService;
	private CourierService courierService;
	private GbDistrictService gbDistrictService;
	private OperationLogService operationLogService;
	private static final int TIME_OUT = 10; //10秒没有返回，断链
	

	public void setOperationLogService(OperationLogService operationLogService)
	{
		this.operationLogService = operationLogService;
	}
	public void setGbDistrictService(GbDistrictService gbDistrictService) {
		this.gbDistrictService = gbDistrictService;
	}
	public void setCourierService(CourierService courierService) {
		this.courierService = courierService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	public void setSmsHelperService(SMSHelperService smsHelperService) {
		this.smsHelperService = smsHelperService;
	}

	private static Log log = LogFactory.getLog(StoragestationaGUIAction.class);
	
	public void setStoragestationaService(StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 获取请求结果
	 * @return
	 * @throws Exception
	 */
	public void getGUIResponseText() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String transNO = request.getParameter("tranNO")==null?"":request.getParameter("tranNO");
		String transType = request.getParameter("transType")==null?"0":request.getParameter("transType");
		String ssId = request.getParameter("ssId")==null?"0":request.getParameter("ssId");
		String boxCode = request.getParameter("boxCode")==null?"":request.getParameter("boxCode");
		
		if("".equals(transType)){
			transType = "0";
		}		
		int _transType = Integer.parseInt(transType);
		//log.info("transNO："+transNO);
		
		if("".equals(transNO)){
			if(_transType==Global.BOX_GUI_RESPONSETYPE_SYN){
				response.getWriter().write("物箱同步失败，请稍后重试！");
			}else if(_transType== Global.BOX_GUI_OPENBOX){
				response.getWriter().write("物箱开箱失败，请稍后重试！");
			}else if(_transType == Global.BOX_GUI_SETSYSTEMUSER){
				response.getWriter().write("设置维护员失败，请稍后重试！");
			}else if(_transType == Global.BOX_GUI_RECIPIENTCOURIER){
				response.getWriter().write("设置收件快递员失败，请稍后重试！");
			}else if(_transType == Global.BOX_GUI_CASTPARTS){
				response.getWriter().write("设置投件快递员失败，请稍后重试！");
			}else if(_transType == Global.BOX_GUI_BOXSTATUS){
				response.getWriter().write("查询物箱状态失败，请稍后重试！");
			}else if(_transType == Global.BOX_GUI_PERIPHERAL){
				response.getWriter().write("查询外围设备状态失败，请稍后重试！");
			}else if(_transType == Global.BOX_GUI_BOXINFO){
				response.getWriter().write("查询箱子状态失败，请稍后重试！");
			}else{
				response.getWriter().write("请求失败，未知的交易信息！");
			}
		}else{
			ResponseText resText = TomcatHttpServlet.getResultMapsValue(transNO);
			if(null==resText){
				if(_transType==Global.BOX_GUI_RESPONSETYPE_SYN){
					response.getWriter().write("物箱同步成功！");
				}else if(_transType== Global.BOX_GUI_OPENBOX){
					response.getWriter().write("物箱开箱成功！");
				}else if(_transType == Global.BOX_GUI_SETSYSTEMUSER){
					response.getWriter().write("设置维护员成功！");
				}else if(_transType == Global.BOX_GUI_RECIPIENTCOURIER){
					response.getWriter().write("设置收件快递员成功！");
				}else if(_transType == Global.BOX_GUI_CASTPARTS){
					response.getWriter().write("设置投件快递员成功！");
				}else if(_transType == Global.BOX_GUI_BOXSTATUS){
					this.getStoragestationInfo(ssId);
				}else if(_transType == Global.BOX_GUI_PERIPHERAL){
					this.loadPeripheralxStatus(ssId);
				}else if(_transType == Global.BOX_GUI_BOXINFO){
					this.loadBoxInfoStatus(ssId, boxCode);
				}else{
					response.getWriter().write("未知的请求结果！");
				}
			}else{
				if(resText.getResult()==1){
					TomcatHttpServlet.removeResultMaps(resText.getTransNo());
					if(_transType==Global.BOX_GUI_RESPONSETYPE_SYN){
						response.getWriter().write("物箱同步失败！");
					}else if(_transType== Global.BOX_GUI_OPENBOX){
						response.getWriter().write("物箱开箱失败！");
					}else if(_transType == Global.BOX_GUI_SETSYSTEMUSER){
						response.getWriter().write("设置维护员失败！");
					}else if(_transType == Global.BOX_GUI_RECIPIENTCOURIER){
						response.getWriter().write("设置收件快递员失败！");
					}else if(_transType == Global.BOX_GUI_CASTPARTS){
						response.getWriter().write("设置投件快递员失败！");
					}else if(_transType == Global.BOX_GUI_BOXSTATUS){
						this.getStoragestationInfo(ssId);
					}else if(_transType == Global.BOX_GUI_PERIPHERAL){
						this.loadPeripheralxStatus(ssId);
					}else if(_transType == Global.BOX_GUI_BOXINFO){
						this.loadBoxInfoStatus(ssId, boxCode);
					}else{
						response.getWriter().write("未知的请求结果！");
					}
				}else{
					if(resText.getCount()==TIME_OUT){ //
						TomcatHttpServlet.removeResultMaps(resText.getTransNo());
						response.getWriter().write("操作失败，断链！");
					}else{
						log.info(resText.getCount());
						resText.setCount(resText.getCount()+1);
						response.getWriter().write("1");//请求已经发送给物箱，但是还没收到物箱的反馈。
					}
				}
			}
		}
	}
	
	/**
	 * 跳转到物箱GUI界面
	 * @return
	 * @throws Exception
	 */
	public String loadGUIBox() throws Exception{	
		String ssId = request.getParameter("ssId"); //物箱ID
		String ssType = request.getParameter("ssType"); //物箱类型
		
		Storagestation stor = new Storagestation();
		stor.setSsId(ssId);
		stor.setSsType(ssType);
		
		//StoragestationType storType =  storagestationaService.loadStoragestationTypeBytypeId(ssType);
		
		Storagestation storagestation = storagestationaService.loadStoragestationBySSId(ssId); //物箱信息
		List<Cabinet> cabList = storagestationaService.getCabinetList(ssId); //柜子信息
		WriterBox writerBox = new WriterBox();
		
		//获取素有箱子状态信息
		Map<String, BoxInfo> boxMap = storagestationaService.loadBoxInfo(ssId);
		String html = writerBox.writer(cabList, storagestation,boxMap);
		
		/*int size = cabList.size();
		int width = size*160+80;
		//总宽度830
		int marginLeft = (800-width)/2;
		if("".equals(html)){
			marginLeft = 100;
		}
		request.setAttribute("_marginLeft", marginLeft+"px");*/
		
		request.setAttribute("boxHTML",html);
		request.setAttribute("stor", stor);
		
		return SUCCESS;
	}
	
	/**
	 * 同步物箱
	 * @return
	 * @throws Exception
	 */
	public String synchronizedBox() throws Exception{
		//String boxId = request.getParameter("boxId");
		//boolean isMainBox = this.isMainBox(boxId);//是否为主控柜
		//boxId = boxId.replaceAll("box_", "");
		
		String ssId = request.getParameter("ssId");
		Storagestationx stor = storagestationaService.loadStoragestationStatus(ssId);
		String transNo = KeyHelper.creatKey();
		
		ResponseText resText = new ResponseText();
		resText.setSsCode(stor.getSsCode());
		resText.setSsId(ssId);
		resText.setResponseType(Global.BOX_GUI_RESPONSETYPE_SYN); //同步
		resText.setTransNo(transNo);
		
		String[] results = TomcatHttpServlet.send(resText,request);
		StringBuffer message = new StringBuffer();
		if(this.sendSuccess(results)){
			message.append("正在同步物箱信息，请稍后...");
		}else{
			transNo = "";
			message.append("同步物箱出错，请稍后重试！错误信息:"+results[1]);
		}
		request.setAttribute("message",message);
		request.setAttribute("tranNO", transNo);
		request.setAttribute("transType", Global.BOX_GUI_RESPONSETYPE_SYN);
		
		return SUCCESS;
	}
	
	/**
	 * 判断是否发送成功
	 * @param results
	 * @return
	 */
	private boolean sendSuccess(String[] results){
		if(null!=results && results[0].equals("1")){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 跳转到录入开箱手机号与随机码页面
	 * @return
	 * @throws Exception
	 */
	public String toOpenBox() throws Exception{
		String ssId = request.getParameter("ssId");
		String boxId = request.getParameter("boxId");
		boxId = boxId.replaceAll("box_", "");
		String randCode = request.getParameter("randCode");
		String mobile = request.getParameter("mobile");
		
		request.setAttribute("ssId", ssId);
		request.setAttribute("boxId", boxId);
		request.setAttribute("randCode", randCode);
		request.setAttribute("mobile", mobile);
		
		return SUCCESS;
	}
	
	
	/**
	 * 开箱
	 * @return
	 * @throws Exception
	 */
	public String openBox() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String ssId = request.getParameter("ssId");
		String boxId = request.getParameter("boxId");
		boxId = boxId.replaceAll("box_", "");
		String randCode = request.getParameter("randCode"); //开箱随机码
		String mobile = request.getParameter("mobile");//手机号
		
		String transNo = KeyHelper.creatKey();
		Storagestationx stor = storagestationaService.loadStoragestationStatus(ssId);
		
		/*ResponseText resText = new ResponseText();
		resText.setSsCode(stor.getSsCode());
		resText.setBoxCode(boxId);
		resText.setSsId(ssId);
		resText.setResponseType(Global.BOX_GUI_OPENBOX); //开箱
		resText.setTransNo(transNo);
		String userId = SessionManger.loadPlatUserSession(request).getUserId();//用户ID
		resText.setUserId(userId);*/
		
		String userId = SessionManger.loadPlatUserSession(request).getUserId();//用户ID
		DepositUnpackInfoWarpper deposit = new DepositUnpackInfoWarpper();
		deposit.setBoxCode(boxId);
		deposit.setGuiSequenceNumber(transNo);
		deposit.setRandomNum(randCode);
		deposit.setUserMobilePhone(mobile);
		deposit.setStorageStationId(stor.getSsCode());
		deposit.setUserId(userId);
		
		String _message = XstreamUtil.javaBean2JETTSON(deposit,RemoteUnpackeInfoWarpper.class);
		String[] results = TomcatHttpServlet.sendOpenBox(_message,request);
		
		StringBuffer message = new StringBuffer();
		if(this.sendSuccess(results)){
			message.append("正在开箱，请稍后...");
			

			OperationLog log = new OperationLog();
			log.setLogId(KeyHelper.creatKey());
			log.setSysPlatType(1);
			log.setOperationType(17);	// 操作类型
			log.setSsId(ssId);
			log.setBoxId(stor.getBoxId());
			log.setOperationUserId(opUserId);
			log.setOperationContent("GUI界面执行远程开箱，相关参数："+StringUtil.getOptionContent(new Object[]{opUserId, _message}));
			log.setOperationTime(new Timestamp(new Date().getTime()));
			operationLogService.addOperationLogInfo(log);// 添加日志
		}else{
			transNo = "";
			message.append("物箱开箱出错，请稍后重试！错误信息:"+results[1]);
		}
		request.setAttribute("message",message);
		request.setAttribute("tranNO", transNo);
		request.setAttribute("transType", Global.BOX_GUI_OPENBOX);
		
		
		return SUCCESS;
	}
	
	/**
	 * 维修密码发送
	 * @return
	 * @throws Exception
	 */
	public String sendServiceSMS() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String boxId = request.getParameter("boxId");
		boxId = boxId.replaceAll("box_", "");		
		String ssId = request.getParameter("ssId");
		
		Storagestationx storagestationx = storagestationaService.loadStoragestationxBySSId(ssId,boxId);
		if(null==storagestationx){
			request.setAttribute("message", "查询物箱信息出错，维修密码发送失败！");
		}else{
			String sms = SMSTools.getServiceSMS(storagestationx);
			boolean bool = smsHelperService.sendSMS(new String[]{storagestationx.getMobileNumber()},sms);
			
			String message = "";
			if(bool){
				message = "维修密码发送成功！";
				

				OperationLog log = new OperationLog();
				log.setLogId(KeyHelper.creatKey());
				log.setSysPlatType(1);
				log.setOperationType(18);	// 操作类型
				log.setSsId(ssId);
				log.setBoxId(boxId);
				log.setOperationUserId(opUserId);
				log.setOperationContent("GUI界面重发维护密码，相关参数："+StringUtil.getOptionContent(new Object[]{opUserId, ssId, boxId, storagestationx}));
				log.setOperationTime(new Timestamp(new Date().getTime()));
				operationLogService.addOperationLogInfo(log);// 添加日志
			}else{
				message = "维修密码发送失败！";
			}
			request.setAttribute("message", message);
		}
		return SUCCESS;
	}
	
	/**
	 * 开箱密码重发
	 * @return
	 * @throws Exception
	 */
	public String sendOpenBoxSMS() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String boxId = request.getParameter("boxId").replaceAll("box_", "");;
		String ssId = request.getParameter("ssId");
		Storagestationx storagestationx = storagestationaService.loadStoragestationxBySSId(ssId,boxId);
		if(null==storagestationx){
			request.setAttribute("message", "查询物箱信息出错，开箱密码发送失败！");
		}else{
			String sms = SMSTools.getServiceSMS(storagestationx);
			Transaction transaction = transactionService.getTransaction(storagestationx.getBoxId());			
			String message = "";
			if(null == transaction){
				message = "未查询到交易信息，无法重发开箱密码！";
			}else{
				storagestationx.setMaintainPwd(transaction.getPickupPwd());			
				boolean bool = smsHelperService.sendSMS(new String[]{storagestationx.getMobileNumber()},sms);				
				if(bool){
					message = "开箱密码发送成功！";
					

					OperationLog log = new OperationLog();
					log.setLogId(KeyHelper.creatKey());
					log.setSysPlatType(1);
					log.setOperationType(19);	// 操作类型
					log.setSsId(ssId);
					log.setBoxId(boxId);
					log.setOperationUserId(opUserId);
					log.setOperationContent("GUI界面重发开箱密码，相关参数："+StringUtil.getOptionContent(new Object[]{opUserId, ssId, boxId, storagestationx}));
					log.setOperationTime(new Timestamp(new Date().getTime()));
					operationLogService.addOperationLogInfo(log);// 添加日志
				}else{
					message = "开箱密码发送失败！";
				}
			}
			request.setAttribute("message", message);
		}
		return SUCCESS;
	}
	
	/**
	 * 设置维护员
	 * @throws Exception
	 */
	public String setSystemUser() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String userId = request.getParameter("userId"); //维护员ID		
		String ssId = request.getParameter("ssId");
		
		Storagestationx stor = storagestationaService.loadStoragestationStatus(ssId);		
		SysuserStoragestation psys = new SysuserStoragestation();
		psys.setUserId(userId);
		psys.setSsId(ssId);
		userService.updateSystemUser(opUserId, psys);

		String transNo = KeyHelper.creatKey();
		ResponseText resText = new ResponseText();
		resText.setResponseType(Global.BOX_GUI_SETSYSTEMUSER);
		resText.setSsCode(stor.getSsCode());
		resText.setSsId(ssId);
		resText.setTransNo(transNo);		
		String[] results = TomcatHttpServlet.send(resText,request);
		
		StringBuffer message = new StringBuffer();
		if(this.sendSuccess(results)){
			message.append("正在设置维护员信息，请稍后...");
		}else{
			transNo = "";
			message.append("设置维护员失败，请稍后重试！错误信息:"+results[1]);
		}
		
		request.setAttribute("message",message);
		request.setAttribute("tranNO", transNo);
		request.setAttribute("transType", Global.BOX_GUI_SETSYSTEMUSER);
		
		return SUCCESS;
	}
	
	/**
	 * 获取快递员组列表
	 * @return
	 * @throws Exception
	 */
	public String listCourier() throws Exception{		
		String _pageNumber = request.getParameter("pageNumber")==null?"1":request.getParameter("pageNumber");
		String groupName = request.getParameter("groupName")==null?"":request.getParameter("groupName");
		String ssId = request.getParameter("ssId")==null?"":request.getParameter("ssId");
		String districtId = request.getParameter("districtId")==null?"":request.getParameter("districtId");
		String checkedGroupId = request.getParameter("checkedGroupId")==null?"":request.getParameter("checkedGroupId");
		String checkedGroupName = request.getParameter("checkedGroupName")==null?"":request.getParameter("checkedGroupName");
		String _pageSize = request.getParameter("pageSize")==null?(Global.PAGE_SIZE+""):request.getParameter("pageSize");		
		String _exePermission = request.getParameter("exePermission")==null?"0":request.getParameter("exePermission");
		
		// 调出区域目录树
		String parentGbId = Global.GB_DISTRICT_TREE_ROOT;
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(parentGbId);
		request.setAttribute("gds", gds);
		String districtName = "";
		if(StringUtil.isNotBlank(districtId)){
			districtName = gbDistrictService.getGBDistrictFullName(districtId);
		}
		request.setAttribute("districtName", districtName);
		request.setAttribute("nextId", "cityTD");
		request.setAttribute("districtId", districtId);
		//地域end
		
		int pageNumber = Integer.parseInt(_pageNumber);
		int pageSize = Integer.parseInt(_pageSize);
		
		Courierx courierx = new Courierx();
		courierx.setSsId(ssId);
		courierx.setGroupName(groupName);
		courierx.setDistrictId(districtId);
		courierx.setExePermission(Integer.parseInt(_exePermission));
		
		int items = courierService.getCourierxItmes(courierx);
		Page page = new Page();
		page.setPageAllCount(items);
		page.setPageNumber(pageNumber);
		page.setPageSize(pageSize);
		
		List<Courierx> listCourier = courierService.getCourierxList(courierx,page);
		
		request.setAttribute("listCourier", listCourier);
		request.setAttribute("page", page);
		request.setAttribute("courierx", courierx);
		request.setAttribute("checkedGroupId", checkedGroupId);
		request.setAttribute("checkedGroupName", checkedGroupName);
		
		return SUCCESS;
	}
	
	/**
	 * 显示更多
	 * @throws Exception
	 */
	public void showMoreCourier() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String _pageNumber = request.getParameter("pageNumber")==null?"1":request.getParameter("pageNumber");
		String _pageSize = request.getParameter("pageSize")==null?(Global.PAGE_SIZE+""):request.getParameter("pageSize");
		
		String ssId = request.getParameter("ssId")==null?"":request.getParameter("ssId");
		String groupName = request.getParameter("groupName")==null?"":request.getParameter("groupName");		
		String districtId = request.getParameter("districtId")==null?"":request.getParameter("districtId");
		
		
		Courierx courierx = new Courierx();
		courierx.setSsId(ssId);
		courierx.setGroupName(groupName);
		courierx.setDistrictId(districtId);
		
		int items = courierService.getCourierxItmes(courierx);
		
		int pageNumber = Integer.parseInt(_pageNumber);
		int pageSize = Integer.parseInt(_pageSize);
		Page page = new Page();
		page.setPageAllCount(items);
		page.setPageNumber(pageNumber);
		page.setPageSize(pageSize);
		
		List<Courierx> listCourier = courierService.getCourierxList(courierx,page);
		Map<String,Object> root=new HashMap<String,Object>();
		root.put("listCourier", listCourier);
		String context = new FreemarkerUtil().getContext(root, "Courier.ftl");
		log.info("showMoreCourier："+context);
		response.getWriter().write(context);
	}
	
	
	/**
	 * 设置收件快递员
	 * @return
	 * @throws Exception
	 */
	public String setRecipientCourier() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String ssId = request.getParameter("ssId");
		String groupIds = request.getParameter("groupIds"); //快递员组
		String[] groupArr = groupIds.split("@");
		
		Storagestationx stor = storagestationaService.loadStoragestationStatus(ssId);
		storagestationaService.updateStoragestationDeliveryG(opUserId, groupArr, ssId, Global.RECIPIENT);
		
		String transNo = KeyHelper.creatKey();
		ResponseText resText = new ResponseText();
		resText.setResponseType(Global.BOX_GUI_RECIPIENTCOURIER);
		resText.setSsCode(stor.getSsCode());
		resText.setSsId(ssId);
		resText.setTransNo(transNo);		
		String[] results = TomcatHttpServlet.send(resText,request);
		
		StringBuffer message = new StringBuffer();
		if(this.sendSuccess(results)){
			message.append("正在设置收件快递员，请稍后...");
		}else{
			transNo = "";
			message.append("设置收件快递员失败，请稍后重试！错误信息:"+results[1]);
		}	
		request.setAttribute("message",message);
		request.setAttribute("tranNO", transNo);
		request.setAttribute("transType",Global.BOX_GUI_RECIPIENTCOURIER);
		request.setAttribute("ssId", ssId);
		return SUCCESS;
	}
	
	/**
	 * 设置投件快递员
	 * @return
	 * @throws Exception
	 */
	public String setCastPartsCourier() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String ssId = request.getParameter("ssId");
		String groupIds = request.getParameter("groupIds"); //快递员组
		String[] groupArr = groupIds.split("@");
		
		storagestationaService.updateStoragestationDeliveryG(opUserId, groupArr, ssId, Global.SENDPIECES);
		Storagestationx stor = storagestationaService.loadStoragestationStatus(ssId);
		
		String transNo = KeyHelper.creatKey();
		ResponseText resText = new ResponseText();
		resText.setResponseType(Global.BOX_GUI_CASTPARTS);
		resText.setSsCode(stor.getSsCode());
		resText.setSsId(ssId);
		resText.setTransNo(transNo);		
		String[] results = TomcatHttpServlet.send(resText,request);
		
		StringBuffer message = new StringBuffer();
		if(sendSuccess(results)){
			message.append("正在设置投件快递员，请稍后...");
		}else{
			transNo = "";
			message.append("设置投件快递员失败，请稍后重试！错误信息:"+results[1]);
		}	
		request.setAttribute("message",message);
		request.setAttribute("tranNO", transNo);
		request.setAttribute("transType",Global.BOX_GUI_CASTPARTS);
		request.setAttribute("ssId", ssId);
		
		return SUCCESS;
	}
	
	/**
	 * 查询物箱状态
	 * @return
	 * @throws Exception
	 */
	public String searchStorStatus() throws Exception{
		String ssId = request.getParameter("ssId");
		Storagestationx stor = storagestationaService.loadStoragestationStatus(ssId);
		
		String transNo = KeyHelper.creatKey();
		ResponseText resText = new ResponseText();
		resText.setSsCode(stor.getSsCode());
		resText.setResponseType(Global.BOX_GUI_BOXSTATUS);
		resText.setSsId(ssId);
		resText.setTransNo(transNo);		
		String[] results = TomcatHttpServlet.send(resText,request);
		
		StringBuffer message = new StringBuffer();
		if(this.sendSuccess(results)){
			message.append("正在查询物箱信息，请稍后...");
		}else{
			transNo = "";
			message.append("查询物箱信息失败，请稍后重试！错误信息:"+results[1]);
		}	
		request.setAttribute("message",message);
		request.setAttribute("tranNO", transNo);
		request.setAttribute("transType",Global.BOX_GUI_BOXSTATUS);
		request.setAttribute("ssId", ssId);
		
		return SUCCESS;
	}
	
	
	/**
	 * 获取物箱信息(查询物箱状态)
	 * @return
	 * @throws Exception
	 */
	public void getStoragestationInfo(String ssId) throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		Storagestationx stor = storagestationaService.loadStoragestationStatus(ssId); //获取物箱信息		
		
		Map<String,Object> root=new HashMap<String,Object>();
		root.put("stor", stor);
		String context = new FreemarkerUtil().getContext(root, "StoragestationStatus.ftl");
		log.info(context);
		response.getWriter().write(context);
	}
	
	/**
	 * 查询外围设备状态
	 * @return
	 * @throws Exception
	 */
	public String searchPeripheralStatus() throws Exception{
		String ssId = request.getParameter("ssId");
		Storagestationx stor = storagestationaService.loadStoragestationStatus(ssId);
		
		String transNo = KeyHelper.creatKey();
		ResponseText resText = new ResponseText();
		resText.setResponseType(Global.BOX_GUI_PERIPHERAL);
		resText.setSsCode(stor.getSsCode());
		resText.setSsId(ssId);
		resText.setTransNo(transNo);		
		String[] results = TomcatHttpServlet.send(resText,request);
		
		StringBuffer message = new StringBuffer();
		if(this.sendSuccess(results)){
			message.append("正在查询外围设备信息，请稍后...");
		}else{
			transNo = "";
			message.append("查询外围设备信息失败，请稍后重试！错误信息:"+results[1]);
		}	
		request.setAttribute("message",message);
		request.setAttribute("tranNO", transNo);
		request.setAttribute("transType",Global.BOX_GUI_PERIPHERAL);
		request.setAttribute("ssId", ssId);
		
		return SUCCESS;
	}
	
	/**
	 * 获取外围设备状态
	 * @param ssId
	 * @return
	 * @throws Exception
	 */
	public void loadPeripheralxStatus(String ssId) throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		List<Peripheralx> peripheralx = storagestationaService.loadPeripheralxInfo(ssId);	
		
		Map<String,Object> root=new HashMap<String,Object>();
		root.put("peripheralx", peripheralx);
		String context = new FreemarkerUtil().getContext(root, "loadPeripheralxStatus.ftl");
		log.info(context);
		response.getWriter().write(context);
	}
	
	
	/**
	 * 查询外围设备状态
	 * @return
	 * @throws Exception
	 */
	public String searchBoxInfoStatus() throws Exception{
		String boxId = request.getParameter("boxId");
		boxId = boxId.replaceAll("box_", "");
		String ssId = request.getParameter("ssId");
		Storagestationx stor = storagestationaService.loadStoragestationStatus(ssId);
		
		String transNo = KeyHelper.creatKey();
		ResponseText resText = new ResponseText();
		resText.setResponseType(Global.BOX_GUI_BOXINFO);
		resText.setSsCode(stor.getSsCode());
		resText.setSsId(ssId);
		resText.setTransNo(transNo);		
		String[] results = TomcatHttpServlet.send(resText,request);
		
		StringBuffer message = new StringBuffer();
		if(this.sendSuccess(results)){
			message.append("正在查询箱子信息，请稍后...");
		}else{
			transNo = "";
			message.append("查询箱子信息失败，请稍后重试！错误信息:"+results[1]);
		}	
		request.setAttribute("message",message);
		request.setAttribute("tranNO", transNo);
		request.setAttribute("transType",Global.BOX_GUI_BOXINFO);
		request.setAttribute("ssId", ssId);
		request.setAttribute("boxCode", boxId);
		
		return SUCCESS;
	}
	
	/**
	 * 获取外围设备状态
	 * @param ssId
	 * @return
	 * @throws Exception
	 */
	public void loadBoxInfoStatus(String ssId,String boxCode) throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		Map<String,Object> root=new HashMap<String,Object>();
		List<BoxInfox> boxList = new ArrayList<BoxInfox>();
		if(this.isMainBox(boxCode)){ //如果为主控柜,需要查询所以箱子状态
			boxList = storagestationaService.loadBoxInfoxList(ssId);
			
		}else{
			BoxInfox boxInfox = storagestationaService.loadBoxInfox(ssId, boxCode);			
			boxList.add(boxInfox);
		}
		root.put("boxList", boxList);
		String context = new FreemarkerUtil().getContext(root, "boxInfoStatus.ftl");
		log.info(context);
		response.getWriter().write(context);
	}	
	
	/**
	 * 是否为主控柜
	 * @param boxId
	 * @return
	 * @throws Exception
	 */
	private boolean isMainBox(String boxId) throws Exception{
		boolean bool = false;
		if(boxId.equals("box_0")){
			bool = true;
		}else if(boxId.equals("0")){
			bool = true;
		}
		return bool;		
	}
	
	/**
	 * 根据物箱代码与箱子序号获取箱子代码
	 * @param ssCode
	 * @return
	 */
	public String getBoxCode(String ssCode,String boxId){
		StringBuffer buffer = new StringBuffer(boxId);
		if(boxId.length()<3){
			for (int i = 0; i < 3-boxId.length(); i++) {
				buffer.insert(0, "0");
			}
		}
		buffer.insert(0, ssCode);
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		StoragestationaGUIAction g = new StoragestationaGUIAction();
		String s = g.getBoxCode("31010100010101", "99");
		System.out.println(s);
	}
	
}
