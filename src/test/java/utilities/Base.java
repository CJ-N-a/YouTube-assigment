package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties properties;

    public WebDriver initializeDriver() throws IOException {

        properties = new Properties();
        FileInputStream a = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configuration.properties");

        properties.load(a);

        String browserName =  properties.getProperty("browser");


        if (browserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "/Users/sergey/Desktop/SDET/chromedriver");

            driver = new ChromeDriver();


        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}
