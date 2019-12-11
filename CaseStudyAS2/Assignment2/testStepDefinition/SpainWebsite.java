package testStepDefinition;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wrapper.SeleniumWrapper;

public class SpainWebsite extends SeleniumWrapper{
	final String randomEmail = randomEmailID(7);
	final String randomPassword = randomPassword(9);

	String url;
	String browser;

	@Before
	public void loadData() {
		data();
		browser = prop.getProperty("browser");
		url = prop.getProperty("spain");
	}

	@Given("^user launch the Spain website$")
	public void launch_url() {
		startApp(browser, url);
	}

	@When("^user click Register-SP$")
	public void register() {
		click(locateElement(Locator_LinkText, "Registro"));
	}
	@Then("^user select gender-SP$")
	public void select_gender() {
		String gender = jsonData().getGender();
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
	@Then("^user enter firstname-SP$")
	public void enter_firstname() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_fName\"]/input"), jsonData().getFirstname());
	}
	@Then("^user enter lastname-SP$")
	public void enter_lastname() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_lName\"]/span[text()='APELLIDO']/following-sibling::input"), jsonData().getLastname());
	}
	@Then("^user enter surname-SP$")
	public void enter_surname() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_lName\"]/span[text()='SEGUNDO APELLIDO']/following-sibling::input"), jsonData().getLastname());
	}
	@Then("^user enter Email ID-SP$")
	public void enter_email() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_Email\"]/input"), jsonData().getEmail());
	}
	@Then("^user enter password-SP$")
	public void enter_password() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld password\"]/input"), jsonData().getPassword());
	}
	@Then("^user enter confirm password-SP$")
	public void enter_confirm_password() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_loginConfirmpasswrd\"]/input"), jsonData().getPassword());
	}
	@Then("^user enter Birthday-SP$")
	public void enter_birthday() {
		selectDropDownUsingVisibleText(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_BirthDay\"]/select"),jsonData().getBirthday().getDay());
		selectDropDownUsingVisibleText(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_BirthMonth\"]/select"),jsonData().getBirthday().getMonth());
		selectDropDownUsingVisibleText(locateElement(Locator_Xpath, "//div[@class=\"pc_slct pc_year pc_birthday\"]/select"), jsonData().getBirthday().getYear());
	}
	@Then("^user enter phone number-SP$")
	public void enter_phone_number() {
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld pc_PhoneNumber\"]/input"),jsonData().getPhonenumber());
	}
	@And("^user click register button-SP$")
	public void click_register() {
		click(locateElement(Locator_Xpath, "//div[@class=\"button-link\"]//input"));
	}
	@Then ("^user enter login Email ID-SP$")
	public void enter_login_emailID()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld username qqq\"]/input"), jsonData().getEmail());
	}
	@Then ("^user enter the incorrect password-SP$")
	public void enter_incorrect_password()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld password\"]/input"), randomPassword(9));
	}
	@And ("^user click Signin button-SP$")
	public void click_signin_button()
	{
		click(locateElement(Locator_Xpath, "//div[@class=\"pc_btn\"]/input"));
	}
	@And ("^user verify the Incorrect password text-SP$")
	public void verify_password()
	{
		System.out.println(getText(locateElement(Locator_Xpath, "//span[@class=\"pc_error-message2\"]")));
		verifyPartialText(locateElement(Locator_Xpath, "//span[@class=\"pc_error-message2\"]"), "incorrecta");
	}
	@Then ("^user click Forgot password-SP$")
	public void forgot_password()
	{
		click(locateElement(Locator_LinkText, "contraseña?"));
	}
	@Then ("^user enter registered Email ID-SP$")
	public void enter_registered_emailID()
	{
		type(locateElement(Locator_Xpath, "//div[@class=\"pc_txtfld username qqq\"]/input"), jsonData().getEmail());
	}
	@And ("^user click Next-SP$")
	public void click_next()
	{
		click(locateElement(Locator_Xpath, "//div[@class=\"pc_btn\"]/input"));
	}

}
