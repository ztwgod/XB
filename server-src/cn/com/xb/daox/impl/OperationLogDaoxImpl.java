package cn.com.xb.daox.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.daox.IOperationLogDaox;
import cn.com.xb.domain.displayWrapper.OperationLogWrapper;
import cn.com.xb.domain.parameterWrapper.GetOperationLogListParam;
import cn.com.xb.util.Global;
import cn.com.xb.util.StringUtil;


public class OperationLogDaoxImpl implements IOperationLogDaox
{
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<OperationLogWrapper> getOperationLogList(GetOperationLogListParam golp) throws Exception
	{
		List<OperationLogWrapper> olws = null;
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OL.LOG_ID, OL.SYS_PLAT_TYPE, FD1.NAME SYS_PLAT_TYPE_SHOW, OL.OPERATION_USER_ID, U.USER_NAME OPERATION_USER_NAME, OL.OPERATION_TYPE, FD2.NAME OPERATION_TYPE_SHOW, OL.SS_ID, SS.SS_CODE, SS.SS_ADDRESS, OL.BOX_ID, OL.OPERATION_CONTENT, OL.OPERATION_RESULT, OL.OPERATION_TIME");
		sql.append(" FROM T_OPERATION_LOG OL LEFT JOIN T_USER U ON (U.USER_ID = OL.OPERATION_USER_ID) LEFT JOIN T_STORAGESTATION SS ON (OL.SS_ID = SS.SS_ID), T_FLAG_DICTIONARY FD1, T_FLAG_DICTIONARY FD2");
		sql.append(" WHERE OL.SYS_PLAT_TYPE = FD1.CODE AND OL.OPERATION_TYPE = FD2.CODE AND FD1.TYPE_ID = '"+Global.DICTIONARY_TYPE_SYS_PLAT_TYPE+"' AND FD2.TYPE_ID = '"+Global.DICTIONARY_TYPE_OPERATION_TYPE+"'");
		
		if(null != golp)
		{
			if(StringUtil.isNotBlank(golp.getOperationUserName()))
			{
				sql.append(" AND U.USER_NAME LIKE ?");
				param.add("%"+golp.getOperationUserName()+"%");
			}
			if(StringUtil.isNotBlank(golp.getSsCode()))
			{
				sql.append(" AND SS.SS_CODE LIKE ?");
				param.add("%"+golp.getSsCode()+"%");
			}
			if(StringUtil.isNotBlank(golp.getStartDate()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%Y-%m-%d') >= ?");
				param.add(golp.getStartDate());
			}
			if(StringUtil.isNotBlank(golp.getEndDate()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%Y-%m-%d') <= ?");
				param.add(golp.getEndDate());
			}
			if(StringUtil.isNotBlank(golp.getStartTime()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%H:%i:%S') >= ?");
				param.add(golp.getStartTime());
			}
			if(StringUtil.isNotBlank(golp.getEndTime()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%H:%i:%S') <= ?");
				param.add(golp.getEndTime());
			}
		}
		sql.append(" ORDER BY OL.OPERATION_TIME DESC, OL.SYS_PLAT_TYPE, OL.SS_ID, OL.OPERATION_TYPE");
		
		List list = jdbcTemplate.queryForList(sql.toString(), param.toArray());
		if(null != list && list.size() != 0)
		{
			olws = new ArrayList<OperationLogWrapper>();
			
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				Map map = (Map) it.next();
				OperationLogWrapper olw = new OperationLogWrapper();
				
				olw.setLogId(StringUtil.formatStringTrim(map.get("LOG_ID")));
				olw.setSysPlatType(StringUtil.formatStringToInteger(map.get("SYS_PLAT_TYPE"), 0));
				olw.setSysPlatTypeShow(StringUtil.formatStringTrim(map.get("SYS_PLAT_TYPE_SHOW")));
				olw.setOperationUserId(StringUtil.formatStringTrim(map.get("OPERATION_USER_ID")));
				olw.setOperationUserName(StringUtil.formatStringTrim(map.get("OPERATION_USER_NAME")));
				olw.setOperationType(StringUtil.formatStringToInteger(map.get("OPERATION_TYPE"), 0));
				olw.setOperationTypeShow(StringUtil.formatStringTrim(map.get("OPERATION_TYPE_SHOW")));
				olw.setSsId(StringUtil.formatStringTrim(map.get("SS_ID")));
				olw.setSsCode(StringUtil.formatStringTrim(map.get("SS_CODE")));
				olw.setSsAddress(StringUtil.formatStringTrim(map.get("SS_ADDRESS")));
				olw.setBoxId(StringUtil.formatStringTrim(map.get("BOX_ID")));
				olw.setOperationContent(StringUtil.formatStringTrim(map.get("OPERATION_CONTENT")));
				olw.setOperationResult(StringUtil.formatStringTrim(map.get("OPERATION_RESULT")));
				olw.setOperationTime((Timestamp) map.get("OPERATION_TIME"));
				
				olws.add(olw);
			}
		}
		
		return olws;
	}
	
	
	
	@Override
	public List<OperationLogWrapper> getOperationLogListLimit(GetOperationLogListParam golp, int startInd, int pageSize) throws Exception
	{
		List<OperationLogWrapper> olws = null;
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OL.LOG_ID, OL.SYS_PLAT_TYPE, FD1.NAME SYS_PLAT_TYPE_SHOW, OL.OPERATION_USER_ID, U.USER_NAME OPERATION_USER_NAME, OL.OPERATION_TYPE, FD2.NAME OPERATION_TYPE_SHOW, OL.SS_ID, SS.SS_CODE, SS.SS_ADDRESS, OL.BOX_ID, OL.OPERATION_CONTENT, OL.OPERATION_RESULT, OL.OPERATION_TIME");
		sql.append(" FROM T_OPERATION_LOG OL LEFT JOIN T_USER U ON (U.USER_ID = OL.OPERATION_USER_ID) LEFT JOIN T_STORAGESTATION SS ON (OL.SS_ID = SS.SS_ID), T_FLAG_DICTIONARY FD1, T_FLAG_DICTIONARY FD2");
		sql.append(" WHERE OL.SYS_PLAT_TYPE = FD1.CODE AND OL.OPERATION_TYPE = FD2.CODE AND FD1.TYPE_ID = '"+Global.DICTIONARY_TYPE_SYS_PLAT_TYPE+"' AND FD2.TYPE_ID = '"+Global.DICTIONARY_TYPE_OPERATION_TYPE+"'");
		
		if(null != golp)
		{
			if(StringUtil.isNotBlank(golp.getOperationUserName()))
			{
				sql.append(" AND U.USER_NAME LIKE ?");
				param.add("%"+golp.getOperationUserName()+"%");
			}
			if(StringUtil.isNotBlank(golp.getSsCode()))
			{
				sql.append(" AND SS.SS_CODE LIKE ?");
				param.add("%"+golp.getSsCode()+"%");
			}
			if(StringUtil.isNotBlank(golp.getStartDate()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%Y-%m-%d') >= ?");
				param.add(golp.getStartDate());
			}
			if(StringUtil.isNotBlank(golp.getEndDate()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%Y-%m-%d') <= ?");
				param.add(golp.getEndDate());
			}
			if(StringUtil.isNotBlank(golp.getStartTime()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%H:%i:%S') >= ?");
				param.add(golp.getStartTime());
			}
			if(StringUtil.isNotBlank(golp.getEndTime()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%H:%i:%S') <= ?");
				param.add(golp.getEndTime());
			}
		}
		sql.append(" ORDER BY OL.OPERATION_TIME DESC, OL.SYS_PLAT_TYPE, OL.SS_ID, OL.OPERATION_TYPE");
		sql.append(" LIMIT ?,?");
		param.add(startInd);
		param.add(pageSize);
		
		
		List list = jdbcTemplate.queryForList(sql.toString(), param.toArray());
		if(null != list && list.size() != 0)
		{
			olws = new ArrayList<OperationLogWrapper>();
			
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				Map map = (Map) it.next();
				OperationLogWrapper olw = new OperationLogWrapper();
				
				olw.setLogId(StringUtil.formatStringTrim(map.get("LOG_ID")));
				olw.setSysPlatType(StringUtil.formatStringToInteger(map.get("SYS_PLAT_TYPE"), 0));
				olw.setSysPlatTypeShow(StringUtil.formatStringTrim(map.get("SYS_PLAT_TYPE_SHOW")));
				olw.setOperationUserId(StringUtil.formatStringTrim(map.get("OPERATION_USER_ID")));
				olw.setOperationUserName(StringUtil.formatStringTrim(map.get("OPERATION_USER_NAME")));
				olw.setOperationType(StringUtil.formatStringToInteger(map.get("OPERATION_TYPE"), 0));
				olw.setOperationTypeShow(StringUtil.formatStringTrim(map.get("OPERATION_TYPE_SHOW")));
				olw.setSsId(StringUtil.formatStringTrim(map.get("SS_ID")));
				olw.setSsCode(StringUtil.formatStringTrim(map.get("SS_CODE")));
				olw.setSsAddress(StringUtil.formatStringTrim(map.get("SS_ADDRESS")));
				olw.setBoxId(StringUtil.formatStringTrim(map.get("BOX_ID")));
				olw.setOperationContent(StringUtil.formatStringTrim(map.get("OPERATION_CONTENT")));
				olw.setOperationResult(StringUtil.formatStringTrim(map.get("OPERATION_RESULT")));
				olw.setOperationTime((Timestamp) map.get("OPERATION_TIME"));
				
				olws.add(olw);
			}
		}
		
		return olws;
	}

	@Override
	public int getOperationLogListSize(GetOperationLogListParam golp) throws Exception
	{
		int count = 0;
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(1) CNT FROM T_OPERATION_LOG OL LEFT JOIN T_USER U ON (U.USER_ID = OL.OPERATION_USER_ID) LEFT JOIN T_STORAGESTATION SS ON (OL.SS_ID = SS.SS_ID)");
		sql.append(" WHERE 1 = 1");
		if(null != golp)
		{
			if(StringUtil.isNotBlank(golp.getOperationUserName()))
			{
				sql.append(" AND U.USER_NAME LIKE ?");
				param.add("%"+golp.getOperationUserName()+"%");
			}
			if(StringUtil.isNotBlank(golp.getSsCode()))
			{
				sql.append(" AND SS.SS_CODE LIKE ?");
				param.add("%"+golp.getSsCode()+"%");
			}
			if(StringUtil.isNotBlank(golp.getStartDate()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%Y-%m-%d') >= ?");
				param.add(golp.getStartDate());
			}
			if(StringUtil.isNotBlank(golp.getEndDate()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%Y-%m-%d') <= ?");
				param.add(golp.getEndDate());
			}
			if(StringUtil.isNotBlank(golp.getStartTime()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%H:%i:%S') >= ?");
				param.add(golp.getStartTime());
			}
			if(StringUtil.isNotBlank(golp.getEndTime()))
			{
				sql.append(" AND DATE_FORMAT(OL.OPERATION_TIME, '%H:%i:%S') <= ?");
				param.add(golp.getEndTime());
			}
		}
		
		count = jdbcTemplate.queryForInt(sql.toString(), param.toArray());
		
		return count;
	}
	
	public OperationLogWrapper getOperationLogDetailByLogId(String logId) throws Exception
	{
		OperationLogWrapper olw = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OL.LOG_ID, OL.SYS_PLAT_TYPE, PT.NAME PT_SHOW, OL.OPERATION_USER_ID, U.USER_NAME OPE_NAME, OL.OPERATION_TYPE, OT.NAME OT_SHOW, OL.SS_ID, SS.SS_CODE, SS.SS_ADDRESS, OL.OPERATION_CONTENT, OL.OPERATION_RESULT, OL.OPERATION_TIME");
		sql.append(" FROM T_OPERATION_LOG OL LEFT JOIN T_USER U ON (OL.OPERATION_USER_ID = U.USER_ID) LEFT JOIN T_STORAGESTATION SS ON (OL.SS_ID = SS.SS_ID), T_FLAG_DICTIONARY PT, T_FLAG_DICTIONARY OT");
		sql.append(" WHERE OL.SYS_PLAT_TYPE = PT.CODE AND OL.OPERATION_TYPE = OT.CODE AND PT.TYPE_ID = '38' AND OT.TYPE_ID = '39'");
		sql.append(" AND OL.LOG_ID = ?");
		
		List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{logId});
		
		if(null != list && list.size() != 0)
		{
			olw = new OperationLogWrapper();
			Map map = (Map) list.get(0);

			olw.setLogId(StringUtil.formatStringTrim(map.get("LOG_ID")));
			olw.setSysPlatType(StringUtil.formatStringToInteger(map.get("SYS_PLAT_TYPE"), 0));
			olw.setSysPlatTypeShow(StringUtil.formatStringTrim(map.get("PT_SHOW")));
			olw.setOperationUserId(StringUtil.formatStringTrim(map.get("OPERATION_USER_ID")));
			olw.setOperationUserName(StringUtil.formatStringTrim(map.get("OPE_NAME")));
			olw.setOperationType(StringUtil.formatStringToInteger(map.get("OPERATION_TYPE"), 0));
			olw.setOperationTypeShow(StringUtil.formatStringTrim(map.get("OT_SHOW")));
			olw.setSsId(StringUtil.formatStringTrim(map.get("SS_ID")));
			olw.setSsCode(StringUtil.formatStringTrim(map.get("SS_CODE")));
			olw.setSsAddress(StringUtil.formatStringTrim(map.get("SS_ADDRESS")));
			olw.setBoxId(StringUtil.formatStringTrim(map.get("BOX_ID")));
			olw.setOperationContent(StringUtil.formatStringTrim(map.get("OPERATION_CONTENT")));
			olw.setOperationResult(StringUtil.formatStringTrim(map.get("OPERATION_RESULT")));
			olw.setOperationTime((Timestamp) map.get("OPERATION_TIME"));
		}
		
		return olw;
	}
}