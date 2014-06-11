package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.StoragestationPeripheralDaoImpl;
import cn.com.xb.daox.IStoragestationPeripheralDaox;
import cn.com.xb.domain.base.StoragestationPeripheral;
import cn.com.xb.inter.domain.IDeviceStatus;
import cn.com.xb.util.StringUtil;

public class StoragestationPeripheralDaoxImpl extends StoragestationPeripheralDaoImpl implements IStoragestationPeripheralDaox {

	private JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void deleteBySSId(String ssId) throws Exception {
		String sql ="DELETE FROM T_STORAGESTATION_PERIPHERAL WHERE SS_ID= ? ";
		 Object[] values = new Object[] {ssId};
		 jdbcTemplate.update(sql, values);
	}
	
	
	public List<StoragestationPeripheral> getSsPeripheralListBySSId(String ssId) throws Exception
	{
		List<StoragestationPeripheral> ssps = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SSP.SS_ID, SSP.PERIPHERAL_ID, SSP.RUN_STATUS FROM T_STORAGESTATION_PERIPHERAL SSP WHERE SSP.SS_ID = ?");
		
		List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{ssId});
		if(null != list && list.size() != 0)
		{
			ssps = new ArrayList<StoragestationPeripheral>();
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				Map map = (Map) it.next();
				
				StoragestationPeripheral ssp = new StoragestationPeripheral();
				ssp.setPeripheralId(StringUtil.formatStringTrim(map.get("PERIPHERAL_ID")));
				ssp.setSsId(StringUtil.formatStringTrim(map.get("SS_ID")));
				ssp.setRunStatus(StringUtil.formatStringToInteger(map.get("RUN_STATUS"), 0));
				
				ssps.add(ssp);
			}
		}
		
		return ssps;
	}

	@Override
	public void updatePeripheral(IDeviceStatus perDeviceStatus,String ssId)	throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE T_STORAGESTATION_PERIPHERAL A SET A.RUN_STATUS = ? WHERE A.PERIPHERAL_ID = ( ");
		sql.append(" SELECT B.PERIPHERAL_ID FROM T_PERIPHERAL B WHERE B.PERIPHERAL_CODE = ? AND A.SS_ID= ? )");
		Object[] values = new Object[]{perDeviceStatus.getDeviceStatus(),perDeviceStatus.getDeviceCode(),ssId};
		jdbcTemplate.update(sql.toString(), values);
	}
}