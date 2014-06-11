package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.CourierGroup;

public interface ICourierGroupDao{

	public  List<CourierGroup> loadAll() throws Exception;
	
	public  CourierGroup loadCourierGroupBygroupId(String groupId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String groupId) throws Exception;
	
	public  void update(CourierGroup couriergroup) throws Exception;
	
	public  void insert(CourierGroup couriergroup) throws Exception;
	
	public  CourierGroup fetch(Map map) throws Exception;
}

