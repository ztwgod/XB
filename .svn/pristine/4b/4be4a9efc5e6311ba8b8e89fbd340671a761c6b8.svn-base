package cn.com.xb.inter.domain;

import java.io.Serializable;
import java.util.List;

public class ISysUserAuthorityInfo implements Serializable {

	/**
	 * 维护人员权限信息
	 */
	private static final long serialVersionUID = 1L;

	private ISysUserInfo sysUserInfo;// 维护人员员信息
	private ISysUserCardInfo sysUserCardInfo;// 维护人员关联卡信息
	private int authorityType;// 权限类型（1，可开启任意物箱；2，只允许开启特定状态物箱；3，只允许开启某一个物箱、或多个指定物箱）一期只支持第三种
	
	private List<Integer>	boxRunStatus;//	(authorityType == 2)运行状态：1，空闲、2，占用、3，占用超时、4，弃件（占用超期）、5，开启、6，故障、7，租用、8，预留、9，闭塞、10，未关闭、11，被破坏、12，维修
	private List<String>	boxCodes;//维护人员可维护的箱子code列表

	public ISysUserInfo getSysUserInfo() {
		return sysUserInfo;
	}

	public void setSysUserInfo(ISysUserInfo sysUserInfo) {
		this.sysUserInfo = sysUserInfo;
	}

	public ISysUserCardInfo getSysUserCardInfo() {
		return sysUserCardInfo;
	}

	public void setSysUserCardInfo(ISysUserCardInfo sysUserCardInfo) {
		this.sysUserCardInfo = sysUserCardInfo;
	}

	public int getAuthorityType() {
		return authorityType;
	}

	public void setAuthorityType(int authorityType) {
		this.authorityType = authorityType;
	}

	public List<Integer> getBoxRunStatus() {
		return boxRunStatus;
	}

	public void setBoxRunStatus(List<Integer> boxRunStatus) {
		this.boxRunStatus = boxRunStatus;
	}

	public List<String> getBoxCodes() {
		return boxCodes;
	}

	public void setBoxCodes(List<String> boxCodes) {
		this.boxCodes = boxCodes;
	}
}
