package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class landingPage {
    public WebDriver driver;

    //locators
    By youtubeLogo = By.xpath("//a[@title='YouTube Home']")  ;
    By appsBox = By.xpath("//button[@id='button'and@aria-label='YouTube apps']");
    By tvYoutube = By.xpath("//*[@id='label' and text()='YouTube TV']");
    By musicYoutube = By.xpath("//*[@id='label' and text()='YouTube Music']");
    By kidsYoutube = By.xpath("//*[@id='label' and text()='YouTube Kids']");
    By creatorAcadYotube = By.xpath("//*[@id='label' and text()='Creator Academy']");
    By forArtistYoutube = By.xpath("//*[@id='label' and text()='YouTube for Artists']");
    By searchBar = By.xpath("//input[@id='search']");
    By findElement =By.xpath("//yt-formatted-string[text()='No more results']");


    public landingPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement logo(){
        return driver.findElement(youtubeLogo);
    }
    public WebElement apps(){
        return driver.findElement(appsBox);

    }
    public WebElement youtubeTv(){
        return driver.findElement(tvYoutube);
    }
    public WebElement youtubeMusic(){
        return driver.findElement(musicYoutube);

    }
    public WebElement youtubeKids(){
        return driver.findElement(kidsYoutube);
    }
    public WebElement youtubeCreatorAcademy(){
        return driver.findElement(creatorAcadYotube);

    }
    public WebElement youtubeForArtist(){
        return driver.findElement(forArtistYoutube);

    }
    public WebElement search(){
        return driver.findElement(searchBar);
    }

   public void scrollinPage(){
       JavascriptExecutor js = (JavascriptExecutor)driver;
       long initialLength = (long) js.executeScript("return document.documentElement.scrollHeight");
       while(true){
           js.executeScript("window.scrollTo(0,document.documentElement.scrollHeight)");
           try{
               Thread.sleep(4000);
           }catch(InterruptedException e){
               e.printStackTrace();
           }
           long currentLength = (long) js.executeScript("return document.documentElement.scrollHeight");
           if(initialLength==currentLength){
               break;

           }
           initialLength=currentLength;
       }

   }
   public WebElement elementInTheEnd(){
        return driver.findElement(findElement);
   }

}
