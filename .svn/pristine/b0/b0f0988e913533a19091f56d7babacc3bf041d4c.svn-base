package cn.com.xb.inter.domain.request;

import java.io.Serializable;

import cn.com.xb.inter.domain.IStorageStationInfo;
import cn.com.xb.util.VerifyTool;

public class SynchWrapper extends BaseRequest implements Serializable {

	/**
	 * 同步信息封装
	 */
	private static final long serialVersionUID = 1L;

	private int synchType;// 同步类型
	// 1，注册、新建；2，注册、故障恢复；3，注册、重启；4，注册、其他原因；5，同步、周期；6，同步、派件；7，同步、取件；8，同步、故障

	private IStorageStationInfo storageStation;// 物箱详情
	private String time;// 操作时间 yyyy-MM-dd hh24:mm:ss
	
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(1>this.synchType || this.synchType>8){
			buffer.append("synchType 输入非法");
		}
		if(!VerifyTool.isDate(this.time)){
			buffer.append("time 输入非法");
		}
		return buffer.toString();
	}

	public int getSynchType() {
		return synchType;
	}

	public void setSynchType(int synchType) {
		this.synchType = synchType;
	}

	public IStorageStationInfo getStorageStation() {
		return storageStation;
	}

	public void setStorageStation(IStorageStationInfo storageStation) {
		this.storageStation = storageStation;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
