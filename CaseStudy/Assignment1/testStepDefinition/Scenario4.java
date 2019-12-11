package testStepDefinition;


import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import wrapper.SeleniumWrapper;

public class Scenario4 extends SeleniumWrapper{
	String url;
	String browser;
	
	@Before
	public void loadData()
	{
		data();
		browser = prop.getProperty("browser");
		url = prop.getProperty("ur4");
	}
	@Given("^user launch the url4$")
	public void launch_url()
	{
		startApp(browser, url);
	}
	
	@When("^verify Datepicker title is (.*)$")
	public void verify_content(String title)
	{
		verifyPartialText(locateElement(Locator_Xpath, "//div[@id=\"content\"]/h1"), title);
	}
	
	@Then("^user selects the birth date as (.*)$")
	public void date_picker(String birthdate)
	{
		setDate(locateElement(Locator_Xpath, "//input[@id=\"datepicker\"]"), birthdate);
	}
	
	@And("^user close the Browser4$")
	public void close_browser()
	{
		closeBrowser();
	}
}
