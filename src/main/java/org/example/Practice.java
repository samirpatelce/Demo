package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("password@123");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement StaticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(StaticDropdown);
        dropdown.selectByVisibleText("Male");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("06/18/2024");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        String text = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
        System.out.println(text);
    }
}
