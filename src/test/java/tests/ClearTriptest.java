package tests;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ClearTriptest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void test1() throws InterruptedException {
        // verifying the home page is open
        WebElement homepage = driver.findElement(By.xpath("//h1[contains(text(),'Search flights')]"));
        System.out.println(homepage.getText());
        if ( homepage.getText().equals("Search flights")){
            System.out.println("The Home Page is open");
        }else{
            System.out.println("Wrong page!");
        }
        // we are looking for one way element and click on it
        driver.findElement(By.id("OneWay")).click();
        Assert.assertTrue( driver.findElement(By.id("OneWay")).isSelected());

// lets find the date element and get clicked on it
try {
    driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight ui-state-active')]")).click();
}catch(Exception e){
    e.getStackTrace();
}

// verifying how many adults were selected
       Select adultBtn = new Select( driver.findElement(By.id("Adults")));
        adultBtn.selectByIndex(5);
            Thread.sleep(5);

            Select childrenBtn = new Select ( driver.findElement(By.id("Childrens")));
    childrenBtn.selectByIndex(2);
Thread.sleep(5);

Select infant = new Select(driver.findElement(By.id("Infants")));
infant.getFirstSelectedOption();

// find the search button and click on it
        driver.findElement(By.id("SearchBtn")).click();
        Thread.sleep(5);
       System.out.println( driver.findElement(By.id("homeErrorMessage")).getText());




        driver.quit();
    }


}

