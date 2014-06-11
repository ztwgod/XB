package cn.com.xb.inter.domain;

import java.io.Serializable;
import java.util.List;

import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.Cabinet;
import cn.com.xb.domain.base.Peripheral;
import cn.com.xb.domain.base.Storagestation;
import cn.com.xb.domain.base.StoragestationPeripheral;

public class SynchObject implements Serializable {

	/**
	 * 同步接口
	 */
	private static final long serialVersionUID = 1L;

	private Storagestation storagestation; // 物箱

	private List<BoxInfo> insertBoxInfos; // 添加：箱子信息
	private List<BoxInfo> updateBoxInfos; // 修改：箱子信息

	private List<Cabinet> insertCabinets; // 添加： 柜子信息
	private List<Cabinet> updateCabinets;// 修改：柜子信息
	private List<Cabinet> deleteCabinets; // 删除：柜子信息

	private List<Peripheral> peripherals; // 外围设备信息
	private List<StoragestationPeripheral> storagestationPeripherals; // 物箱外围设备中间表

	public Storagestation getStoragestation() {
		return storagestation;
	}

	public void setStoragestation(Storagestation storagestation) {
		this.storagestation = storagestation;
	}

	public List<BoxInfo> getInsertBoxInfos() {
		return insertBoxInfos;
	}

	public void setInsertBoxInfos(List<BoxInfo> insertBoxInfos) {
		this.insertBoxInfos = insertBoxInfos;
	}

	public List<BoxInfo> getUpdateBoxInfos() {
		return updateBoxInfos;
	}

	public List<Cabinet> getDeleteCabinets() {
		return deleteCabinets;
	}

	public void setDeleteCabinets(List<Cabinet> deleteCabinets) {
		this.deleteCabinets = deleteCabinets;
	}

	public void setUpdateBoxInfos(List<BoxInfo> updateBoxInfos) {
		this.updateBoxInfos = updateBoxInfos;
	}

	public List<Cabinet> getInsertCabinets() {
		return insertCabinets;
	}

	public void setInsertCabinets(List<Cabinet> insertCabinets) {
		this.insertCabinets = insertCabinets;
	}

	public List<Cabinet> getUpdateCabinets() {
		return updateCabinets;
	}

	public void setUpdateCabinets(List<Cabinet> updateCabinets) {
		this.updateCabinets = updateCabinets;
	}

	public List<Peripheral> getPeripherals() {
		return peripherals;
	}

	public void setPeripherals(List<Peripheral> peripherals) {
		this.peripherals = peripherals;
	}

	public List<StoragestationPeripheral> getStoragestationPeripherals() {
		return storagestationPeripherals;
	}

	public void setStoragestationPeripherals(
			List<StoragestationPeripheral> storagestationPeripherals) {
		this.storagestationPeripherals = storagestationPeripherals;
	}
}
