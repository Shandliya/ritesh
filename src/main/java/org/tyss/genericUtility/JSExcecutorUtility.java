package org.tyss.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;

public final class JSExcecutorUtility {
	private JavascriptExecutor js;
/**
 * 
 * This class contains all the JS reusable Method/actions
 * @author rupesh
 */
	public void intiallizeJSExecutor(WebDriver driver) {
		js=(JavascriptExecutor)driver;
	}
	/**
	 * Intialize the javascript executor
	 * @param url
	 */
	public void navigateApp(String url)
	{
		js.executeScript("window.location=arguments[0]",url);
	}
	/**
	 * This method is used to send the data to textfiled using JSExecutor
	 * @param element
	 * @param data
	 */
	
	
	public void enterData(WebElement element,String data)
	{
		
	js.executeScript("arguments[0].click()", element);
	
}
	/**
	 * 
	 * This method is used to click on the element using JSExecutor
	 * @param element
	 */
	
	public void clickOnElement(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
}
	/**
	 * This method is used to scroll till the end of page
	 * @param strategy
	 */
	public void scrollTillEnd(String strategy)
	{
		String sign = strategy.equalsIgnoreCase("up")? "_":"+";
		js.executeScript("window.scrollBy(0,"+sign+"document.body.scrollHeight)");
	}
	/**
	 * This method is used to scroll till some postion
	 * @param y_position
	 * @param strategy
	 */
	public void scrollTillSomePosition(int y_position,String strategy)
	{
		String sign = strategy.equalsIgnoreCase("up") ? "_" : "+";
		js.executeScript("window.scrollBy(0,"+sign+"arguments[0])",y_position);
	}
	/**
	 * This element is used to scroll till the element is visible
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()",element);
		
	}
	public void highlightElement(WebElement element)
	{
		js.executeScript("arguments[0].setAttribute('style',border:5px solid red;')",element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
