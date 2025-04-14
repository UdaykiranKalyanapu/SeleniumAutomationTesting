package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.it.Data;

public class Login_PO
{
    public WebDriver driver;
    By login_btn = By.linkText("Login");
    By Username = By.id("username");
    By Password = By.id("password");
    By login_btn2 = By.cssSelector(".btn");



    public Login_PO(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getLoginbutton()
    {
        return driver.findElement(login_btn);
    }

    public WebElement getUsernameField()
    {
        return driver.findElement(Username);
    }

    public WebElement getPasswordField()
    {
        return driver.findElement(Password);
    }

    public WebElement getLoginbutton2()
    {
        return driver.findElement(login_btn2);
    }


}