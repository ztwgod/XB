package cn.com.xb.domain.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class BlobFiles implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fileId;
	private String fileName;
	private String fileSuffix;
	private String fileType;
	private File fileContents;
	private double fileSize;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getFileType()
	{
		return fileType;
	}

	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}

	public File getFileContents()
	{
		return fileContents;
	}

	public void setFileContents(File fileContents)
	{
		this.fileContents = fileContents;
		try
		{
			this.fileSize = getFileInputStream().available() / 1024.0;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public InputStream getFileInputStream()
	{
		if(fileContents != null)
		{
			try
			{
				return new FileInputStream(fileContents);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public OutputStream getFileOutputStream()
	{
		if(fileContents != null)
		{
			try
			{
				return new FileOutputStream(fileContents);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

}
