package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;


    public static WebDriver startChromeBrowser() {

//        String driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
//        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
