package cn.com.xb.dao.impl;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import  cn.com.xb.dao.IFeeProofDao;
import  cn.com.xb.domain.base.FeeProof;

public class FeeProofDaoImpl implements IFeeProofDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public  List<FeeProof> loadAll() throws Exception {
		 String sql ="SELECT * FROM T_FEE_PROOF";
		 List<FeeProof> list = new ArrayList<FeeProof>();
		 List<FeeProof> mapList = jdbcTemplate.queryForList(sql);
		 Iterator it = mapList.iterator();
		 
		 while (it.hasNext()) { 
			 Map map = (Map) it.next();
			 FeeProof feeproof = fetch(map); 
			 list.add(feeproof); 
		 }
		 return list;
	}
	
	public FeeProof loadFeeProofByfeeId(String feeId) throws Exception {
		 FeeProof feeproof = null;
		 String sql ="SELECT * FROM T_FEE_PROOF WHERE FEE_ID = ? ";
		 Object[] values = new Object[]{feeId};
		 Map map = null;
		 try{ 
			 map = jdbcTemplate.queryForMap(sql, values);
		 } catch (DataAccessException e) {
			 return null;
		 }
		 feeproof = fetch(map);
		 return feeproof;
	}
	
	public int loadItems() throws Exception{
		int items = 0;
		String sql = "SELECT COUNT(*) CNT FROM T_FEE_PROOF";
		items = jdbcTemplate.queryForInt(sql);
		return items;
	}
	
	public  void delete(String feeId) throws Exception{
		 String sql ="DELETE FROM T_FEE_PROOF WHERE FEE_ID=?";
		 Object[] values = new Object[] { feeId };
		 jdbcTemplate.update(sql, values);

	}
	
	public  void update(FeeProof feeproof) throws Exception{
		 String sql ="UPDATE T_FEE_PROOF SET TRANS_ID= ?,TRANS_ACTION_ID= ?,PAY_METHODS= ?,AMOUNT= ?,VOUCHER_ID= ?,VOUCHER_TOTAL= ?,BOX_FEE_ID= ?,PAY_TYPE= ?,PAY_DESC= ? WHERE FEE_ID=?";
		 Object[] values = new Object[] {feeproof.getTransId(),feeproof.getTransActionId(),feeproof.getPayMethods(),feeproof.getAmount(),feeproof.getVoucherId(),feeproof.getVoucherTotal(),feeproof.getBoxFeeId(),feeproof.getPayType(),feeproof.getPayDesc(),feeproof.getFeeId()};
		 jdbcTemplate.update(sql, values);
	}
	
	public  void insert(FeeProof feeproof) throws Exception{
		 String sql ="INSERT INTO T_FEE_PROOF(FEE_ID,TRANS_ID,TRANS_ACTION_ID,PAY_METHODS,AMOUNT,VOUCHER_ID,VOUCHER_TOTAL,BOX_FEE_ID,PAY_TYPE,PAY_DESC) VALUES(?,?,?,?,?,?,?,?,?,?)";
		 Object[] values = new Object[] {feeproof.getFeeId(),feeproof.getTransId(),feeproof.getTransActionId(),feeproof.getPayMethods(),feeproof.getAmount(),feeproof.getVoucherId(),feeproof.getVoucherTotal(),feeproof.getBoxFeeId(),feeproof.getPayType(),feeproof.getPayDesc()};
		 jdbcTemplate.update(sql, values);

	}	
	
	public FeeProof fetch(Map map) throws Exception{
		FeeProof feeproof = new FeeProof();		
		feeproof.setFeeId((String)map.get("FEE_ID"));
		feeproof.setTransId((String)map.get("TRANS_ID"));
		feeproof.setTransActionId((String)map.get("TRANS_ACTION_ID"));
		feeproof.setPayMethods(Integer.parseInt(map.get("PAY_METHODS").toString()));
		feeproof.setAmount(Double.parseDouble(map.get("AMOUNT").toString()));
		feeproof.setVoucherId((String)map.get("VOUCHER_ID"));
		feeproof.setVoucherTotal(Integer.parseInt(map.get("VOUCHER_TOTAL").toString()));
		feeproof.setBoxFeeId((String)map.get("BOX_FEE_ID"));
		feeproof.setPayType(Integer.parseInt(map.get("PAY_TYPE").toString()));
		feeproof.setPayDesc((String)map.get("PAY_DESC"));
		return feeproof;
	}
}
