package cn.com.xb.daox.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.xb.dao.impl.PSysDaoImpl;
import cn.com.xb.daox.ISysUserDaox;
import cn.com.xb.inter.domain.ISysUserAuthorityInfo;
import cn.com.xb.inter.domain.ISysUserCardInfo;
import cn.com.xb.inter.domain.ISysUserInfo;
import cn.com.xb.util.StringUtil;

public class SysUserDaoxImpl extends PSysDaoImpl implements ISysUserDaox {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<ISysUserAuthorityInfo> getSysUserAuthorityInfos(String ssId) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.USER_ID USERID,B.USER_NAME,B.MOBILE_NUMBER,B.HABITUAL_RESIDENCE,B.EMAIL,B.STATUS,C.CARD_ID, ");
		sql.append(" C.CARD_CODE,C.CARD_PWD,C.USER_ID,C.DESCRIPTION,C.CARD_TYPE,C.ISSUED_AGENCY,C.EXPIRATION_DATE,C.CARD_STATUS ");
		sql.append(" FROM T_SYSUSER_STORAGESTATION A,T_USER B LEFT JOIN T_AUTH_CARD C ON C.USER_ID = B.USER_ID   ");
		sql.append(" WHERE A.USER_ID = B.USER_ID AND A.SS_ID = ? ");
		List<ISysUserAuthorityInfo> lists = jdbcTemplate.queryForList(sql.toString(),new String[]{ssId});
		Iterator iter = lists.iterator();
		List<ISysUserAuthorityInfo> authorityInfos = new ArrayList<ISysUserAuthorityInfo>();
		while(iter.hasNext()){
			Map map = (Map) iter.next();
			ISysUserInfo sysUserInfo = new ISysUserInfo();
			sysUserInfo.setSysUserId(map.get("USERID").toString());
			sysUserInfo.setAddress((String)map.get("HABITUAL_RESIDENCE"));
			sysUserInfo.setEmail((String)map.get("EMAIL"));
			sysUserInfo.setMobilePhone((String)map.get("MOBILE_NUMBER"));
			sysUserInfo.setName((String)map.get("USER_NAME"));
			sysUserInfo.setStatus(map.get("STATUS").toString());
			
			ISysUserCardInfo sys = new ISysUserCardInfo();
			sys.setCardId((String)map.get("CARD_ID"));
			sys.setCardCode((String)map.get("CARD_CODE"));
			sys.setCardPwd((String)map.get("CARD_PWD"));
			sys.setUserId((String)map.get("USER_ID"));
			sys.setDescription((String)map.get("DESCRIPTION"));
			
			Object carType = map.get("CARD_TYPE")==null?"0":map.get("CARD_TYPE");
			sys.setCardType(StringUtil.formatStringToInteger(carType,0));
			sys.setIssuedAgency((String)map.get("ISSUED_AGENCY"));
			Object cardStatus = map.get("CARD_STATUS")==null?"0":map.get("CARD_STATUS");
			sys.setValidFlag(StringUtil.formatStringToInteger(cardStatus, 0));
			Object expirationDate = map.get("EXPIRATION_DATE");
			sys.setExpirationDate((String)expirationDate);
			
			ISysUserAuthorityInfo auth = new ISysUserAuthorityInfo();
			auth.setSysUserCardInfo(sys);
			auth.setSysUserInfo(sysUserInfo);
			
			//权限类型（1，可开启任意物箱；2，只允许开启特定状态物箱；3，只允许开启某一个物箱、或多个指定物箱）一期只支持第一种
			auth.setAuthorityType(1); //一期为固定值1
			authorityInfos.add(auth);
		}
		return authorityInfos;
	}
}
