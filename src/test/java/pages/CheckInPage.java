package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class CheckInPage 
{
 RemoteWebDriver driver;
 FluentWait<RemoteWebDriver> fwait;
 
 @FindBy(how=How.XPATH,using="//div[starts-with(text(),'PNR')]/following::div[1]//input") @CacheLookup
 private WebElement pnrOrTicketNo;
 
 @FindBy(how=How.XPATH,using="//div[contains(text(),'Email ID')]/following::div[1]//input") @CacheLookup
 private WebElement emailIdOrLastName;
 
 @FindBy(how=How.XPATH,using="//div[text()='Search Booking']") @CacheLookup
 private WebElement searchBookingBtn;
 
  
 public CheckInPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> fwait)
 {
	 this.driver=driver;
	 this.fwait=fwait;
	 PageFactory.initElements(driver,this);
 }
 
 public void enter_pnrOrTicketNo(String pnrOrTicketNo)
 {
	 
 }
 
 public void enter_emailIdOrLastName(String emailIdOrLastName)
 {
	 
 }
 
 public void click_searchBookingBtn()
 {
	 
 }
}
