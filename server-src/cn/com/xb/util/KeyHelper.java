package cn.com.xb.util;

import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;



/**
 * 主键生成策略
 * @author OS-Dev
 *
 */
public class KeyHelper {
	

	/**
	 * @param String
	 * 功能描述 ：生成一个不重复的字符串
	 */

	public static String creatKey() 
	{
		String key = "";
		String s = getRandomNumber(5);
		key = HEX() + s;
		return key;
	}
	
	public static String HEX(){
		return Long.toHexString(new Date().getTime());
	}
	
	public static String creatKey(int len){
		String key = getRandomNumber(len);
		return key;
	}
	
	/**
	 * @param String
	 * 功能描述 ：得到一个cnt位的随机�?
	 */
	private static String getRandomNumber(int cnt) {
		int j = cnt;
		long[] random = new long[j];
		for (int i = 0; i < j; i++) 
		{
			random[i] = Math.round(Math.floor((Math.random() * 10)));
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < random.length; i++) 
		{
			String temp = Long.toString(random[i]);
			sb.append(temp);
		}
		return sb.toString();
	}
	
	/**
	 * 获取seq中的ID
	 * @param seqname
	 * @param jdbcTemplate
	 * @return
	 */
	public static long getSeqId(String seqname, JdbcTemplate jdbcTemplate) {
		String seqsql = "select "+ seqname +".nextVal from dual";
		long seqid = jdbcTemplate.queryForLong(seqsql);
		return seqid;
	}
	
	public static void main(String[] args) {
		System.out.println(KeyHelper.creatKey());;
	}
	
}
