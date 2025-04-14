package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.it.Data;

public class Registration_user_PO
{
	public WebDriver driver;
    By Nav_bar = By.id("navbarSupportedContent");
    By Login = By.linkText("Login");
    By CreateBTN = By.linkText("Create an account");
    By firstName = By.id("firstName");
    By LastName = By.id("lastName");
    By EmailAdd = By.id("emailAddress");
    By Mobile = By.id("mobileNumber");
    By password = By.id("password");
    By Password_repeat = By.id("password_repeat");
    By RegisterBTN = By.xpath("/html/body/div/div/section/div/div/div/div/div/div/form/div[7]/button");
    
    
    
    public Registration_user_PO(WebDriver driver)
    {
    	this.driver = driver;
    }
    
    public WebElement getNav_bar()
    {
    	return driver.findElement(Nav_bar);
    }
    
    public WebElement getLoginField()
    {
    	return driver.findElement(Login);
    }
    
    public WebElement getCreateBTN()
    {
    	return driver.findElement(CreateBTN);
    }
    
    public WebElement getfirstName()
    {
    	return driver.findElement(firstName);
    }
    
    public WebElement getLastName()
    {
    	return driver.findElement(LastName);
    }
    public WebElement getEmailAdd()
    {
    	return driver.findElement(EmailAdd);
    }
    public WebElement getMobile()
    {
    	return driver.findElement(Mobile);
    }
    public WebElement getpassword()
    {
    	return driver.findElement(password);
    }
    public WebElement getPassword_repeat()
    {
    	return driver.findElement(Password_repeat);
    }
    public WebElement getRegisterBTN()
    {
        return driver.findElement(RegisterBTN);
    }
    
}