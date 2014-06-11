package cn.com.xb.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class CheckFileType
{
	/**
	 * JPEG (jpg)，文件头：FFD8FF 
	 * PNG (png)，文件头：89504E47 
	 * GIF (gif)，文件头：47494638 
	 * TIFF (tif)，文件头：49492A00 
	 * Windows Bitmap (bmp)，文件头：424D 
	 * CAD (dwg)，文件头：41433130
	 * Adobe Photoshop (psd)，文件头：38425053 
	 * Rich Text Format (rtf)，文件头：7B5C727466
	 * XML (xml)，文件头：3C3F786D6C 
	 * HTML (html)，文件头：68746D6C3E 
	 * Email [thorough only] (eml)，文件头：44656C69766572792D646174653A 
	 * Outlook Express (dbx)，文件头：CFAD12FEC5FD746F 
	 * Outlook (pst)，文件头：2142444E 
	 * MS Word/Excel (xls.or.doc)，文件头：D0CF11E0 
	 * MS Access (mdb)，文件头：5374616E64617264204A
	 * WordPerfect (wpd)，文件头：FF575043 
	 * Postscript (eps.or.ps)，文件头：252150532D41646F6265
	 * Adobe Acrobat (pdf)，文件头：255044462D312E 
	 * Quicken (qdf)，文件头：AC9EBD8F 
	 * Windows Password (pwl)，文件头：E3828596 
	 * ZIP Archive (zip)，文件头：504B0304 
	 * RAR Archive (rar)，文件头：52617221 
	 * Wave (wav)，文件头：57415645 
	 * AVI (avi)，文件头：41564920 
	 * Real Audio (ram)，文件头：2E7261FD 
	 * Real Media (rm)，文件头：2E524D46 
	 * MPEG (mpg)，文件头：000001BA 
	 * MPEG (mpg)，文件头：000001B3 
	 * Quicktime (mov)，文件头：6D6F6F76
	 * Windows Media (asf)，文件头：3026B2758E66CF11 
	 * MIDI (mid)，文件头：4D546864
	 */

	// 判断文件为图片
	public static final String TYPE_IMG_JPG = "ffd8"; // jpg文件头
	public static final String TYPE_IMG_PNG = "8950"; // png文件头
	public static final String TYPE_IMG_BMP = "424d"; // bmp文件头
	public static final String TYPE_IMG_GIF = "4749"; // gif文件头

	// 可执行文件
	public static final String TYPE_EXEC_EXE = "4d5a"; // exe文件头

	// office excel文件
	public static final String TYPE_OFFICE_XLS = "d0cf11"; // xls文件头
	public static final String TYPE_OFFICE_XLSX = "504b03"; // xlsx文件头

	// xml文件
	public static final String TYPE_XML = "efbbbf"; // xml文件头

	/**
	 * 校验文件名是否为不合法文件名[是否为空，是否带有特殊字符]
	 */
	public static boolean checkFileName(String name)
	{
		boolean bool = false;
		if (name == null || "".equals(name) || name.indexOf("<") != -1
				|| name.indexOf(">") != -1 || name.indexOf("*") != -1
				|| name.indexOf("?") != -1 || name.indexOf("|") != -1)
		{
			bool = true;
		}
		//System.out.println("checkFileName===" + bool + "\tFileName:" + name);
		return bool;
	}

	/**
	 * 通过文件后缀名判断文件类型【不区分大小写】 例： fileName：test.Exe suffix:.exE ===> true
	 * fileName：test.Exe suffix:exE ===> true
	 * 
	 * @author DIGUA add 20121224
	 * @param fileName
	 *            文件名【可以是全路径】
	 * @param suffix
	 *            后缀名【不区分大小写：exE .exe】
	 * @return
	 */
	public static boolean checkFileTypeBySuffixName(String fileName,
			String suffix)
	{
		boolean bool = false;
		if (suffix != null && !"".equals(suffix) && !checkFileName(fileName))
		{
			fileName = getBaseFilename(fileName);
			if (fileName.indexOf('.') != -1)
			{
				suffix = (suffix.indexOf('.') == -1 ? "." : "") + suffix;
				if (suffix.equalsIgnoreCase(fileName.substring(fileName
						.lastIndexOf('.'))))
				{
					bool = true;
				}
			}
		}
		return bool;
	}

	public static boolean checkXml(InputStream is)
	{
		boolean bool = false;
		try
		{
			// 取前三字节
			byte[] b = new byte[3];
			is.read(b, 0, b.length);

			StringBuffer str = new StringBuffer();
			if (b == null || b.length <= 0)
			{
				return false;
			}
			for (int i = 0; i < b.length; i++)
			{
				int v = b[i] & 0xFF;
				String hv = Integer.toHexString(v);
				if (hv.length() < 2)
				{
					str.append(0);
				}
				str.append(hv);
			}

			// 判断否是为images类型
			String xmlHeadByte = str.toString();
            System.out.println(xmlHeadByte);
			if (xmlHeadByte.indexOf(TYPE_XML) != -1)
			{
				bool = true;
			}
		} catch (IOException e)
		{
			System.out.println("IO IS ERROR!");
			e.printStackTrace();
		}

		return bool;
	}

	/**
	 * 校验文件是否为images文件
	 */
	public static boolean checkImages(InputStream is)
	{
		boolean bool = false;

		try
		{
			// 取前三字节
			byte[] b = new byte[3];
			is.read(b, 0, b.length);

			StringBuffer str = new StringBuffer();
			if (b == null || b.length <= 0)
			{
				return false;
			}
			for (int i = 0; i < b.length; i++)
			{
				int v = b[i] & 0xFF;
				String hv = Integer.toHexString(v);
				if (hv.length() < 2)
				{
					str.append(0);
				}
				str.append(hv);
			}

			// 判断否是为images类型
			String imgHeadByte = str.toString();
            System.out.println(imgHeadByte);
			if (imgHeadByte.indexOf(TYPE_IMG_JPG) != -1 // ffd8ff ==jpg
					|| imgHeadByte.indexOf(TYPE_IMG_PNG) != -1 // 89504e47
																// ==png
					|| imgHeadByte.indexOf(TYPE_IMG_BMP) != -1 // 424d == bmp
					|| imgHeadByte.indexOf(TYPE_IMG_GIF) != -1 // 47494638 ==
																// gif
			)
			{
				bool = true;
			}
		} catch (IOException e)
		{
			System.out.println("IO IS ERROR!");
			e.printStackTrace();
		}

		return bool;
	}

	/**
	 * 校验文件是否为exe文件
	 * 
	 * @param src
	 * @return
	 */
	public static boolean checkExeFile(InputStream is)
	{
		boolean bool = false;

		try
		{
			// 取前三字节
			byte[] b = new byte[3];
			is.read(b, 0, b.length);

			StringBuffer str = new StringBuffer();
			if (b == null || b.length <= 0)
			{
				return false;
			}
			for (int i = 0; i < b.length; i++)
			{
				int v = b[i] & 0xFF;
				String hv = Integer.toHexString(v);
				if (hv.length() < 2)
				{
					str.append(0);
				}
				str.append(hv);
			}

			// 判断否是为images类型
			String exeHeadByte = str.toString();

			if (exeHeadByte.indexOf(TYPE_EXEC_EXE) != -1)// 4d5a ==exe
			{
				bool = true;
			}
		} catch (IOException e)
		{
			System.out.println("IO IS error!");
			e.printStackTrace();
		}

		return bool;
	}

	/**
	 * 检验文件是否为excel
	 * 
	 * @param args
	 */
	public static boolean checkExcelFile(InputStream is)
	{
		boolean bool = false;

		try
		{
			// 取前三字节
			byte[] b = new byte[3];
			is.read(b, 0, b.length);

			StringBuffer str = new StringBuffer();
			if (b == null || b.length <= 0)
			{
				return false;
			}
			for (int i = 0; i < b.length; i++)
			{
				int v = b[i] & 0xFF;
				String hv = Integer.toHexString(v);
				if (hv.length() < 2)
				{
					str.append(0);
				}
				str.append(hv);
			}

			// 判断否是为images类型
			String exeHeadByte = str.toString();
			if (exeHeadByte.indexOf(TYPE_OFFICE_XLSX) != -1
					|| exeHeadByte.indexOf(TYPE_OFFICE_XLS) != -1)
			{
				bool = true;
			}
		} catch (IOException e)
		{
			System.out.println("IO IS error!");
			e.printStackTrace();
		}

		return bool;
	}

	/**
	 * 获取基本文件名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getBaseFilename(String fileName)
	{
		int idx = fileName.lastIndexOf("\\");
		return fileName.substring(idx + 1);
	}
}
