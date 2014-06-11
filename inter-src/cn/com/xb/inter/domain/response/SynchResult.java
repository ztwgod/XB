package cn.com.xb.inter.domain.response;

import java.io.Serializable;

public class SynchResult extends BaseResponse implements Serializable {

	/**
	 * 物箱同步结果
	 */
	private static final long serialVersionUID = 1L;

	// 1,注册成功；2,失败、配置错误；3,失败、系统忙；4,失败、操作维护；5,同步成功；6,失败；7,拒绝同步
	private int synchStatus;// 同步状态

	public int getSynchStatus() {
		return synchStatus;
	}

	public void setSynchStatus(int synchStatus) {
		this.synchStatus = synchStatus;
	}

}
