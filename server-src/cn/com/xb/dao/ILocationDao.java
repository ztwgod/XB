package cn.com.xb.dao;

import java.util.List;
import java.util.Map;

import  cn.com.xb.domain.base.Location;

public interface ILocationDao{

	public  List<Location> loadAll() throws Exception;
	
	public  Location loadLocationBylocationId(String locationId) throws Exception;
	
	public  int loadItems() throws Exception;
	
	public  void delete(String locationId) throws Exception;
	
	public  void update(Location location) throws Exception;
	
	public  void insert(Location location) throws Exception;
	
	public  Location fetch(Map map) throws Exception;
}

