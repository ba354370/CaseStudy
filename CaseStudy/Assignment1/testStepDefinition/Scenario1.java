package testStepDefinition;

import java.util.List;

import org.openqa.selenium.WebElement;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import wrapper.SeleniumWrapper;

public class Scenario1 extends SeleniumWrapper{
	String url;
	String browser;
	
	@Before
	public void loadData()
	{
		data();
		browser = prop.getProperty("browser");
		url = prop.getProperty("url1");
	}
	
	@Given("^user launch the url1$")
	public void launch_url()
	{
		startApp(browser, url);
	}
	@When("^Verify Selectables title name is (.*)$")
	public void verify_content(String title)
	{
		verifyPartialText(locateElement(Locator_Xpath, "//div[@id=\"content\"]/h1"), title);
	}
	@Then("^user click and print item name$")
	public void click_print_item()
	{
		List<WebElement> itemList = driver.findElementsByXPath("//ol[@id=\"selectable\"]/li");
		for(WebElement ele: itemList)
		{
			click(ele);
			System.out.println("--->"+getText(ele)+"<---");
		}	
	}
	@And("^user close the Browser1$")
	public void close_browser()
	{
		closeBrowser();
	}
}
