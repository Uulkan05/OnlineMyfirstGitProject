package tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragandDrops {
    @Test
    public void test(){
       // WebDriver driver;
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/drag_and_drop");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions a = new Actions (driver);
        WebElement source = driver.findElement(By.cssSelector("#column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        a.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
