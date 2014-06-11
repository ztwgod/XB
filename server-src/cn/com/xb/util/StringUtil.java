package cn.com.xb.util;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 字符串处理工具
 * @author DIGUA
 */
public class StringUtil
{
	private StringUtil()
	{
	}
	
	public static String formatIntToString(int i, int len)
	{
		String strI = "" + i;
		int x = len - strI.length();
		for (int n = 0; n < x; n++)
		{
			strI = "0" + strI;
		}
		return strI;
	}

	/**
	 * 判断字符串str是否为null，或是空字符串
	 * @param str
	 * @return
	 * @author DIGUA 20120106
	 */
	public static boolean isNull(Object str){
		return str == null ? true : "".equals(str);
	}
	
	/**
	 * 判断字符串str是否为null，或是空字符串
	 * @param str
	 * @return
	 * @author DIGUA 20120106
	 */
	public static boolean isNotNull(Object str){
		return !isNull(str);
	}
	
	/**
	 * 判断字符串str是否为null，或是空字符串，或是空格字符串
	 * @param str
	 * @return
	 * @author DIGUA 20120106
	 */
	public static boolean isBlank(Object str){
		return str == null ? true : "".equals(str.toString().trim());
	}
	
	/**
	 * 判断字符串str是否不为null，也不为空字符串，也不为空格字符串
	 * @param str
	 * @return
	 * @author DIGUA 20120106
	 */
	public static boolean isNotBlank(Object str){
		return !isBlank(str);
	}
	
	/**
	 * __未实现__
	 * 获取字符串长度【英文字母和数字当做0.5的长度】
	 * @param str
	 * @return
	 * @deprecated
	 */
	public static int getStringRealLength(Object str)
	{
		int len = 0;
		
		if(isNotBlank(str))
		{
			
		}
		
		return len;
	}
	
	
	/**
	 * 去String的前len位，若不足，全取<br>
	 * 若字符串中含有字母数字，则算0.5的长度（未实现）
	 * @param str
	 * @param len
	 * @return
	 */
	public static String getStringOfLen(Object str, int len)
	{
		if(isNotBlank(str))
		{
			String string = formatStringTrim(str);
			
			if(string.length() > len)
			{
				string = string.substring(0, len);
			}
			
			return string;
		}
		else
		{
			return "";
		}
	}
	
	/**
	 * 处理字符串对象，去掉前后空格 
	 * 若字符串为null则返回null
	 * 
	 * @param strObj
	 * @return
	 * @author DIGUA 20120106
	 */
	public static String formatStringTrimToNull(Object strObj)
	{
		if (isBlank(strObj))
		{
			return null;
		}
		return strObj.toString().trim();
	}

	/**
	 * 去掉字符串前后空格 若字符串为null则返回空字符串
	 * 
	 * @param strObj
	 * @return
	 * @author DIGUA 20120106
	 */
	public static String formatStringTrim(Object strObj)
	{
		if (isBlank(strObj))
			return "";
		return strObj.toString().trim();
	}
	
	/**
	 * 判断数组arr是否为null，或是长度为0
	 * @param arr
	 * @return
	 * @author DIGUA 20120106
	 */
	public static boolean isEmptyArray(Object arr[]){
		return arr == null ? true : arr.length == 0;
	}
	
	/**
	 * 判断数组arr不为null,并且长度不为0
	 * @param arr
	 * @return
	 * @author DIGUA 20120106
	 */
	public static boolean isNotEmptyArray(Object arr[]){
		return !isEmptyArray(arr);
	}
	
	/**
	 * 字符串数组转换为List
	 * @param arr
	 * @return
	 * @author DIGUA 20120106
	 */
	public static List asList(String arr[])
	{
		List list = null;
		if (isNotEmptyArray(arr))
		{
			list = new ArrayList();
			for (int i = 0; i < arr.length; i++)
			{
				list.add(formatStringTrim(arr[i]));
			}
		}
		return list;
	}
	
	/**
	 * 截取字符串str为List字符串
	 * @param str
	 * @param delimiter
	 * @return
	 * @author DIGUA 20120106
	 */
	public static List splitToList(String str, String delimiter){
		List strList = null;
		if(isNotBlank(str) && isNotNull(delimiter)){
			String strArr[] = str.split(delimiter);
			if(isNotEmptyArray(strArr)){
				strList = asList(strArr);
			}
		}
		return strList;
	}
	
	/**
	 * 判断str是否为list中的一项
	 * @param list
	 * @param str
	 * @return
	 */
	public static boolean checkStrInList(List list, String str){
		if(isNull(str)){
			return false;
		}
		if(list == null || list.size() == 0){
			return false;
		}
		Iterator it = list.iterator();
		while(it.hasNext()){
			if(str.equals(it.next())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 将list转换为以separator分割的字符串
	 * @param list
	 * @param separator
	 * @return
	 */
	public static String arraysToString(List list, String separator){
		String arrString = null;
		if(null != list && list.size() != 0){
			Iterator it = list.iterator();
			while(it.hasNext()){
				if(arrString == null){
					arrString = String.valueOf(it.next());
				}else{
					arrString += separator + it.next().toString().trim();
				}
			}
		}
		return arrString;
	}
	
	/**
	 * 将String类型的数字转换成整型，若字符串为空，或出现异常，则返回预订的表示为空的数字nullNum
	 * @param str
	 * @param nullNum
	 * @return
	 */
	public static int formatStringToInteger(Object str, int nullNum)
	{
		if(isBlank(str))
		{
			return nullNum;
		}
		try{
			return Integer.parseInt(str.toString());
		}catch(Exception e){
			return nullNum;
		}
	}
	
	/**
	 * 将String类型的日期转换成Date类型，若字符串为空，或出现异常，则返回预订的表示为空的日期nullDate
	 * @param date
	 * @param formater
	 * @param nullDate
	 * @return
	 */
	public static Date formatStringToDate(Object date, String formater, Date nullDate)
	{
		if(isBlank(date) || isBlank(formater))
		{
			return nullDate;
		}
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(formater);
			return sdf.parse(formatStringTrim(date));
		}catch(Exception e){
			return nullDate;
		}
	}
	
	/**
	 * 将String类型的日期转换成Timestamp类型，若字符串为空，或出现异常，则返回预订的表示为空的日期nullTime
	 * @param date
	 * @param formater
	 * @param nullDate
	 * @return
	 */
	public static Timestamp formatStringToTimestamp(Object time, String formater, Timestamp nullTime)
	{
		if(isBlank(time) || isBlank(formater))
		{
			return nullTime;
		}
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(formater);
			return new Timestamp(sdf.parse(formatStringTrim(time)).getTime());
		}catch(Exception e){
			return nullTime;
		}
	}
	
	/**
	 * 将String类型的数字转换成双精度浮点型，若字符串为空，或出现异常，则返回预订的表示为空的数字nullNum
	 * @param str
	 * @param nullNum
	 * @return
	 */
	public static double formatStringToDouble(Object str, double nullNum)
	{
		if(isBlank(str))
		{
			return nullNum;
		}
		try{
			return Double.parseDouble(str.toString());
		}catch(Exception e){
			return nullNum;
		}
	}
	
	
	/** 
     * 使用Java反射来获取被拦截方法参数值， 
     * 将参数值拼接为操作内容 
     */  
	public static String getOptionContent(Object[] args) throws Exception
	{
		if (args == null)
		{
			return null;
		}
		StringBuffer rs = new StringBuffer();
		String className = null;
		int index = 1;
		// 遍历参数对象
		for (Object info : args)
		{
			if(null != info)
			{
				// 获取对象类型
				className = info.getClass().getName();
				className = className.substring(className.lastIndexOf(".") + 1);
				rs.append("[参数" + index + "，类型：" + className + "，值：");
				
				//20140408添加：判断参数是否为String类型
				if(className.equalsIgnoreCase("String")){
					rs.append(info);
					continue;
				}
				
	
				// 获取对象的所有方法
				Method[] methods = info.getClass().getDeclaredMethods();
	
				// 遍历方法，判断get方法
				for (Method method : methods)
				{
	
					String methodName = method.getName();
					// 判断是不是get方法
					if (methodName.indexOf("get") == -1)	// 不是get方法
					{
						continue;// 不处理
					}
	
					Object rsValue = null;
					try
					{
	
						// 调用get方法，获取返回值
						rsValue = method.invoke(info);
	
						if (rsValue == null)	// 没有返回值
						{
							continue;
						}
	
					}
					catch (Exception e)
					{
						continue;
					}
	
					// 将值加入内容中
					rs.append("(" + methodName + " : " + rsValue + ")");
				}
	
				rs.append("]");
	
				index++;
			}
		}

		return rs.toString();
	}
	
	/**
	 * 补零方法
	 * @param lenght
	 * @param str
	 * @return
	 */
	public static String appendZero(int lenght,String str){
		StringBuffer buffer = new StringBuffer(str);
		for (int i = 0; i < lenght-str.length(); i++) {
			buffer.insert(0, "0");
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		String s = StringUtil.appendZero(4, 12+"");
		System.out.println(s);
	}
	
}
