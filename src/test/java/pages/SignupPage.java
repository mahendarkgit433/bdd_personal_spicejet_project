package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class SignupPage 
{
	//Properties for locating elements
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> fwait;
	Select select;

	//locators for happy paths testing
	@FindBy(xpath="//div[text()='Signup']/..") @CacheLookup
	private WebElement signup;

	@FindBy(xpath="//option[starts-with(text(),'Select')]/..") @CacheLookup
	private WebElement title_dropdown;

	@FindBy(id="first_name")
	private WebElement first_middle_name;

	@FindBy(id="last_name")
	private WebElement last_name;

	@FindBy(xpath="(//select)[2]")
	private WebElement country_dropdown;

	@FindBy(id="dobDate")
	private WebElement date_of_birth;

	@FindBy(xpath="//button[@aria-label='Previous Month']")
	private WebElement previous_month_button;

	@FindBy(xpath="//select[contains(@class,'year-select')]")
	private WebElement year_dropdown;

	@FindBy(xpath="//select[contains(@class,'month-select')]")
	private WebElement month_dropdown;

	@FindBy(xpath="//div[contains(@aria-label,'month')]")
	private WebElement date_picker_table;

	@FindBy(xpath="//input[@type='tel']")
	private WebElement mobile_number;

	@FindBy(how=How.CSS,using="#email_id") @CacheLookup
	private WebElement emailid;

	@FindBy(id="new-password")
	private WebElement password;

	@FindBy(id="c-password")
	private WebElement confirm_password;

	@FindBy(id="defaultCheck1")
	private WebElement checkbox;

	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitbutton;
	
	//Locators for fuzzy testing
	@FindBy(how=How.XPATH,using="//div[starts-with(text(),'Password length should be min 8')]") @CacheLookup
	private WebElement passwordLengthError;
	//Year of birth should be in between 1925 to 2007 so perform boundary value analysis technique.take positive and negative test data. 
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Please fill all mandatory fields')]") @CacheLookup
	private WebElement mandatoryError;//This error occurs at top while click on signup button with blank or partial blank details.
	//To the above invalid message locator develop methods for interaction in future for negative test pass for invalid details.
	
	//Constructor method to link with step definition and page classes
	public SignupPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> fwait)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.fwait=fwait;
	}
	public void clickOnSignup()
	{
		fwait.until(ExpectedConditions.visibilityOf(signup)).click();
	}
	//method by visible text for select class
	public void title_Select_VisibleText(String text)
	{
		select = new Select(title_dropdown);
		select.selectByVisibleText(text);
	}

	public void fill_first_middle_name(String name)
	{
		first_middle_name.sendKeys(name);
	}

	public void fill_last_name(String name)
	{
		last_name.sendKeys(name);
	}
	//method to select country by visible text
	public void select_Country_VisibleText(String text)
	{
		select = new Select(country_dropdown);
		select.selectByVisibleText(text);
	}
	//method to select month and year via visile text along with date
	public void fill_date_of_birth(String date,String month,String year)
	{
		date_of_birth.click();
		select = new Select(year_dropdown);
		select.selectByVisibleText(year);
		select = new Select(month_dropdown);
		select.selectByVisibleText(month);
		//find date
		List<WebElement> rows=date_picker_table.findElements(By.xpath("child::div"));
		for(WebElement row:rows)
		{
			try
			{
			List<WebElement> col=row.findElements(By.xpath("child::div"));
			for (WebElement dateValue : col) 
			{
				// Check if the date matches the desired date
				if (dateValue.getText().equals(date)) 
				{
					// Click the matching date
					fwait.until(ExpectedConditions.elementToBeClickable(dateValue)).click();
					break;
				}
			}
			}
			catch(Exception ex)
			{
				fwait.until(ExpectedConditions.stalenessOf(row));
			}
		}
	}

	public void fill_mobile_number(String num)
	{
		fwait.until(ExpectedConditions.visibilityOf(mobile_number)).sendKeys(num);
		mobile_number.sendKeys(Keys.ENTER);
	}

	public void fill_email_id(String eid)
	{
		driver.executeScript("arguments[0].scrollIntoView();",emailid);
		driver.executeScript("arguments[0].value='"+eid+"';",emailid);
	}

	public void fill_password(String pwd)
	{
		fwait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pwd);
	}

	public void fill_confirm_password(String pwd)
	{
		fwait.until(ExpectedConditions.visibilityOf(confirm_password)).sendKeys(pwd);
	}

	public void clickOnCheckbox()
	{
		driver.executeScript("arguments[0].click();",checkbox);
	}

	public void clickOnSubmitButton()
	{
		driver.executeScript("arguments[0].click();",submitbutton);
	}
}
