package cn.com.xb.inter.service;

public interface XBProcessServer {

	/**
	 * 物箱平台处理请求接口
	 * @param message 请求数据 Json格式
	 * @param applyCode 接口代码
	 * @return
	 * @throws Exception
	 */
	public String process(String message) throws Exception;
	
}
