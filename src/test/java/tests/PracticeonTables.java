package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PracticeonTables {

    @Test
    public void test(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement table = driver.findElement(By.cssSelector("#product"));
        int rowcount = table.findElements(By.cssSelector("#product tbody tr ")).size();
        int colomncount =table.findElements(By.cssSelector("#product tbody tr th")).size();
        System.out.println(rowcount);
        System.out.println(colomncount);
        String text= driver.findElement(By.cssSelector("div.block.large-row-spacer:nth-child(5) div.left-align fieldset:nth-child(1) table.table-display:nth-child(2) tbody:nth-child(1) tr:nth-child(3) > td:nth-child(1)")).getText();
        System.out.println(text);
        String text2= driver.findElement(By.xpath("//td[contains(text(),'Learn SQL in Practical + Database Testing from Scr')]")).getText();
        System.out.println(text2);
        String text3 = driver.findElement(By.xpath("//tr[3]//td[3]")).getText();
        System.out.println(text3);

    }
}
