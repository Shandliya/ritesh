package org.studentManagement.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.student_management.objectRepository.AdminCommonPage;
import org.student_management.objectRepository.AllStudentPage;
import org.student_management.objectRepository.LoginPage;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

public class DeleteParticularStudent {
	public static void main(String[] args)
	{
		WebDriverUtility webdriverUtility=new WebDriverUtility();
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		JavaUtility javaUtility=new JavaUtility();
		
		String url = fileUtility.getDataFromPropertyFile("url");
		String adminusername = fileUtility.getDataFromPropertyFile("adminusername");
		String adminpassword = fileUtility.getDataFromPropertyFile("adminpassword");
		String Timeouts = fileUtility.getDataFromPropertyFile("duration");
		String browser = fileUtility.getDataFromPropertyFile("browser");
		long longTimeouts = javaUtility.convertStringToLong(Timeouts);
		
		String sheetname = "admin";
		int gradeCellNum = 2;
		int rowNum = 2;
		int studentNameCellNum = 1;
		
		String grade = excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetname, rowNum, studentNameCellNum);
		String deleteStudentName = excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetname, rowNum, studentNameCellNum);
		
		WebDriver driver = webdriverUtility.setupBrowser(browser);
		webdriverUtility.navigateToApplication(url);
		webdriverUtility.maximizeBrowser();
		webdriverUtility.implicitWait(longTimeouts);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginAction(adminusername, adminpassword);
	  WebElement gradeDropdown = new AdminCommonPage(driver).clickStudentTabAction().clickAllStudentAction().getGradeDropdownElement();	     
	  webdriverUtility.selectDropdown(grade, gradeDropdown);
	  AllStudentPage allStudentPage = new AllStudentPage(driver);
	  allStudentPage.clickSubmitBtnAction().leaveStudentAction(deleteStudentName);
	  WebElement element = allStudentPage.getAllStudentHeader();
	  webdriverUtility.waitTillElementInVisible(element);
	  new AdminCommonPage(driver).signoutAction();
	  excelUtility.closeWorkbook();
	  webdriverUtility.closeAllTabs();
	  
	  
		
		
	}

} 
