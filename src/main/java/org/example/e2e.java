package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class e2e {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        Thread.sleep(3000);
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
        {
            System.out.println("its enabled");
            Assert.assertTrue((true));
        } else {
            System.out.println("its enableded");
            Assert.assertTrue(false);
        }

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i=1; i<5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Thread.sleep(2000);
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

        WebElement StaticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(StaticDropdown);
        dropdown.selectByValue("INR");

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        Thread.sleep(5000);

        driver.quit();
    }
}
