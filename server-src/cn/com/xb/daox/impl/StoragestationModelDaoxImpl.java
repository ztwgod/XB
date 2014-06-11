package cn.com.xb.daox.impl;

import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.StoragestationModelDaoImpl;
import cn.com.xb.daox.IStoragestationModelDaox;
import cn.com.xb.domain.base.StoragestationModel;

public class StoragestationModelDaoxImpl extends StoragestationModelDaoImpl
		implements IStoragestationModelDaox {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public StoragestationModel getStoragestationModelByCode(String moduleCode) throws Exception {
		String sql = " SELECT * FROM T_STORAGESTATION_MODEL A WHERE A.MODEL_FULL_CODE = ? ";
		Map map = null;
		try {
			map = jdbcTemplate.queryForMap(sql, new Object[] { moduleCode });
		} catch (DataAccessException e) {
			return null;
		}
		StoragestationModel model = super.fetch(map);
		return model;
	}

}
