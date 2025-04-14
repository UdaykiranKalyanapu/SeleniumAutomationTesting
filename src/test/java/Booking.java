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
import pageObjects.Booking_PO;
import pageObjects.LoginSave_PO;
import pageObjects.Login_PO;
import pageObjects.Search_PO;
import resource.Utility;
import resource.base;

import java.io.IOException;

public class Booking{

    WebDriver driver;
    String org_name="";
    base bs = new base();
    @Parameters("browser")
    @Test(priority = 1)
    @Given("I am in flight search page")
    public void I_am_in_Flight_search_Page(String browser) throws IOException, InterruptedException {
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
        Booking_PO BK = new Booking_PO(driver);
        BK.getOrigin().sendKeys("mumbai");
        Thread.sleep(2000);
        BK.getDestination().sendKeys("delhi");
        Thread.sleep(2000);
        BK.getDate().sendKeys("17032023");
        Thread.sleep(2000);
        BK.getNumberofPassengers().sendKeys("2");
        Thread.sleep(2000);
        BK.getSubmitbutton().click();


    }

    @Test(priority = 2)
    @When("I should be able to opt the flight from the list")
    public void I_should_be_able_to_opt_the_Flight_from_the_list() throws InterruptedException {
        Booking_PO BK = new Booking_PO(driver);
        String Expected_Text2 = BK.getFlight().getText();
        Assert.assertEquals(bs.FlightDetails, Expected_Text2);
        System.out.println("User was able to search for flights successfully.");
        BK.getAvailableFlight().click();
        System.out.println("User clicks on a available flight");

        Utility.captureScreenshot(driver, "Search");




    }



    @Test(priority = 4)
    @Then("I should be redirected to booking page")
    public void I_get_the_result_flight_details() throws InterruptedException {
        Thread.sleep(3000);
        Booking_PO BK = new Booking_PO(driver);
        String Expected_Text = BK.getFlightText().getText();

        Assert.assertEquals(bs.Booking_Page_text, Expected_Text);
        System.out.println("User is  navigated to Booking Page");
        Utility.captureScreenshot(driver, "Booking");

    }
    @AfterClass
    public void after_class() {
        Utility.captureScreenshot(driver, "Booking");
    }

}