package cn.com.xb.daox;

import java.util.List;

import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.inter.domain.IDeviceStatus;

public interface IBoxInfoDaox {

	/**
	 * 修改箱子信息
	 * @param boxInfo
	 * @throws Exception
	 */
	public void updateBoxInfo(BoxInfo boxInfo) throws Exception;

	/**
	 * 根据百度地图id与运行状态，查询所有箱子信息
	 * @param poiId
	 * @param loadStatus
	 * @return
	 * @throws Exception
	 */
	public List<BoxInfo> getBoxInfoByLoadStatus(String poiId,int loadStatus) throws Exception;
	
	/**
	 * 根据百度地图ID，查询箱子信息
	 * @param poiId
	 * @return
	 * @throws Exception
	 */
	public List<Storagestationx> getStoragestationByPoiId(String poiId) throws Exception;
	
	/**
	 * 删除根据物箱ID
	 * @param ssId
	 * @throws Exception
	 */
	public void deleteBySSId(String ssId) throws Exception;
	
	/**
	 * 根据物箱id获取箱子集合
	 * @param ssId
	 * @return
	 * @throws Exception
	 */
	public List<BoxInfo> getBoxInfoListBySSId(String ssId) throws Exception;
	
	/**
	 * 根据柜子ID删除箱子
	 * @param cabinetId
	 * @throws Exception
	 */
	public void deleteBoxInfoByCabinetId(String cabinetId) throws Exception;
	
	/**
	 * 修改状态
	 * @param deviceStatus
	 * @param ssId
	 * @throws Exception
	 */
	public void updateLoadStatus(IDeviceStatus deviceStatus,String ssId) throws Exception;
	
	/**
	 * 修改运行状态
	 * @param deviceStatus
	 * @param ssId
	 * @throws Exception
	 */
	public void updateRunStatus(IDeviceStatus deviceStatus,String ssId) throws Exception;
	
	/**
	 * 通过boxCode查询boxId
	 * @param boxCode
	 * @return
	 * @throws Exception
	 */
	public String getBoxIdByBoxCode(String boxCode) throws Exception;
	
	/**
	 * 修改物箱库存状态
	 * @param boxId
	 * @param status
	 * @throws Exception
	 */
	public void updateLoadStatusByBoxId(String boxId, int status) throws Exception;
	
	/**
	 * 根据物箱状态与物箱ID获取记录数
	 * @param ssId
	 * @param runStatus
	 * @return
	 * @throws Exception
	 */
	public int getItemsByRunStatus(String ssId,int runStatus) throws Exception;
	public String getBoxCodeByBoxId(String boxId) throws Exception;
	public String getBoxIndexByBoxId(String boxId) throws Exception;

	public String getSSIDByBoxId(String boxId);
	
	
}
