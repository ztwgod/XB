package cn.com.xb.inter.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import cn.com.xb.domain.base.Peripheral;
import cn.com.xb.util.VerifyTool;

public class IPeripheral implements Serializable {

	/**
	 * 外围设备
	 */
	private static final long serialVersionUID = 1L;
	private String peripheralCode;// 设备CODE
	private String peripheralAbbName;// 设备简称【主控计算机、读卡器、二维码识别器、红外识别...】
	private String assetSn;// 资产编号
	private int type;// 设备类型【1，工程计算机；2，读卡器；3，二维码识别器；4，红外识别；5，钱币识别器；6，摄像头；7，触摸屏；8，报警器】
	private String version;// 版本号
	private Timestamp startTime;// 启用时间
	private Timestamp stopTime;// 停用时间
	private int runStatus;// 运行状态【1,正常;2,故障;3,被破坏;4,维修】
	private String memo;// 备注

	
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(VerifyTool.isNull(this.peripheralCode)){
			buffer.append("peripheralCode不能为空。");
		}
		if(VerifyTool.isNull(this.peripheralAbbName)){
			buffer.append(this.peripheralCode+"，peripheralAbbName不能为空。");
		}
		if(VerifyTool.isNull(this.assetSn)){
			buffer.append(this.peripheralCode+"，assetSn不能为空。");
		}
		if(this.type<0 || this.type>8){
			buffer.append(this.peripheralCode+"，type输入非法。");
		}
		if(VerifyTool.isNull(this.version)){
			buffer.append(this.peripheralCode+"，version不能为空。");
		}
		if(null==this.startTime){
			buffer.append(this.peripheralCode+"，startTime不能为空。");
		}
		if(this.runStatus<0 || this.runStatus>4){
			buffer.append(this.peripheralCode+"，runStatus输入非法。");
		}
		return buffer.toString();
	}
	
	
	
	
	public Peripheral getPeripheral() {
		Peripheral peripheral = new Peripheral();
		peripheral.setPeripheralCode(peripheralCode);
		peripheral.setAssetSn(assetSn);
		peripheral.setMemo(memo);
		peripheral.setPeripheralAbbName(peripheralAbbName);
		peripheral.setStartTime(startTime);
		peripheral.setStopTime(stopTime);
		peripheral.setStatus(runStatus);
		peripheral.setVersion(version);
		peripheral.setType(type);
		return peripheral;
	}
	
	public IPeripheral(){
		
	}

	public IPeripheral(String peripheralCode, String peripheralAbbName,
			String assetSn, int type, String version, Timestamp startTime,
			Timestamp stopTime, int runStatus, String memo) {
		super();
		this.peripheralCode = peripheralCode;
		this.peripheralAbbName = peripheralAbbName;
		this.assetSn = assetSn;
		this.type = type;
		this.version = version;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.runStatus = runStatus;
		this.memo = memo;
	}

	public String getPeripheralCode() {
		return peripheralCode;
	}

	public void setPeripheralCode(String peripheralCode) {
		this.peripheralCode = peripheralCode;
	}

	public String getPeripheralAbbName() {
		return peripheralAbbName;
	}

	public void setPeripheralAbbName(String peripheralAbbName) {
		this.peripheralAbbName = peripheralAbbName;
	}

	public String getAssetSn() {
		return assetSn;
	}

	public void setAssetSn(String assetSn) {
		this.assetSn = assetSn;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Timestamp getStopTime() {
		return stopTime;
	}

	public void setStopTime(Timestamp stopTime) {
		this.stopTime = stopTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public int getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(int runStatus) {
		this.runStatus = runStatus;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public IPeripheral getIPeripheral(Peripheral peripheral) {
		IPeripheral iPeripheral = new IPeripheral();
		iPeripheral.setAssetSn(peripheral.getAssetSn());
		iPeripheral.setMemo(peripheral.getMemo());
		iPeripheral.setPeripheralAbbName(peripheral.getPeripheralAbbName());
		iPeripheral.setPeripheralCode(peripheral.getPeripheralCode());
		iPeripheral.setRunStatus(peripheral.getStatus());
		iPeripheral.setStartTime(peripheral.getStartTime());
		iPeripheral.setStopTime(peripheral.getStopTime());
		iPeripheral.setType(peripheral.getType());
		iPeripheral.setVersion(peripheral.getVersion());
		return iPeripheral;

	}
}
