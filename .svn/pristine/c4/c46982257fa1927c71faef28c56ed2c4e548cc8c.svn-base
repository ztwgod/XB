package cn.com.xb.daox.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.PCourierDaoImpl;
import cn.com.xb.daox.ICourierDaox;
import cn.com.xb.domain.base.CourierGroup;
import cn.com.xb.domain.base.Courierx;
import cn.com.xb.domain.base.ExpressCompany;
import cn.com.xb.domain.base.PCourier;
import cn.com.xb.domain.base.Page;
import cn.com.xb.domain.displayWrapper.CourierGroupWrapper;
import cn.com.xb.domain.displayWrapper.CourierWrapper;
import cn.com.xb.domain.parameterWrapper.GetCourierGroupParam;
import cn.com.xb.domain.parameterWrapper.GetCourierListParam;
import cn.com.xb.inter.domain.ICourierAuthorityInfo;
import cn.com.xb.inter.domain.ICourierCardInfo;
import cn.com.xb.inter.domain.ICourierInfo;
import cn.com.xb.util.Global;
import cn.com.xb.util.StringUtil;

public class CourierDaoxImpl extends PCourierDaoImpl implements ICourierDaox
{
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public int getCourierCompaniesSize(ExpressCompany expressCompany) throws Exception
	{
		int items = 0;
		StringBuffer sql = new StringBuffer("SELECT COUNT(1) CNT FROM T_EXPRESS_COMPANY WHERE 1=1 ");
		
		List<Object> object = new ArrayList<Object>();
		if(null!= expressCompany.getContactPhone() && !"".equals(expressCompany.getContactPhone())){
			sql.append(" AND CONTACT_PHONE = ? "); 
			object.add(expressCompany.getContactPhone());
		}
		
		if(null!= expressCompany.getExcoName() && !"".equals(expressCompany.getExcoName())){
			sql.append(" AND EXCO_NAME LIKE '%").append(expressCompany.getExcoName()).append("%'"); 
		}
		
		try
		{
			items = jdbcTemplate.queryForInt(sql.toString(),object.toArray());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return items;
	}


	@Override
	public List<ExpressCompany> getCourierCompanies(int startInd, int pageSize,ExpressCompany expressCompany) throws Exception
	{
		List<ExpressCompany> ecs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT EXCO_ID, EXCO_NAME, CONTACTOR_NAME, CONTACT_PHONE, CONTACT_ADD, SERVICE_STATUS, CONTRACT_NO, VALID_DATE");
		sql.append(" FROM T_EXPRESS_COMPANY WHERE 1=1 ");
		
		
		List<Object> object = new ArrayList<Object>();
		if(null!= expressCompany.getContactPhone() && !"".equals(expressCompany.getContactPhone())){
			sql.append(" AND CONTACT_PHONE = ? "); 
			object.add(expressCompany.getContactPhone());
		}
		
		if(null!= expressCompany.getExcoName() && !"".equals(expressCompany.getExcoName())){
			sql.append(" AND EXCO_NAME LIKE '%").append(expressCompany.getExcoName()).append("%'"); 
		}
		
		object.add(startInd);
		object.add(pageSize);
		sql.append("  ORDER BY VALID_DATE LIMIT ?, ?");
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(),object.toArray());
			
			if(null != list && list.size() != 0)
			{
				ecs = new ArrayList<ExpressCompany>();
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					Map map = (Map) it.next();
					ExpressCompany ec = new ExpressCompany();
					ec.setExcoId(StringUtil.formatStringTrimToNull(map.get("EXCO_ID")));
					ec.setExcoName(StringUtil.formatStringTrimToNull(map.get("EXCO_NAME")));
					ec.setContactorName(StringUtil.formatStringTrimToNull(map.get("CONTACTOR_NAME")));
					ec.setContactPhone(StringUtil.formatStringTrimToNull(map.get("CONTACT_PHONE")));
					ec.setContactAdd(StringUtil.formatStringTrimToNull(map.get("CONTACT_ADD")));
					ec.setServiceStatus(StringUtil.formatStringToInteger(map.get("SERVICE_STATUS"), 0));
					ec.setContractNo(StringUtil.formatStringTrimToNull(map.get("CONTRACT_NO")));
					ec.setValidDate((Timestamp) map.get("VALID_DATE"));
					
					ecs.add(ec);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return ecs;
	}


	@Override
	public List<CourierGroupWrapper> getCourierGroupList(int startInd, int pageSize, GetCourierGroupParam gcgp) throws Exception
	{
		List<CourierGroupWrapper> cgws = null;
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT TEMP.*, DR2.DISTRICT_LEVEL, DR2.PARENT_D_ID, GD2.DISTRICT_NAME PARENT_NAME, DR2.PARENT_D_LEVEL");
		sql.append(" FROM (SELECT CG.GROUP_ID, CG.GROUP_NAME, CG.EXCO_ID, EC.EXCO_NAME, CG.PICK_CONTACTOR_M, CG.DISTRICT_ID, GD3.DISTRICT_NAME");
		sql.append(" FROM T_COURIER_GROUP CG, T_EXPRESS_COMPANY EC,T_GB_DISTRICT GD3");
		sql.append(" WHERE CG.EXCO_ID = EC.EXCO_ID AND CG.DISTRICT_ID = GD3.DISTRICT_ID");
		if(gcgp != null)
		{
			if(StringUtil.isNotBlank(gcgp.getGroupName()))
			{
				sql.append(" AND CG.GROUP_NAME LIKE ?");
				param.add("%"+gcgp.getGroupName()+"%");
			}
			if(StringUtil.isNotBlank(gcgp.getDistrictId()))
			{
				sql.append(" AND (EXISTS (SELECT DR.DISTRICT_ID FROM T_DISTRICT_RELA DR WHERE DR.PARENT_D_ID = ? AND DR.DISTRICT_ID = CG.DISTRICT_ID) OR CG.DISTRICT_ID = ?)");
				param.add(gcgp.getDistrictId());
				param.add(gcgp.getDistrictId());
			}
			if(StringUtil.isNotBlank(gcgp.getExcoId()))
			{
				sql.append(" AND CG.EXCO_ID = ?");
				param.add(gcgp.getExcoId());
			}
		}
		param.add(startInd);
		param.add(pageSize);
		sql.append(" ORDER BY GROUP_NAME LIMIT ?, ?) TEMP, T_DISTRICT_RELA DR2 LEFT JOIN T_GB_DISTRICT GD2 ON DR2.PARENT_D_ID = GD2.DISTRICT_ID");
		sql.append(" WHERE TEMP.DISTRICT_ID = DR2.DISTRICT_ID");
		sql.append(" ORDER BY TEMP.GROUP_ID, DR2.PARENT_D_LEVEL");
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(), param.toArray());
			
			if(null != list && list.size() != 0)
			{
				cgws = new ArrayList<CourierGroupWrapper>();
				Iterator it = list.iterator();
				CourierGroupWrapper cgwTemp = new CourierGroupWrapper();
				while(it.hasNext())
				{
					Map map = (Map) it.next();
					
					CourierGroupWrapper cgw = new CourierGroupWrapper();
					
					cgw.setGroupId(StringUtil.formatStringTrimToNull(map.get("GROUP_ID")));
					cgw.setGroupName(StringUtil.formatStringTrimToNull(map.get("GROUP_NAME")));
					cgw.setExcoId(StringUtil.formatStringTrimToNull(map.get("EXCO_ID")));
					cgw.setExcoName(StringUtil.formatStringTrimToNull(map.get("EXCO_NAME")));
					cgw.setPickContactorM(StringUtil.formatStringTrimToNull(map.get("PICK_CONTACTOR_M")));
					cgw.setDistrictId(StringUtil.formatStringTrimToNull(map.get("DISTRICT_ID")));
					cgw.setDistrictName(StringUtil.formatStringTrimToNull(map.get("DISTRICT_NAME")));
					
					int districtLevel = StringUtil.formatStringToInteger(map.get("DISTRICT_LEVEL"), 0);
					int parentLevel = StringUtil.formatStringToInteger(map.get("PARENT_D_LEVEL"), 0);
					String parentName = StringUtil.formatStringTrimToNull(map.get("PARENT_NAME"));
					
					if(districtLevel - parentLevel > 1)
					{
						cgw.setDistrictName(StringUtil.formatStringTrim(cgwTemp.getDistrictName()) + " " + StringUtil.formatStringTrim(parentName));
						cgwTemp = cgw;
					}
					if(districtLevel - parentLevel == 1)
					{
						cgw.setDistrictName(StringUtil.formatStringTrim(cgwTemp.getDistrictName()) + " " + StringUtil.formatStringTrim(parentName) + " " + StringUtil.formatStringTrim(cgw.getDistrictName()));
						cgwTemp = new CourierGroupWrapper();
						cgws.add(cgw);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return cgws;
	}


	public List<CourierGroup> getCourierGroupListByCouComId(String couComId) throws Exception
	{
		List<CourierGroup> cgs = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT CG.GROUP_ID, CG.GROUP_NAME, CG.EXCO_ID, CG.PICK_CONTACTOR_M, CG.DISTRICT_ID");
		sql.append(" FROM T_COURIER_GROUP CG WHERE CG.EXCO_ID = ?");
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{couComId});
			
			if(null != list && list.size() != 0)
			{
				cgs = new ArrayList<CourierGroup>();
				
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					Map map = (Map) it.next();
					
					CourierGroup cg = new CourierGroup();
					cg.setDistrictId(StringUtil.formatStringTrim(map.get("DISTRICT_ID")));
					cg.setExcoId(StringUtil.formatStringTrim(map.get("EXCO_ID")));
					cg.setGroupId(StringUtil.formatStringTrim(map.get("GROUP_ID")));
					cg.setGroupName(StringUtil.formatStringTrim(map.get("GROUP_NAME")));
					cg.setPickContactorM(StringUtil.formatStringTrim(map.get("PICK_CONTACTOR_M")));
					
					cgs.add(cg);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return cgs;
	}
	

	@Override
	public int getCourierGroupListSize(GetCourierGroupParam gcgp) throws Exception
	{
		int count = 0;
		List<Object> param = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(1) FROM T_COURIER_GROUP CG");
		sql.append(" WHERE 1 = 1");
		if(gcgp != null)
		{
			if(StringUtil.isNotBlank(gcgp.getGroupName()))
			{
				sql.append(" AND CG.GROUP_NAME LIKE ?");
				param.add("%"+gcgp.getGroupName()+"%");
			}
			if(StringUtil.isNotBlank(gcgp.getDistrictId()))
			{
				sql.append(" AND (EXISTS (SELECT DR.DISTRICT_ID FROM T_DISTRICT_RELA DR WHERE DR.PARENT_D_ID = ? AND DR.DISTRICT_ID = CG.DISTRICT_ID) OR CG.DISTRICT_ID = ?)");
				param.add(gcgp.getDistrictId());
				param.add(gcgp.getDistrictId());
			}
			if(StringUtil.isNotBlank(gcgp.getExcoId()))
			{
				sql.append(" AND CG.EXCO_ID = ?");
				param.add(gcgp.getExcoId());
			}
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
	public void updatePCourierSnapshotInfo(String userId, String snapshotId, String paperwork1Id, String paperwork2Id) throws Exception
	{
		List<Object> params = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE T_P_COURIER SET ");

		if(snapshotId != null)
		{
			sql.append("SNAPSHOT_PIC_ID = ?");
			if(params == null)
			{
				params = new ArrayList<Object>();
			}
			params.add(snapshotId);
		}
		if(paperwork1Id != null)
		{
			if(null != params)
			{
				sql.append(", ");
			}
			else
			{
				params = new ArrayList<Object>();
			}
			sql.append("PAPERWORK_PIC1_ID = ?");
			params.add(paperwork1Id);
		}
		if(paperwork2Id != null)
		{
			if(null != params)
			{
				sql.append(", ");
			}
			else
			{
				params = new ArrayList<Object>();
			}
			sql.append("PAPERWORK_PIC2_ID = ?");
			params.add(paperwork2Id);
		}
		
		if(params != null)
		{
			sql.append(" WHERE USER_ID = ?");
			params.add(userId);
			
			jdbcTemplate.update(sql.toString(), params.toArray());
		}
	}


	@Override
	public List<CourierWrapper> getCourierListLimit(cn.com.xb.domain.parameterWrapper.GetCourierListParam gclp, int startInd, int pageSize) throws Exception
	{
		List<CourierWrapper> cws = null;
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT PC.USER_ID, U.USER_NAME, U.PAPERWORK_NUM, U.MOBILE_NUMBER, PC.GROUP_ID, CG.GROUP_NAME, PC.EXCO_ID, EC.EXCO_NAME, PC.COURIER_STATUS");
		sql.append(" FROM T_P_COURIER PC, T_USER U, T_COURIER_GROUP CG, T_EXPRESS_COMPANY EC");
		sql.append(" WHERE PC.USER_ID = U.USER_ID AND PC.GROUP_ID = CG.GROUP_ID AND PC.EXCO_ID = EC.EXCO_ID");
		
		if(null != gclp)
		{
			if(StringUtil.isNotBlank(gclp.getUserName()))
			{
				params.add("%"+gclp.getUserName()+"%");
				sql.append(" AND U.USER_NAME LIKE ?");
			}
			if(StringUtil.isNotBlank(gclp.getPaperworkNum()))
			{
				params.add("%"+gclp.getPaperworkNum()+"%");
				sql.append(" AND U.PAPERWORK_NUM LIKE ?");
			}
			if(StringUtil.isNotBlank(gclp.getMobileNumber()))
			{
				params.add("%"+gclp.getMobileNumber()+"%");
				sql.append(" AND U.MOBILE_NUMBER LIKE ?");
			}
			if(StringUtil.isNotBlank(gclp.getExcoId()))
			{
				params.add(gclp.getExcoId());
				sql.append(" AND PC.EXCO_ID = ?");
			}
		}
		
		sql.append(" ORDER BY PC.USER_ID DESC");
		sql.append(" LIMIT ?, ?");

		params.add(startInd);
		params.add(pageSize);
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(), params.toArray());
			if(null != list)
			{
				cws = new ArrayList<CourierWrapper>();
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					Map map = (Map) it.next();
					CourierWrapper cw = new CourierWrapper();
					cw.setUserId(StringUtil.formatStringTrim(map.get("USER_ID")));
					cw.setUserName(StringUtil.formatStringTrim(map.get("USER_NAME")));
					cw.setPaperworkNum(StringUtil.formatStringTrim(map.get("PAPERWORK_NUM")));
					cw.setMobileNumber(StringUtil.formatStringTrim(map.get("MOBILE_NUMBER")));
					cw.setGroupId(StringUtil.formatStringTrim(map.get("GROUP_ID")));
					cw.setGroupName(StringUtil.formatStringTrim(map.get("GROUP_NAME")));
					cw.setExcoId(StringUtil.formatStringTrim(map.get("EXCO_ID")));
					cw.setExcoName(StringUtil.formatStringTrim(map.get("EXCO_NAME")));
					cw.setCourierStatus(StringUtil.formatStringToInteger(map.get("COURIER_STATUS"), 3));
					
					cws.add(cw);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return cws;
	}


	@Override
	public int getCourierSize(GetCourierListParam gclp) throws Exception
	{
		int count = 0;
		
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(1) CNT FROM T_P_COURIER PC, T_USER U WHERE PC.USER_ID = U.USER_ID");

		if(null != gclp)
		{
			if(StringUtil.isNotBlank(gclp.getUserName()))
			{
				params.add("%"+gclp.getUserName()+"%");
				sql.append(" AND U.USER_NAME LIKE ?");
			}
			if(StringUtil.isNotBlank(gclp.getPaperworkNum()))
			{
				params.add("%"+gclp.getPaperworkNum()+"%");
				sql.append(" AND U.PAPERWORK_NUM LIKE ?");
			}
			if(StringUtil.isNotBlank(gclp.getMobileNumber()))
			{
				params.add("%"+gclp.getMobileNumber()+"%");
				sql.append(" AND U.MOBILE_NUMBER LIKE ?");
			}
			if(StringUtil.isNotBlank(gclp.getExcoId()))
			{
				params.add(gclp.getExcoId());
				sql.append(" AND PC.EXCO_ID = ?");
			}
		}
		
		try
		{
			count = jdbcTemplate.queryForInt(sql.toString(), params.toArray());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}

	/**
	 * 获取某快递员的所有快照ID列，以XXXX,XXXX,XXXX的形式返回，便于查询
	 * @param userId
	 * @return
	 */
	public String selectSnapshotIDs(String userId)
	{
		String ids = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT CONCAT('\'',SNAPSHOT_PIC_ID,'\',\'',PAPERWORK_PIC1_ID,'\',\'',PAPERWORK_PIC2_ID,'\'') IDS FROM T_P_COURIER WHERE USER_ID = ?");
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{userId});
			if(null != list)
			{
				Map map = (Map) list.iterator().next();
				ids = StringUtil.formatStringTrim(map.get("IDS"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return ids;
	}
	

	@Override
	public void deleteCourierSnapshotInfo(String userId) throws Exception
	{
		
		String ids = selectSnapshotIDs(userId);
		StringBuffer sql = new StringBuffer();
		if(StringUtil.isNotBlank(ids))
		{
			sql.append("DELETE FROM T_BLOB_FILES WHERE FILE_ID IN (?)");
			
			jdbcTemplate.update(sql.toString(), new Object[]{ids});
		}
	}


	@Override
	public CourierWrapper getCourierWrapperInfo(String userId) throws Exception
	{
		CourierWrapper cw = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT TEMP.*, DR.DISTRICT_LEVEL, DR.PARENT_D_ID, GD.DISTRICT_NAME PARENT_NAME, DR.PARENT_D_LEVEL");
		sql.append(" FROM (SELECT PC.USER_ID, PC.GROUP_ID, CG.GROUP_NAME, PC.EXCO_ID, EC.EXCO_NAME, PC.COURIER_STATUS, PC.LOCALE_ID, GD1.DISTRICT_NAME LOCALE_NAME, PC.SNAPSHOT_PIC_ID,CONCAT(BF1.FILE_ID, BF1.FILE_SUFFIX) SNAPSHOT_PIC_NAME,");
		sql.append(" PC.PAPERWORK_PIC1_ID,CONCAT(BF2.FILE_ID, BF2.FILE_SUFFIX) PAPERWORK_PIC1_NAME, PC.PAPERWORK_PIC2_ID, CONCAT(BF3.FILE_ID, BF3.FILE_SUFFIX) PAPERWORK_PIC2_NAME,");
		sql.append(" U.USER_ACCOUNT, U.USER_TYPE, U.USER_NAME, U.GENDER, U.PAPERWORK_TYPE, U.PAPERWORK_NUM, U.MOBILE_NUMBER, U.EMAIL, U.QQ, U.WB, U.WEIXIN, U.HOUSEHOLD_REGISTER_ADDRESS, U.HABITUAL_RESIDENCE, U.ZIP_CODE, U.STATUS");
		sql.append(" FROM T_P_COURIER PC, T_USER U, T_COURIER_GROUP CG, T_EXPRESS_COMPANY EC, T_GB_DISTRICT GD1, T_BLOB_FILES BF1, T_BLOB_FILES BF2, T_BLOB_FILES BF3");
		sql.append(" WHERE PC.USER_ID = U.USER_ID AND PC.GROUP_ID = CG.GROUP_ID AND PC.EXCO_ID = EC.EXCO_ID AND PC.SNAPSHOT_PIC_ID = BF1.FILE_ID AND PC.PAPERWORK_PIC1_ID = BF2.FILE_ID");
		sql.append(" AND PC.PAPERWORK_PIC2_ID = BF3.FILE_ID AND PC.LOCALE_ID = GD1.DISTRICT_ID AND PC.USER_ID = ?) TEMP, T_DISTRICT_RELA DR LEFT JOIN T_GB_DISTRICT GD ON DR.PARENT_D_ID = GD.DISTRICT_ID");
		sql.append(" WHERE TEMP.LOCALE_ID = DR.DISTRICT_ID");
		sql.append(" ORDER BY DR.PARENT_D_LEVEL");
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{userId});
			
			if(null != list)
			{
				cw = new CourierWrapper();
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					Map map = (Map) it.next();
					cw.setUserId(StringUtil.formatStringTrim(map.get("USER_ID")));
					cw.setGroupId(StringUtil.formatStringTrim(map.get("GROUP_ID")));
					cw.setGroupName(StringUtil.formatStringTrim(map.get("GROUP_NAME")));
					cw.setExcoId(StringUtil.formatStringTrim(map.get("EXCO_ID")));
					cw.setExcoName(StringUtil.formatStringTrim(map.get("EXCO_NAME")));
					cw.setCourierStatus(StringUtil.formatStringToInteger(map.get("COURIER_STATUS"), 3));
					cw.setLocaleId(StringUtil.formatStringTrim(map.get("LOCALE_ID")));
					cw.setSnapshotPicId(StringUtil.formatStringTrim(map.get("SNAPSHOT_PIC_ID")));
					cw.setSnapshotPicPath(StringUtil.formatStringTrim(map.get("SNAPSHOT_PIC_NAME")));
					cw.setPaperworkPic1Id(StringUtil.formatStringTrim(map.get("PAPERWORK_PIC1_ID")));
					cw.setPaperworkPic1Path(StringUtil.formatStringTrim(map.get("PAPERWORK_PIC1_NAME")));
					cw.setPaperworkPic2Id(StringUtil.formatStringTrim(map.get("PAPERWORK_PIC2_ID")));
					cw.setPaperworkPic2Path(StringUtil.formatStringTrim(map.get("PAPERWORK_PIC2_NAME")));
					cw.setUserAccount(StringUtil.formatStringTrim(map.get("USER_ACCOUNT")));
					cw.setUserType(StringUtil.formatStringToInteger(map.get("USER_TYPE"), 2));
					cw.setUserName(StringUtil.formatStringTrim(map.get("USER_NAME")));
					cw.setGender(StringUtil.formatStringToInteger(map.get("GENDER"), 3));
					cw.setPaperworkType(StringUtil.formatStringToInteger(map.get("PAPERWORK_TYPE"), 1));
					cw.setPaperworkNum(StringUtil.formatStringTrim(map.get("PAPERWORK_NUM")));
					cw.setMobileNumber(StringUtil.formatStringTrim(map.get("MOBILE_NUMBER")));
					cw.setEmail(StringUtil.formatStringTrim(map.get("EMAIL")));
					cw.setQq(StringUtil.formatStringTrim(map.get("QQ")));
					cw.setWb(StringUtil.formatStringTrim(map.get("WB")));
					cw.setWeixin(StringUtil.formatStringTrim(map.get("WEIXIN")));
					cw.setHouseholdRegisterAddress(StringUtil.formatStringTrim(map.get("HOUSEHOLD_REGISTER_ADDRESS")));
					cw.setHabitualResidence(StringUtil.formatStringTrim(map.get("HABITUAL_RESIDENCE")));
					cw.setZipCode(StringUtil.formatStringTrim(map.get("ZIP_CODE")));
					cw.setStatus(StringUtil.formatStringToInteger(map.get("STATUS"), 4));
					

					String localeName = StringUtil.formatStringTrim(map.get("LOCALE_NAME"));
					int districtLevel = StringUtil.formatStringToInteger(map.get("DISTRICT_LEVEL"), 0);
					int parentLevel = StringUtil.formatStringToInteger(map.get("PARENT_D_LEVEL"), 0);
					String parentName = StringUtil.formatStringTrimToNull(map.get("PARENT_NAME"));
					
					if(districtLevel - parentLevel > 1)
					{
						cw.setLocaleName(StringUtil.formatStringTrim(cw.getLocaleName()) + " " + StringUtil.formatStringTrim(parentName));
					}
					if(districtLevel - parentLevel == 1)
					{
						cw.setLocaleName(StringUtil.formatStringTrim(cw.getLocaleName()) + " " + StringUtil.formatStringTrim(parentName) + " " + StringUtil.formatStringTrim(localeName));
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return cw;
	}


	@Override
	public void updateCourierInfo(PCourier courier) throws Exception
	{
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();

		sql.append("UPDATE T_P_COURIER SET");
		
		if(StringUtil.isNotBlank(courier.getGroupId()))
		{
			sql.append(" GROUP_ID = ?");
			params.add(courier.getGroupId());
		}
		if(StringUtil.isNotBlank(courier.getExcoId()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " EXCO_ID = ?");
			params.add(courier.getExcoId());
		}
		if(courier.getCourierStatus() != 0)
		{
			sql.append((params.size() != 0 ? " ," : "") + " COURIER_STATUS = ?");
			params.add(courier.getCourierStatus());
		}
		if(StringUtil.isNotBlank(courier.getLocaleId()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " LOCALE_ID = ?");
			params.add(courier.getLocaleId());
		}
		if(StringUtil.isNotBlank(courier.getSnapshotPicId()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " SNAPSHOT_PIC_ID = ?");
			params.add(courier.getSnapshotPicId());
		}
		if(StringUtil.isNotBlank(courier.getPaperworkPic1Id()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " PAPERWORK_PIC1_ID = ?");
			params.add(courier.getPaperworkPic1Id());
		}
		if(StringUtil.isNotBlank(courier.getPaperworkPic2Id()))
		{
			sql.append((params.size() != 0 ? " ," : "") + " PAPERWORK_PIC2_ID = ?");
			params.add(courier.getPaperworkPic2Id());
		}
		sql.append(" WHERE USER_ID = ?");
		params.add(courier.getUserId());
		
		jdbcTemplate.update(sql.toString(), params.toArray());
	}


	@Override
	public CourierWrapper getCourierSnapshotInfo(String userId) throws Exception
	{
		CourierWrapper cw = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT PC.SNAPSHOT_PIC_ID, CONCAT(BF1.FILE_ID, BF1.FILE_SUFFIX) FILE_NAME1, PC.PAPERWORK_PIC1_ID, CONCAT(BF2.FILE_ID, BF2.FILE_SUFFIX) FILE_NAME2, PC.PAPERWORK_PIC2_ID, CONCAT(BF3.FILE_ID, BF3.FILE_SUFFIX) FILE_NAME3  ");
		sql.append(" FROM T_P_COURIER PC, T_BLOB_FILES BF1, T_BLOB_FILES BF2, T_BLOB_FILES BF3");
		sql.append(" WHERE PC.SNAPSHOT_PIC_ID = BF1.FILE_ID AND PC.PAPERWORK_PIC1_ID = BF2.FILE_ID AND PC.PAPERWORK_PIC2_ID = BF3.FILE_ID AND PC.USER_ID = ?");
		
		try
		{
			List list = jdbcTemplate.queryForList(sql.toString(), new Object[]{userId});
			
			if(list != null && list.size() != 0)
			{
				cw = new CourierWrapper();
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					Map map = (Map) it.next();
					cw.setUserId(userId);
					cw.setSnapshotPicId(StringUtil.formatStringTrim(map.get("SNAPSHOT_PIC_ID")));
					cw.setSnapshotPicPath(StringUtil.formatStringTrim(Global.SNAP_PATH + map.get("FILE_NAME1")));
					cw.setPaperworkPic1Id(StringUtil.formatStringTrim(map.get("PAPERWORK_PIC1_ID")));
					cw.setPaperworkPic1Path(StringUtil.formatStringTrim(Global.PAPER_PATH + map.get("FILE_NAME2")));
					cw.setPaperworkPic2Id(StringUtil.formatStringTrim(map.get("PAPERWORK_PIC2_ID")));
					cw.setPaperworkPic2Path(StringUtil.formatStringTrim(Global.PAPER_PATH + map.get("FILE_NAME3")));
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return cw;
	}


	public int getCourierxItmes(Courierx courier) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT COUNT(1) ");
		sql.append(" FROM T_EXPRESS_COMPANY  B,T_GB_DISTRICT T,T_COURIER_GROUP A  LEFT JOIN ");
		sql.append(" (SELECT C.GROUP_ID,C.SS_ID FROM T_STORAGESTATION_DELIVERY_G C,T_STORAGESTATION D WHERE C.SS_ID = D.SS_ID) E ");
		sql.append(" ON E.GROUP_ID = A.GROUP_ID WHERE A.EXCO_ID = B.EXCO_ID AND T.DISTRICT_ID=A.DISTRICT_ID ");
		
		List<Object> params = new ArrayList<Object>();
		
		if(!"".equals(courier.getGroupName())){
			sql.append(" AND A.GROUP_NAME LIKE '%").append(courier.getGroupName()).append("%'");
		}
		if(!"".equals(courier.getDistrictId())){
			sql.append(" AND (A.DISTRICT_ID IN(SELECT FI.DISTRICT_ID FROM T_DISTRICT_RELA FI WHERE FI.PARENT_D_ID = ? ) OR A.DISTRICT_ID = ? ) ");
			params.add(courier.getDistrictId());
			params.add(courier.getDistrictId());
		}
		
		return jdbcTemplate.queryForInt(sql.toString(),params.toArray());
	}


	public List<Courierx> getCourierxList(Courierx courier,Page page)throws Exception {
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		
		sql.append(" SELECT TEMP.*, DR.DISTRICT_LEVEL, DR.PARENT_D_ID, GD.DISTRICT_NAME PARENT_NAME, DR.PARENT_D_LEVEL FROM ");
		sql.append(" ( SELECT A.GROUP_ID,A.DISTRICT_ID,T.DISTRICT_NAME,A.GROUP_NAME,B.CONTACTOR_NAME,B.CONTACT_PHONE,B.CONTACT_ADD,B.EXCO_NAME,E.SS_ID,MAX(E.SS_ID=?) CK ");
		sql.append(" FROM T_EXPRESS_COMPANY  B,T_GB_DISTRICT T,T_COURIER_GROUP A  LEFT JOIN ");
		sql.append(" (SELECT C.GROUP_ID,C.SS_ID FROM T_STORAGESTATION_DELIVERY_G C,T_STORAGESTATION D WHERE C.SS_ID = D.SS_ID AND C.EXE_PERMISSION=?) E ");
		sql.append(" ON E.GROUP_ID = A.GROUP_ID WHERE A.EXCO_ID = B.EXCO_ID AND T.DISTRICT_ID=A.DISTRICT_ID  ");
		
		params.add(courier.getSsId());
		params.add(courier.getExePermission());
		
		if(!"".equals(courier.getGroupName())){
			sql.append(" AND A.GROUP_NAME LIKE '%").append(courier.getGroupName()).append("%'");
		}
		if(!"".equals(courier.getDistrictId())){
			sql.append(" AND (A.DISTRICT_ID IN(SELECT FI.DISTRICT_ID FROM T_DISTRICT_RELA FI WHERE FI.PARENT_D_ID = ? ) OR A.DISTRICT_ID = ? )");
			params.add(courier.getDistrictId());
			params.add(courier.getDistrictId());
		}

		sql.append(" GROUP BY GROUP_ID ");
		sql.append(" ORDER BY (E.SS_ID=?) DESC LIMIT ?,? ) TEMP ");
		params.add(courier.getSsId());
		params.add(page.getStartItems());
		params.add(page.getPageSize());
		
		//查询具体地址
		sql.append(" , T_DISTRICT_RELA DR LEFT JOIN T_GB_DISTRICT GD ON DR.PARENT_D_ID = GD.DISTRICT_ID ");
		sql.append(" WHERE TEMP.DISTRICT_ID = DR.DISTRICT_ID ORDER BY TEMP.CK DESC,TEMP.GROUP_ID,DR.PARENT_D_LEVEL ");
		
		List<Courierx> lists = new ArrayList<Courierx>();
		List mapList = jdbcTemplate.queryForList(sql.toString(), params.toArray());
		Iterator it = mapList.iterator();
		Courierx _courierxTemp = new Courierx();
		while(it.hasNext()){
			Map map = (Map) it.next();
			Courierx _courierx = new Courierx();
			_courierx.setGroupId((String)map.get("GROUP_ID"));
			_courierx.setGroupName((String)map.get("GROUP_NAME"));
			_courierx.setContactorName((String)map.get("CONTACTOR_NAME"));
			_courierx.setContactorPhone((String)map.get("CONTACT_PHONE"));
			_courierx.setContactorAddress((String)map.get("CONTACT_ADD"));
			_courierx.setExcoName((String)map.get("EXCO_NAME"));
			_courierx.setSsId((String)map.get("SS_ID"));
			String ck = map.get("CK")==null?"":map.get("CK").toString();
			_courierx.setCheck(ck);
			_courierx.setDistrictId((String)map.get("DISTRICT_ID"));
			//_courierx.setDistrictName((String)map.get("DISTRICT_NAME"));
			
			String localeName = StringUtil.formatStringTrim(map.get("DISTRICT_NAME"));
			int districtLevel = StringUtil.formatStringToInteger(map.get("DISTRICT_LEVEL"), 0);
			String parentName = StringUtil.formatStringTrimToNull(map.get("PARENT_NAME"));		
			int parentLevel = StringUtil.formatStringToInteger(map.get("PARENT_D_LEVEL"), 0);	
			if(districtLevel - parentLevel > 1)
			{
				_courierx.setDistrictName(StringUtil.formatStringTrim(_courierxTemp.getDistrictName()) + " " + StringUtil.formatStringTrim(parentName));
				_courierxTemp = _courierx;
			}
			if(districtLevel - parentLevel == 1)
			{
				_courierx.setDistrictName(StringUtil.formatStringTrim(_courierxTemp.getDistrictName()) + " " + StringUtil.formatStringTrim(parentName) + " " + StringUtil.formatStringTrim(localeName));
				_courierxTemp = new Courierx();
				lists.add(_courierx);	
			}
		}
		return lists;
	}


	@Override
	public List<ICourierAuthorityInfo> getCourierInfoBySSid(String ssId,int exePermission) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT B.USER_ID,B.COURIER_STATUS,C.EXCO_NAME,TEMP.EXE_PERMISSION,D.USER_NAME,D.EMAIL,D.MOBILE_NUMBER,  ");
		sql.append(" F.AGENCY_NAME,E.CARD_ID,E.USER_ID,E.DESCRIPTION,E.CARD_CODE,E.CARD_PWD,E.CARD_TYPE,E.ISSUED_AGENCY, ");
		sql.append(" E.EXPIRATION_DATE,E.CARD_STATUS ");
		sql.append(" FROM T_P_COURIER B,(");
		sql.append(" SELECT A.GROUP_ID,A.EXE_PERMISSION FROM T_STORAGESTATION_DELIVERY_G A WHERE A.SS_ID = ? ");
		if(exePermission!=0){
			sql.append(" AND A.EXE_PERMISSION = "+exePermission);
		}
		sql.append(" ) TEMP,T_EXPRESS_COMPANY C,T_USER D LEFT JOIN T_AUTH_CARD E ON D.USER_ID = E.USER_ID ");
		sql.append( " LEFT JOIN T_ISSUED_AGENCY F ON E.ISSUED_AGENCY = F.AGENCY_ID ");
		sql.append( " WHERE B.GROUP_ID = TEMP.GROUP_ID AND B.EXCO_ID = C.EXCO_ID AND D.USER_ID = B.USER_ID ");
				
		List<ICourierAuthorityInfo> lists = new ArrayList<ICourierAuthorityInfo>();
		List mapList = jdbcTemplate.queryForList(sql.toString(),new String[]{ssId});
		Iterator it = mapList.iterator();
		while(it.hasNext()){
			Map map = (Map) it.next();
			ICourierInfo courierInfo = new ICourierInfo();
			courierInfo.setCourierId((String)map.get("USER_ID"));
			courierInfo.setStatus(Integer.parseInt(map.get("COURIER_STATUS").toString()));
			courierInfo.setExcoName((String)map.get("EXCO_NAME"));
			String perMission = map.get("EXE_PERMISSION").toString();
			courierInfo.setName((String)map.get("USER_NAME"));
			courierInfo.setEmail((String)map.get("EMAIL"));
			courierInfo.setMobilePhone((String)map.get("MOBILE_NUMBER"));
			
			ICourierCardInfo cardInfo = new ICourierCardInfo();
			cardInfo.setCardId((String)map.get("CARD_ID"));
			cardInfo.setCourierId((String)map.get("USER_ID"));
			cardInfo.setDescription((String)map.get("DESCRIPTION"));
			cardInfo.setCardCode((String)map.get("CARD_CODE"));
			cardInfo.setCardPwd((String)map.get("CARD_PWD"));
			
			Object carType = map.get("CARD_TYPE")==null?"0":map.get("CARD_TYPE");
			cardInfo.setCardType(StringUtil.formatStringToInteger(carType,0));
			cardInfo.setIssuedAgency((String)map.get("ISSUED_AGENCY"));
			
			Object cardStatus = map.get("CARD_STATUS")==null?"0":map.get("CARD_STATUS");
			cardInfo.setValidFlag(StringUtil.formatStringToInteger(cardStatus, 0));
			cardInfo.setExpirationDate(StringUtil.formatStringToDate(map.get("EXPIRATION_DATE"), "yyyy-MM-dd HH:mm:ss", null));
			ICourierAuthorityInfo courierAuthorityInfo = new ICourierAuthorityInfo();
			courierAuthorityInfo.setAuthorityType(Integer.parseInt(perMission));
			courierAuthorityInfo.setCourierInfo(courierInfo);
			courierAuthorityInfo.setCourierCardInfo(cardInfo);
			lists.add(courierAuthorityInfo);
		}
		return lists;
	}
}
