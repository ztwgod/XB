package cn.com.xb.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.com.xb.domain.base.Transaction;
import cn.com.xb.inter.domain.IAddresseeInfo;
import cn.com.xb.inter.domain.IBoxInfo;
import cn.com.xb.inter.domain.ICabinetContainer;
import cn.com.xb.inter.domain.ICourierInfo;
import cn.com.xb.inter.domain.IPeripheral;
import cn.com.xb.inter.domain.ISenderInfo;
import cn.com.xb.inter.domain.IStorageStationInfo;
import cn.com.xb.inter.domain.ITransactionInfo;
import cn.com.xb.inter.domain.request.SynchWrapper;
import cn.com.xb.inter.domain.request.TransactionWrapper;
import cn.com.xb.util.DateTools;
import cn.com.xb.util.XstreamUtil;

public class SynTransactionTest {
	/**
	 * 交易同步测试
	 * @param args
	 */
	
	public static void main(String[] args) throws Exception{
		
		int seqNum = 0;		// 序列号
		int transType = 1;	// 1，成功：寄件人寄件；2，成功：快递员取件；3，成功：快递员投件；4，成功：收件人收件；5，成功：寄存人寄件；6，成功：寄存人取件；7，无空箱：寄件人寄件；8，无空箱：快递员投件；9，无空箱：寄存；10，退件：快递员投件；11，退件：寄存人寄件
		String ssCode = "31010100010101";	// 物箱Code
		//Date clientTime = new Date();
		//Date clientUploadTime = new Date();
		
		// 发件人信息
		ISenderInfo sender = new ISenderInfo();
		sender.setName("张三");
		sender.setMobilePhone("13808020386");
		sender.setEmail("zhangsan@live.cn");
		sender.setAddress("上海市 浦东新区 浙桥路3号");
		
		// 收件人信息
		IAddresseeInfo addressee = new IAddresseeInfo();
		addressee.setName("张三");
		addressee.setMobilePhone("13808020386");
		addressee.setEmail("lisi@163.com");
		addressee.setAddress("上海市 黄浦区 南京东路5号");
		
		// 快递员信息
//		ICourierInfo courier = new ICourierInfo();
//		courier.setCourierId("142eaf4446b79729");
//		courier.setName("刘亮");
//		courier.setMobilePhone("13987877875");
//		courier.setEmail("admin@qq.com");
//		courier.setExcoName("如风快递");
		
		
		// 交易信息
		ITransactionInfo ti = new ITransactionInfo();
		ti.setTransactionID("TRANS_00004");
		ti.setBoxCode("3101100001010201014");
		ti.setSupplierId("000000");		
		ti.setExpressDeliveryId("142082b2e0f78581");
//		ti.setExpressCode("010101010103");	// 快递单号
		ti.setExpressDescription("电子器件");	// 快件描述
		ti.setStorageTime(360);	// 默认存放时长[min]
		ti.setPastDueTime(0);
		ti.setTotalAmount(10);	// 本单交易总金额
		ti.setPayType(1);	// 支付款项类型[1，正常支付；2，逾期支付；3，退还金额]
		ti.setPayMode(1);	// 支付方式（1，投币；2，平台支付；）
		//ti.setVoucherId("");
		//ti.setVoucherTotal(0);
		ti.setPayPrice(3);	// 本次花费
		ti.setPickupPassword("123456");
		ti.setIsStandardsCompliant(0);	// 物品是否符合标准资费 [快递员取件时使用]（1，符合；2，不符合）
		ti.setNotStandardsCompliantCause("");
		ti.setExpressSizeType(3);	// 尺寸类型（1,超大/2,大/3,中/4,小/5,超小）
		
		ti.setSenderInfo(sender);
		ti.setAddresseeInfo(addressee);
//		ti.setCourierInfo(courier);
		
		
		// 交易封装信息
		TransactionWrapper tw = new TransactionWrapper();
		tw.setSequenceNumber(seqNum);
		tw.setTransActionType(transType);
		tw.setStorageStationId(ssCode);
		tw.setClientTime(DateTools.formatDateToString(new Date(), DateTools.FORMAT_YYYYMMDD_HHMMSS));
		tw.setClientUploadTime(DateTools.formatDateToString(new Date(), DateTools.FORMAT_YYYYMMDD_HHMMSS));
		tw.setTransactionInfo(ti);
		
		
		
		
		List<Class> classs = new ArrayList<Class>();
		classs.add(ISenderInfo.class);
		classs.add(IAddresseeInfo.class);
		classs.add(ICourierInfo.class);
		classs.add(ITransactionInfo.class);
		classs.add(TransactionWrapper.class);
		
		String str = XstreamUtil.javaBean2JETTSON(tw,classs);
		System.out.println(str.trim());
	}
}
