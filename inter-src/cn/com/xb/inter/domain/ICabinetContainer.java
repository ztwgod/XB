package cn.com.xb.inter.domain;

import java.io.Serializable;
import java.util.List;

import cn.com.xb.domain.base.Cabinet;
import cn.com.xb.util.VerifyTool;

public class ICabinetContainer implements Serializable {

	/**
	 * 物箱柜子
	 */
	private static final long serialVersionUID = 1L;
	private String cabinetCode;// 柜子CODE
	private String cabinetIndex;// 柜子序列
	private int	type;//柜子类型【1，A型；2、B型；】
	
	private String version;// 版本
	private String assetSn;// 资产编号
	private int cabinetWidth;// 宽度，横排箱子数
	private int cabinetHeight;// 高度，竖排箱子数
	private int boxNumber;// 柜子包含箱子数 从左到右、从上到下排序
	private int status;// 状态【1,正常;2,无空箱;3,负荷高;4,系统忙;5,故障恢复;6,维护中;7,断链;8,闭塞;9,重启】
	private List<IBoxInfo> boxInfos;// 箱子列表
	
	public String empty(){
		StringBuffer buffer = new StringBuffer();
		if(VerifyTool.isNull(this.cabinetCode)){
			buffer.append("cabinetCode不能为空。");
		}
		
		if(VerifyTool.isNull(this.cabinetIndex)){
			buffer.append(this.cabinetCode+"，cabinetIndex不能为空。");
		}
		
		if(this.type!=1 && this.type!=2){
			buffer.append(this.cabinetCode+"，type输入非法。");
		}
		
//		if(VerifyTool.isNull(this.version)){
//			buffer.append(this.cabinetCode+"，version不能为空。");
//		}
//		
//		if(VerifyTool.isNull(this.assetSn)){
//			buffer.append(this.cabinetCode+"，assetSn不能为空。");
//		}
		
		if(this.cabinetWidth<=0){
			buffer.append(this.cabinetCode+"，cabinetWidth输入非法。");
		}
		
		if(this.cabinetHeight<=0){
			buffer.append(this.cabinetCode+"，cabinetHeight输入非法。");
		}
		
		if(this.boxNumber<=0){
			buffer.append(this.cabinetCode+"，boxNumber输入非法。");
		}
		
		if(this.status<1 || this.status>9){
			buffer.append(this.cabinetCode+"，status 输入非法。");
		}
		
		return buffer.toString();
	}
	

	public Cabinet getCabinet() {
		Cabinet cabinet = new Cabinet();
		cabinet.setCabinetCode(cabinetCode);
		cabinet.setCabinetIndex(cabinetIndex);
		cabinet.setCabinetModel(version);
		cabinet.setAssetSn(assetSn);
		cabinet.setCabinetWidth(cabinetWidth);
		cabinet.setCabinetHeight(cabinetHeight);
		cabinet.setBoxNumber(boxNumber);
		cabinet.setCabinetStatus(status);
		return cabinet;
	}

	public ICabinetContainer() {

	}

	public ICabinetContainer(String cabinetCode, String cabinetIndex,
			String version, String assetSn, int cabinetWidth,
			int cabinetHeight, int boxNumber, int status,
			List<IBoxInfo> boxInfos,int type) {
		super();
		this.cabinetCode = cabinetCode;
		this.cabinetIndex = cabinetIndex;
		this.version = version;
		this.assetSn = assetSn;
		this.cabinetWidth = cabinetWidth;
		this.cabinetHeight = cabinetHeight;
		this.boxNumber = boxNumber;
		this.status = status;
		this.boxInfos = boxInfos;
		this.type = type;
	}

	public String getCabinetCode() {
		return cabinetCode;
	}

	public void setCabinetCode(String cabinetCode) {
		this.cabinetCode = cabinetCode;
	}

	public String getCabinetIndex() {
		return cabinetIndex;
	}

	public void setCabinetIndex(String cabinetIndex) {
		this.cabinetIndex = cabinetIndex;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAssetSn() {
		return assetSn;
	}

	public void setAssetSn(String assetSn) {
		this.assetSn = assetSn;
	}

	public int getCabinetWidth() {
		return cabinetWidth;
	}

	public void setCabinetWidth(int cabinetWidth) {
		this.cabinetWidth = cabinetWidth;
	}

	public int getCabinetHeight() {
		return cabinetHeight;
	}

	public void setCabinetHeight(int cabinetHeight) {
		this.cabinetHeight = cabinetHeight;
	}

	public int getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(int boxNumber) {
		this.boxNumber = boxNumber;
	}

	public int getStatus() {
		return status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<IBoxInfo> getBoxInfos() {
		return boxInfos;
	}

	public void setBoxInfos(List<IBoxInfo> boxInfos) {
		this.boxInfos = boxInfos;
	}

	public ICabinetContainer getICabinetContainer(Cabinet cabinet,
			List<IBoxInfo> boxInfos) {
		ICabinetContainer iCabinetContainer = new ICabinetContainer();
		iCabinetContainer.setAssetSn(cabinet.getAssetSn());
		iCabinetContainer.setBoxNumber(cabinet.getBoxNumber());
		iCabinetContainer.setCabinetCode(cabinet.getCabinetCode());
		iCabinetContainer.setCabinetHeight(cabinet.getCabinetHeight());
		iCabinetContainer.setCabinetIndex(cabinet.getCabinetIndex());
		iCabinetContainer.setCabinetWidth(cabinet.getCabinetWidth());
		iCabinetContainer.setStatus(cabinet.getCabinetStatus());
		iCabinetContainer.setVersion(cabinet.getCabinetModel());
		return iCabinetContainer;
	}
}
