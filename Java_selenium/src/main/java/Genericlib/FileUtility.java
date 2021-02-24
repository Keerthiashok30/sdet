package Genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility
{
	public String generatevalue(String key) throws Throwable
	{
		FileInputStream fil=new FileInputStream(IConstant.commondatapath);
		Properties pro=new Properties();
		pro.load(fil);
		String value =pro.getProperty(key);
		return value;
	}
	
	public String amazonvalue(String key) throws Throwable
	{
		FileInputStream fil=new FileInputStream(IConstant.amazoncommondatapath);
		Properties pro=new Properties();
		pro.load(fil);
		String value =pro.getProperty(key);
		return value;
	}

}
