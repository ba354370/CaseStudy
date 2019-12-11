package testStepDefinition;


import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import wrapper.SeleniumWrapper;

public class Scenario3 extends SeleniumWrapper{
	String url;
	String browser;
	
	@Before
	public void loadData()
	{
		data();
		browser = prop.getProperty("browser");
		url = prop.getProperty("ur3");
	}
	
	@Given("^user launch the url3$")
	public void launch_url()
	{
		startApp(browser, url);
	}
	
	@When("^verify Droppable title is (.*)$")
	public void verify_content(String title)
	{
		verifyPartialText(locateElement(Locator_Xpath, "//div[@id=\"content\"]/h1"), title);
	}
	
	@Then("^user drag and drops the item$")
	public void drag_drop()
	{
		dragDrop(locateElement(Locator_Xpath, "//div[@id=\"draggable\"]"), locateElement(Locator_Xpath, "//div[@id=\"droppable\"]"));
	}
	
	@And("^user close the Browser3$")
	public void close_browser()
	{
		closeBrowser();
	}
}
