package cn.com.xb.inter.domain.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private long sequenceNumber;// 序列号
	private int resultStatus;// 1：成功 ；0：失败
	private String errorMsg; // 错误信息(可选，调用接口出错，需要提示错误)
	private String storageStationId;// 物箱编码

	private String guiSequenceNumber; // 指令序列号，仅GUI命令触发的同步需要此序列号(整个服务器全局唯一)

	public String getGuiSequenceNumber() {
		return guiSequenceNumber;
	}

	public void setGuiSequenceNumber(String guiSequenceNumber) {
		this.guiSequenceNumber = guiSequenceNumber;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}

	public long getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getStorageStationId() {
		return storageStationId;
	}

	public void setStorageStationId(String storageStationId) {
		this.storageStationId = storageStationId;
	}

}
