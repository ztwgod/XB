package cn.com.xb.inter.util;

import java.util.HashMap;
import java.util.Map;

public class AppResponseUtil {

	//key:当比请求交易随机码  value: 交易结果
	private static Map<String, String> RESPONSES = new HashMap<String, String>(); 
	
	public static String getValue(String key){
		return RESPONSES.get(key);
	}
	
	public static void putValue(String key,String value){
		RESPONSES.put(key, value);
	}
	
	public static void removeValue(String key){
		RESPONSES.remove(key);
	}
	
	public static void claer(){
		RESPONSES.clear();
	}
}
