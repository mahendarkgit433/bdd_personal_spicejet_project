package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;

public class LoginPage 
{
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> fwait;

	//Locators to conduct happy paths testing
	@FindBy(how=How.XPATH,using="//div[text()='Login']") @CacheLookup
	private WebElement login_button;

	@FindBy(xpath="//div[text()='Mobile Number']")
	private WebElement mobile_radio;
	
	@FindBy(xpath="//div[text()='Email']")
	private WebElement email_radio;
	
	@FindBy(xpath="//input[contains(@data-testid,'mobileno')]")
	private WebElement mobile_number_or_emailid;

	@FindBy(xpath="//input[@type='password']")
	private WebElement password;

	@FindBy(xpath="//div[@data-testid='login-cta']")
	private WebElement login;
	
	//Locators to conduct fuzzy testing.
	@FindBy(xpath="//div[text()='Please enter a valid mobile number']")
	private WebElement mobileNumberErrorMessege;
	//Check mobile number criteria should be 10.not less than or greater than 10 check with invalid data.
	
	@FindBy(xpath="//div[text()='Please enter a valid email address']")
	private WebElement emailIdErrorMessege;
	
	@FindBy(xpath="//div[text()='Please enter a valid password']")
	private WebElement passwordErrorMessege;
	//To the above invalid message locator develop methods for interaction in future for negative test pass for invalid details
	
	//When we try to login invalid mobile/email with invalid password we get below error
	@FindBy(xpath="//div[text()='Invalid Username/Password']")
	private WebElement invalidUserNamePasswordmessege;
	
	public LoginPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> fwait)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
		this.fwait=fwait;
	}

	public void click_login()
	{
		fwait.until(ExpectedConditions.visibilityOf(login_button)).click();
	}

	public void fill_mobile_number_or_emailid(String mbnloremailid,String selectionType)
	{
		if(selectionType.equalsIgnoreCase("mobile"))
		{
		fwait.until(ExpectedConditions.visibilityOf(mobile_radio)).click();		
		fwait.until(ExpectedConditions.visibilityOf(mobile_number_or_emailid)).sendKeys(mbnloremailid);
		}
		else if(selectionType.equalsIgnoreCase("email"))
		{
		fwait.until(ExpectedConditions.visibilityOf(email_radio)).click();
		fwait.until(ExpectedConditions.visibilityOf(mobile_number_or_emailid)).sendKeys(mbnloremailid);
		}
		else
		{
			Reporter.log("Invalid selection type",true);
		}
	}

	public void fill_password(String pwd)
	{
		fwait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pwd);
	}

	public void click_login_button()
	{
		fwait.until(ExpectedConditions.visibilityOf(login)).click();
	}
}
