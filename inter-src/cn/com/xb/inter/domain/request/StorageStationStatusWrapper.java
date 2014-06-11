package cn.com.xb.inter.domain.request;

import java.io.Serializable;
import java.util.List;

import cn.com.xb.inter.domain.IDeviceStatus;
import cn.com.xb.util.VerifyTool;

public class StorageStationStatusWrapper extends BaseRequest implements
		Serializable {

	/**
	 * 箱子各状态信息封装
	 */
	private static final long serialVersionUID = 1L;

	private int storageStationStatus; // 物箱状态 [正常；无空箱；负荷高；系统忙；故障恢复；维护中；断链；闭塞；重启]

	private List<IDeviceStatus> peripheralRunStatus;// 外围设备运行状态列表(存放内容<外围设备Code,状态>)
	private List<IDeviceStatus> cabinetContainerStatus;// 柜子运行状态列表(存放内容<柜子Code,状态>)
	private List<IDeviceStatus> boxLoadStatus;// 箱子存货状态【1,空闲;2,占用;3,占用超时;4,占用超期】
	private List<IDeviceStatus> boxRunStatus;// 箱子运行状态：空闲、占用、占用超时、占用超期、开启、故障、租用、预留、闭塞、未关闭、被破坏、维修

	// private List<IBoxInfo> boxInfos;// 箱子列表
	private String clientUploadTime;// 上传提交时间 yyyy-MM-dd hh24:mm:ss
	
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(this.storageStationStatus<0 || this.storageStationStatus>9){
			buffer.append("storageStationStatus非法。");
		}
		if(!VerifyTool.isDate(this.clientUploadTime)){
			buffer.append("clientUploadTime非法。");
		}
		return buffer.toString();
	}
	
	

	public int getStorageStationStatus() {
		return storageStationStatus;
	}

	public void setStorageStationStatus(int storageStationStatus) {
		this.storageStationStatus = storageStationStatus;
	}

	public List<IDeviceStatus> getPeripheralRunStatus() {
		return peripheralRunStatus;
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

	public String getClientUploadTime() {
		return clientUploadTime;
	}

	public void setClientUploadTime(String clientUploadTime) {
		this.clientUploadTime = clientUploadTime;
	}
}
