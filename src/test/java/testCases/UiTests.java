package testCases;

import org.junit.*;

import org.openqa.selenium.*;


import org.openqa.selenium.interactions.Actions;

import pages.landingPage;
import utilities.Base;


import java.io.IOException;

import java.util.logging.Logger;

public class UiTests extends Base {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(UiTests.class));
    public WebDriver driver;
    landingPage landing;

    @Before
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @After
    public void tearDown() {
        closeDriver();
    }

    @Test
    public void logoTest() {
        LOGGER.info("Navigate to Youtube page " + properties.getProperty("url"));
        landing = new landingPage(driver);
        boolean check = landing.logo().isDisplayed();
        LOGGER.info("Verifying logo of YouTube");
        Assert.assertTrue(check);
    }


    @Test
    public void appsLogo() {
        Actions action = new Actions(driver);
        landing = new landingPage(driver);
        LOGGER.info("Navigating to Apps icon");
        action.moveToElement(landing.apps()).build().perform();
        LOGGER.info("Retriving tooltip");
        String value = driver.findElement(By.xpath("//div[@class='style-scope tp-yt-paper-tooltip fade-in-animation']")).getText();
        Assert.assertEquals("YouTube apps", value);
    }


    @Test
    public void dropdown() {
        LOGGER.info("Click on YoutubeApps");
        landing = new landingPage(driver);
        landing.apps().click();
        LOGGER.info("Checking presence of elements ");
        Assert.assertTrue(landing.youtubeTv().isDisplayed());
        Assert.assertTrue(landing.youtubeMusic().isDisplayed());
        Assert.assertTrue(landing.youtubeKids().isDisplayed());
        Assert.assertTrue(landing.youtubeForArtist().isDisplayed());
        Assert.assertTrue(landing.youtubeCreatorAcademy().isDisplayed());


    }
    @Test
    public void searchBar() throws InterruptedException {
        LOGGER.info("Navigating to search bar");
        landing = new landingPage(driver);
       WebElement element =  landing.search();
       element.click();
       LOGGER.info("Entered bata drums");
       element.sendKeys("bata drums");
       element.sendKeys(Keys.RETURN);
       LOGGER.info("This method does auto scrolling ");
       landing.scrollinPage();
       Assert.assertTrue(landing.elementInTheEnd().isDisplayed());

         }
}











