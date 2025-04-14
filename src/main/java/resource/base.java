package resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver;
    
    public Properties prop;
       public String FlightDetails;
    public String paymentsuccessful;
    public String HomePageMSG;
    public String Payment_Page;
    public String NoBookings;
    public String UserField;
    public String Booking_Page_text;
    public WebDriver initializeDriver(String browserName) throws IOException
    {

        prop= new Properties();
        FileInputStream fis=new FileInputStream("src/main/java/resource/data.properties");

        prop.load(fis);
//        String browserName=prop.getProperty("browser");
        FlightDetails = prop.getProperty("FlightDetails");
        
        paymentsuccessful = prop.getProperty("paymentsuccessful");
        HomePageMSG = prop.getProperty("HomePageMSG");
        Payment_Page = prop.getProperty("Payment_Page");
        NoBookings = prop.getProperty("NoBookings");
        UserField = prop.getProperty("UserField");
        Booking_Page_text = prop.getProperty("Booking_Page_text");
        System.out.println(browserName);

        if(browserName.equals("chrome"))
        {
      	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaludayk\\Downloads\\chromedriver\\chromedriver.exe");
            driver= new ChromeDriver();
            //execute in chrome driver
        }

        else if (browserName.equals("firefox"))
        {
            driver= new FirefoxDriver();
            //firefox code
        }
        else if (browserName.equals("IE"))
        {
        	System.setProperty("webdriver.edge.driver", "C:\\Users\\kaludayk\\Downloads\\chromedriver\\msedgedriver.exe");
        	driver = new EdgeDriver();
//	IE code
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;


    }
}