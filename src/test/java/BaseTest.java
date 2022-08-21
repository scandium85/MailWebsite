import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.UkrNetLoginPage;
import pages.UkrNetMailPage;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    @BeforeTest
    public void profileSetUp(){chromedriver().setup();}

    @BeforeMethod
    public void testSetUp(){
        options.addArguments("disable-infobars");
        options.addArguments("disable-popup-blocking");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://accounts.ukr.net/");
    }

    @AfterMethod
    public void testDown(){driver.quit();}

    public WebDriver getDriver(){return driver;}

    public UkrNetLoginPage getUkrNetHomePage(){
        return new UkrNetLoginPage(driver);
    }

    public UkrNetMailPage getUkrNetMailPage(){return new UkrNetMailPage(driver);}

}
