package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import cn.com.xb.dao.impl.BoxInfoDaoImpl;
import cn.com.xb.daox.IBoxInfoDaox;
import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.inter.domain.IDeviceStatus;
import cn.com.xb.util.Global;
import cn.com.xb.util.StringUtil;

public class BoxInfoDaoxImpl extends BoxInfoDaoImpl implements IBoxInfoDaox {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<BoxInfo> getBoxInfoByLoadStatus(String poiId,int loadStatus) throws Exception {
		 StringBuilder sql = new StringBuilder();
		 sql.append(" SELECT C.SS_ID,D.SIZE FROM T_LOCATION A,T_STORAGESTATION_GROUP B,T_STORAGESTATION C ,T_BOX_INFO D ");
		 sql.append(" WHERE A.LOCATION_ID = B.LOCATION_ID AND C.GROUP_ID = B.GROUP_ID AND D.SS_ID = C.SS_ID AND A.POI_ID = ? AND D.LOAD_STATUS = ? ");
		 
		 Object[] values = new Object[]{poiId,loadStatus};
		 List<BoxInfo> list = new ArrayList<BoxInfo>();
		 List<BoxInfo> mapList = jdbcTemplate.queryForList(sql.toString(),values);
		 Iterator it = mapList.iterator();		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 BoxInfo boxinfo = new BoxInfo();
			 boxinfo.setSize(Integer.parseInt(map.get("SIZE").toString()));
			 boxinfo.setSsId((String)map.get("SS_ID"));			 
			 list.add(boxinfo); 
		 }
		 return list;
	}
	
	
	//@Override
	/*public List<BoxInfo> getBoxInfoLsBySSId(String ssId) throws Exception {
		String sql ="SELECT * FROM T_BOX_INFO WHERE SS_ID = ? ";
		List<BoxInfo> list = new ArrayList<BoxInfo>();
		List<BoxInfo> mapList = jdbcTemplate.queryForList(sql,new String[]{ssId});
		Iterator it = mapList.iterator();
		 
		while (it.hasNext()) { 
			Map map = (Map) it.next();
			BoxInfo boxinfo = fetch(map); 
			list.add(boxinfo); 
		 }
		 return list;
	}*/

	@Override
	public void updateBoxInfo(BoxInfo boxinfo) throws Exception {
		String sql ="UPDATE T_BOX_INFO A SET A.BOX_CODE = ?,A.BOX_INDEX = ?,A.ASSET_SN = ?,A.SIZE = ?,A.LOAD_STATUS = ?,A.RUN_STATUS = ? WHERE A.BOX_ID = ?";
		 Object[] values = new Object[] {boxinfo.getBoxCode(),boxinfo.getBoxIndex(),boxinfo.getAssetSn(),boxinfo.getSize(),boxinfo.getLoadStatus(),
				 boxinfo.getRunStatus(),boxinfo.getBoxId()};
		 jdbcTemplate.update(sql, values);
	}

	public List<Storagestationx> getStoragestationByPoiId(String poiId) throws Exception {
		 StringBuilder sql = new StringBuilder();
		 sql.append(" SELECT C.SS_ID,D.SIZE FROM T_STORAGESTATION C ,T_BOX_INFO D WHERE D.SS_ID = C.SS_ID AND C.POI_ID = ? AND D.LOAD_STATUS = ? ");
		 
		 Object[] values = new Object[]{poiId,Global.BOX_LOADSTATUS_IDLE};
		 List<Storagestationx> list = new ArrayList<Storagestationx>();
		 List<Storagestationx> mapList = jdbcTemplate.queryForList(sql.toString(),values);
		 Iterator it = mapList.iterator();		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 Storagestationx storagestation = new Storagestationx();	 
			 storagestation.setSsId(map.get("SS_ID").toString());
			 String size = map.get("SIZE").toString();
			 storagestation.setSize(Integer.parseInt(size));
			 list.add(storagestation); 
		 }
		 return list;
	}

	@Override
	public void deleteBySSId(String ssId) throws Exception {
		String sql ="DELETE FROM T_BOX_INFO WHERE SS_ID=?";
		Object[] values = new Object[] { ssId };
		jdbcTemplate.update(sql, values);
	}
	
	
	public List<BoxInfo> getBoxInfoListBySSId(String ssId) throws Exception
	{
		List<BoxInfo> bis = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT BI.BOX_ID, BI.CABINET_ID, BI.SS_ID, BI.BOX_CODE, BI.BOX_INDEX, BI.ASSET_SN, BI.SIZE, BI.LOAD_STATUS, BI.RUN_STATUS"); //, BI.MAINTAIN_PWD
		sql.append(" FROM T_BOX_INFO BI WHERE BI.SS_ID = ?");
		
		List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{ssId});
		if(null != list && list.size() != 0)
		{
			bis = new ArrayList<BoxInfo>();
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				Map map = (Map) it.next();
				
				BoxInfo bi = new BoxInfo();
				bi.setBoxId(StringUtil.formatStringTrim(map.get("BOX_ID")));
				bi.setCabinetId(StringUtil.formatStringTrim(map.get("CABINET_ID")));
				bi.setSsId(StringUtil.formatStringTrim(map.get("SS_ID")));
				bi.setBoxCode(StringUtil.formatStringTrim(map.get("BOX_CODE")));
				bi.setBoxIndex(StringUtil.formatStringTrim(map.get("BOX_INDEX")));
				bi.setAssetSn(StringUtil.formatStringTrim(map.get("ASSET_SN")));
				bi.setSize(StringUtil.formatStringToInteger(map.get("SIZE"), 0));
				bi.setLoadStatus(StringUtil.formatStringToInteger(map.get("LOAD_STATUS"), 0));
				bi.setRunStatus(StringUtil.formatStringToInteger(map.get("RUN_STATUS"), 0));
				//bi.setMaintainPwd(StringUtil.formatStringTrim(map.get("MAINTAIN_PWD")));
				
				bis.add(bi);
			}
		}
			
		return bis;
	}

	@Override
	public void deleteBoxInfoByCabinetId(String cabinetId) throws Exception {
		String sql ="DELETE FROM T_BOX_INFO WHERE CABINET_ID = ?";
		Object[] values = new Object[] { cabinetId };
		jdbcTemplate.update(sql, values);
	}
	
	
	@Override
	public void updateLoadStatus(IDeviceStatus deviceStatus,String ssId) throws Exception {
		String sql ="UPDATE T_BOX_INFO A SET A.LOAD_STATUS = ? WHERE A.SS_ID = ? AND A.BOX_CODE = ? ";
		Object[] values = new Object[] {deviceStatus.getDeviceStatus(),ssId,deviceStatus.getDeviceCode()};
		 jdbcTemplate.update(sql, values);
	}
	
	public void updateRunStatus(IDeviceStatus deviceStatus,String ssId) throws Exception {
		String sql ="UPDATE T_BOX_INFO A SET A.RUN_STATUS = ? WHERE A.SS_ID = ? AND A.BOX_CODE = ? ";
		Object[] values = new Object[] {deviceStatus.getDeviceStatus(),ssId,deviceStatus.getDeviceCode()};
		 jdbcTemplate.update(sql, values);
	}
	
	public String getBoxIdByBoxCode(String boxCode) throws Exception
	{
		String boxId = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT BI.BOX_ID FROM T_BOX_INFO BI WHERE BI.BOX_CODE = ?");
		
		List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{boxCode});
		if(null != list && list.size() != 0)
		{
			boxId = StringUtil.formatStringTrimToNull(((Map) list.get(0)).get("BOX_ID"));
		}
		
		return boxId;
	}
	

	public void updateLoadStatusByBoxId(String boxId, int status) throws Exception
	{
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE T_BOX_INFO A SET A.LOAD_STATUS = ? WHERE A.BOX_ID = ? ");
		jdbcTemplate.update(sql.toString(), new Object[] {status, boxId});
	}

	public int getItemsByRunStatus(String ssId, int runStatus) throws Exception {
		StringBuffer sql = new StringBuffer("SELECT COUNT(1) FROM T_BOX_INFO A WHERE A.SS_ID = ? ");
		if(runStatus!=0){
			sql.append(" AND A.RUN_STATUS = " + runStatus);
		}
		int items = jdbcTemplate.queryForInt(sql.toString(),new String[]{ssId});
		return items;
	}

	@Override
	public String getBoxCodeByBoxId(String boxId) throws Exception {
		StringBuffer sql = new StringBuffer("SELECT BOX_CODE FROM T_BOX_INFO WHERE BOX_ID = ? ");
		List list=jdbcTemplate.queryForList(sql.toString(),new String[]{boxId});
		String boxCode=StringUtil.formatStringTrimToNull(((Map) list.get(0)).get("BOX_CODE"));
		return boxCode;
	}
	public String getBoxIndexByBoxId(String boxId) throws Exception {
		StringBuffer sql = new StringBuffer("SELECT BOX_INDEX FROM T_BOX_INFO WHERE BOX_ID = ? ");
		List list=jdbcTemplate.queryForList(sql.toString(),new String[]{boxId});
		String boxIndex=StringUtil.formatStringTrimToNull(((Map) list.get(0)).get("BOX_INDEX"));
		return boxIndex;
	}

	@Override
	public String getSSIDByBoxId(String boxId) {
		StringBuffer sql = new StringBuffer("SELECT SS_ID FROM T_BOX_INFO WHERE BOX_ID = ? ");
		List list=jdbcTemplate.queryForList(sql.toString(),new String[]{boxId});
		String ssId=StringUtil.formatStringTrimToNull(((Map) list.get(0)).get("SS_ID"));
		return ssId;
	}
}
