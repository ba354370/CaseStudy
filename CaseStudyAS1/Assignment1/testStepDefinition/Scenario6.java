package testStepDefinition;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wrapper.SeleniumWrapper;

public class Scenario6 extends SeleniumWrapper{
	
	String url;
	String browser;
	
	@Before
	public void loadData()
	{
		data();
		browser = prop.getProperty("browser");
		url = prop.getProperty("url6");
	}
	@Given("^user launch the url6$")
	public void launch_url()
	{
		startApp(browser, url);
	}
	@When("^verify Control group title is (.*)$")
	public void verify_content(String title)
	{
		verifyPartialText(locateElement(Locator_Xpath, "//div[@id=\"content\"]/h1"), title);
	}
	@Then("^user selects the car type as (.*)$")
	public void select_carType(String cartype)
	{
		type(locateElement(Locator_Xpath, "//span[@id=\"car-type-button\"]"), "Luxury");
	}
	@Then("^user selects a transmission as (.*)$")
	public void select_transmission(String transmission)
	{
		switch (transmission.toUpperCase()) {
		case "STANDARD":
			click(locateElement(Locator_Xpath, "//input[@id=\"transmission-standard\"]//preceding::label[text()='Standard']"));
			break;
		case "AUTOMAtIC":
			click(locateElement(Locator_Xpath, "//input[@id=\"transmission-automatic\"]//preceding::label[text()='Automatic']"));
			break;
		}
	}
	@Then("^user selects insurance as (.*)$")
	public void select_insurance(String insurance)
	{
		if(insurance.equalsIgnoreCase("yes"))
		{
			click(locateElement(Locator_Xpath, "//input[@id=\"insurance\"]//preceding::label[text()='Insurance']"));
		}
		else
		{
			System.out.println("Insurance :"+insurance);
		}
	}
	@Then("^user enters number of cars as (.*)$")
	public void select_quantity(String number)
	{
		type(locateElement(Locator_Xpath, "//input[@id=\"horizontal-spinner\"]"), number);
	}
	@Then("^user click on Book Now$")
	public void book()
	{
		click(locateElement(Locator_Xpath, "//input[@id=\"horizontal-spinner\"]//following::button"));
	}
	
	@And("^user close the Browser6$")
	public void close_browser()
	{
		closeBrowser();
	}
}