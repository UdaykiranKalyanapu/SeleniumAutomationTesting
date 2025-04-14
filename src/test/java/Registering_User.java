import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.Registration_user_PO;
import resource.Utility;
import resource.base;

import java.io.IOException;

public class Registering_User {

    WebDriver driver;
    String org_name="";
    base bs = new base();
    @Parameters("browser")
    @Test(priority = 1)
    @Given("I am in registration page")
    public void I_am_in_registration_page(String browser) throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver = bs.initializeDriver(browser);
        driver.get("http://localhost:3000/");
        driver.manage().window().maximize();


    }

    @Test(priority = 2)
    @When("I enter valid required details")
    public void user_enters_Payment_credentials() throws InterruptedException {


        Registration_user_PO REG = new Registration_user_PO(driver);
        REG.getNav_bar().click();
        REG.getLoginField().click();
        REG.getCreateBTN().click();
        REG.getfirstName().click();
        REG.getfirstName().sendKeys("meenakshi");
        REG.getLastName().click();
        REG.getLastName().sendKeys("R");
        REG.getEmailAdd().click();
        REG.getEmailAdd().sendKeys("meenakshir125@gmail.com");
        REG.getMobile().click();
        REG.getMobile().sendKeys("1234509125");
        REG.getpassword().sendKeys("123412341234");

        REG.getPassword_repeat().sendKeys("123412341234");
        /*driver.findElement(By.id("navbarSupportedContent")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.linkText("Create an account")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("meenakshi");
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("R");
        driver.findElement(By.id("emailAddress")).click();
        driver.findElement(By.id("emailAddress")).sendKeys("meenakshir123@gmail.com");
        driver.findElement(By.cssSelector(".form-outline:nth-child(4) > .form-label")).click();
        driver.findElement(By.id("mobileNumber")).sendKeys("1234509876");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("123412341234");
        driver.findElement(By.id("password_repeat")).click();
        driver.findElement(By.id("password_repeat")).sendKeys("123412341234");

        assertThat(driver.findElement(By.cssSelector(".lead")).getText(), is("User Sign in"));

*/

    }
    @Test(priority = 3)
    @And("I click on Register")
    public void i_click_on_register() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Registration_user_PO REG = new Registration_user_PO(driver);
        Thread.sleep(3000);
        REG.getRegisterBTN().getLocation();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", REG.getRegisterBTN());
        Thread.sleep(300);
        REG.getRegisterBTN().click();


        // driver.findElement(By.cssSelector(".btn")).click();
    }

    @SuppressWarnings("deprecation")
    @Test(priority = 4)
    @Then("it should redirect the user to login page")
    public void It_Should_redirect_the_user_to_login_page() throws InterruptedException {
        Thread.sleep(3000);


        String Expected_Text2 = driver.findElement(By.cssSelector(".lead")).getText();
        Assert.assertEquals(bs.HomePageMSG, Expected_Text2);
        System.out.println("User is redirected to HomePage");
        // driver.close();
        Utility.captureScreenshot(driver, "Registration");
    }
    @AfterClass
    public void after_class() {
        Utility.captureScreenshot(driver, "Registration");
    }

}