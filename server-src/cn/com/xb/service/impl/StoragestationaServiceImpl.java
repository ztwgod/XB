package cn.com.xb.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.xb.dao.IBoxInfoDao;
import cn.com.xb.dao.ICabinetDao;
import cn.com.xb.dao.ILeaseAliasesDao;
import cn.com.xb.dao.ILeaseBoxRelaDao;
import cn.com.xb.dao.ILocationDao;
import cn.com.xb.dao.IOperationLogDao;
import cn.com.xb.dao.IStoragestationDao;
import cn.com.xb.dao.IStoragestationDeliveryGDao;
import cn.com.xb.dao.IStoragestationGroupDao;
import cn.com.xb.dao.IStoragestationModelDao;
import cn.com.xb.dao.IStoragestationTypeDao;
import cn.com.xb.dao.ISysuserStoragestationDao;
import cn.com.xb.daox.IBoxInfoDaox;
import cn.com.xb.daox.ICabinetDaox;
import cn.com.xb.daox.ILocationDaox;
import cn.com.xb.daox.IStoragestationDaox;
import cn.com.xb.daox.IStoragestationGroupDaox;
import cn.com.xb.daox.IStoragestationModelDaox;
import cn.com.xb.daox.IStoragestationPeripheralDaox;
import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.BoxInfox;
import cn.com.xb.domain.base.Cabinet;
import cn.com.xb.domain.base.LeaseAliases;
import cn.com.xb.domain.base.LeaseBoxRela;
import cn.com.xb.domain.base.Location;
import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Peripheral;
import cn.com.xb.domain.base.Peripheralx;
import cn.com.xb.domain.base.Storagestation;
import cn.com.xb.domain.base.StoragestationDeliveryG;
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
import cn.com.xb.service.PeripheralServer;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.util.Global;
import cn.com.xb.util.KeyHelper;
import cn.com.xb.util.StringUtil;

public class StoragestationaServiceImpl implements StoragestationaService {

	private IStoragestationTypeDao storagestationTypeDao;
	private IStoragestationDao storagestationDao;
	private ISysuserStoragestationDao sysuserStoragestationDao;
	private IStoragestationModelDao storagestationModelDao;
	private IStoragestationGroupDao storagestationGroupDao;
	private ILocationDao locationDao;
	private IStoragestationGroupDaox storagestationGroupDaox;
	private IStoragestationDaox storagestationDaox;
	private IStoragestationDeliveryGDao storagestationDeliveryGDao;
	private ILeaseAliasesDao leaseAliasesDao;
	private ILeaseBoxRelaDao leaseBoxRelaDao;
	private ICabinetDaox cabinetDaox;
	private IOperationLogDao operationLogDao;
	private ILocationDaox locationDaox;
	private IStoragestationModelDaox storagestationModelDaox;
	
	public void setStoragestationModelDaox(
			IStoragestationModelDaox storagestationModelDaox) {
		this.storagestationModelDaox = storagestationModelDaox;
	}

	public void setLocationDaox(ILocationDaox locationDaox) {
		this.locationDaox = locationDaox;
	}
	private PeripheralServer peripheralServer;
	public void setPeripheralServer(PeripheralServer peripheralServer) {
		this.peripheralServer = peripheralServer;
	}
	private IBoxInfoDao boxInfoDao;
	public void setBoxInfoDao(IBoxInfoDao boxInfoDao) {
		this.boxInfoDao = boxInfoDao;
	}
	private ICabinetDao cabinetDao;
	

	public void setCabinetDao(ICabinetDao cabinetDao) {
		this.cabinetDao = cabinetDao;
	}

	public void setOperationLogDao(IOperationLogDao operationLogDao)
	{
		this.operationLogDao = operationLogDao;
	}
	private IStoragestationPeripheralDaox storagestationPeripheralDaox;
	private IBoxInfoDaox boxInfoDaox;

	public void setBoxInfoDaox(IBoxInfoDaox boxInfoDaox) {
		this.boxInfoDaox = boxInfoDaox;
	}

	public void setStoragestationPeripheralDaox(
			IStoragestationPeripheralDaox storagestationPeripheralDaox) {
		this.storagestationPeripheralDaox = storagestationPeripheralDaox;
	}

	public void setCabinetDaox(ICabinetDaox cabinetDaox) {
		this.cabinetDaox = cabinetDaox;
	}

	public void setLeaseAliasesDao(ILeaseAliasesDao leaseAliasesDao) {
		this.leaseAliasesDao = leaseAliasesDao;
	}

	public void setLeaseBoxRelaDao(ILeaseBoxRelaDao leaseBoxRelaDao) {
		this.leaseBoxRelaDao = leaseBoxRelaDao;
	}

	public void setStoragestationDeliveryGDao(IStoragestationDeliveryGDao storagestationDeliveryGDao) {
		this.storagestationDeliveryGDao = storagestationDeliveryGDao;
	}

	public void setStoragestationDaox(IStoragestationDaox storagestationDaox) {
		this.storagestationDaox = storagestationDaox;
	}

	public void setStoragestationGroupDaox(
			IStoragestationGroupDaox storagestationGroupDaox) {
		this.storagestationGroupDaox = storagestationGroupDaox;
	}

	public void setLocationDao(ILocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public void setStoragestationGroupDao(
			IStoragestationGroupDao storagestationGroupDao) {
		this.storagestationGroupDao = storagestationGroupDao;
	}

	public void setStoragestationModelDao(
			IStoragestationModelDao storagestationModelDao) {
		this.storagestationModelDao = storagestationModelDao;
	}

	public void setSysuserStoragestationDao(
			ISysuserStoragestationDao sysuserStoragestationDao) {
		this.sysuserStoragestationDao = sysuserStoragestationDao;
	}

	public void setStoragestationDao(IStoragestationDao storagestationDao) {
		this.storagestationDao = storagestationDao;
	}

	public void setStoragestationTypeDao(
			IStoragestationTypeDao storagestationTypeDao) {
		this.storagestationTypeDao = storagestationTypeDao;
	}

	public List<StoragestationType> loadAllBoxType() throws Exception {
		
		return storagestationTypeDao.loadAll();
	}

	public void insertStoragestation(String opUserId, Storagestation stor, String sysId,String[] sendGroups,String[] pickGroups) throws Exception {
		stor.setSsId(KeyHelper.creatKey());
		storagestationDao.insert(stor);
		//添加物箱维护人员
		SysuserStoragestation sysuserstoragestation = new SysuserStoragestation();
		sysuserstoragestation.setUserId(sysId);
		sysuserstoragestation.setSsId(stor.getSsId());		
		sysuserStoragestationDao.insert(sysuserstoragestation);
		
		if(null!=sendGroups && sendGroups.length>=1){
			this.updateStoragestationDeliveryG(opUserId, sendGroups,stor.getSsId(),Global.RECIPIENT);
		}
		
		if(null!=pickGroups && pickGroups.length>=1){
			this.updateStoragestationDeliveryG(opUserId, pickGroups,stor.getSsId(),Global.SENDPIECES);
		}
		
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(11);	// 操作类型
		log.setSsId(stor.getSsId());
		log.setOperationUserId(opUserId);
		log.setOperationContent("添加物箱信息(包括维护人员、快递员信息)，相关参数："+StringUtil.getOptionContent(new Object[]{stor, sysuserstoragestation, sendGroups, pickGroups}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}

	public List<StoragestationModel> loadAllStoragestationModel()
			throws Exception {
		
		return storagestationModelDao.loadAll();
	}

	public List<Storagestation> loadAllStoragestation() throws Exception {
		
		return storagestationDao.loadAll();
	}

	public void insertStoragestationGroup(String opUserId, StoragestationGroup storGroup,Location location) throws Exception {
		location.setLocationId(KeyHelper.creatKey());
		storGroup.setGroupId(KeyHelper.creatKey());
		storGroup.setLocationId(location.getLocationId());
	
		int code = locationDaox.getMaxCode(location.getDistrictId());
		
		location.setLocationCode(StringUtil.appendZero(4, String.valueOf(code+1)));
		locationDao.insert(location);
		storagestationGroupDao.insert(storGroup);
		
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(9);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("添加物箱组信息，相关参数："+StringUtil.getOptionContent(new Object[]{storGroup, location}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}

	public int getItems(StoragestationGroupx storGroup) throws Exception {
	
		return storagestationGroupDaox.getItems(storGroup);
	}

	public List<StoragestationGroupx> loadList(StoragestationGroupx storGroup,Page page) throws Exception {
		
		return storagestationGroupDaox.loadList(storGroup, page);
	}

	public StoragestationGroupx loadStoragestationGroupxByGroupId(String groupId)throws Exception {
		
		return storagestationGroupDaox.loadStoragestationGroupxByGroupId(groupId);
	}

	public Location loadLocationByLocation(String locationId)throws Exception {
		
		return locationDao.loadLocationBylocationId(locationId);
	}

	public StoragestationGroup loadStoragestationGroupByGroupId(String groupId)	throws Exception {
		
		return storagestationGroupDao.loadStoragestationGroupBygroupId(groupId);
	}

	public void updateStoragestationGroup(String opUserId, StoragestationGroup storGroup,Location location) throws Exception {
		locationDao.update(location);
		storagestationGroupDao.update(storGroup);
		
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(10);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("修改物箱组信息，相关参数："+StringUtil.getOptionContent(new Object[]{storGroup, location}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}
	
	public void delteStoragestationGroup(String opUserId, String groupId,String locationId) throws Exception{
		StoragestationGroup storGroup = storagestationGroupDao.loadStoragestationGroupBygroupId(groupId);
		Location location = locationDao.loadLocationBylocationId(locationId);
		
		storagestationGroupDao.delete(groupId);
		locationDao.delete(locationId);
		
		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(10);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("删除物箱组信息，相关参数："+StringUtil.getOptionContent(new Object[]{storGroup, location}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}

	public List<StoragestationGroup> loadAllStoragestationGroup()throws Exception {
		
		return storagestationGroupDao.loadAll();
	}

	public int loadStoragestationxItems(Storagestationx stro) throws Exception {
		
		return storagestationDaox.loadStoragestationxItems(stro);
	}

	public List<Storagestationx> loadStoragestationxList(Storagestationx stro,Page page) throws Exception {
		
		return storagestationDaox.loadStoragestationxList(stro, page);
	}

	public Storagestation loadStoragestationBySSId(String ssId) throws Exception {
		
		return storagestationDao.loadStoragestationByssId(ssId);
	}

	public void updateStoragestation(String opUserId, Storagestation stor, String sysId) throws Exception {		
		storagestationDao.update(stor);
		SysuserStoragestation sysuserstoragestation = new SysuserStoragestation();
		sysuserstoragestation.setSsId(stor.getSsId());
		sysuserstoragestation.setUserId(sysId);
		sysuserStoragestationDao.update(sysuserstoragestation);

		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(12);	// 操作类型
		log.setSsId(stor.getSsId());
		log.setOperationUserId(opUserId);
		log.setOperationContent("修改物箱信息(包括维护人员信息)，相关参数："+StringUtil.getOptionContent(new Object[]{stor, sysuserstoragestation}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}

	public void deleteStoragestation(String opUserId, String ssId) throws Exception {
		Storagestation stor = storagestationDao.loadStoragestationByssId(ssId);
		List<StoragestationPeripheral> ssps = storagestationPeripheralDaox.getSsPeripheralListBySSId(ssId);
		List<Cabinet> cabinets = cabinetDaox.loadCabinetsBySSId(ssId);
		List<BoxInfo> bis = boxInfoDaox.getBoxInfoListBySSId(ssId);
		
		storagestationDao.delete(ssId); //删除物箱信息
		sysuserStoragestationDao.delete(ssId);//删除物箱配置的维护员
		
		//删除物箱配置的快递员组
		storagestationDaox.deleteStoragestationDeliveryGBySSId(ssId, Global.RECIPIENT);//删除收件快递员
		storagestationDaox.deleteStoragestationDeliveryGBySSId(ssId, Global.SENDPIECES);//删除取件快递员
		
		//删除物箱外围设备
		storagestationPeripheralDaox.deleteBySSId(ssId);
		//删除柜子
		cabinetDaox.deleteBySSId(ssId);
		//删除箱子
		boxInfoDaox.deleteBySSId(ssId);

		
		OperationLog log = new OperationLog();
		log.setLogId(KeyHelper.creatKey());
		log.setSysPlatType(1);
		log.setOperationType(12);	// 操作类型
		log.setOperationUserId(opUserId);
		log.setOperationContent("删除物箱信息，相关参数："+StringUtil.getOptionContent(new Object[]{stor, cabinets, bis, ssps}));
		log.setOperationTime(new Timestamp(new Date().getTime()));
		operationLogDao.insert(log);// 添加日志
	}

	public StoragestationType loadStoragestationTypeBytypeId(String typeId)
			throws Exception {
		
		return storagestationTypeDao.loadStoragestationTypeBytypeId(typeId);
	}
	
	public SysuserStoragestation loadSysuserStoragestationByssId(String ssId) throws Exception{
		return sysuserStoragestationDao.loadSysuserStoragestationByssId(ssId);
	}

	public Storagestationx loadStoragestationxBySSId(String ssId,String boxId) throws Exception {
		
		return storagestationDaox.loadStoragestationxBySSId(ssId,boxId);
	}

	public void updateStoragestationDeliveryG(String opUserId, String[] groups,String ssId,int limit) throws Exception {		
		storagestationDaox.deleteStoragestationDeliveryGBySSId(ssId,limit);		
		for (int i = 0; i < groups.length; i++) {
			StoragestationDeliveryG storagestationDeliveryG = new StoragestationDeliveryG();
			storagestationDeliveryG.setExePermission(limit);
			storagestationDeliveryG.setGroupId(groups[i]);
			storagestationDeliveryG.setSsId(ssId);
			storagestationDeliveryGDao.insert(storagestationDeliveryG);
		}
		
		if(limit == Global.RECIPIENT || limit == Global.SENDPIECES)
		{
			OperationLog log = new OperationLog();
			log.setLogId(KeyHelper.creatKey());
			log.setSysPlatType(1);
			log.setOperationType(limit == Global.RECIPIENT ? 15 : 14);	// 操作类型
			log.setSsId(ssId);
			log.setOperationUserId(opUserId);
			log.setOperationContent("重置物箱"+(limit == Global.RECIPIENT ? "取件" : "派件")+"快递员组信息，相关参数："+StringUtil.getOptionContent(new Object[]{ssId, groups}));
			log.setOperationTime(new Timestamp(new Date().getTime()));
			operationLogDao.insert(log);// 添加日志
		}
	}
	
	public Storagestationx loadStoragestationStatus(String ssId)
			throws Exception {
		
		return storagestationDaox.loadStoragestationStatus(ssId);
	}

	public List<Peripheralx> loadPeripheralxInfo(String ssId) throws Exception {
		
		return storagestationDaox.loadPeripheralxInfo(ssId);
	}

	public BoxInfox loadBoxInfox(String ssId, String boxCode)
			throws Exception {
		
		return storagestationDaox.loadBoxInfox(ssId, boxCode);
	}

	public List<BoxInfox> loadBoxInfoxList(String ssId) throws Exception {
		
		return storagestationDaox.loadBoxInfoxList(ssId);
	}

	public List<StoragestationGroupx> getStoragestationGroup(String districtId)throws Exception {
		
		return storagestationGroupDaox.getStoragestationGroup(districtId);
	}

	public List<Storagestationx> loadStoragestationByGroupId(String groupId)
			throws Exception {
		
		return storagestationDaox.loadStoragestationByGroupId(groupId);
	}

	/**
	 * 定制物箱方法
	 */
	public void insertBoxInfoToRegisterUser(LeaseAliases leaseAliases,LeaseBoxRela boxRela) throws Exception {
		leaseAliasesDao.insert(leaseAliases);
		leaseBoxRelaDao.insert(boxRela);
	}

	
	public String getCourierGroupsName(String ssId, int type) throws Exception {
		List<String> lists = storagestationDaox.loadCourierListBySSId(ssId, type);
		StringBuffer buffer = new StringBuffer();
		if(null!=lists && !lists.isEmpty()){
			for (String string : lists) {
				buffer.append(string).append(" ");
			}
		}
		return buffer.toString();
	}

	
	public List<Cabinet> getCabinetList(String ssId) throws Exception {
		
		return cabinetDaox.loadCabinetsBySSId(ssId);
	}
	
	public int getItemsByPid(String pid) throws Exception{
		
		return storagestationDaox.getItemsByPid(pid);
	}
	
	public Storagestationx getStoragestationxByPid(String pid) throws Exception{
		return storagestationDaox.getStoragestationxByPid(pid);
	}

	public Storagestationx getStoragestationxBySSCode(String ssCode) throws Exception {

		return storagestationDaox.getStoragestationxBySSCode(ssCode);
	}

	@Override
	public void insertIniStorInfo(SynchObject synchObject) throws Exception {
		
		//物箱型号
		String verison = synchObject.getStoragestation().getModelId();
		StoragestationModel sModel = storagestationModelDaox.getStoragestationModelByCode(verison);
		if(null==sModel){
			sModel = new StoragestationModel();
			sModel.setModelFullCode(verison);
			sModel.setModelId(KeyHelper.creatKey());
			sModel.setModelAbb(verison+"版本");
			storagestationModelDao.insert(sModel);
		}
		
		//修改物箱信息
		synchObject.getStoragestation().setModelId(sModel.getModelId());
		storagestationDaox.updateStoragestation(synchObject.getStoragestation());
		
		//柜子信息
		for (Cabinet cabinet : synchObject.getUpdateCabinets()) {
			cabinetDaox.update(cabinet);
		}
		
		List<String> cabinetIds = new ArrayList<String>();
		for (Cabinet cabinet : synchObject.getDeleteCabinets()) {
			Cabinet _cabCabinet = cabinetDaox.getCabinetBySSIdAndCabinetCode(cabinet.getSsId(), cabinet.getCabinetCode());
			if(null!=_cabCabinet){
				cabinetIds.add(_cabCabinet.getCabinetId());
				cabinetDaox.deleteCabinetBySSIdAndCabinetCode(cabinet.getSsId(), cabinet.getCabinetCode());
			}
		}
		for (String cabinetId : cabinetIds) {//删除柜子下面的箱子信息
			boxInfoDaox.deleteBoxInfoByCabinetId(cabinetId);
		}
		
		for (Cabinet cabinet : synchObject.getInsertCabinets()) {
			cabinetDao.insert(cabinet);
		}
		
		//箱子信息
		for (BoxInfo boxInfo : synchObject.getUpdateBoxInfos()) {
			boxInfoDaox.updateBoxInfo(boxInfo);
		}
		for (BoxInfo boxInfo : synchObject.getInsertBoxInfos()) {
			boxInfoDao.insert(boxInfo);
		}
		//外围设备中间表
		peripheralServer.updateStorPeripheral(synchObject.getStoragestationPeripherals());
		//外围设备表
		for (Peripheral peripheral : synchObject.getPeripherals()) {
			peripheralServer.insert(peripheral);
		}
	}

	@Override
	public String getLocationCodeByGroupId(String groupId) throws Exception {
		
		return storagestationGroupDaox.getLocationCodeByGroupId(groupId);
	}

	@Override
	public boolean isExistByModuleCode(String moduleCode) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	

	public String getSSIdBySSCode(String ssCode) throws Exception
	{
		return storagestationDaox.getSSIdBySSCode(ssCode);
	}
	
	
	public String getBoxIdByBoxCode(String boxCode) throws Exception
	{
		return boxInfoDaox.getBoxIdByBoxCode(boxCode);
	}

	@Override
	public int getBoxStatusListSize(GetBoxStatusListParam bslp) throws Exception
	{
		return storagestationDaox.getBoxStatusListSize(bslp);
	}

	@Override
	public List<BoxStatusWrapper> getBoxStatusListLimit(GetBoxStatusListParam bslp, Page page) throws Exception
	{
		if(page == null)
		{
			page = new Page();
			page.setPageSize(0);
		}
		return storagestationDaox.getBoxStatusListLimit(bslp, page.getPageNumber(), page.getPageSize());
	}

	@Override
	public Map<String, BoxInfo> loadBoxInfo(String ssId) throws Exception {
		
		return storagestationDaox.loadBoxInfo(ssId);
	}
}
