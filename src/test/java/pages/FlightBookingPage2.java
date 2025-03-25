package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class FlightBookingPage2 //After Clicking on search flight button in home page we get this page
{
	   RemoteWebDriver driver;
	   FluentWait<RemoteWebDriver> fwait;
	  //After successfully searching flight button in home page click we have passengers, Add-ons, payment details as sub modules.
	   
		@FindBy(xpath="//div[text()='All flights']")
		private WebElement allflights;
		
		//indexing is used in xpath because in that page direct flight radio button may show n number of direct flights leads to show have n number of elements under flight number in ui.	
		@FindBy(xpath="(//div[text()='Direct'])[1]")
	    private WebElement directFlight;	
		
		@FindBy(xpath="//div[@data-testid='lowfare-carousel']/div")
		private WebElement flightDateList;//in setter method we have to iterate using this elements from previous day to next day
		
		@FindBy(xpath="(//*[local-name()='svg'])[last()-1]")
		private WebElement clickCheckBox;
		
		@FindBy(xpath="//div[text()='Continue']")
		private WebElement clickContinuebtn;
		
		//The above clickCheckBox and clickContinuebtn will appear after clicking search flight button in home page only for the applicable discount , not everytime
		//For 1 family member no discount , minimum 2 people requried to apply discount , so no need of clickCheckBox and clickContinuebtn
		//because checkBox and continue button will not appear in that case.
		
		public FlightBookingPage2(RemoteWebDriver driver,FluentWait<RemoteWebDriver> fwait)
		{
			PageFactory.initElements(driver,this);
			this.driver=driver;
			this.fwait=fwait;
		}
		//check that page url is changed using getUrl method
}
