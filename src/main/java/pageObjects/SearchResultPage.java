package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import generic.Waits;
import managers.FileManager;

public class SearchResultPage {

	public WebDriver driver;
    int Timeout = Integer.parseInt(FileManager.getFileReaderManagerInstance().getConfigReader().getWaitTimeout());

    private static final String PAGETITLE = "//h2[contains(text(),'Refine your search')]";

    private static final String SEARCHRESULTS = "//div[@class='srp-list']/div";

    
    
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public void minimumSearchResults(String miniumNumberOfSSearch)
    {
        By searchResults = By.xpath(SEARCHRESULTS);
        List<WebElement> elements =driver.findElements(searchResults);
        elements.size();
        Assert.assertTrue(elements.size()>=Integer.parseInt(miniumNumberOfSSearch));


    }

    public void verifySearchResultPageisDisplayed(){

        By PageTitle = By.xpath(PAGETITLE);
        WebElement element = Waits.WaitForElement(driver, PageTitle, Timeout);
        Assert.assertTrue(element.isDisplayed());
    }


   
}
