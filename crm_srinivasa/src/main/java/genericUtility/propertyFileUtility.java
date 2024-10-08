
//1. First class to get the properties file related details in the scripts.

package genericUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyFileUtility 
{

	 public String readDataFromProperties(String key) throws IOException 
	 {
	 FileInputStream fis= new FileInputStream("./configAppData/commonData.properties");
	 Properties prop = new Properties();
	 prop.load(fis);
	 String data =prop.getProperty(key);
	 return data;

     }
	 
}

