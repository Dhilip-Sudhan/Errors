package runner.servicenow;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( features = "src/test/java/features.servicenow/CreateChange.feature",
                      glue = "stepDefintion.servicenow",
                monochrome = true,
                   publish = true)

public class Runservicenow extends AbstractTestNGCucumberTests {

	
}

/*
dryRun = false,
features = "src/test/java/features.servicenow/CreateChange.feature",
glue = {"stepDefintion.servicenow"},
//glue = {"stepDefintion","hooks"},
monochrome = true
//tags = "@smoke and not @Babu"
*/