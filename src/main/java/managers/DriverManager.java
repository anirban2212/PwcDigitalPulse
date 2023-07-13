package managers;

import java.time.Duration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * This class is used to handle all the driver related function.
 */
public class DriverManager {

	private String browserDriver;
	private WebDriver driver;
	private static Logger log = LogManager.getLogger(DriverManager.class);

	public DriverManager() {
		browserDriver = FileManager.getFileReaderManagerInstance().getConfigReader().getBrowser();
	}

	/*
	 * This will return the current driver instance.
	 */
	public WebDriver getDriver() {
		return createDriver();
	}

	/*
	 * This will create a new driver instance.
	 */
	private WebDriver createDriver() {
		switch (browserDriver) {
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
			break;
		case "InternetExplorer":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			log.error("opening browser has failed");
			break;

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
				Integer.parseInt(FileManager.getFileReaderManagerInstance().getConfigReader().getWaitTimeout())));
		return driver;
	}

	/*
	 * This will close all the driver instance.
	 */
	public void closeDriver() {
		driver.quit();
	}

}
