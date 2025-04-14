import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.Login_PO;
import resource.Utility;
import resource.base;

import java.io.IOException;

public class Login {

    WebDriver driver;
    String org_name="";
    base bs = new base();
    @Parameters("browser")
    @Test(priority = 1)
    @Given("I am in login page")
    public void I_am_in_registration_page(String browser) throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver = bs.initializeDriver(browser);
        driver.get("http://localhost:3000/");
      /*  driver.manage().window().maximize();

        Registration_user_PO REG = new Registration_user_PO(driver);
        REG.getNav_bar().click();
        REG.getLoginField().click();
        REG.getCreateBTN().click();
        REG.getfirstName().click();
        REG.getfirstName().sendKeys("meenakshi");
        REG.getLastName().click();
        REG.getLastName().sendKeys("R");
        REG.getEmailAdd().click();
        REG.getEmailAdd().sendKeys("meenakshir124@gmail.com");
        REG.getMobile().click();
        REG.getMobile().sendKeys("1234509666");
        REG.getpassword().sendKeys("123412341234");

        REG.getPassword_repeat().sendKeys("123412341234");

        Thread.sleep(3000);
        REG.getRegisterBTN().getLocation();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", REG.getRegisterBTN());
        Thread.sleep(300);
        REG.getRegisterBTN().click();
        */


    }

    @Test(priority = 2)
    @When("I enter the registered email id and valid password")
    public void user_enters_Payment_credentials() throws InterruptedException {

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

    @Test(priority = 4)
    @Then("I should navigate to flight search page")
    public void It_Should_redirect_the_user_to_login_page() throws InterruptedException {
        Thread.sleep(3000);


        String Expected_Text2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/p")).getText();
        Assert.assertEquals(bs.NoBookings, Expected_Text2);
        System.out.println("User is in SearchPage");
        // driver.close();
        Utility.captureScreenshot(driver, "LoginSuccessful");
    }
    @AfterClass
    public void after_class() {
        Utility.captureScreenshot(driver, "LoginSuccessful");
    }

}