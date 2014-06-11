package cn.com.xb.daox.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.ModuleDaoImpl;
import cn.com.xb.daox.IModuleDaox;
import cn.com.xb.domain.base.Module;
import cn.com.xb.domain.base.RoleModuleObject;
import cn.com.xb.util.Global;
import cn.com.xb.util.StringUtil;

public class ModuleDaoxImpl extends ModuleDaoImpl implements IModuleDaox {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Module> loadModuleLimit(Module module, int start, int end) throws Exception {
		StringBuilder sql = new StringBuilder("SELECT * FROM T_MODULE WHERE 1=1");
		List<Object> params = new ArrayList<Object>();
		if(!"".equals(module.getModuleName())){
			sql.append(" AND MODULE_NAME LIKE '%").append(module.getModuleName()).append("%'"); 
			//params.add(module.getModuleName());
		}
		if(0!=module.getModuleType()){
			sql.append(" AND MODULE_TYPE = ? ");
			params.add(module.getModuleType());
		}		
		sql.append(" LIMIT ?,?");
		params.add(start);
		params.add(end);

		List<Module> list = new ArrayList<Module>();
		List<Module> mapList = jdbcTemplate.queryForList(sql.toString(),params.toArray());
		Iterator it = mapList.iterator();
		while (it.hasNext()) {
			Map map = (Map) it.next();
			Module _module = fetch(map);
			list.add(_module);
		}
		return list;
	}

	public int loadItems(Module module) throws Exception {
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) CNT FROM T_MODULE WHERE 1=1");
		
		List<Object> params = new ArrayList<Object>();
		if(!"".equals(module.getModuleName())){
			sql.append(" AND MODULE_NAME LIKE '%").append(module.getModuleName()).append("%'"); 
			//params.add(module.getModuleName());
		}
		if(0!=module.getModuleType()){
			sql.append(" AND MODULE_TYPE = ? ");
			params.add(module.getModuleType());
		}	
		int items = jdbcTemplate.queryForInt(sql.toString(),params.toArray());
		return items;
	}

	public List<Module> loadUserModule(String roleId) throws Exception {
		StringBuilder sql =  new StringBuilder();
		sql.append("SELECT DISTINCT A.MODULE_ID,A.* FROM T_MODULE A,T_ROLE_MODULE B WHERE A.MODULE_ID = B.MODULE_ID AND A.MODULE_LEVEL >=2 AND A.STATUS = 1 AND B.ROLE_ID IN ( ")
		.append(roleId).append(") ORDER BY A.MODULE_LEVEL,A.SHOW_SEQ ASC");
		
		List<Module> list = new ArrayList<Module>();
		List<Module> mapList = jdbcTemplate.queryForList(sql.toString());
		Iterator it = mapList.iterator();
		while (it.hasNext()) {
			Map map = (Map) it.next();
			Module _module = fetch(map);
			list.add(_module);
		}
		return list;
	}

	@Override
	public List<RoleModuleObject> getRoleModuleObjectList(String roleId, String moduleId) throws Exception
	{
		List<RoleModuleObject> rmos = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT TEMP1.*,RM1.ROLE_ID FROM");
		sql.append(" (SELECT M.MODULE_ID, M.MODULE_CODE, M.PARENT_M_ID, M.MODULE_NAME, M.MODULE_LINK, M.MODULE_DESC, M.MODULE_LEVEL, M.SHOW_SEQ, M.MODULE_TYPE, M.CREATE_TIME, M.CREATOR, M.ENABLE_TIME, M.STATUS, MAX(M2.MODULE_ID) SUB_M_ID");
		sql.append(" FROM T_MODULE M LEFT JOIN T_MODULE M2 ON M.MODULE_ID = M2.PARENT_M_ID WHERE M.PARENT_M_ID = ?");
		sql.append(" AND M.MODULE_ID NOT IN (SELECT CASE TR.ROLE_TYPE WHEN ? THEN ? WHEN ? THEN ? END FROM T_ROLE TR WHERE TR.ROLE_ID = ?)");
		sql.append(" GROUP BY M.MODULE_ID) TEMP1");
		sql.append(" LEFT JOIN (SELECT RM.MODULE_ID, RM.ROLE_ID FROM T_ROLE_MODULE RM WHERE RM.ROLE_ID = ?) RM1 ON TEMP1.MODULE_ID = RM1.MODULE_ID");
		sql.append(" ORDER BY TEMP1.MODULE_LEVEL, TEMP1.PARENT_M_ID, TEMP1.SHOW_SEQ");
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{moduleId, Global.ROLE_TYPE_PORTAL, Global.MODULE_ID_PLAT, Global.ROLE_TYPE_PLAT, Global.MODULE_ID_PORTAL, roleId, roleId});
			
			if(null != list && list.size() != 0)
			{
				rmos = new ArrayList<RoleModuleObject>();
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					Map map = (Map) it.next();
					
					RoleModuleObject rmo = new RoleModuleObject();
					rmo.setModuleId(StringUtil.formatStringTrimToNull(map.get("MODULE_ID")));
					rmo.setModuleCode(StringUtil.formatStringTrimToNull(map.get("MODULE_CODE")));
					rmo.setParentMId(StringUtil.formatStringTrimToNull(map.get("PARENT_M_ID")));
					rmo.setModuleName(StringUtil.formatStringTrimToNull(map.get("MODULE_NAME")));
					rmo.setModuleLink(StringUtil.formatStringTrimToNull(map.get("MODULE_LINK")));
					rmo.setModuleDesc(StringUtil.formatStringTrimToNull(map.get("MODULE_DESC")));
					rmo.setModuleLevel(StringUtil.formatStringToInteger(map.get("MODULE_LEVEL"), 99999));
					rmo.setShowSeq(StringUtil.formatStringToInteger(map.get("SHOW_SEQ"), 99999));
					rmo.setModuleType(StringUtil.formatStringToInteger(map.get("MODULE_TYPE"), 0));
					rmo.setCreateTime((Timestamp) map.get("CREATE_TIME"));
					rmo.setCreator(StringUtil.formatStringTrimToNull(map.get("CREATOR")));
					rmo.setEnableTime((Timestamp) map.get("ENABLE_TIME"));
					rmo.setStatus(StringUtil.formatStringToInteger(map.get("STATUS"), 2));
					rmo.setHasSubModule(StringUtil.formatStringTrimToNull(map.get("SUB_M_ID")) != null ? 1 : 0);
					rmo.setIsAssignRole(StringUtil.formatStringTrimToNull(map.get("ROLE_ID")) != null ? 1 : 0);
					
					rmos.add(rmo);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return rmos;
	}

	public int loadItemsByModuleCode(String moduleCode) throws Exception {
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) CNT FROM T_MODULE T WHERE T.MODULE_CODE = ? ");
		Object[] values = new Object[]{moduleCode};
		return jdbcTemplate.queryForInt(sql.toString(),values);
	}
}
