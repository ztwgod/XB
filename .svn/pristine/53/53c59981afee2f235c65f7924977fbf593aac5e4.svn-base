package cn.com.xb.service;

import java.util.Map;

import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.inter.domain.SynchBoxInfoObject;

public interface BoxInfoService {
	
	public Map<Integer,Integer> getBoxInfoByLoadStatus(String poiId,int loadStatus) throws Exception;
	
	public Map<Integer,Integer> getStoragestationByPoiId(String poiId) throws Exception;
	
	public Map<String, BoxInfo> getBoxInfoListBySSId(String ssId) throws Exception;
	
	public void updateBoxInfo(BoxInfo boxInfo) throws Exception;
	
	public void synchBoxInfo(SynchBoxInfoObject object) throws Exception;
}
