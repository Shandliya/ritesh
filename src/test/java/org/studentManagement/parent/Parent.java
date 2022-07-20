package org.studentManagement.parent;


import org.openqa.selenium.WebElement;
import org.student_management.objectRepository.DashboardPreviewPage;
import org.student_management.objectRepository.MyProfilePreviewPage;
import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClassParent;
import org.tyss.genericUtility.IConstants;


import org.testng.Assert;
@Test
public class Parent extends BaseClassParent {
	@Test
	public void updateAndValidateParentProfileTest(){
		String sheetName = "parent";
		int rowNum = 4;
		String expectedFullName = excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetName, rowNum,1);
		WebElement element=parentCommonPage.clickOnProfileAction().clickOnMyProfileAction().updateParentFullName(expectedFullName).getInformationPopup();
		webdriverUtility.waitTillElementInVisible(element);
		MyProfilePreviewPage myProfilePreviewPage=new MyProfilePreviewPage(driver);
		boolean flag = myProfilePreviewPage.verifyProfileUpdate(expectedFullName);
	
		Assert.assertTrue(flag==true,"Profile Updated Successfully---->TestCase Passed");
	}
	@Test
	public void validateMySonsTeacherNameTest() {
		String sheetName = "parent";
		int rowNum = 8;
		String expectedTeacherName = excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetName, rowNum,1);
		boolean flag = parentCommonPage.clickOnTeacherAction().clickOnMySonsTeacherAction().validateMySonsTeacherName(expectedTeacherName);
	Assert.assertTrue(flag==true,"Teacher is present--->TC passed");
		
	}
	@Test
	public void validateTeacherNameTest() {
		String sheetName = "parent";
		int rowNum = 6;
		String expectedTeacherName = excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetName, rowNum,1);
		boolean flag = parentCommonPage.clickOnTeacherAction().clickOnAllTeacherAction().validateTeacherName(expectedTeacherName);
		Assert.assertTrue(flag==true,"Teacher is present--->TC passed");
	}
	@Test
	public void validateTotal_Student_Teacher_Test() {
		String sheetName = "parent";
		int rowNum = 2;
		String totalStudent= excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetName, rowNum, 1);
		String totalTeacher = excelUtility.getDataFromExcel(IConstants.EXCELPATH, sheetName, rowNum, 2);
		DashboardPreviewPage dashBoardPreviewPage=new DashboardPreviewPage(driver);
		int expectedTotalStudentCount = javaUtility.convertStringToInt(totalStudent);
		int expectedTotalTeacherCount = javaUtility.convertStringToInt(totalTeacher);
		int actualTotalStudentCount = dashBoardPreviewPage.getTotalStudentCount();
		int actualTotalTeacherCount = dashBoardPreviewPage.getTotalTeacherCount();
		Assert.assertTrue(expectedTotalStudentCount==actualTotalStudentCount && expectedTotalTeacherCount==actualTotalTeacherCount,"Test case passed");
	}
}
