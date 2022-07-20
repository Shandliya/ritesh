package org.tyss.genericUtility;

import org.openqa.selenium.WebDriver;
import org.student_management.objectRepository.LoginPage;
import org.student_management.objectRepository.ParentCommonPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassParent {
	public WebDriverUtility webdriverUtility;
	public FileUtility fileUtility;
	public ExcelUtility excelUtility;
	public JavaUtility javaUtility;
	protected LoginPage loginPage;
	public WebDriver driver;
	public ParentCommonPage parentCommonPage;
	private String url;
	private String parentusername;
	private String parentpassword;
	private String timeouts;
	private String browser;
	long longTimeouts;
	@BeforeSuite
	public void suiteSetup() {
		webdriverUtility=new WebDriverUtility();
		fileUtility=new FileUtility();
		excelUtility=new ExcelUtility();
		javaUtility=new JavaUtility();

		url=fileUtility.getDataFromPropertyFile("url");
		parentusername=fileUtility.getDataFromPropertyFile("parentusername");
		parentpassword=fileUtility.getDataFromPropertyFile("parentpassword");
		timeouts=fileUtility.getDataFromPropertyFile("duration");
		browser=fileUtility.getDataFromPropertyFile("browser");
		longTimeouts = javaUtility.convertStringToLong(timeouts);
	}

	@BeforeMethod
	public void methodSetup() {
		driver=webdriverUtility.setupBrowser(browser);
		webdriverUtility.navigateToApplication(url);
		webdriverUtility.maximizeBrowser();
		webdriverUtility.implicitWait(longTimeouts);
		webdriverUtility.initiallizeExplicitWait(longTimeouts);
		loginPage=new LoginPage(driver);
		loginPage.loginAction(parentusername, parentpassword);
		parentCommonPage=new ParentCommonPage(driver);
	}
	@AfterMethod
	public void methodTearDown() {
		parentCommonPage.logoutAction();

		webdriverUtility.closeAllTabs();
	}
	@AfterSuite
	public void suiteTearDown() {
		excelUtility.closeWorkbook();
	}



}
