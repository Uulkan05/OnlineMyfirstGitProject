package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest {

   @Test
    public void setUp(){
        WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
     driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
     driver.findElement(By.xpath("//div[@class='display']//form//input")).click();
     System.out.println(driver.switchTo().alert().getText());
     driver.switchTo().alert().accept();// we are accepting the ok button
     driver.quit();
     // pop ups alert accept, dismiss, get text, and sendkeys if we want to edit the message
       // example the message: "Are you sure? yes, or no?

    }
    @Test
    public void handlichCheckbox(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        try {

           // System.out.println(driver.findElement(By.xpath(" //em[contains(text(),'Senior Citizen')]")).isSelected());
            Assert.assertFalse(driver.findElement(By.cssSelector("#ControlGroupSearchView_AvailabilitySearchInputSearchView_SeniorCitizen")).isSelected());
            driver.findElement(By.cssSelector("#ControlGroupSearchView_AvailabilitySearchInputSearchView_SeniorCitizen")).click();// we are clicking on the checkbox
            System.out.println(driver.findElement(By.cssSelector("#ControlGroupSearchView_AvailabilitySearchInputSearchView_SeniorCitizen")).isSelected());// if it returns true it means the cekcbox is selected or if not, it returns false
        }catch (Exception e){
            e.fillInStackTrace();
        }

        //Count the number of checkboxes
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        driver.quit();


    }

    @Test
    public void checkedBoxes () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qaclickacademy.com/practice.php");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#checkBoxOption1")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected(), true);
        System.out.println("Selected");
        Thread.sleep(4);
        if (driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected()){
            driver.findElement(By.cssSelector("#checkBoxOption1")).click();
            Thread.sleep(4);
            System.out.println("Unchecked");
        }else {
            System.out.println("Still checked");
        }

        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

        driver.quit();

        }



    }




