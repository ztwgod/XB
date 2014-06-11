package cn.com.xb.inter.domain.request;

import java.io.Serializable;

public class SynchCourierWrapper extends BaseRequest implements Serializable {

	/**
	 * 快递员同步信息封装
	 */
	private static final long serialVersionUID = 1L;

	private int exePermissionType; // 快递员执行权限（0,取件/寄件快递员；1,取件快递员；2,派件快递员）
	
	
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(this.exePermissionType<0 || this.exePermissionType>2){
			buffer.append("exePermissionType非法。");
		}
		/*if(VerifyTool.isNull(super.getStorageStationId())){
			buffer.append("storageStationId不能为空。");
		}*/
		return buffer.toString();
	}

	public int getExePermissionType() {
		return exePermissionType;
	}

	public void setExePermissionType(int exePermissionType) {
		this.exePermissionType = exePermissionType;
	}

}
