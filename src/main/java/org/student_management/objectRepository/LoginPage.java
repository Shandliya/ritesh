package org.student_management.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	@FindBy(name = "user_name")
	private WebElement usernameTextFiled;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordTextFiled;
	
	public WebElement getUsernameTextFiled() {
		return usernameTextFiled;
	}
	public WebElement getPasswordTextFiled() {
		return passwordTextFiled;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	@FindBy(xpath="//button[@id='btnSubmit']")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void  loginAction(String username,String password)
	{
		usernameTextFiled.sendKeys(username);
		passwordTextFiled.sendKeys(password);
		loginBtn.click();
		
	}

}
