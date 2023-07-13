package stepDefination;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import helpAssist.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SearchResultPage;

public class SearchResultPageSteps {

	public TestContextSetup context;
	public SearchResultPage searchresultpage;
	private static Logger log = LogManager.getLogger(SearchResultPageSteps.class);

	public SearchResultPageSteps(TestContextSetup context) {
		this.context = context;
		this.searchresultpage = context.getPageObjectsManager().getSearchResultPage();
	}

	@Then("^I am taken to the search results page$")
	public void I_Am_Taken_To_The_SearchResultsPage() {

		searchresultpage.verifySearchResultPageIsDisplayed();
		log.info("Search Result page is displayed");
	}


	@And("^I am presented with at least \"(.*)\" search result$")
	public void I_Am_Presented_With_AtLeast_SearchResult(String numberofResults) {

		searchresultpage.minimumSearchResults(numberofResults);
		log.info("Min 1 search result is present");
	}
}
