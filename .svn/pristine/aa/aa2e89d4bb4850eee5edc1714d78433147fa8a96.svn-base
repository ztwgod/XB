package cn.com.xb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import cn.com.xb.dao.ISsBoxnumLogDao;
import cn.com.xb.daox.IBoxInfoDaox;
import cn.com.xb.daox.ISsBoxnumLogDaox;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.SsBoxnumLog;
import cn.com.xb.domain.base.SsBoxnumLogx;
import cn.com.xb.service.SsBoxnumLogServer;
import cn.com.xb.util.KeyHelper;

public class SsBoxnumLogServerImpl implements SsBoxnumLogServer {

	private ISsBoxnumLogDao ssboxnumLogDao;
	private IBoxInfoDaox boxInfoDaox;
	private ISsBoxnumLogDaox ssBoxnumLogDaox;

	public void setSsBoxnumLogDaox(ISsBoxnumLogDaox ssBoxnumLogDaox) {
		this.ssBoxnumLogDaox = ssBoxnumLogDaox;
	}

	public void setBoxInfoDaox(IBoxInfoDaox boxInfoDaox) {
		this.boxInfoDaox = boxInfoDaox;
	}

	public void setSsboxnumLogDao(ISsBoxnumLogDao ssboxnumLogDao) {
		this.ssboxnumLogDao = ssboxnumLogDao;
	}

	public void insertSSBoxNumLog(String ssId) throws Exception {
		int totalNum = boxInfoDaox.getItemsByRunStatus(ssId, 0);//总箱子数
		int faultNum = boxInfoDaox.getItemsByRunStatus(ssId, 6);//故障箱子数
		int occupationNum = boxInfoDaox.getItemsByRunStatus(ssId, 2);//箱子占用数
		int emptyNum = boxInfoDaox.getItemsByRunStatus(ssId, 1);//空箱占用数
		
		SsBoxnumLog log = new SsBoxnumLog();
		log.setTotalNum(totalNum);
		log.setFaultNum(faultNum);
		log.setOccupationNum(occupationNum);
		log.setEmptyNum(emptyNum);
		log.setRecordId(KeyHelper.creatKey());
		log.setSsId(ssId);
		log.setRecordTime(new Timestamp(System.currentTimeMillis()));
		ssboxnumLogDao.insert(log);
	}

	@Override
	public List<SsBoxnumLogx> getSSBoxNumLogLists(SsBoxnumLogx params, Page page)
			throws Exception {
		
		return ssBoxnumLogDaox.getSSBoxNumLogLists(params, page);
	}

	@Override
	public int getItems(SsBoxnumLogx params) throws Exception {
		
		return ssBoxnumLogDaox.getItems(params);
	}
}
