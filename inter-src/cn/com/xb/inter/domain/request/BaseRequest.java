package cn.com.xb.inter.domain.request;

import java.io.Serializable;

public class BaseRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private long sequenceNumber; // 序列号
	private String guiSequenceNumber; // 物箱GUI交易号
	private String storageStationId; // 物箱编码
	
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

	public String getGuiSequenceNumber() {
		return guiSequenceNumber;
	}

	public void setGuiSequenceNumber(String guiSequenceNumber) {
		this.guiSequenceNumber = guiSequenceNumber;
	}
}
