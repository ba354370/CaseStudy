package wrapper;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface WdMethods {		
	
		public void startApp(String browser,String url);

		public WebElement locateElement(String locator, String locValue) ;	
		
		public List<WebElement> locateMultiElement(String locator, String locValue);
		
		public void type(WebElement ele, String data) ;
		
		public void click(WebElement ele);
		
		public void keyActions(WebElement ele, Keys key);
		
		public void rightClickNewtab(WebElement ele);
		
		public void dragDrop(WebElement source, WebElement target);

		public String getText(WebElement ele);
		
		public void setDate(WebElement ele, String date);

		public void selectDropDownUsingText(WebElement ele, String value) ;
		
		public void selectDropDownUsingIndex(WebElement ele, int index) ;
		
		public void selectDropDownUsingValue(WebElement ele, String value);

		public void selectDropDownUsingVisibleText(WebElement ele, String dropDownText);
		
		public boolean verifyTitle(String expectedTitle);
		
		public void verifyExactText(WebElement ele, String expectedText);
		
		public void verifyPartialText(WebElement ele, String expectedText);

		public void verifyExactAttribute(WebElement ele, String attribute, String value);
	
		public void verifyPartialAttribute(WebElement ele, String attribute, String value);
	
		public void verifySelected(WebElement ele);
		
		public void verifyDisplayed(WebElement ele);
	
		public void switchToWindow(int index);
		
		public void switchToFrame(WebElement ele);
	
		public void acceptAlert();
	
		public void dismissAlert();
	
		public String getAlertText();
		
		public void takeSnap();
		
		public void closeBrowser();		
	
		public void closeAllBrowsers();

}