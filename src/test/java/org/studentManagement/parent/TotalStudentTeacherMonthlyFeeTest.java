package org.studentManagement.parent;

import org.openqa.selenium.WebDriver;
import org.student_management.objectRepository.DashboardPreviewPage;
import org.student_management.objectRepository.LoginPage;
import org.student_management.objectRepository.ParentCommonPage;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

public class TotalStudentTeacherMonthlyFeeTest {
	public static void main(String []args)
	{
		WebDriverUtility webdriverUtility=new WebDriverUtility();
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		JavaUtility javaUtility=new JavaUtility();
		
		String url = fileUtility.getDataFromPropertyFile("url");
		String parentusername = fileUtility.getDataFromPropertyFile("parentusername");
		String parentpassword = fileUtility.getDataFromPropertyFile("parentpassword");
		String Timeouts = fileUtility.getDataFromPropertyFile("duration");
		String browser = fileUtility.getDataFromPropertyFile("browser");
		System.out.println(browser);
		System.out.println(url);
		long longTimeouts = javaUtility.convertStringToLong(Timeouts);
		
		String sheetname = "parent";
		int rowNum = 2; 
		
		
		String totalStudent = excelUtility.getDataFromExcel(IConstants.EXCELPATH,sheetname,rowNum,1); 
		String totalTeacher = excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetname,rowNum,2);
		WebDriver driver = webdriverUtility.setupBrowser(browser);
		webdriverUtility.navigateToApplication(url);
		webdriverUtility.maximizeBrowser();
		webdriverUtility.implicitWait(longTimeouts);
		webdriverUtility.initiallizeExplicitWait(longTimeouts);
		new LoginPage(driver).loginAction(parentusername, parentpassword);
		DashboardPreviewPage dashboardpreviewpage=new DashboardPreviewPage(driver);
		 int expectedTotalStudentCount = JavaUtility.convertStringToInt(totalStudent);
		 int expectedTotalTeacherCount = JavaUtility.convertStringToInt(totalTeacher);
		 int actualTotalStudentCount = dashboardpreviewpage.getTotalStudentCount();
		 int actutalTotalTeacherCount = dashboardpreviewpage.getTotalTeacherCount();
		 if(expectedTotalStudentCount==actualTotalStudentCount && expectedTotalTeacherCount== actutalTotalTeacherCount)
		 {
			javaUtility.print("TEST CASE PASSED");
		 }
		 else
		 {
			 javaUtility.print("TEST CASE FAILED");
			 new ParentCommonPage(driver).logoutAction();
			 excelUtility.closeWorkbook();
			 webdriverUtility.closeAllTabs();
		 }
		 
		
		
	}

}
