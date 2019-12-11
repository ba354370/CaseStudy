package testStepDefinition;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import wrapper.SeleniumWrapper;

public class UKwebsite extends SeleniumWrapper{
	
	final String randomEmail = randomEmailID(7);
	final String randomPassword = randomPassword(9);
	
	String url;
	String browser;
	@Before
	public void loadData()
	{
		data();
		browser = prop.getProperty("browser");
		url = prop.getProperty("uk");
	}
	@Given ("^user launch the UK website$")
	public void launch_url()
	{
		startApp(browser, url);
	}
	@When ("^user click Register-UK$")
	public void register()
	{
		click(locateElement(Locator_LinkText, "Register"));
	}
	@Then ("^user enter Email ID-UK$")
	public void enter_email()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_Email\"]/input"), randomEmail);
	}
	@Then ("^user enter password-UK$")
	public void enter_password()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld password\"]/input"), randomPassword);
	}
	@Then ("^user enter confirm password-UK$")
	public void enter_confirm_password()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_loginConfirmpasswrd\"]/input"), randomPassword);
	}
	@Then ("^user enter Birthday-UK as ([^\"]*) ([^\"]*) ([^\"]*)$")
	public void enter_birthday(String date, String month, String year)
	{
		selectDropDownUsingValue(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_BirthDay\"]/select"), date);
		selectDropDownUsingValue(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_BirthMonth\"]/select"), month);
		selectDropDownUsingValue(locateElement(Locator_Xpath, "//div[@class=\"pc_slct pc_year pc_birthday\"]/select"), year);
	}
	@Then ("^user click Register and create profile-UK$")
	public void create_profile()
	{
		click(locateElement(Locator_Xpath, "//input[@type=\"submit\"]"));
	}
	@Then ("^user enter firstname-UK as (.*)$")
	public void enter_firstname(String firstname)
	{
		type(locateElement(Locator_Xpath, " //span[text()='FIRST NAME']/following-sibling::input"), firstname);
	}
	@Then ("^user enter lastname-UK as (.*)$")
	public void enter_lastname(String lastname)
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_lName\"]/input"), lastname);
	}
	@Then ("^user enter Street_house number-UK as(.*)$")
	public void enter_house_number(String housenumber)
	{
		type(locateElement(Locator_Xpath, " //span[text()='STREET AND HOUSE NUMBER']/following-sibling::input"), housenumber);
	}
	@Then ("^user enter city-UK as(.*)$")
	public void enter_city(String city)
	{
		type(locateElement(Locator_Xpath, " //span[text()='CITY']/following-sibling::input"), city);
	}
	@Then ("^user enter postcode-UK as(.*)$")
	public void enter_postcode(String postcode)
	{
		type(locateElement(Locator_Xpath, " //span[text()='POSTCODE']/following-sibling::input"), postcode);
	}
	@And ("^user click Add profile-UK$")
	public void add_profile()
	{
		click(locateElement(Locator_Xpath, "//div[@class=\"pc_button\"]/input"));
	}
	@Then ("^user enter login Email ID-UK$")
	public void enter_login_emailID()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld username qqq\"]/input"), randomEmail);
	}
	@Then ("^user enter the incorrect password-UK$")
	public void enter_incorrect_password()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld password\"]/input"), randomPassword(9));
	}
	@And ("^user click Signin button-UK$")
	public void click_signin_button()
	{
		click(locateElement(Locator_Xpath, "//div[@class=\"pc_btn\"]/input"));
	}
	@And ("^user verify the Incorrect password text-UK$")
	public void verify_password()
	{
		System.out.println(getText(locateElement(Locator_Xpath, "//span[@class=\"pc_error-message2\"]")));
		verifyPartialText(locateElement(Locator_Xpath, "//span[@class=\"pc_error-message2\"]"), "incorrect");
	}
	@Then ("^user click Forgot password-UK$")
	public void forgot_password()
	{
		click(locateElement(Locator_LinkText, "password?"));
	}
	@Then ("^user enter registered Email ID-UK$")
	public void enter_registered_emailID()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld username qqq\"]/input"), randomEmail);
	}
	@And ("^user click Next-UK$")
	public void click_next()
	{
		click(locateElement(Locator_Xpath, "//div[@class=\"pc_btn\"]/input"));
	}
	
}
