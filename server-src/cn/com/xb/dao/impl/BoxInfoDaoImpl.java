package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IBoxInfoDao;
import  cn.com.xb.domain.base.BoxInfo;

public class BoxInfoDaoImpl implements IBoxInfoDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<BoxInfo> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_BOX_INFO";
		 List<BoxInfo> list = new ArrayList<BoxInfo>();
		 List<BoxInfo> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 BoxInfo boxinfo = fetch(map); 
			 list.add(boxinfo); 
		 }
		 return list;
	}
	
	public BoxInfo loadBoxInfoByboxId(String boxId) throws Exception {
		 BoxInfo boxinfo = null;
		 String sql ="SELECT * FROM T_BOX_INFO WHERE BOX_ID = ? ";
		 Object[] values = new Object[]{boxId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 boxinfo = fetch(map);
		 return boxinfo;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_BOX_INFO";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String boxId) throws Exception{
		 String sql ="DELETE FROM T_BOX_INFO WHERE BOX_ID=?";
		 Object[] values = new Object[] { boxId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(BoxInfo boxinfo) throws Exception{
		 String sql ="UPDATE T_BOX_INFO SET CABINET_ID= ?,SS_ID= ?,BOX_CODE= ?,BOX_INDEX= ?,ASSET_SN= ?,SIZE= ?,LOAD_STATUS= ?,RUN_STATUS= ? WHERE BOX_ID=?";
		 Object[] values = new Object[] {boxinfo.getCabinetId(),boxinfo.getSsId(),boxinfo.getBoxCode(),boxinfo.getBoxIndex(),boxinfo.getAssetSn(),boxinfo.getSize(),boxinfo.getLoadStatus(),boxinfo.getRunStatus(),boxinfo.getBoxId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(BoxInfo boxinfo) throws Exception{
		 String sql ="INSERT INTO T_BOX_INFO(BOX_ID,CABINET_ID,SS_ID,BOX_CODE,BOX_INDEX,ASSET_SN,SIZE,LOAD_STATUS,RUN_STATUS) VALUES(?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {boxinfo.getBoxId(),boxinfo.getCabinetId(),boxinfo.getSsId(),boxinfo.getBoxCode(),boxinfo.getBoxIndex(),boxinfo.getAssetSn(),boxinfo.getSize(),boxinfo.getLoadStatus(),boxinfo.getRunStatus()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public BoxInfo fetch(Map map) throws Exception{
		BoxInfo boxinfo = new BoxInfo();		
		boxinfo.setBoxId((String)map.get("BOX_ID"));
		boxinfo.setCabinetId((String)map.get("CABINET_ID"));
		boxinfo.setSsId((String)map.get("SS_ID"));
		boxinfo.setBoxCode((String)map.get("BOX_CODE"));
		boxinfo.setBoxIndex((String)map.get("BOX_INDEX"));
		boxinfo.setAssetSn((String)map.get("ASSET_SN"));
		boxinfo.setSize(Integer.parseInt(map.get("SIZE").toString()));
		boxinfo.setLoadStatus(Integer.parseInt(map.get("LOAD_STATUS").toString()));
		boxinfo.setRunStatus(Integer.parseInt(map.get("RUN_STATUS").toString()));
		return boxinfo;
	}
}
