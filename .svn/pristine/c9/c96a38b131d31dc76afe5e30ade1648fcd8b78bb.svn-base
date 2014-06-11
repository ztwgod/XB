package cn.com.xb.plat.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.com.xb.domain.base.GbDistrict;
import cn.com.xb.domain.base.Location;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.StoragestationGroup;
import cn.com.xb.domain.base.StoragestationGroupx;
import cn.com.xb.service.GbDistrictService;
import cn.com.xb.service.LocationServer;
import cn.com.xb.service.StoragestationaService;
import cn.com.xb.util.Global;
import cn.com.xb.util.SessionManger;
import cn.com.xb.util.StringUtil;

import com.opensymphony.xwork2.ActionSupport;

public class StoragestationaGroupAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	private static final long serialVersionUID = -578697069556382981L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private StoragestationaService storagestationaService;
	private GbDistrictService gbDistrictService;
	private LocationServer locationServer;
	
	public void setLocationServer(LocationServer locationServer) {
		this.locationServer = locationServer;
	}
	public void setGbDistrictService(GbDistrictService gbDistrictService) {
		this.gbDistrictService = gbDistrictService;
	}
	public void setStoragestationaService(StoragestationaService storagestationaService) {
		this.storagestationaService = storagestationaService;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 跳转到物箱组列表
	 * @return
	 * @throws Exception
	 */
	public String listBoxGroup() throws Exception{
		//初始化下拉框
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(Global.GB_DISTRICT_TREE_ROOT);
		request.setAttribute("gds", gds);
		request.setAttribute("nextId", "cityTD");
		
		String _pageNumber = request.getParameter("pageNumber")==null?"1":request.getParameter("pageNumber");
		String districtId = request.getParameter("districtId")==null?"":request.getParameter("districtId");
		String groupName = request.getParameter("groupName")==null?"":request.getParameter("groupName");
		
		int pageNumber = Integer.parseInt(_pageNumber);
		
		StoragestationGroupx storGroup = new StoragestationGroupx();
		storGroup.setDistrictId(districtId);
		storGroup.setGroupAbb(groupName);
		
		int items = storagestationaService.getItems(storGroup);
		Page page = new Page();
		page.setPageAllCount(items);
		page.setPageNumber(pageNumber);
		
		List<StoragestationGroupx> listGroup = storagestationaService.loadList(storGroup, page);
		request.setAttribute("page", page);
		request.setAttribute("listGroup", listGroup);
		request.setAttribute("storGroup", storGroup);
		return SUCCESS;
	}
	
	/**
	 * 跳转到添加物箱组页面
	 * @return
	 * @throws Exception
	 */
	public String toAddBoxGroup() throws Exception{
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(Global.GB_DISTRICT_TREE_ROOT);
		request.setAttribute("gds", gds);
		request.setAttribute("nextId", "cityTD");
		return SUCCESS;
	}
	
	/**
	 * 添加物箱
	 * @return
	 * @throws Exception
	 */
	public String doAddBoxGroup() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String groupAbb = request.getParameter("groupAbb");
		String districtId = request.getParameter("districtId");
		String groupCode = request.getParameter("groupCode");
		String seatDesc = request.getParameter("seatDesc");
		//String availableBoxNum = request.getParameter("availableBoxNum");
		
		//String poiId = request.getParameter("poiId");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		String groupDesc = request.getParameter("groupDesc");
		String locationAbb = request.getParameter("locationAbb");
		
		String districtName = "";
		if(StringUtil.isNotBlank(districtId))
		{
			districtName = gbDistrictService.getGBDistrictFullName(districtId);
		}
		
		StoragestationGroup storGroup = new StoragestationGroup();
		storGroup.setGroupAbb(groupAbb);
		storGroup.setGroupCode(StringUtil.appendZero(2, groupCode));
		storGroup.setSeatDesc(seatDesc);
		storGroup.setGroupDesc(groupDesc);
		storGroup.setLongitude(Double.parseDouble(longitude));
		storGroup.setLatitude(Double.parseDouble(latitude));
		//storGroup.setAvailableBoxNum(Integer.parseInt(availableBoxNum));
		
		Location location = new Location();
		location.setAddress(districtName+" "+locationAbb);
		location.setLocationAbb(locationAbb);
		
		//location.setPoiId(poiId);
		//location.setLongitude(Double.parseDouble(longitude));
		//location.setLatitude(Double.parseDouble(latitude));
		location.setDistrictId(districtId);
		
		storagestationaService.insertStoragestationGroup(opUserId, storGroup, location);
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改物箱组页面
	 * @return
	 * @throws Exception
	 */
	public String toUpdateBoxGroup() throws Exception{
		String groupId = request.getParameter("groupId");
		StoragestationGroupx storGroupx = storagestationaService.loadStoragestationGroupxByGroupId(groupId);
		
		List<GbDistrict> gds = gbDistrictService.getGBDistrictList(Global.GB_DISTRICT_TREE_ROOT);
		request.setAttribute("storGroupx", storGroupx);
		request.setAttribute("gds", gds);
		request.setAttribute("nextId", "cityTD");
		return SUCCESS;
	}
	
	/**
	 * 修改物箱
	 * @return
	 * @throws Exception
	 */
	public String doUpdateBoxGroup() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String groupId = request.getParameter("groupId");
		String groupAbb = request.getParameter("groupAbb");
		String districtId = request.getParameter("districtId");
		String groupCode = request.getParameter("groupCode");
		String seatDesc = request.getParameter("seatDesc");
		//String availableBoxNum = request.getParameter("availableBoxNum");
		String locationAbb = request.getParameter("locationAbb");
		
		//String poiId = request.getParameter("poiId");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		String groupDesc = request.getParameter("groupDesc");
		
		String districtName = "";
		if(StringUtil.isNotBlank(districtId))
		{
			districtName = gbDistrictService.getGBDistrictFullName(districtId);
		}
		
		
		StoragestationGroup storGroup = storagestationaService.loadStoragestationGroupByGroupId(groupId);
		storGroup.setGroupAbb(groupAbb);
		storGroup.setGroupCode(StringUtil.appendZero(2, groupCode));
		storGroup.setSeatDesc(seatDesc);
		storGroup.setGroupDesc(groupDesc);
		storGroup.setLongitude(Double.parseDouble(longitude));
		storGroup.setLatitude(Double.parseDouble(latitude));
		//storGroup.setAvailableBoxNum(Integer.parseInt(availableBoxNum));
		
		Location location = storagestationaService.loadLocationByLocation(storGroup.getLocationId());
		//location.setPoiId(poiId);
		//location.setLongitude(Double.parseDouble(longitude));
		//location.setLatitude(Double.parseDouble(latitude));
		location.setDistrictId(districtId);
		location.setAddress(districtName+" "+locationAbb);
		location.setLocationAbb(locationAbb);
		
		storagestationaService.updateStoragestationGroup(opUserId, storGroup, location);
		return SUCCESS;
	}
	
	/**
	 * 组代码验证
	 * @throws Exception
	 */
	public void verifyGroupCode() throws Exception{
		response.setContentType("text/plain;charset=UTF-8");
		String districtId = request.getParameter("districtId");
		String groupCode = request.getParameter("groupCode");
		if(groupCode.contains(districtId)){
			response.getWriter().write(groupCode);
			return;
		}
		int locationCode = locationServer.getMaxCode(districtId);
		String lCode = StringUtil.appendZero(4, String.valueOf(locationCode));
		
		String gGode = StringUtil.appendZero(2, groupCode);
		//组代码=地域ID（6位）+地点代码（4位）+用户输入组编号（2位）
		String allCode = districtId+lCode+gGode;
		response.getWriter().write(allCode);
		
		//同一地点下的组代码不能重复
		/*boolean flag = locationServer.isExistLocation(allCode, districtId);
		if(flag){ //不存在，可用
			response.getWriter().write(allCode);
		}else{
			response.getWriter().write("FAIL");
		}*/		
	}
	
	
	
	/**
	 * 删除方法
	 * @throws Exception
	 */
	public String doDeleteBoxGroup() throws Exception{
		String opUserId = SessionManger.loadPlatUserSession(request).getUserId();
		String groupId = request.getParameter("groupId");
		String locationId = request.getParameter("locatonId");
		storagestationaService.delteStoragestationGroup(opUserId, groupId, locationId);
		return SUCCESS;
	}
	
}
