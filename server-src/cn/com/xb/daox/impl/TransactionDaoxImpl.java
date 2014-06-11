package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.TransactionDaoImpl;
import cn.com.xb.daox.ITransactionDaox;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.base.SsBoxnumLogx;
import cn.com.xb.domain.base.Transaction;
import cn.com.xb.domain.base.Transactionx;
import cn.com.xb.inter.domain.IAppTransactionInfo;
import cn.com.xb.inter.domain.request.GetTransactionListWrapper;
import cn.com.xb.inter.domain.request.RemoteUnpackeInfoWarpper;
import cn.com.xb.util.DateTools;
import cn.com.xb.util.StringUtil;

public class TransactionDaoxImpl extends TransactionDaoImpl implements ITransactionDaox {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public String getUserIdByTransactionId(String transactionId) throws Exception {
		String userId=null;
		String sql = "SELECT * FROM T_TRANSACTION WHERE TRANS_ID = ? ";
		Object[] values = new Object[] { transactionId };
		List list=jdbcTemplate.queryForList(sql, values);
		userId = StringUtil.formatStringTrimToNull(((Map) list.get(0)).get("USER_ID"));
		return userId;
	}
	public Transaction getTransaction(String boxId) throws Exception {
		Transaction transaction = null;
		String sql = "SELECT * FROM T_TRANSACTION WHERE BOX_ID = ? ";
		Object[] values = new Object[] { boxId };
		Map map = null;
		try {
			map = jdbcTemplate.queryForMap(sql, values);
		} catch (DataAccessException e) {
			return null;
		}
		transaction = fetch(map);
		return transaction;
	}

	@Override
	public RemoteUnpackeInfoWarpper getAppOpenBoxInfo(String transId) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT T.BOX_TRANS_ID,B.BOX_CODE,C.SS_CODE FROM T_TRANSACTION T,T_BOX_INFO B,T_STORAGESTATION C ");
		sql.append(" WHERE T.BOX_ID = B.BOX_ID AND B.SS_ID = C.SS_ID AND T.TRANS_ID = ?");
		
		Object[] values = new Object[]{transId};
		Map map = null;
		try{ 
			 map = jdbcTemplate.queryForMap(sql.toString(), values);
		} catch (DataAccessException e) {
			 return null;
		}
		String boxTransId = (String)map.get("BOX_TRANS_ID");
		String boxCode = (String)map.get("BOX_CODE");
		String ssCode = (String)map.get("SS_CODE");
		
		RemoteUnpackeInfoWarpper remote = new RemoteUnpackeInfoWarpper();
		remote.setBoxCode(boxCode);
		remote.setTransactionID(boxTransId);
		remote.setStorageStationId(ssCode);
		return remote;
	}

	@Override
	public List<IAppTransactionInfo> getAppTransactionInfos(
			GetTransactionListWrapper trans) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.TRANS_ID,A.TRANS_CODE,A.TRANS_TYPE,B.NAME TRANSTYPESHOW,KD.USER_NAME COURIERNAME, ");
		sql.append(" A.EXPRESS_CODE,A.EXPRESS_DESC,FJR.USER_NAME SENDERNAME,FJR.MOBILE_NUMBER senderMobileNum,");
		sql.append(" SJR.USER_NAME addresseeName,SJR.MOBILE_NUMBER addresseeMobileNum, A.TRANS_STATUS,D.SS_ADDRESS,C.BOX_INDEX,E.CABINET_INDEX ");
		sql.append(" FROM T_TRANSACTION A,T_FLAG_DICTIONARY B,T_USER KD,T_USER FJR,T_USER SJR,T_BOX_INFO C,T_STORAGESTATION D,T_CABINET E ");
		sql.append(" WHERE A.TRANS_TYPE = B.CODE AND B.TYPE_ID = '1' AND A.COURIER_ID = KD.USER_ID ");
		sql.append(" AND FJR.USER_ID = A.SENDER_ID AND SJR.USER_ID = A.ADDRESSEE_ID AND C.BOX_ID = A.BOX_ID AND D.SS_ID = C.SS_ID AND E.CABINET_ID = C.CABINET_ID ");
		sql.append(" AND A.USER_ID = ? AND A.TRANS_TYPE = ? AND A.TRANS_STATUS = ? ");
		
		Object[] values = new Object[]{trans.getUserId(),trans.getTransType(),trans.getTransStatus()};
		
		List<IAppTransactionInfo> mapList = jdbcTemplate.queryForList(sql.toString(),values);
		Iterator iter = mapList.iterator();
		List<IAppTransactionInfo> appTransactionInfos = new ArrayList<IAppTransactionInfo>();
		while(iter.hasNext()){
			Map map = (Map) iter.next();
			IAppTransactionInfo transactionInfo = new IAppTransactionInfo();
			transactionInfo.setTransId((String)map.get("TRANS_ID"));
			transactionInfo.setTransCode((String)map.get("TRANS_CODE"));
			transactionInfo.setTransType(Integer.parseInt(map.get("TRANS_TYPE").toString()));
			transactionInfo.setTransTypeShow((String)map.get("NAME TRANSTYPESHOW"));
			transactionInfo.setCourierName((String)map.get("COURIERNAME"));
			transactionInfo.setExpressCode((String)map.get("EXPRESS_CODE"));
			transactionInfo.setExpressDesc((String)map.get("EXPRESS_DESC"));
			transactionInfo.setSenderName((String)map.get("SENDERNAME"));
			transactionInfo.setSenderMobileNum((String)map.get("senderMobileNum"));
			transactionInfo.setAddresseeName((String)map.get("addresseeName"));
			transactionInfo.setAddresseeMobileNum((String)map.get("addresseeMobileNum"));
			transactionInfo.setTransStatus(Integer.parseInt(map.get("TRANS_STATUS").toString()));
			String cabIndex = (String)map.get("CABINET_INDEX");
			String boxIndex = (String)map.get("BOX_INDEX");
			transactionInfo.setBoxIndexShow(cabIndex+"-"+boxIndex);
			transactionInfo.setSsAddress((String)map.get("SS_ADDRESS"));
			appTransactionInfos.add(transactionInfo);
		}
		return appTransactionInfos;
	}
	
	

	
	public boolean isExistTransByBoxTransID(String transId) throws Exception
	{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT EXISTS(SELECT 1 FROM T_TRANSACTION T WHERE T.BOX_TRANS_ID = ?)");
		int flagInt = jdbcTemplate.queryForInt(sql.toString(), new Object[]{transId});
		
		return flagInt == 1;
	}
	
	public String getTransIdByBoxTransID(String boxTransId) throws Exception
	{
		String transId = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.TRANS_ID FROM T_TRANSACTION T WHERE T.BOX_TRANS_ID = ?");

		List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{boxTransId});
		if(null != list && list.size() != 0)
		{
			transId = StringUtil.formatStringTrimToNull(((Map) list.get(0)).get("TRANS_ID"));
		}
		
		return transId;
	}
	
	
	public String getSenderIdByTransId(String transId) throws Exception
	{
		String senderId = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.SENDER_ID FROM T_TRANSACTION T WHERE T.TRANS_ID = ?");

		List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{transId});
		if(null != list && list.size() != 0)
		{
			senderId = StringUtil.formatStringTrimToNull(((Map) list.get(0)).get("SENDER_ID"));
		}
		
		return senderId;
	}
	

	public String getAddresseeIdByTransId(String transId) throws Exception
	{
		String addresseeId = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.ADDRESSEE_ID FROM T_TRANSACTION T WHERE T.TRANS_ID = ?");

		List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{transId});
		if(null != list && list.size() != 0)
		{
			addresseeId = StringUtil.formatStringTrimToNull(((Map) list.get(0)).get("ADDRESSEE_ID"));
		}
		
		return addresseeId;
	}
	
	public void updateTransactionInfo(Transaction transaction) throws Exception
	{
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE T_TRANSACTION SET");

		if(StringUtil.isNotBlank(transaction.getTransCode()))
		{
			sql.append(" TRANS_CODE = ?");
			param.add(transaction.getTransCode());
		}
		if(null != transaction.getCreateTime())
		{
			sql.append((param.size() == 0 ? "" : ",") + " CREATE_TIME = ?");
			param.add(transaction.getCreateTime());
		}
		if(StringUtil.isNotBlank(transaction.getUserId()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " USER_ID = ?");
			param.add(transaction.getUserId());
		}
		if(StringUtil.isNotBlank(transaction.getSupplierId()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " SUPPLIER_ID = ?");
			param.add(transaction.getSupplierId());
		}
		if(StringUtil.isNotBlank(transaction.getCourierId()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " COURIER_ID = ?");
			param.add(transaction.getCourierId());
		}
		if(StringUtil.isNotBlank(transaction.getExpressDeliveryId()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " EXPRESS_DELIVERY_ID = ?");
			param.add(transaction.getExpressDeliveryId());
		}
		if(StringUtil.isNotBlank(transaction.getExpressCode()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " EXPRESS_CODE = ?");
			param.add(transaction.getExpressCode());
		}
		if(StringUtil.isNotBlank(transaction.getExpressDesc()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " EXPRESS_DESC = ?");
			param.add(transaction.getExpressDesc());
		}
		if(0 != transaction.getPastDueTime())
		{
			sql.append((param.size() == 0 ? "" : ",") + " PAST_DUE_TIME = ?");
			param.add(transaction.getPastDueTime());
		}
		if(0 != transaction.getStorageTime())
		{
			sql.append((param.size() == 0 ? "" : ",") + " STORAGE_TIME = ?");
			param.add(transaction.getStorageTime());
		}
		if(StringUtil.isNotBlank(transaction.getPickupPwd()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " PICKUP_PWD = ?");
			param.add(transaction.getPickupPwd());
		}
		if(0 != transaction.getIsStandardsCompliant())
		{
			sql.append((param.size() == 0 ? "" : ",") + " IS_STANDARDS_COMPLIANT = ?");
			param.add(transaction.getIsStandardsCompliant());
		}
		if(StringUtil.isNotBlank(transaction.getNotStandardsCompliantCause()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " NOT_STANDARDS_COMPLIANT_CAUSE = ?");
			param.add(transaction.getNotStandardsCompliantCause());
		}
		if(StringUtil.isNotBlank(transaction.getSenderId()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " SENDER_ID = ?");
			param.add(transaction.getSenderId());
		}
		if(StringUtil.isNotBlank(transaction.getAddresseeId()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " ADDRESSEE_ID = ?");
			param.add(transaction.getAddresseeId());
		}
		if(null != transaction.getLastModifyTime())
		{
			sql.append((param.size() == 0 ? "" : ",") + " LAST_MODIFY_TIME = ?");
			param.add(transaction.getLastModifyTime());
		}
		if(null != transaction.getCloseTime())
		{
			sql.append((param.size() == 0 ? "" : ",") + " CLOSE_TIME = ?");
			param.add(transaction.getCloseTime());
		}
		if(StringUtil.isNotBlank(transaction.getBoxId()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " BOX_ID = ?");
			param.add(transaction.getBoxId());
		}
		if(StringUtil.isNotBlank(transaction.getTransType()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " TRANS_TYPE = ?");
			param.add(transaction.getTransType());
		}
		if(StringUtil.isNotBlank(transaction.getBoxTransId()))
		{
			sql.append((param.size() == 0 ? "" : ",") + " BOX_TRANS_ID = ?");
			param.add(transaction.getBoxTransId());
		}
		if(0 != transaction.getTotalAmount())
		{
			sql.append((param.size() == 0 ? "" : ",") + " TOTAL_AMOUNT = ?");
			param.add(transaction.getTotalAmount());
		}
		if(0 != transaction.getSizeType())
		{
			sql.append((param.size() == 0 ? "" : ",") + " SIZE_TYPE = ?");
			param.add(transaction.getSizeType());
		}
		if(0 != transaction.getTransStatus())
		{
			sql.append((param.size() == 0 ? "" : ",") + " TRANS_STATUS = ?");
			param.add(transaction.getTransStatus());
		}
		
		sql.append(" WHERE TRANS_ID = ?");
		param.add(transaction.getTransId());
		
		jdbcTemplate.update(sql.toString(), param.toArray()); 
	}

	@Override
	public List<Transactionx> getTransLists(Transactionx tranx,Page page) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT B.BOX_CODE,B.BOX_INDEX,C.NAME SIZE,D.NAME TRANS_TYPE_NAME,A.CREATE_TIME,A.CLOSE_TIME,A.TOTAL_AMOUNT,E.SS_CODE,A.TRANS_TYPE,A.SIZE_TYPE,A.EXPRESS_DELIVERY_ID ");
		sql.append(" FROM T_TRANSACTION A,T_BOX_INFO B,T_FLAG_DICTIONARY C,T_FLAG_DICTIONARY D,T_STORAGESTATION E ");
		sql.append(" WHERE A.BOX_ID = B.BOX_ID AND C.CODE = B.SIZE AND C.TYPE_ID = 4  ");
		sql.append(" AND D.TYPE_ID = 1 AND D.CODE = A.TRANS_TYPE AND E.SS_ID = B.SS_ID ");
		
		List<Object> values = new ArrayList<Object>();
		if(!"".equals(tranx.getsDate())){
			sql.append(" AND DATE_FORMAT(A.CREATE_TIME, '%Y-%m-%d') >= ? ");
			values.add(tranx.getsDate());
		}
		if(!"".equals(tranx.geteDate())){
			sql.append(" AND DATE_FORMAT(A.CREATE_TIME, '%Y-%m-%d') <= ? ");
			values.add(tranx.geteDate());
		}
		
		if(!"".equals(tranx.getsTime())){
			sql.append(" AND DATE_FORMAT(A.CREATE_TIME, '%H:%i:%S') >= ? ");
			values.add(tranx.getsTime());
		}
		
		if(!"".equals(tranx.geteTime())){
			sql.append(" AND DATE_FORMAT(A.CREATE_TIME, '%H:%i:%S') <= ?  ");
			values.add(tranx.geteTime());
		}
		
		if(!"".equals(tranx.getSsCode())){
			sql.append(" AND E.SS_CODE LIKE ?  ");
			values.add("%"+tranx.getSsCode()+"%");
		}
		
		if(tranx.getSizeType()>0){
			sql.append(" AND B.SIZE = ?  ");
			values.add(tranx.getSizeType());
		}
		
		if(!"".equals(tranx.getGroupId())){
			sql.append(" AND E.GROUP_ID = ? ");
			values.add(tranx.getGroupId());
		}
		
		if(!"".equals(tranx.getExpressDeliveryId())){
			sql.append(" AND A.EXPRESS_DELIVERY_ID = ? ");
			values.add(tranx.getExpressDeliveryId());
		}
		
		if(tranx.getTransType()>0){
			sql.append(" AND A.TRANS_TYPE = ? ");
			values.add(tranx.getTransType());
		}
		sql.append(" ORDER BY A.CREATE_TIME ");
		
		if(!tranx.isExcel()){
			sql.append(" LIMIT ?,? ");
			values.add(page.getStartItems());
			values.add(page.getPageSize());
		}
		
		List<Transactionx> lists = new ArrayList<Transactionx>();
		List<Transactionx> queryList = jdbcTemplate.queryForList(sql.toString(),values.toArray());
		Iterator it = queryList.iterator();	 
		while(it.hasNext()){
			Map map = (Map) it.next();
			Transactionx transactionx = new Transactionx();
			transactionx.setBoxCode(StringUtil.formatStringTrim(map.get("BOX_CODE")));
			transactionx.setBoxIndex(StringUtil.formatStringTrim(map.get("BOX_INDEX")));
			transactionx.setSizeName(StringUtil.formatStringTrim(map.get("SIZE")));
			transactionx.setTransTypeName(StringUtil.formatStringTrim(map.get("TRANS_TYPE_NAME")));
			transactionx.setCreateTime(DateTools.formatStringToTimestamp(map.get("CREATE_TIME"), DateTools.FORMAT_YYYYMMDD_HHMMSS));
			transactionx.setCloseTime(DateTools.formatStringToTimestamp(map.get("CLOSE_TIME"), DateTools.FORMAT_YYYYMMDD_HHMMSS));
			transactionx.setTotalAmount(StringUtil.formatStringToDouble(map.get("TOTAL_AMOUNT"), 0));
			transactionx.setSsCode(StringUtil.formatStringTrim(map.get("SS_CODE")));
			transactionx.setTransType(StringUtil.formatStringToInteger(map.get("TRANS_TYPE"), 0));
			transactionx.setSizeType(StringUtil.formatStringToInteger(map.get("SIZE_TYPE"), 0));
			transactionx.setExpressDeliveryId(StringUtil.formatStringTrim(map.get("EXPRESS_DELIVERY_ID")));
			lists.add(transactionx);
		}
		return lists;	
	}

	@Override
	public int getTransItems(Transactionx tranx) throws Exception {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT COUNT(1) ");
		sql.append(" FROM T_TRANSACTION A,T_BOX_INFO B,T_FLAG_DICTIONARY C,T_FLAG_DICTIONARY D,T_STORAGESTATION E ");
		sql.append(" WHERE A.BOX_ID = B.BOX_ID AND C.CODE = B.SIZE AND C.TYPE_ID = 4  ");
		sql.append(" AND D.TYPE_ID = 1 AND D.CODE = A.TRANS_TYPE AND E.SS_ID = B.SS_ID ");
		
		List<Object> values = new ArrayList<Object>();
		if(!"".equals(tranx.getsDate())){
			sql.append(" AND DATE_FORMAT(A.CREATE_TIME, '%Y-%m-%d') >= ? ");
			values.add(tranx.getsDate());
		}
		if(!"".equals(tranx.geteDate())){
			sql.append(" AND DATE_FORMAT(A.CREATE_TIME, '%Y-%m-%d') <= ? ");
			values.add(tranx.geteDate());
		}
		
		if(!"".equals(tranx.getsTime())){
			sql.append(" AND DATE_FORMAT(A.CREATE_TIME, '%H:%i:%S') >= ? ");
			values.add(tranx.getsTime());
		}
		
		if(!"".equals(tranx.geteTime())){
			sql.append(" AND DATE_FORMAT(A.CREATE_TIME, '%H:%i:%S') <= ?  ");
			values.add(tranx.geteTime());
		}
		
		if(!"".equals(tranx.getSsCode())){
			sql.append(" AND E.SS_CODE LIKE ?  ");
			values.add("%"+tranx.getSsCode()+"%");
		}
		
		if(tranx.getSizeType()>0){
			sql.append(" AND B.SIZE = ?  ");
			values.add(tranx.getSizeType());
		}
		
		if(!"".equals(tranx.getGroupId())){
			sql.append(" AND E.GROUP_ID = ? ");
			values.add(tranx.getGroupId());
		}
		
		if(!"".equals(tranx.getExpressDeliveryId())){
			sql.append(" AND A.EXPRESS_DELIVERY_ID = ? ");
			values.add(tranx.getExpressDeliveryId());
		}
		
		if(tranx.getTransType()>0){
			sql.append(" AND A.TRANS_TYPE = ? ");
			values.add(tranx.getTransType());
		}
		int items = jdbcTemplate.queryForInt(sql.toString(),values.toArray());
		return items;
	}
}
