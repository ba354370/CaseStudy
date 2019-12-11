package testRunner;


import org.testng.annotations.*;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "./features", 
glue = {"testStepDefinition", "wrapper"},
monochrome = true,
plugin = {"html:cucumberResultsAS2/cucumber-html-report", "json:cucumberResultsAS2/cucumber.json"},
tags="@Assignment2")

public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "scenarios")
    public void runFeature(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
    	testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
	}

    @DataProvider(name = "scenarios")
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}

