package cn.com.xb.daox;

import java.util.List;
import java.util.Map;

import cn.com.xb.domain.base.CourierGroup;
import cn.com.xb.domain.base.Courierx;
import cn.com.xb.domain.base.ExpressCompany;
import cn.com.xb.domain.base.PCourier;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.displayWrapper.CourierGroupWrapper;
import cn.com.xb.domain.displayWrapper.CourierWrapper;
import cn.com.xb.domain.parameterWrapper.GetCourierGroupParam;
import cn.com.xb.domain.parameterWrapper.GetCourierListParam;
import cn.com.xb.inter.domain.ICourierAuthorityInfo;
import cn.com.xb.inter.domain.ICourierInfo;

public interface ICourierDaox
{
	/**
	 * 获取快递公司总记录数
	 * @return
	 * @throws Exception
	 */
	public int getCourierCompaniesSize(ExpressCompany expressCompany) throws Exception;
	
	
	/**
	 * 获取快递公司列表
	 * @param startInd
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<ExpressCompany> getCourierCompanies(int startInd, int pageSize,ExpressCompany expressCompany) throws Exception;
	
	
	/**
	 * 查询快递员组列表
	 * @param startInd
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<CourierGroupWrapper> getCourierGroupList(int startInd, int pageSize, GetCourierGroupParam gcgp) throws Exception;

	
	/**
	 * 根据快递公司查询快递员组列表
	 * @param startInd
	 * @param pageSize
	 * @param gcgp
	 * @return
	 * @throws Exception
	 */
	public List<CourierGroup> getCourierGroupListByCouComId(String couComId) throws Exception;
	
	
	/**
	 * 获取快递员组列表记录数
	 * @param gcgp
	 * @return
	 * @throws Exception
	 */
	public int getCourierGroupListSize(GetCourierGroupParam gcgp) throws Exception;
	
	
	/**
	 * 更新快递员关联快照信息
	 * @param userId
	 * @param snapshotId
	 * @param paperwork1Id
	 * @param paperwork2Id
	 * @throws Exception
	 */
	public void updatePCourierSnapshotInfo(String userId, String snapshotId, String paperwork1Id, String paperwork2Id) throws Exception;
	
	
	/**
	 * 获取快递员总记录数
	 * @return
	 * @throws Exception
	 */
	public int getCourierSize(GetCourierListParam gclp) throws Exception;
	
	
	/**
	 * 获取快递员列表
	 * @return
	 * @throws Exception
	 */
	public List<CourierWrapper> getCourierListLimit(GetCourierListParam gclp, int startInd, int pageSize) throws Exception;
	
	
	/**
	 * 删除快递员快照信息
	 * @param userId
	 * @throws Exception
	 */
	public void deleteCourierSnapshotInfo(String userId) throws Exception;
	
	
	/**
	 * 查询快递员封装信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public CourierWrapper getCourierWrapperInfo(String userId) throws Exception;
	
	
	/**
	 * 更新快递员信息
	 * @param courier
	 * @throws Exception
	 */
	public void updateCourierInfo(PCourier courier) throws Exception;
	
	
	/**
	 * 查询快递员快照信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public CourierWrapper getCourierSnapshotInfo(String userId) throws Exception;
	
	
	public int getCourierxItmes(Courierx courier) throws Exception;
	
	public List<Courierx> getCourierxList(Courierx courier,Page page) throws Exception;
	
	/**
	 * 根据物箱id获取快递员信息
	 * @param ssId
	 * @return
	 * @throws Exception
	 */
	public List<ICourierAuthorityInfo> getCourierInfoBySSid(String ssId,int exePermission) throws Exception;
	
}
