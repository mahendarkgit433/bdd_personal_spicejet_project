package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class FlightBookingPage 
{
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> fwait;
	
	@FindBy(xpath="//div[text()='Flights']")
	private WebElement flights;

	@FindBy(xpath="//div[text()='one way']")
	private WebElement oneway;

	@FindBy(xpath="//div[text()='round trip']")
	private WebElement roundtrip;
	
	@FindBy(xpath="//div[text()='From']/following-sibling::div//input")
	private WebElement from;
	
	@FindBy(xpath="//div[text()='To']/following-sibling::div//input")
	private WebElement to;

	@FindBy(xpath="//div[text()='Departure Date']")
	private WebElement depart;

	@FindBy(xpath="//div[text()='Return Date']")
	private WebElement return_date;
	
	@FindBy(xpath="//div[text()='Passengers']")
	private WebElement passengers;
	
	@FindBy(xpath="//div[text()='Currency']")
	private WebElement currency;
	
	@FindBy(xpath="//div[text()='Family & Friends']")
	private WebElement familyandfriends;

	@FindBy(xpath="//div[text()='Senior Citizen']")
	private WebElement seniorcitizen;
	
	@FindBy(xpath="//div[text()='Unaccompanied Minor']")
	private WebElement unaccompaniedminor;
	
	@FindBy(xpath="//div[text()='Students']")
	private WebElement students;
	
	@FindBy(xpath="//div[text()='Armed Forces']")
	private WebElement armedforces;
	
	@FindBy(xpath="//div[text()='Govt. Employee']")
	private WebElement govtemployee;
	
	@FindBy(xpath="//div[text()='Search Flight']")
	private WebElement searchflight;
	
	@FindBy(xpath="(//*[local-name()='svg'])[last()-1]")
	private WebElement clickCheckBox;
	
	@FindBy(xpath="//div[text()='Continue']")
	private WebElement clickContinuebtn;
	
	public FlightBookingPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> fwait)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
		this.fwait=fwait;
	}
	
	public void click_flights()
	{
		if(flights.isDisplayed())
		fwait.until(ExpectedConditions.visibilityOf(flights)).click();
	}
	public void oneway()
	{
		fwait.until(ExpectedConditions.visibilityOf(oneway)).click();
	}
	
	public void roundtrip()
	{
		fwait.until(ExpectedConditions.visibilityOf(roundtrip)).click();
	}
	
	public void enterFromCity(String city)
	{
		fwait.until(ExpectedConditions.visibilityOf(from)).sendKeys(city);
	}
	
	public void enterToCity(String city)
	{
		fwait.until(ExpectedConditions.visibilityOf(to)).sendKeys(city);
	}
	
	public void departure()
	{
		fwait.until(ExpectedConditions.visibilityOf(from)).click();
		List<WebElement> rows=from.findElements(By.xpath("child::div"));
		rows.get(3).click();
	}
		
	public void return_date()
	{
		fwait.until(ExpectedConditions.visibilityOf(to)).click();
		List<WebElement> rows=to.findElements(By.xpath("child::div"));
		rows.get(3).click();
	}
}
