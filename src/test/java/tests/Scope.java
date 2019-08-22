package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        //give me the count of links on the page
        // every link starts with //a
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());
WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
//limiting the driver scope
// this will be subdriver of driver
       System.out.println( footerDriver.findElements(By.tagName("a")).size()) ;
      WebElement colomn = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
     System.out.println(colomn.findElements(By.tagName("a")).size());
//click on each link and check if the pages are opening
        for (int i =1; i <colomn.findElements(By.tagName("a")).size();i++ ) {
            String clickOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            colomn.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);
            Thread.sleep(5);
        }
            //to get the title of each tabs
            Set<String> title = driver.getWindowHandles();
            Iterator<String> iter = title.iterator();

        while(iter.hasNext()){
            //has next tells us if the next index is present or not
            //next tells us the index is present
            driver.switchTo().window(iter.next());
            System.out.println(driver.getTitle());
            // getting the title of each tabs of the new windows..
            //Set and Iterator will help us doing it
        }
        driver.quit();
        }

    }
