package org.student_management.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentCommonPage {
	WebDriver driver;
	@FindBy(xpath ="//img[@class='user-image']")
	private WebElement parentDropdownLink;
	
	@FindBy(xpath ="//a[.='Sign out']")
	private WebElement signoutLink;
	
	@FindBy(xpath="//a[.=' My Profile']")
	private WebElement myProfileLink;
	
	@FindBy(xpath="//span[.='Profile']")
	private WebElement profileFeature;
	
	@FindBy(xpath="//span[.='Teacher']")
	private WebElement teacherFeature;
	
	@FindBy(xpath="//a[@href='my_sons_teacher.php']")
	private WebElement mySonsTeacherFeature;
	
	@FindBy(xpath="//a[.=' All Teacher']")
	private WebElement allTeacherFeature;
	
	@FindBy(xpath="//span[.='Subject']")
	private WebElement subjectFeature;
	
	@FindBy(xpath="//a[@href='my_sons_subject.php']")
	private WebElement mySonsAllSubject;
	
	@FindBy(xpath="//a[@href='my_sons_payments.php']")
    private WebElement mySonsPayment;
	
	public ParentCommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void logoutAction() {
		parentDropdownLink.click();
		signoutLink.click();
	}
	public ParentCommonPage clickOnProfileAction() {
		profileFeature.click();
		return this;
	}
	public MyProfilePreviewPage clickOnMyProfileAction() {
		myProfileLink.click();
		return new MyProfilePreviewPage(driver);
	}
	public ParentCommonPage clickOnTeacherAction(){
		teacherFeature.click();
		return this;
	}
	public TeacherPreviewPage clickOnAllTeacherAction() {
		allTeacherFeature.click();
		return new TeacherPreviewPage(driver);//WHY WE USE NEW
	}
	public TeacherPreviewPage clickOnMySonsTeacherAction() {
		mySonsTeacherFeature.click();
		return new TeacherPreviewPage(driver);
	}
	public void clickOnSubjectAction() {
		subjectFeature.click();
	}
	public void clickOnMYSonsAllSubjectAction() {
		mySonsAllSubject.click(); 
	}
	public void clickOnMySonsPaymentAction() {
		mySonsPayment.click();
	}
}
