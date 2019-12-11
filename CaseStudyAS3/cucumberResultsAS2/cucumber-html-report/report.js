$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./features/Assignment3.feature");
formatter.feature({
  "name": "Assignment3",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Register Uk website",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Assignment3"
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
formatter.step({
  "name": "user launch the MakeMyTrip website",
  "keyword": "Given "
});
formatter.match({
  "location": "makeTrip.launch_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is in home page",
  "keyword": "When "
});
formatter.match({
  "location": "makeTrip.verify_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user select trip mode",
  "keyword": "Then "
});
formatter.match({
  "location": "makeTrip.trip_mode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user Select From and To",
  "keyword": "Then "
});
formatter.match({
  "location": "makeTrip.select_From_To()"
});
formatter.result({
  "status": "passed"
});
});