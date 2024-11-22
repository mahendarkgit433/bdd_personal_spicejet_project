package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Shared 
{
    public RemoteWebDriver driver;
    public FluentWait<RemoteWebDriver> wait;
    public Scenario se;
    public int stepno; // Ensure this variable is correctly managed per scenario
    public static int scenariono = 1;

    @Before
    public void beforeScenario(Scenario se)
    { // Before every scenario, taking that scenario information
        this.se = se;
        if (!se.getName().isEmpty()) 
        {
            se.log(se.getName() + " is started");
        } 
        else 
        {
            se.log("Scenario: " + scenariono + " is started");
        }
        stepno = 1; // Reset stepno for the new scenario
    }

    @BeforeStep
    public void beforeStep() 
    { // Before every step
        se.log("step-> " + stepno + " is started");
    }

    @AfterStep
    public void afterStep() 
    { // After every step
        se.log("step-> " + stepno + " is ended");
        stepno++; // Increment step number after each step
    }

    @After
    public void afterScenario()
    { // After every scenario
        if (!se.getName().isEmpty())
        {
            se.log(se.getName() + " is completed with status-> " + se.getStatus().name());
        } 
        else 
        {
            se.log("Scenario: " + scenariono + " is completed with status-> " + se.getStatus().name());
            scenariono++;
        }
    }
}
