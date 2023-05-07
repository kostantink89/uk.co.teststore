import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyStorePage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected WebDriver webDriver;
    private static Properties properties;
    private static InputStream input;

    protected HomePage homePage;
    protected LoginPage loginPage;

    protected MyStorePage myStorePage;


    @Before
    public void setup() {
        try {
            input = new FileInputStream("src/main/java/configurations/config.properties");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        properties = new Properties();
        try {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(options);
        } else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--remote-allow-origins=*");
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if (properties.getProperty("browser").equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--remote-allow-origins=*");
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        myStorePage = new MyStorePage(webDriver);


    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        } else {
            System.out.println("WebDriver instance is null, cannot quit");
        }
    }
}
