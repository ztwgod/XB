package cn.com.xb.util;

import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpClientUtil {

	private HttpClient httpClient;
	private PostMethod postMethod;

	private static final String PROXY_SITE = "10.7.204.28"; // 代理服务器地址
	private static final int PROXY_PORT = 808; // 代理服务器端地址

	/**
	 * 实例化对象
	 */
	public HttpClientUtil() {
		httpClient = new HttpClient();
	}

	/**
	 * 代理设置
	 * 
	 * @param site
	 *            代理服务器地址
	 * @param prot
	 *            端口
	 */
	private void setProxy(String site, int prot) {
		httpClient.getHostConfiguration().setProxy(site, prot);
	}

	/**
	 * 获取链接
	 * 
	 * @param url
	 */
	private void connect(String baseUrl) {
		postMethod = new PostMethod(baseUrl);
	}

	/**
	 * 添加参数
	 */
	private void addParameter(Map<String, String> paras) {
		if (null != paras && paras.size() > 0) {
			Object[] keys = paras.keySet().toArray();
			NameValuePair[] nameValuePairs = new NameValuePair[keys.length];
			for (int i = 0; i < keys.length; i++) {
				NameValuePair name = new NameValuePair((String) keys[i],
						(String) paras.get(keys[i]));
				nameValuePairs[i] = name;
			}
			postMethod.setRequestBody(nameValuePairs);
		}
	}

	/**
	 * 发送请求
	 * 
	 * @param baseUrl
	 *            请求服务器地址
	 * @param params
	 *            参数
	 * @param flag
	 *            是否需要经过代理 true为通过代理 false为不经过代理
	 * @return
	 * @throws Exception
	 */
	public String doPost(String baseUrl, Map<String, String> params,
			boolean isProxy) throws Exception {
		if (isProxy) {
			this.setProxy(PROXY_SITE, PROXY_PORT);
		}
		this.connect(baseUrl);
		this.addParameter(params);

		httpClient.executeMethod(postMethod);
		return new String(postMethod.getResponseBody(), "UTF-8");
	}

	public static void main(String[] args) throws Exception {
		HttpClientUtil http = new HttpClientUtil();
		//Map<String, String> params = new HashMap<String, String>();
		String address = URLEncoder.encode("上海","UTF-8");
		String query = URLEncoder.encode("软件开发", "UTF-8");
		
		String url = "http://api.map.baidu.com/place/v2/search?&q="+query+"&region="+ address +"&output=xml&ak=63511dfe583df752929d369836958dfd";

		String result = http.doPost(url, null, false);
		System.out.println(result);
	}
}
