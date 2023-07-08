package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import generic.Waits;
import managers.FileManager;

public class HomePage {

	public WebDriver driver;
	private static final String ARTICLES = "//div[contains(@class,'headline_column')][$value$]/article";
	private static final String SUBSCRIBELINK = "//a[contains(@navigation-title,'Subscribe')]";
	private static final String SEARCHLINK = "//button[text()='Search']";
	private static final String SEARCHFIELD = "//input[@name='searchfield']";
	private static final String SUBMITBUTTON = "//input[@type='submit']";
	private static final String PAGETITLE = "//p[text()='Digital Pulse']";
	private static final String COLUMNS = "//div[contains(@class,'headline_column')]";
	


	int Timeout = Integer.parseInt(FileManager.getFileReaderManagerInstance().getConfigReader().getWaitTimeout());


	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void goToDigitalPulseHomePage(){
		driver.get(FileManager.getFileReaderManagerInstance().getConfigReader().getApplicationUrl());
	}
	
	
	public void verifyHomePageDisplayed(String pageName){

		By PageTitle = By.xpath(PAGETITLE);
		WebElement element = Waits.WaitForElement(driver, PageTitle, Timeout);
		Assert.assertTrue(element.isDisplayed());

	}

	public void clickSearchLink()
	{
		By searchLink = By.xpath(SEARCHLINK);
		WebElement element = Waits.WaitForElement(driver, searchLink, Timeout);
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}
	
	public void enterTextIntoTheSearchField(String text)
	{
		By searchField = By.xpath(SEARCHFIELD);
		WebElement element = Waits.WaitForElement(driver, searchField, Timeout);
		Assert.assertTrue(element.isDisplayed());
		element.sendKeys(text);
	}
	
	
	public void clickOnSubmitButton()
	{
		By submitButton = By.xpath(SUBMITBUTTON);
		WebElement element = Waits.WaitForElement(driver, submitButton, Timeout);
		Assert.assertTrue(element.isDisplayed());
		element.click();
		
	}

	
	public void verifyNumberOfColumns(int NumberOfColumn)
	{
		By columns = By.xpath(COLUMNS);
		List<WebElement> elements = driver.findElements(columns);
		int colCount = elements.size();
		Assert.assertEquals(colCount,NumberOfColumn);
	}

	public void verifyNumberOfArticlesPerColumn(int column,int NumberOfArtcles)
	{
		String articles = ARTICLES.replace("$value$",String.valueOf(column));
		List<WebElement> elements = driver.findElements(By.xpath(articles));
		int ArticleCount = elements.size();
		Assert.assertEquals(NumberOfArtcles,ArticleCount);
	}
	

	public void clickSubscribeLink()
	{
		By subscribeLink = By.xpath(SUBSCRIBELINK);
		WebElement element = Waits.WaitForElement(driver, subscribeLink, Timeout);
		element.click();

	}
	
	
	
	
}
