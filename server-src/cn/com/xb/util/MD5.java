package cn.com.xb.util;

import java.security.MessageDigest;

public class MD5 {

	/**
	 * MD5 加密
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if(Integer.toHexString(0xFF & byteArray[i]).length() == 1){
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			}else{
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}				
		}
		return md5StrBuff.toString();
	}
	
	public static String sign(String src){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(src.getBytes());
			byte[] b_md5 = md.digest();
			StringBuilder sbuilder = new StringBuilder();
			for(byte b:b_md5){
				String tmp = Integer.toHexString(b & 0xff);
				if(tmp.length() == 1){
					sbuilder.append("0");
				}
				sbuilder.append(tmp);
			}
			return sbuilder.toString().toLowerCase();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String sign(String str,String key){
		String temp = str+key;
		System.out.println(temp);
		String md5Msg = sign(temp);
		return md5Msg;
	}
}
