package cn.com.xb.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.com.xb.inter.domain.IBoxInfo;
import cn.com.xb.inter.domain.ICabinetContainer;
import cn.com.xb.inter.domain.IPeripheral;
import cn.com.xb.inter.domain.IStorageStationInfo;
import cn.com.xb.inter.domain.request.SynchWrapper;
import cn.com.xb.util.DateTools;
import cn.com.xb.util.XstreamUtil;

public class SynTest {
	
	private final static String SS_CODE = "31010100010101"; //物箱ID
	
	private final static String CAB_CODE_01 = SS_CODE+"01"; //柜子
	private final static String CAB_CODE_02 = SS_CODE+"02";

	/**
	 * 物箱同步测试
	 * @param args
	 */
	
	public static void main(String[] args) throws Exception{
		
		//2大 3中 4小
		IBoxInfo box1 = new IBoxInfo(CAB_CODE_01+"001", "001","20201231001", 2, 1, 1);//大
		
		IBoxInfo box2 = new IBoxInfo(CAB_CODE_01+"002", "002", "20201231002", 3, 1, 1);//中
		IBoxInfo box3 = new IBoxInfo(CAB_CODE_01+"003", "003", "20201231003", 3, 1, 1);
		IBoxInfo box4 = new IBoxInfo(CAB_CODE_01+"004", "004", "20201231004", 3, 1, 6);
		IBoxInfo box5 = new IBoxInfo(CAB_CODE_01+"005", "005", "20201231005", 3, 1, 1);
		IBoxInfo box6 = new IBoxInfo(CAB_CODE_01+"006", "006", "20201231006", 3, 1, 2);
		
		IBoxInfo box7 =  new IBoxInfo(CAB_CODE_01+"007", "007", "20201231007", 4, 1, 1);//小
		IBoxInfo box8 =  new IBoxInfo(CAB_CODE_01+"008", "008", "20201231008", 4, 1, 6);
		IBoxInfo box9 =  new IBoxInfo(CAB_CODE_01+"009", "009", "20201231009", 4, 1, 6);
		IBoxInfo box10 = new IBoxInfo(CAB_CODE_01+"010", "010", "20201231010", 4, 1, 2);
		
		IBoxInfo box11 = new IBoxInfo(CAB_CODE_01+"011", "011", "20201231011", 2, 1, 1);//大
		
		IBoxInfo box12 = new IBoxInfo(CAB_CODE_01+"012", "012", "20201231012", 3, 1, 1);//中
		IBoxInfo box13 = new IBoxInfo(CAB_CODE_01+"013", "013", "20201231013", 3, 1, 1);
		IBoxInfo box14 = new IBoxInfo(CAB_CODE_01+"014", "014", "20201231014", 3, 1, 1);
		IBoxInfo box15 = new IBoxInfo(CAB_CODE_01+"015", "015", "20201231015", 3, 1, 1);
		IBoxInfo box16 = new IBoxInfo(CAB_CODE_01+"016", "016", "20201231016", 3, 1, 1);
		
		IBoxInfo box17 = new IBoxInfo(CAB_CODE_01+"017", "017", "20201231017", 4, 1, 1);//小
		IBoxInfo box18 = new IBoxInfo(CAB_CODE_01+"018", "018", "20201231018", 4, 1, 1);
		IBoxInfo box19 = new IBoxInfo(CAB_CODE_01+"019", "019", "20201231019", 4, 1, 1);
		IBoxInfo box20 = new IBoxInfo(CAB_CODE_01+"020", "020", "20201231020", 4, 1, 1);
		
		List<IBoxInfo> boxInfos = new ArrayList<IBoxInfo>();
		boxInfos.add(box1);
		boxInfos.add(box2);
		boxInfos.add(box3);
		boxInfos.add(box4);
		boxInfos.add(box5);
		boxInfos.add(box6);
		boxInfos.add(box7);
		boxInfos.add(box8);
		boxInfos.add(box9);
		boxInfos.add(box10);
		
		boxInfos.add(box11);
		boxInfos.add(box12);
		boxInfos.add(box13);
		boxInfos.add(box14);
		boxInfos.add(box15);
		boxInfos.add(box16);
		boxInfos.add(box17);
		boxInfos.add(box18);
		boxInfos.add(box19);
		boxInfos.add(box20);
		
		IBoxInfo box21 = new IBoxInfo(CAB_CODE_02+"021", "021", "20201231021", 2, 1, 1);
		
		IBoxInfo box22 = new IBoxInfo(CAB_CODE_02+"022", "022", "20201231022", 3, 1, 1);
		IBoxInfo box23 = new IBoxInfo(CAB_CODE_02+"023", "023", "20201231023", 3, 1, 1);
		IBoxInfo box24 = new IBoxInfo(CAB_CODE_02+"024", "024", "20201231024", 3, 1, 1);
		IBoxInfo box25 = new IBoxInfo(CAB_CODE_02+"025", "025", "20201231025", 3, 1, 1);
		IBoxInfo box26 = new IBoxInfo(CAB_CODE_02+"026", "026", "20201231026", 3, 1, 1);
		
		IBoxInfo box27 =  new IBoxInfo(CAB_CODE_02+"027", "027", "20201231027", 4, 1, 1);
		IBoxInfo box28 =  new IBoxInfo(CAB_CODE_02+"028", "028", "20201231028", 4, 1, 1);
		IBoxInfo box29 =  new IBoxInfo(CAB_CODE_02+"029", "029", "20201231029", 4, 1, 1);
		IBoxInfo box30 =  new IBoxInfo(CAB_CODE_02+"030", "030", "20201231030", 4, 1, 1);
		
		IBoxInfo box31 = new IBoxInfo(CAB_CODE_02+"031", "031", "20201231031", 2, 1, 1);
		
		IBoxInfo box32 = new IBoxInfo(CAB_CODE_02+"032", "032", "20201231032", 3, 1, 1);
		IBoxInfo box33 = new IBoxInfo(CAB_CODE_02+"033", "033", "20201231033", 3, 1, 1);
		IBoxInfo box34 = new IBoxInfo(CAB_CODE_02+"034", "034", "20201231034", 3, 1, 1);
		IBoxInfo box35 = new IBoxInfo(CAB_CODE_02+"035", "035", "20201231035", 3, 1, 1);
		IBoxInfo box36 = new IBoxInfo(CAB_CODE_02+"036", "036", "20201231036", 3, 1, 1);
		
		IBoxInfo box37 = new IBoxInfo(CAB_CODE_02+"037", "037", "20201231037", 4, 1, 1);
		IBoxInfo box38 = new IBoxInfo(CAB_CODE_02+"038", "038", "20201231038", 4, 1, 1);
		IBoxInfo box39 = new IBoxInfo(CAB_CODE_02+"039", "039", "20201231039", 4, 1, 1);
		IBoxInfo box40 = new IBoxInfo(CAB_CODE_02+"040", "040", "20201231040", 4, 1, 1);
		
		List<IBoxInfo> boxInfos1 = new ArrayList<IBoxInfo>();
		boxInfos1.add(box21);
		boxInfos1.add(box22);
		boxInfos1.add(box23);
		boxInfos1.add(box24);
		boxInfos1.add(box25);
		boxInfos1.add(box26);
		boxInfos1.add(box27);
		boxInfos1.add(box28);
		boxInfos1.add(box29);
		boxInfos1.add(box30);
		
		boxInfos1.add(box31);
		boxInfos1.add(box32);
		boxInfos1.add(box33);
		boxInfos1.add(box34);
		boxInfos1.add(box35);
		boxInfos1.add(box36);
		boxInfos1.add(box37);
		boxInfos1.add(box38);
		boxInfos1.add(box39);
		boxInfos1.add(box40);
		
		
		/**
		 * 柜子信息
		 */
		ICabinetContainer iContainer1 = new ICabinetContainer(CAB_CODE_01, "01", "1.0", "20180909001", 20, 200, 20, 1, boxInfos,1);
		ICabinetContainer iContainer2 = new ICabinetContainer(CAB_CODE_02, "03", "1.0", "20180909002", 20, 200, 20, 1, boxInfos1,2);
		List<ICabinetContainer> iList = new ArrayList<ICabinetContainer>();
		iList.add(iContainer1);
		iList.add(iContainer2);
		
		
		IPeripheral per1 = new IPeripheral(SS_CODE+"001", "工控计算机", "20131029001", 1, "1.0", null, null, 1, "工控计算机");
		IPeripheral per2 = new IPeripheral(SS_CODE+"002", "读卡器", "20131029002", 2, "1.0", null, null, 2, "读卡器");
		IPeripheral per3 = new IPeripheral(SS_CODE+"003", "二维码识别器", "20131029003", 3, "1.0", null, null, 3, "二维码识别器");
		IPeripheral per4 = new IPeripheral(SS_CODE+"004", "红外识别", "20131029004", 4, "1.0", null, null, 4, "红外识别");
		IPeripheral per5 = new IPeripheral(SS_CODE+"005", "钱币识别", "20131029005", 5, "1.0", null, null, 5, "钱币识别");
		IPeripheral per6 = new IPeripheral(SS_CODE+"006", "摄像头", "20131029006", 6, "1.0", null, null, 6, "摄像头");
		IPeripheral per7 = new IPeripheral(SS_CODE+"007", "触摸屏", "20131029007", 7, "1.0", null, null, 7, "触摸屏");
		IPeripheral per8 = new IPeripheral(SS_CODE+"008", "报警", "20131029008", 8, "1.0", null, null, 8, "报警");
		List<IPeripheral> perList = new ArrayList<IPeripheral>();
		perList.add(per1);
		perList.add(per2);
		perList.add(per3);
		perList.add(per4);
		perList.add(per5);
		perList.add(per6);
		perList.add(per7);
		perList.add(per8);
		
		/**
		 * 物箱信息
		 */
		IStorageStationInfo iStorageStation = new IStorageStationInfo();
		iStorageStation.setAssetSn("20160909000101");
		iStorageStation.setAvailableBoxNum(40);
		iStorageStation.setControlCabinetLocation(2);
		iStorageStation.setDataCard("13657563345");
		iStorageStation.setInstallDate(DateTools.formatDateToString(new Date(), DateTools.FORMAT_YYYYMMDD_HHMMSS));
		iStorageStation.setIpAddress("58.247.79.82");
		iStorageStation.setLatitude(23.009801);
		iStorageStation.setLongitude(131.232108);
		iStorageStation.setPhyLinkType(2); //1:GE/FE  2:无线数据卡  3:WLAN
		iStorageStation.setPort("808");
		//iStorageStation.setStorageStationIndex("1");
		iStorageStation.setStorageStationStatus(1);
		iStorageStation.setStorageStationType("1");
		iStorageStation.setStorageStationVersion("1.0.10");
		iStorageStation.setPeripherals(perList);//外围设备
		iStorageStation.setCabinetContainers(iList);//柜子
		
		SynchWrapper syn = new SynchWrapper();
		syn.setSequenceNumber(1);
		syn.setStorageStationId(SS_CODE); //物箱代码
		syn.setStorageStation(iStorageStation);
		//同步类型  1，注册、新建；2，注册、故障恢复；3，注册、重启；4，注册、其他原因；5，同步、周期；6，同步、派件；7，同步、取件；8，同步、故障
		syn.setSynchType(1); 
		syn.setTime(DateTools.formatDateToString(new Date(), DateTools.FORMAT_YYYYMMDD_HHMMSS));
		syn.setGuiSequenceNumber("10000000001");
		
		List<Class> classs = new ArrayList<Class>();
		classs.add(IStorageStationInfo.class);
		classs.add(IPeripheral.class);
		classs.add(ICabinetContainer.class);
		classs.add(IBoxInfo.class);
		classs.add(SynchWrapper.class);
		
		String str = XstreamUtil.javaBean2JETTSON(syn,classs);
		System.out.println(str.trim());
	}
}
