package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandlingWindows {
WebDriver driver;

@Test
    public void test () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        Thread.sleep(3);
        WebElement linkHere = driver.findElement(By.xpath(" //a[contains(text(),'Click Here')]"));
        linkHere.click();
        System.out.println("child window");
    Set<String> windows = driver.getWindowHandles();
    // we use set iterator to handle windwos and we put the windows into one variable
    Iterator<String> titles = windows.iterator();
    // here we use Iterator in order to use each window one by one and get the titles
   String parentWindow= titles.next();
   // since window() method accepst string args we assing the title.next() method into String varible
   String childWindow = titles.next();
   // next() method helps us to go back and forth to the windows
   driver.switchTo().window(childWindow);
   System.out.println(driver.getTitle());
   System.out.println("parent window");
   driver.switchTo().window(parentWindow);
   System.out.println(driver.getTitle());
   driver.quit();
    }
}
