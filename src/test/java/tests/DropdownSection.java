package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownSection {
WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://spicejet.com"); //URL in the browser
        driver.manage().window().maximize();
    }

    @Test
        public void test1 () throws InterruptedException {
            driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

            driver.findElement(By.xpath("//a[@value='DEL']")).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
//try {
//    driver.findElement(By.cssSelector(".ui-state-default ui-state-highlight ui-state-active")).click();
//}catch(Exception e){
//    e.fillInStackTrace();
//
//        }

            if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {

                System.out.println("its disabled");

                Assert.assertTrue(true);

            } else {

                Assert.assertTrue(false);

            }

            driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

            driver.findElement(By.id("divpaxinfo")).click();

            Thread.sleep(2000L);

            for (int i = 1; i < 5; i++) {

                driver.findElement(By.id("hrefIncAdt")).click();

            }

            driver.findElement(By.id("btnclosepaxoption")).click();

            Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

// driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

            driver.findElement(By.cssSelector("input[value='Search']")).click();
            driver.quit();

//	driver.findElement(By.xpath("//input[@value='Search']")).click();

// driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
        }
    }



//    driver.findElement(By.id("divpaxinfo")).click();
//
//   Thread.sleep(2000L);
//
//   /*int i=1;
//
//while(i<5)
//
//{
//
//driver.findElement(By.id("hrefIncAdt")).click();//4 times
//
//i++;
//
//}*/
//
//   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
//
//for(int i=1;i<5;i++)
//
//    {
//
//        driver.findElement(By.id("hrefIncAdt")).click();
//
//    }
//
//driver.findElement(By.id("btnclosepaxoption")).click();
//
//Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
//
//System.out.println(driver.findElement(By.id("divpaxinfo")).getText(
//    System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
//
//System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
//
//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
//
//System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
//
//if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
//
//    {
//
//        System.out.println("its enabled");
//
//        Assert.assertTrue(true);
//
//    }
//
//else
//
//    {
//
//        Assert.assertTrue(false);
//
//    }

