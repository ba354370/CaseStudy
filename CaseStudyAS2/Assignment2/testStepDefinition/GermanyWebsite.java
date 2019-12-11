package testStepDefinition;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wrapper.SeleniumWrapper;

public class GermanyWebsite extends SeleniumWrapper {
	final String randomEmail = randomEmailID(7);
	final String randomPassword = randomPassword(9);

	String url;
	String browser;

	@Before
	public void loadData() {
		data();
		browser = prop.getProperty("browser");
		url = prop.getProperty("germany");
	}

	@Given("^user launch the Germany website$")
	public void launch_url() {
		startApp(browser, url);
	}

	@When("^user click Register-GE$")
	public void register() {
		click(locateElement(Locator_LinkText, "Registrieren"));
	}

	@Then("^user select gender-GE$")
	public void select_gender() {
		String gender = data.excelData(1, "gender");
		switch (gender) {
		case "male":
			click(locateElement(Locator_Xpath, "//div[@class=\"pc_slct gender\"]//li[@class=\"male\"]/a"));
			break;
		case "female":
			click(locateElement(Locator_Xpath, "//div[@class=\"pc_slct gender\"]//li[@class=\"female\"]/a"));
			break;
		default:
			System.out.println("Please select gender");
			break;
		}
	}
	@Then("^user enter firstname-GE$")
	public void enter_firstname() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_fName\"]/span[text()='VORNAME']/following-sibling::input"), data.excelData(1, "Firstname"));
	}
	@Then("^user enter lastname-GE$")
	public void enter_lastname() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_lName\"]/input"), data.excelData(1, "Lastname"));
	}
	@Then("^user enter Email ID-GE$")
	public void enter_email() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_Email\"]/input"), data.excelData(1, "emailID"));
	}
	@Then("^user enter password-GE$")
	public void enter_password() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld password\"]/input"), data.excelData(1, "password"));
	}

	@Then("^user enter confirm password-GE$")
	public void enter_confirm_password() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_loginConfirmpasswrd\"]/input"), data.excelData(1, "password"));
	}
	@Then("^user enter Birthday-GE$")
	public void enter_birthday() {
		selectDropDownUsingVisibleText(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_BirthDay\"]/select"),data.excelData(1, "birth day"));
		selectDropDownUsingVisibleText(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_BirthMonth\"]/select"),data.excelData(1, "birth month"));
		selectDropDownUsingVisibleText(locateElement(Locator_Xpath, "//div[@class=\"pc_slct pc_year pc_birthday\"]/select"), data.excelData(1, "birth year"));
	}
	@Then("^user select Country-GE$")
	public void select_country() {
		String country = data.excelData(1, "country");
		switch (country.toLowerCase()) {
		case "germany":
			selectDropDownUsingValue(locateElement(Locator_Xpath, "//div[@class=\"countrylist\"]/select"), "DEU");
			break;
		case "austria":
			selectDropDownUsingValue(locateElement(Locator_Xpath, "//div[@class=\"countrylist\"]/select"), "AUT");
			break;
		default:
			System.out.println("Please select country");
			break;
		}
	}
	
	@Then("^user enter house number-GE$")
	public void enter_house_number() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_Addressline1\"]/input"),data.excelData(1, "house number"));
	}
	@Then("^user enter postcode-GE$")
	public void enter_postcode() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld\"]/input"), data.excelData(1, "postcode"));
	}
	@Then("^user enter Location-GE$")
	public void enter_location() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_fName\"]/span[text()='ORT']/following-sibling::input"),data.excelData(1, "location"));
	}
	@And("^user click Create account-GE$")
	public void create_account() {
		click(locateElement(Locator_Xpath, "//div[@class=\"button-link\"]//input"));
	}
	@Then("^user click on login-GE$")
	public void login() {
		click(locateElement(Locator_LinkText, "Anmelden"));
	}
	@Then ("^user enter login Email ID-GE$")
	public void enter_login_emailID()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld username qqq\"]/input"), data.excelData(1, "emailID"));
	}
	@Then ("^user enter the incorrect password-GE$")
	public void enter_incorrect_password()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld password\"]/input"), randomPassword(9));
	}
	@And("^user click Signin button-GE$")
	public void click_signin_button() {
		click(locateElement(Locator_Xpath, "//div[@class=\"pc_btn\"]/input"));
	}
	@And("^user verify the Incorrect password text-GE$")
	public void verify_password() {
		System.out.println(getText(locateElement(Locator_Xpath, "//span[@class=\"pc_error-message2\"]")));
		verifyPartialText(locateElement(Locator_Xpath, "//span[@class=\"pc_error-message2\"]"), "ungültig");
	}
	@Then("^user click Forgot password-GE$")
	public void forgot_password() {
		click(locateElement(Locator_LinkText, "Neues Kennwort erstellen."));
	}
	@Then("^user enter registered Email ID-GE$")
	public void enter_registered_emailID() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld username qqq\"]/input"), data.excelData(1, "emailID"));
	}
	@And("^user click Next-GE$")
	public void click_next() {
		click(locateElement(Locator_Xpath, "//div[@class=\"pc_btn\"]/input"));
	}

}
