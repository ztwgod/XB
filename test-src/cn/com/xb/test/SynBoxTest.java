package cn.com.xb.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.com.xb.inter.domain.IDeviceStatus;
import cn.com.xb.inter.domain.request.StorageStationStatusWrapper;
import cn.com.xb.util.DateTools;
import cn.com.xb.util.XstreamUtil;

public class SynBoxTest {

	/**
	 * 同步箱子信息
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		StorageStationStatusWrapper wrapper = new StorageStationStatusWrapper();
		wrapper.setClientUploadTime(DateTools.formatDateToString(new Date(), DateTools.FORMAT_YYYYMMDD_HHMMSS));
		
		//外围设备运行状态列表(存放内容<外围设备Code,状态>)
		List<IDeviceStatus>	peripheralRunStatus = new ArrayList<IDeviceStatus>();
		IDeviceStatus dev1 = new IDeviceStatus("1",3);
		IDeviceStatus dev2 = new IDeviceStatus("2",3);
		IDeviceStatus dev3 = new IDeviceStatus("3",3);
		IDeviceStatus dev4 = new IDeviceStatus("4",3);
		
		IDeviceStatus dev5 = new IDeviceStatus("5",3);
		IDeviceStatus dev6 = new IDeviceStatus("6",3);
		IDeviceStatus dev7 = new IDeviceStatus("7",3);
		IDeviceStatus dev8 = new IDeviceStatus("8",4);
		peripheralRunStatus.add(dev1);
		peripheralRunStatus.add(dev2);
		peripheralRunStatus.add(dev3);
		peripheralRunStatus.add(dev4);
		peripheralRunStatus.add(dev5);
		peripheralRunStatus.add(dev6);
		peripheralRunStatus.add(dev7);
		peripheralRunStatus.add(dev8);
		
		//普通柜子运行状态列表(存放内容<主控柜子Code,状态>)
		List<IDeviceStatus>	cabinetContainerStatus = new ArrayList<IDeviceStatus>();
		IDeviceStatus cab1 = new IDeviceStatus("1",2);
		IDeviceStatus cab2 = new IDeviceStatus("2",2);
		cabinetContainerStatus.add(cab1);
		cabinetContainerStatus.add(cab2);
		
		//箱子存货状态【1,空闲;2,占用;3,占用超时;4,占用超期】
		List<IDeviceStatus>	boxLoadStatus = new ArrayList<IDeviceStatus>();
		IDeviceStatus box1 = new IDeviceStatus("10001",3);
		boxLoadStatus.add(box1);
		
		//箱子运行状态：空闲、占用、占用超时、占用超期、开启、故障、租用、预留、闭塞、未关闭、被破坏、维修
		List<IDeviceStatus>	boxRunStatus = new ArrayList<IDeviceStatus>();
		IDeviceStatus box = new IDeviceStatus("10001",3);
		boxRunStatus.add(box);
		
		wrapper.setCabinetContainerStatus(cabinetContainerStatus);
		wrapper.setPeripheralRunStatus(peripheralRunStatus);
		wrapper.setBoxLoadStatus(boxLoadStatus);
		wrapper.setBoxRunStatus(boxRunStatus);
		
		wrapper.setStorageStationId("100001");
		wrapper.setGuiSequenceNumber("10000000001");
		wrapper.setSequenceNumber(2);
		wrapper.setStorageStationStatus(2);
		
		List<Class> classs = new ArrayList<Class>();
		classs.add(StorageStationStatusWrapper.class);
		classs.add(IDeviceStatus.class);
		String json = XstreamUtil.javaBean2JETTSON(wrapper, classs);
		System.out.println(json);
	}
}
