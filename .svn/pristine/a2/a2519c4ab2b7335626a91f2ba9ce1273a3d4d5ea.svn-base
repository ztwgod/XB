package cn.com.xb.daox;

import java.util.List;

import cn.com.xb.domain.displayWrapper.OperationLogWrapper;
import cn.com.xb.domain.parameterWrapper.GetOperationLogListParam;

public interface IOperationLogDaox
{
	
	/**
	 * 获取操作日志列表记录数
	 * @return
	 * @throws Exception
	 */
	public int getOperationLogListSize(GetOperationLogListParam golp) throws Exception;
	
	
	/**
	 * 获取操作日志列表(分页)
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OperationLogWrapper> getOperationLogListLimit(GetOperationLogListParam golp, int startInd, int pageSize) throws Exception;
	

	/**
	 * 获取操作日志列表(不分页)
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OperationLogWrapper> getOperationLogList(GetOperationLogListParam golp) throws Exception;
	

	/**
	 * 查看操作日志详情
	 * @param logId
	 * @return
	 * @throws Exception
	 */
	public OperationLogWrapper getOperationLogDetailByLogId(String logId) throws Exception;
}
