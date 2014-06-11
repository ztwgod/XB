package cn.com.xb.plat.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import cn.com.xb.domain.base.BlobFiles;
import cn.com.xb.domain.base.CourierGroup;
import cn.com.xb.domain.base.ExpressCompany;
import cn.com.xb.domain.base.FlagDictionary;
import cn.com.xb.domain.base.GbDistrict;
import cn.com.xb.domain.base.PCourier;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.displayWrapper.CourierGroupWrapper;
import cn.com.xb.domain.displayWrapper.CourierWrapper;
import cn.com.xb.domain.parameterWrapper.GetCourierGroupParam;
import cn.com.xb.domain.parameterWrapper.GetCourierListParam;
import cn.com.xb.service.CourierService;
import cn.com.xb.service.FlagDictionaryService;
import cn.com.xb.service.GbDistrictService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.PathUtility;
import cn.com.xb.util.SessionManger;
import cn.com.xb.util.StringUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 快递员管理
 * 	1、处理快递员的申请，修改，查询
 * 	2、处理快递员组的添加，修改，查询
 * 
 * @author DiGua
 * 
 */
public class CourierManagementAction extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	private FlagDictionaryService flagDictionaryService;
	private CourierService courierService;
	private GbDistrictService gbDistrictService;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	
	private String userId;
	private String snapshotPicId;
	private String paperworkPic1Id;
	private String paperworkPic2Id;
	private File snapshotPic;
	private File paperworkPic1;
	private File paperworkPic2;
	private String snapshotPicContentType;
	private String paperworkPic1ContentType;
	private String paperworkPic2ContentType;
	private String snapshotPicFileName;
	private String paperworkPic1FileName;
	private String paperworkPic2FileName;
	

	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}
	public void setHttpSession(HttpSession session)
	{
		this.session = session;
	}
	public void setFlagDictionaryService(FlagDictionaryService flagDictionaryService)
	{
		this.flagDictionaryService = flagDictionaryService;
	}
	public void setCourierService(CourierService courierService)
	{
		this.courierService = courierService;
	}
	public void setGbDistrictService(GbDistrictService gbDistrictService)
	{
		this.gbDistrictService = gbDistrictService;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setSnapshotPicId(String snapshotPicId)
	{
		this.snapshotPicId = snapshotPicId;
	}
	public void setPaperworkPic1Id(String paperworkPic1Id)
	{
		this.paperworkPic1Id = paperworkPic1Id;
	}
	public void setPaperworkPic2Id(String paperworkPic2Id)
	{
		this.paperworkPic2Id = paperworkPic2Id;
	}
	public void setSnapshotPic(File snapshotPic)
	{
		this.snapshotPic = snapshotPic;
	}
	public void setPaperworkPic1(File paperworkPic1)
	{
		this.paperworkPic1 = paperworkPic1;
	}
	public void setPaperworkPic2(File paperworkPic2)
	{
		this.paperworkPic2 = paperworkPic2;
	}
	public void setSnapshotPicContentType(String snapshotPicContentType)
	{
		this.snapshotPicContentType = snapshotPicContentType;
	}
	public void setPaperworkPic1ContentType(String paperworkPic1ContentType)
	{
		this.paperworkPic1ContentType = paperworkPic1ContentType;
	}
	public void setPaperworkPic2ContentType(String paperworkPic2ContentType)
	{
		this.paperworkPic2ContentType = paperworkPic2ContentType;
	}
	public void setSnapshotPicFileName(String snapshotPicFileName)
	{
		this.snapshotPicFileName = snapshotPicFileName;
	}
	public void setPaperworkPic1FileName(String paperworkPic1FileName)
	{
		this.paperworkPic1FileName = paperworkPic1FileName;
	}
	public void setPaperworkPic2FileName(String paperworkPic2FileName)
	{
		this.paperworkPic2FileName = paperworkPic2FileName;
	}
	
	
	
	/**
	 * 跳转至添加快递员信息页面
	 * @return
	 * @throws Exception
	 */
	public String toAddCourierPage() throws Exception
	{
		// 查询快递员状态列表
		List<FlagDictionary> fds = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_COURIER_STATUS);
		
		// 查询快递公司列表
		List<ExpressCompany> ecs = courierService.getCourierCompanies(null,null);
		
		// 查询行政区域列表
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(Global.GB_DISTRICT_TREE_ROOT);

		// 证件类型
		List<FlagDictionary> idList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_PAPERWORK_TYPE);
		
		request.setAttribute("fds", fds);
		request.setAttribute("ecs", ecs);
		request.setAttribute("gds", gds);
		request.setAttribute("idList", idList);
		request.setAttribute("nextId", "cityTD");
		return SUCCESS;
	}
	
	
	/**
	 * 获取快递公司的所有快递员组
	 * @return
	 * @throws Exception
	 */
	public String getCourierGroupListBycouComId() throws Exception
	{
		String couComId = StringUtil.formatStringTrimToNull(request.getParameter("couComId"));
		
		// 查询快递员组列表 couComId
		List<CourierGroup> cgs = courierService.getCourierGroupList(couComId);

		request.setAttribute("cgs", cgs);
		return SUCCESS;
	}
	
	
	/**
	 * 添加快递员信息
	 * @return
	 * @throws Exception
	 */
	public String addCourierInfo() throws Exception
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String userAccount = StringUtil.formatStringTrimToNull(request.getParameter("userAccount"));
		String chName = StringUtil.formatStringTrimToNull(request.getParameter("chName"));
		int    gender = StringUtil.formatStringToInteger(request.getParameter("gender"), 3);
		int    courierStatus = StringUtil.formatStringToInteger(request.getParameter("courierStatus"), 3);
		String mobile = StringUtil.formatStringTrimToNull(request.getParameter("mobile"));
		String email = StringUtil.formatStringTrimToNull(request.getParameter("email"));
		String password = StringUtil.formatStringTrimToNull(request.getParameter("password"));
		String excoId = StringUtil.formatStringTrimToNull(request.getParameter("excoId"));
		String groupId = StringUtil.formatStringTrimToNull(request.getParameter("groupId"));
		String localeId = StringUtil.formatStringTrimToNull(request.getParameter("localeId"));
		String usualAddress = StringUtil.formatStringTrimToNull(request.getParameter("usualAddress"));
		String zipCode = StringUtil.formatStringTrimToNull(request.getParameter("zipCode"));
		String registerAddress = StringUtil.formatStringTrimToNull(request.getParameter("registerAddress"));
		int    idType = StringUtil.formatStringToInteger(request.getParameter("idType"), 0);
		String idNo = StringUtil.formatStringTrimToNull(request.getParameter("idNo"));
		
		User user = new User();
		user.setUserId(KeyHelper.creatKey());
		user.setUserAccount(userAccount);
		user.setUserName(chName);
		user.setGender(gender);
		user.setMobileNumber(mobile);
		user.setEmail(email);
		user.setPassword(password);
		user.setHabitualResidence(usualAddress);
		user.setHouseholdRegisterAddress(registerAddress);
		user.setZipCode(zipCode);
		user.setPaperworkType(idType);
		user.setPaperworkNum(idNo);
		user.setCreateTime(new Timestamp(new Date().getTime()));
		user.setUserType(Global.USER_TYPE_2);
		user.setStatus(Global.USER_STATUS_WX);
		
		PCourier courier = new PCourier();
		courier.setUserId(user.getUserId());
		courier.setExcoId(excoId);
		courier.setGroupId(groupId);
		courier.setLocaleId(localeId);
		courier.setCourierStatus(courierStatus);
		
		courierService.insertCourierUserInfo(opUserId, courier, user);
		
		request.setAttribute("userId", user.getUserId());
		
		return SUCCESS;
	}
	
	
	/**
	 * 上传快递员电子快照、证件照
	 * @return
	 * @throws Exception
	 */
	public String uploadCourierPic() throws Exception
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String userId = StringUtil.formatStringTrimToNull(request.getParameter("userId"));
		BlobFiles snapshot = null;
		BlobFiles paperwork1 = null;
		BlobFiles paperwork2 = null;
		
		
		if(StringUtil.isNotBlank(snapshotPicFileName) && snapshotPic != null)
		{
			snapshot = new BlobFiles();
			snapshot.setFileId(KeyHelper.creatKey());
			snapshot.setFileName(snapshotPicFileName);
			snapshot.setFileType(snapshotPicContentType);
			snapshot.setFileSuffix(snapshotPicFileName.substring(snapshotPicFileName.lastIndexOf(".")));
			snapshot.setFileSize(snapshotPic.getTotalSpace());
			
			File dirs = new File(PathUtility.getRealPath("/") + Global.TEMP_PATH);
			if(!dirs.exists())
			{
				dirs.mkdirs();
			}
			File newSnapshot = new File(dirs, snapshot.getFileId() + snapshot.getFileSuffix());
			FileUtils.copyFile(snapshotPic, newSnapshot);
			snapshot.setFileContents(newSnapshot);
		}
		if(StringUtil.isNotBlank(paperworkPic1FileName) && paperworkPic1 != null)
		{
			paperwork1 = new BlobFiles();
			paperwork1.setFileId(KeyHelper.creatKey());
			paperwork1.setFileName(paperworkPic1FileName);
			paperwork1.setFileType(paperworkPic1ContentType);
			paperwork1.setFileSuffix(paperworkPic1FileName.substring(paperworkPic1FileName.lastIndexOf(".")));
			
			File dirs = new File(PathUtility.getRealPath("/") + Global.TEMP_PATH);
			if(!dirs.exists())
			{
				dirs.mkdirs();
			}
			File newPaperwork = new File(dirs, paperwork1.getFileId() + paperwork1.getFileSuffix());
			FileUtils.copyFile(paperworkPic1, newPaperwork);
			paperwork1.setFileContents(newPaperwork);
		}
		if(StringUtil.isNotBlank(paperworkPic2FileName) && paperworkPic2 != null)
		{
			paperwork2 = new BlobFiles();
			paperwork2.setFileId(KeyHelper.creatKey());
			paperwork2.setFileName(paperworkPic2FileName);
			paperwork2.setFileType(paperworkPic2ContentType);
			paperwork2.setFileSuffix(paperworkPic2FileName.substring(paperworkPic2FileName.lastIndexOf(".")));
			
			File dirs = new File(PathUtility.getRealPath("/") + Global.TEMP_PATH);
			if(!dirs.exists())
			{
				dirs.mkdirs();
			}
			File newPaperwork = new File(dirs, paperwork2.getFileId() + paperwork2.getFileSuffix());
			FileUtils.copyFile(paperworkPic2, newPaperwork);
			paperwork2.setFileContents(newPaperwork);
		}
		
		int flag = courierService.insertCourierSnapshot(opUserId, userId, snapshot, paperwork1, paperwork2);
		
		if(flag != 0)
		{
			if(snapshot != null)
			{
				File dirs = new File(PathUtility.getRealPath("/") + Global.SNAP_PATH);
				if(!dirs.exists())
				{
					dirs.mkdirs();
				}
				File newSnapshot = new File(dirs, snapshot.getFileId() + snapshot.getFileSuffix());
				FileUtils.copyFile(snapshot.getFileContents(), newSnapshot);
			}
			if(StringUtil.isNotBlank(paperworkPic1FileName) && paperworkPic1 != null)
			{
				File dirs = new File(PathUtility.getRealPath("/") + Global.PAPER_PATH);
				if(!dirs.exists())
				{
					dirs.mkdirs();
				}
				File newPaperwork = new File(dirs, paperwork1.getFileId() + paperwork1.getFileSuffix());
				FileUtils.copyFile(paperwork1.getFileContents(), newPaperwork);
			}
			if(StringUtil.isNotBlank(paperworkPic2FileName) && paperworkPic2 != null)
			{
				File dirs = new File(PathUtility.getRealPath("/") + Global.PAPER_PATH);
				if(!dirs.exists())
				{
					dirs.mkdirs();
				}
				File newPaperwork = new File(dirs, paperwork2.getFileId() + paperwork2.getFileSuffix());
				FileUtils.copyFile(paperwork2.getFileContents(), newPaperwork);
			}
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 跳转至修改快递员信息页面
	 * @return
	 * @throws Exception
	 */
	public String toModifyCourierPage() throws Exception
	{
		String userId = StringUtil.formatStringTrimToNull(request.getParameter("userId"));
		
		// 获取快递员详细信息
		CourierWrapper cw = courierService.getCourierWrapperInfo(userId);
		// 查询快递员状态列表
		List<FlagDictionary> fds = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_COURIER_STATUS);
		
		// 查询快递公司列表
		List<ExpressCompany> ecs = courierService.getCourierCompanies(null,null);
		
		// 查询行政区域列表
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(Global.GB_DISTRICT_TREE_ROOT);

		// 证件类型
		List<FlagDictionary> idList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_USER_PAPERWORK_TYPE);
		
		request.setAttribute("fds", fds);
		request.setAttribute("ecs", ecs);
		request.setAttribute("gds", gds);
		request.setAttribute("idList", idList);
		request.setAttribute("nextId", "cityTD");
		request.setAttribute("cw", cw);
		return SUCCESS;
	}
	
	
	/**
	 * 修改快递员信息
	 * @return
	 * @throws Exception
	 */
	public String doModifyCourierInfo() throws Exception
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String userId = StringUtil.formatStringTrimToNull(request.getParameter("userId"));
		String chName = StringUtil.formatStringTrimToNull(request.getParameter("chName"));
		int    gender = StringUtil.formatStringToInteger(request.getParameter("gender"), 3);
		int    courierStatus = StringUtil.formatStringToInteger(request.getParameter("courierStatus"), 3);
		String mobile = StringUtil.formatStringTrimToNull(request.getParameter("mobile"));
		String email = StringUtil.formatStringTrimToNull(request.getParameter("email"));
		String password = StringUtil.formatStringTrimToNull(request.getParameter("password"));
		String excoId = StringUtil.formatStringTrimToNull(request.getParameter("excoId"));
		int    groupIsChange = StringUtil.formatStringToInteger(request.getParameter("groupIsChange"), 0);
		String groupId = StringUtil.formatStringTrimToNull(request.getParameter("groupId"));
		String localeId = StringUtil.formatStringTrimToNull(request.getParameter("localeId"));
		String usualAddress = StringUtil.formatStringTrimToNull(request.getParameter("usualAddress"));
		String zipCode = StringUtil.formatStringTrim(request.getParameter("zipCode"));
		String registerAddress = StringUtil.formatStringTrimToNull(request.getParameter("registerAddress"));
		int    idType = StringUtil.formatStringToInteger(request.getParameter("idType"), 0);
		String idNo = StringUtil.formatStringTrimToNull(request.getParameter("idNo"));
		
		User user = new User();
		user.setUserId(userId);
		user.setUserName(chName);
		user.setGender(gender);
		user.setMobileNumber(mobile);
		user.setEmail(email);
		user.setPassword(password);
		user.setHabitualResidence(usualAddress);
		user.setHouseholdRegisterAddress(registerAddress);
		user.setZipCode(zipCode);
		user.setPaperworkType(idType);
		user.setPaperworkNum(idNo);
		user.setUserType(Global.USER_TYPE_2);
		user.setStatus(Global.USER_STATUS_WX);
		
		PCourier courier = new PCourier();
		courier.setUserId(user.getUserId());
		courier.setExcoId(excoId);
		if(groupIsChange != 0)
		{
			courier.setGroupId(groupId);
		}
		courier.setLocaleId(localeId);
		courier.setCourierStatus(courierStatus);
		
		courierService.updateCourierUserInfo(opUserId, courier, user);
		
		this.userId = user.getUserId();
		return SUCCESS;
	}
	
	
	/**
	 * 跳转修改快递员快照页面
	 * @return
	 * @throws Exception
	 */
	public String toModifyCourierPicPage() throws Exception
	{
		String userId = StringUtil.formatStringTrimToNull(request.getParameter("userId"));
		userId = StringUtil.isNotBlank(userId) ? userId : StringUtil.formatStringTrimToNull(request.getAttribute("userId"));
		
//		System.out.println("userId : " + userId);
		CourierWrapper cw = courierService.getCourierSnapshotInfo(userId);

		request.setAttribute("cw", cw);
		request.setAttribute("userId", userId);
		return SUCCESS;
	}
	
	
	/**
	 * 修改快递员快照
	 * @return
	 * @throws Exception
	 */
	public String doModifyCourierPicInfo() throws Exception
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String userId = StringUtil.formatStringTrimToNull(request.getParameter("userId"));
		BlobFiles snapshot = null;
		BlobFiles paperwork1 = null;
		BlobFiles paperwork2 = null;
		
		if(StringUtil.isNotBlank(snapshotPicFileName) && snapshotPic != null)
		{
			snapshot = new BlobFiles();
			snapshot.setFileId(StringUtil.isNotBlank(snapshotPicId) ? snapshotPicId : KeyHelper.creatKey());
			snapshot.setFileName(snapshotPicFileName);
			snapshot.setFileType(snapshotPicContentType);
			snapshot.setFileSuffix(snapshotPicFileName.substring(snapshotPicFileName.lastIndexOf(".")));
			snapshot.setFileSize(snapshotPic.getTotalSpace());
			
			File dirs = new File(PathUtility.getRealPath("/") + Global.TEMP_PATH);
			if(!dirs.exists())
			{
				dirs.mkdirs();
			}
			File newSnapshot = new File(dirs, snapshot.getFileId() + snapshot.getFileSuffix());
			FileUtils.copyFile(snapshotPic, newSnapshot);
			snapshot.setFileContents(newSnapshot);
		}
		if(StringUtil.isNotBlank(paperworkPic1FileName) && paperworkPic1 != null)
		{
			paperwork1 = new BlobFiles();
			paperwork1.setFileId(StringUtil.isNotBlank(paperworkPic1Id) ? paperworkPic1Id : KeyHelper.creatKey());
			paperwork1.setFileName(paperworkPic1FileName);
			paperwork1.setFileType(paperworkPic1ContentType);
			paperwork1.setFileSuffix(paperworkPic1FileName.substring(paperworkPic1FileName.lastIndexOf(".")));
			
			File dirs = new File(PathUtility.getRealPath("/") + Global.TEMP_PATH);
			if(!dirs.exists())
			{
				dirs.mkdirs();
			}
			File newPaperwork = new File(dirs, paperwork1.getFileId() + paperwork1.getFileSuffix());
			FileUtils.copyFile(paperworkPic1, newPaperwork);
			paperwork1.setFileContents(newPaperwork);
		}
		if(StringUtil.isNotBlank(paperworkPic2FileName) && paperworkPic2 != null)
		{
			paperwork2 = new BlobFiles();
			paperwork2.setFileId(StringUtil.isNotBlank(paperworkPic2Id) ? paperworkPic2Id : KeyHelper.creatKey());
			paperwork2.setFileName(paperworkPic2FileName);
			paperwork2.setFileType(paperworkPic2ContentType);
			paperwork2.setFileSuffix(paperworkPic2FileName.substring(paperworkPic2FileName.lastIndexOf(".")));
			
			File dirs = new File(PathUtility.getRealPath("/") + Global.TEMP_PATH);
			if(!dirs.exists())
			{
				dirs.mkdirs();
			}
			File newPaperwork = new File(dirs, paperwork2.getFileId() + paperwork2.getFileSuffix());
			FileUtils.copyFile(paperworkPic2, newPaperwork);
			paperwork2.setFileContents(newPaperwork);
		}
		
		int flag = courierService.updateCourierSnapshot(opUserId, userId, snapshot, paperwork1, paperwork2);
		
		if(flag != 0)
		{
			if(snapshot != null)
			{
				File dirs = new File(PathUtility.getRealPath("/") + Global.SNAP_PATH);
				if(!dirs.exists())
				{
					dirs.mkdirs();
				}
				File newSnapshot = new File(dirs, snapshot.getFileId() + snapshot.getFileSuffix());
				FileUtils.copyFile(snapshot.getFileContents(), newSnapshot);
			}
			if(StringUtil.isNotBlank(paperworkPic1FileName) && paperworkPic1 != null)
			{
				File dirs = new File(PathUtility.getRealPath("/") + Global.PAPER_PATH);
				if(!dirs.exists())
				{
					dirs.mkdirs();
				}
				File newPaperwork = new File(dirs, paperwork1.getFileId() + paperwork1.getFileSuffix());
				FileUtils.copyFile(paperwork1.getFileContents(), newPaperwork);
			}
			if(StringUtil.isNotBlank(paperworkPic2FileName) && paperworkPic2 != null)
			{
				File dirs = new File(PathUtility.getRealPath("/") + Global.PAPER_PATH);
				if(!dirs.exists())
				{
					dirs.mkdirs();
				}
				File newPaperwork = new File(dirs, paperwork2.getFileId() + paperwork2.getFileSuffix());
				FileUtils.copyFile(paperwork2.getFileContents(), newPaperwork);
			}
		}
		
		return SUCCESS;
	}
	

	/**
	 * 删除快递员信息
	 * @return
	 * @throws Exception
	 */
	public String deleteCourierInfo() throws Exception
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String userId = StringUtil.formatStringTrimToNull(request.getParameter("userId"));
		
		courierService.deleteCourierInfo(opUserId, userId);
		
		return SUCCESS;
	}
	
	
	/**
	 * 查询快递员列表
	 * @return
	 * @throws Exception
	 */
	public String getCourierList() throws Exception
	{
		int pageNum 		= StringUtil.formatStringToInteger(request.getParameter("pageNum"), 1);
		String userName 	= StringUtil.formatStringTrimToNull(request.getParameter("userName"));
		String paperworkNum = StringUtil.formatStringTrimToNull(request.getParameter("paperworkNum"));
		String mobileNumber = StringUtil.formatStringTrimToNull(request.getParameter("mobileNumber"));
		String excoId 		= StringUtil.formatStringTrimToNull(request.getParameter("excoId"));
		
		GetCourierListParam gclp = new GetCourierListParam();
		gclp.setUserName(userName);
		gclp.setPaperworkNum(paperworkNum);
		gclp.setMobileNumber(mobileNumber);
		gclp.setExcoId(excoId);

		int allCount = courierService.getCourierSize(gclp);
		
		Page page = new Page();
		page.setPageNumber(pageNum);
		page.setPageSize(Global.PAGE_SIZE);
		page.setPageAllCount(allCount);
		
		List<CourierWrapper> cws = courierService.getCourierListLimit(gclp, page);
		
		// 查询快递公司
		List<ExpressCompany> ecs = courierService.getCourierCompanies(null,null);

		request.setAttribute("ecs", ecs);
		request.setAttribute("page", page);
		request.setAttribute("gclp", gclp);
		request.setAttribute("cws", cws);
		return SUCCESS;
	}
	
	
	/**
	 * 跳转到添加快递员组页面
	 * 
	 * ***********页面中需要根据地区动态列出该地区所有物箱列表**********
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toAddCourierGroupPage() throws Exception
	{
		String parentGbId = StringUtil.formatStringTrimToNull(request.getParameter("districtId"));
		parentGbId = parentGbId == null ? Global.GB_DISTRICT_TREE_ROOT : parentGbId;
		
		// 查询快递公司
		List<ExpressCompany> ecs = courierService.getCourierCompanies(null,null);
		// 调出区域目录树	GB_DISTRICT_TREE
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(parentGbId);
		
		request.setAttribute("ecs", ecs);
		request.setAttribute("gds", gds);
		request.setAttribute("nextId", "cityTD");
		return SUCCESS;
	}

	
	/**
	 * 获取子级区域列表
	 * @return
	 * @throws Exception
	 */
	public String getGbDistrictListByParentId() throws Exception
	{
		String nextId = StringUtil.formatStringTrimToNull(request.getParameter("nextId"));
		String parentGbId = StringUtil.formatStringTrimToNull(request.getParameter("districtId"));
		parentGbId = parentGbId == null ? Global.GB_DISTRICT_TREE_ROOT : parentGbId;
		
		// 调出区域列表
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(parentGbId);
		
		request.setAttribute("gds", gds);
		request.setAttribute("nextId", "cityTD".equals(nextId) ? "districtTD" : "districtTD".equals(nextId) ? "____" : "cityTD");
		return SUCCESS;
	}
	
	/**
	 * 添加快递员组
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doAddCourierGroup() throws Exception
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		// 将快递员组信息添加至数据库
		String groupName = StringUtil.formatStringTrimToNull(request.getParameter("groupName"));
		String pickContactorM = StringUtil.formatStringTrimToNull(request.getParameter("pickContactorM"));
		String excoId = StringUtil.formatStringTrimToNull(request.getParameter("excoId"));
		String districtId = StringUtil.formatStringTrimToNull(request.getParameter("districtId"));
		
		CourierGroup cg = new CourierGroup();
		
		cg.setGroupId(KeyHelper.creatKey());
		cg.setExcoId(excoId);
		cg.setDistrictId(districtId);
		cg.setGroupName(groupName);
		cg.setPickContactorM(pickContactorM);
		
		courierService.insertCourierGroupInfo(opUserId, cg);
		
		return SUCCESS;
	}
	
	
	/**
	 * 查看快递员组列表页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getListCourierGroup() throws Exception
	{
		String parentGbId = Global.GB_DISTRICT_TREE_ROOT;
		
		// 查询快递公司列表
		List<ExpressCompany> ecs = courierService.getCourierCompanies(null,null);
		// 调出区域目录树
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(parentGbId);
		// 查询快递员组权限
		List<FlagDictionary> permissions = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_EXE_TO_SS_PERMISSION);
		
		// 获取查询的页码，查询快递员组列表
		int pageNum = StringUtil.formatStringToInteger(request.getParameter("pageNum"), 1);
		String groupName = StringUtil.formatStringTrimToNull(request.getParameter("groupName"));
		String permission = StringUtil.formatStringTrimToNull(request.getParameter("permission"));
		String districtId = StringUtil.formatStringTrimToNull(request.getParameter("districtId"));
		String excoId = StringUtil.formatStringTrimToNull(request.getParameter("excoId"));
		
		GetCourierGroupParam gcgp = new GetCourierGroupParam();
		gcgp.setDistrictId(districtId);
		gcgp.setExcoId(excoId);
		gcgp.setGroupName(groupName);
		gcgp.setPermission(permission);
		
		int allCount = courierService.getCourierGroupListSize(gcgp);
		
		Page page = new Page();
		page.setPageNumber(pageNum);
		page.setPageSize(Global.PAGE_SIZE);
		page.setPageAllCount(allCount);
		
		List<CourierGroupWrapper> cgws = courierService.getCourierGroupListLimit(page, gcgp);
		
		String districtName = "";
		if(StringUtil.isNotBlank(districtId))
		{
			districtName = gbDistrictService.getGBDistrictFullName(districtId);
		}
		
		request.setAttribute("districtName", districtName);
		request.setAttribute("ecs", ecs);
		request.setAttribute("gds", gds);
		request.setAttribute("nextId", "cityTD");
		request.setAttribute("permission", permissions);
		request.setAttribute("cgws", cgws);
		request.setAttribute("page", page);
		request.setAttribute("gcgp", gcgp);
		return SUCCESS;
	}
	
	
	/**
	 * 跳转至修改快递员组页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toModifyCourierGroupPage() throws Exception
	{
		String parentGbId = Global.GB_DISTRICT_TREE_ROOT;
		
		// 查询快递公司列表
		List<ExpressCompany> ecs = courierService.getCourierCompanies(null,null);
		// 调出区域目录树
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(parentGbId);
		// 查询快递员组权限
		List<FlagDictionary> permissions = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_EXE_TO_SS_PERMISSION);
		
		// 获取快递员组ID，并查询该快递员组详情
		String groupId = StringUtil.formatStringTrimToNull(request.getParameter("groupId"));
		
		CourierGroup cg = courierService.getCourierGroupById(groupId);

		String districtName = "";
		if(null != cg && StringUtil.isNotBlank(cg.getDistrictId()))
		{
			districtName = gbDistrictService.getGBDistrictFullName(cg.getDistrictId());
		}
		request.setAttribute("districtName", districtName);
		request.setAttribute("ecs", ecs);
		request.setAttribute("gds", gds);
		request.setAttribute("nextId", "cityTD");
		request.setAttribute("permission", permissions);
		request.setAttribute("cg", cg);
		return SUCCESS;
	}
	
	/**
	 * 修改快递员组信息
	 * @return
	 * @throws Exception
	 */
	public String doModifyCourierGroup() throws Exception
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		// 获取快递员组详情，并执行修改操作。
		String groupId = StringUtil.formatStringTrimToNull(request.getParameter("groupId"));
		String groupName = StringUtil.formatStringTrimToNull(request.getParameter("groupName"));
		String pickContactorM = StringUtil.formatStringTrimToNull(request.getParameter("pickContactorM"));
		String excoId = StringUtil.formatStringTrimToNull(request.getParameter("excoId"));
		String districtId = StringUtil.formatStringTrimToNull(request.getParameter("districtId"));
		
		CourierGroup cg = new CourierGroup();
		
		cg.setGroupId(groupId);
		cg.setExcoId(excoId);
		cg.setDistrictId(districtId);
		cg.setGroupName(groupName);
		cg.setPickContactorM(pickContactorM);
		
		courierService.updateCourierGroupInfo(opUserId, cg);
		
		return SUCCESS;
	}
	
	
	/**
	 * 删除快递员组信息
	 * @return
	 * @throws Exception
	 */
	public String deleteCourierGroup() throws Exception 
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		// 获取快递员组ID，并删除快递员组信息
		String groupId = StringUtil.formatStringTrimToNull(request.getParameter("groupId"));
		
		courierService.deleteCourierGroup(opUserId, groupId);
		
		return SUCCESS;
	}
	
	
	/**
	 * 查询快递公司列表
	 * @return
	 * @throws Exception
	 */
	public String getListCourierCompanies() throws Exception
	{
		int pageNum = StringUtil.formatStringToInteger(request.getParameter("pageNum"), 1);
		String mobileNumber  = StringUtil.formatStringTrimToNull(request.getParameter("mobileNumber"));
		String excoName = StringUtil.formatStringTrimToNull(request.getParameter("excoName"));
		
		ExpressCompany expressCompany = new ExpressCompany();
		expressCompany.setContactPhone(mobileNumber);
		expressCompany.setExcoName(excoName);
		
		// 获取查询的页码，查询快递公司列表
		int allCount = courierService.getCourierCompaniesSize(expressCompany);
		
		Page page = new Page();
		page.setPageNumber(pageNum);
		page.setPageSize(Global.PAGE_SIZE);
		page.setPageAllCount(allCount);
		
		List<ExpressCompany> ecs = courierService.getCourierCompanies(page,expressCompany);
		
		request.setAttribute("expressCompany", expressCompany);
		request.setAttribute("page", page);
		request.setAttribute("ecs", ecs);
		return SUCCESS;
	}
	
	
	/**
	 * 跳转至添加快递公司页面
	 * @return
	 * @throws Exception
	 */
	public String toAddCourierCompanyPage() throws Exception
	{
		// 查询快递公司服务状态列表
		List<FlagDictionary> serviceStatusList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_EXP_COM_SERVICE_STATUS);
		
		request.setAttribute("serviceStatusList", serviceStatusList);
		return SUCCESS;
	}
	
	
	/**
	 * 添加快递公司信息
	 * @return
	 * @throws Exception
	 */
	public String addCourierCompany() throws Exception
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String excoId = KeyHelper.creatKey();
		String excoName = StringUtil.formatStringTrimToNull(request.getParameter("excoName"));
		String contactorName = StringUtil.formatStringTrimToNull(request.getParameter("contactorName"));
		String contactPhone = StringUtil.formatStringTrimToNull(request.getParameter("contactPhone"));
		String contactAdd = StringUtil.formatStringTrimToNull(request.getParameter("contactAdd"));
		int serviceStatus = StringUtil.formatStringToInteger(request.getParameter("serviceStatus"), 0);
		String contractNo = StringUtil.formatStringTrimToNull(request.getParameter("contractNo"));
		Timestamp validDate = StringUtil.formatStringToTimestamp(request.getParameter("validDate"), "yyyy-MM-dd", null);
		
		ExpressCompany ec = new ExpressCompany();
		ec.setExcoId(excoId);
		ec.setExcoName(excoName);
		ec.setContactorName(contactorName);
		ec.setContactPhone(contactPhone);
		ec.setContactAdd(contactAdd);
		ec.setServiceStatus(serviceStatus);
		ec.setContractNo(contractNo);
		ec.setValidDate(validDate);
		
		courierService.insertCourierCompanyInfo(opUserId, ec);
		
		return SUCCESS;
	}
	
	/**
	 * 跳转至修改快递公司信息页面
	 * @return
	 * @throws Exception
	 */
	public String toModifyCourierCompanyPage() throws Exception
	{
		String excoId = StringUtil.formatStringTrimToNull(request.getParameter("excoId"));
		
		// 查询快递公司详情
		ExpressCompany ec = courierService.loadCourierCompanyInfo(excoId);
		// 查询快递公司服务状态列表
		List<FlagDictionary> serviceStatusList = flagDictionaryService.loadDictionaryByTypeId(Global.DICTIONARY_TYPE_EXP_COM_SERVICE_STATUS);
		
		request.setAttribute("ec", ec);
		request.setAttribute("serviceStatusList", serviceStatusList);
		return SUCCESS;
	}
	
	
	/**
	 * 执行修改快递公司信息
	 * @return
	 * @throws Exception
	 */
	public String doModifyCourierCompany() throws Exception
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String excoId = StringUtil.formatStringTrimToNull(request.getParameter("excoId"));
		String excoName = StringUtil.formatStringTrimToNull(request.getParameter("excoName"));
		String contactorName = StringUtil.formatStringTrimToNull(request.getParameter("contactorName"));
		String contactPhone = StringUtil.formatStringTrimToNull(request.getParameter("contactPhone"));
		String contactAdd = StringUtil.formatStringTrimToNull(request.getParameter("contactAdd"));
		int serviceStatus = StringUtil.formatStringToInteger(request.getParameter("serviceStatus"), 0);
		String contractNo = StringUtil.formatStringTrimToNull(request.getParameter("contractNo"));
		Timestamp validDate = StringUtil.formatStringToTimestamp(request.getParameter("validDate"), "yyyy-MM-dd", null);
		
		ExpressCompany ec = new ExpressCompany();
		ec.setExcoId(excoId);
		ec.setExcoName(excoName);
		ec.setContactorName(contactorName);
		ec.setContactPhone(contactPhone);
		ec.setContactAdd(contactAdd);
		ec.setServiceStatus(serviceStatus);
		ec.setContractNo(contractNo);
		ec.setValidDate(validDate);
		
		courierService.updateCourierCompanyInfo(opUserId, ec);
		
		return SUCCESS;
	}
	
	
	/**
	 * 删除快递公司信息
	 * @return
	 * @throws Exception
	 */
	public String deleteCourierCompany() throws Exception
	{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String excoId = StringUtil.formatStringTrimToNull(request.getParameter("excoId"));
		
		courierService.deleteCourierCompany(opUserId, excoId);
		
		return SUCCESS;
	}
}
