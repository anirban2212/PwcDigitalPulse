package helpAssist;

import managers.DriverManager;
import managers.PageObjectsManager;

public class TestContextSetup {

	private DriverManager driverManager;
	private PageObjectsManager pageObjectsManager;

	/**
	 * 
	 * Objective of this class is the share the data between different
	 * StepDefination files using dependency injection.
	 * 
	 */
	public TestContextSetup() {
		driverManager = new DriverManager();
		pageObjectsManager = new PageObjectsManager(driverManager.getDriver());

	}

	/*
	 * Below method will return the web driver manager object
	 */
	public DriverManager getWebDriverManager() {
		return driverManager;
	}

	/*
	 * Below method will return the page object manager objects
	 */
	public PageObjectsManager getPageObjectsManager() {
		return pageObjectsManager;
	}
}
