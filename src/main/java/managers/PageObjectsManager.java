package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import pageObjects.SubscribePage;

/*
 * This class is used to handle all the page objects.
 */
public class PageObjectsManager {

	private WebDriver driver;
	private HomePage homePage;
	private SubscribePage subscribeDigitalPage;

	private SearchResultPage searchResultPage;

	public PageObjectsManager(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This will return an instance of Home page.
	 */
	public HomePage getHomePage() {
		if (homePage == null) {
			homePage = new HomePage(driver);
		}
		return homePage;
	}

	/*
	 * This will return an instance of Subscribe Page .
	 */
	public SubscribePage getSubscribeDigitalPage() {
		if (subscribeDigitalPage == null) {
			subscribeDigitalPage = new SubscribePage(driver);
		}

		return subscribeDigitalPage;
	}

	/*
	 * This will return an instance of SearchResult Page.
	 */
	public SearchResultPage getSearchResultPage() {
		if (searchResultPage == null) {
			searchResultPage = new SearchResultPage(driver);
		}

		return searchResultPage;
	}

}
