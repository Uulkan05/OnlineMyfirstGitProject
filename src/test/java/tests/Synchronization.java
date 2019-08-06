package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.util.concurrent.TimeUnit;

public class Synchronization {
 WebDriver driver;

 @BeforeMethod
 public void setUp(){
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.get ("https://www.alaskaair.com/");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.manage().deleteAllCookies();

 }
 @Test
 public  void test1 () throws InterruptedException {
     driver.findElement(By.cssSelector(".defaultnav-opennav-menu-open")).click();
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.findElement(By.id("navBookHotels")).click();
     WebElement destination = driver.findElement(By.xpath("//input[@placeholder='Where do you need a hotel?']"));
     destination.sendKeys("New York");
     destination.sendKeys(Keys.TAB);
     System.out.println (destination.getText());
     driver.quit();
 }
}
