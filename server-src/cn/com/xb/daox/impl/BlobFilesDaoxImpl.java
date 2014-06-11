package cn.com.xb.daox.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

import cn.com.xb.daox.IBlobFilesDaox;
import cn.com.xb.domain.base.BlobFiles;
import cn.com.xb.util.StringUtil;

public class BlobFilesDaoxImpl implements IBlobFilesDaox
{
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public void insertBlobFile(final BlobFiles bf) throws Exception
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO T_BLOB_FILES(FILE_ID, FILE_NAME, FILE_SUFFIX, FILE_TYPE, FILE_CONTENTS, FILE_SIZE)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?)");
		final LobHandler lobHandler = new DefaultLobHandler(); 
		jdbcTemplate.execute(sql.toString(), new AbstractLobCreatingPreparedStatementCallback(lobHandler)
		{
			@Override
			protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException
			{
				lobCreator.setClobAsString(ps, 1, bf.getFileId());
				lobCreator.setClobAsString(ps, 2, bf.getFileName());
				lobCreator.setClobAsString(ps, 3, bf.getFileSuffix());
				lobCreator.setClobAsString(ps, 4, bf.getFileType());
				lobCreator.setBlobAsBinaryStream(ps, 5, bf.getFileInputStream(), (int) bf.getFileContents().length());
				lobCreator.setClobAsString(ps, 6, String.valueOf(bf.getFileSize()));
			}
		});
	}


	@Override
	public void updateBlobFile(final BlobFiles bf) throws Exception
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE T_BLOB_FILES SET FILE_NAME = ?, FILE_SUFFIX = ?, FILE_TYPE = ?, FILE_CONTENTS = ?, FILE_SIZE = ? WHERE FILE_ID = ?");
		
		final LobHandler lobHandler = new DefaultLobHandler();
		jdbcTemplate.execute(sql.toString(), new AbstractLobCreatingPreparedStatementCallback(lobHandler)
		{
			@Override
			protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException
			{
				lobCreator.setClobAsString(ps, 1, bf.getFileName());
				lobCreator.setClobAsString(ps, 2, bf.getFileSuffix());
				lobCreator.setClobAsString(ps, 3, bf.getFileType());
				lobCreator.setBlobAsBinaryStream(ps, 4, bf.getFileInputStream(), (int) bf.getFileContents().length());
				lobCreator.setClobAsString(ps, 5, String.valueOf(bf.getFileSize()));
				lobCreator.setClobAsString(ps, 6, bf.getFileId());
			}
		});
	}
	
	
	public List<BlobFiles> getBlobFilesByUserId(String userId) throws Exception
	{
		List<BlobFiles> bfs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT BF.FILE_ID, BF.FILE_NAME, BF.FILE_SUFFIX, BF.FILE_TYPE, BF.FILE_SIZE");
		sql.append(" FROM T_BLOB_FILES BF, T_P_COURIER PC WHERE BF.FILE_ID = PC.SNAPSHOT_PIC_ID AND PC.USER_ID = ?");
		sql.append(" UNION ALL SELECT BF.FILE_ID, BF.FILE_NAME, BF.FILE_SUFFIX, BF.FILE_TYPE, BF.FILE_SIZE");
		sql.append(" FROM T_BLOB_FILES BF, T_P_COURIER PC WHERE BF.FILE_ID = PC.PAPERWORK_PIC1_ID AND PC.USER_ID = ?");
		sql.append(" UNION ALL SELECT BF.FILE_ID, BF.FILE_NAME, BF.FILE_SUFFIX, BF.FILE_TYPE, BF.FILE_SIZE");
		sql.append(" FROM T_BLOB_FILES BF, T_P_COURIER PC WHERE BF.FILE_ID = PC.PAPERWORK_PIC2_ID AND PC.USER_ID = ?");
		
		List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{userId, userId, userId});
		if(null != list && list.size() != 0)
		{
			bfs = new ArrayList<BlobFiles>();
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				Map map = (Map) it.next();
				
				BlobFiles bf = new BlobFiles();
				bf.setFileId(StringUtil.formatStringTrim(map.get("FILE_ID")));
				bf.setFileName(StringUtil.formatStringTrim(map.get("FILE_NAME")));
				bf.setFileSuffix(StringUtil.formatStringTrim(map.get("FILE_SUFFIX")));
				bf.setFileType(StringUtil.formatStringTrim(map.get("FILE_TYPE")));
				bf.setFileSize(StringUtil.formatStringToDouble(map.get("FILE_SIZE"), 0));
				
				bfs.add(bf);
			}
		}
		
		return bfs;
	}
}
