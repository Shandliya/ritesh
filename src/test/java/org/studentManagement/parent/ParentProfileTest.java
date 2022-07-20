package org.studentManagement.parent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.student_management.objectRepository.LoginPage;
import org.student_management.objectRepository.MyProfilePreviewPage;
import org.student_management.objectRepository.ParentCommonPage;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

public class ParentProfileTest {
	public static void main(String []args) {
		WebDriverUtility webdriverUtility=new WebDriverUtility();
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		JavaUtility javaUtility=new JavaUtility();

		String url=fileUtility.getDataFromPropertyFile("url");
		String parentusername=fileUtility.getDataFromPropertyFile("parentusername");
		String parentpassword=fileUtility.getDataFromPropertyFile("parentpassword");
		String timeouts=fileUtility.getDataFromPropertyFile("duration");
		String browser=fileUtility.getDataFromPropertyFile("browser");
		long longTimeouts = javaUtility.convertStringToLong(timeouts);   
		String sheetName = "parent";
		int rowNum = 4;
		String expectedFullName = excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetName, rowNum,1);
		WebDriver driver=webdriverUtility.setupBrowser(browser);
		webdriverUtility.navigateToApplication(url);
		webdriverUtility.maximizeBrowser();
		webdriverUtility.implicitWait(longTimeouts);
		webdriverUtility.initiallizeExplicitWait(longTimeouts);  
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginAction(parentusername, parentpassword);
		ParentCommonPage parentCommonPage=new ParentCommonPage(driver);  
		parentCommonPage.clickOnProfileAction();
		parentCommonPage.clickOnMyProfileAction();
		MyProfilePreviewPage myProfilePreviewPage=new MyProfilePreviewPage(driver);
		myProfilePreviewPage.updateParentFullName(expectedFullName);
		WebElement element = myProfilePreviewPage.getInformationPopup();
		webdriverUtility.waitTillElementInVisible(element);
		boolean flag = myProfilePreviewPage.verifyProfileUpdate(expectedFullName);
		if(flag==true)
			javaUtility.print("Profile Updated Successfully---->TestCase Passed");
		else
			javaUtility.print("Profile not Updated---->TestCase Failed");

		parentCommonPage.logoutAction();
		excelUtility.closeWorkbook();
		webdriverUtility.closeAllTabs();  
	}
}

