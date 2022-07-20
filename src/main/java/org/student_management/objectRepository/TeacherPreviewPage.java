package org.student_management.objectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherPreviewPage {
	@FindBy(xpath="//tbody/tr/td[2]")
	private List<WebElement> allTeacherName;
	@FindBy(xpath="//a[@aria-controls='example1']")
	private List<WebElement> pageCount;
	@FindBy(xpath="//a[.='Next']")
	private WebElement nextBtn;
	@FindBy(xpath="//tbody/tr/td[2]")
	private List<WebElement> mySonsAllTeacher;
	public TeacherPreviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean validateTeacherName(String expectedTeacherName) {
		List<String> pages=new ArrayList<>();
		boolean flag=false;
		for(WebElement count:pageCount) {
			pages.add(count.getText());
		}
		for(int i=1;i<pages.size()-1;i++) {
			for(int j=0;j<allTeacherName.size();j++) {
				String actualTeacherName =allTeacherName.get(j).getText().trim();
				if(expectedTeacherName.equalsIgnoreCase(actualTeacherName)) {
					System.out.println("Teacher is present---Actual TeacherName-->"+actualTeacherName);
					flag=true;
					break;
				}
			}
			if(flag==true)
				break;
			else
				nextBtn.click();
		}
		return flag;
	}
	public boolean validateMySonsTeacherName(String expectedMySonsTeacherName) {
		List<String> pages=new ArrayList<>();
		boolean flag=false;
		for(WebElement count:pageCount) {
			pages.add(count.getText());
		}
		for(int i=1;i<pages.size()-1;i++) {
			for(int j=0;j<mySonsAllTeacher.size();j++) {
			String name = mySonsAllTeacher.get(j).getText();
			String[] teacherName = name.split(">");
			String actualTeacherName = teacherName[teacherName.length-1];
			if(actualTeacherName.equals(expectedMySonsTeacherName)) {
				System.out.println("Teacher present in my son's teacher");
				flag=true;
				break;
			}
			}
			if(flag==true)
				break;
			else 
				nextBtn.click();

		}
        return flag;
	}
}

	
	


