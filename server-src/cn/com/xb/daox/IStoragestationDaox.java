package cn.com.xb.daox;

import java.util.List;
import java.util.Map;

import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.BoxInfox;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Peripheralx;
import cn.com.xb.domain.base.Storagestation;
import cn.com.xb.domain.base.StoragestationDeliveryG;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.domain.displayWrapper.BoxStatusWrapper;
import cn.com.xb.domain.parameterWrapper.GetBoxStatusListParam;

public interface IStoragestationDaox {

	public List<Storagestationx> loadStoragestationxList(Storagestationx stro,Page page) throws Exception;
	
	public int loadStoragestationxItems(Storagestationx stro) throws Exception;
	
	public Storagestationx loadStoragestationxBySSId(String ssId,String boxId) throws Exception;
	
	public StoragestationDeliveryG loadStoragestationDeliveryGBySSId(String ssId) throws Exception;
	
	public void deleteStoragestationDeliveryGBySSId(String ssId,int exePermission) throws Exception;
	
	public Storagestationx loadStoragestationStatus(String ssId) throws Exception;
	
	public List<Peripheralx> loadPeripheralxInfo(String ssId) throws Exception;
	
	public BoxInfox loadBoxInfox(String ssId,String boxCode) throws Exception;
	
	public List<BoxInfox> loadBoxInfoxList(String ssId) throws Exception;
	
	public List<Storagestationx> loadStoragestationByGroupId(String groupId) throws Exception;
	
	public List<String> loadCourierListBySSId(String ssId,int type) throws Exception;
	
	public int getItemsByPid(String pid) throws Exception;
	
	public Storagestationx getStoragestationxByPid(String pid) throws Exception;
	
	public Storagestationx getStoragestationxBySSCode(String ssCode) throws Exception;
	
	public void updateStoragestation(Storagestation stor) throws Exception;
	
	public void updateStatus(int status,String ssCode) throws Exception;
	
	public String getSSIdBySSCode(String ssCode) throws Exception;
	
	public int getBoxStatusListSize(GetBoxStatusListParam bslp) throws Exception;
	
	public List<BoxStatusWrapper> getBoxStatusListLimit(GetBoxStatusListParam bslp, int startInd, int pageSize) throws Exception;
	
	public Map<String, BoxInfo> loadBoxInfo(String ssId) throws Exception;
	
	public String getAddressByssId(String ssCode) throws Exception;
}
