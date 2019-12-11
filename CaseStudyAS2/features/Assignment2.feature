Feature: Assignment2

@Assignment2 @Scenario1
Scenario Outline: Register Uk website

Given user launch the UK website
When user click Register-UK
Then user enter Email ID-UK
Then user enter password-UK
Then user enter confirm password-UK
Then user enter Birthday-UK as <birth_day> <birth_month> <birth_year>
Then user click Register and create profile-UK
Then user enter firstname-UK as <Firstname>
Then user enter lastname-UK as <Lastname>
Then user enter Street_house number-UK as <St_house_number>
Then user enter city-UK as <City>
Then user enter postcode-UK as <Postcode>
And user click Add profile-UK
Then user enter login Email ID-UK
Then user enter the incorrect password-UK
And user click Signin button-UK
And user verify the Incorrect password text-UK
Then user click Forgot password-UK
Then user enter registered Email ID-UK
And user click Next-UK

Examples:
|birth_day  |birth_month |birth_year |Firstname |Lastname |St_house_number |City     |Postcode |
|25         |07           |1998		 |Matt      |Damen    |2/35            |London   |12345    |

@Assignment2 @Scenario2
Scenario: Register Germany website

Given user launch the Germany website
When user click Register-GE
Then user select gender-GE
Then user enter firstname-GE
Then user enter lastname-GE
Then user enter Email ID-GE
Then user enter password-GE
Then user enter confirm password-GE
Then user enter Birthday-GE
Then user select Country-GE
Then user enter house number-GE
Then user enter postcode-GE
Then user enter Location-GE
And user click Create account-GE
Then user click on login-GE
Then user enter login Email ID-GE
Then user enter the incorrect password-GE
And user click Signin button-GE
And user verify the Incorrect password text-GE
Then user click Forgot password-GE
Then user enter registered Email ID-GE
And user click Next-GE

@Assignment2 @Scenario3
Scenario: Register Spain website

Given user launch the Spain website
When user click Register-SP
Then user select gender-SP
Then user enter firstname-SP
Then user enter lastname-SP
Then user enter surname-SP
Then user enter Email ID-SP
Then user enter password-SP
Then user enter confirm password-SP
Then user enter Birthday-SP
Then user enter phone number-SP
And user click register button-SP
Then user enter login Email ID-SP
Then user enter the incorrect password-SP
And user click Signin button-SP
And user verify the Incorrect password text-SP
Then user click Forgot password-SP
Then user enter registered Email ID-SP
And user click Next-SP

@Test
Scenario: testing

Given read excel
