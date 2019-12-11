package wrapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.Before;
import utils.readData;

public class SeleniumWrapper extends WrapperConstants implements WdMethods {

	public static RemoteWebDriver driver = null;
	Actions act = null;
	private int i = 1;
	public Properties prop;
	readData data = new readData();

	public void data() {
		try {
			prop = data.readProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startApp(String browser, String url) {
		try {
			switch (browser.toUpperCase()) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", Chrome_Driver_File_Path);
				driver = new ChromeDriver();
				break;
			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver", Firefox_Driver_File_Path);
				FirefoxOptions options = new FirefoxOptions();
		    	options.setCapability("marionette", false);
				driver = new FirefoxDriver(options);
				break;
			default:
				System.setProperty("webdriver.chrome.driver", Chrome_Driver_File_Path);
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			System.out.println(browser + "Browser launched successfully and loaded with the " + url);

		} /*
			 * catch (IllegalStateException e) { throw new IllegalStateException
			 * ("Invalid browser parameters passed"); }
			 */ catch (NullPointerException e) {
			throw new NullPointerException("Browser is not opened");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public WebElement locateElement(String locator, String locValue) {
		WebElement element = null;
		try {
			switch (locator.toLowerCase()) {
			case Locator_ID:
				element = driver.findElementById(locValue);
				break;
			case Locator_ClassName:
				element = driver.findElementByClassName(locValue);
				break;
			case Locator_Name:
				element = driver.findElementByName(locValue);
				break;
			case Locator_LinkText:
				element = driver.findElementByLinkText(locValue);
				break;
			case Locator_PartialLinkText:
				element = driver.findElementByPartialLinkText(locValue);
				break;
			case Locator_TagName:
				element = driver.findElementByTagName(locValue);
				break;
			case Locator_Xpath:
				element = driver.findElementByXPath(locValue);
				break;

			default:
				element = null;
				break;
			}

		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public void type(WebElement ele, String data) {
		try {
			// ele.clear();
			ele.sendKeys(data);
			System.out.println(data + " entered successfully in the element " + ele);
		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println(ele + "Element clicked successfully");
		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void rightClickNewtab(WebElement ele) {
		try {
			act = new Actions(driver);
			act.contextClick(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
			act.build().perform();
			// act.contextClick(ele).perform();
			// act.sendKeys(Keys.ARROW_DOWN).build().perform();
			System.out.println(ele + "Element clicked successfully");
		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void dragDrop(WebElement source, WebElement target) {
		try {
			act = new Actions(driver);
			act.clickAndHold(source).build().perform();
			act.click(target).build().perform();
			act.release(target).build().perform();
		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public String getText(WebElement ele) {
		String txt = null;
		try {
			txt = ele.getText();
			System.out.println(ele + "Element text is taken successfully");
		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
		return txt;
	}

	public void setDate(WebElement ele, String date) {
		try {
			ele.clear();
			ele.sendKeys(date);
			Thread.sleep(500);
		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			ele.sendKeys(value);
			System.out.println(ele + "Dropdown is selected using text successfully");
		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select select = new Select(ele);
			select.selectByIndex(index);
			System.out.println(ele + "Dropdown is selected using index successfully");
		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}
	
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select select = new Select(ele);
			select.selectByValue(value);
			System.out.println(ele + "Dropdown is selected using value successfully");
		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}


	public void selectDropDownUsingVisibleText(WebElement ele, String visibleText) {
		try {
			Select select = new Select(ele);
			select.selectByVisibleText(visibleText);
			System.out.println(ele + "Dropdown is selected using visible text successfully");
		} catch (NullPointerException e) {
			throw new NullPointerException("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	@SuppressWarnings("finally")
	public boolean verifyTitle(String expectedTitle) {
		boolean title = false;
		try {
			if (driver.getTitle().equalsIgnoreCase(expectedTitle)) {
				title = true;
				System.out.println(expectedTitle + ":Title verified successfully");
			} else {
				title = false;
				System.out.println(expectedTitle + ":Title is mismatched");
			}
		} catch (NullPointerException e) {
			System.err.println("Title is not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return title;
		}

	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if (ele.getText().equalsIgnoreCase(expectedText))
				System.out.println(expectedText + ":Text verified successfully");
			else
				System.out.println(expectedText + ":Text is mismatched");
		} catch (NullPointerException e) {
			System.err.println("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if (ele.getText().toUpperCase().contains(expectedText.toUpperCase()))
				System.out.println(expectedText + ":Text verified successfully");
			else
				System.out.println(expectedText + ":Text is mismatched");
		} catch (NullPointerException e) {
			System.err.println("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if (ele.getAttribute(attribute).equalsIgnoreCase(value))
				System.out.println(value + ":Attribute value is verified successfully");
			else
				System.out.println(value + ":Attribute value is mismatched");
		} catch (NullPointerException e) {
			System.err.println("Attribute not available");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if (ele.getAttribute(attribute).toUpperCase().contains(value.toUpperCase()))
				System.out.println(value + ":Attribute value is verified successfully");
			else
				System.out.println(value + ":Attribute value is mismatched");
		} catch (NullPointerException e) {
			System.err.println("Attribute not available");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			if (ele.isSelected())
				System.out.println(ele + ":Element is selected");
			else
				System.out.println(ele + ":Element is not selected");
		} catch (NullPointerException e) {
			System.err.println("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			if (ele.isDisplayed())
				System.out.println(ele + ":Element is displayed");
			else
				System.out.println(ele + ":Element is not displayed");
		} catch (NullPointerException e) {
			System.err.println("Webelement not available");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void switchToWindow(int index) {
		try {
			List<String> windowHandles = new ArrayList<>();
			windowHandles.addAll(driver.getWindowHandles());
			driver.switchTo().window(windowHandles.get(index));
			System.out.println("Switched to the indexed window successfully");
		} catch (NoSuchWindowException e) {
			throw new NoSuchWindowException("Window is not opened");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			System.out.println("Switched to the frame successfully");
		} catch (NoSuchFrameException e) {
			throw new NoSuchFrameException("Frame is not available");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void acceptAlert() {
		try {
			takeSnap();
			driver.switchTo().alert().accept();
			System.out.println("Alert accepted");
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException("Alert is not available");
		} catch (UnhandledAlertException e) {
			throw new UnhandledAlertException("Alert is not handled");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void dismissAlert() {
		try {
			takeSnap();
			driver.switchTo().alert().dismiss();
			System.out.println("Alert dismissed");
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException("Alert is not available");
		} catch (UnhandledAlertException e) {
			throw new UnhandledAlertException("Alert is not handled");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	@SuppressWarnings("finally")
	public String getAlertText() {
		try {
			takeSnap();
			System.out.println("Getting Alert text");
		} catch (NoAlertPresentException e) {
			System.err.println("Alert is not available");
		} catch (UnhandledAlertException e) {
			System.err.println("Alert is not handled");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return driver.switchTo().alert().getText();
		}
	}

	public void takeSnap() {

		File srcfile = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("./snaps/Image" + i + ".png"));
			i++;
		} catch (IOException e) {
			System.err.println("Exception occured while taking snapshot");
		}
	}

	public void closeBrowser() {
		try {
			Thread.sleep(1000);
			driver.close();
			System.out.println("Current browser is closed");
		} catch (NullPointerException e) {
			throw new NullPointerException("Browser is not opened");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("All browsers were closed");
		} catch (NullPointerException e) {
			throw new NullPointerException("Browser is not opened");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
