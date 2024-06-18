package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Static Drop-Down
        WebElement StaticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(StaticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        Thread.sleep(5000);
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
//        int i = 1;
//        while (i<5){
//            driver.findElement(By.id("hrefIncAdt")).click();
//            i++;
//        }
        for (int i=1; i<3; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Thread.sleep(2000);
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(2000);

//        Dynamic Drop-Down
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        Thread.sleep(3000);


        //Auto Suggestive DropDown
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement option: options) {
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
        Thread.sleep(3000);

        //Checkbox
        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        Thread.sleep(3000);

//        select radio button
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("its enabled");
            Assert.assertTrue((true));
        } else {
            System.out.println("its enableded");
            Assert.assertTrue(false);
        }
        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
//        Date Select
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
