package cn.com.xb.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import cn.com.xb.dao.ICourierGroupDao;
import cn.com.xb.dao.IExpressCompanyDao;
import cn.com.xb.dao.IOperationLogDao;
import cn.com.xb.dao.IPCourierDao;
import cn.com.xb.dao.IUserDao;
import cn.com.xb.daox.IBlobFilesDaox;
import cn.com.xb.daox.ICourierDaox;
import cn.com.xb.daox.IUserDaox;
import cn.com.xb.domain.base.BlobFiles;
import cn.com.xb.domain.base.CourierGroup;
import cn.com.xb.domain.base.Courierx;
import cn.com.xb.domain.base.ExpressCompany;
import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.domain.base.PCourier;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.displayWrapper.CourierGroupWrapper;
import cn.com.xb.domain.displayWrapper.CourierWrapper;
import cn.com.xb.domain.parameterWrapper.GetCourierGroupParam;
import cn.com.xb.domain.parameterWrapper.GetCourierListParam;
import cn.com.xb.inter.domain.ICourierAuthorityInfo;
import cn.com.xb.service.CourierService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.MD5;
import cn.com.xb.util.StringUtil;

public class CourierServiceImpl implements CourierService
{
	private IExpressCompanyDao expressCompanyDao;
	private ICourierDaox courierDaox;
	private ICourierGroupDao courierGroupDao;
	private IPCourierDao pCourierDao;
	private IUserDao userDao;
	private IBlobFilesDaox blobFilesDaox;
	private IUserDaox userDaox;
	private IOperationLogDao operationLogDao;
	

	public void setOperationLogDao(IOperationLogDao operationLogDao)
	{
		this.operationLogDao = operationLogDao;
	}
	public void setExpressCompanyDao(IExpressCompanyDao expressCompanyDao)
	{
		this.expressCompanyDao = expressCompanyDao;
	}
	public void setCourierDaox(ICourierDaox courierDaox)
	{
		this.courierDaox = courierDaox;
	}
	public void setCourierGroupDao(ICourierGroupDao courierGroupDao)
	{
		this.courierGroupDao = courierGroupDao;
	}
	public void setpCourierDao(IPCourierDao pCourierDao)
	{
		this.pCourierDao = pCourierDao;
	}
	public void setUserDao(IUserDao userDao)
	{
		this.userDao = userDao;
	}
	public void setBlobFilesDaox(IBlobFilesDaox blobFilesDaox)
	{
		this.blobFilesDaox = blobFilesDaox;
	}
	public void setUserDaox(IUserDaox userDaox)
	{
		this.userDaox = userDaox;
	}
	
	
	
	@Override
	public void insertCourierCompanyInfo(String opUserId, ExpressCompany ec) throws Exception
	{
		expressCompanyDao.insert(ec);
		
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(7);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("添加快递员公司信息，相关参数："+StringUtil.getOptionContent(new Object[]{ec}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}

	@Override
	public int getCourierCompaniesSize(ExpressCompany expressCompany) throws Exception
	{
		
		return courierDaox.getCourierCompaniesSize(expressCompany);
	}
	@Override
	public List<ExpressCompany> getCourierCompanies(Page page,ExpressCompany expressCompany) throws Exception
	{
		if(null == page)
			return expressCompanyDao.loadAll();
		else
			return courierDaox.getCourierCompanies(page.getStartItems(), page.getPageSize(),expressCompany);
	}
	@Override
	public void deleteCourierCompany(String opUserId, String excoId) throws Exception
	{
		ExpressCompany ec = expressCompanyDao.loadExpressCompanyByexcoId(excoId);
		expressCompanyDao.delete(excoId);
		
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(8);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("删除快递员公司信息，相关参数："+StringUtil.getOptionContent(new Object[]{ec}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}
	@Override
	public ExpressCompany loadCourierCompanyInfo(String excoId) throws Exception
	{
		return expressCompanyDao.loadExpressCompanyByexcoId(excoId);
	}
	@Override
	public void updateCourierCompanyInfo(String opUserId, ExpressCompany ec) throws Exception
	{
		expressCompanyDao.update(ec);
		
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(8);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("修改快递员公司信息，相关参数："+StringUtil.getOptionContent(new Object[]{ec}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}
	@Override
	public void insertCourierGroupInfo(String opUserId, CourierGroup cg) throws Exception
	{
		courierGroupDao.insert(cg);
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(1);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("添加快递员组信息，相关参数："+StringUtil.getOptionContent(new Object[]{cg}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}
	@Override
	public List<CourierGroupWrapper> getCourierGroupListLimit(Page page, GetCourierGroupParam gcgp) throws Exception
	{
		return courierDaox.getCourierGroupList(page.getStartItems(), page.getPageSize(), gcgp);
	}
	@Override
	public int getCourierGroupListSize(GetCourierGroupParam gcgp) throws Exception
	{
		return courierDaox.getCourierGroupListSize(gcgp);
	}
	@Override
	public void deleteCourierGroup(String opUserId, String groupId) throws Exception
	{
		CourierGroup cg = courierGroupDao.loadCourierGroupBygroupId(groupId);
		courierGroupDao.delete(groupId);
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(2);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("删除快递员组信息，相关参数："+StringUtil.getOptionContent(new Object[]{cg}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}
	@Override
	public CourierGroup getCourierGroupById(String groupId) throws Exception
	{
		return courierGroupDao.loadCourierGroupBygroupId(groupId);
	}
	@Override
	public void updateCourierGroupInfo(String opUserId, CourierGroup cg) throws Exception
	{
		courierGroupDao.update(cg);
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(2);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("修改快递员组信息，相关参数："+StringUtil.getOptionContent(new Object[]{cg}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}
	@Override
	public List<CourierGroup> getCourierGroupList(String couComId) throws Exception
	{
		if(StringUtil.isNotBlank(couComId))
			return courierDaox.getCourierGroupListByCouComId(couComId);
		else
			return courierGroupDao.loadAll();
	}
	@Override
	public void insertCourierUserInfo(String opUserId, PCourier courier, User user) throws Exception
	{
		if(courier != null && user != null)
		{
			user.setPassword(MD5.getMD5Str(user.getPassword()));
			userDao.insert(user);
			pCourierDao.insert(courier);
			
			OperationLog log = new OperationLog();
			log.setLogId(KeyHelper.creatKey());
			log.setSysPlatType(1);
			log.setOperationType(3);	// 操作类型
			log.setOperationUserId(opUserId);
			log.setOperationContent("添加快递员基本信息，相关参数："+StringUtil.getOptionContent(new Object[]{user, courier}));
			log.setOperationTime(new Timestamp(new Date().getTime()));
			operationLogDao.insert(log);// 添加日志
		}
	}
	@Override
	public int insertCourierSnapshot(String opUserId, String userId, BlobFiles snapshot, BlobFiles paperwork1, BlobFiles paperwork2) throws Exception
	{
		int flag = 0;
		if(StringUtil.isNotBlank(userId))
		{
			flag = 1;
			if(snapshot != null)
			{
				blobFilesDaox.insertBlobFile(snapshot);
			}
			if(paperwork1 != null)
			{
				blobFilesDaox.insertBlobFile(paperwork1);
				flag = 2;
			}
			if(paperwork2 != null)
			{
				blobFilesDaox.insertBlobFile(paperwork2);
				flag = 2;
			}
			
			courierDaox.updatePCourierSnapshotInfo(userId, snapshot == null ? null : snapshot.getFileId(), paperwork1 == null ? null : paperwork1.getFileId(), paperwork2 == null ? null : paperwork2.getFileId());
			if(flag == 2)
			{
				userDaox.updateUserStatus(userId, Global.USER_STATUS_WJH);
				
				OperationLog log = new OperationLog();
				log.setLogId(KeyHelper.creatKey());
				log.setSysPlatType(1);
				log.setOperationType(3);	// 操作类型
				log.setOperationUserId(opUserId);
				log.setOperationContent("添加快递员快照信息，相关参数："+StringUtil.getOptionContent(new Object[]{snapshot, paperwork1, paperwork2}));
				log.setOperationTime(new Timestamp(new Date().getTime()));
				operationLogDao.insert(log);// 添加日志
			}
		}
		else
		{
			System.out.println("上传快递员快照时，用户ID丢失");
		}
		
		return flag;
	}
	@Override
	public List<CourierWrapper> getCourierListLimit(GetCourierListParam gclp, Page page) throws Exception
	{
		return courierDaox.getCourierListLimit(gclp, page.getStartItems(), page.getPageSize());
	}
	@Override
	public int getCourierSize(GetCourierListParam gclp) throws Exception
	{
		return courierDaox.getCourierSize(gclp);
	}
	@Override
	public void deleteCourierInfo(String opUserId, String userId) throws Exception
	{
		if(StringUtil.isNotBlank(userId))
		{
			User user = userDao.loadUserByuserId(userId);
			PCourier courier = pCourierDao.loadPCourierByuserId(userId);
			List<BlobFiles> bfs = blobFilesDaox.getBlobFilesByUserId(userId);
			
			
			// 删除快递员用户信息
			userDao.delete(userId);
			// 删除快递员快照附件信息
			courierDaox.deleteCourierSnapshotInfo(userId);
			// 删除快递员信息
			pCourierDao.delete(userId);
			
			
			OperationLog log = new OperationLog();
			log.setLogId(KeyHelper.creatKey());
			log.setSysPlatType(1);
			log.setOperationType(4);	// 操作类型
			log.setOperationUserId(opUserId);
			log.setOperationContent("删除快递员信息，相关参数："+StringUtil.getOptionContent(new Object[]{user, courier, bfs}));
			log.setOperationTime(new Timestamp(new Date().getTime()));
			operationLogDao.insert(log);// 添加日志
		}
	}
	@Override
	public CourierWrapper getCourierWrapperInfo(String userId) throws Exception
	{
		return courierDaox.getCourierWrapperInfo(userId);
	}
	@Override
	public void updateCourierUserInfo(String opUserId, PCourier courier, User user) throws Exception
	{
		if(null != courier)
		{
			courierDaox.updateCourierInfo(courier);
		}
		if(null != user)
		{
			if(StringUtil.isNotBlank(user.getPassword()))
			{
				user.setPassword(MD5.getMD5Str(user.getPassword()));
			}
			userDaox.updateUserInfo(user);
		}
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(4);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("修改快递员基本信息，相关参数："+StringUtil.getOptionContent(new Object[]{courier, user}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}
	@Override
	public CourierWrapper getCourierSnapshotInfo(String userId) throws Exception
	{
		return courierDaox.getCourierSnapshotInfo(userId);
	}
	@Override
	public int updateCourierSnapshot(String opUserId, String userId, BlobFiles snapshot, BlobFiles paperwork1, BlobFiles paperwork2) throws Exception
	{
		int flag = 0;
		if(StringUtil.isNotBlank(userId))
		{
			flag = 1;
			if(snapshot != null)
			{
				blobFilesDaox.updateBlobFile(snapshot);
			}
			if(paperwork1 != null)
			{
				blobFilesDaox.updateBlobFile(paperwork1);
			}
			if(paperwork2 != null)
			{
				blobFilesDaox.updateBlobFile(paperwork2);
			}
			
			courierDaox.updatePCourierSnapshotInfo(userId, snapshot == null ? null : snapshot.getFileId(), paperwork1 == null ? null : paperwork1.getFileId(), paperwork2 == null ? null : paperwork2.getFileId());

			
			OperationLog log = new OperationLog();
			log.setLogId(KeyHelper.creatKey());
			log.setSysPlatType(1);
			log.setOperationType(4);	// 操作类型
			log.setOperationUserId(opUserId);
			log.setOperationContent("修改快递员快照信息，相关参数："+StringUtil.getOptionContent(new Object[]{snapshot, paperwork1, paperwork2}));
			log.setOperationTime(new Timestamp(new Date().getTime()));
			operationLogDao.insert(log);// 添加日志
		}
		else
		{
			System.out.println("上传快递员快照时，用户ID丢失");
		}
		
		return flag;
	}
	
	public int getCourierxItmes(Courierx courier) throws Exception {
		
		return courierDaox.getCourierxItmes(courier);
	}
	
	public List<Courierx> getCourierxList(Courierx courier, Page page)throws Exception {
		
		return courierDaox.getCourierxList(courier, page);
	}
	@Override
	public List<ICourierAuthorityInfo> getCourierInfoBySSid(String ssId,
			int exePermission) throws Exception {
		
		return courierDaox.getCourierInfoBySSid(ssId, exePermission);
	}	
}
