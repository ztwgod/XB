package cn.com.xb.util;


public class ExportToXml {

	public static void main(String[] args) {
		/*StorageStationInfo ssi = new StorageStationInfo();
		
		MainCabinetContainer mcc = new MainCabinetContainer();
		mcc.setControlCabinetLocation("01010101");
		Computer c = new Computer();
		c.setType(1);
		c.setVersion("1.0.0.11");
		c.setStatus(1);
		IdReader ir = new IdReader();
		ir.setType(2);
		ir.setVersion("1.0.0.12");
		ir.setStatus(1);
		DimensionalCodeReader dcr = new DimensionalCodeReader();
		dcr.setType(3);
		dcr.setVersion("1.0.0.13");
		dcr.setStatus(1);
		InfraredIdentification ii = new InfraredIdentification();
		ii.setType(4);
		ii.setVersion("1.0.0.14");
		ii.setStatus(1);
		AutomaticCashMachine acm = new AutomaticCashMachine();
		acm.setType(5);
		acm.setVersion("1.0.0.15");
		acm.setStatus(1);
		SecurityCamera sc = new SecurityCamera();
		sc.setType(6);
		sc.setVersion("1.0.0.16");
		sc.setStatus(1);
		TouchScreen ts = new TouchScreen();
		ts.setType(7);
		ts.setVersion("1.0.0.17");
		ts.setStatus(1);
		AlarmSystem as = new AlarmSystem();
		as.setType(8);
		as.setVersion("1.0.0.18");
		as.setStatus(1);

		mcc.setComputer(c);
		mcc.setIdReader(ir);
		mcc.setDimensionalCodeReader(dcr);
		mcc.setInfraredIdentification(ii);
		mcc.setAutomaticCashMachine(acm);
		mcc.setSecurityCamera(sc);
		mcc.setTouchScreen(ts);
		mcc.setAlarmSystem(as);
		
		CabinetContainer cc = new CabinetContainer();
		List<BoxInfo> bis = new ArrayList<BoxInfo>();
		for(int i=0; i<10; i++)
		{
			BoxInfo bi = new BoxInfo();
			bi.setBoxId("000"+(i+1));
			bi.setBoxType(i%2);
			bi.setBoxStatus(i/2);
			bis.add(bi);
		}
		
		cc.setCabinetIndex(111);
		cc.setType(2);
		cc.setVersion("1.0.1.2");
		cc.setStatus(1);
		cc.setCabinetWidth(6);
		cc.setCabinetHeight(10);
		cc.setBoxNumber(3);
		cc.setBoxInfos(bis);

		ssi.setCountryCode("0001");
		ssi.setRegionCode("0002");
		ssi.setAreaCode("0003");
		ssi.setStorageStationCode("0004");
		ssi.setStorageStationType(1);
		ssi.setStorageStationVersion("1.0.0.1");
		ssi.setStorageStationStatus(1);
		ssi.setIpAddress("10.1.11.110:89");
		ssi.setPhyLinkType(2);
		ssi.setMainCabinetContainer(mcc);
		ssi.setCabinetContainer(cc);
		
		XStream xstream = new XStream();
		
		String xml = xstream.toXML(ssi);
		System.out.println(xml);*/
	}
}
