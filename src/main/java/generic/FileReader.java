package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class FileReader {

	private Properties prop;
    private final String propertyFilePath= "src/test/resources/Config.properties";
    
    public FileReader() {
    	prop= new Properties();
    	FileInputStream fis = null;
    	try {
			fis= new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
    	try {
			prop.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
   
    public String getBrowser() {
    	return prop.getProperty("Browser");
    }
    
   
    public String getApplicationUrl() {
        return prop.getProperty("url");
    }
    
    
    public String getWaitTimeout() {
        return prop.getProperty("WaitTime");
      
    }
}
