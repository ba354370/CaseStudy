package testStepDefinition;


import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import wrapper.SeleniumWrapper;

public class Scenario5 extends SeleniumWrapper{
	String url;
	String browser;
	
	@Before
	public void loadData()
	{
		data();
		browser = prop.getProperty("browser");
		url = prop.getProperty("ur4");
	}
	@Given("^user launch the url5$")
	public void launch_url()
	{
		startApp(browser, url);
	}
	@When("^verify Selectmenu title is (.*)$")
	public void verify_content(String title)
	{
		verifyPartialText(locateElement(Locator_Xpath, "//div[@id=\"content\"]/h1"), title);
	}
	@Then("^user selects the speed as (.*)$")
	public void select_speed(String speed)
	{
		type(locateElement(Locator_Xpath, "//span[@id=\"speed-button\"]"), speed);
	}
	@Then("^user selects a file as (.*)$")
	public void select_file(String file)
	{
		type(locateElement(Locator_Xpath, "//span[@id=\"files-button\"]"), file);
	}
	@Then("^user selects a number as (.*)$")
	public void select_number(String number)
	{
		type(locateElement(Locator_Xpath, "//span[@id=\"number-button\"]"), number);
	}
	@Then("^user selects a title as (.*)$")
	public void select_title(String title)
	{
		type(locateElement(Locator_Xpath, "//span[@id=\"salutation-button\"]"), title);
	}
	@And("^user close the Browser5$")
	public void close_browser()
	{
		closeBrowser();
	}
}
