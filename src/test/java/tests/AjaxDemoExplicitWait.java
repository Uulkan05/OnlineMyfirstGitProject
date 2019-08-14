package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AjaxDemoExplicitWait {
    WebDriver driver;

 @Test
    public void setUp() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.itgeared.com/articles/1506-how-to-display-image-spinner-ajax-request/");
        driver.findElement(By.xpath("//a[@href='/demo/1506-ajax-loading.html']")).click();
        Thread.sleep(5);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String message ="Process completed! This response has been loaded via the Ajax request" +
                "directly from the web server, without reoading this page.";

        try {
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/a[2]")).click();

        }catch (Exception e){
            e.fillInStackTrace();
        }
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#results")));
System.out.println(driver.findElement(By.id("results")).getText());

        driver.quit();



    }
}
