package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.StoragestationDaoImpl;
import cn.com.xb.daox.IStoragestationDaox;
import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.BoxInfox;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.Peripheralx;
import cn.com.xb.domain.base.Storagestation;
import cn.com.xb.domain.base.StoragestationDeliveryG;
import cn.com.xb.domain.base.Storagestationx;
import cn.com.xb.domain.displayWrapper.BoxStatusWrapper;
import cn.com.xb.domain.parameterWrapper.GetBoxStatusListParam;
import cn.com.xb.util.StringUtil;

public class StoragestationDaoxImpl extends StoragestationDaoImpl implements IStoragestationDaox {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Storagestationx> loadStoragestationxList(Storagestationx stro,Page page) throws Exception {
		StringBuilder sql = new StringBuilder("SELECT A.SS_ID,A.SS_CODE,A.SS_NAME,A.IP_ADD,A.DATA_CARD,D.USER_ACCOUNT,B.SEAT_DESC,B.GROUP_ABB,A.SS_TYPE ");
		sql.append(",A.SS_ADDRESS ");
		sql.append(" FROM T_STORAGESTATION A,T_STORAGESTATION_GROUP B,T_SYSUSER_STORAGESTATION C,T_USER D ");
		sql.append(" WHERE A.GROUP_ID = B.GROUP_ID AND C.SS_ID = A.SS_ID AND C.USER_ID = D.USER_ID ");
		List<Object> params = new ArrayList<Object>();
		if(!"".equals(stro.getSsCode())){
			sql.append(" AND A.SS_CODE LIKE '%").append(stro.getSsCode()).append("%'"); 
		}
		if(""!=stro.getSsName()){
			sql.append(" AND A.SS_NAME LIKE '%").append(stro.getSsName()).append("%'");
		}
		if(""!=stro.getGroupId()){
			sql.append(" AND A.GROUP_ID = ? ");
			params.add(stro.getGroupId());
		}
		if(""!=stro.getDataCard()){
			sql.append(" AND A.DATA_CARD LIKE '%").append(stro.getDataCard()).append("%'");
		}
		sql.append(" LIMIT ?,? ");
		params.add(page.getStartItems());
		params.add(page.getPageSize());
		
		List<Storagestationx> list = new ArrayList<Storagestationx>();
		List<Storagestationx> mapList = jdbcTemplate.queryForList(sql.toString(),params.toArray());
		Iterator it = mapList.iterator();	 
		while (it.hasNext()) { 
			Map map = (Map) it.next();
			Storagestationx storagestation = new Storagestationx();
			storagestation.setSsId((String)map.get("SS_ID"));
			storagestation.setSsName((String)map.get("SS_NAME"));
			storagestation.setSsCode((String)map.get("SS_CODE"));
			storagestation.setDataCard((String)map.get("DATA_CARD"));
			storagestation.setIpAdd((String)map.get("IP_ADD"));
			storagestation.setUserName((String)map.get("USER_ACCOUNT"));
			storagestation.setSeatDesc((String)map.get("SEAT_DESC"));
			storagestation.setGroupAbb((String)map.get("GROUP_ABB"));
			storagestation.setSsType((String)map.get("SS_TYPE"));
			//storagestation.setSsIndex((String)map.get("SS_INDEX"));
			storagestation.setSsAddress((String)map.get("SS_ADDRESS"));
			list.add(storagestation);
		}
		return list;
	}
	
	public int loadStoragestationxItems(Storagestationx stro) throws Exception {
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) ");
		sql.append(" FROM T_STORAGESTATION A,T_STORAGESTATION_GROUP B,T_SYSUSER_STORAGESTATION C,T_USER D ");
		sql.append(" WHERE A.GROUP_ID = B.GROUP_ID AND C.SS_ID = A.SS_ID AND C.USER_ID = D.USER_ID ");
		List<Object> params = new ArrayList<Object>();
		if(!"".equals(stro.getSsCode())){
			sql.append(" AND A.SS_CODE LIKE '%").append(stro.getSsCode()).append("%'"); 
		}
		if(""!=stro.getSsName()){
			sql.append(" AND A.SS_NAME LIKE '%").append(stro.getSsName()).append("%'");
		}
		if(""!=stro.getGroupId()){
			sql.append(" AND A.GROUP_ID = ? ");
			params.add(stro.getGroupId());
		}
		if(""!=stro.getDataCard()){
			sql.append(" AND A.DATA_CARD LIKE '%").append(stro.getDataCard()).append("%'");
		}
		return jdbcTemplate.queryForInt(sql.toString(),params.toArray());
	}

	
	public Storagestationx loadStoragestationxBySSId(String ssId,String boxId) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT A.SS_ID,A.SS_NAME,D.SEAT_DESC,C.MOBILE_NUMBER,E.BOX_CODE,E.MAINTAIN_PWD,E.BOX_ID ");
		sql.append(" FROM T_STORAGESTATION A,T_SYSUSER_STORAGESTATION B,T_USER C,T_STORAGESTATION_GROUP D,T_BOX_INFO E ");
		sql.append(" WHERE A.SS_ID = B.SS_ID AND A.GROUP_ID = D.GROUP_ID AND C.USER_ID = B.USER_ID AND E.SS_ID = A.SS_ID ");
		sql.append(" AND A.SS_ID = ? AND E.BOX_CODE = ? ");
		
		Map map = null;
		try{
			 String[] value = new String[]{ssId,boxId};
			 map = jdbcTemplate.queryForMap(sql.toString(), value);
		} catch (DataAccessException e) {
			 return null;
		}
		
		Storagestationx storagestation = new Storagestationx();
		storagestation.setSsId((String)map.get("SS_ID"));
		storagestation.setSsName((String)map.get("SS_NAME"));
		//storagestation.setSsIndex((String)map.get("SS_INDEX"));
		storagestation.setSeatDesc((String)map.get("SEAT_DESC"));
		storagestation.setMobileNumber((String)map.get("MOBILE_NUMBER"));
		storagestation.setBoxCode((String)map.get("BOX_CODE"));
		storagestation.setMaintainPwd((String)map.get("MAINTAIN_PWD"));
		storagestation.setBoxId((String)map.get("BOX_ID"));
		
		return storagestation;
	}
	
	public StoragestationDeliveryG loadStoragestationDeliveryGBySSId(String ssId) throws Exception {
		 StoragestationDeliveryG storagestationdeliveryg = null;
		 String sql ="SELECT * FROM T_STORAGESTATION_DELIVERY_G WHERE SS_ID = ? ";
		 Object[] values = new Object[]{ssId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		storagestationdeliveryg = new StoragestationDeliveryG();		
		storagestationdeliveryg.setSsId((String)map.get("SS_ID"));
		storagestationdeliveryg.setGroupId((String)map.get("GROUP_ID"));
		storagestationdeliveryg.setExePermission(Integer.parseInt(map.get("EXE_PERMISSION").toString()));
		
		return storagestationdeliveryg;
	}
	
	public void deleteStoragestationDeliveryGBySSId(String ssId,int exePermission) throws Exception{
		 String sql ="DELETE FROM T_STORAGESTATION_DELIVERY_G WHERE SS_ID = ? AND EXE_PERMISSION = ? ";
		 Object[] values = new Object[] {ssId,exePermission};
		 jdbcTemplate.update(sql, values);

	}

	public Storagestationx loadStoragestationStatus(String ssId) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.SS_ID,A.SS_CODE,A.RUN_STATUS,A.SS_NAME,B.NAME,A.DATA_CARD FROM T_STORAGESTATION A,T_FLAG_DICTIONARY B ");
		sql.append(" WHERE A.RUN_STATUS = B.CODE AND B.TYPE_ID = '8' AND A.SS_ID = ? ");
		
		Map map = null;
		try {
			map = jdbcTemplate.queryForMap(sql.toString(),new Object[]{ssId});
		} catch (DataAccessException e) {
			return null;
		}
		Storagestationx storagestationx = new Storagestationx();
		storagestationx.setSsId((String)map.get("SS_ID"));
		storagestationx.setSsCode((String)map.get("SS_CODE"));
		storagestationx.setSsName((String)map.get("SS_NAME"));
		storagestationx.setRunStatusName((String)map.get("NAME"));
		storagestationx.setDataCard((String)map.get("DATA_CARD"));
		storagestationx.setRunStatus(Integer.parseInt(map.get("RUN_STATUS").toString()));
		
		return storagestationx;
	}

	public List<Peripheralx> loadPeripheralxInfo(String ssId) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.MEMO,B.RUN_STATUS,D.NAME,C.SS_CODE,C.SS_ID FROM T_PERIPHERAL A,T_STORAGESTATION_PERIPHERAL B, ");
		sql.append(" T_STORAGESTATION C,T_FLAG_DICTIONARY D ");
		sql.append(" WHERE A.PERIPHERAL_ID = B.PERIPHERAL_ID AND C.SS_ID = B.SS_ID AND D.TYPE_ID = '11' ");
		sql.append(" AND D.CODE = B.RUN_STATUS AND C.SS_ID = ? ");
		
		List<Peripheralx> perLs = new ArrayList<Peripheralx>();
		List<Storagestationx> mapList = jdbcTemplate.queryForList(sql.toString(),new Object[]{ssId});
		Iterator it = mapList.iterator();
		while(it.hasNext()){
			Map map = (Map) it.next();
			Peripheralx peripheralx = new Peripheralx();
			peripheralx.setMemo((String)map.get("MEMO"));
			peripheralx.setRunStatusName((String)map.get("NAME"));
			peripheralx.setSsCode((String)map.get("SS_CODE"));
			peripheralx.setSsId((String)map.get("SS_ID"));
			peripheralx.setRunStatus(Integer.parseInt(map.get("RUN_STATUS").toString()));
			perLs.add(peripheralx);
		}
		return perLs;
	}

	
	public BoxInfox loadBoxInfox(String ssId, String boxCode) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.BOX_CODE,B.NAME RUNNAME,A.RUN_STATUS,C.NAME LOADNAME FROM T_BOX_INFO A,T_FLAG_DICTIONARY B,");
		sql.append(" T_FLAG_DICTIONARY C WHERE B.TYPE_ID = '6' AND A.RUN_STATUS = B.CODE AND C.TYPE_ID = '5' ");
		sql.append(" AND A.LOAD_STATUS = C.CODE  AND A.SS_ID = ? AND A.BOX_CODE = ? ");
		
		Object[] values = new Object[]{ssId,boxCode};
		Map map = null;
		try {
			map = jdbcTemplate.queryForMap(sql.toString(),values);
		} catch (DataAccessException e) {
			return null;
		}
		BoxInfox boxInfox = new BoxInfox();
		boxInfox.setBoxCode((String)map.get("BOX_CODE"));
		boxInfox.setRunStatusName((String)map.get("RUNNAME"));
		//boxInfox.setRunStatusName((String)map.get("RUNNAME"));
		boxInfox.setLoadStatusName((String)map.get("LOADNAME"));
		return boxInfox;
	}

	public List<BoxInfox> loadBoxInfoxList(String ssId) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.BOX_CODE,B.NAME RUNNAME,A.RUN_STATUS,C.NAME LOADNAME,A.BOX_ID FROM T_BOX_INFO A,T_FLAG_DICTIONARY B,");
		sql.append(" T_FLAG_DICTIONARY C WHERE B.TYPE_ID = '6' AND A.RUN_STATUS = B.CODE AND C.TYPE_ID = '5' ");
		sql.append(" AND A.LOAD_STATUS = C.CODE  AND A.SS_ID = ? ");
		
		List<BoxInfox> perLs = new ArrayList<BoxInfox>();
		List<BoxInfox> mapList = jdbcTemplate.queryForList(sql.toString(),new Object[]{ssId});
		Iterator it = mapList.iterator();
		while(it.hasNext()){
			Map map = (Map)it.next();
			BoxInfox boxInfox = new BoxInfox();
			boxInfox.setBoxCode((String)map.get("BOX_CODE"));
			boxInfox.setRunStatusName((String)map.get("RUNNAME"));
			//boxInfox.setRunStatusName((String)map.get("RUNNAME"));
			boxInfox.setLoadStatusName((String)map.get("LOADNAME"));
			boxInfox.setBoxId((String)map.get("BOX_ID"));
			perLs.add(boxInfox);			
		}
		return perLs;
	}
	
	public Map<String, BoxInfo> loadBoxInfo(String ssId) throws Exception{
		String sql = "SELECT B.SS_ID,B.BOX_CODE,B.RUN_STATUS,B.LOAD_STATUS,B.CABINET_ID FROM T_BOX_INFO B WHERE B.SS_ID = ? ";
		Map<String, BoxInfo> maps = new HashMap<String, BoxInfo>();
		
		List<?> mapList = jdbcTemplate.queryForList(sql.toString(),new Object[]{ssId});
		Iterator<?> it = mapList.iterator();
		while(it.hasNext()){
			Map<?,?> map = (Map<?,?>)it.next();
			BoxInfo boxInfo = new BoxInfo();
			boxInfo.setBoxCode((String)map.get("BOX_CODE"));
			boxInfo.setSsId((String)map.get("SS_ID"));
			boxInfo.setRunStatus(Integer.parseInt(map.get("RUN_STATUS").toString()));
			boxInfo.setLoadStatus(Integer.parseInt(map.get("LOAD_STATUS").toString()));
			//boxInfo.setCabinetId((String)map.get("LOAD_STATUS"));
			maps.put(boxInfo.getBoxCode(), boxInfo);
		}
		return maps;
	}
	

	public List<Storagestationx> loadStoragestationByGroupId(String groupId)throws Exception {
		String sql = "SELECT A.SS_ID,A.SS_NAME FROM T_STORAGESTATION A WHERE A.GROUP_ID = ? ";
		List<Storagestationx> lists = new ArrayList<Storagestationx>();
		List<Storagestationx> mapList = jdbcTemplate.queryForList(sql,new String[]{groupId});
		Iterator it = mapList.iterator();
		while(it.hasNext()){
			Map map = (Map)it.next();
			Storagestationx stor = new Storagestationx();
			stor.setSsId((String)map.get("SS_ID"));
			stor.setSsName((String)map.get("SS_NAME"));
			lists.add(stor);
		}
		return lists;
	}

	
	public List<String> loadCourierListBySSId(String ssId, int type) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT C.GROUP_NAME FROM ");
		sql.append(" T_STORAGESTATION A,T_STORAGESTATION_DELIVERY_G B,T_COURIER_GROUP C ");
		sql.append(" WHERE A.SS_ID = B.SS_ID AND C.GROUP_ID = B.GROUP_ID AND A.SS_ID = ? AND B.EXE_PERMISSION = ? ");
		Object[] values = new Object[]{ssId,type};
		List<String> mapList = jdbcTemplate.queryForList(sql.toString(),values);
		Iterator iter = mapList.iterator();
		List<String> list = new ArrayList<String>();
		while(iter.hasNext()){
			Map map = (Map) iter.next();
			String groupName = (String)map.get("GROUP_NAME");
			list.add(groupName);
		}
		return list;
	}
	
	public int getItemsByPid(String pid) throws Exception{
		String sql = "SELECT COUNT(*) CNT FROM T_STORAGESTATION WHERE POI_ID = ? ";
		int items = jdbcTemplate.queryForInt(sql,new String[]{pid});
		return items;
	}


	public Storagestationx getStoragestationxByPid(String pid) throws Exception {
		 String sql ="SELECT * FROM T_STORAGESTATION WHERE POI_ID = ? ";
		 Object[] values = new Object[]{pid};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 
		Storagestationx storagestationx = new Storagestationx();		
		storagestationx.setSsId((String)map.get("SS_ID"));
		storagestationx.setSsCode((String)map.get("SS_CODE"));
		storagestationx.setPoiId((String)map.get("POI_ID"));
		return storagestationx;
	}

	public Storagestationx getStoragestationxBySSCode(String ssCode)
			throws Exception {
		String sql ="SELECT * FROM T_STORAGESTATION WHERE SS_CODE = ? ";
		 Object[] values = new Object[]{ssCode};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 
		Storagestationx storagestationx = new Storagestationx();		
		storagestationx.setSsId((String)map.get("SS_ID"));
		storagestationx.setSsCode((String)map.get("SS_CODE"));
		storagestationx.setPoiId((String)map.get("POI_ID"));
		return storagestationx;
	}

	@Override
	public void updateStoragestation(Storagestation stor) throws Exception {
		 StringBuffer sql = new StringBuffer();
		 sql.append(" UPDATE T_STORAGESTATION A "); //A.SS_INDEX = ?,
		 sql.append(" SET A.SS_TYPE=?,A.MODEL_ID=?,A.ASSET_SN = ?,A.RUN_STATUS = ?,A.DATA_CARD=?, ");
		 sql.append(" A.IP_ADD = ?,A.PORT=?,A.LINK_TYPE=?,A.LONGITUDE=?,A.LATITUDE=?,A.AVAILABLE_BOX_NUM=?, ");
		 sql.append("A.INSTALL_DATE = ?,A.CONTROL_CABINET_LOCATION = ? WHERE A.SS_CODE = ? ");
		 
		 Object[] values = new Object[] {stor.getSsType(),stor.getModelId(),stor.getAssetSn(),stor.getRunStatus(),
				 						stor.getDataCard(),stor.getIpAdd(),stor.getPort(),stor.getLinkType(),stor.getLongitude(),
				 						stor.getLatitude(),stor.getAvailableBoxNum(),stor.getInstallDate(),stor.getControlCabinetLocation(),
				 						stor.getSsCode()};
		 jdbcTemplate.update(sql.toString(), values);
	}

	@Override
	public void updateStatus(int status,String ssCode) throws Exception {
		String sql = " UPDATE T_STORAGESTATION T SET T.RUN_STATUS = ? WHERE T.SS_CODE = ? ";
		jdbcTemplate.update(sql,new String[]{String.valueOf(status),ssCode});
	}
	
	public String getSSIdBySSCode(String ssCode) throws Exception
	{
		String ssId = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SS.SS_ID FROM T_STORAGESTATION SS WHERE SS.SS_CODE = ?");
		
		List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{ssCode});
		
		if(null != list && list.size() != 0)
		{
			ssId = (String) ((Map)list.get(0)).get("SS_ID");
		}
		return ssId;
	}

	@Override
	public List<BoxStatusWrapper> getBoxStatusListLimit(GetBoxStatusListParam bslp, int startInd, int pageSize) throws Exception
	{
		List<BoxStatusWrapper> bsws = null;
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SS.SS_ID, SS.SS_CODE, BI.BOX_ID, BI.BOX_CODE, CONCAT(C.CABINET_INDEX,'-',BI.BOX_INDEX) BOX_INDEX, BI.SIZE, BI.RUN_STATUS");
		sql.append(" FROM T_STORAGESTATION SS, T_CABINET C, T_BOX_INFO BI, T_STORAGESTATION_GROUP SG");
		sql.append(" WHERE SS.SS_ID = C.SS_ID AND C.CABINET_ID = BI.CABINET_ID AND SS.GROUP_ID = SG.GROUP_ID");
		
		if(null != bslp)
		{
			if(StringUtil.isNotBlank(bslp.getSsCode()))
			{
				sql.append(" AND SS.SS_CODE LIKE ?");
				param.add("%"+bslp.getSsCode()+"%");
			}
			if(StringUtil.isNotBlank(bslp.getGroupId()))
			{
				sql.append(" AND SG.GROUP_ID = ?");
				param.add(bslp.getGroupId());
			}
			if(bslp.getBoxStatus() != 0)
			{
				sql.append(" AND BI.RUN_STATUS = ?");
				param.add(bslp.getBoxStatus());
			}
			if(bslp.getBoxType() != 0)
			{
				sql.append(" AND BI.SIZE = ?");
				param.add(bslp.getBoxType());
			}
			// 关于开始和结束时间，目前搁置
			if(StringUtil.isNotBlank(bslp.getStartDate()))
			{
			}
			if(StringUtil.isNotBlank(bslp.getEndDate()))
			{
			}
			if(StringUtil.isNotBlank(bslp.getStartTime()))
			{
			}
			if(StringUtil.isNotBlank(bslp.getEndTime()))
			{
			}
		}
		
		sql.append(" ORDER BY SS.SS_CODE, C.CABINET_INDEX, BI.BOX_INDEX");
		if(pageSize != 0)
		{
			sql.append(" LIMIT ?,?");
			param.add(startInd);
			param.add(pageSize);
		}
		
		List list = jdbcTemplate.queryForList(sql.toString(), param.toArray());
		if(null != list && list.size() != 0)
		{
			bsws = new ArrayList<BoxStatusWrapper>();
			
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				Map map = (Map) it.next();
				
				BoxStatusWrapper bsw = new BoxStatusWrapper();
				bsw.setSsId(StringUtil.formatStringTrim(map.get("SS_ID")));
				bsw.setSsCode(StringUtil.formatStringTrim(map.get("SS_CODE")));
				bsw.setBoxId(StringUtil.formatStringTrim(map.get("BOX_ID")));
				bsw.setBoxCode(StringUtil.formatStringTrim(map.get("BOX_CODE")));
				bsw.setBoxIndex(StringUtil.formatStringTrim(map.get("BOX_INDEX")));
				bsw.setBoxSize(StringUtil.formatStringToInteger(map.get("SIZE"), 0));
				bsw.setBoxStatus(StringUtil.formatStringToInteger(map.get("RUN_STATUS"), 0));
				
				bsws.add(bsw);
			}
		}
		
		return bsws;
	}

	@Override
	public int getBoxStatusListSize(GetBoxStatusListParam bslp) throws Exception
	{
		int count = 0;

		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(1) CNT FROM T_STORAGESTATION SS, T_CABINET C, T_BOX_INFO BI, T_STORAGESTATION_GROUP SG");
		sql.append(" WHERE SS.SS_ID = C.SS_ID AND C.CABINET_ID = BI.CABINET_ID AND SS.GROUP_ID = SG.GROUP_ID");
		
		if(null != bslp)
		{
			if(StringUtil.isNotBlank(bslp.getSsCode()))
			{
				sql.append(" AND SS.SS_CODE LIKE ?");
				param.add("%"+bslp.getSsCode()+"%");
			}
			if(StringUtil.isNotBlank(bslp.getGroupId()))
			{
				sql.append(" AND SG.GROUP_ID = ?");
				param.add(bslp.getGroupId());
			}
			if(bslp.getBoxStatus() != 0)
			{
				sql.append(" AND BI.RUN_STATUS = ?");
				param.add(bslp.getBoxStatus());
			}
			if(bslp.getBoxType() != 0)
			{
				sql.append(" AND BI.SIZE = ?");
				param.add(bslp.getBoxType());
			}
			// 关于开始和结束时间，目前搁置
			if(StringUtil.isNotBlank(bslp.getStartDate()))
			{
			}
			if(StringUtil.isNotBlank(bslp.getEndDate()))
			{
			}
			if(StringUtil.isNotBlank(bslp.getStartTime()))
			{
			}
			if(StringUtil.isNotBlank(bslp.getEndTime()))
			{
			}
		}
		
		List list = jdbcTemplate.queryForList(sql.toString(), param.toArray());
		
		if(null != list && list.size() != 0)
		{
			count = StringUtil.formatStringToInteger(((Map)list.get(0)).get("CNT"), 0);
		}
		
		return count;
	}

	@Override
	public String getAddressByssId(String ssId) throws Exception {
		String sql="SELECT SS_ADDRESS FROM T_STORAGESTATION WHERE SS_ID=?";
		System.out.println(ssId);
		Object[] values = new Object[] { ssId };
		List list=jdbcTemplate.queryForList(sql, values);
		String address = StringUtil.formatStringTrimToNull(((Map) list.get(0)).get("SS_ADDRESS"));
		return address;
	}
}
