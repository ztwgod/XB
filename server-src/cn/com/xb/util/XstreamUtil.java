package cn.com.xb.util;

import java.util.List;

import cn.com.xb.inter.domain.request.RemoteUnpackeInfoWarpper;
import cn.com.xb.inter.domain.response.RemoteUnpackeInfoResult;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class XstreamUtil {

	/**
	 * 对象转换为Json格式
	 * @param object
	 * @param _class
	 * @return
	 */
	public static String javaBean2JETTSON(Object object,Class _class){
		String jsttson = "";
		//JsonHierarchicalStreamDriver JettisonMappedXmlDriver
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias(_class.getSimpleName(),_class);  
	    jsttson = xstream.toXML(object);
	    return jsttson;
	}
	
	/**
	 * 对象转换为Json格式
	 * @param object
	 * @param _class
	 * @return
	 */
	public static String javaBean2JETTSON(Object object,List<Class> classs){
		String jsttson = "";
		//JsonHierarchicalStreamDriver JettisonMappedXmlDriver
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		for (Class _class : classs) {
			xstream.alias(_class.getSimpleName(), _class);
		}
	    jsttson = xstream.toXML(object);
	    return jsttson;
	}
	
	
	/**
	 * Json格式数据转换为对象
	 * @param jsonString
	 * @param _class
	 * @return
	 */
	public static Object JETTSON2JavaBean(String jsonString,Class _class){
		Object _object = new Object();
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias(_class.getSimpleName(), _class);  
		_object = xstream.fromXML(jsonString);
		return _object;
	}
	
	/**
	 * Json格式数据转换为对象(复杂对象转换)
	 * @param jsonString
	 * @param _class
	 * @return
	 */
	public static Object JETTSON2JavaBean(String jsonString,List<Class> classs){
		Object _object = new Object();
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		for (Class _class : classs) {
			xstream.alias(_class.getSimpleName(), _class);
		}
		_object = xstream.fromXML(jsonString);
		return _object;
	}
	
	public static void main(String[] args) {
		RemoteUnpackeInfoWarpper remoteUnpackeInfoWarpper = new RemoteUnpackeInfoWarpper();
		remoteUnpackeInfoWarpper.setBoxCode("1");
		remoteUnpackeInfoWarpper.setRandomNum("2009");
		remoteUnpackeInfoWarpper.setSequenceNumber(2);
		remoteUnpackeInfoWarpper.setStorageStationId("1000000002001001");
		remoteUnpackeInfoWarpper.setTransactionID("0000000001");
		remoteUnpackeInfoWarpper.setUserId("12660E2343D90");
		
		RemoteUnpackeInfoWarpper remoteUnpackeInfoWarpper2 = new RemoteUnpackeInfoWarpper();
		remoteUnpackeInfoWarpper2.setBoxCode("2");
		remoteUnpackeInfoWarpper2.setRandomNum("2019");
		remoteUnpackeInfoWarpper2.setSequenceNumber(4);
		remoteUnpackeInfoWarpper2.setStorageStationId("1000021312312301");
		remoteUnpackeInfoWarpper2.setTransactionID("0001230001");
		remoteUnpackeInfoWarpper2.setUserId("432660E2123D90");
		
		RemoteUnpackeInfoResult result = new RemoteUnpackeInfoResult();
		result.setResultStatus(0);
		result.setSequenceNumber(1);
		
		String str = XstreamUtil.javaBean2JETTSON(remoteUnpackeInfoWarpper2,RemoteUnpackeInfoWarpper.class);
		System.out.println(str);
		
		/*Test test = new Test();
		test.setRemoteUnpackeInfoResult(result);
		test.setTestId("10010");
		
		List<RemoteUnpackeInfoWarpper> lists1 = new ArrayList<RemoteUnpackeInfoWarpper>();
		lists1.add(remoteUnpackeInfoWarpper);
		lists1.add(remoteUnpackeInfoWarpper2);
		test.setLists(lists1);
		
		String str = XstreamUtil.javaBean2JETTSON(test,Test.class);
		System.out.println(str);
		
		List<Class> classs = new ArrayList<Class>();
		classs.add(Test.class);
		classs.add(RemoteUnpackeInfoWarpper.class);
		classs.add(RemoteUnpackeInfoResult.class);
		
		String temp = "{\"Test\":{\"testId\":10010,\"lists\":{\"RemoteUnpackeInfoWarpper\":[{\"userId\":\"12660E2343D90\",\"sequenceNumber\":2,\"storageStationId\":1000000002001001,\"boxCode\":1,\"randomNum\":2009,\"transactionID\":\"0000000001\"},{\"userId\":\"432660E2123D90\",\"sequenceNumber\":4,\"storageStationId\":1000021312312301,\"boxCode\":2,\"randomNum\":2019,\"transactionID\":\"0001230001\"}]},\"remoteUnpackeInfoResult\":{\"sequenceNumber\":1,\"resultStatus\":0}}}";
		Test _test = (Test) XstreamUtil.JETTSON2JavaBean(temp,classs);
		
		List<RemoteUnpackeInfoWarpper> re = _test.getLists();
		for (RemoteUnpackeInfoWarpper remoteUnpackeInfoWarpper3 : re) {
			System.out.println(remoteUnpackeInfoWarpper3.toString());
		}
		System.out.println(_test.getRemoteUnpackeInfoResult().toString());
		System.out.println(_test.getTestId());*/
	}
}