package stepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import helpAssist.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public TestContextSetup context;


    public Hooks(TestContextSetup context) {
        this.context = context;
    }


   
   
    @After(order = 0)
    public void AfterSteps() {
    	context.getWebDriverManager().closeDriver();
    }
    @After(order = 1)
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            
                File src =((TakesScreenshot) context.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(src) ;
                scenario.attach(fileContent,"image/png", "image");

        

        }
    }


}
