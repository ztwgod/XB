package cn.com.xb.daox;

import java.util.List;

import cn.com.xb.domain.base.BlobFiles;

public interface IBlobFilesDaox
{
	/**
	 * 插入文件对象
	 * @param bf
	 * @throws Exception
	 */
	public void insertBlobFile(BlobFiles bf) throws Exception;
	
	/**
	 * 修改文件对象
	 * @param bf
	 * @throws Exception
	 */
	public void updateBlobFile(BlobFiles bf) throws Exception;
	
	
	/**
	 * 查询快递员对应的快照列表
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<BlobFiles> getBlobFilesByUserId(String userId) throws Exception;
	
}
