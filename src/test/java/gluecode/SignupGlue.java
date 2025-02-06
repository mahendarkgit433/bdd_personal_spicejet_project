package gluecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;
import utilities.WebSiteUtility;

public class SignupGlue
{
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	WebSiteUtility web;
	Scenario se;
	SignupPage signup;
	Shared sh;

	public SignupGlue(Shared sh)
	{
		this.sh=sh;
		this.se=sh.se;
	}

	@Given("open browser {string}")
	public void open_browser(String bn) throws Exception
	{
		web = new WebSiteUtility();
		sh.driver=web.openBrowser(bn);
		this.driver=sh.driver;
		wait = web.defineWait(driver);
		signup = new SignupPage(driver,wait);
	}

	@When("launch site")
	public void open_url() throws Exception
	{
		web.launchSite(driver);
	}

	@Then("i should see the title contains {string}")
	public void verify_title(String exp_title)
	{
		String act_title=driver.getTitle();
		if(act_title.contains(exp_title))
		{
			Reporter.log("Title Test Passed",true);
			se.log("Title Test Passed");
		}
		else
		{
			Reporter.log("Title Test Failed",true);
			se.log("Title Test Failed");
			Assert.fail();
		}
	}

	@When("click on signup button")
	public void click_on_signup_button() throws Exception
	{
		signup.clickOnSignup();

		// Wait for the new window to open
		Thread.sleep(2000);
		// Get all window handles(Only to validate sign up page displayed or not)
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lhandles =new ArrayList<String>(windowHandles);
		driver.switchTo().window(lhandles.get(1)); // Switch to the signup window 
	}

	@Then("signup page should be displayed")
	public void verify_signup_page()
	{
		String act_title = driver.getTitle();
		if (act_title.contains("SpiceClub"))
		{
			Reporter.log("Signup Page Test Passed", true);
			se.log("Signup Page Test Passed");
		} 
		else 
		{
			Reporter.log("Signup Page Test Failed " + act_title, true);
			se.log("Signup Page Test Failed " + act_title);
			Assert.fail();
		}
	}

	@When("select title")
	public void select_title() throws Exception
	{
		Thread.sleep(1000);
		signup.title_Select_VisibleText("Mrs");
	}

	@When("enter first and middle name")
	public void enter_first_and_middle_name()
	{
		signup.fill_first_middle_name("Thomas");
	}

	@When("enter last name")
	public void enter_last_name()
	{
		signup.fill_last_name("Jones");
	}

	@When("select country")
	public void select_country()
	{
		signup.select_Country_VisibleText("India");
	}

	@When("enter date of birth")
	public void enter_date_of_birth() throws Exception
	{
		Thread.sleep(1000);
		signup.fill_date_of_birth("24","October","1994");
	}

	@When("enter mobile number")
	public void enter_mobile_number()
	{
		signup.fill_mobile_number("1234567890");
	}

	@When("enter email")
	public void enter_email()
	{
		signup.fill_email_id("thomas@gmail.com");
	}

	@When("enter password")
	public void enter_password()
	{
		signup.fill_password("xyz@123");
	}

	@When("enter confirm password")
	public void enter_confirm_password()
	{
		signup.fill_confirm_password("xyz@123");
	}

	@When("click on checkbox")
	public void click_on_checkbox()
	{
		signup.clickOnCheckbox();
	}

	@Then("click on submit button")
	public void click_on_submit_button()
	{
		signup.clickOnSubmitButton();
	}
	
	@Then("close browser")
	public void close_browser()
	{
		web.closeSite(driver);	
	}
}
