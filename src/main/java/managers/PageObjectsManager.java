package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import pageObjects.SubscribePage;

public class PageObjectsManager {
	
	 private WebDriver driver;
	 private HomePage homePage;
	 private SubscribePage subscribedigitalpage;

	 private SearchResultPage searchResultPage;


	    public PageObjectsManager(WebDriver driver) {
	        this.driver = driver;
	    }

	  
	    public HomePage getHomePage() {
	        if(homePage == null)
	        	return new HomePage(driver);
	        else
	        	return homePage;
	    }
	   
	    public SubscribePage getSubscribeDigitalPage() {
	         if(subscribedigitalpage == null)
	        	 return new SubscribePage(driver);
	         else
	        	 return subscribedigitalpage;
	    }

	  
	    public SearchResultPage getSearchResultPage() {
	         if(searchResultPage == null)
	        	 return new SearchResultPage(driver);
	         else
	        	 return searchResultPage;
	    }

	    
	   



}
