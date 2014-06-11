package cn.com.xb.portal.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.com.xb.service.BoxInfoService;
import cn.com.xb.util.ClientProperty;
import cn.com.xb.util.Global;

import com.opensymphony.xwork2.ActionSupport;


public class MapAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	private static final long serialVersionUID = -578697069556382981L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private BoxInfoService boxInfoService;
		
	public void setBoxInfoService(BoxInfoService boxInfoService) {
		this.boxInfoService = boxInfoService;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}	
	
	/**
	 *加载地图
	 * @return
	 * @throws Exception
	 */
	public String loadMap() throws Exception {
		String ak = ClientProperty.getProperty("config", "BAIDUMAP_AK");
		String mdKey = ClientProperty.getProperty("config", "BAIDUMAP_MDKEY");
		request.setAttribute("ak", ak);
		request.setAttribute("mdKey", mdKey);
		return SUCCESS;
	}
	
	/**
	 * 模糊查询地址
	 * @return
	 * @throws Exception
	 */
	public void loadBoxCnt() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String poiId = request.getParameter("poiId");
		System.out.println(poiId);
		Map<Integer, Integer> maps = boxInfoService.getStoragestationByPoiId(poiId);
		String writer = this.mapToString(maps);
		response.getWriter().write(writer);
	}
	
	private String mapToString(Map<Integer, Integer> maps){
		StringBuilder builder = new StringBuilder();
		builder.append("剩余箱子：超大").append(maps.get(Global.BOX_SIZE_XXL)).append("个，大")
		.append(maps.get(Global.BOX_SIZE_XL)).append("个，中")
		.append(maps.get(Global.BOX_SIZE_L)).append("个，小")
		.append(maps.get(Global.BOX_SIZE_M)).append("个，超小")
		.append(maps.get(Global.BOX_SIZE_S)).append("个");
		return builder.toString();
	}
	
}
