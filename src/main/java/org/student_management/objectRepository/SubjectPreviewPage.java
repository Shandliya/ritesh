package org.student_management.objectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectPreviewPage {
	public class SubjectRoutingPage {
		 @FindBy(xpath="//tbody/tr/td[2]")
		 private List<WebElement> mySonsSubject;
		 @FindBy(xpath="//a[.='Next']")
		 private WebElement nextBtn;
		 @FindBy(xpath="//a[@aria-controls='example1']")
		 private List<WebElement> pageCount;
		 public SubjectRoutingPage(WebDriver driver) {
			 PageFactory.initElements(driver, this);
		 }
		 public List<String> getMySonsAllSubject() {
			 List<String> listOfAllSubject=new ArrayList<>();
			 for(int i=1;i<pageCount.size()-1;i++) {
				 for(int j=0;j<mySonsSubject.size();j++){
					 listOfAllSubject.add(mySonsSubject.get(j).getText());
				 }
				 nextBtn.click();
			 }
			 return listOfAllSubject;
		 }
		 }
}
