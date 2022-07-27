package baseDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MainDriver {
    WebDriver driver = null;
    //under this annotation everything will be executed at first

    @BeforeSuite
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        if (browser.contains("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();

        }
        if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        //WebSite
        driver.get("https://surokkha.gov.bd");
        //Implicitly wait actually tells browser to wait certain amount of time befor thowing "no such element found"
        //this wait for globally
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Now Set up driver for current page
        PageDriver.Object().SetDriver(driver);
    }

    @AfterSuite
    public void tearDown() {
        PageDriver.getCurrentDriver().quit();
    }

}
