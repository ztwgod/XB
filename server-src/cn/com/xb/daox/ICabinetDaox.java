package cn.com.xb.daox;

import java.util.List;

import cn.com.xb.domain.base.Cabinet;
import cn.com.xb.inter.domain.IDeviceStatus;

public interface ICabinetDaox {

	public List<Cabinet> loadCabinetsBySSId(String ssId) throws Exception;
	
	public void deleteBySSId(String ssId) throws Exception;
	
	public void update(Cabinet cabinet) throws Exception;
	
	/**
	 * 删除柜子信息，根据ssId与CabinetCode
	 * @param ssId
	 * @param CabinetCode
	 * @throws Exception
	 */
	public void deleteCabinetBySSIdAndCabinetCode(String ssId,String cabinetCode) throws Exception;
	
	
	/**
	 * 查询柜子信息，根据ssId与CabinetCode
	 * @param ssId
	 * @param CabinetCode
	 * @throws Exception
	 */
	public Cabinet getCabinetBySSIdAndCabinetCode(String ssId,String cabinetCode) throws Exception;
	
	/**
	 * 同步箱子信息
	 * @param deviceStatus
	 * @param ssId
	 * @throws Exception
	 */
	public void updateCabinet(IDeviceStatus deviceStatus,String ssId) throws Exception;
}
