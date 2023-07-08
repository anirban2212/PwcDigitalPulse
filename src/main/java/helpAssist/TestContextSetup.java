package helpAssist;

import managers.DriverManager;
import managers.PageObjectsManager;


public class TestContextSetup {

	
		private DriverManager driverManager;
	    private PageObjectsManager pageObjectsManager;

	   
	    public TestContextSetup(){
	        driverManager = new DriverManager();
	        pageObjectsManager = new PageObjectsManager(driverManager.getDriver());


	    }

	  
	    public DriverManager getWebDriverManager() {
	        return driverManager;
	    }
	    
	    
	    public PageObjectsManager getPageObjectsManager() {
	        return pageObjectsManager;
	    }
}
