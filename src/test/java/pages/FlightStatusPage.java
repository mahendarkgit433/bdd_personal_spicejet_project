package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class FlightStatusPage
{
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> fwait;
	
	@FindBy(how=How.XPATH,using="//div[starts-with(text(),'Today')]") @CacheLookup
	private WebElement dateClick;
	
	@FindBy(xpath="//div[text()='Yesterday']")
	private WebElement yesterday;
	
	@FindBy(xpath="//div[text()='Today']")
	private WebElement today;
	
	@FindBy(xpath="//div[text()='Tomorrow']")
	private WebElement tomorrow;
	
	//Here Locate From and To Fields
	
	@FindBy(xpath="//div[starts-with(text(),'Flight No')]/following::div[1]//input")
	private WebElement flightNo;
	
	@FindBy(xpath="//div[text()='Search Flights']")
	private WebElement searchFlightsbtn;
	
	public FlightStatusPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> fwait)
	{
		this.driver=driver;
		this.fwait=fwait;
		PageFactory.initElements(driver,this);
	}	
}
