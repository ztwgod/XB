package cn.com.xb.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import cn.com.xb.domain.base.SsBoxnumLogx;
import cn.com.xb.domain.base.Transactionx;
import cn.com.xb.domain.displayWrapper.BoxStatusWrapper;
import cn.com.xb.domain.displayWrapper.OperationLogWrapper;


public class ExcelUtils {

	//导出excel文件默认名称
	private static final String xlsName = "operationLog.xls";
	private static final String xlsName_BoxLog = "BoxLog.xls";
	private static final String xlsName_StorStatus = "StorStatus.xls";
	
	/**
	 * 操作日志生成一个Excel文件
	 */
	public static void writeOperationLogExcel(HttpServletResponse response, List<OperationLogWrapper> logs) throws Exception
	{
		WritableWorkbook wwb = null;
		OutputStream os = response.getOutputStream();
		response.setHeader("Content-disposition", "attachment;filename=" + xlsName);// 设定输出文件头
		response.setContentType("application/vnd.ms-excel");

		try
		{
			// 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(os);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if (wwb != null)
		{
			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			// 添加标题栏
			ws = insertOperationLogTitle(ws);
			// 下面开始添加单元格
			for (int i = 1; i < logs.size() + 1; i++)
			{
				OperationLogWrapper log = (OperationLogWrapper) logs.get(i - 1);
				for (int k = 0; k < 6; k++)
				{
					Label labelC = null;
					// 这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
					if (k == 0)// 序号
					{
						labelC = new Label(k, i, log.getSysPlatTypeShow());
					}
					else if (k == 1)
					{
						labelC = new Label(k, i, log.getOperationTypeShow());
					}
					else if (k == 2)
					{
						labelC = new Label(k, i, log.getSsCode());
					}
					else if (k == 3)
					{
						labelC = new Label(k, i, log.getOperationContent());
					}
					else if (k == 4)
					{
						labelC = new Label(k, i, log.getOperationUserName());
					}
					else if (k == 5)
					{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						labelC = new Label(k, i, sdf.format(log.getOperationTime()));
					}
					// 将生成的单元格添加到工作表中
					ws.addCell(labelC);
				}
			}
			try
			{
				// 从内存中写入文件中
				wwb.write();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				// 关闭资源，释放内存
				if (null != wwb)
					wwb.close();
				if (os != null)
					os.close();
			}
		}
	}
	
	
	/**
	 * 操作日志生成一个Excel文件
	 */
	public static void writeBoxNumLogExcel(HttpServletResponse response, List<SsBoxnumLogx> logs) throws Exception
	{
		WritableWorkbook wwb = null;
		OutputStream os = response.getOutputStream();
		response.setHeader("Content-disposition", "attachment;filename=" + xlsName_BoxLog);// 设定输出文件头
		response.setContentType("application/vnd.ms-excel");

		try
		{
			// 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(os);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if (wwb != null)
		{
			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			// 添加标题栏
			ws = insertBoxNumLogTitle(ws);
			// 下面开始添加单元格
			for (int i = 1; i < logs.size() + 1; i++)
			{
				SsBoxnumLogx log = (SsBoxnumLogx) logs.get(i - 1);
				for (int k = 0; k < 6; k++)
				{
					Label labelC = null;
					// 这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
					if (k == 0)// 序号
					{
						labelC = new Label(k, i, log.getSsCode());
					}
					else if (k == 1)
					{
						labelC = new Label(k, i, log.getTotalNum()+"");
					}
					else if (k == 2)
					{
						labelC = new Label(k, i, log.getFaultNum()+"");
					}
					else if (k == 3)
					{
						labelC = new Label(k, i, log.getOccupationNum()+"");
					}
					else if (k == 4)
					{
						labelC = new Label(k, i, log.getEmptyNum()+"");
					}
					else if (k == 5)
					{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						labelC = new Label(k, i, sdf.format(log.getRecordTime()));
					}
					// 将生成的单元格添加到工作表中
					ws.addCell(labelC);
				}
			}
			try
			{
				// 从内存中写入文件中
				wwb.write();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				// 关闭资源，释放内存
				if (null != wwb)
					wwb.close();
				if (os != null)
					os.close();
			}
		}
	}

	
	/**
	 * 物箱状态生成一个Excel文件
	 */
	public static void writeStorStatusExcel(HttpServletResponse response, List<BoxStatusWrapper> bsws) throws Exception
	{
		WritableWorkbook wwb = null;
		OutputStream os = response.getOutputStream();
		response.setHeader("Content-disposition", "attachment;filename=" + xlsName_StorStatus);// 设定输出文件头
		response.setContentType("application/vnd.ms-excel");

		try
		{
			// 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(os);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if (wwb != null)
		{
			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			// 添加标题栏
			ws = insertBoxStatusTitle(ws);
			// 下面开始添加单元格
			for (int i = 1; i < bsws.size() + 1; i++)
			{
				BoxStatusWrapper bsw = (BoxStatusWrapper) bsws.get(i - 1);
				for (int k = 0; k < 6; k++)
				{
					Label labelC = null;
					// 这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
					if (k == 0)// 序号
					{
						labelC = new Label(k, i, bsw.getSsCode());
					}
					else if (k == 1)
					{
						labelC = new Label(k, i, bsw.getBoxIndex()+"");
					}
					else if (k == 2)
					{
						labelC = new Label(k, i, bsw.getBoxSizeShow()+"");
					}
					else if (k == 3)
					{
						labelC = new Label(k, i, bsw.getBoxStatusShow()+"");
					}
					else if (k == 4)
					{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						labelC = new Label(k, i, null == bsw.getStartTime() ? "" : sdf.format(bsw.getStartTime())+"");
					}
					else if (k == 5)
					{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						labelC = new Label(k, i, null == bsw.getEndTime() ? "" : sdf.format(bsw.getEndTime()));
					}
					// 将生成的单元格添加到工作表中
					ws.addCell(labelC);
				}
			}
			try
			{
				// 从内存中写入文件中
				wwb.write();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				// 关闭资源，释放内存
				if (null != wwb)
					wwb.close();
				if (os != null)
					os.close();
			}
		}
	}
	
	
	/**
	 * 交易信息成一个Excel文件
	 */
	public static void writeBusinessExcel(HttpServletResponse response, List<Transactionx> trans) throws Exception
	{
		WritableWorkbook wwb = null;
		OutputStream os = response.getOutputStream();
		response.setHeader("Content-disposition", "attachment;filename=" + xlsName_BoxLog);// 设定输出文件头
		response.setContentType("application/vnd.ms-excel");

		try
		{
			// 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(os);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if (wwb != null)
		{
			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			// 添加标题栏
			ws = insertBusinessTitle(ws);
			// 下面开始添加单元格
			for (int i = 1; i < trans.size() + 1; i++)
			{
				Transactionx tran = (Transactionx) trans.get(i - 1);
				for (int k = 0; k < 7; k++)
				{
					Label labelC = null;
					// 这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
					if (k == 0)// 序号
					{
						labelC = new Label(k, i, tran.getSsCode());
					}
					else if (k == 1)
					{
						labelC = new Label(k, i, tran.getBoxIndex());
					}
					else if (k == 2)
					{
						labelC = new Label(k, i, tran.getSizeName());
					}
					else if (k == 3)
					{
						labelC = new Label(k, i,tran.getTransTypeName());
					}
					else if (k == 4)
					{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						labelC = new Label(k, i, sdf.format(tran.getCreateTime()));
					}
					else if (k == 5)
					{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						if(null!=tran.getCloseTime()){
							labelC = new Label(k, i, sdf.format(tran.getCloseTime()));
						}else{
							labelC = new Label(k, i,null);
						}
						
					}
					else if (k == 6)
					{
						labelC = new Label(k, i, tran.getTotalAmount()+"");
					}
					
					// 将生成的单元格添加到工作表中
					ws.addCell(labelC);
				}
			}
			try
			{
				// 从内存中写入文件中
				wwb.write();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				// 关闭资源，释放内存
				if (null != wwb)
					wwb.close();
				if (os != null)
					os.close();
			}
		}
	}
	
	
	/**
	 * 设置宽度和标题
	 * @param ws
	 * @return
	 * @throws Exception
	 */
	public static WritableSheet insertOperationLogTitle(WritableSheet ws) throws Exception
	{
		// 设置单元格宽度
		ws.setColumnView(0, 14);
		ws.setColumnView(1, 20);
		ws.setColumnView(2, 14);
		ws.setColumnView(3, 35);
		ws.setColumnView(4, 12);
		ws.setColumnView(5, 19);
		String[] titles = new String[] { "操作平台", "操作类型", "物箱代码", "操作内容", "操作者", "操作时间" };
		for (int i = 0; i < titles.length; i++)
		{
			Label laber = new Label(i, 0, titles[i]);
			ws.addCell(laber);
		}
		return ws;
	}
	
	
	/**
	 * 设置宽度和标题
	 * @param ws
	 * @return
	 * @throws Exception
	 */
	public static WritableSheet insertBoxNumLogTitle(WritableSheet ws) throws Exception
	{
		// 设置单元格宽度
		ws.setColumnView(0, 20);
		ws.setColumnView(1, 15);
		ws.setColumnView(2, 15);
		ws.setColumnView(3, 15);
		ws.setColumnView(4, 15);
		ws.setColumnView(5, 20);
		String[] titles = new String[] { "物箱代码", "总箱子数", "故障箱子数", "箱子占用数", "空箱数量", "记录时间" };
		for (int i = 0; i < titles.length; i++)
		{
			Label laber = new Label(i, 0, titles[i]);
			ws.addCell(laber);
		}
		return ws;
	}
	

	
	/**
	 * 设置宽度和标题
	 * @param ws
	 * @return
	 * @throws Exception
	 */
	public static WritableSheet insertBoxStatusTitle(WritableSheet ws) throws Exception
	{
		// 设置单元格宽度
		ws.setColumnView(0, 20);
		ws.setColumnView(1, 15);
		ws.setColumnView(2, 15);
		ws.setColumnView(3, 15);
		ws.setColumnView(4, 20);
		ws.setColumnView(5, 20);
		String[] titles = new String[] { "物箱代码", "箱子编号", "箱子尺寸类", "状态类型", "起始时间", "终止时间" };
		for (int i = 0; i < titles.length; i++)
		{
			Label laber = new Label(i, 0, titles[i]);
			ws.addCell(laber);
		}
		return ws;
	}
	
	/**
	 * 设置宽度和标题
	 * @param ws
	 * @return
	 * @throws Exception
	 */
	public static WritableSheet insertBusinessTitle(WritableSheet ws) throws Exception
	{
		// 设置单元格宽度
		ws.setColumnView(0, 20);
		ws.setColumnView(1, 10);
		ws.setColumnView(2, 10);
		ws.setColumnView(3, 10);
		ws.setColumnView(4, 20);
		ws.setColumnView(5, 20);
		ws.setColumnView(6, 10);
		String[] titles = new String[] { "物箱代码", "箱子编号", "箱子尺寸类", "业务类型", "投件时间", "取件时间","收费情况" };
		for (int i = 0; i < titles.length; i++)
		{
			Label laber = new Label(i, 0, titles[i]);
			ws.addCell(laber);
		}
		return ws;
	}
	
	
	
    /**往Excel中插入图片
     * @param dataSheet  待插入的工作表
     * @param col 图片从该列开始
     * @param row 图片从该行开始
     * @param width 图片所占的列数
     * @param height 图片所占的行数
     * @param imgFile 要插入的图片文件
     */
	public static void insertImg(WritableSheet dataSheet, int col, int row, int width, int height, File imgFile)
	{
		WritableImage img = new WritableImage(col, row, width, height, imgFile);
		dataSheet.addImage(img);
	}
}
