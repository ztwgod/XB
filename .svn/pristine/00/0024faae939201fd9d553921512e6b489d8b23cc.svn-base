package cn.com.xb.inter.domain;

import java.io.Serializable;
import java.util.List;

import cn.com.xb.domain.base.Storagestation;
import cn.com.xb.util.DateTools;
import cn.com.xb.util.VerifyTool;
import cn.com.xb.util.VerifyTool;

public class IStorageStationInfo implements Serializable {

	/**
	 * 物箱详情
	 */
	private static final long serialVersionUID = 1L;
	//private String storageStationIndex;// 物箱编号/序列号 物箱ID组成部分：物箱编号
	private String storageStationType;// 物箱类型
	private String storageStationVersion;// 物箱版本
	private String assetSn;// 资产编号
	private int storageStationStatus;// 物箱状态
	
	// [1,正常;2,无空箱;3,负荷高;4,系统忙;5,故障恢复;6,维护中;7,断链;8,闭塞;9,重启]
	private String dataCard;// 数据卡号
	private String ipAddress;// 物箱对应IP地址 若有ID地址则传递（目前需求信元定义中无ＩＰ定义）
	private String port;// 端口
	private int phyLinkType;// PHY链路类型 （GPRS、WCDMA、WIFI、GE/FE）
	private double longitude;// 经度
	private double latitude;// 纬度

	private int availableBoxNum;// 可用箱子
	private String installDate;// 安装时间
	private int controlCabinetLocation;// 控制面板所在位置
	private List<IPeripheral> peripherals;// 外围设备列表
	private List<ICabinetContainer> cabinetContainers;// 物箱柜子
	
	
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(VerifyTool.isNull(this.storageStationType)){
			buffer.append("storageStationType不能为空。");
		}
		if(VerifyTool.isNull(this.storageStationVersion)){
			buffer.append("storageStationVersion不能为空。");
		}
		if(VerifyTool.isNull(this.assetSn)){
			buffer.append("assetSn不能为空。");
		}
		if(this.storageStationStatus<0 || this.storageStationStatus>9){
			buffer.append("storageStationStatus输入非法。");
		}
		if(VerifyTool.isNull(this.dataCard) && VerifyTool.isNull(this.ipAddress)){
			buffer.append("dataCard与ipAddress必须录入一个，不能同时为空。");
		}
		if(VerifyTool.isNull(this.port)){
			buffer.append("port不能为空。");
		}
		if(this.controlCabinetLocation<=0){
			buffer.append("controlCabinetLocation输入非法。");
		}
		return buffer.toString();
	}


	/*public String getStorageStationIndex() {
		return storageStationIndex;
	}

	public void setStorageStationIndex(String storageStationIndex) {
		this.storageStationIndex = storageStationIndex;
	}*/

	public String getInstallDate() {
		return installDate;
	}

	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}

	public String getStorageStationType() {
		return storageStationType;
	}

	public void setStorageStationType(String storageStationType) {
		this.storageStationType = storageStationType;
	}

	public String getStorageStationVersion() {
		return storageStationVersion;
	}

	public void setStorageStationVersion(String storageStationVersion) {
		this.storageStationVersion = storageStationVersion;
	}

	public String getAssetSn() {
		return assetSn;
	}

	public void setAssetSn(String assetSn) {
		this.assetSn = assetSn;
	}

	public int getStorageStationStatus() {
		return storageStationStatus;
	}

	public void setStorageStationStatus(int storageStationStatus) {
		this.storageStationStatus = storageStationStatus;
	}

	public String getDataCard() {
		return dataCard;
	}

	public void setDataCard(String dataCard) {
		this.dataCard = dataCard;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public int getPhyLinkType() {
		return phyLinkType;
	}

	public void setPhyLinkType(int phyLinkType) {
		this.phyLinkType = phyLinkType;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getAvailableBoxNum() {
		return availableBoxNum;
	}

	public void setAvailableBoxNum(int availableBoxNum) {
		this.availableBoxNum = availableBoxNum;
	}


	

	public int getControlCabinetLocation() {
		return controlCabinetLocation;
	}

	public void setControlCabinetLocation(int controlCabinetLocation) {
		this.controlCabinetLocation = controlCabinetLocation;
	}

	public List<IPeripheral> getPeripherals() {
		return peripherals;
	}

	public void setPeripherals(List<IPeripheral> peripherals) {
		this.peripherals = peripherals;
	}

	public List<ICabinetContainer> getCabinetContainers() {
		return cabinetContainers;
	}

	public void setCabinetContainers(List<ICabinetContainer> cabinetContainers) {
		this.cabinetContainers = cabinetContainers;
	}

	public IStorageStationInfo getIStorageStationInfo(Storagestation storageStation,List<IPeripheral> peripherals,List<ICabinetContainer> cabinetContainers) {
		IStorageStationInfo iStorageStation = new IStorageStationInfo();
		iStorageStation.setAssetSn(storageStation.getAssetSn());
		iStorageStation.setAvailableBoxNum(storageStation.getAvailableBoxNum());
		iStorageStation.setControlCabinetLocation(storageStation.getControlCabinetLocation()); // 控制面板所在位置
		iStorageStation.setDataCard(storageStation.getDataCard());
		iStorageStation.setInstallDate(DateTools.formatDateToString(storageStation.getInstallDate(),DateTools.FORMAT_YYYYMMDD_HHMMSS));
		iStorageStation.setIpAddress(storageStation.getIpAdd());
		iStorageStation.setLatitude(storageStation.getLatitude());
		iStorageStation.setLongitude(storageStation.getLongitude());
		iStorageStation.setPhyLinkType(storageStation.getLinkType());
		iStorageStation.setPort(storageStation.getPort());
		//iStorageStation.setStorageStationIndex(storageStation.getSsIndex());
		iStorageStation.setStorageStationStatus(storageStation.getRunStatus());
		iStorageStation.setStorageStationType(storageStation.getSsType());
		iStorageStation.setStorageStationVersion(storageStation.getModelId());
		iStorageStation.setPeripherals(peripherals);
		iStorageStation.setCabinetContainers(cabinetContainers);
		
		return iStorageStation;
	}
	
	public Storagestation getStoragestation(){
		Storagestation storagestation = new Storagestation();
		storagestation.setAssetSn(this.assetSn);
		storagestation.setAvailableBoxNum(this.availableBoxNum);
		storagestation.setControlCabinetLocation(this.controlCabinetLocation);
		storagestation.setDataCard(this.dataCard);
		
		//安装日期可以为空
		storagestation.setInstallDate(DateTools.formatStringToTimestamp(this.installDate,DateTools.FORMAT_YYYYMMDD_HHMMSS));
		
		
		storagestation.setIpAdd(this.ipAddress);
		storagestation.setLatitude(this.latitude);
		storagestation.setLinkType(this.phyLinkType);
		storagestation.setLongitude(this.longitude);
		storagestation.setModelId(this.storageStationVersion);
		storagestation.setPort(this.port);
		storagestation.setRunStatus(this.storageStationStatus);
		//storagestation.setSsIndex(this.storageStationIndex);
		storagestation.setSsType(this.storageStationType);
		return storagestation;
	}

}
