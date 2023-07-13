package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import generic.ElementWaitUtils;
import managers.FileManager;

public class SearchResultPage {

	public WebDriver driver;
	private int Timeout = Integer
			.parseInt(FileManager.getFileReaderManagerInstance().getConfigReader().getWaitTimeout());

	private static final String PAGETITLE = "//h2[contains(text(),'Refine your search')]";

	private static final String SEARCHRESULTS = "//div[@class='srp-list']/div";

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This is used to search min no of search results.
	 */
	public void minimumSearchResults(String miniumNumberOfSSearch) {
		By searchResults = By.xpath(SEARCHRESULTS);
		List<WebElement> elements = driver.findElements(searchResults);
		Assert.assertTrue(elements.size() >= Integer.parseInt(miniumNumberOfSSearch));

	}

	/*
	 * Below method is used to verify Search result is opened.
	 */
	public void verifySearchResultPageIsDisplayed() {

		By PageTitle = By.xpath(PAGETITLE);
		WebElement element = ElementWaitUtils.waitForElement(driver, PageTitle, Timeout);
		Assert.assertTrue(element.isDisplayed());
	}

}
