package org.student_management.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePreviewPage {
	@FindBy(xpath="//input[@id='full_name1']")
	private WebElement fullNameTextField;
	
	@FindBy(xpath="//a[@id='btnEdit']")
	private WebElement editMyProfileLink;
	
	@FindBy(xpath="//button[@id='btnUpdate']")
	private WebElement updateBtn;
	
	@FindBy(xpath="//td[@id='full_name']")
	private WebElement actualFullnameTextBox;
	
	@FindBy(xpath="//section[@class='content-header']")
	private WebElement myProfileHeader;
	
	@FindBy(xpath="(//strong[.='Success!']/parent::div/preceding-sibling::div/h4)[2]")
	private WebElement infomationPopUp;
	
	public MyProfilePreviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);//PAGEFACTORY.INT ELEMENTS()STATIC METHOD TAKES THE DRIVER INSTANCE OF THE GIVEN CLASS AND THE CLASS TYPE AND RETURNS A PAGE OBJECT WITH ITS FIELDS FULLY INITIALIZED.
	}
	public MyProfilePreviewPage updateParentFullName(String expectedFullname) {
		editMyProfileLink.click();
		//fullNameTextField.clear();
		fullNameTextField.sendKeys(Keys.CONTROL,"a");
		fullNameTextField.sendKeys(expectedFullname);
		updateBtn.click();
		return this;
}
	public boolean verifyProfileUpdate(String expectedFullname) {
		return expectedFullname.equals(actualFullnameTextBox.getText().trim());
	}
	public WebElement getInformationPopup() {
		return infomationPopUp;
	}
}

