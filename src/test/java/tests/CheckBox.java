package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckBox {
    @Test
    public  void test() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/practice.php");
        WebElement labl =driver.findElement(By.tagName("fieldset"));
        System.out.println(labl.findElements(By.tagName("label")).size());
        // looking for checkbox3 and click on it
        Thread.sleep(5);
        WebElement checkbox3 = driver.findElement(By.id("checkBoxOption3"));
        checkbox3.click();
        if(checkbox3.isSelected()){
           System.out.println("checkbox3 is selected");
        }else {
            System.out.println("try again");

       }
Select s =new Select (driver.findElement(By.id("dropdown-class-example")));
       s.selectByVisibleText("Option3");
       WebElement n1 = driver.findElement(By.id("name"));
       n1.sendKeys("Option3");
       driver.findElement(By.id("confirmbtn")).click();
        Alert alert = driver.switchTo().alert();
      String alertMessage=  driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        alert.accept();
        driver.quit();

      }






    }

