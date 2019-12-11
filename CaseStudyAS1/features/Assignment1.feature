Feature: Assignment1

@Assignment1 @Scenario1
Scenario Outline: Click and print selectable items

Given user launch the url1
When Verify Selectables title name is <title>
Then user click and print item name
And user close the Browser1

Examples:
		|title		|
		|Selectable	|

@Assignment1 @Scenario2
Scenario Outline: Fill the contact form

Given user launch the url2
When verify Contact form title is <title>
Then user enters firstname as <firstname>
Then user enters lastname as <lastname>
Then user enters country as <country>
Then user verify links with partial text <linktext>
Then user enters subject as <subject>
Then user clicks on submit
And user close the Browser2

Examples:
		|title		         |firstname  |lastname |country |subject      |linktext |
		|HTML contact form   |Bala		 |Vignesh  |India   |Hello World! |Google   |

@Assignment1 @Scenario3
Scenario Outline: Drag and drop the item

Given user launch the url3
When verify Droppable title is <title>
Then user drag and drops the item
And user close the Browser3

Examples:
		|title		|
		|Droppable	|

@Assignment1 @Scenario4
Scenario Outline: Birth date picker

Given user launch the url4
When verify Datepicker title is <title>
Then user selects the birth date as <title>
And user close the Browser4

Examples:
		|title		|birthdate   |
		|Datepicker	|25/02/1995  |

@Assignment1 @Scenario5
Scenario Outline: Select menu

Given user launch the url5
When verify Selectmenu title is <title>
Then user selects the speed as <speed>
Then user selects a file as <file>
Then user selects a number as <number>
Then user selects a title as <titles>
And user close the Browser5

Examples:
		|title		|speed   |file      |number |titles |
		|Selectmenu	|Faster  |jQuery.js |3      |Mr.   |

@Assignment1 @Scenario6
Scenario Outline: Control group

Given user launch the url6
When verify Control group title is <title>
Then user selects the car type as <cartype>
Then user selects a transmission as <transmission>
Then user selects insurance as <insurance>
Then user enters number of cars as <number>
Then user click on Book Now
And user close the Browser6

Examples:
		|title		   |cartype  |transmission  |insurance |number |
		|Controlgroup  |Luxury   |Standard      |yes       |4      |
		
		