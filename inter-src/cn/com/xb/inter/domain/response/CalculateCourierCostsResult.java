package cn.com.xb.inter.domain.response;

import java.io.Serializable;

public class CalculateCourierCostsResult extends BaseResponse implements Serializable {

	/**
	 * 快递费用 计算请求返回结果
	 */
	private static final long serialVersionUID = 1L;

	private int courierCosts;// 快递费用 [单位：RMB元]

	public int getCourierCosts() {
		return courierCosts;
	}

	public void setCourierCosts(int courierCosts) {
		this.courierCosts = courierCosts;
	}
}
