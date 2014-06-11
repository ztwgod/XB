package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.SsBoxnumLogDaoImpl;
import cn.com.xb.daox.ISsBoxnumLogDaox;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.SsBoxnumLogx;
import cn.com.xb.util.DateTools;
import cn.com.xb.util.StringUtil;

public class SsBoxnumLogDaoxImpl extends SsBoxnumLogDaoImpl implements ISsBoxnumLogDaox {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<SsBoxnumLogx> getSSBoxNumLogLists(SsBoxnumLogx params, Page page)
			throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.EMPTY_NUM,A.FAULT_NUM,A.OCCUPATION_NUM,A.RECORD_ID,A.RECORD_TIME,A.SS_ID,A.TOTAL_NUM,B.SS_CODE ");
		sql.append(" FROM T_SS_BOXNUM_LOG A,T_STORAGESTATION B ");
		sql.append(" WHERE A.SS_ID = B.SS_ID ");
		
		List<Object> values = new ArrayList<Object>();
		if(!"".equals(params.getsDate())){
			sql.append("  AND DATE_FORMAT(A.RECORD_TIME, '%Y-%m-%d') >= ? ");
			values.add(params.getsDate());
		}
		if(!"".equals(params.geteDate())){
			sql.append("AND DATE_FORMAT(A.RECORD_TIME, '%Y-%m-%d') <= ? ");
			values.add(params.geteDate());
		}
		if(!"".equals(params.getsTime())){
			sql.append(" AND DATE_FORMAT(A.RECORD_TIME, '%H:%i:%S') >= ? ");
			values.add(params.getsTime());
		}
		if(!"".equals(params.geteTime())){
			sql.append(" AND DATE_FORMAT(A.RECORD_TIME, '%H:%i:%S') <= ? ");
			values.add(params.geteTime());
		}
		if(!"".equals(params.getGroupId())){
			sql.append(" AND B.GROUP_ID = ? ");
			values.add(params.getGroupId());
		}
		if(!"".equals(params.getSsCode())){
			sql.append(" AND B.SS_CODE LIKE ? ");
			values.add("%"+params.getSsCode()+"%");
		}
		sql.append(" ORDER BY A.RECORD_TIME DESC ");
		
		if(!params.isExcel()){
			sql.append(" LIMIT ?,? ");
			values.add(page.getStartItems());
			values.add(page.getPageSize());
		}
		
		
		List<SsBoxnumLogx> lists = new ArrayList<SsBoxnumLogx>();
		List<SsBoxnumLogx> queryList = jdbcTemplate.queryForList(sql.toString(),values.toArray());
		Iterator it = queryList.iterator();	 
		while(it.hasNext()){
			Map map = (Map) it.next();
			SsBoxnumLogx logx = new SsBoxnumLogx();
			logx.setEmptyNum(StringUtil.formatStringToInteger(map.get("EMPTY_NUM"), 0));
			logx.setFaultNum(StringUtil.formatStringToInteger("FAULT_NUM", 0));
			logx.setOccupationNum(StringUtil.formatStringToInteger("OCCUPATION_NUM", 0));
			logx.setRecordId(map.get("RECORD_ID").toString());
			logx.setRecordTime(DateTools.formatStringToTimestamp(map.get("RECORD_TIME").toString(),DateTools.FORMAT_YYYYMMDD_HHMMSS));
			logx.setSsId(map.get("SS_ID").toString());
			logx.setTotalNum(StringUtil.formatStringToInteger(map.get("TOTAL_NUM"), 0));
			logx.setSsCode(map.get("SS_CODE").toString());
			lists.add(logx);
		}
		return lists;
	}

	@Override
	public int getItems(SsBoxnumLogx params) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT COUNT(*) ");
		sql.append(" FROM T_SS_BOXNUM_LOG A,T_STORAGESTATION B ");
		sql.append(" WHERE A.SS_ID = B.SS_ID ");
		
		List<Object> values = new ArrayList<Object>();
		if(!"".equals(params.getsDate())){
			sql.append("  AND DATE_FORMAT(A.RECORD_TIME, '%Y-%m-%d') >= ? ");
			values.add(params.getsDate());
		}
		if(!"".equals(params.geteDate())){
			sql.append("AND DATE_FORMAT(A.RECORD_TIME, '%Y-%m-%d') <= ? ");
			values.add(params.geteDate());
		}
		if(!"".equals(params.getsTime())){
			sql.append(" AND DATE_FORMAT(A.RECORD_TIME, '%H:%i:%S') >= ? ");
			values.add(params.getsTime());
		}
		if(!"".equals(params.geteTime())){
			sql.append(" AND DATE_FORMAT(A.RECORD_TIME, '%H:%i:%S') <= ? ");
			values.add(params.geteTime());
		}
		if(!"".equals(params.getGroupId())){
			sql.append(" AND B.GROUP_ID = ? ");
			values.add(params.getGroupId());
		}
		if(!"".equals(params.getSsCode())){
			sql.append(" AND B.SS_CODE LIKE ? ");
			values.add("%"+params.getSsCode()+"%");
		}
		int items = jdbcTemplate.queryForInt(sql.toString(),values.toArray());
		return items;
	}


}
