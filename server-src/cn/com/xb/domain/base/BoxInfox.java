package cn.com.xb.domain.base;

public class BoxInfox extends BoxInfo {

	private static final long serialVersionUID = 1L;

	private String runStatusName; // 运行状态
	private String loadStatusName; // 存货状态

	public String getRunStatusName() {
		return runStatusName;
	}

	public void setRunStatusName(String runStatusName) {
		this.runStatusName = runStatusName;
	}

	public String getLoadStatusName() {
		return loadStatusName;
	}

	public void setLoadStatusName(String loadStatusName) {
		this.loadStatusName = loadStatusName;
	}

}
