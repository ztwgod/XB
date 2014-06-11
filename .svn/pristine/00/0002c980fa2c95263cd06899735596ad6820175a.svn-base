package cn.com.xb.util;

import java.io.File;

public class PathUtility {
	
	public static String getRealPath(String filePath){
		String pa = new String(filePath);
		try {			
			String realPath = null;
			if(filePath == null){
				return null;
			}
			
			//获取当前class的路径
			String path = PathUtility.class.getResource("PathUtility.class").getPath();
//		System.out.println(path);
//		System.out.println(path.substring(0, path.indexOf("WEB-INF")));
//		File file = new File(path);
//		System.out.println(file.getPath());
			
//		将filePath中的所有‘/’,‘\’ 转换为 File.separator
//			System.out.println("pa:::"+pa);
			if(pa.indexOf("/") != -1){
				pa = pa.replace('/', File.separatorChar);
			}
			if(pa.indexOf("\\") != -1){
				pa = pa.replace('\\', File.separatorChar);
			}
//		System.out.println(filePath);
			
//		将filePath中最前面的‘\’去掉
			if(pa.indexOf(File.separator) == 0){
				pa = pa.substring(1);
			}
//		System.out.println(filePath);
			
			//截取path至项目目录下
			path = path.substring(0, path.indexOf("WEB-INF"));
			
			//将path中所有的‘/’转换为‘\’
			if(path.indexOf("/") != -1){
				path = path.replace('/', File.separatorChar);
			}
			if(path.indexOf("\\") != -1){
				path = path.replace('\\', File.separatorChar);
			}
//		System.out.println(path);
			
			if(path != null && !path.equals("") && filePath != null){
				realPath = path+pa;
			}
			
			//System.out.println("pa:"+pa);
			//System.out.println("realPath:"+realPath);
			return realPath;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in getRealPath! filePath = " + filePath);
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getRealPathNew(String filePath){
		String newPath = "";
		String path = PathUtility.class.getClassLoader().getResource("/").getPath();
		String pattern1 = "[/\\\\]WEB-INF[/\\\\]classes[/\\\\]";
		String pattern2 = "[/\\\\]WEB-INF[/\\\\]classes";
		if (path.endsWith(File.separator) || path.endsWith("/")) {
			newPath = path.replaceAll(pattern1, "") + File.separator;
		}else {
			newPath = path.replaceAll(pattern2, "") + File.separator;
		}
		if (!filePath.equals("/") && !filePath.equals(File.separator)) {
			newPath = newPath + filePath;
		}
		return newPath;
	}
	
	public static void main(String[] args) {
		//getRealPath(null);
		/*System.out.println(File.separator.equals("/"));
		System.out.println(File.separator.equals("\\"));
		System.out.println(getRealPath("/"));
		
		File file = new File(getRealPath("index.jsp"));
		System.out.println(file.getPath());
		System.out.println(file.length());*/
		
		//String str = "\\userfiles\\fuck\\xiaoliangliang";
		//System.out.println(str.replace('/', '\\'));
		//System.out.println(str.replace(File.separatorChar, '/'));
		//System.out.println(str.substring(1));
		
		//System.out.println(File.separatorChar);
		//System.out.println(File.separator);
		
//		System.out.println(str.indexOf("/"));
		//System.out.println(File.separator);
		//System.out.println(getRealPath(str));
	}
}
