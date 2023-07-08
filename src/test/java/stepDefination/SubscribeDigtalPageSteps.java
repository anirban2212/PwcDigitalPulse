package stepDefination;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import helpAssist.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SubscribePage;

public class SubscribeDigtalPageSteps {

	public TestContextSetup context;
	public SubscribePage subscribedigitalpage;
	private static Logger log = LogManager.getLogger(SubscribeDigtalPageSteps.class);

	public SubscribeDigtalPageSteps(TestContextSetup context) {
		this.context = context;
		this.subscribedigitalpage = context.getPageObjectsManager().getSubscribeDigitalPage();
	}

	@Then("^I am taken to the Subscribe page$")
	public void I_Am_Taken_ToThe_SubscribePage() {
		subscribedigitalpage.verifySubscribePageDisplayed();
		log.info("Subscribe page got displayed");
	}


	@And("^I am presented with the below fields$")
	public void I_Am_Presented_With_TheBelow_Fields(DataTable fields) throws InterruptedException {

		subscribedigitalpage.verificationOfFields(fields);

	}

	@And("^I will need to complete Google reCAPTCHA before I can complete my request$")
	public void I_Will_Need_To_Complete_Google_ReCAPTCHA_BeforeICanComplete_MyRequest() {

		subscribedigitalpage.verifyRecaptchaLink();
	}


}
