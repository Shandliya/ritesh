package org.student_management.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPreviewPage {
	@FindBy(xpath="//span[.='Total Student']/following-sibling::span")
	private WebElement totalStudentCount;
	@FindBy(xpath="//span[.='Total Teacher']/following-sibling::span")
	private WebElement totalTeacherCount;
	@FindBy(xpath="//span[.='Monthly Fee']/following-sibling::span")
	private WebElement monthlyFee;

  public DashboardPreviewPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  public int getTotalStudentCount() {
	  String count = totalStudentCount.getText();//gettext returns the text froom the single line text field.It returns only the first line of a multi line text filed.
	  return Integer.parseInt(count);//This returns an integer,given a string representation of decimal,binary,octal or hexadecimal.
  }
  public int getTotalTeacherCount() {
	  String count = totalTeacherCount.getText();
	  return Integer.parseInt(count);
  }
  public  int getMonthlyFee() {
	  String fee = monthlyFee.getText();
	  return Integer.parseInt(fee);
  }
}
  
