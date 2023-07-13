package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/*
 * This is used to execute the feature files.
 */
@CucumberOptions(
		features =  {
				"src/test/java/features/ColumnVerification.feature",
		},
		monochrome = true,
		tags =      " @Sanity or @Regression or @Smoke",
		plugin =    {
				"pretty", "html:reports/cucumber-html-report",
				"json:reports/CucumberTestReport.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		glue = {"stepDefination"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
