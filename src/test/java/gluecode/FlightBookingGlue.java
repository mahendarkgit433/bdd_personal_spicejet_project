package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlightBookingPage1;
import utilities.WebSiteUtility;

public class FlightBookingGlue 
{
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> fwait;
	WebSiteUtility web;
	Scenario se;
	FlightBookingPage1 fbp;
	Shared sh;
	
	public FlightBookingGlue(Shared sh)
	{
		this.sh=sh;
		this.se=sh.se;
	}

	@Given("I am on the SpiceJet flight booking page")
	public void flightBookingLinkClick() throws Exception 
	{
	    // Write code here that turns the phrase above into concrete actions
		web = new WebSiteUtility();
		this.driver=sh.driver;
		fwait = web.defineWait(driver);
		fbp = new FlightBookingPage1(driver,fwait);
		fbp.click_flights();
	}
	
	@When("I select Leaving From as {string} and verify Going To does not include {string}")
	public void method2(String string, String string2) 
	{
		fbp.enterFromCity(string);
		//verify Going To does not include		
	}

	@When("I select Going To as {string}")
	public void method3(String string)
	{
		fbp.enterToCity(string);
	}

	@When("I select Departure Date as {string}")
	public void method4(String string)
	{
	  
	}

	@When("I select {string} as the passenger type")
	public void method5(String string) 
	{
		Reporter.log("Hi",true);
	}

	@When("I select {string} as the preferred currency")
	public void method6(String string) 
	{
	   
	}

	@When("I enter Adults as {string} and Children as {string}")
	public void method7(String string, String string2)
	{
	 
	}

	@Then("I should see flight options matching the criteria")
	public void method8() 
	{
	  
	}

	@Then("I verify the displayed flights meet the booking details")
	public void method9() 
	{
	 
	}

	@When("I select Departure Date as {string} and  Return date as {string}")
	public void method10(String string, String string2) 
	{
	 Reporter.log("I am on the SpiceJet flight booking page man good job.",true);
	}
}