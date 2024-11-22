package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/resources/features/flightbooking.feature", 
glue ={"gluecode"}, 
plugin = {"pretty", "html:target/cucumber.html", 
		"json:target/cucumber.json", 
		"junit:target/cucumber.xml",
		"rerun:target/failedtestscenarios.txt"},
dryRun = false,
monochrome = true
		)
public class TestRunner3 extends AbstractTestNGCucumberTests
{
}
