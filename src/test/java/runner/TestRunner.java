package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features =  {
				"src/test/java/features/ColumnVerification.feature",
		},
		monochrome = true,
		tags =      "@Regression or @Sanity or @Smoke",
		plugin =    {
				"pretty", "html:reports/cucumber-html-report",
				"json:reports/CucumberTestReport.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		glue = {"stepDefination"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
