package cn.com.xb.daox.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.daox.IOrderDaox;
import cn.com.xb.domain.base.FeeProof;
import cn.com.xb.domain.displayWrapper.OrderWrapper;
import cn.com.xb.domain.displayWrapper.TransActionDetailWrapper;
import cn.com.xb.domain.parameterWrapper.GetOrderListParam;
import cn.com.xb.util.Global;
import cn.com.xb.util.StringUtil;

public class OrderDaoxImpl implements IOrderDaox
{
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	

	@Override
	public int getOrderListSize(GetOrderListParam golp) throws Exception
	{
		int count = 0;
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(1) CNT FROM T_TRANSACTION T, T_USER SENDER, T_USER ADDRESSEE, T_BOX_INFO BI, T_STORAGESTATION SS");
		sql.append(" WHERE T.SENDER_ID = SENDER.USER_ID AND T.ADDRESSEE_ID = ADDRESSEE.USER_ID AND T.BOX_ID = BI.BOX_ID AND BI.SS_ID = SS.SS_ID");

		if (StringUtil.isNotBlank(golp.getGroupId()))
		{
			sql.append(" AND SS.GROUP_ID = ?");
			param.add(golp.getGroupId());
		}
		if (StringUtil.isNotBlank(golp.getSsCode()))
		{
			sql.append(" AND SS.SS_CODE LIKE ?");
			param.add("%" + golp.getSsCode() + "%");
		}
		if (StringUtil.isNotBlank(golp.getMobileNumber()))
		{
			sql.append(" AND (SENDER.MOBILE_NUMBER = ? OR ADDRESSEE.MOBILE_NUMBER = ?)");
			param.add(golp.getMobileNumber());
			param.add(golp.getMobileNumber());
		}
		if (StringUtil.isNotBlank(golp.getUserId()))
		{
			sql.append(" AND (T.SENDER_ID = ? OR T.ADDRESSEE_ID = ?)");
			param.add(golp.getUserId());
			param.add(golp.getUserId());
		}
		if (StringUtil.isNotBlank(golp.getOrderCode()))
		{
			sql.append(" AND T.TRANS_CODE LIKE ?");
			param.add("%" + golp.getOrderCode() + "%");
		}
		if (StringUtil.isNotBlank(golp.getStartDate()))
		{
			sql.append(" AND DATE_FORMAT(T.CREATE_TIME, '%Y-%m-%d') >= ? ");
			param.add(golp.getStartDate());
		}
		if (StringUtil.isNotBlank(golp.getEndDate()))
		{
			sql.append(" AND DATE_FORMAT(T.CREATE_TIME, '%Y-%m-%d') <= ? ");
			param.add(golp.getEndDate());
		}

		try
		{
			count = jdbcTemplate.queryForInt(sql.toString(), param.toArray());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return count;
	}
	
	@Override
	public List<OrderWrapper> getOrderListLimit(GetOrderListParam golp, int startInd, int pageSize) throws Exception
	{
		List<OrderWrapper> ows = null;
		
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT TRANS.*, FD.NAME TRANS_TYPE_SHOW, COUR.USER_NAME COURIER_NAME,");
		sql.append(" TAD.TRANS_ACTION_ID, TAD.TRANS_ACTION_TYPE, TAD.ACTION_TIME, TAD.ACTIONER ACTIONER_ID, ACTIONER.USER_NAME ACTIONER_NAME, ACTIONER.MOBILE_NUMBER ACTIONER_MOBILE_NUM, TAD.BOX_ACTION_ID,");
		sql.append(" EP.FEE_ID, EP.PAY_METHODS, EP.AMOUNT, EP.VOUCHER_ID, EP.VOUCHER_TOTAL, EP.BOX_FEE_ID");
		sql.append(" FROM (SELECT T.TRANS_ID, T.TRANS_CODE, T.USER_ID, T.TRANS_TYPE, T.SUPPLIER_ID, T.COURIER_ID, T.EXPRESS_DELIVERY_ID, T.EXPRESS_CODE, T.EXPRESS_DESC, T.SIZE_TYPE, T.STORAGE_TIME,");
		sql.append(" T.PAST_DUE_TIME, T.TOTAL_AMOUNT, T.PICKUP_PWD, T.IS_STANDARDS_COMPLIANT, T.NOT_STANDARDS_COMPLIANT_CAUSE, T.SENDER_ID, T.ADDRESSEE_ID,");
		sql.append(" T.BOX_ID, T.CREATE_TIME, T.CLOSE_TIME, T.LAST_MODIFY_TIME, T.BOX_TRANS_ID, T.TRANS_STATUS,");
		sql.append(" SENDER.USER_NAME SENDER_NAME, SENDER.MOBILE_NUMBER SENDER_MOBILE_NUM,");
		sql.append(" ADDRESSEE.USER_NAME ADDRESSEE_NAME, ADDRESSEE.MOBILE_NUMBER ADDRESSEE_MOBILE_NUM");
		sql.append(" FROM T_TRANSACTION T, T_USER SENDER, T_USER ADDRESSEE, T_BOX_INFO BI, T_STORAGESTATION SS");
		sql.append(" WHERE T.SENDER_ID = SENDER.USER_ID AND T.ADDRESSEE_ID = ADDRESSEE.USER_ID AND T.BOX_ID = BI.BOX_ID AND BI.SS_ID = SS.SS_ID");
		
		if(StringUtil.isNotBlank(golp.getGroupId()))
		{
			sql.append(" AND SS.GROUP_ID = ?");
			param.add(golp.getGroupId());
		}
		if(StringUtil.isNotBlank(golp.getSsCode()))
		{
			sql.append(" AND SS.SS_CODE LIKE ?");
			param.add(golp.getSsCode());
		}
		if(StringUtil.isNotBlank(golp.getMobileNumber()))
		{
			sql.append(" AND (SENDER.MOBILE_NUMBER = ? OR ADDRESSEE.MOBILE_NUMBER = ?)");
			param.add(golp.getMobileNumber());
			param.add(golp.getMobileNumber());
		}
		if(StringUtil.isNotBlank(golp.getUserId()))
		{
			sql.append(" AND (T.SENDER_ID = ? OR T.ADDRESSEE_ID = ?)");
			param.add(golp.getUserId());
			param.add(golp.getUserId());
		}
		if(StringUtil.isNotBlank(golp.getOrderCode()))
		{
			sql.append(" AND T.TRANS_CODE LIKE ?");
			param.add("%"+golp.getOrderCode()+"%");
		}
		if(StringUtil.isNotBlank(golp.getStartDate()))
		{
			sql.append(" AND DATE_FORMAT(T.CREATE_TIME, '%Y-%m-%d') >= ? ");
			param.add(golp.getStartDate());
		}
		if(StringUtil.isNotBlank(golp.getEndDate()))
		{
			sql.append(" AND DATE_FORMAT(T.CREATE_TIME, '%Y-%m-%d') <= ? ");
			param.add(golp.getEndDate());
		}
		
		sql.append(" ORDER BY T.LAST_MODIFY_TIME DESC, T.TRANS_CODE LIMIT ?, ?) TRANS");
		param.add(startInd);
		param.add(pageSize);
		
		sql.append(" LEFT JOIN T_USER COUR ON (TRANS.COURIER_ID = COUR.USER_ID), T_FLAG_DICTIONARY FD, T_TRANS_ACTION_DETAIL TAD LEFT JOIN T_FEE_PROOF EP ON (TAD.TRANS_ACTION_ID = EP.TRANS_ACTION_ID), T_USER ACTIONER");
		sql.append(" WHERE TRANS.TRANS_ID = TAD.TRANS_ID AND TRANS.TRANS_TYPE = FD.CODE AND TAD.ACTIONER = ACTIONER.USER_ID AND FD.TYPE_ID = '"+Global.DICTIONARY_TYPE_TRANS_TYPE+"'");
		sql.append(" ORDER BY TRANS.LAST_MODIFY_TIME DESC, TRANS.TRANS_CODE, TAD.ACTION_TIME");
		
		List list = jdbcTemplate.queryForList(sql.toString(), param.toArray());
		if(null != list && list.size() != 0)
		{
			Map<String, OrderWrapper> owMap = new LinkedHashMap<String, OrderWrapper>();
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				
				Map map = (Map) it.next();
				String orderId = StringUtil.formatStringTrim(map.get("TRANS_ID"));
				
				OrderWrapper ow = owMap.get(orderId);
				if(ow == null)
				{
					ow = new OrderWrapper();
					ow.setTransId(orderId);
					ow.setTransCode(StringUtil.formatStringTrim(map.get("TRANS_CODE")));
					ow.setUserId(StringUtil.formatStringTrim(map.get("USER_ID")));
					ow.setTransType(StringUtil.formatStringToInteger(map.get("TRANS_TYPE"), 0));
					ow.setTransTypeShow(StringUtil.formatStringTrim(map.get("TRANS_TYPE_SHOW")));
					ow.setSupplierId(StringUtil.formatStringTrim(map.get("SUPPLIER_ID")));
					ow.setCourierId(StringUtil.formatStringTrim(map.get("COURIER_ID")));
					ow.setCourierName(StringUtil.formatStringTrim(map.get("COURIER_NAME")));
					ow.setExpressDeliveryId(StringUtil.formatStringTrim(map.get("EXPRESS_DELIVERY_ID")));
					ow.setExpressCode(StringUtil.formatStringTrim(map.get("EXPRESS_CODE")));
					ow.setExpressDesc(StringUtil.formatStringTrim(map.get("EXPRESS_DESC")));
					ow.setSizeType(StringUtil.formatStringToInteger(map.get("SIZE_TYPE"), 0));
					ow.setStorageTime(StringUtil.formatStringToInteger(map.get("STORAGE_TIME"), 0));
					ow.setPastDueTime(StringUtil.formatStringToInteger(map.get("PAST_DUE_TIME"), 0));
					ow.setTotalAmount(StringUtil.formatStringToDouble(map.get("TOTAL_AMOUNT"), 0));
					ow.setPickupPwd(StringUtil.formatStringTrim(map.get("PICKUP_PWD")));
					ow.setIsStandardsCompliant(StringUtil.formatStringToInteger(map.get("IS_STANDARDS_COMPLIANT"), 0));
					ow.setNotStandardsCompliantCause(StringUtil.formatStringTrim(map.get("NOT_STANDARDS_COMPLIANT_CAUSE")));
					ow.setSenderId(StringUtil.formatStringTrim(map.get("SENDER_ID")));
					ow.setSenderName(StringUtil.formatStringTrim(map.get("SENDER_NAME")));
					ow.setSenderMobileNum(StringUtil.formatStringTrim(map.get("SENDER_MOBILE_NUM")));
					ow.setAddresseeId(StringUtil.formatStringTrim(map.get("ADDRESSEE_ID")));
					ow.setAddresseeName(StringUtil.formatStringTrim(map.get("ADDRESSEE_NAME")));
					ow.setAddresseeMobileNum(StringUtil.formatStringTrim(map.get("ADDRESSEE_MOBILE_NUM")));
					ow.setBoxId(StringUtil.formatStringTrim(map.get("BOX_ID")));
					ow.setCreateTime((Timestamp) map.get("CREATE_TIME"));
					ow.setCloseTime((Timestamp) map.get("CLOSE_TIME"));
					ow.setLastModifyTime((Timestamp) map.get("LAST_MODIFY_TIME"));
					ow.setBoxTransId(StringUtil.formatStringTrim(map.get("BOX_TRANS_ID")));
					ow.setTransStatus(StringUtil.formatStringToInteger(map.get("TRANS_STATUS"), 0));
				}
				
				TransActionDetailWrapper tadw = new TransActionDetailWrapper();
				tadw.setTransId(ow.getTransId());
				tadw.setTransActionId(StringUtil.formatStringTrim(map.get("TRANS_ACTION_ID")));
				tadw.setTransActionType(StringUtil.formatStringToInteger(map.get("TRANS_ACTION_TYPE"), 0));
				tadw.setActionTime((Timestamp) map.get("ACTION_TIME"));
				tadw.setActioner(StringUtil.formatStringTrim(map.get("ACTIONER_ID")));
				tadw.setActionerName(StringUtil.formatStringTrim(map.get("ACTIONER_NAME")));
				tadw.setActionerMobileNum(StringUtil.formatStringTrim(map.get("ACTIONER_MOBILE_NUM")));
				tadw.setBoxActionId(StringUtil.formatStringTrim(map.get("BOX_ACTION_ID")));
				
				
				String feeId = StringUtil.formatStringTrim(map.get("FEE_ID"));
				if(StringUtil.isNotBlank(feeId))
				{
					FeeProof feeProof = new FeeProof();
					feeProof.setFeeId(feeId);
					feeProof.setTransId(ow.getTransId());
					feeProof.setTransActionId(tadw.getTransActionId());
					feeProof.setPayMethods(StringUtil.formatStringToInteger(map.get("PAY_METHODS"), 0));
					feeProof.setAmount(StringUtil.formatStringToDouble(map.get("AMOUNT"), 0));
					feeProof.setVoucherId(StringUtil.formatStringTrim(map.get("VOUCHER_ID")));
					feeProof.setVoucherTotal(StringUtil.formatStringToInteger(map.get("VOUCHER_TOTAL"), 0));
					feeProof.setBoxFeeId(StringUtil.formatStringTrim(map.get("BOX_FEE_ID")));

					tadw.setFeeProof(feeProof);
				}
				
				ow.addTadws(tadw);
				owMap.put(ow.getTransId(), ow);
			}
			
			if(owMap != null && owMap.size() != 0)
			{
				Iterator keyIt = owMap.keySet().iterator();
				while(keyIt.hasNext())
				{
					String key = (String) keyIt.next();
					OrderWrapper ow = owMap.get(key);
					if(null != ow)
					{
						if(null == ows)
						{
							ows = new ArrayList<OrderWrapper>();
						}
						ows.add(ow);
					}
				}
			}
		}
		
		return ows;
	}

}
