package org.student_management.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

public class AllStudentPage {
	JavaUtility javaUtility=new JavaUtility();
	WebDriver driver;
	public AllStudentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//select[@id='grade']")
	private WebElement gradeDropdown;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement submitBtn;
	@FindBy(xpath="//tbody/tr/td[2]")
	private List<WebElement>  studentNameList;
	@FindBy(xpath="//a[@aria-controls='example1']")
	private List<WebElement>  pageCount;
	@FindBy(xpath="//a[.='Next']")
	private WebElement nextBtn;
	@FindBy(xpath="//a[.='Yes' and @id='btnYes']")
	private WebElement yesBtn;
	@FindBy(xpath="//section[@class='content-header']")
	private WebElement allStudentHeader;


	private String elementPartialXpath="//a[.='%s']/parent::td/following-sibling::td/a[@class='confirm-delete btn btn-danger btn-xs']";

    public WebElement getGradeDropdownElement() {
    	return gradeDropdown;
    }
	public AllStudentPage selectGradeDropDown(String visibleText,WebElement element){
		new WebDriverUtility().selectDropdown(visibleText, element);
		return this;
	}
	public AllStudentPage clickSubmitBtnAction() {
		submitBtn.click();
		return this;
	}
	private WebElement convertStringToXpath(String replaceData) {
		String xpath=String.format(elementPartialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	public boolean leaveStudentAction(String expectedStudentName) {
		boolean flag=false;
		String countStart = pageCount.get(1).getText();
		String countEnd = pageCount.get(pageCount.size()-2).getText();
		int start = JavaUtility.convertStringToInt(countStart);
		int end = JavaUtility.convertStringToInt(countEnd);
		for(int i=start;i<end;i++) {
			for(int j=0;j<studentNameList.size();j++) {
				if(expectedStudentName.equals(studentNameList.get(j).getText())) {
					convertStringToXpath(expectedStudentName).click();
					yesBtn.click();
					flag=true;
					break;
				}
			}
			if(flag==false)
				nextBtn.click();
			else
				break;
		}
		return flag;
	}
		
	
	public WebElement getAllStudentHeader() {
		return allStudentHeader;
	}
}
