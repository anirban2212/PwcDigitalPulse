package managers;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	
	public class DriverManager {

		private String BrowserDriver;
		private WebDriver driver;

		public DriverManager() {
			BrowserDriver = FileManager.getFileReaderManagerInstance().getConfigReader().getBrowser();
		}

		
		public WebDriver getDriver() {
			if(driver == null)
				driver = createDriver();
			return driver;
		}
		
		
		private WebDriver createDriver() {
			switch (BrowserDriver) {
			case "FireFox" : 
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "Chrome" :
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.setAcceptInsecureCerts(true);
				driver = new ChromeDriver(options);
				break;
			case "InternetExplorer" : 
				driver = new InternetExplorerDriver();
				break;
			default:
				System.out.println("Choose A Right a Option");
				break;


			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(FileManager.getFileReaderManagerInstance().getConfigReader().getWaitTimeout())));
			return driver;
		}
		
		
		public void closeDriver() {
			driver.quit();
		}

}
