package org.studentManagement.admin;

import org.openqa.selenium.WebElement;
import org.student_management.objectRepository.AdminCommonPage;
import org.student_management.objectRepository.AllStudentPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClassAdmin;
import org.tyss.genericUtility.IConstants;

public class Admin extends BaseClassAdmin {
	@Test
	public void DeleteParticularStudent() {
		int rowNum = 2;
		String grade = excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetName, rowNum, 2);
		String deleteStudentName = excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetName, rowNum, 1);
		WebElement gradeDropdown = new AdminCommonPage(driver).clickStudentTabAction().clickAllStudentAction().getGradeDropdownElement();
		webdriverUtility.selectDropdown(grade, gradeDropdown);
		AllStudentPage allStudentPage=new AllStudentPage(driver);
		boolean flag = allStudentPage.clickSubmitBtnAction().leaveStudentAction(deleteStudentName);
		Assert.assertTrue(flag);
		
		
		//allStudentPage.clickSubmitBtnAction().leaveStudentAction(deleteStudentName).leaveStudentAction();
		WebElement element = allStudentPage.getAllStudentHeader();
		
		webdriverUtility.waitTillElementVisible(element);
	}
}

