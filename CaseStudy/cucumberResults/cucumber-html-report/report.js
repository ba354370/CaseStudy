$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./features/Assignment1.feature");
formatter.feature({
  "name": "Assignment1",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Click and print selectable items",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Assignment1"
    },
    {
      "name": "@Scenario1"
    }
  ]
});
formatter.step({
  "name": "user launch the url1",
  "keyword": "Given "
});
formatter.step({
  "name": "Verify Selectables title name is \u003ctitle\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "user click and print item name",
  "keyword": "Then "
});
formatter.step({
  "name": "user close the Browser1",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "title"
      ]
    },
    {
      "cells": [
        "Selectable"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Click and print selectable items",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Assignment1"
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
  "name": "user launch the url1",
  "keyword": "Given "
});
formatter.match({
  "location": "Scenario1.launch_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Selectables title name is Selectable",
  "keyword": "When "
});
formatter.match({
  "location": "Scenario1.verify_content(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click and print item name",
  "keyword": "Then "
});
formatter.match({
  "location": "Scenario1.click_print_item()"
});
formatter.result({
  "error_message": "java.lang.RuntimeException: Unexpected result for screenshot command: null\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getScreenshotAs(RemoteWebDriver.java:300)\r\n\tat wrapper.SeleniumWrapper.takeSnap(SeleniumWrapper.java:431)\r\n\tat wrapper.SeleniumWrapper.getText(SeleniumWrapper.java:187)\r\n\tat testStepDefinition.Scenario1.click_print_item(Scenario1.java:40)\r\n\tat ✽.user click and print item name(./features/Assignment1.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user close the Browser1",
  "keyword": "And "
});
formatter.match({
  "location": "Scenario1.close_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "name": "Fill the contact form",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Assignment1"
    },
    {
      "name": "@Scenario2"
    }
  ]
});
formatter.step({
  "name": "user launch the url2",
  "keyword": "Given "
});
formatter.step({
  "name": "verify Contact form title is \u003ctitle\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "user enters firstname as \u003cfirstname\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user enters lastname as \u003clastname\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user enters country as \u003ccountry\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user verify links with partial text \u003clinktext\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user enters subject as \u003csubject\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user clicks on submit",
  "keyword": "Then "
});
formatter.step({
  "name": "user close the Browser2",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "title",
        "firstname",
        "lastname",
        "country",
        "subject",
        "linktext"
      ]
    },
    {
      "cells": [
        "HTML contact form",
        "Bala",
        "Vignesh",
        "India",
        "Hello World!",
        "Google"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Fill the contact form",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Assignment1"
    },
    {
      "name": "@Scenario2"
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
  "name": "user launch the url2",
  "keyword": "Given "
});
formatter.match({
  "location": "Scenario2.launch_url()"
});
