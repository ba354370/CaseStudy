package testStepDefinition;

import java.util.List;
import org.openqa.selenium.WebElement;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import wrapper.SeleniumWrapper;

public class Scenario2 extends SeleniumWrapper{
	String url;
	String browser;
	
	@Before
	public void loadData()
	{
		data();
		browser = prop.getProperty("browser");
		url = prop.getProperty("url2");
	}
	@Given("^user launch the url2$")
	public void launch_url()
	{
		startApp(browser, url);
	}
	@When("^verify Contact form title is (.*)$")
	public void verify_content(String title)
	{
		verifyPartialText(locateElement(Locator_Xpath, "//div[@id=\"content\"]/h1"), title);
	}
	@Then("^user enters firstname as (.*)$")
	public void enter_firstname(String firstname)
	{
		type(locateElement(Locator_Xpath, "//input[@class=\"firstname\"]"), firstname);
	}
	@Then("^user enters lastname as (.*)$")
	public void enter_lastname(String lastname)
	{
		type(locateElement(Locator_Xpath, "//input[@id=\"lname\"]"), lastname);
	}
	@Then("^user enters country as (.*)$")
	public void enter_country(String country)
	{
		type(locateElement(Locator_Xpath, "//input[@name=\"country\"]"), country);
	}
	@Then("^user verify links with partial text (.*)$")
	public void verify_links(String linktext)
	{
		List<WebElement> linkList = driver.findElementsByPartialLinkText(linktext);
		System.out.println("count "+linkList.size());
		int i=0;
		for(WebElement ele: linkList)
		{
			List<WebElement> linkList1 = driver.findElementsByPartialLinkText(linktext);
			rightClickNewtab(linkList1.get(i));
			System.out.println("page title --->"+driver.getTitle()+"<---");
			//switchToWindow(0);
			i++;
		}
	}
	@Then("^user enters subject as (.*)$")
	public void enter_subject(String subject)
	{
		type(locateElement(Locator_Xpath, "//*[@name=\"subject\"]"), subject);
	}
	@Then("^user clicks on submit$")
	public void click_submit()
	{
		click(locateElement(Locator_Xpath, "//input[@type=\"submit\"]"));
	}
	@And("^user close the Browser2$")
	public void close_browser()
	{
		closeBrowser();
	}

}
