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
import resource.Utility;
import resource.base;

import java.io.IOException;

public class LoginSave {

    WebDriver driver;
    String org_name="";
    base bs = new base();
    @Parameters("browser")
    @Test(priority = 1)
    @Given("I am in login page")
    public void I_am_in_login_page(String browser) throws IOException, InterruptedException {
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
    public void I_enter_valid_credentials() throws InterruptedException {

        LoginSave_PO LogS = new LoginSave_PO(driver);
        LogS.getLoginbutton().click();

        Thread.sleep(3000);
        LogS.getUsernameField().click();
        Thread.sleep(3000);
        LogS.getUsernameField().sendKeys("meenakshir124@gmail.com");
        LogS.getPasswordField().click();
        Thread.sleep(3000);
        LogS.getPasswordField().sendKeys("123412341234");
        Thread.sleep(3000);


    }

    @Test(priority = 4)
    @And("I check Remember me box")
    public void I_Check_Rememberme_Box() throws InterruptedException {
        Thread.sleep(3000);

        LoginSave_PO LogS = new LoginSave_PO(driver);
        LogS.getRememberme().click();
        LogS.getLoginbutton2().click();
    }

    @Test(priority = 4)
    @Then("Password must be fetched automatically")
    public void Password_Must_be_fetched_automatically() throws InterruptedException {
        Thread.sleep(3000);
        LoginSave_PO LogS = new LoginSave_PO(driver);
        LogS.getlogout_btn().click();
        LogS.getLoginbutton().click();
        Utility.captureScreenshot(driver, "LoginSave");


        String Expected_Text2 = LogS.getUsernameField().getText();
        Assert.assertEquals(bs.UserField, Expected_Text2);
        System.out.println("User data is not fetched Automatically");
        // driver.close();
       // Utility.captureScreenshot(driver, "LoginSave");
    }
    @AfterClass
    public void after_class() {
        Utility.captureScreenshot(driver, "LoginSave");
    }

}