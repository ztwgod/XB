package cn.com.xb.service;

import java.util.List;
import java.util.Map;

import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.BoxInfox;
import cn.com.xb.domain.base.Cabinet;
import cn.com.xb.domain.base.LeaseAliases;
import cn.com.xb.domain.base.LeaseBoxRela;
import cn.com.xb.domain.base.Location;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Peripheral;
import cn.com.xb.domain.base.Peripheralx;
import cn.com.xb.domain.base.Storagestation;
import cn.com.xb.domain.base.StoragestationGroup;
import cn.com.xb.domain.base.StoragestationGroupx;
import cn.com.xb.domain.base.StoragestationModel;
import cn.com.xb.domain.base.StoragestationPeripheral;
import cn.com.xb.domain.base.StoragestationType;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.domain.base.SysuserStoragestation;
import cn.com.xb.domain.displayWrapper.BoxStatusWrapper;
import cn.com.xb.domain.parameterWrapper.GetBoxStatusListParam;
import cn.com.xb.inter.domain.SynchObject;


public interface StoragestationaService {

	public List<StoragestationType> loadAllBoxType() throws Exception;
	
	public void insertStoragestation(String opUserId, Storagestation stor,String sysId,String[] sendGroups,String[] pickGroups) throws Exception;
	
	public List<StoragestationModel> loadAllStoragestationModel()throws Exception;
	
	public List<Storagestation> loadAllStoragestation()throws Exception;
	
	public void insertStoragestationGroup(String opUserId, StoragestationGroup storGroup,Location location) throws Exception;
	
	public List<StoragestationGroupx> loadList(StoragestationGroupx storGroup,Page page) throws Exception;
	
	public int getItems(StoragestationGroupx storGroup) throws Exception;
	
	public StoragestationGroupx loadStoragestationGroupxByGroupId(String groupId) throws Exception;
	
	public StoragestationGroup loadStoragestationGroupByGroupId(String groupId) throws Exception;
	
	public Location loadLocationByLocation(String locationId)throws Exception;
	
	public void updateStoragestationGroup(String opUserId, StoragestationGroup storGroup,Location location) throws Exception;
	
	public void delteStoragestationGroup(String opUserId, String groupId,String locationId) throws Exception;
	
	public List<StoragestationGroup> loadAllStoragestationGroup() throws Exception;
	
	public List<Storagestationx> loadStoragestationxList(Storagestationx stro,Page page) throws Exception;
	
	public int loadStoragestationxItems(Storagestationx stro) throws Exception;
	
	public Storagestation loadStoragestationBySSId(String ssId) throws Exception;
	
	public void updateStoragestation(String opUserId, Storagestation stor,String sysId) throws Exception;
	
	public void deleteStoragestation(String opUserId, String ssId) throws Exception;
	
	public StoragestationType loadStoragestationTypeBytypeId(String typeId) throws Exception;
	
	public SysuserStoragestation loadSysuserStoragestationByssId(String ssId) throws Exception;
	
	public Storagestationx loadStoragestationxBySSId(String ssId,String boxId) throws Exception;
	
	public void updateStoragestationDeliveryG(String opUserId, String[] groups,String ssId,int limit) throws Exception;
	
	public Storagestationx loadStoragestationStatus(String ssId) throws Exception;
	
	public List<Peripheralx> loadPeripheralxInfo(String ssId) throws Exception;
	
	public BoxInfox loadBoxInfox(String ssId, String boxCode) throws Exception;
	
	public List<BoxInfox> loadBoxInfoxList(String ssId) throws Exception;
	
	public List<StoragestationGroupx> getStoragestationGroup(String districtId) throws Exception;
	
	public List<Storagestationx> loadStoragestationByGroupId(String groupId)throws Exception;
	
	public void insertBoxInfoToRegisterUser(LeaseAliases leaseAliases,LeaseBoxRela boxRela) throws Exception;
	
	public String getCourierGroupsName(String ssId,int type) throws Exception;
	
	public List<Cabinet> getCabinetList(String ssId) throws Exception;
	
	public int getItemsByPid(String pid) throws Exception;
	
	public Storagestationx getStoragestationxByPid(String pid) throws Exception;
	
	public Storagestationx getStoragestationxBySSCode(String ssCode) throws Exception;
	
		/**
	 * 通过物箱Code，查询其对应ID
	 * @param ssCode
	 * @return
	 * @throws Exception
	 */
	public String getSSIdBySSCode(String ssCode) throws Exception;
	
	/**
	 * 通过箱子Code，查询箱子ID
	 * @param boxCode
	 * @return
	 * @throws Exception
	 */
	public String getBoxIdByBoxCode(String boxCode) throws Exception;
	
	/**
	 * 物箱同步
	 */
	public void insertIniStorInfo(SynchObject synchObject) throws Exception;
	
	/**
	 * 查询物箱地点代码
	 * @param groupId
	 * @return
	 * @throws Exception
	 */
	public String getLocationCodeByGroupId(String groupId) throws Exception;
	
	/**
	 * 判断物箱类型是否存在
	 * @param moduleCode
	 * @return
	 * @throws Exception
	 */
	public boolean isExistByModuleCode(String moduleCode) throws Exception;
	
	
	/**
	 * 获取物箱状态记录数
	 * @param bslp
	 * @return
	 * @throws Exception
	 */
	public int getBoxStatusListSize(GetBoxStatusListParam bslp) throws Exception;
	
	
	/**
	 * 查询物箱状态记录列表
	 * @param bslp
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<BoxStatusWrapper> getBoxStatusListLimit(GetBoxStatusListParam bslp, Page page) throws Exception;
	
	public Map<String, BoxInfo> loadBoxInfo(String ssId) throws Exception;
}
