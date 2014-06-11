package cn.com.xb.service;

import java.util.List;

import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.displayWrapper.OperationLogWrapper;
import cn.com.xb.domain.parameterWrapper.GetOperationLogListParam;

public interface OperationLogService
{
	/**
	 * 查询操作日志列表记录数
	 * @param golp
	 * @return
	 * @throws Exception
	 */
	public int getOperationLogListSize(GetOperationLogListParam golp) throws Exception;
	
	
	/**
	 * 查询操作日志列表（page不为空时分页，page为空时不分页）
	 * @param golp
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OperationLogWrapper> getOperationLogListLimit(GetOperationLogListParam golp, Page page) throws Exception;
	
	
	/**
	 * 添加日志信息
	 * @param ol
	 * @throws Exception
	 */
	public void addOperationLogInfo(OperationLog ol) throws Exception;
	
	
	/**
	 * 查询操作日志信息
	 * @param logId
	 * @return
	 * @throws Exception
	 */
	public OperationLogWrapper getOperationLogDetailByLogId(String logId) throws Exception;
}
