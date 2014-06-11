package cn.com.xb.test;

import java.util.Date;

import cn.com.xb.inter.domain.request.CalculateCourierCostsWrapper;
import cn.com.xb.util.DateTools;
import cn.com.xb.util.XstreamUtil;

public class CalculateCourierCostsTest {

	/**
	 * 计算快递费用
	 * @param args
	 */
	
	public static void main(String[] args) {
		CalculateCourierCostsWrapper wraper = new CalculateCourierCostsWrapper();
		wraper.setCityCode("310100");
		wraper.setClientUploadTime(DateTools.formatDateToString(new Date(), DateTools.FORMAT_YYYYMMDD_HHMMSS));
		wraper.setDistrictCountyCode("310115");
		wraper.setExpressSizeType(1);
		wraper.setProvinceCode("310000");
		wraper.setSequenceNumber(0);
		wraper.setStorageStationId("100001");
		wraper.setGuiSequenceNumber("10000000001");
		
		String json = XstreamUtil.javaBean2JETTSON(wraper, CalculateCourierCostsWrapper.class);
		System.out.println(json);
		
	}
}
