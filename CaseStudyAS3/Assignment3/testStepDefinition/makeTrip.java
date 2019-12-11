package testStepDefinition;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wrapper.SeleniumWrapper;

public class makeTrip extends SeleniumWrapper {
	String url;
	String browser;

	@Before
	public void loadData() {
		data();
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
	}

	@Given("^user launch the MakeMyTrip website$")
	public void launch_url() {
		startApp(browser, url);
	}

	@When("^user is in home page$")
	public void verify_title() {
		verifyTitle("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
	}

	@Then("user select trip mode$")
	public void trip_mode() {
		String tripMode = jsonData().getTripMode();
		switch (tripMode.toLowerCase()) {
		case "oneway":
			click(locateElement(Locator_Xpath, "//div[@class=\"makeFlex\"]//li[@data-cy=\"oneWayTrip\"]"));
			break;
		case "roundtrip":
			click(locateElement(Locator_Xpath, "//div[@class=\"makeFlex\"]//li[@data-cy=\"roundTrip\"]"));
			break;
		case "multicitytrip":
			click(locateElement(Locator_Xpath, "//div[@class=\"makeFlex\"]//li[@data-cy=\"mulitiCityTrip\"]"));
			break;
		default:
			System.out.println("Please select Trip mode");
			break;
		}
	}

	@Then("^user Select From and To$")
	public void select_From_To() {
		String tripMode = jsonData().getTripMode();
		System.out.println(tripMode.toLowerCase());
		if (tripMode.toLowerCase().equals("multicitytrip")) {
			// from1
			click(locateElement(Locator_Xpath, "//input[@id=\"fromAnotherCity0\"]"));
			type(locateElement(Locator_Xpath,
					"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"), jsonData().getFrom());
			keyActions(
					locateElement(Locator_Xpath,
							"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"),
					Keys.ARROW_DOWN);
			keyActions(
					locateElement(Locator_Xpath,
							"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"),
					Keys.ENTER);

			// to1
			click(locateElement(Locator_Xpath, "//input[@id=\"toAnotherCity0\"]"));
			type(locateElement(Locator_Xpath,
					"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"), jsonData().getTo());
			keyActions(
					locateElement(Locator_Xpath,
							"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"),
					Keys.ARROW_DOWN);
			keyActions(
					locateElement(Locator_Xpath,
							"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"),
					Keys.ENTER);
			keyActions(locateElement(Locator_Xpath, "//input[@id=\"toAnotherCity0\"]"), Keys.ESCAPE);

			// to2

			click(locateElement(Locator_Xpath, "//input[@id=\"toAnotherCity1\"]"));
			type(locateElement(Locator_Xpath,
					"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"), jsonData().getTo2());
			keyActions(
					locateElement(Locator_Xpath,
							"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"),
					Keys.ARROW_DOWN);
			keyActions(
					locateElement(Locator_Xpath,
							"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"),
					Keys.ENTER);
			keyActions(locateElement(Locator_Xpath, "//input[@id=\"toAnotherCity1\"]"), Keys.ESCAPE);
		} else {
			// from
			click(locateElement(Locator_Xpath, "//input[@id=\"fromCity\"]/parent::label"));
			type(locateElement(Locator_Xpath,
					"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"), jsonData().getFrom());
			keyActions(
					locateElement(Locator_Xpath,
							"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"),
					Keys.ARROW_DOWN);
			keyActions(
					locateElement(Locator_Xpath,
							"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"),
					Keys.ENTER);

			// to
			
			click(locateElement(Locator_Xpath, "//input[@id=\"toCity\"]/parent::label"));
			type(locateElement(Locator_Xpath,
					"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"), jsonData().getTo());
			keyActions(
					locateElement(Locator_Xpath,
							"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"),
					Keys.ARROW_DOWN);
			keyActions(
					locateElement(Locator_Xpath,
							"//div[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]//input[@type=\"text\"]"),
					Keys.ENTER);
			keyActions(locateElement(Locator_Xpath, "//input[@id=\"toCity\"]"), Keys.ESCAPE);
		}
	}

	@Then("^user select departure and return dates$")
	public void depature_return_date() {
		String tripMode = jsonData().getTripMode();
		String depDate = jsonData().getDepatureDate();
		String retDate = jsonData().getReturnDate();
		String depDate1 = jsonData().getDepatureDate1();
		String depatureDate = depDate.substring(depDate.indexOf("-")+1);
		String returnDate = retDate.substring(retDate.indexOf("-")+1);
		String depatureDate1 = depDate1.substring(depDate1.indexOf("-")+1);
		String[] dDay = depDate.split("-");
		String[] rDay = retDate.split("-");
		String[] dDay1 = depDate1.split("-");
		String depDay = dDay[0];
		String retDay = rDay[0];
		String depDay1 = dDay1[0];
		String[] dDate = depatureDate.split(" ");
		String depMonth = dDate[0];
		String depYear = dDate[1];
		String[] rDate = returnDate.split(" ");
		String retMonth = rDate[0];
		String retYear = rDate[1];
		Boolean condition = false;
		
		System.out.println(depDay+"    "+depMonth+"   "+depYear);
		System.out.println(retDay+"    "+retMonth+"   "+retYear);
		
		switch (tripMode.toLowerCase()) {
		case "oneway":
			click(locateElement(Locator_Xpath, "//input[@id=\"departure\"]/parent::label"));
			a:do 
			{
				for (WebElement element : locateMultiElement(Locator_Xpath, "//div[@class=\"DayPicker-Caption\"]//div")) 
				{
					if (element.getText().equalsIgnoreCase(depatureDate)) 
					{
						List<WebElement> elements = locateMultiElement(Locator_Xpath, "//div[text()='"+depatureDate+"']/parent::div/following-sibling::div[@class=\"DayPicker-Body\"]//div[@class=\"DayPicker-Day\"]//p[@class=\"priceLow todayPrice\"]");
						int[] prices = new int[elements.size()];
						int i=0, lowPrice = 0, a = 2000000000;
						for (WebElement priceEle : elements)
						{
							prices[i] = Integer.parseInt(priceEle.getText());
							if(i==0)
								a = prices[i];
							lowPrice = Math.min(a,prices[i]);
							a = lowPrice;
							i++;
						}
						System.out.println(lowPrice);
						
						
						click(locateElement(Locator_Xpath, "//div[text()='"+depatureDate+"']/parent::div/following-sibling::div[@class=\"DayPicker-Body\"]//div[@class=\"DayPicker-Day\"]//p[@class=\"priceLow todayPrice\" and text()='"+lowPrice+"']"));
						// select day
						condition = true;
						break a;
					}
				}
				click(locateElement(Locator_Xpath, "//div[@class=\"DayPicker-NavBar\"]//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
				click(locateElement(Locator_Xpath, "//div[@class=\"DayPicker-NavBar\"]//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
			} while (!condition);

			break;
		case "roundtrip":
			click(locateElement(Locator_Xpath, "//input[@id=\"departure\"]/parent::label"));
			a:do 
			{
				for (WebElement element : locateMultiElement(Locator_Xpath, "//div[@class=\"DayPicker-Caption\"]/div")) 
				{
					System.out.println("element text"+element.getText());
					if (element.getText().equalsIgnoreCase(depMonth+depYear)) 
					{
						
						click(locateElement(Locator_Xpath, "//div[text()='"+depMonth+"']/parent::div/following-sibling::div[@class=\"DayPicker-Body\"]//div[@class=\"DayPicker-Day\"]//p[text()='"+depDay+"']"));
						condition = true;
						break a;
					}
				}
				click(locateElement(Locator_Xpath, "//div[@class=\"DayPicker-NavBar\"]//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
				click(locateElement(Locator_Xpath, "//div[@class=\"DayPicker-NavBar\"]//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
			} while (!condition);
			click(locateElement(Locator_Xpath, "//input[@id=\"return\"]/parent::label/parent::div"));
			condition = false;
			b:do 
			{
				for (WebElement element : locateMultiElement(Locator_Xpath, "//div[@class=\"DayPicker-Caption\"]/div")) 
				{
					System.out.println("element text"+element.getText());
					System.out.println("element text"+retMonth+retYear);
					if (element.getText().equalsIgnoreCase(retMonth+retYear))
					{
						
						click(locateElement(Locator_Xpath, "//div[text()='"+retMonth+"']/parent::div/following-sibling::div[@class=\"DayPicker-Body\"]//div[@class=\"DayPicker-Day\"]//p[text()='"+retDay+"']"));
						condition = true;
						
						System.out.println(condition);
						
						break b;
					}
				}
				click(locateElement(Locator_Xpath, "//div[@class=\"DayPicker-NavBar\"]//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
				click(locateElement(Locator_Xpath, "//div[@class=\"DayPicker-NavBar\"]//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
			} while (!condition);
		break;
		
		case "multicitytrip":
			click(locateElement(Locator_Xpath, "//input[@id=\"anotherDeparture 0\"]/parent::label"));
			b:do 
			{
				for (WebElement element : locateMultiElement(Locator_Xpath, "//div[@class=\"DayPicker-Caption\"]/div")) 
				{
					System.out.println("element text"+element.getText());
					if (element.getText().equalsIgnoreCase(depatureDate))
					{
						
						click(locateElement(Locator_Xpath, "//div[text()='"+depatureDate+"']/parent::div/following-sibling::div[@class=\"DayPicker-Body\"]//div[@class=\"DayPicker-Day\"]//p[text()='"+depDay+"']"));
						condition = true;
						
						System.out.println(condition);
						
						break b;
					}
				}
				click(locateElement(Locator_Xpath, "//div[@class=\"DayPicker-NavBar\"]//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
				click(locateElement(Locator_Xpath, "//div[@class=\"DayPicker-NavBar\"]//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
			} while (!condition);
			condition = false;
			click(locateElement(Locator_Xpath, "//input[@id=\"anotherDeparture 1\"]/parent::label/parent::div"));
			b:do 
			{
				for (WebElement element : locateMultiElement(Locator_Xpath, "//div[@class=\"DayPicker-Caption\"]/div")) 
				{
					System.out.println("element text"+element.getText());
					if (element.getText().equalsIgnoreCase(depatureDate1))
					{
						
						click(locateElement(Locator_Xpath, "//div[text()='"+depatureDate1+"']/parent::div/following-sibling::div[@class=\"DayPicker-Body\"]//div[@class=\"DayPicker-Day\"]//p[text()='"+depDay1+"']"));
						condition = true;
						
						System.out.println(condition);
						
						break b;
					}
				}
				click(locateElement(Locator_Xpath, "//div[@class=\"DayPicker-NavBar\"]//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
				click(locateElement(Locator_Xpath, "//div[@class=\"DayPicker-NavBar\"]//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
			} while (!condition);
			break;
		default:
			System.out.println("Please select Trip date");
			break;
		}
	}
	@Then("user search for rides$")
	public void search_ride() {
		click(locateElement(Locator_Xpath, "//p[@class=\"makeFlex vrtlCenter \"]/a"));
	}
	@Then("user select cheapest ride and Book$")
	public void book_cheapest_ride() {
		String tripMode = jsonData().getTripMode();
		
		switch (tripMode.toLowerCase()) {
		case "oneway":
			while (locateElement(Locator_Xpath, "//span[text()='Price']/following-sibling::span").getAttribute(Locator_ClassName).equals("up sort-arrow")) {
				click(locateElement(Locator_Xpath, "//span[text()='Price']"));
			}
			click(locateElement(Locator_Xpath, "(//div[@class=\"pull-left make_relative\"]//button)[1]"));
			break;
		case "roundtrip":
			type(locateElement(Locator_Xpath, "//button[@id=\"sorter_btn_onward\"]"), "Low to High");
			click(locateElement(Locator_Xpath, "(//div[@class=\"paddLR15 make_flex append_bottom7\"]/parent::label)[1]"));
			type(locateElement(Locator_Xpath, "//button[@id=\"sorter_btn_return\"]"), "Low to High");
			click(locateElement(Locator_Xpath, "//button[@id=\"sorter_btn_return\"]//following::div[@class=\"paddLR15 make_flex append_bottom7\"][1]"));
			click(locateElement(Locator_Xpath, "//button[text()='Book Now']"));
			break;
		case "multicitytrip":
			while (locateElement(Locator_Xpath, "//span[text()='Price']/following-sibling::span").getAttribute(Locator_ClassName).equals("up sort-arrow")) {
				System.out.println();
				click(locateElement(Locator_Xpath, "//span[text()='Price']"));
			}
			click(locateElement(Locator_Xpath, "(//div[@class=\"pull-left make_relative\"]//button)[1]"));
			break;

		default:
			System.out.println("Please trip mode");
			break;
		}
	}
	@And("user Review the ride$")
	public void review_ride() {
		switchToWindow(1);

	}
}
