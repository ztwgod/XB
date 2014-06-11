package cn.com.xb.service;

import java.util.List;

import cn.com.xb.domain.base.BlobFiles;
import cn.com.xb.domain.base.CourierGroup;
import cn.com.xb.domain.base.Courierx;
import cn.com.xb.domain.base.ExpressCompany;
import cn.com.xb.domain.base.PCourier;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.User;
import cn.com.xb.domain.displayWrapper.CourierGroupWrapper;
import cn.com.xb.domain.displayWrapper.CourierWrapper;
import cn.com.xb.domain.parameterWrapper.GetCourierGroupParam;
import cn.com.xb.domain.parameterWrapper.GetCourierListParam;
import cn.com.xb.inter.domain.ICourierAuthorityInfo;

/**
 * 快递相关（快递员、快递公司、快递员组等）的服务
 * 
 * @author DiGua
 *
 */
public interface CourierService
{
	/**
	 * 添加快递公司信息
	 * @param ec
	 * @throws Exception
	 */
	public void insertCourierCompanyInfo(String opUserId, ExpressCompany ec) throws Exception;
	
	
	/**
	 * 查询快递公司总记录数
	 * @return
	 * @throws Exception
	 */
	public int getCourierCompaniesSize(ExpressCompany expressCompany) throws Exception;
	
	
	/**
	 * 查询快递公司列表
	 * @return
	 * @throws Exception
	 */
	public List<ExpressCompany> getCourierCompanies(Page page,ExpressCompany expressCompany) throws Exception;
	
	
	/**
	 * 删除快递公司信息
	 * @param excoId
	 * @throws Exception
	 */
	public void deleteCourierCompany(String opUserId, String excoId) throws Exception;

	
	/**
	 * 查询快递公司详情
	 * @param excoId
	 * @return
	 * @throws Exception
	 */
	public ExpressCompany loadCourierCompanyInfo(String excoId) throws Exception;
	
	
	/**
	 * 更新快递公司信息
	 * @param ec
	 * @throws Exception
	 */
	public void updateCourierCompanyInfo(String opUserId, ExpressCompany ec) throws Exception;
	
	
	/**
	 * 插入快递员组信息
	 * @param cg
	 * @throws Exception
	 */
	public void insertCourierGroupInfo(String opUserId, CourierGroup cg) throws Exception;
	
	
	/**
	 * 获取快递员组的总记录数
	 * @throws Exception
	 */
	public int getCourierGroupListSize(GetCourierGroupParam gcgp) throws Exception;
	
	
	/**
	 * 查询快递员组列表（不分页，查询所有）
	 * @return
	 * @throws Exception
	 */
	public List<CourierGroup> getCourierGroupList(String couComId) throws Exception;
	
	
	/**
	 * 查询快递员组列表（分页查询）
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CourierGroupWrapper> getCourierGroupListLimit(Page page, GetCourierGroupParam gcgp) throws Exception;
	
	/**
	 * 删除快递员组信息
	 * @param groupId
	 * @throws Exception
	 */
	public void deleteCourierGroup(String opUserId, String groupId) throws Exception;
	
	
	/**
	 * 获取快递员组信息
	 * @param groupId
	 * @throws Exception
	 */
	public CourierGroup getCourierGroupById(String groupId) throws Exception;
	
	
	/**
	 * 修改快递员组信息
	 * @param cg
	 * @throws Exception
	 */
	public void updateCourierGroupInfo(String opUserId, CourierGroup cg) throws Exception;
	
	
	/**
	 * 插入快递员用户信息
	 * @param courier
	 * @param user
	 * @throws Exception
	 */
	public void insertCourierUserInfo(String opUserId, PCourier courier, User user) throws Exception;
	
	
	/**
	 * 插入快递员快照及证件快照
	 * @param userId
	 * @param snapshot
	 * @param paperwork1
	 * @param paperwork2
	 * @throws Exception
	 */
	public int insertCourierSnapshot(String opUserId, String userId, BlobFiles snapshot, BlobFiles paperwork1, BlobFiles paperwork2) throws Exception;
	
	
	/**
	 * 查询快递员列表记录数
	 * @return
	 * @throws Exception
	 */
	public int getCourierSize(GetCourierListParam gclp) throws Exception;
	
	
	/**
	 * 获取快递员列表
	 * @return
	 * @throws Exception
	 */
	public List<CourierWrapper> getCourierListLimit(GetCourierListParam gclp, Page page) throws Exception;
	
	
	/**
	 * 删除快递员信息
	 * @param userId
	 * @throws Exception
	 */
	public void deleteCourierInfo(String opUserId, String userId) throws Exception;
	
	
	/**
	 * 获取快递员封装信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public CourierWrapper getCourierWrapperInfo(String userId) throws Exception;
	
	
	/**
	 * 更新快递员用户信息
	 * @param courier
	 * @param user
	 * @throws Exception
	 */
	public void updateCourierUserInfo(String opUserId, PCourier courier, User user) throws Exception;
	
	
	/**
	 * 查询快递员快照信息
	 * @param userId
	 * @return
	 */
	public CourierWrapper getCourierSnapshotInfo(String userId) throws Exception;


	/**
	 * 修改快递员快照信息
	 * @param userId
	 * @param snapshot
	 * @param paperwork1
	 * @param paperwork2
	 * @return
	 * @throws Exception
	 */
	public int updateCourierSnapshot(String opUserId, String userId, BlobFiles snapshot, BlobFiles paperwork1, BlobFiles paperwork2) throws Exception;
	
	
	public int getCourierxItmes(Courierx courier) throws Exception;
	
	public List<Courierx> getCourierxList(Courierx courier,Page page) throws Exception;
	
	/**
	 * 同步获取快递员信息
	 * @param ssId
	 * @param exePermission
	 * @return
	 * @throws Exception
	 */
	public List<ICourierAuthorityInfo> getCourierInfoBySSid(String ssId,int exePermission) throws Exception; 
}