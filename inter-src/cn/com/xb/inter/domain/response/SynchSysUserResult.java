package cn.com.xb.inter.domain.response;

import java.io.Serializable;
import java.util.List;

import cn.com.xb.inter.domain.ISysUserAuthorityInfo;

public class SynchSysUserResult extends BaseResponse implements Serializable {

	/**
	 * 维护人员同步信息封装
	 */
	private static final long serialVersionUID = 1L;

	private List<ISysUserAuthorityInfo> sysUserAuthorityInfos;// 维护人员权限信息

	public List<ISysUserAuthorityInfo> getSysUserAuthorityInfos() {
		return sysUserAuthorityInfos;
	}

	public void setSysUserAuthorityInfos(
			List<ISysUserAuthorityInfo> sysUserAuthorityInfos) {
		this.sysUserAuthorityInfos = sysUserAuthorityInfos;
	}
}
