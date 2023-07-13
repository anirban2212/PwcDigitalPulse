package generic;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementWaitUtils {

	private static Logger log = LogManager.getLogger(ElementWaitUtils.class);

	/*
	 * This method is to wait for a particular element until it is visible or
	 * detected by the xpath
	 */
	public static WebElement waitForElement(WebDriver driver, By by, Integer timeoutInSeconds) {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			log.info("Element found: " + by);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver.findElement(by);

	}

}
