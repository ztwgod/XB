package cn.com.xb.inter.domain;

import java.io.Serializable;

import cn.com.xb.util.VerifyTool;

public class IDeviceStatus implements Serializable {

	/**
	 * 设备状态
	 */
	private static final long serialVersionUID = 1L;

	private String deviceCode;// 设备Code（外围设备Code，柜子Code，箱子Code）
	private int deviceStatus;// 设备状态
	
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(VerifyTool.isNull(deviceCode)){
			buffer.append("deviceCode不能为空。");
		}
		return buffer.toString();
	}
	
	public IDeviceStatus(){}

	public IDeviceStatus(String deviceCode, int deviceStatus) {
		super();
		this.deviceCode = deviceCode;
		this.deviceStatus = deviceStatus;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public int getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(int deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
}
