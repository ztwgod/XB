package cn.com.xb.util;

import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class ClientProperty {

	private static Properties selfProperty = null; 

	public static String getProperty(String bundleName, String key) {		
		if (selfProperty == null) {
			selfProperty = getPropObjFromBundle(bundleName);
		}
		return selfProperty.getProperty(key);
	}

	private static Properties getPropObjFromBundle(String bundleName) {
		Properties objProp = new Properties();
		PropertyResourceBundle bundle = (PropertyResourceBundle) PropertyResourceBundle.getBundle(bundleName);
		Enumeration<String> enm = bundle.getKeys();
		while (enm.hasMoreElements()) {
			String key = (String) enm.nextElement();
			String value = bundle.getString(key);
			objProp.setProperty(key, value);
		}
		return objProp;
	}
}
