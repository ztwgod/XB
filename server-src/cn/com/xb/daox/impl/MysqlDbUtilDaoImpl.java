package cn.com.xb.daox.impl;

import java.sql.Timestamp;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.daox.IMysqlDbUtilDao;

public class MysqlDbUtilDaoImpl implements IMysqlDbUtilDao{

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Timestamp getSystemDate() throws Exception {
		String sql = "SELECT NOW()";
		Timestamp time = (Timestamp) jdbcTemplate.queryForObject(sql, Timestamp.class);
		return time;
	}

}
