package cn.com.xb.inter.domain;

import java.io.Serializable;
import java.util.List;

import cn.com.xb.domain.base.BoxInfo;

public class SynchBoxInfoObject implements Serializable {

	/**
	 * 同步箱子状态
	 */
	private static final long serialVersionUID = 1L;

	private String storageStationId; // 物箱代码
	private int status; // 物箱状态
	private String ssId; // 物箱id

	List<IDeviceStatus> boxLoadStatus;
	List<IDeviceStatus> boxRunStatus;
	List<IDeviceStatus> cabinetContainerStatus;
	List<IDeviceStatus> peripheralRunStatus;

	public List<IDeviceStatus> getPeripheralRunStatus() {
		return peripheralRunStatus;
	}

	public String getSsId() {
		return ssId;
	}

	public void setSsId(String ssId) {
		this.ssId = ssId;
	}

	public void setPeripheralRunStatus(List<IDeviceStatus> peripheralRunStatus) {
		this.peripheralRunStatus = peripheralRunStatus;
	}

	public List<IDeviceStatus> getCabinetContainerStatus() {
		return cabinetContainerStatus;
	}

	public void setCabinetContainerStatus(
			List<IDeviceStatus> cabinetContainerStatus) {
		this.cabinetContainerStatus = cabinetContainerStatus;
	}

	public List<IDeviceStatus> getBoxLoadStatus() {
		return boxLoadStatus;
	}

	public void setBoxLoadStatus(List<IDeviceStatus> boxLoadStatus) {
		this.boxLoadStatus = boxLoadStatus;
	}

	public List<IDeviceStatus> getBoxRunStatus() {
		return boxRunStatus;
	}

	public void setBoxRunStatus(List<IDeviceStatus> boxRunStatus) {
		this.boxRunStatus = boxRunStatus;
	}

	public String getStorageStationId() {
		return storageStationId;
	}

	public void setStorageStationId(String storageStationId) {
		this.storageStationId = storageStationId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
