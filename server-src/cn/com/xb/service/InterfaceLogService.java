package cn.com.xb.service;

import cn.com.xb.domain.base.StoragestationIntfLog;

public interface InterfaceLogService
{
	/**
	 * 添加日志信息
	 * @param sil
	 * @throws Exception
	 */
	public void addInterfaceLogInfo(String applyCode, int upDown, StoragestationIntfLog sil) throws Exception;
}
