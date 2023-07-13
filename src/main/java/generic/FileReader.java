package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

	private Properties prop;
	private final String propertyFilePath = "src/test/resources/Config.properties";

	/*
	 * The below constructor is getting used to load the properties file.
	 */
	public FileReader() {
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/*
	 * The below method is used to get the browser name from properties file.
	 */
	public String getBrowser() {
		return prop.getProperty("Browser");
	}

	/*
	 * The below method is used to get the url from properties file.
	 */
	public String getApplicationUrl() {
		return prop.getProperty("url");
	}

	/*
	 * The below method is used to fetch the implicit wait time from properties
	 * file.
	 */
	public String getWaitTimeout() {
		return prop.getProperty("WaitTime");

	}
}
