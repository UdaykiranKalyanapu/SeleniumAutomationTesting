package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"},
        features={"C:\\Users\\kaludayk\\OneDrive - Capgemini\\Documents\\A5 hackathob\\FlipKart\\src\\test\\java\\features\\Search.feature"},
        //tags = "@functional_testing",
       glue ={"Navigation_to_booking_page"}

)
public class TestRunner extends AbstractTestNGCucumberTests{
}

