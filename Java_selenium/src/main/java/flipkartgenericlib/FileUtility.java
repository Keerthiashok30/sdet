package flipkartgenericlib;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility
{
	public String getPropertyKeyValue(String key) throws Throwable  {
		  
		FileInputStream fis = new FileInputStream(IConstant.amazoncommonDataFilePath);
		 Properties pObj = new Properties();
		 pObj.load(fis);
		 String value = pObj.getProperty(key);
	
	return value;
}


}
