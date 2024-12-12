package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlightBookingPage;
import utilities.WebSiteUtility;

public class FlightBookingGlue 
{
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> fwait;
	WebSiteUtility web;
	Scenario se;
	FlightBookingPage fbp;
	Shared sh;
	
	public FlightBookingGlue(Shared sh)
	{
		this.sh=sh;
		this.se=sh.se;
	}

	@Given("I am on the SpiceJet flight booking page")
	public void i_am_on_the_spice_jet_flight_booking_page() throws Exception 
	{
	    // Write code here that turns the phrase above into concrete actions
		web = new WebSiteUtility();
		this.driver=sh.driver;
		fwait = web.defineWait(driver);
		fbp = new FlightBookingPage(driver,fwait);
		fbp.click_flights();
	}
	
	
	@When("I select Leaving From as {string} and verify Going To does not include {string}")
	public void i_select_leaving_from_as_and_verify_going_to_does_not_include(String string, String string2) 
	{
	
	}

	@When("I select Going To as {string}")
	public void i_select_going_to_as(String string)
	{

	}

	@When("I select Departure Date as {string}")
	public void i_select_departure_date_as(String string)
	{
	  
	}

	@When("I select {string} as the passenger type")
	public void i_select_as_the_passenger_type(String string) 
	{
		Reporter.log("Hi",true);
	}

	@When("I select {string} as the preferred currency")
	public void i_select_as_the_preferred_currency(String string) 
	{
	   
	}

	@When("I enter Adults as {string} and Children as {string}")
	public void i_enter_adults_as_and_children_as(String string, String string2)
	{
	 
	}

	@Then("I should see flight options matching the criteria")
	public void i_should_see_flight_options_matching_the_criteria() 
	{
	  
	}

	@Then("I verify the displayed flights meet the booking details")
	public void i_verify_the_displayed_flights_meet_the_booking_details() 
	{
	 
	}

	@When("I select Departure Date as {string} and  Return date as {string}")
	public void i_select_departure_date_as_and_return_date_as(String string, String string2) 
	{
	 Reporter.log("I am on the SpiceJet flight booking page man good job.",true);
	}




}