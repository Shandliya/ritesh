package org.student_management.objectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MySonsPaymentPreviewPage {
	    @FindBy(xpath="//tbody/tr/td[6]")
	    private List<WebElement> paymentDates;
	    
	    @FindBy(xpath="//a[@aria-controls='example1']")
	    private List<WebElement> pageCount;
	    
	    @FindBy(xpath="//a[.='Next']")
	    private WebElement nextBtn;
	    
	    @FindBy(xpath="//span[@id='spanPaid']")
	    private WebElement totalPayment;
	    
	    public MySonsPaymentPreviewPage(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    }
	    
	    public void viewPaymentDetails(String date) {//DOUBT
	    	List<String> list=new ArrayList<>();
	    	for(int i=1;i<pageCount.size()-1;i++) {
	    		for(int j=0;j<paymentDates.size();j++) {
	    			if(date.equals(paymentDates.get(j).getText())){
	    			 //continue
	    			}
	    		}
	    	}
	    }
}
	    
