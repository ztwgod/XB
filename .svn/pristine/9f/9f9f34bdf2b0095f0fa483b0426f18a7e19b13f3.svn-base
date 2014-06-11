package cn.com.xb.service.impl;

import java.util.List;

import cn.com.xb.dao.IOperationLogDao;
import cn.com.xb.daox.IOperationLogDaox;
import cn.com.xb.domain.base.OperationLog;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.displayWrapper.OperationLogWrapper;
import cn.com.xb.domain.parameterWrapper.GetOperationLogListParam;
import cn.com.xb.service.OperationLogService;

/**
 * 操作日志管理
 * @author DiGua
 *
 */
public class OperationLogServiceImpl implements OperationLogService
{
	private IOperationLogDao operationLogDao;
	private IOperationLogDaox operationLogDaox;

	public void setOperationLogDao(IOperationLogDao operationLogDao)
	{
		this.operationLogDao = operationLogDao;
	}
	public void setOperationLogDaox(IOperationLogDaox operationLogDaox)
	{
		this.operationLogDaox = operationLogDaox;
	}

	public int getOperationLogListSize(GetOperationLogListParam golp) throws Exception
	{
		return operationLogDaox.getOperationLogListSize(golp);
	}

	public List<OperationLogWrapper> getOperationLogListLimit(GetOperationLogListParam golp, Page page) throws Exception
	{
		if(null != page)
		{
			return operationLogDaox.getOperationLogListLimit(golp, page.getStartItems(), page.getPageSize());
		}
		else
		{
			return operationLogDaox.getOperationLogList(golp);
		}
	}

	public void addOperationLogInfo(OperationLog ol) throws Exception
	{
		operationLogDao.insert(ol);
	}
	@Override
	public OperationLogWrapper getOperationLogDetailByLogId(String logId) throws Exception
	{
		return operationLogDaox.getOperationLogDetailByLogId(logId);
	}
}
