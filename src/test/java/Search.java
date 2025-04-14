import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginSave_PO;
import pageObjects.Login_PO;
import pageObjects.Search_PO;
import resource.Utility;
import resource.base;

import java.io.IOException;

public class Search {

    WebDriver driver;
    String org_name="";
    base bs = new base();
    @Parameters("browser")
    @Test(priority = 1)
    @Given("I am in search page")
    public void I_am_in_Search_page(String browser) throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver = bs.initializeDriver(browser);
        driver.get("http://localhost:3000/");
        driver.manage().window().maximize();


        Login_PO Log = new Login_PO(driver);
        Log.getLoginbutton().click();

        Thread.sleep(3000);
        Log.getUsernameField().click();
        Thread.sleep(3000);
        Log.getUsernameField().sendKeys("meenakshir124@gmail.com");
        Log.getPasswordField().click();
        Thread.sleep(3000);
        Log.getPasswordField().sendKeys("123412341234");
        Thread.sleep(3000);
        Log.getLoginbutton2().click();


    }

    @Test(priority = 2)
    @When("I enter origin, destination, flight date and no. of passengers")
    public void I_enter_search_details() throws InterruptedException {
        Search_PO search = new Search_PO(driver);
        search.getOrigin().sendKeys("mumbai");
        Thread.sleep(2000);
        search.getDestination().sendKeys("delhi");
        Thread.sleep(2000);
        search.getDate().sendKeys("17032023");
        Thread.sleep(2000);
        search.getNumberofPassengers().sendKeys("2");
        Thread.sleep(2000);
        search.getSubmitbutton().click();


    }



    @Test(priority = 4)
    @Then("I get the result of flight details")
    public void I_get_the_result_flight_details() throws InterruptedException {
        Thread.sleep(3000);

        Search_PO search = new Search_PO(driver);
        String Expected_Text2 = search.getFlight().getText();
        Assert.assertEquals(bs.FlightDetails, Expected_Text2);
        System.out.println("User was able to search for flights successfully.");
        // driver.close();
        Utility.captureScreenshot(driver, "Search");
    }
    @AfterClass
    public void after_class() {
        Utility.captureScreenshot(driver, "Search");
    }

}