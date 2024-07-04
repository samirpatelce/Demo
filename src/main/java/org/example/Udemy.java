package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Udemy {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.udemy.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

        String value = "postman";

        typeWithDelay(searchField, value, 500);
    }

    public static void typeWithDelay(WebElement element, String value, int delayInMillis) throws InterruptedException {
        for (char ch : value.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            Thread.sleep(delayInMillis);
        }
    }
}
