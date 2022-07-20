package org.student_management.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCommonPage {
	WebDriver driver;
    public AdminCommonPage(WebDriver driver) {
   	 this.driver=driver;
   	 PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[.='Student']")
    private WebElement studentTab;
    @FindBy (xpath="//a[@href='all_student.php']")
    private WebElement allStudentLink;
    
    @FindBy(xpath ="//img[@class='user-image']")
	private WebElement adminDropdownLink;
	@FindBy(xpath ="//a[.='Sign out']")
	private WebElement signoutLink;
	
	public AdminCommonPage clickStudentTabAction() {
	   	 studentTab.click();
	   	 return this;
	    }
	    public AllStudentPage clickAllStudentAction() {
	   	 allStudentLink.click();
	   	 return new AllStudentPage(driver);
	    }
	    public void signoutAction() {
	   	 adminDropdownLink.click();
	   	 signoutLink.click();
	    }

}
	




























