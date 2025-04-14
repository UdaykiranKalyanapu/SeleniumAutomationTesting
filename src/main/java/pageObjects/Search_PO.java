package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.it.Data;

public class Search_PO
{   public WebDriver driver;
    By Origin = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/form/div[1]/input");
    By Destination = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/form/div[2]/input");
    By Date = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/form/div[3]/input");
    By NumberofPassengers = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/form/div[4]/input");
    By Submit = By.xpath("/html/body/div/div/div[2]/div/div[1]/form/button");

    By Flight = By.xpath("/html/body/div/div/div[2]/div/div[2]/table/tbody/tr/td[1]");


    public Search_PO(WebDriver driver)
    {
        this.driver = driver;
    }


    public WebElement getOrigin()
    {
        return driver.findElement(Origin);
    }
    public WebElement getDestination()
    {
        return driver.findElement(Destination);
    }
    public WebElement getDate()
    {
        return driver.findElement(Date);
    }
    public WebElement getNumberofPassengers()
    {
        return driver.findElement(NumberofPassengers);
    }
    public WebElement getSubmitbutton()
    {
        return driver.findElement(Submit);
    }
    public WebElement getFlight()
    {
        return driver.findElement(Flight);
    }
}