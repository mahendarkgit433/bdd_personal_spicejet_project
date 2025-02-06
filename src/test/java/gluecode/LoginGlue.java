package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.WebSiteUtility;

public class LoginGlue 
{
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> fwait;
	WebSiteUtility web;
	Scenario se;
	LoginPage lp;
	Shared sh;
	
	public LoginGlue(Shared sh)
	{
		this.sh=sh;
		this.se=sh.se;
	}
	//Background steps are already in sign up feature so code re usability is acheieved here
	@When("click on login button")
	public void login_button() throws Exception
	{
		web = new WebSiteUtility();
		this.driver=sh.driver;
		fwait = web.defineWait(driver);
		lp = new LoginPage(driver,fwait);
		Thread.sleep(2000);
		lp.click_login();
	}
	
	@When("enter either mobile number or email id as {string}")
	public void enter_mobile_number_or_email_id(String mobileoremail)
	{
		String input = mobileoremail.trim();
		//change dynamic values in feature(10th line) step as email/mobile
		lp.fill_mobile_number_or_emailid(input,"email");
		/*
		 String[] input=mobileoremail.split("or");
		input[0]=input[0].trim();
		input[1]=input[1].trim();
		if(input[0].contains("@"))//try to write regular expression here for email
			lp.fill_mobile_number_or_emailid(input[0],"email");
		else
			lp.fill_mobile_number_or_emailid(input[1],"mobile");
			*/
	}
	
	@When("enter login {string}")
	public void enter_password(String pwd)
	{
		lp.fill_password(pwd);
	}
	
	@When("click on submit login button")
	public void click_on_login_button()
	{
		lp.click_login_button();
	}
	
	@Then("login page should be displayed")
	public void verify_login_page()
	{
		String act_title=driver.getTitle();
		if(act_title.contains("Spice"))
		{
			Reporter.log("Login Page Test Passed",true);
			se.log("Login Page Test Passed");
		}
		else
		{
			Reporter.log("Login Page Test Failed",true);
			se.log("Login Page Test Failed");
			Assert.fail();
		}
	}
}
