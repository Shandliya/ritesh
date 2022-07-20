package org.tyss.genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains all the webdriver actions
 * @author rites
 *
 */

public final class WebDriverUtility {
	private WebDriver driver;
	Select select;
	WebDriverWait wait;
	/**
	 * This method will setup the browser 
	 */
	public WebDriver setupBrowser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		}
		return driver;
	}
	/**
	 * This method will maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	/**
	 * This method will implicitly holds the execution till element is visible
	 * @param longTimeouts
	 */
	public void implicitWait(long longTimeouts) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeouts));
	}
	/**
	 * This method will initiallize WebDriverWait
	 * @param longTimeouts
	 */
	public void initiallizeExplicitWait(long longTimeouts) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(longTimeouts));
	}
	/**
	 * This method will explicitly holds the execution till element is visible
	 * @param element
	 */
	public void waitTillElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will explicitly holds the execution till element is Invisible
	 * @param element
	 */
	public void waitTillElementInVisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	/**
	 * This method will navigate to application based on given url
	 * @param url
	 */
	public void navigateToApplication(String url) {
		driver.get(url);
	}
	/**
	 * This method will close the current browser
	 */
	public void closeBrowser() {
		driver.close();
	}
	/**
	 * This method will close all the tabs,parent tab as well as child tab
	 */
	public void closeAllTabs() {
		driver.quit();
	}
	/**
	 * This method will mousehover to a perticular element
	 * @param element
	 * @param driver
	 */
	public void mouseHoverToElement(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This is the method overloading will select dropdownoption using value
	 * @param element
	 * @param value
	 */
	public void selectDropdown(WebElement element,String value) {
		select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This is the method overloading will select dropdownoption using visibletext
	 * @param visibleText
	 * @param element
	 */
	public void selectDropdown(String visibleText,WebElement element) {
		select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	/**
	 * This is the method overloading will select dropdownoption using index
	 * @param index
	 * @param element
	 */
	public void selectDropdown(int index,WebElement element) {
		select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method will switch the window/tab based on startegy(url or title)
	 * @param startegy
	 * @param element
	 */
	public void swichToWindow(String startegy) {
		Set<String> allWhs = driver.getWindowHandles();
		for(String wh:allWhs) {
			driver.switchTo().window(wh);
			if(startegy.contains(driver.getCurrentUrl()))
				break;
			else if(startegy.equalsIgnoreCase(driver.getTitle()))
				break;
		}
	}
	public void switchFrame(String indexOrText) {
		driver.switchTo().frame(indexOrText);
	}
	public void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method will switch the control from frame to parent frame or default frame based on our startegy
	 * startegy(parent or default
	 * @param startegy
	 */
	public void switchBackFromFrame(String startegy) {
		if(startegy.equalsIgnoreCase("parent"))
			driver.switchTo().parentFrame();
		else if(startegy.equalsIgnoreCase("default"))
			driver.switchTo().defaultContent();
	}
	/**
	 * This method will hold the execution till element is clickable
	 * @param totalDuration
	 * @param longPollingTime
	 * @param element
	 */
	public void customWaitTillElementClickable(int totalDuration,long longPollingTime,WebElement element) {
		int count=0;
		while(count<=totalDuration) {
			try {
				element.click();
				break;
			}
			catch (Exception e) {
				try {
					Thread.sleep(longPollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * This method will accept alert popup
	 */
	public void alertPopupAccept() {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss alert popup
	 */
	public void alertPopupDismiss() {
		driver.switchTo().alert().dismiss();
	}

}



	

	

