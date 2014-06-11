package cn.com.xb.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTools {
	
	public final static String FORMAT_YYYYMMDD = "yyyy-MM-dd";
	public final static String FORMAT_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * formatStr yyyy-MM-dd HH:mm:ss 或者
	 * @param strDate
	 * @param formatStr
	 * @return
	 */
	public static Date formatStringToDate(String strDate,String formatStr) {
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		if(strDate.indexOf("-")==-1 && strDate.length()==8){
			//格式化字符串如：将19820202格式化为1985-02-02
			StringBuffer _format = new StringBuffer();
			_format.append(strDate.substring(0, 4)).append("-").append(strDate.substring(4, 6)).append("-").append(strDate.substring(6, 8));
			strDate = _format.toString();
		}
		try {
			date = format.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	/**
	 * String类型的日期转换为Timestamp
	 * @param ctime
	 * @param formatStr
	 * @return
	 */
	public static Timestamp formatStringToTimestamp(Object ctime,String formatStr){
		if(null==ctime || "".equals(ctime)){
			return null;
		}else{
			try {
				Date date = formatStringToDate(ctime.toString(),formatStr);
				Timestamp ts = new Timestamp(date.getTime());
				return ts;
			} catch (Exception e) {
				return null;
			}
		}		
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            需要格式化的日期
	 * @return
	 * 
	 */
	public static String formatDateToString(Date date,String formatStr) {
		//新加时区解决new Date()获取到的日期跟实际日期不匹配问题
		SimpleDateFormat format = new SimpleDateFormat(formatStr,Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String strDate = format.format(date);
		return strDate;
	}

	
	public static void main(String[] args) {
		
	}
}
