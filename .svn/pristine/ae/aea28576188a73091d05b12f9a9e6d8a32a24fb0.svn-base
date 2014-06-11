package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.CabinetDaoImpl;
import cn.com.xb.daox.ICabinetDaox;
import cn.com.xb.domain.base.Cabinet;
import cn.com.xb.inter.domain.IDeviceStatus;

public class CabinetDaoxImpl extends CabinetDaoImpl implements ICabinetDaox {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Cabinet> loadCabinetsBySSId(String ssId) throws Exception {
		String sql = "SELECT * FROM T_CABINET WHERE SS_ID = ? ORDER BY CABINET_INDEX ";
		List<Cabinet> list = new ArrayList<Cabinet>();
		List<Cabinet> mapList = jdbcTemplate.queryForList(sql,new String[] { ssId });
		Iterator it = mapList.iterator();
		while (it.hasNext()) {
			Map map = (Map) it.next();
			Cabinet cabinet = fetch(map);
			list.add(cabinet);
		}
		return list;
	}

	public void deleteBySSId(String ssId) throws Exception {
		String sql = "DELETE FROM T_CABINET WHERE SS_ID = ? ";
		Object[] values = new Object[] { ssId };
		jdbcTemplate.update(sql, values);
	}

	public void update(Cabinet cabinet) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE T_CABINET A  ");
		sql.append("SET A.CABINET_CODE = ?,A.CABINET_INDEX=?,A.CABINET_MODEL = ?,A.ASSET_SN = ?, ");
		sql.append("    A.CABINET_WIDTH = ?,A.CABINET_HEIGHT = ?,A.BOX_NUMBER = ?,A.CABINET_STATUS = ? ");
		sql.append(" WHERE A.CABINET_ID = ? ");
		Object[] values = new Object[] { cabinet.getCabinetCode(),
				cabinet.getCabinetIndex(), cabinet.getCabinetModel(),
				cabinet.getAssetSn(), cabinet.getCabinetWidth(),
				cabinet.getCabinetHeight(), cabinet.getBoxNumber(),
				cabinet.getCabinetStatus(), cabinet.getCabinetId() };
		jdbcTemplate.update(sql.toString(), values);
	}

	@Override
	public void deleteCabinetBySSIdAndCabinetCode(String ssId,
			String cabinetCode) throws Exception {
		String sql = " DELETE FROM T_CABINET WHERE SS_ID = ? AND CABINET_CODE = ? ";
		Object[] values = new Object[] { ssId, cabinetCode };
		jdbcTemplate.update(sql, values);
	}

	@Override
	public Cabinet getCabinetBySSIdAndCabinetCode(String ssId,String cabinetCode) throws Exception {
		String sql = " SELECT * FROM T_CABINET WHERE SS_ID = ? AND CABINET_CODE = ? ";
		Object[] values = new Object[] {ssId, cabinetCode };

		Map map = null;
		try {
			map = jdbcTemplate.queryForMap(sql, values);
		} catch (DataAccessException e) {
			return null;
		}
		Cabinet cabinet = fetch(map);
		return cabinet;
	}

	@Override
	public void updateCabinet(IDeviceStatus deviceStatus, String ssId) throws Exception {
		 String sql ="UPDATE T_CABINET SET CABINET_STATUS= ? WHERE CABINET_CODE = ? AND SS_ID = ? ";
		 Object[] values = new Object[] {deviceStatus.getDeviceStatus(),deviceStatus.getDeviceCode(),ssId};
		 jdbcTemplate.update(sql, values);
	}

}
