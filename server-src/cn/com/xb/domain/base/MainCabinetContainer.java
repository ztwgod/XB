package cn.com.xb.domain.base;

import java.io.Serializable;

/**
 * 主控柜子
 * @author DiGua  Tue Sep 10 13:36:43 CST 2013
 *
 */
public class MainCabinetContainer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String 					controlCabinetLocation;	// 控制面板所在位置
	private Computer				computer;				// 工控计算机
	private IdReader				idReader;				// 读卡器
	private DimensionalCodeReader	dimensionalCodeReader;	// 二维码识别器
	private InfraredIdentification	infraredIdentification;	// 红外识别
	private AutomaticCashMachine	automaticCashMachine;	// 钱币识别器
	private SecurityCamera			securityCamera;			// 摄像头
	private TouchScreen				touchScreen;			// 触摸屏
	private AlarmSystem				alarmSystem;			// 报警器
	
	public String getControlCabinetLocation() {
		return controlCabinetLocation;
	}
	public void setControlCabinetLocation(String controlCabinetLocation) {
		this.controlCabinetLocation = controlCabinetLocation;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public IdReader getIdReader() {
		return idReader;
	}
	public void setIdReader(IdReader idReader) {
		this.idReader = idReader;
	}
	public DimensionalCodeReader getDimensionalCodeReader() {
		return dimensionalCodeReader;
	}
	public void setDimensionalCodeReader(DimensionalCodeReader dimensionalCodeReader) {
		this.dimensionalCodeReader = dimensionalCodeReader;
	}
	public InfraredIdentification getInfraredIdentification() {
		return infraredIdentification;
	}
	public void setInfraredIdentification(
			InfraredIdentification infraredIdentification) {
		this.infraredIdentification = infraredIdentification;
	}
	public AutomaticCashMachine getAutomaticCashMachine() {
		return automaticCashMachine;
	}
	public void setAutomaticCashMachine(AutomaticCashMachine automaticCashMachine) {
		this.automaticCashMachine = automaticCashMachine;
	}
	public SecurityCamera getSecurityCamera() {
		return securityCamera;
	}
	public void setSecurityCamera(SecurityCamera securityCamera) {
		this.securityCamera = securityCamera;
	}
	public TouchScreen getTouchScreen() {
		return touchScreen;
	}
	public void setTouchScreen(TouchScreen touchScreen) {
		this.touchScreen = touchScreen;
	}
	public AlarmSystem getAlarmSystem() {
		return alarmSystem;
	}
	public void setAlarmSystem(AlarmSystem alarmSystem) {
		this.alarmSystem = alarmSystem;
	}
}
