$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./features/Assignment2.feature");
formatter.feature({
  "name": "Assignment2",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Register Uk website",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Assignment2"
    },
    {
      "name": "@Scenario1"
    }
  ]
});
formatter.step({
  "name": "user launch the UK website",
  "keyword": "Given "
});
formatter.step({
  "name": "user click Register-UK",
  "keyword": "When "
});
formatter.step({
  "name": "user enter Email ID-UK",
  "keyword": "Then "
});
formatter.step({
  "name": "user enter password-UK",
  "keyword": "Then "
});
formatter.step({
  "name": "user enter confirm password-UK",
  "keyword": "Then "
});
formatter.step({
  "name": "user enter Birthday-UK as \u003cbirth_day\u003e \u003cbirth_month\u003e \u003cbirth_year\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user click Register and create profile-UK",
  "keyword": "Then "
});
formatter.step({
  "name": "user enter firstname-UK as \u003cFirstname\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user enter lastname-UK as \u003cLastname\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user enter Street_house number-UK as \u003cSt_house_number\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user enter city-UK as \u003cCity\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user enter postcode-UK as \u003cPostcode\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user click Add profile-UK",
  "keyword": "And "
});
formatter.step({
  "name": "user enter login Email ID-UK",
  "keyword": "Then "
});
formatter.step({
  "name": "user enter the incorrect password-UK",
  "keyword": "Then "
});
formatter.step({
  "name": "user click Signin button-UK",
  "keyword": "And "
});
formatter.step({
  "name": "user verify the Incorrect password text-UK",
  "keyword": "And "
});
formatter.step({
  "name": "user click Forgot password-UK",
  "keyword": "Then "
});
formatter.step({
  "name": "user enter registered Email ID-UK",
  "keyword": "Then "
});
formatter.step({
  "name": "user click Next-UK",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "birth_day",
        "birth_month",
        "birth_year",
        "Firstname",
        "Lastname",
        "St_house_number",
        "City",
        "Postcode"
      ]
    },
    {
      "cells": [
        "25",
        "07",
        "1998",
        "Matt",
        "Damen",
        "2/35",
        "London",
        "12345"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Register Uk website",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Assignment2"
    },
    {
      "name": "@Scenario1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user launch the UK website",
  "keyword": "Given "
});
formatter.match({
  "location": "UKwebsite.launch_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click Register-UK",
  "keyword": "When "
});
formatter.match({
  "location": "UKwebsite.register()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter Email ID-UK",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter password-UK",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter confirm password-UK",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_confirm_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter Birthday-UK as 25 07 1998",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_birthday(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click Register and create profile-UK",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.create_profile()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter firstname-UK as Matt",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_firstname(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter lastname-UK as Damen",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_lastname(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter Street_house number-UK as 2/35",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_house_number(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter city-UK as London",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_city(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter postcode-UK as 12345",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_postcode(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click Add profile-UK",
  "keyword": "And "
});
formatter.match({
  "location": "UKwebsite.add_profile()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter login Email ID-UK",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_login_emailID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter the incorrect password-UK",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_incorrect_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click Signin button-UK",
  "keyword": "And "
});
formatter.match({
  "location": "UKwebsite.click_signin_button()"
});
formatter.result({
  "error_message": "java.lang.RuntimeException: Unexpected result for screenshot command: null\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getScreenshotAs(RemoteWebDriver.java:300)\r\n\tat wrapper.SeleniumWrapper.takeSnap(SeleniumWrapper.java:499)\r\n\tat wrapper.SeleniumWrapper.click(SeleniumWrapper.java:195)\r\n\tat testStepDefinition.UKwebsite.click_signin_button(UKwebsite.java:101)\r\n\tat ✽.user click Signin button-UK(./features/Assignment2.feature:21)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user verify the Incorrect password text-UK",
  "keyword": "And "
});
formatter.match({
  "location": "UKwebsite.verify_password()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user click Forgot password-UK",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.forgot_password()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user enter registered Email ID-UK",
  "keyword": "Then "
});
formatter.match({
  "location": "UKwebsite.enter_registered_emailID()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user click Next-UK",
  "keyword": "And "
});
formatter.match({
  "location": "UKwebsite.click_next()"
});
formatter.result({
  "status": "skipped"
});
});